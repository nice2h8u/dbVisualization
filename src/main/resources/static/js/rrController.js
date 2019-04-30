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
            const names = ["ТРМ1а_2","ТРМ2а_2","ТРМ3а_2","ТРМ4а_2","ТРМ1б_2","ТРМ2б_2","ТРМ1в_2","ТРМ2в_2"
                ,"ТРМ1г_2","ТРМ2г_2","ТРМ1д_2","ТРМ2д_2","ТРМ3б_2","ТРМ3в_2","ТРМ3г_2","ТРМ3д_2"];

            for (i = 0; i < names.length; i++)
                renderChart(objects[i],names[i]);

            fillTheTable('painting');




        }).error(function (data, status, headers, config) {

            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };


});


const getArray = function (ar) {
    data = [];

    ar.graph.forEach(el => {
        data.push({
            x: el.mil,
            y: el.val,
    })
    });
    return data;

};

const renderChart = function (obj,nameOfGraph) {
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
            dataPoints: getArray(obj.el1)
        },
            {
                type: "line",
                showInLegend: true,
                yValueFormatString: "##.00",
                name: "Октябрь",
                dataPoints: getArray(obj.el2)
            }]
    });
    console.log(nameOfGraph);


    const firstValueStatisticsContainer = document.createElement('div');
    //стили
    firstValueStatisticsContainer.classList.add('firstStatistics');
    firstValueStatisticsContainer.innerHTML ='Математическое ожидание '+ obj.el1.matWaiting + '  Дисперсия ' + obj.el1.dispersion
        + '  Максимум ' + obj.el1.max + ' Минимум ' + obj.el1.min;
    document.getElementById(nameOfGraph).appendChild(firstValueStatisticsContainer);

    const secondValueStatisticsContainer = document.createElement('div');
    //стили
    secondValueStatisticsContainer.classList.add('secondStatistics');
    secondValueStatisticsContainer.innerHTML ='Математическое ожидание '+ obj.el2.matWaiting + '  Дисперсия ' + obj.el2.dispersion
        + '  Максимум ' + obj.el2.max + ' Минимум ' + obj.el2.min;
    document.getElementById(nameOfGraph).appendChild(secondValueStatisticsContainer);



   


    //hiders to hide add banners
    const hiderLeftContainer = document.createElement('hiderLeft');
    hiderLeftContainer.classList.add('hiderLeft');
    document.getElementById(nameOfGraph).appendChild(hiderLeftContainer);

    const hiderRightContainer = document.createElement('hiderRight');
    hiderRightContainer.classList.add('hiderRight');
    document.getElementById(nameOfGraph).appendChild(hiderRightContainer);

    chart.render();
};




const fillTheTable = function (name) {

    var table = document.createElement('TABLE')
    var tableBody = document.createElement('TBODY')
    table.border = '15';
    table.appendChild(tableBody);
    var heading = new Array();
    heading[0] = "Название режима"
    heading[1] = "Параметр"
    heading[2] = "Пуск"
    heading[3] = "Математическое ожидание"
    heading[4] = "Дисперсия"
    heading[5] = "Максимум"
    heading[6] = "Минимум"

    //TABLE COLUMNS
    var tr = document.createElement('TR');
    tableBody.appendChild(tr);
    for (i = 0; i < heading.length; i++) {
        var th = document.createElement('TH');
        th.width = '75';
        th.appendChild(document.createTextNode(heading[i]));
        tr.appendChild(th);
    }


    //TABLE ROWS
    for (i = 0; i < 5; i++) {
        var tr = document.createElement('TR');
        for (j = 0; j < 7; j++) {
            var td = document.createElement('TD');
            td.appendChild(document.createTextNode(i+j));
            tr.appendChild(td)
        }
        tableBody.appendChild(tr);
    }
    document.getElementById('painting').appendChild(table);



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

