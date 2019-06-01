var app = angular.module('rrgraphs', []);

app.controller("ApartController", function ($scope, $http) {


    $scope.getAparts = function () {
        $http.get('/rrgraphs/').success(function (data, status, headers, config) {


            console.log(data);

            const nameOfButtons = [];
            const listOfParameters = []
            for (i in data) {
                nameOfButtons.push(data[i].nameOfMode);
                listOfParameters.push(data[i].listOfParameters)
            }

            createSpaceForGraphs(nameOfButtons, listOfParameters)


            for (i = 0; i < listOfParameters.length; i++)
                for (j = 0; j < listOfParameters[i].length; j++)
                    renderChart(listOfParameters[i][j][0], listOfParameters[i][j][1], listOfParameters[i][j][0].name);

            //fillTheTable('painting');

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
})
    ;
    return data;

};

const renderChart = function (el1, el2, nameOfGraph) {
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
            dataPoints: getArray(el1.graph)
        },
            {
                type: "line",
                showInLegend: true,
                yValueFormatString: "##.00",
                name: "Октябрь",
                dataPoints: getArray(el2.graph)
            }]
    });
    console.log(nameOfGraph);


    const firstValueStatisticsContainer = document.createElement('div');
    //стили
    firstValueStatisticsContainer.classList.add('firstStatistics');
    firstValueStatisticsContainer.innerHTML = 'Математическое ожидание ' + el1.matWaiting + '  Дисперсия ' + el1.dispersion
        + '  Максимум ' + el1.max + ' Минимум ' + el1.min;
    document.getElementById(nameOfGraph).appendChild(firstValueStatisticsContainer);

    const secondValueStatisticsContainer = document.createElement('div');
    //стили
    secondValueStatisticsContainer.classList.add('secondStatistics');
    secondValueStatisticsContainer.innerHTML = 'Математическое ожидание ' + el2.matWaiting + '  Дисперсия ' + el2.dispersion
        + '  Максимум ' + el2.max + ' Минимум ' + el2.min;
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

const createSpaceForGraphs = function (nameOfButtons, listOfParameters) {

    for (i in nameOfButtons) {

        const buttonContainer = document.createElement('div');

        buttonContainer.id = nameOfButtons[i];
        buttonContainer.innerHTML = nameOfButtons[i] + '';

        document.getElementById('main').appendChild(buttonContainer);


        for (j in listOfParameters[i]) {
            const someDiv = document.createElement('div');
            someDiv.classList.add('chart');
            someDiv.id = listOfParameters[i][j][0].name;
            document.getElementById(nameOfButtons[i]).appendChild(someDiv);
        }

        const tableContainer = document.createElement('div');

        tableContainer.id = 'table' + i;


        document.getElementById(nameOfButtons[i]).appendChild(tableContainer);
        fillTheTable('table' + i, listOfParameters[i])


    }

}


const fillTheTable = function (name, data) {

    var table = document.createElement('TABLE')
    var tableBody = document.createElement('TBODY')
    table.border = '1';
    table.appendChild(tableBody);
    var heading = new Array();

    heading[0] = "Параметр";
    heading[1] = "Дата  пуска";
    heading[2] = "Математическое ожидание";
    heading[3] = "Дисперсия";
    heading[4] = "Максимум";
    heading[5] = "Минимум";

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


    for (i = 0; i < data.length; i++) {


        for (j = 0; j < data[i].length; j++) {
            var tr = document.createElement('TR');
            var td = document.createElement('TD');
            td.appendChild(document.createTextNode(data[i][j].name));
            tr.appendChild(td);

            td = document.createElement('TD');
            if (j == 0) {
                td.appendChild(document.createTextNode('2012-06'));
            }
            else td.appendChild(document.createTextNode('2012-09'));
            tr.appendChild(td);

            td = document.createElement('TD');
            td.appendChild(document.createTextNode(data[i][j].matWaiting));
            tr.appendChild(td);

            td = document.createElement('TD');
            td.appendChild(document.createTextNode(data[i][j].dispersion));
            tr.appendChild(td);

            td = document.createElement('TD');
            td.appendChild(document.createTextNode(data[i][j].max));
            tr.appendChild(td);

            td = document.createElement('TD');
            td.appendChild(document.createTextNode(data[i][j].min));
            tr.appendChild(td);

            tableBody.appendChild(tr);
        }

    }
    document.getElementById(name).appendChild(table);

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

