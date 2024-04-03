<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>
	<div>
		<div class="recomCar-header mx-10">
			<h1 class="cstmr-title mx-5">추천</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠 추천</p>
		</div>
	</div>
	<div class="container recom-table text-center mb-5">
		<div class="btn-group btn-group-lg container text-center" role="group"
			aria-label="...">
			<button class="btn btn-dark btn-outline-dark mb-1 text-white"
				id="recomCar" type="button">렌터카추천</button>
			<button class="btn btn-outline-dark mb-1" id="recomCar"
				type="button">부대시설추천</button>
		</div>
	</div>
	   <a href="javascript:inicis()">결제</a>
	
</section>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
IMP.init('imp84350861')
   
function inicis(){
      IMP.request_pay({
          pg : 'html5_inicis',
          pay_method : 'card',
          merchant_uid : 'RSVT_RMT', // 상품번호
          name : 'Ozen Hotel',
          amount : 100,
          buyer_email : 'gims6521@gmail.com',
          buyer_name : 'seungyeon',
          buyer_tel : '010-6568-3252',
          buyer_addr : 'Shinsa-dong, Gangnam-gu, Seo ul',
          buyer_postcode : '123-456'
//           m_redirect_url : '{Mobile only - URL to redirect to after payment approval}' // Example: https://www.my-service.com/payments/complete/mobile
      }, function(resp) {
         console.log(resp)
      });
   }
</script>
</html>