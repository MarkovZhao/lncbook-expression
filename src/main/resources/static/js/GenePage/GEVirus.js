//SARS2 plot 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/virus?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#virus_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["srp253951"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,4);
        var value1 = ex_value.slice(1,4);
        $(function () {
            $('#virus_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "COVID Patients and Normal Control (" +  geneid + ")",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight:"bold",
                    }
                },
                xAxis: {
                    categories: ["COVID patient","Normal control"],
                    lineColor: "#000000",
                    tickColor: "#000000",
                    style:{
                        fontSize: '17px',
                        color:"#000000",
                        fontWeight: 'bold',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -30,
                        style: {
                            fontSize:'13px',
                            color: '#000000',
                            fontWeight: 'bold',
                            fontFamily: "Arial"
                        },
                    },
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'TPM',
                        style: {
                            fontSize: '17px',
                            color: "#000000",
                            fontWeight: 'bold',
                            fontFamily: 'Arial, sans-serif'
                        },
                    },
                    labels: {
                        style: {
                            fontSize:'13px',
                            color: '#000000',
                            fontWeight: 'bold',
                            fontFamily: "Arial"
                        },
                    },
                },
                tooltip: {
                    headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.3f}</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        borderWidth: 0,
                        pointWidth: 50,
                    }
                },
                series: [{
                    name: 'TPM',
                    data: value1
                }],
                legend: {
                    enabled: false
                }
            });
        });
    }
});


//HIV, HBV and HCV plot
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/virus?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#hiv_plot").html('加载中...');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["srp182096"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,tissue_name.length);
        var value1 = ex_value.slice(1,ex_value.length);
        $(function () {
            $('#hiv_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "HBC, HCV, HIV Infection and Normal Control (" +  geneid + ")",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight:"bold",
                    }
                },
                xAxis: {
                    categories: ["Normal control","HBV infection","HCV infection","HIV infection"],
                    lineColor: "#000000",
                    tickColor: "#000000",
                    style:{
                        fontSize: '17px',
                        color:"#000000",
                        fontWeight: 'bold',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -30,
                        style: {
                            fontSize:'13px',
                            color: '#000000',
                            fontWeight: 'bold',
                            fontFamily: "Arial"
                        },
                    },
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'TPM',
                        style: {
                            fontSize: '17px',
                            color: "#000000",
                            fontWeight: 'bold',
                            fontFamily: 'Arial, sans-serif'
                        },
                    },
                    labels: {
                        style: {
                            fontSize:'13px',
                            color: '#000000',
                            fontWeight: 'bold',
                            fontFamily: "Arial"
                        },

                    },
                },
                tooltip: {
                    headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.3f}</b></td></tr>',
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
                    name: 'TPM',
                    data: value1
                }],
                legend: {
                    enabled: false
                }
            });
        });
    }
});

