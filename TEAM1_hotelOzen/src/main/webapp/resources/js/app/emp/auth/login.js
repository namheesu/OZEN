/**
 * 
 */

const cPath = document.body.dataset.contextPath;

let username = document.querySelector("input[name=username]")
let password = document.querySelector("input[name=password]")

let selectList = document.querySelector("select[name=login]")

selectList.addEventListener("change", function(event){
	let empNo = event.target.value;
	
	console.log(empNo);
	
	username.value = empNo;
	if(empNo == ""){
		username.value = ""
		password.value = ""
		return false;
	}
	fetch(cPath + "/emp/auth/selectPw",{
		method:"post",
		headers:{
			"Content-Type":"application/json",
			"Accept":"application/json"
		},
		body:JSON.stringify({
			"empNo":empNo
		})
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류 발생", {cause:resp});
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
		password.value = jsonObj['password'];
	})
})
