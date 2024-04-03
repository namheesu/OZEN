/**
 * 
 */
window.initMap = function () {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 33.26048, lng: 126.5018 },
    zoom: 13,
  });
};