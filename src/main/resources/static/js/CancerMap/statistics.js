
//deathrank
$(function() {
    // var cancer = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/cancermap/browse/deathrank?deathrank=1',
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#mortality_map").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var map_map = {};
        var map_list = new Array();
        var gene_ex = data["cm"];
        var color_map = {"Lung":"#0e566c","Cervix uteri":"#6a3d9a","Breast":"#ff7f00",
            "Prostate":"#1f78b4","Stomach":"#33a02c","Liver":"#b15928","Oesophagus":"#1f78b4",
            "Colon":"#a6cee3","Gallbladder":"#cab2d6","Leukaemia":"#e31a1c","Bladder":"#feb24c",
            "Rectum":"#fed976","Thyroid":"#ffeda0","Non-Hodgkin lymphoma":"#ffffcc",
            'Brain, central nervous system':"#7fcdbb",'Nasopharynx':"#c7e9b4",'Ovary':"#edf8b1",
            'Pancreas':"#ffffd9",'Larynx':"#addd8e",'Hodgkin lymphoma':"#d9f0a3",
            'Multiple myeloma':"#f7fcb9",'Kidney':"#ffffe5",'Corpus uteri':"#bcbddc",
            'Lip, oral cavity':"#dadaeb",'Melanoma of skin':"#efedf5",'Salivary glands':"#fcfbfd",
            'Testis':"#737373",'Anus':"#969696",'Oropharynx':"#bdbdbd",'Vulva':"#d9d9d9",
            'Mesothelioma':"#f0f0f0",'Kaposi sarcoma':"#ffffff",'Hypopharynx':"#fa9fb5",
            'Vagina':"#fcc5c0",'Penis':"#fde0dd"}
        for (var key in gene_ex) {
            if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                map_map["code"] = gene_ex[key]["code"]
                map_map["name"] = gene_ex[key]["name"]
                map_map["value"] = gene_ex[key]["cancer"]
                map_map["color"] = color_map[gene_ex[key]["cancer"]]
                map_map["cancer"] = gene_ex[key]["cancer"]
                map_map["mortality"] = Number(gene_ex[key]["death_number"])
                map_map["incidence"] = Number(gene_ex[key]["new_number"])
                map_map["prevalence"] = Number(gene_ex[key]["prevalence_number"])
                map_list.push(map_map);
                map_map = {};
            }
        }
        console.log(map_list)

        $(function () {

            Highcharts.setOptions({
                lang: {
                    thousandsSep: ','
                }
            });

            $('#mortality_map').highcharts('Map',{
                chart: {
                    // type: 'map',
                    backgroundColor: 'white',
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
                            '<b>Top Cancer: ' + this.point.value + ' Cancer</b><br>' +
                            '<b>Incidence Counts: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>' +
                            '<b>Mortality Counts: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                    }
                },


                // colors:['#bd0026','#253494'],
                credits: {
                    enabled: false,
                },
                title: { text: "Most Commonly Diagnosed Cancers Worldwide",
                        style:{
                            color:"#000000",
                            fontFamily:"Arial",
                            fontWeight: 'bold',
                        },
                },
                mapNavigation: {
                    enabled: true,
                },
                // plotOptions: {
                //     series: {
                //         cursor: 'pointer',
                //         point: {
                //             events: {
                //                 click: function () {
                //                     window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                //                 }
                //             }
                //         }
                //     }
                // },
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

//所有国家的top cancer与发病数、死亡数
$("#country").click(function () {
    $(function() {
        // var cancer = window.location.href.split("=")[1].split("#")[0];
        $.ajax({
            url: '/lncexpdb/cancermap/browse/deathrank?deathrank=1',
            type: 'POST',
            dataType: 'json',
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        });
        function LoadFunction() {
            $("#mortality_map").html('<h4>Please wait...</h4>');
        }
        function erryFunction() {
            alert("error");
        }
        function succFunction(data) {

            var map_map = {};
            var map_list = new Array();
            var gene_ex = data["cm"];
            var color_map = {"Lung":"#0e566c","Cervix uteri":"#6a3d9a","Breast":"#ff7f00",
                "Prostate":"#1f78b4","Stomach":"#33a02c","Liver":"#b15928","Oesophagus":"#1f78b4",
                "Colon":"#a6cee3","Gallbladder":"#cab2d6","Leukaemia":"#e31a1c","Bladder":"#feb24c",
                "Rectum":"#fed976","Thyroid":"#ffeda0","Non-Hodgkin lymphoma":"#ffffcc",
                'Brain, central nervous system':"#7fcdbb",'Nasopharynx':"#c7e9b4",'Ovary':"#edf8b1",
                'Pancreas':"#ffffd9",'Larynx':"#addd8e",'Hodgkin lymphoma':"#d9f0a3",
                'Multiple myeloma':"#f7fcb9",'Kidney':"#ffffe5",'Corpus uteri':"#bcbddc",
                'Lip, oral cavity':"#dadaeb",'Melanoma of skin':"#efedf5",'Salivary glands':"#fcfbfd",
                'Testis':"#737373",'Anus':"#969696",'Oropharynx':"#bdbdbd",'Vulva':"#d9d9d9",
                'Mesothelioma':"#f0f0f0",'Kaposi sarcoma':"#ffffff",'Hypopharynx':"#fa9fb5",
                'Vagina':"#fcc5c0",'Penis':"#fde0dd"}
            for (var key in gene_ex) {
                if ((gene_ex[key]["cancer"]!="All cancer sites")&(gene_ex[key]["year"]=="2018")) {

                    map_map["code"] = gene_ex[key]["code"]
                    map_map["name"] = gene_ex[key]["name"]
                    map_map["value"] = gene_ex[key]["cancer"]
                    map_map["color"] = color_map[gene_ex[key]["cancer"]]
                    map_map["cancer"] = gene_ex[key]["cancer"]
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
                        enabled: false
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>Country: ' + this.point.name + '</b><br>' +
                                '<b>Top Cancer: ' + this.point.value + ' Cancer</b><br>' +
                                '<b>Incidence Counts: ' + Highcharts.numberFormat(this.point.incidence,0) + '</b><br>' +
                                '<b>Mortality Counts: ' + Highcharts.numberFormat(this.point.mortality,0) + '</b><br>';
                        }
                    },


                    // colors:['#bd0026','#253494'],
                    credits: {
                        enabled: false,
                    },
                    title: { text: "Most Commonly Diagnosed Cancers Worldwide",
                            style:{
                                color:"#000000",
                                fontFamily:"Arial",
                                fontWeight: 'bold',
                            },
                    },
                    mapNavigation: {
                        enabled: true,
                    },
                    // plotOptions: {
                    //     series: {
                    //         cursor: 'pointer',
                    //         point: {
                    //             events: {
                    //                 click: function () {
                    //                     window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                    //                 }
                    //             }
                    //         }
                    //     }
                    // },
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
})

//所有国家总的死亡数
$("#mortality").click(function () {
    $(function() {
        // var cancer = window.location.href.split("=")[1].split("#")[0];
        $.ajax({
            url: '/lncexpdb/cancermap/browse/cancer?cancer=All cancer sites',
            type: 'POST',
            dataType: 'json',
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        });
        function LoadFunction() {
            $("#mortality_map").html('<h4>Please wait...</h4>');
        }
        function erryFunction() {
            alert("error");
        }
        function succFunction(data) {

            var countries = new Array();
            var mortality_number = new Array();
            var incidence_number = new Array();
            var prevalence_number = new Array();
            var map_map = {};
            var map_list = new Array();
            var gene_ex = data["cm"];

            for (var key in gene_ex) {
                if (gene_ex[key]["year"]=="2018") {
                    countries.push(gene_ex[key]["country"]);
                    mortality_number.push(Number(gene_ex[key]["death_number"]))
                    incidence_number.push(Number(gene_ex[key]["new_number"]))
                    prevalence_number.push(Number(gene_ex[key]["prevalence_number"]))

                    map_map["code"] = gene_ex[key]["code"]
                    map_map["name"] = gene_ex[key]["name"]
                    map_map["value"] = Number(gene_ex[key]["death_number"])
                    map_map["rank1"] = gene_ex[key]["death_rank"]
                    map_list.push(map_map);
                    map_map = {};
                    console.log(map_map)
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
                    // colors:['#bd0026','#253494'],
                    credits: {
                        enabled: false,
                    },
                    title: { text: "Total Mortality of 35 Cancer Sites in 185 Countries/Regions",
                            style:{
                                color:"#000000",
                                fontFamily:"Arial",
                                fontWeight: 'bold',
                            },
                    },
                    mapNavigation: {
                        enabled: true,
                    },
                    // plotOptions: {
                    //     series: {
                    //         cursor: 'pointer',
                    //         point: {
                    //             events: {
                    //                 click: function () {
                    //                     window.open('http://localhost:18000/lncexpdb/cancermap/country?country=' + this.name, '_blank').location;
                    //                 }
                    //             }
                    //         }
                    //     }
                    // },
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
})

//所有国家总的发病数
$("#incidence").click(function () {
    $(function() {
        // var cancer = window.location.href.split("=")[1].split("#")[0];
        $.ajax({
            url: '/lncexpdb/cancermap/browse/cancer?cancer=All cancer sites',
            type: 'POST',
            dataType: 'json',
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        });
        function LoadFunction() {
            $("#mortality_map").html('<h4>Please wait...</h4>');
        }
        function erryFunction() {
            alert("error");
        }
        function succFunction(data) {

            var countries = new Array();
            var mortality_number = new Array();
            var incidence_number = new Array();
            var prevalence_number = new Array();
            var map_map = {};
            var map_list = new Array();
            var gene_ex = data["cm"];

            for (var key in gene_ex) {
                if (gene_ex[key]["year"]=="2018") {
                    countries.push(gene_ex[key]["country"]);
                    mortality_number.push(Number(gene_ex[key]["death_number"]))
                    incidence_number.push(Number(gene_ex[key]["new_number"]))
                    prevalence_number.push(Number(gene_ex[key]["prevalence_number"]))

                    map_map["code"] = gene_ex[key]["code"]
                    map_map["name"] = gene_ex[key]["name"]
                    map_map["value"] = Number(gene_ex[key]["new_number"])
                    map_map["rank1"] = gene_ex[key]["death_rank"]
                    map_list.push(map_map);
                    map_map = {};
                    console.log(map_map)
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
                    // colors:['#bd0026','#253494'],
                    credits: {
                        enabled: false,
                    },
                    title: { text: "Total Incidence of 35 Cancer Sites in 185 Countries/Regions",
                            style:{
                                color:"#000000",
                                fontFamily:"Arial",
                                fontWeight: 'bold',
                            },
                    },
                    mapNavigation: {
                        enabled: true,
                    },
                    // plotOptions: {
                    //     series: {
                    //         cursor: 'pointer',
                    //         point: {
                    //             events: {
                    //                 click: function () {
                    //                     window.open('http://localhost:18000/lncexpdb/cancermap/country?country=' + this.name, '_blank').location;
                    //                 }
                    //             }
                    //         }
                    //     }
                    // },
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
})

//所有癌症的发病数、死亡数
$("#cancer").click(function () {
    $(function() {
        // var cancer = window.location.href.split("=")[1].split("#")[0];
        $.ajax({
            url: '/lncexpdb/cancermap/browse/all',
            type: 'POST',
            dataType: 'json',
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        });
        function LoadFunction() {
            $("#mortality_map").html('<h4>Please wait...</h4>');
        }
        function erryFunction() {
            alert("error");
        }
        function succFunction(data) {

            // var map_map = {};
            var map_list = [{'data': [-48418,
                    -546053,
                    -296048,
                    -2074545,
                    -568044,
                    -1085483,
                    -380340,
                    -218290,
                    -79841,
                    -79022,
                    -41696,
                    -400740,
                    -176544,
                    -435084,
                    -347880,
                    -826335,
                    -2078283,
                    -287273,
                    -30362,
                    -159179,
                    -127039,
                    -506288,
                    -568618,
                    -91734,
                    -293700,
                    -456588,
                    -34390,
                    -1268346,
                    -696913,
                    -52523,
                    -1029111,
                    -70849,
                    -564049,
                    -17509,
                    -44117], 'name': 'incidence'},
                {'data': [19094.0,
                        198614.0,
                        240322.0,
                        624144.0,
                        310341.0,
                        545951.0,
                        89665.0,
                        163527.0,
                        26133.0,
                        34237.0,
                        19862.0,
                        174337.0,
                        94460.0,
                        307742.0,
                        174809.0,
                        770520.0,
                        1749322.0,
                        60471.0,
                        25512.0,
                        105498.0,
                        72082.0,
                        247301.0,
                        506289.0,
                        50544.0,
                        184098.0,
                        430023.0,
                        15114.0,
                        356954.0,
                        308668.0,
                        22104.0,
                        779648.0,
                        9489.0,
                        40914.0,
                        8040.0,
                        15190.0], 'name': 'mortality'}];
            // map_list.push({"id":"World","parent":"","name":"World"})
            // map_list.push({"id":"Africa","parent":"World","name":"Africa"})
            // map_list.push({"id":"Asia","parent":"World","name":"Asia"})
            // map_list.push({"id":"Europe","parent":"World","name":"Europe"})
            // map_list.push({"id":"Latin America and the Caribbean","parent":"World","name":"Latin America and the Caribbean"})
            // map_list.push({"id":'North America',"parent":"World","name":'North America'})
            // map_list.push({"id":'Oceania',"parent":"World","name":'Oceania'})
            //
            // var gene_ex = data["cm"];
            // for (var key in gene_ex) {
            //     if (gene_ex[key]["cancer"]=="All cancer sites") {
            //
            //         map_map["id"] = gene_ex[key]["country"]
            //         map_map["parent"] = gene_ex[key]["continent"]
            //         map_map["name"] = gene_ex[key]["country"]
            //         map_map["value"] = gene_ex[key]["death_number"]
            //         map_list.push(map_map);
            //         map_map = {};
            //     }
            // }
            // console.log(map_list)
            $(function () {

                Highcharts.setOptions({
                    lang: {
                        thousandsSep: ','
                    }
                });

                $('#mortality_map').highcharts({
                    chart: {
                        type: 'column',
                        // polar: true,

                        backgroundColor: '#fafafa',
                        style: {
                            fontFamily: 'Arial'
                        }
                    },

                    credits: {
                        enabled: false,
                    },

                    title: { text: "Total Incidence and Mortality of 35 Cancers in 185 Countries/Regions",
                            style:{
                                color:"#000000",
                                fontFamily:"Arial",
                                fontWeight: 'bold',
                            },
                    },
                    pane: {
                        size: '85%'
                    },
                    xAxis: [{
                        tickmarkPlacement: 'on',
                        categories: ['Anus',
                            'Bladder',
                            'Brain, central nervous system',
                            'Breast',
                            'Cervix uteri',
                            'Colon',
                            'Corpus uteri',
                            'Gallbladder',
                            'Hodgkin lymphoma',
                            'Hypopharynx',
                            'Kaposi sarcoma',
                            'Kidney',
                            'Larynx',
                            'Leukaemia',
                            'Lip, oral cavity',
                            'Liver',
                            'Lung',
                            'Melanoma of skin',
                            'Mesothelioma',
                            'Multiple myeloma',
                            'Nasopharynx',
                            'Non-Hodgkin lymphoma',
                            'Oesophagus',
                            'Oropharynx',
                            'Ovary',
                            'Pancreas',
                            'Penis',
                            'Prostate',
                            'Rectum',
                            'Salivary glands',
                            'Stomach',
                            'Testis',
                            'Thyroid',
                            'Vagina',
                            'Vulva'],
                        lineColor: "#000000",
                        tickColor: '#000000',
                        minorTickColor: "#000000",
                        labels: {
                            step: 1,
                            rotation: -60,
                            style: {
                                fontSize:'11px',
                                color: '#000000',
                                fontFamily: 'Arial',
                                fontWeight: 'bold',
                            },
                        },
                    }],
                    yAxis: {
                        min: 0,
                        title: {
                            style: {
                                color: '#000000',
                                fontSize: '14px',
                                fontWeight: 'bold',
                                fontFamily: 'Arial, sans-serif'
                            }
                        },
                        labels: {
                            formatter: function () {
                                return (Math.abs(this.value))/1000000 + 'M';
                            },
                            step: 1,
                            style: {
                                fontSize:'12px',
                                color: '#000000',
                                fontFamily: 'Arial',
                                fontWeight: 'bold',
                            },
                        },
                        min: -2000000,
                        max: 1500000
                    },

                    series:map_list,

                    plotOptions: {
                        series: {
                            // stacking: 'normal',
                            shadow: false,
                            groupPadding: 0,
                            pointPlacement: 'on'
                        }
                    }
                });

            });
        }
    });
})

//所有癌症在各大洲的发病数、死亡数
$("#continent").click(function () {
    $(function() {

        $.ajax({
            url: '/lncexpdb/cancermap/browse/all',
            type: 'POST',
            dataType: 'json',
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        });
        function LoadFunction() {
            $("#mortality_map").html('<h4>Please wait...</h4>');
        }
        function erryFunction() {
            alert("error");
        }
        function succFunction(data) {

            var map_map = {};
            var incidence_list = new Array();
            var map_list = new Array();
            var gene_ex = data["cm"];

            var cancers = ['Anus', 'Bladder',
                'Brain, central nervous system', 'Breast', 'Cervix uteri', 'Colon',
                'Corpus uteri', 'Gallbladder', 'Hodgkin lymphoma', 'Hypopharynx',
                'Kaposi sarcoma', 'Kidney', 'Larynx', 'Leukaemia',
                'Lip, oral cavity', 'Liver', 'Lung', 'Melanoma of skin',
                'Mesothelioma', 'Multiple myeloma', 'Nasopharynx',
                'Non-Hodgkin lymphoma', 'Oesophagus', 'Oropharynx', 'Ovary',
                'Pancreas', 'Penis', 'Prostate', 'Rectum', 'Salivary glands',
                'Stomach', 'Testis', 'Thyroid', 'Vagina', 'Vulva']
            for (var count in cancers) {
                var cancer = cancers[count]
                map_map["name"] = cancer;
                for (var key in gene_ex) {
                    if (gene_ex[key]["cancer"] == cancer) {

                        incidence_list.push(Number(gene_ex[key]["new_number"]))
                    }
                }
                map_map["data"] = incidence_list;
                map_map["stack"] = "incidence";
                map_list.push(map_map)
                map_map = {};
                incidence_list = new Array();
                map_map["name"] = cancer;
                for (var key in gene_ex) {
                    if (gene_ex[key]["cancer"] == cancer) {

                        incidence_list.push(Number(gene_ex[key]["death_number"]))
                    }
                }
                map_map["data"] = incidence_list;
                map_map["stack"] = "mortality";
                map_list.push(map_map)
                map_map = {};
                incidence_list = new Array();
            }
            console.log(map_list)

            $(function () {
                Highcharts.setOptions({
                    lang: {
                        thousandsSep: ' '
                    }
                });

                $('#mortality_map').highcharts({
                    chart: {
                        polar: true,
                        type: 'column',
                        backgroundColor: '#fafafa',
                        style: {
                            fontFamily: 'Arial'
                        }
                    },
                    legend: {
                        enabled: false
                    },

                    credits: {
                        enabled: false,
                    },
                    title: { text: "Cancer with The Highest Mortality Rate in 185 Countries/Regions"
                    },

                    xAxis: {
                        categories: cancers
                    },

                    yAxis: {
                        allowDecimals: false,
                        min: 0,
                        title: {
                            text: 'Counts'
                        }
                    },

                    plotOptions: {
                        column: {
                            stacking: 'normal'
                        },
                        series: {
                            cursor: 'pointer',
                            point: {
                                events: {
                                    click: function () {
                                        window.open('https://bigd.big.ac.cn:443/databasecommons/browse/country/' + this.name, '_blank').location;
                                    }
                                }
                            }
                        }
                    },

                    tooltip: {
                        formatter: function () {
                            return '<b>' + this.x + '</b><br/>' +
                                this.series.name + ': ' + this.y + '<br/>' +
                                'Counts: ' + this.point.stackTotal;
                        }
                    },

                    series: [
                        {
                            name: '1000+',
                            data: [11, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '500-1000',
                            data: [11, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '300-500',
                            data: [11, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '200-300',
                            data: [12, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '100-200',
                            data: [13, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '50-100',
                            data: [14, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        },
                        {
                            name: '0-50',
                            data: [15, 12, 15, 21, 24, 35, 16, 18, 25, 24, 12]
                        }
                    ]
                });
            });
        }
    });
})