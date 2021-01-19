//Incidence, Mortality Counts by Cancer Site
$(function () {
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/country?country=' + country,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var cancers = new Array();
        var mortality_number = new Array();
        var mortality_number20 = new Array();
        var incidence_number = new Array();
        var incidence_number20 = new Array();
        var mortality_percentage = new Array();
        var incidence_percentage = new Array();
        var prevalence_number = new Array();
        var prevalence_prop = new Array();
        var pie_incidence_map = {};
        var pie_mortality_map = {};
        var scatter = new Array();
        var scatter_list = new Array();
        var pie_incidence_list = new Array();
        var pie_mortality_list = new Array();
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];

        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {
                cancers.push(gene_ex[key]["cancer"]);
                console.log(cancers)
                mortality_number.push(parseInt(gene_ex[key]["death_number"]))
                incidence_number.push(parseInt(gene_ex[key]["new_number"]))
                mortality_percentage.push(Number(gene_ex[key]["death_percent"]))
                incidence_percentage.push(Number(gene_ex[key]["new_percent"]))
                prevalence_number.push(parseInt(gene_ex[key]["prevalence_number"]))
                prevalence_prop.push(Number(gene_ex[key]["prevalence_prop"]))
                pie_incidence_map["name"] = gene_ex[key]["cancer"]
                pie_incidence_map["y"] = Number(gene_ex[key]["new_number"])
                pie_incidence_list.push(pie_incidence_map)
                pie_mortality_map["name"] = gene_ex[key]["cancer"]
                pie_mortality_map["y"] = Number(gene_ex[key]["death_number"])
                pie_mortality_list.push(pie_mortality_map)
                pie_incidence_map = {};
                pie_mortality_map = {};
                scatter.push(Number(gene_ex[key]["new_number"]))
                scatter.push(Number(gene_ex[key]["death_number"]))
                scatter_list.push(scatter)
                scatter = [];
                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["value"] = Number(gene_ex[key]["death_number"])
                map_list.push(map_map);
                map_map = {};
            }

            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2020")) {
                cancers.push(gene_ex[key]["cancer"]);
                console.log(cancers)
                mortality_number20.push(parseInt(gene_ex[key]["death_number"]))
                incidence_number20.push(parseInt(gene_ex[key]["new_number"]))
                // mortality_percentage.push(Number(gene_ex[key]["death_percent"]))
                // incidence_percentage.push(Number(gene_ex[key]["new_percent"]))
                // prevalence_number.push(parseInt(gene_ex[key]["prevalence_number"]))
                // prevalence_prop.push(Number(gene_ex[key]["prevalence_prop"]))
                // pie_incidence_map["name"] = gene_ex[key]["cancer"]
                // pie_incidence_map["y"] = Number(gene_ex[key]["new_number"])
                // pie_incidence_list.push(pie_incidence_map)
                // pie_mortality_map["name"] = gene_ex[key]["cancer"]
                // pie_mortality_map["y"] = Number(gene_ex[key]["death_number"])
                // pie_mortality_list.push(pie_mortality_map)
                // pie_incidence_map = {};
                // pie_mortality_map = {};
                // scatter.push(Number(gene_ex[key]["new_number"]))
                // scatter.push(Number(gene_ex[key]["death_number"]))
                // scatter_list.push(scatter)
                // scatter = [];
                // map_map["code"] = gene_ex[key]["code"]
                // map_map["name"] = gene_ex[key]["name"]
                // map_map["value"] = Number(gene_ex[key]["death_number"])
                // map_list.push(map_map);
                // map_map = {};
            }
        }

        $(function () {

            var bar = $('#bar').highcharts({

                chart: {
                    type: 'column'
                },
                colors:['#bd0026','#253494'],
                credits: {
                    href: 'http://www.example.com'
                },
                title: { text: "Incidence and Mortality Counts " + "in " + decodeURIComponent(country),
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                xAxis: {
                    categories: cancers,
                    lineColor: "#000000",
                    tickColor: '#000000',
                    minorTickColor: "#000000",
                    labels: {
                        rotation: -30,
                        style: {
                            fontSize:'11px',
                            color: '#000000',
                            fontFamily: 'Arial',
                            fontWeight: 'bold',
                        },
                    },
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Counts',
                        style: {
                            color: '#000000',
                            fontSize: '14px',
                            fontWeight: 'bold',
                            fontFamily: 'Arial, sans-serif'
                        }
                    },
                    labels: {
                        style: {
                            fontSize:'12px',
                            color: '#000000',
                            fontFamily: 'Arial',
                            fontWeight: 'bold',
                        },
                    },
                },
                tooltip: {
                    headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y}</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        borderWidth: 0
                    }
                },
                series: [{
                    name: '2018',
                    data: mortality_number,
                },
                    {
                        name: '2020',
                        data: mortality_number20,
                    }],
                legend: {
                    enabled: true
                },
            });

            $('#pie_incidence').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Incidence Rate by Cancer Sites in " + decodeURIComponent(country) + " (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'mortality',
                    colorByPoint: true,
                    data: pie_incidence_list,
                }],
                legend: {
                    enabled: true
                }
            });

            $('#pie_mortality').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Mortality Rate by Cancer Sites in " + decodeURIComponent(country) + " (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: pie_mortality_list,
                }],
                legend: {
                    enabled: true
                }
            });

            $('#scatter').highcharts({
                chart: {
                    type: 'scatter',
                    zoomType: 'xy'
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Incidence, Mortality Rate by Cancer Site",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                xAxis: {
                    title: {
                        enabled: true,
                        text: 'Incidence counts'
                    },
                    startOnTick: true,
                    endOnTick: true,
                    showLastLabel: true
                },
                yAxis: {
                    title: {
                        text: 'Mortality counts'
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: scatter_list,
                }],
                legend: {
                    enabled: true
                }
            });

        });
    }
});

//Incidence Rate by Cancer Site
$(function () {
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            var color_map = {"1":"#0e566c","2":"#6a3d9a","3":"#ff7f00",
                "4":"#1f78b4","5":"#33a02c","6":"#b15928","7":"#b15928",
                "8":"#b15928","9":"#b15928","10":"#b15928","11":"#feb24c",
                "12":"#feb24c","13":"#feb24c","14":"#feb24c",
                '15':"#feb24c",'16':"#feb24c",'17':"#feb24c",
                '18':"#feb24c",'19':"#feb24c",'20':"#feb24c",
                '21':"#f7fcb9",'22':"#f7fcb9",'23':"#f7fcb9",
                '24':"#f7fcb9",'25':"#f7fcb9",'26':"#f7fcb9",
                '27':"#f7fcb9",'28':"#f7fcb9",'29':"#f7fcb9",'30':"#f7fcb9",
                '31':"#f7fcb9",'32':"#f7fcb9",'33':"#f7fcb9",
                '34':"#f7fcb9",'35':"#f7fcb9"}
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                map_map["color"] = color_map[gene_ex[key]["deathrank"]]
                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["value"] = parseInt(gene_ex[key]["deathrank"])
                map_map["cancer"] = gene_ex[key]["cancer"]
                map_map["mortality"] = Number(gene_ex[key]["death_number"])
                map_map["incidence"] = Number(gene_ex[key]["new_number"])
                map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                map_list.push(map_map);
                map_map = {};
            }
        }
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#mortality_rank_map').highcharts('Map',{
                chart: {
                    // type: 'map',
                    backgroundColor: '#fafafa',
                    style: {
                        fontFamily: 'Arial'
                    }
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank: ' + this.point.value + '</b><br>' +
                            '<b>Incidence: ' + this.point.incidence + '</b><br>' +
                            '<b>Mortality: ' + this.point.mortality + '</b><br>';
                    }
                },


                // colors:['#bd0026','#253494'],
                credits: {
                    enabled: false,
                },
                title: { text: "Cancer with The Highest Mortality Rate in 185 Countries/Regions (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                mapNavigation: {
                    enabled: true,
                },
                plotOptions: {
                    series: {
                        cursor: 'pointer',
                        // point: {
                        //     events: {
                        //         click: function () {
                        //             window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                        //         }
                        //     }
                        // }
                    }
                },
                colorAxis: {
                    stops: [
                        [0, '#EFEFFF'],
                        [0.5, Highcharts.getOptions().colors[7]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[7]).brighten(-0.5).get()]
                    ],
                    type: 'logarithmic',
                    min: 1
                },
                series: [{
                    name: 'mortality',
                    data: map_list,
                    mapData: Highcharts.maps['custom/world'],
                    joinBy: ['iso-a2','code'],
                    name: 'Number of databases in',
                    states:{
                        hover:{
                            color:'#BADA55'
                        }
                    }
                }],
            });
        });
    }
});

//Mortality Rate by Cancer Site
$(function () {
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var color_map = {"1":"#0e566c","2":"#6a3d9a","3":"#ff7f00",
            "4":"#1f78b4","5":"#33a02c","6":"#b15928","7":"#b15928",
            "8":"#b15928","9":"#b15928","10":"#b15928","11":"#feb24c",
            "12":"#feb24c","13":"#feb24c","14":"#feb24c",
            '15':"#feb24c",'16':"#feb24c",'17':"#feb24c",
            '18':"#feb24c",'19':"#feb24c",'20':"#feb24c",
            '21':"#f7fcb9",'22':"#f7fcb9",'23':"#f7fcb9",
            '24':"#f7fcb9",'25':"#f7fcb9",'26':"#f7fcb9",
            '27':"#f7fcb9",'28':"#f7fcb9",'29':"#f7fcb9",'30':"#f7fcb9",
            '31':"#f7fcb9",'32':"#f7fcb9",'33':"#f7fcb9",
            '34':"#f7fcb9",'35':"#f7fcb9"}
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                map_map["color"] = color_map[gene_ex[key]["new_rank"]]
                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["value"] = parseInt(gene_ex[key]["new_rank"])
                map_map["cancer"] = gene_ex[key]["cancer"]
                map_map["mortality"] = Number(gene_ex[key]["death_number"])
                map_map["incidence"] = Number(gene_ex[key]["new_number"])
                map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                map_list.push(map_map);
                map_map = {};
            }
        }
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#incidence_rank_map').highcharts('Map',{
                chart: {
                    // type: 'map',
                    backgroundColor: '#fafafa',
                    style: {
                        fontFamily: 'Arial'
                    }
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank: ' + this.point.value + '</b><br>' +
                            '<b>Incidence: ' + this.point.incidence + '</b><br>' +
                            '<b>Mortality: ' + this.point.mortality + '</b><br>';
                    }
                },


                // colors:['#bd0026','#253494'],
                credits: {
                    enabled: false,
                },
                title: { text: "Cancer with The Highest Incidence Rate in 185 Countries/Regions (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                mapNavigation: {
                    enabled: true,
                },
                plotOptions: {
                    series: {
                        cursor: 'pointer',
                        // point: {
                        //     events: {
                        //         click: function () {
                        //             window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                        //         }
                        //     }
                        // }
                    }
                },
                colorAxis: {
                    stops: [
                        [0, '#EFEFFF'],
                        [0.5, Highcharts.getOptions().colors[5]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[5]).brighten(-0.5).get()]
                    ],
                    type: 'logarithmic',
                    min: 1
                },
                series: [{
                    name: 'mortality',
                    data: map_list,
                    // dataLabels: {
                    //     enabled: true,
                    //     color: 'white',
                    //     format: '{point.value}'
                    // },
                    mapData: Highcharts.maps['custom/world'],
                    joinBy: ['iso-a2','code'],
                    name: 'Number of databases in',
                    states:{
                        hover:{
                            color:'#BADA55'
                        }
                    }
                }],
            });
        });
    }
});

//The Mortality Counts of Cancer in 185 Countries/Regions
$(function () {
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["rank"] = gene_ex[key]["deathrank"]
                map_map["value"] = parseInt(gene_ex[key]["death_number"]) + 1
                map_map["mortality"] = Number(gene_ex[key]["death_number"])
                map_map["incidence"] = Number(gene_ex[key]["new_number"])
                map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                map_list.push(map_map);
                map_map = {};
            }
        }
        $(function () {

            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#mortality_map').highcharts('Map',{
                chart: {
                    // type: 'map',
                    backgroundColor: '#fafafa',
                    style: {
                        fontFamily: 'Arial'
                    }
                },
                legend: {
                    enabled: true
                },
                tooltip: {
                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank: ' + this.point.rank + '</b><br>' +
                            '<b>Incidence: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>' +
                            '<b>Mortality: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                    }
                },


                // colors:['#bd0026','#253494'],
                credits: {
                    enabled: false,
                },
                title: { text: "The Mortality Counts of " + cancer + " Cancer in 185 Countries/Regions (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                mapNavigation: {
                    enabled: true,
                },
                plotOptions: {
                    series: {
                        cursor: 'pointer',
                        // point: {
                        //     events: {
                        //         click: function () {
                        //             window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                        //         }
                        //     }
                        // }
                    }
                },
                colorAxis: {
                    stops: [
                        [0, '#EFEFFF'],
                        [0.5, Highcharts.getOptions().colors[7]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[7]).brighten(-0.5).get()]
                    ],
                    type: 'logarithmic',
                    min: 1
                },
                series: [{
                    name: 'mortality',
                    data: map_list,
                    mapData: Highcharts.maps['custom/world'],
                    joinBy: ['iso-a2','code'],
                    name: 'Number of databases in',
                    states:{
                        hover:{
                            color:'#BADA55'
                        }
                    }
                }],
            });
        });
    }
});

//The Incidence Counts of Cancer in 185 Countries/Regions
$(function () {
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["rank"] = gene_ex[key]["deathrank"]
                map_map["value"] = parseInt(gene_ex[key]["new_number"]) + 1
                map_map["mortality"] = Number(gene_ex[key]["death_number"])
                map_map["incidence"] = Number(gene_ex[key]["new_number"])
                map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                map_list.push(map_map);
                map_map = {};
            }
        }
        $(function () {

            $('#incidence_map').highcharts('Map',{
                chart: {
                    // type: 'map',
                    backgroundColor: '#fafafa',
                    style: {
                        fontFamily: 'Arial'
                    }
                },
                legend: {
                    enabled: true
                },
                tooltip: {
                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank: ' + this.point.rank + '</b><br>' +
                            '<b>Incidence: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>' +
                            '<b>Mortality: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                    }
                },


                // colors:['#bd0026','#253494'],
                credits: {
                    enabled: false,
                },
                title: { text: "The Incidence Counts of " + cancer + " Cancer in 185 Countries/Regions (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                mapNavigation: {
                    enabled: true,
                },
                plotOptions: {
                    series: {
                        cursor: 'pointer',
                        // point: {
                        //     events: {
                        //         click: function () {
                        //             window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                        //         }
                        //     }
                        // }
                    }
                },
                colorAxis: {
                    stops: [
                        [0, '#EFEFFF'],
                        [0.5, Highcharts.getOptions().colors[5]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[5]).brighten(-0.5).get()]
                    ],
                    type: 'logarithmic',
                    min: 1
                },
                series: [{
                    name: 'mortality',
                    data: map_list,
                    mapData: Highcharts.maps['custom/world'],
                    joinBy: ['iso-a2','code'],
                    name: 'Number of databases in',
                    states:{
                        hover:{
                            color:'#BADA55'
                        }
                    }
                }],
            });
        });
    }
});

//Continent Incidence Ratio
$(function () {
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var other = parseInt(0);
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if (gene_ex[key]["country"]==decodeURIComponent(country)) {
                var continent = gene_ex[key]["continent"]
            }
        }
        for (var key in gene_ex) {
            if ((gene_ex[key]["continent"] == continent)&(gene_ex[key]["year"]=="2018")) {
                if ((gene_ex[key]["continent_incirank"] <= 10)||(gene_ex[key]["country"]==decodeURIComponent(country))) {
                    // map_map["code"] = gene_ex[key]["code"]
                    // map_map["name"] = gene_ex[key]["name"]
                    map_map["rank"] = gene_ex[key]["continent_incirank"]
                    // map_map["value"] = parseInt(gene_ex[key]["new_number"]) + 1
                    map_map["incidence"] = Number(gene_ex[key]["new_number"])
                    map_map["name"] = gene_ex[key]["country"]
                    map_map["y"] = Number(gene_ex[key]["new_number"])
                    // map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                    map_list.push(map_map);
                    map_map = {};
                }
                else {
                    other = other + parseInt(gene_ex[key]["new_number"])
                }
            }

        }
        map_map["name"] = "other"
        map_map["y"] = other
        map_map["rank"] = "NA"
        map_map["incidence"] = other
        map_list.push(map_map);
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#continent_incidence').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }

                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Incidence Rate of Top 10 Countries in " + continent + " (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    // pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'

                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank in ' + continent + " : " + this.point.rank + '</b><br>' +
                            '<b>Percentage: ' + this.point.percentage.toFixed(1) + ' %</b><br>' +
                            '<b>Incidence: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>';
                    }
                },

                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: map_list,
                }],
                legend: {
                    enabled: true
                }
            });
        });
    }
});

//Continent Mortality Ratio
$(function () {
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var other = parseInt(0);
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if (gene_ex[key]["country"]==decodeURIComponent(country)) {
                var continent = gene_ex[key]["continent"]
            }
        }
        for (var key in gene_ex) {
            if ((gene_ex[key]["continent"] == continent)&(gene_ex[key]["year"]=="2018")) {
                if ((gene_ex[key]["continent_mortrank"] <= 10)||(gene_ex[key]["country"]==decodeURIComponent(country))) {
                    // map_map["code"] = gene_ex[key]["code"]
                    // map_map["name"] = gene_ex[key]["name"]
                    map_map["rank"] = gene_ex[key]["continent_mortrank"]
                    // map_map["value"] = parseInt(gene_ex[key]["new_number"]) + 1
                    map_map["mortality"] = Number(gene_ex[key]["death_number"])
                    map_map["name"] = gene_ex[key]["country"]
                    map_map["y"] = Number(gene_ex[key]["death_number"])
                    // map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                    map_list.push(map_map);
                    map_map = {};
                }
                else {
                    other = other + parseInt(gene_ex[key]["death_number"])
                }
            }

        }
        map_map["name"] = "other"
        map_map["y"] = other
        map_list.push(map_map);
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#continent_mortality').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Mortality Rate of Top 10 Countries in " + continent + " (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    // pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b><b>{point.rank}</b>'
                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank in ' + continent + " : " + this.point.rank + '</b><br>' +
                            '<b>Percentage: ' + this.point.percentage.toFixed(1) + ' %</b><br>' +
                            '<b>Mortality: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                    }
                },

                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: map_list,
                }],
                legend: {
                    enabled: true
                }
            });
        });
    }
});

//World Incidence Ratio
$(function () {
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var other = parseInt(0);
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];

        for (var key in gene_ex) {
            if (gene_ex[key]["year"]=="2018") {
                if ((gene_ex[key]["world_incirank"] <= 10) || (gene_ex[key]["country"] == country)) {
                    map_map["rank"] = gene_ex[key]["world_incirank"]
                    map_map["incidence"] = Number(gene_ex[key]["new_number"])
                    map_map["name"] = gene_ex[key]["country"]
                    map_map["y"] = Number(gene_ex[key]["new_number"])
                    map_list.push(map_map);
                    map_map = {};
                } else {
                    other = other + parseInt(gene_ex[key]["new_number"])
                }
            }
        }
        map_map["name"] = "other"
        map_map["y"] = other
        map_map["rank"] = "NA"
        map_map["incidence"] = other
        map_list.push(map_map);
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#world_incidence').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Incidence Rate of Top 10 Countries Worldwide (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    // pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'

                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank Around The World : ' + this.point.rank + '</b><br>' +
                            '<b>Percentage: ' + this.point.percentage.toFixed(1) + ' %</b><br>' +
                            '<b>Incidence: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>';
                    }
                },

                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: map_list,
                }],
                legend: {
                    enabled: true
                }
            });
        });
    }
});

//World Mortality Ratio
$(function () {
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    var cancer = window.location.href.split("cancer=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/cancer?cancer=' + cancer,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#bar").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var other = parseInt(0);
        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];

        for (var key in gene_ex) {
            if (gene_ex[key]["year"]=="2018") {
                if ((gene_ex[key]["world_mortrank"] <= 10) || (gene_ex[key]["country"] == country)) {
                    map_map["rank"] = gene_ex[key]["world_mortrank"]
                    map_map["mortality"] = Number(gene_ex[key]["death_number"])
                    map_map["name"] = gene_ex[key]["country"]
                    map_map["y"] = Number(gene_ex[key]["death_number"])
                    map_list.push(map_map);
                    map_map = {};
                } else {
                    other = other + parseInt(gene_ex[key]["death_number"])
                }
            }
        }

        map_map["name"] = "other"
        map_map["y"] = other
        map_map["rank"] = "NA"
        map_map["mortality"] = other
        map_list.push(map_map);
        // console.log(map_list)
        $(function () {
            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#world_mortality').highcharts({
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 35,
                        beta: 0
                    }
                },
                // colors:['#bd0026','#253494'],
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Mortality Rate of Top 10 Countries Worldwide (2018)",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight: 'bold',
                    },
                },
                tooltip: {
                    // pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'

                    formatter: function () {
                        return '<b>Country: ' + this.point.name + '</b><br>' +
                            '<b>Rank Around The World : ' + this.point.rank + '</b><br>' +
                            '<b>Percentage: ' + this.point.percentage.toFixed(1) + ' %</b><br>' +
                            '<b>Mortality: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                    }
                },

                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        }
                    }
                },
                series: [{
                    name: 'mortality',
                    colorByPoint: true,
                    data: map_list,
                }],
                legend: {
                    enabled: true
                }
            });
        });
    }
});

//table
$(function () {
    var country = window.location.href.split("country=")[1].split("&")[0].split("#")[0];
    var cancer = decodeURIComponent(window.location.href.split("cancer=")[1].split("#")[0]);
    $.ajax({
        url: '/lncexpdb/cancermap/browse/country?country=' + country,
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var gene_ex = data["cm"];
        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]==cancer)&(gene_ex[key]["year"]=="2018")) {

                var mortality_number = parseInt(gene_ex[key]["death_number"])
                var incidence_number = parseInt(gene_ex[key]["new_number"])
                var mortality_rank = parseInt(gene_ex[key]["deathrank"])
                var incidence_rank = parseInt(gene_ex[key]["new_rank"])
                var mortality_percentage = Number(gene_ex[key]["death_percent"])
                var incidence_percentage = Number(gene_ex[key]["new_percent"])
                var prevalence_number = parseInt(gene_ex[key]["prevalence_number"])
                var prevalence_prop = Number(gene_ex[key]["prevalence_prop"])
            }
        }

        $("#gene_table").append(
            "<tr><td><strong>The Incidence of " + cancer.toString() + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + incidence_number.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,').split(".")[0] + "</strong></td></tr>" +
            "<tr><td><strong>The Incidence Rate of " + cancer.toString() + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + incidence_percentage + " %</strong></td></tr>" +
            "<tr><td><strong>The Incidence Rank of " + cancer.toString() + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + incidence_rank + "</strong></td></tr>" +
            "<tr><td><strong>The 5-year Prevalence Number of " + cancer.toString() + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + prevalence_number.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,').split(".")[0] + "</strong></td></tr>"
        );

        $('#gene_table1').append(
            "<tr><td><strong>The Mortality of " + cancer + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + mortality_number.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,').split(".")[0] + "</strong></td></tr>" +
            "<tr><td><strong>The Mortality Rate of " + cancer + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + mortality_percentage + " %</strong></td></tr>" +
            "<tr><td><strong>The Mortality Rank of " + cancer + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + mortality_rank + "</strong></td></tr>" +
            "<tr><td><strong>The 5-year Prevalence Proportion of " + cancer + " Cancer in " + decodeURIComponent(country) + ": </strong></td><td style='text-align: left;padding-left: 20px'><strong>" + prevalence_prop + " %</strong></td></tr>"
        );
    }
});