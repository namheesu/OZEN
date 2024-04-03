package kr.or.ddit.noti.msg.server;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import kr.or.ddit.global.vo.EmpAlramVO;
import kr.or.ddit.mybatis.mappers.EmpAlramMapper;
import kr.or.ddit.mybatis.mappers.EmpMapper;
import kr.or.ddit.noti.msg.server.config.MessageServerAppConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ServerEndpoint(value = "/messageServerEndpoint", configurator = MessageServerAppConfig.class)
public class MessageServerEndpoint {
	
	@Inject
	private EmpAlramMapper dao;

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServerEndpoint.class);

	private static Set<Session> connectedAllUsers = Collections.synchronizedSet(new HashSet<Session>());

	// Spring bean과 연동하기 위해서는 ServerAppConfig를 configurator로 등록해주면 된다.
	/*
	 * @Resource(name="TestService") TestService testService;
	 */

	/**
	 * Handshaking 함수
	 *
	 * @param userSession 사용자 session
	 */
	@OnOpen
	public void handleOpen(Session userSession) {
		connectedAllUsers.add(userSession);
	}

	/**
	 * Message전달 함수
	 *
	 * @param message     메시지
	 * @param userSession 사용자 session
	 * @throws IOException
	 * @throws EncodeException
	 */
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException, EncodeException {
		String username = (String) userSession.getUserProperties().get("username");

		JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
		String connectionType = jsonObject.getString("connectionType");
		
		log.info("usernameee {}", username);
		log.info("jsonObjecttt {}", jsonObject);
		log.info("connertionTypeee {}", connectionType);
		log.info("messageee {}", message);

		if ("firstConnection".equals(connectionType) && username == null) {
			// 맨 처음 접속 시,
			// 사용자의 이름을 가져옴
			username = jsonObject.getString("username");

			LOGGER.info("{} is entered.", username);

			if (username != null) {
				userSession.getUserProperties().put("username", username);

				for (Session session : connectedAllUsers) {
					session.getBasicRemote().sendText(buildJsonUserData(getUsers()));
				}
			}
		} else if ("sanctnAlram".equals(connectionType)) {
			//userVo uservo = testService.saver  // 알림 메시지 저장
			//List<userVo> uservo = testService.selectUserAl();~~  // 일림 받을 사용자 목록을 조회 
			
			String receiver = jsonObject.getString("receiver");
			String messageee = jsonObject.getString("message");
			String fxRqstNo = jsonObject.getString("fxRqstNo");
			
			EmpAlramVO alramVO = dao.selectAlram(receiver);
			
			LOGGER.info("receiverrrSan {}", receiver);
			LOGGER.info("messageeeSan {}", messageee);
			LOGGER.info("fxRqstNooooo {}", fxRqstNo);
			LOGGER.info("alramVOoooo {}", alramVO);
			
			LOGGER.info("messageSantnAlrammm : {} ", message);
			
			// 알림을 실시간으로 받을 사용자가 로그인해 있으면 알림을 발송을 한다.
			for (Session session : connectedAllUsers) {
				LOGGER.info("로그인한 사용자 IDDD : {}",session.getUserPrincipal().getName());
				// 나를 제외한 모든 사용자에게 메시지 전달..
//				if (!userSession.getId().equalsIgnoreCase(session.getId())) {
					session.getBasicRemote().sendText(message);
//				}
			}
		} else if ("msgConnection".equals(connectionType)) {
			
			//userVo uservo = testService.saver  // 알림 메시지 저장
			//List<userVo> uservo = testService.selectUserAl();~~  // 일림 받을 사용자 목록을 조회 
			LOGGER.debug("message : {} ", message);
			
			// 알림을 실시간으로 받을 사용자가 로그인해 있으면 알림을 발송을 한다.
			for (Session session : connectedAllUsers) {
				LOGGER.debug("로그인한 사용자 ID : {}",session.getUserPrincipal().getName());
				// 나를 제외한 모든 사용자에게 메시지 전달..
//				if (!userSession.getId().equalsIgnoreCase(session.getId())) {
					session.getBasicRemote().sendText(message);
//				}
			}
		}
	}

	/**
	 * 연결을 끊기 직전에 호출되는 함수
	 *
	 * @param userSession
	 * @throws IOException
	 * @throws EncodeException
	 */
	// 예외처리 필요!
	@OnClose
	public void handleClose(Session userSession) throws IOException, EncodeException {

		String disconnectedUser = (String) userSession.getUserProperties().get("username");
		connectedAllUsers.remove(userSession);

		if (disconnectedUser != null) {
			Json.createObjectBuilder().add("disconnectedUser", disconnectedUser).build().toString();

			for (Session session : connectedAllUsers) {
				session.getBasicRemote().sendText(
						Json.createObjectBuilder().add("disconnectedUser", disconnectedUser).build().toString());
			}
		}
	}

	/**
	 * 연결되어있는 user정보를 가져오는 함수
	 *
	 * @return user set
	 */
	private Set<String> getUsers() {
		HashSet<String> returnSet = new HashSet<String>();

		for (Session session : connectedAllUsers) {
			if (session.getUserProperties().get("username") != null) {
				returnSet.add(session.getUserProperties().get("username").toString());
			}
		}
		return returnSet;
	}

	/**
	 * 유저 정보가 담긴 Set<String>을 json으로 변환해주는 함수
	 *
	 * @param set
	 * @return jsondata
	 */
	private String buildJsonUserData(Set<String> set) {

		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

		for (String user : set) {
			jsonArrayBuilder.add(user);
		}
		return Json.createObjectBuilder().add("allUsers", jsonArrayBuilder).build().toString();
	}

}
