/**
 * 
 */
function combine(){
	var hp1 = document.getElementById("hp1").value;
	var hp2 = document.getElementById("hp2").value;
	var hp3 = document.getElementById("hp3").value;
	var cstHp = hp1 + "-" + hp2 + "-" + hp3;
	console.log(cstHp);
	document.getElementById("cstHp").value = cstHp;
}

$('#hp1').on('keyup', function() {    
	if(this.value.length == 3) {      
		  $('#hp2').focus()      
}});
$('#hp2').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#hp3').focus()      
}});
$('#hp3').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#rsvt[0].rsvtNo').focus()      
}});
