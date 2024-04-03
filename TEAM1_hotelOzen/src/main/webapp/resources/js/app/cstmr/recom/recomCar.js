let recomCar = document.getElementById("recomCar");
let recomSbrs = document.getElementById("recomSbrs");

recomCar.addEventListener('click', function () {
    fetchData("recomCar");
});

recomSbrs.addEventListener('click', function () {
    fetchData("recomSbrs");
});



