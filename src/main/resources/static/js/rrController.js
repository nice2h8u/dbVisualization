var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {


    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {

            $scope.apartsList = data;
            $scope.data = [];
            for (i = 0; i < data.length; i++) {
                $scope.data.push({
                    x: data[i].mil,
                    y: data[i].val
                })

            }

            $scope.data2 = [];
            for (i = 0; i < data.length; i++) {
                $scope.data2.push({
                    x: data[i].mil,
                    y: data[i].val+10
                })

            }


            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title:{
                    text: "ТРМ1а_2 график"
                },
                axisX :{
                    includeZero: false,
                    suffix: "sec"
                },
                data: [{
                    type: "line",
                    showInLegend: true,
                    yValueFormatString: "##.00mn",
                    name: "Июнь",
                    dataPoints: $scope.data
                },
                {
                    type: "line",
                    showInLegend: true,
                    yValueFormatString: "##.00mn",
                    name: "Октябрь",
                    dataPoints: $scope.data2
                }]
            });
            chart.render();


        }).error(function (data, status, headers, config) {

            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };


});

