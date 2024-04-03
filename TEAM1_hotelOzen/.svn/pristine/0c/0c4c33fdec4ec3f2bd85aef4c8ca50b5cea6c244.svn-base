

/** oooooooo
 * 웹 소캣 인스턴스 생성
 */
let webSocket = null;

$(document).ready(function() {

	console.log("msgUrl : ", msgUrl);

	webSocket = connection(msgUrl);

	webSocket.onopen = function() {
		processOpen();
	};
	webSocket.onmessage = function(message) {
		processMessage(message);
	};
	webSocket.onerror = function(message) {
		processError(message);
	};

	/**
	 * 알림 메시지 버튼 클릭
	 */
//	$(document).on('click', '#sendBtn', function() {
//		webSocket.send(JSON.stringify({
//			"connectionType": "msgConnection",
//			"message": textMessage.value
//		}));
//		textMessage.value = "";
//	});

	$(document).on('click', '.fxClick', function() {
		var empRqNo = document.getElementById('empRqNo').value;
		console.log("나와라",empRqNo);
		webSocket.send(JSON.stringify({
			"connectionType": "sanctnAlram",
			"message": "구매 담당자 희방 알림 왔어용..",
			"receiver" : empRqNo
		}));		
		myclick();
		//myclickTwo();

	});
	
});

/** oooooooo
 * 웹 소캣 connection 연결부
 */
function connection(url) {
	var webSocket = null;
	if ('WebSocket' in window) {
		webSocket = new WebSocket(url);
	} else if ('MozWebSocket' in window) {
		webSocket = new MozWebSocket(url);
	} else {
		Console.log('Error: WebSocket is not supported by this browser.');
		return null;
	}
	return webSocket;
}

/** oooooooo
 * 웹 소캣 connection 후 로그인 이벤트
 */
function processOpen() {
	webSocket.send(JSON.stringify({
		"connectionType": "firstConnection",
		"username": userName
	}));
}

/** oooooooo  내용 추가해야함
 * 웹 소캣 server에서 메시지가 넘어왔을때
 */
function processMessage(message) {
	// 서버 메시지 JSON 으로 파싱..
	var jsonData = JSON.parse(message.data);

	console.log("jsonData : ", jsonData);

	/**
	 * 웹 소캣 접속자 전체 목록
	 */
	if (jsonData.allUsers != null) {
		//다른 사용자 접속 시,
		displayUsers(jsonData.allUsers);
	}

	/**
	 * 웹 소캣 로그 아웃 시 사용자 목록 삭제.
	 */
	if (jsonData.disconnectedUser != null) {
		//다른 사용자가 접속을 끊을 때,
		$("#" + jsonData.disconnectedUser).remove();
	} 

	/**
	 * 알림 메시지가 도착 하였을 경우.
	 */
	if (jsonData.connectionType == 'msgConnection') {
		alert("알림이 도착 하였습니다. \n " + jsonData.message);
	}
	
	if(jsonData.connectionType == 'sanctnAlram'){
		$('.sanctnList').append(`
			<div class="list-group-item">
				<a class="notification notification-flush notification-unread" href="#!">
					<div class="notification-body d-flex justify-content-between">
						<p class="mb-1">결재 요청건이 있습니다.</p>
					</div>
					<div class="xTag_delete">
						<span class="xTag" data-feather="x" style="height:20px; width:20px;"></span>
					</div>
				</a>
			</div>
		`);
	}
}

/** oooooooo
 * 전체 사용자 목록 구성...
 */
function displayUsers(userList) {

	$("#users tr:not(:first)").remove();
	for (var i = 0; i < userList.length; i++) {
		if (userName == userList[i]) {
			usrName = userList[i] + "(me!)";
		} else {
			usrName = userList[i];
		}

		$.newTr = $("<tr id=" + userList[i] + "><td>" + usrName + "</td></tr>");
		$("#users").last().append($.newTr);

	}
}

/** oooooooo
 * 에러 발생시...
 */
function processError(message) {
	/* messagesTextArea.value += "error...\n"; */
}

/** oooooooo
 * 페이지를 벗어 날을때 웹소켓 닫기..
 */
window.onbeforeunload = function() {
	webSocket.close();
};



