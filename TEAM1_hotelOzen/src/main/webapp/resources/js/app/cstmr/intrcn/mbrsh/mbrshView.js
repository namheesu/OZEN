/**
 * 
 */

function layerPopUp(mbrGrdCd){
	console.log(mbrGrdCd)
	
	fetch(`${cPath}/mbrsh/${mbrGrdCd}/detail`,{
		method:"get",
		headers:{
			"Accept":"application/json"
		}
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error(`상태코드 ${resp.status}`, {cause:resp});
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
		console.log(jsonObj.mbrsh)
		let detail = jsonObj.mbrsh.couponList
		let trTags = '';
		detail.forEach(d=>{
			if(d.cpnkNm != null){
				trTags += `
					<tr>
						<td>${d.cpnUse}</td>
						<td>${d.cpnkNm}</td>
						<td>${d.cpnPrvCnt}</td>
					</tr>
				`
			}else{
				trTags += `
					<tr>
						<td>${d.cpnUse}</td>
						<td>${d.cpnDscntPrice.toLocaleString()}원 이용권</td>
						<td>${d.cpnPrvCnt}</td>
					</tr>
				`
				
			}
		})
		console.log(trTags)
		mbrshDetail.innerHTML = trTags;
	})
	
	layerPop2.style.display = "block";
	dimmed.style.display = "block";
}

function fncCancel(){
	layerPop1.style.display = "none";
	dimmed.style.display = "none";
}

function fncCancel2(){
	layerPop2.style.display = "none";
	dimmed.style.display = "none";
}

function subLocate(event){
	let mbsGrdCd = event.currentTarget.id;
	console.log(mbsGrdCd)
	if(auth){
		window.location.href=`${cPath}/mbrsh/subscribe/${mbsGrdCd}`
	}else{
		layerPop1.style.display = "block";
		dimmed.style.display = "block";
		
	}
}

