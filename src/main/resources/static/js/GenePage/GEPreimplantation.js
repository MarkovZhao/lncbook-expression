//lncRNA 表达的数据请求

$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/gene/preimplantation?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#preimplantation_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        var time_points = new Array();
        var ex_value = new Array();
        var errors = new Array();
        var gene_ex = data["srp061636"][0];

        for (var key in gene_ex) {
            var new_key = key.replace(/\d+/g,"");
            if (time_points.indexOf(new_key) < 0) {
                time_points.push(new_key);
            }
        }

        for (var i=1;i<time_points.length;i++) {
            var time = time_points[i]
            var tpm = 0;
            var num = 0;
            var tpms = new Array();
            for (var key in gene_ex) {
                var new_key = key.replace(/\d+/g,"");
                if (time == new_key) {
                    tpm += parseFloat(gene_ex[key])
                    num += 1;
                    tpms.push(tpm)
                }
            }
            tpm = tpm/num;
            // var mean = tpms.reduce(sum)/tpms.length;
            // var deviations = tpms.map(function(x){return x-mean;});
            // var stddev = Math.sqrt(deviations.map(square).reduce(sum)/(tpms.length-1));
            // var single_error = new Array();
            // single_error.push(tpm-1);
            // single_error.push(tpm+1);
            // errors.push(single_error);
            ex_value.push(tpm);

        }

        var name1 = time_points.slice(1,time_points.length);
        // $("#gene_expression").html(value1.join(","))
        var value1 = ex_value;
        $(function () {
            $('#preimplantation_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Development of Human Preimplantation Embryos Dataset 2 ("  + geneid + ")"
                },
                xAxis: {
                    categories: ["Oocyte","Zygote","2-cell","4-cell","8-cell","Morulae","Earlyblastocyst",
                    "Middleblastocyst","Lateblastocyst"],
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
                        },
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
                    spline: {
                        borderWidth: 0
                    }
                },
                series: [{
                    name: 'TPM',
                    data: value1,
                }],
                legend: {
                    enabled: false
                }
            });

        });
    }
});


