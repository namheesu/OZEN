const cPath = document.body.dataset.contextPath;

$(document).ready(function() {
    function fetchData() {
        let form = this;
        let url = form.action;
        let method = form.method;
        let data = $(form).serialize();
        let $listBody = $(parkingBody);

        $.ajax({
            url: url,
            method: method,
            data: data,
            dataType: "json",
            success: function(jsonObj) {
                $listBody.empty();

                let dataList = jsonObj.parkingAreaList;
                let divTags = "";

                if (dataList.length > 0) {
                    $.each(dataList, function(index, parking) {
                        if (parking.pakSe == 1) {
                            divTags += `
                                <div class="col-2 text-center">
                                    <div>${parking.pakArea}</div>
                                    <div class="parking-box">
                                        <img src="${cPath}/resources/assets/img/car/blue-car.png">
                                    </div>
                                </div>`;
                        } else {
                            divTags += `
                                <div class="col-2 text-center">
                                    <div>${parking.pakArea}</div>
                                    <div class="parking-box">
                                    </div>
                                </div>`;
                        }
                    });
                } else {
                    divTags = `
                        <div class="col-6 text-center">
                            조회 실패
                        </div>`;
                }

                $listBody.append(divTags);
            },
            error: function(jqXHR, txt, status) {
                console.log(txt, status, jqXHR);
            }
        });
    }

    // 첫 번째 호출
    fetchData();

    // 10초마다 호출
    setInterval(fetchData, 3000);
});
