/**
 * 
 */

const cPath = document.body.dataset.contextPath;

window.initMap = function () {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 33.23170, lng: 126.5037 },
    zoom: 17,
  });

  const malls = {
    C: {name: "호텔오젠", lat: 33.23170, lng: 126.5037 }
    // 다른 마커들을 추가할 수 있습니다.
  };

  for (const key in malls) {
    if (malls.hasOwnProperty(key)) {
      const {name, lat, lng } = malls[key];

      // 커스텀 이미지 생성
      const image = {
        url: '../resources/assets/img/OZEN.png', // 이미지 경로 지정
        size: new google.maps.Size(50, 50), // 이미지 크기 지정
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(15, 30), // 이미지 중앙 하단 지점을 마커의 위치로 설정
      };

      const marker = new google.maps.Marker({
        position: { lat, lng },
        icon: image, // 커스텀 이미지 설정
        map,
      });

      // 마커에 인포윈도우 추가
      const infoWindow = new google.maps.InfoWindow({
        content: `<div><strong>${name}</strong></div>`,
      });

      marker.addListener("click", () => {
        infoWindow.open(map, marker);
      });
    }
  }
};