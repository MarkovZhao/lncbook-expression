//SARS2 plot 表达的数据请求
$(document).on("click", "a[name='view_expression']", function () {
    $("#expression_plot").show();
    $("a[name='hide_expression']").html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $("a[name='hide_expression']").attr("name","view_expression");
    $(this).html("<span class=\"glyphicon glyphicon-minus\"></span>");
    $(this).attr("name","hide_expression");
    var geneid = $(this).data("id");
    $.ajax({
        url: '/LncExpDB/profile/level?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#expression_plot").html('<h4>Please wait...</h4>');
        $('#annotation').html('<p><span><strong>Note:</strong> For each biological ' +
            'condition, genes with maximum expression values less than 1.0 TPM are considered as ' +
            '"NE" (not expressed), genes whose expression values are greater than the upper <br>quantile are ' +
            'considered as “H” (high expression level), those less than the lower quantile as “L” (low expression level), and the remaining as “M” (medium expression level).\n' +
            '                    </span>\n' +
            '                </p>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["level"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var value1 = ex_value.slice(11,15);
        console.log(value1)
        $(function () {
            $('#expression_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Expression Level Distribution of " + geneid + " across 337 Biological Conditions"
                },
                xAxis: {
                    categories: ["NE","L","M","H"],
                    style:{
                        fontSize: '17px',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
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
                        text: 'Number of conditions',
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
                    headerFormat: '<table>',
                    pointFormat: '<tr><td style="padding:0"><b>{point.y:f}</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        borderWidth: 0,
                        pointWidth: 60,
                    },

                },
                series: [{
                    name: 'Expression capacity',
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
    $("#annotation").hide();
    $(this).html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $(this).attr("name","view_expression");

});