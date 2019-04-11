var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {

        accordion();
    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {


            console.log(data);
            $scope.apartsList = data;
            const objects = [];
            data.forEach(([el1, el2]) => objects.push({el1, el2})
            )
            ;


            renderChart(getArray(objects[0].el1), getArray(objects[0].el2),"ТРМ1а_2");
            renderChart(getArray(objects[1].el1), getArray(objects[1].el2),"ТРМ2а_2");
            renderChart(getArray(objects[2].el1), getArray(objects[2].el2),"ТРМ3а_2");
            renderChart(getArray(objects[3].el1), getArray(objects[3].el2),"ТРМ4а_2");
            renderChart(getArray(objects[4].el1), getArray(objects[4].el2),"ТРМ1б_2");

            renderChart(getArray(objects[5].el1), getArray(objects[5].el2),"ТРМ2б_2");
            renderChart(getArray(objects[6].el1), getArray(objects[6].el2),"ТРМ1в_2");
            renderChart(getArray(objects[7].el1), getArray(objects[7].el2),"ТРМ2в_2");
            renderChart(getArray(objects[8].el1), getArray(objects[8].el2),"ТРМ1г_2");
            renderChart(getArray(objects[9].el1), getArray(objects[9].el2),"ТРМ2г_2");
            renderChart(getArray(objects[10].el1), getArray(objects[10].el2),"ТРМ1д_2");
            renderChart(getArray(objects[11].el1), getArray(objects[11].el2),"ТРМ2д_2");
            renderChart(getArray(objects[12].el1), getArray(objects[12].el2),"ТРМ3б_2");
            renderChart(getArray(objects[13].el1), getArray(objects[13].el2),"ТРМ3в_2");
            renderChart(getArray(objects[14].el1), getArray(objects[14].el2),"ТРМ3г_2");
            renderChart(getArray(objects[15].el1), getArray(objects[15].el2),"ТРМ3д_2");
           


        }).error(function (data, status, headers, config) {

            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };


});


const getArray = function (ar) {
    data = [];

    ar.forEach(el => {
        data.push({
            x: el.mil,
            y: el.val,
    })
    });
    return data;

};

const renderChart = function (data1, data2,nameOfGraph) {
    var chart = new CanvasJS.Chart(nameOfGraph, {
        zoomEnabled: true,
        animationEnabled: true,
        title: {
            text: nameOfGraph
        },
        axisX: {
            includeZero: false,
            suffix: "sec"
        },
        data: [{
            type: "line",
            showInLegend: true,
            yValueFormatString: "##.00",
            name: "Июнь",
            dataPoints: data1
        },
            {
                type: "line",
                showInLegend: true,
                yValueFormatString: "##.00",
                name: "Октябрь",
                dataPoints: data2
            }]
    });
    console.log(nameOfGraph);

    const someStatValue = 12;
    const statisticsContainer = document.createElement('div');
    //стили
    statisticsContainer.classList.add('statistics');
    statisticsContainer.innerHTML ='Математическое ожидание '+ someStatValue + '  Дисперсия ' + 42
        + '  Максимум ' + 120 + ' Минимум ' + 20;
    document.getElementById(nameOfGraph).appendChild(statisticsContainer);



    //hiders to hide add banners
    const hiderLeftContainer = document.createElement('hiderLeft');
    hiderLeftContainer.classList.add('hiderLeft');
    document.getElementById(nameOfGraph).appendChild(hiderLeftContainer);

    const hiderRightContainer = document.createElement('hiderRight');
    hiderRightContainer.classList.add('hiderRight');
    document.getElementById(nameOfGraph).appendChild(hiderRightContainer);

    chart.render();
};




const accordion = function () {

    var acc = document.getElementsByClassName("accordion");
    var i;
    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            /* Toggle between adding and removing the "active" class,
            to highlight the button that controls the panel */
            this.classList.toggle("active");

            /* Toggle between hiding and showing the active panel */
            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        });
    }
};

