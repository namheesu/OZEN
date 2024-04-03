<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/chatbot.css" rel="stylesheet">


<div class="chatbot_div">
	<a href="#" id="chatbot">
		<img src="${pageContext.request.contextPath}/resources/assets/img/ico_chatbot.png" id="chatbotBtn" style="cursor: pointer;width : 45px;height : 45px;">
	</a>
</div>

<script>
	chatbot.addEventListener("click", ()=>{
		event.preventDefault();
		
		let chatbotUrl = "http://192.168.141.21:5000";
		
		let windowSize = "width=500, height=600";
	
		let chatbotWindow = window.open(chatbotUrl, "chatty", windowSize);
		if(chatbotWindow){
			chatbotWindow.focus();
		}else{
			Swal.fire({
				title:"팝업이 차단되었습니다."
				, text:"팝업 차단을 해제하고 다시 시도해주세요!"
				, icon:"error"
			})
		}
	})
	
</script>