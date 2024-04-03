/**
 * 
 */

var floorList = document.getElementById('floorList');

// 마우스 올렷을 때 배경 및 글자색 변경
floorList.addEventListener('mouseover', function(event) {
    if (event.target.tagName === 'LI') {
        event.target.style.backgroundColor = 'black';
        event.target.style.color = 'white';
    }
});
// 마우스 벗어났을 때 스타일 재변경
floorList.addEventListener('mouseout', function(event) {
    if (event.target.tagName === 'LI') {
        event.target.style.backgroundColor = '';
        event.target.style.color = '';
    }
});

floorList.addEventListener('click', function(event) {
	
    if (event.target.tagName === 'LI') {
        let floorText = event.target.value;
        console.log("클릭",floorText);
        let allFloors = document.querySelectorAll('div[id^="for"]');
        allFloors.forEach(function(floor) {
            floor.style.display = 'none';
			event.target.style.backgroundColor = 'white';
        });
        
        let targetFloor = document.getElementById(`for-${floorText}`);
        if (targetFloor) {
			console.log("target",targetFloor);
            targetFloor.style.display = 'block';
			event.target.style.backgroundColor = '#ccc';
        }
    }
});