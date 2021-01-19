//lncRNA 表达的数据请求
$(document).on("click", "a[name='view_expression']", function () {
    $("#expression_plot").show();
    $("a[name='hide_expression']").html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $("a[name='hide_expression']").attr("name","view_expression");
    $(this).html("<span class=\"glyphicon glyphicon-minus\"></span>");
    $(this).attr("name","hide_expression");
    var geneid = $(this).data("id");
    $.ajax({
        url: '/lncexpdb/gene/development?geneid=' + geneid,
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
        var tissues = ["brain","cerebellum","heart","kidney","liver","testis","ovary"]
        var value_dic = {};
        var null_dic = {};
        for (var i=0;i<tissues.length;i++) {
            var ex_value = new Array();
            var null_value = new Array();
            var tissue = tissues[i]
            var gene_ex = data[tissue][0]
            for (var key in gene_ex) {
                ex_value.push(parseFloat(gene_ex[key]))
                null_value.push(null)
            }
            value_dic[tissue] = ex_value.slice(1,ex_value.length)
        }
        var tissue_map = {"brain":"Brain","cerebellum":"Cerebellum","heart":"Heart","kidney":"Kidney","liver":"Liver","ovary":"Ovary","testis":"Testis"}
        var xais = {"brain":["Four week","Five week","Seven week","Eight week","Nine week","Ten week","Eleven week", "Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week","Twenty week","Neonate","Infant","Toddler","School age child","Adolescent","Young adult"],
            "cerebellum":["Four week","Five week","Seven week","Eight week","Nine week","Ten week","Eleven week", "Twelve week","Thirteen week","Sixteen week","Neonate","Infant","Toddler","School age child", "Adolescent","Young adult"],
            "heart":["Four week","Five week","Six week","Seven week","Eight week", "Nine week","Ten week", "Eleven week","Twelve week","Thirteen week","Sixteen week", "Eighteen week","Nineteen week", "Neonate","Infant","Toddler","Adolescent","Young adult"],
            "kidney":["Four week","Five week","Six week","Seven week","Eight week","Nine week","Ten week", "Eleven week","Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week", "Neonate","Infant","Toddler","School age child"],
            "liver":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week", "Sixteen week","Eighteen week","Nineteen week","Neonate","Infant","Toddler","School age child", "Adolescent","Young adult","Middle adult","Elderly"],
            "ovary":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week", "Thirteen week","Sixteen week","Eighteen week"],
            "testis":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week", "Sixteen week","Eighteen week","Nineteen week","Infant","Toddler","Adolescent","Young adult", "Middle adult","Elderly"]}

        var single_tissue = function (value_dic,xais,tissue) {
            $('#expression_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Development of " + tissue_map[tissue] + " from Early Organogenesis to Adulthood ("  + geneid + ")",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight:"bold",
                    }
                },
                xAxis: {
                    categories: xais[tissue],
                    lineColor: "#000000",
                    tickColor: "#000000",
                    style:{
                        fontSize: '13px',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -30,
                        style: {
                            style: {
                                fontSize:'13px',
                                color: '#000000',
                                fontWeight: 'bold',
                                fontFamily: "Arial"
                            },
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
                        }
                    },
                    labels: {
                        style: {
                            fontSize:'13px',
                            color: '#000000',
                            fontWeight: 'bold',
                            fontFamily: "Arial",
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
                series: [
                    {
                        name: "TPM",
                        data: value_dic[tissue]
                    },
                ],
                legend: {
                    enabled: true
                }
            });
        };
        var type = $("#type").val()
        single_tissue(value_dic,xais,type);
    }
});

$(document).on("click", "a[name='hide_expression']", function () {
    $("#expression_plot").hide();
    $(this).html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $(this).attr("name","view_expression");
});