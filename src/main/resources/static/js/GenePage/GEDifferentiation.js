//lncRNA 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/differentiation?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#differentiation_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["srp168391"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,tissue_name.length);
        var value1 = ex_value.slice(1,ex_value.length);
        $(function () {
            $('#differentiation_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Differentiation from iPSC to Cardiomyocyte ("  + geneid + ")"
                },
                xAxis: {
                    categories: ["Day 0","Day 1","Day 2"
                        ,"Day 3","Day 4","Day 5","Day 6",
                        "Day 7","Day 8","Day 9","Day 10","Day 11"
                        ,"Day 12","Day 13","Day 14","Day 15"],
                    style:{
                        fontSize: '17px',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -30,
                        style: {
                            fontSize:'13px',
                            fontcolor: '#000000',
                            fontWeight: 'bold',
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
                            fontWeight: 'bold',
                            fontFamily: 'Arial, sans-serif'
                        }
                    },
                    labels: {
                        style: {
                            fontSize:'13px',
                            fontcolor: '#000000',
                            fontWeight: 'bold',
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


