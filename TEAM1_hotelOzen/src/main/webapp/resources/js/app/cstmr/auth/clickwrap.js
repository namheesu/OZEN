/**
 * 
 */

const cPath = document.body.dataset.contextPath;

let selectAllBtn = document.getElementById('agree');
var checkboxes = document.querySelectorAll('input[type="checkbox"]');

selectAllBtn.addEventListener('click', () => {
    if (confirmAllChecked()) {
        checkboxes.forEach(checkbox => {
            checkbox.checked = false;
        });
    } else {
        checkboxes.forEach(checkbox => {
            checkbox.checked = true;
        });
    }
});

function confirmAllChecked() {
    return Array.from(checkboxes).every(checkbox => checkbox.checked);
}

confirmBtn.addEventListener('click', ()=>{
	if(confirmAllChecked()){
		location.href = cPath + "/auth/join.do";		
	}else{
		Swal.fire({
			title:'필수 항목을 체크해주세요',
			text:'체크되지 않은 필수 항목이 있습니다.',
			icon:'error'
			
		})
		
	}
	
})