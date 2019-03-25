var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {


    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {


            console.log(data);
            $scope.apartsList = data;
            $scope.data1 = [];
            $scope.data2 = [];
            const objects = [];
            data.forEach(([el1, el2]) => objects.push({el1, el2})
            )
            ;
            console.log(objects);


            objects.forEach(({el1, el2}) => {
                el1.forEach(el => {
                    $scope.data1.push({
                        x: el.mil,
                        y: el.val
                    })

                })
                ;
                el2.forEach(el => {
                    $scope.data2.push({
                        x: el.mil,
                        y: el.val
                    })

                })
                ;
            })
            ;


            console.log($scope.data1)

            renderChart($scope.data1, $scope.data2)


        }).error(function (data, status, headers, config) {

            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };


});

function blaba() {

}

const renderChart = function (data1, data2) {
    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        title: {
            text: "ТРМ1а_2 график"
        },
        axisX: {
            includeZero: false,
            suffix: "sec"
        },
        data: [{
            type: "line",
            showInLegend: true,
            yValueFormatString: "##.00mn",
            name: "Июнь",
            dataPoints: data1
        },
            {
                type: "line",
                showInLegend: true,
                yValueFormatString: "##.00mn",
                name: "Октябрь",
                dataPoints: data2
            }]
    });
    chart.render();
}

