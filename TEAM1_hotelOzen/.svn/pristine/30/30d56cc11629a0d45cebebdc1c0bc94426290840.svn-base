/**
 * 
 */

const cPath = document.body.dataset.contextPath;

let section = document.querySelector('section');

let mbsGrdCd = section.classList[0];

let today = new Date();

subDay.innerHTML =  today.toLocaleDateString();
expDay.innerHTML = new Date(today.setDate(today.getDate() + 365)).toLocaleDateString();

let form = document.querySelector("#submitForm");

submitForm.addEventListener("submit", ()=>{
	event.preventDefault();
	let url = form.action;
	let method = form.method;
	
	let formData = new FormData(form);
	
	fetch(url,{
		method:method
		, headers:{
			"Accept":"application/json"				
		},
		body:formData
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류 발생", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
		if(jsonObj['message'].includes("ok")){
			window.location.href=`${cPath}/mbrsh/subDone/${mbsGrdCd}`;
		}else {
			
		}
	});
	return false;
});