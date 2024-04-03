package kr.or.ddit.cstmr.rsvt.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.io.exceptions.IOException;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.global.vo.AttatchRmTypeVO;
import kr.or.ddit.global.vo.CouponIsnVO;
import kr.or.ddit.global.vo.CstmrVO;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomRoomVO;
import kr.or.ddit.global.vo.RoomTypeVO;
import kr.or.ddit.global.vo.RsvtVO;
import kr.or.ddit.global.vo.SetleVO;
import kr.or.ddit.mybatis.mappers.CstmrRsvtMapper;
import kr.or.ddit.mybatis.mappers.MberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CstmrRsvtServiceImpl implements CstmrRsvtService {

	private final CstmrRsvtMapper dao;

	private final MberMapper mdao;
	
	private static String contextPath;
	
	@Override
	public CstmrVO retrieveCstmrAge(String cstNo) {
		CstmrVO cstmr = dao.select(cstNo);
		return cstmr;
	}

	@Override
	public List<RecomRoomVO> retrieveRcRm(Map<String, Object> customerData) {
		List<RecomRoomVO> rcRm = dao.selectRcRm(customerData);
		return rcRm;
	}

	@Override
	public AttatchRmTypeVO retrieveRmt(String rmType) {
		AttatchRmTypeVO attRmt = dao.selectRmt(rmType);
		return attRmt;
	}

	@Override
	public List<RoomTypeVO> retrieveRsvtRmt(RsvtVO rsvtVO) {

		List<RoomTypeVO> rsvtRmt = dao.selectRsvtRmt(rsvtVO);
		
		return rsvtRmt;
	}

	@Override
	public MberVO retrieveMber(String cstNo) {
		return mdao.select(cstNo);
	}

	@Override
	public ServiceResult createNewRsvt(Map<String, Object> rsvtData) {
		
		ServiceResult result = null;
		// 객실 타입 정보
		AttatchRmTypeVO roomType = (AttatchRmTypeVO) rsvtData.get("roomType");
		// 고객 정보
		CstmrVO rsvtCstmr = (CstmrVO) rsvtData.get("rsvtCstmr");
		// 결제 정보
		SetleVO rsvtSetle = (SetleVO) rsvtData.get("setle");
		// 예약 정보
		RsvtVO rsvtVO = (RsvtVO) rsvtData.get("rsvtVO");

		String cpnNo = (String) rsvtData.get("cpnNo");
		
		String cstNo = rsvtCstmr.getCstNo();
		
		contextPath = rsvtData.get("contextPath").toString();
		
		// 비회원일시
		if (cstNo.isEmpty()) {
			// 회원번호 발급
			cstNo = dao.selectNewNberCstNo();

			rsvtCstmr.setCstNo(cstNo);
			
			// 회원정보 저장
			int insertNber = dao.insertNber(rsvtCstmr);
			if (insertNber != 1) {
				throw new RuntimeException();
			} else {
				result = ServiceResult.OK;
			}
		}
		log.info("cstNm@@@@:{}",rsvtCstmr.getCstNm());
		
		// 결제번호 발급
		String setleNo = dao.selectNewSelteNo();
		int amnt = rsvtSetle.getSetleAmnt();
		rsvtSetle.setSetleNo(setleNo);
		rsvtSetle.setCstNo(cstNo);
		// 결제정보 저장
		int insertSetle = dao.insertSetle(rsvtSetle);
		
		CouponIsnVO couponIsnVO = new CouponIsnVO();
		couponIsnVO.setCstNo(cstNo);
		couponIsnVO.setCpnNo(cpnNo);
		log.info("@@@@@@@coupon:{}",couponIsnVO);
		int updateCoupon = dao.updateCouponIsn(couponIsnVO);
		log.info("@@@@@@@updateCoupon:{}",updateCoupon);
		
		// 예약번호 발급
		String rsvtNo = dao.selectNewRsvtNo();
		rsvtVO.setRsvtAmnt(amnt);
		rsvtVO.setRsvtNo(rsvtNo);
		rsvtVO.setCstNo(cstNo);
		rsvtVO.setRsvtSetleNo(setleNo);
	
		// 예약정보 저장
		int insertRsvt = dao.insertRsvt(rsvtVO);

		int insertRsvtDetails;

		String rsvtDetailNo;
		
		for (int i = 0; i < rsvtVO.getRsvtRoomCnt(); i++) {

			// 예약상세 번호 발급
			rsvtDetailNo = dao.selectRsvtDetailNo();
			rsvtVO.getRsvtDetails().get(i).setRsvtDtlNo(rsvtDetailNo);
			rsvtVO.getRsvtDetails().get(i).setRsvtNo(rsvtNo);
			rsvtVO.getRsvtDetails().get(i).setRmtTypeCd(roomType.getRmtTypeCd());
			// 예약상세 정보 저장
			insertRsvtDetails = dao.insertRsvtDetails(rsvtVO.getRsvtDetails().get(i));
			if (insertRsvtDetails != 1) {
				throw new RuntimeException();
			} else {
				result = ServiceResult.OK;
			}
		}
		String qrCodeText = contextPath + "/emp/pms/stay/QRRsvtList?rsvtNo="+rsvtNo;
		String filePath = "D:/qr/"+rsvtNo+".png"; //사진저장위치
		int size = 125;
		String fileType = "png";
		File qrFile = new File(filePath);
		try {
			createQRImage(qrFile, qrCodeText, size, fileType);
		} catch (IOException | WriterException | java.io.IOException e) {
			e.printStackTrace();
		}
		log.info("성공");
		
		try {
			coolSMS(rsvtCstmr,rsvtVO, filePath);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		
		if (insertSetle != 1 || insertRsvt != 1) {
			throw new RuntimeException();
				
		} else {
			result = ServiceResult.OK;
		}

		return result;
	}
	
	private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException, java.io.IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		try {
		    ImageIO.write(image, fileType, qrFile);
		    System.out.println("###############################QR 코드 이미지가 성공적으로 생성되었습니다.");
		} catch (IOException e) {
		    System.err.println("#################################파일 저장 중 오류가 발생했습니다: " + e.getMessage());
		    e.printStackTrace();
		}

	}
	
	private static void coolSMS(CstmrVO cstVO, RsvtVO rsvtVO, String filePath) throws AddressException, MessagingException {
			String cstMail = cstVO.getCstMail();
			String cstNm = cstVO.getCstNm();
			String rsvtNo = rsvtVO.getRsvtNo();
			String rsvtCheckinYmd = rsvtVO.getRsvtCheckinYmd().toString();
			String rsvtCheckoutYmd = rsvtVO.getRsvtCheckoutYmd().toString();
			String roomCnt = rsvtVO.getRsvtRoomCnt().toString();
			String adultCnt = rsvtVO.getRsvtAdultCnt().toString();
			String childCnt = rsvtVO.getRsvtChildCnt().toString();
			
			
			
			String to = cstMail; // 받는 사람의 이메일 주소
	        String from = "raboom2580@naver.com"; // 보내는 사람의 이메일 주소
	        String password = "ta712589!"; // 보내는 사람의 이메일 계정 비밀번호
	        String host = "smtp.naver.com"; 

	        // SMTP 프로토콜 설정
	        Properties props = new Properties();
	        props.setProperty("mail.smtp.host", host);
	        props.setProperty("mail.smtp.port", "587");
	        props.setProperty("mail.smtp.auth", "true");
	        props.setProperty("mail.smtp.starttls.enable", "true");

	        // 보내는 사람 계정 정보 설정
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, password);
	            }
	        });

	        // 메일 내용 작성
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(from));
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	        String subject = "[호텔오젠] %s 님의 예약내역 메일 발송해 드립니다.";
	        String subjectForm = String.format(subject, cstNm);
	        String text = "감사합니다 %s님의 예약내역을 알려드립니다.\n"
	        			+ "예약번호 : %s \n"
	        			+ "예약일 : %s  -  %s \n "
	        			+ "객실 수 : %s \n"
	        			+ "총 인원 수 : 성인 %s명, 어린이 %s명 \n"
	        			+ "";
	        String textForm = String.format(text,cstNm, rsvtNo, rsvtCheckinYmd, rsvtCheckoutYmd, roomCnt, adultCnt, childCnt);
	        msg.setSubject(subjectForm);
	        msg.setText(textForm);
	        msg.setContent("<img src='"+contextPath+"'/resources/assets/img/cstmr/bg_main01.jpg'/><h1>집갈래</h1>", "text/html"); //사진위치

	        // 메일 보내기
	        Transport.send(msg);
	    }

	@Override
	public List<CouponIsnVO> retrieveCoupon(Map<String, Object> parameterMap) {
		return dao.selectCouponIsn(parameterMap);
	}

}
