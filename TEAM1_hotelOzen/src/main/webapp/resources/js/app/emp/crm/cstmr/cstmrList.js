/**
 * 
 */

const baseURI = window.location.href

let form = document.querySelector("#submitForm")

$("#submitForm").on("submit", (event) => {
	event.preventDefault();
	let url = form.action;
	let method = form.method;

	let formData = new FormData(form);
	let jsonData = {};
	formData.forEach((value, key) => {
		jsonData[key] = value;
	});
	console.log(jsonData)
	let listBody = document.querySelector("#listBody");

	fetch(url, {
		method: method,
		headers: {
			"Content-Type": "application/json",
			"Accept": "application/json"
		},
		body: JSON.stringify(jsonData)

	}).then(resp => {
		if (resp.ok) {
			return resp.json();
		} else {
			throw new Error("오류발생", { cause: resp })
		}
	}).then(jsonObj => {
		for (let mber of jsonObj) {
			if(mber.mbrsh[0].mbsGrdCd!=null){
				mberList.add({
					'cstNo':mber['cstNo'],
					'cstNm':mber.cst['cstNm'],
					'mberId':mber['mberId'],
					'mberHp':mber.cst['cstHp'],
					'mberMbrsh':mber.mbrsh[0]['mbsGrdCd'],
					'detail':`<button class="btn btn-outline-info btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop" data-cst-No="${mber['cstNo']}">detail</button>`
				});					
			}else{
				mberList.add({
					'cstNo':mber['cstNo'],
					'cstNm':mber.cst['cstNm'],
					'mberId':mber['mberId'],
					'mberHp':mber.cst['cstHp'],
					'mberMbrsh':'Non-subscriber',
					'detail':`<button class="btn btn-outline-info btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop" data-cst-No="${mber['cstNo']}">detail</button>`
				});									
			}
		}
		//listBody.innerHTML = trTags;
	}).catch(err => {
		console.error(err)
	}).finally(() => {
		var tdList = document.querySelectorAll('td');

        tdList.forEach(function(td) {
            if (td.innerHTML.trim() === '') {
                td.style.display = 'none';
            }
 		});
	})

	return false;

})

function fnCommFetch(url, options, fnResolve) {
	fetch(url, options)
		.then(resp => {
			if (resp.ok) {
				return resp.json()
			} else {
				throw new Error(`상태코드 ${resp.status} 수신`, { cause: resp })
			}
		}).then(fnResolve).catch(err => console.error(err));
}

var fnRetrieveMber = (event) => {
	let mberBtn = (event.relatedTarget);
	let mberCstNo = (mberBtn.dataset.cstNo);

	console.log(mberBtn)
	console.log(mberCstNo)
	console.log(`${baseURI}/${mberCstNo}`)
	
	fnCommFetch(`${baseURI}/${mberCstNo}`, {
		headers: {
			"Accept": "application/json"
		}
	}, (jsonObj) => {
		let mber = jsonObj.mber;
		let mbrshList = jsonObj.mbrshList;
		
		console.log(mbrshList)
		
		console.log(mber);
		
		cstHp.value = mber.cst.cstHp
		cstNm.value = mber.cst.cstNm
		cstMail.value = mber.cst.cstMail
		cstBirth.value = mber.cst.cstBirth
		cstGen.value = mber.cst.cstGen
		
		for (let n in mber) {
			let myInput = document.getElementById(n)
			if (myInput == null) continue
			myInput.value = mber[n];
		}
		
		let usedTable = ''
		
		if(mber.rsvtList[0].rsvtYmd !== null){
			for(let i = 0; i < mber.rsvtList.length; i++){
				usedTable += `
							<tr>
								<td>${i+1}</td>
								<td>${mber.rsvtList[i].rsvtYmd}</td>
								<td>${mber.rsvtList[i].rsvtCheckinYmd  }</td>
								<td>${mber.rsvtList[i].rsvtCheckoutYmd}</td>
							</tr>
				`
			}
		}else{
			usedTable = `
					<tr>
						<td colspan="6">이용 내역이 없습니다.</td>
					</tr>
			`
		}

		RecentlyUsed.innerHTML = (usedTable);
		
		let setleList ='';
		
		if(mbrshList.length > 0){
			for(let i = 0; i < mbrshList.length; i++){
				setleList = `
					<li class="nav-item me-2 me-lg-0">
						<a class="nav-link nav-link-card-details" href="#!"><span class="fas fa-user me-2"></span>${mbrshList[i].mbsGrdCd}&nbsp&nbsp${mbrshList[i].mbsSbscrbYmd}</a>
					</li>
				`
			}
		}else{
			setleList = `
				<li>
					<span>멤버십 가입 내역이 없습니다.</span>
				</li>
			`
		}
		mbrshSetleList.innerHTML = setleList;
	})
}



document.addEventListener("show.bs.modal", fnRetrieveMber);

document.addEventListener("DOMContentLoaded", () => {
	let options = { "valueNames": ["cstNo", "cstNm", "mberId", "mberHp","mberMbrsh", "detail"], "filter":{"key":"mberMbrsh"}, "page": 10, "pagination": true } 
	mberList = new List('cstmrList', options)
	$("#submitForm").submit();
	var listFilter = document.querySelector('[data-list-filter]');
	var key = options.filter.key;
	listFilter.addEventListener("change", function(e){
		console.log("change test")
		var filterValue = listFilter.value;
		console.log(filterValue)
		mberList.filter(function(item){
              if (e.target.value === '') {
                return true;
              }
              return item.values()[key].toLowerCase().includes(e.target.value.toLowerCase());
            });			
		})
	
	})
	



