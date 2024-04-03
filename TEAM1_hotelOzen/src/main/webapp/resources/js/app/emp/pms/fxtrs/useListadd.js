const cPath = document.body.dataset.contextPath;

$(document).ready(function(){
	
	var currentDate = new Date();
    var formattedDate = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1).toString().padStart(2, '0') + '-' + currentDate.getDate().toString().padStart(2, '0');
    $('#ymd').text(formattedDate);

    $("input[name='listingPrivacy']").change(function(){
        var floor = $(this).attr('id');
        console.log(floor)

        let $floorListBody = $("#floorListBody");
        let url = './floorList?floor='+floor;
        
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
                $floorListBody.empty();
                console.log("들어옴!");
                console.log(jsonObj.floorList);
                
                floorList = jsonObj.floorList;
                
                let buttonTags = '';
                let labelTags = '';
                let prevRmtTypeCd = '';
                
                jsonObj.floorList.forEach(floor => {
                    let labelTags = ''; // 라벨 초기화
                
                    // 이전 라벨의 타입과 현재 객실의 타입이 다를 경우에만 라벨을 추가
                    if (floor.rmtTypeCd !== prevRmtTypeCd) {
                        switch (floor.rmtTypeCd) {
                            case "STD":
                                labelTags = `<label class="col-sm-12">스탠다드 더블</label>`;
                                break;
                            case "STT":
                                labelTags = `<label class="col-sm-12">스탠다드 트윈</label>`;
                                break;
                            case "STF":
                                labelTags = `<label class="col-sm-12">스탠다드 패밀리</label>`;
                                break;
                            case "DRD":
                                labelTags = `<label class="col-sm-12">디럭스 더블</label>`;
                                break;
                            case "DRT":
                                labelTags = `<label class="col-sm-12">디럭스 트윈</label>`;
                                break;
                            case "DRF":
                                labelTags = `<label class="col-sm-12">디럭스 패밀리</label>`;
                                break;
                            case "SUD":
                                labelTags = `<label class="col-sm-12">스위트 더블</label>`;
                                break;
                            case "SUT":
                                labelTags = `<label class="col-sm-12">스위트 트윈</label>`;
                                break;
                            case "SUF":
                                labelTags = `<label class="col-sm-12">스위트 패밀리</label>`;
                                break;
                            case "SPA":
                                labelTags = `<label class="col-sm-12">스파</label>`;
                                break;
                            case "OND":
                                labelTags = `<label class="col-sm-12">온돌</label>`;
                                break;
                            case "PTY":
                                labelTags = `<label class="col-sm-12">파티</label>`;
                                break;
                            default:
                                break;
                        }
                
                        $floorListBody.append(labelTags);
                
                        prevRmtTypeCd = floor.rmtTypeCd;
                    }
                
                    let buttonTags = `
                        <button class="btn btn-outline-secondary me-1 mb-1 floorbtn" type="button">${floor.rmNo}</button>
                    `;
                    $floorListBody.append(buttonTags);
                });

                $floorListBody.on('click', '.floorbtn', function() {
                    var roomNo = $(this).text();
                    console.log("roomNo:", roomNo)
                    $("#roomNumber").text(roomNo);
                });
            },
            error: function(jqXHR, txt, status){
                console.log(txt, status, jqXHR);
            }
        });
        return false;
    });

    $('.rmSvcSelectList').change(function() {
	    var fxtrsCd = $(this).val();
	    
	    console.log('fxtrsCd:', fxtrsCd);

		let $fxtrsNmBody = $("#fxtrsNmBody");
        let url = './fxtrsNmList?fxtrsCd='+fxtrsCd;

		$fxtrsNmBody.empty();
        
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
				console.log(jsonObj.fxtrsNmList)
				let fxBtnTags = '';
				
				jsonObj.fxtrsNmList.forEach(fxNmList => {
					fxBtnTags = `
						<button class="btn btn-outline-secondary me-1 mb-1 mx-2 fxNmBtn" 
							type="button" id="${fxNmList.fxCd}" name="${fxNmList.fxtrsClsCd.fxClsNm}">${fxNmList.fxNm}</button>
					`
					$fxtrsNmBody.append(fxBtnTags);
				});
				
				let $fxUseListBody = $("#fxUseListBody");
				let fxUsetrTags = '';
				
				$fxtrsNmBody.on('click', '.fxNmBtn', function() {
				    var fxCd = $(this).attr('id');
				    var fxclsNm = $(this).attr('name');
				    var fxNm = $(this).text();
				
				    console.log("fxCd:", fxCd, "fxclsNm:", fxclsNm, "fxNm:", fxNm);
				
				    // 중복 추가 방지
				    let isAlreadyAdded = false;
				    $fxUseListBody.find('tr').each(function() {
				        if ($(this).find('td:nth-child(3)').text() === fxCd) {
				            isAlreadyAdded = true;
				            return false; 
				        }
				    });
				
				    if (!isAlreadyAdded) {
				        var fxUsetrTags = `
				            <tr class="fxtrsUseList">
				                <td class="fxDelete">
								    <i class="fas fa-times" style="vertical-align: middle;"></i>
								</td>
				                <td id="fxclsNm">${fxclsNm}</td>
				                <td id="fxCd">${fxCd}</td>
				                <td id="fxNm">${fxNm}</td>
				                <td>
				                    <input type="number" id="fxudCnt" class="inpWidth">
				                </td>
				            </tr>
				        `;
				
				        $fxUseListBody.append(fxUsetrTags);
				    }
				});
				
				$(document).on('click', '.fxDelete', function() {
				    $(this).closest('tr').remove(); // 부모 tr 요소를 찾아서 제거합니다.
				});
			},
            error: function(jqXHR, txt, status){
                console.log(txt, status, jqXHR);
            }
        });
        return false;
    });
});

function myclick(){
	
	console.log("제출 누름");

	$('.inpWidth').each(function() {
        if ($(this).val() === '') {
            Swal.fire({
				title:'비품 사용서 제출 실패!',
				text:'비품 사용수량을 입력해주세요',
				icon:"error"
			})
        }
    });

	var fxtrsData = []; 
	
	let fxuseNo =  $('#serviceNumber').text(); //사용일련번호
	let rmNo = $('#roomNumber').text(); // 객실번호
	let empNo = $('#empNm').attr('class'); //작성자번호
	let fxuseYmd = $('#ymd').text(); //작성일
	
	$('.fxtrsUseList').each(function() {
	    let fxclsNm = $(this).find('#fxclsNm').text();
	    let fxCd = $(this).find('#fxCd').text();
	    let fxNm = $(this).find('#fxNm').text();
	    let fxudCnt = $(this).find('#fxudCnt').val();
	
	    var fxItem = {
	        fxclsNm: fxclsNm,
	        fxCd: fxCd,
	        fxNm: fxNm,
	        fxudCnt: fxudCnt,

			fxuseNo: fxuseNo,
			rmNo : rmNo,
			empNo : empNo,
			fxuseYmd: fxuseYmd

	    };
	    console.log(fxItem);
	 	fxtrsData.push(fxItem);
    });
    
	let url = cPath+"/emp/pms/fxtrs/fxtrsUse";

	$.ajax({
		url: url,
		type: "POST",
		contentType: "application/json", // JSON 형식으로 데이터를 전송
  		data: JSON.stringify({"fxtrsData": fxtrsData}), // 데이터를 JSON 문자열로 변환하여 전송
	    success: function(response) {
	        // 요청이 성공한 경우의 처리
	    	Swal.fire({
			    title: '비품 사용서 작성 성공',
			    text: '비품 사용서가 성공적으로 처리되었습니다.',
			    icon: 'success'
			}).then((result) => {
	 			window.location.href = response;
			});
	  	},
	  	error: function(xhr, status, error) {
	     	Swal.fire({
				title:'비품 사용서 제출 실패!',
				text:'비품 사용서 제출을 실패하였습니다.',
				icon:"error"
			});
	  	}
	});
};
