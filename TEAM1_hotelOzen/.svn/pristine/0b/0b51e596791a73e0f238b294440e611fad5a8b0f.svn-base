<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/secsn.css"
rel="stylesheet">

<div class="mypage-detail-title">
	회원 탈퇴
</div>
<form id="checkPwForm" method="post" action="${pageContext.request.contextPath }/myinfo/checkPwd.do">
<div class="myContents">
    <p class="pageGuide tleft">정보를 안전하게 보호하기 위해 비밀번호를 다시 한 번 확인합니다.</p>
    <div class="frmInfo">
        <ul class="intList">
            <li>
                <div class="intWrap"><span class="tit"><label for="userpw">PASSWORD</label>
	                <span class="essential">필수</span>
	                </span>
                </div>
                <div class="intInner">
                    <span class="intArea">
	                    <input type="password" id="currentPwd" name="currentPwd" placeholder="비밀번호를 입력해주세요." style="width:1000px" aria-required="true">
	                    <span class="alertMessage">비밀번호를 입력해주세요.</span>
                    </span>
                </div>
            </li>
        </ul>
    </div>
    <div class="btnArea">
        <button type="submit" class="btnSC btnL secsnBtn">다음</button>
    </div>
   
</div>
</form>