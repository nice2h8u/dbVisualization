var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {


    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {


            console.log(data);
            $scope.apartsList = data;
            const objects = [];
            data.forEach(([el1, el2]) => objects.push({el1, el2})
            )
            ;


            renderChart(getArray(objects[0].el1), getArray(objects[0].el2),"ТРМ1_А2");


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
            label: "blabla"
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
    chart.render();
}

