
var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {



    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {

            $scope.apartsList = data;
            console.log("All sucess");
        }).error(function (data, status, headers, config) {

            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };




});

