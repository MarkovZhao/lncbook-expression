//lncRNA 表达的数据请求
$(document).on("click", "a[name='view_expression']", function () {
    $("#expression_plot").show();
    $("a[name='hide_expression']").html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $("a[name='hide_expression']").attr("name","view_expression");
    $(this).html("<span class=\"glyphicon glyphicon-minus\"></span>");
    $(this).attr("name","hide_expression");
    var geneid = $(this).data("id");
    console.log(geneid)
    $.ajax({
        url: '/LncExpDB/gene/circadian?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#expression_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["circadian"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,tissue_name.length-3);
        var value1 = ex_value.slice(1,ex_value.length-3);
        $(function () {
            $('#expression_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Whole Blood with Intermediate Circadian Phenotype (" + geneid + ")"
                },
                xAxis: {
                    categories: ["One hour","Three hour","Five hour"
                        ,"Seven hour","Nine hour","Elven hour","Thirteen hour",
                        "Fifteen hour","Seventeen hour","Nineteen hour","Twenty one hour","Twenty three hour"
                    ],
                    style:{
                        fontSize: '13px',
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

$(document).on("click", "a[name='hide_expression']", function () {
    $("#expression_plot").hide();
    $(this).html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $(this).attr("name","view_expression");
});

