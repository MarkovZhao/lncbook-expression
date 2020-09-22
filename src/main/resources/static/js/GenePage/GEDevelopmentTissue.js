//lncRNA 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/gene/development?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#development_plot_tissue").html('<h4>Please wait...</h4>');
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
        var xais = {"brain":["Four week","Five week","Seven week","Eight week","Nine week","Ten week","Eleven week", "Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week","twenty week","Neonate","Infant","Toddler","School age child","Adolescent","Young adult"],
                "cerebellum":["Four week","Five week","Seven week","Eight week","Nine week","Ten week","Eleven week", "Twelve week","Thirteen week","Sixteen week","Neonate","Infant","Toddler","School age child", "Adolescent","Young adult"],
                "heart":["Four week","Five week","Six week","Seven week","Eight week", "Nine week","Ten week", "Eleven week","Twelve week","Thirteen week","Sixteen week", "Eighteen week","Nineteen week", "Neonate","Infant","Toddler","Adolescent","Young adult"],
                "kidney":["Four week","Five week","Six week","Seven week","Eight week","Nine week","Ten week", "Eleven week","Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week", "Neonate","Infant","Toddler","School age child"],
                "liver":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week", "Sixteen week","Eighteen week","Nineteen week","Neonate","Infant","Toddler","School age child", "Adolescent","Young adult","Middle adult","Elderly"],
                "ovary":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week", "Thirteen week","Sixteen week","Eighteen week"],
                "testis":["Four week","Five week","Six week", "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week", "Sixteen week","Eighteen week","Nineteen week","Infant","Toddler","Adolescent","Young adult", "Middle adult","Elderly"]}

        var single_tissue = function (value_dic,xais,tissue) {
            $('#single_development_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Development of " + tissue_map[tissue] + " from Early Organogenesis to Adulthood ("  + geneid + ")"
                },
                xAxis: {
                    categories: xais[tissue],
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
                series: [
                    {
                        name: tissue_map[tissue],
                        data: value_dic[tissue]
                    },
                ],
                legend: {
                    enabled: true
                }
            });
        };
        single_tissue(value_dic,xais,"brain");
        $("#development").on("change",function () {
            var tissue = $(this).val();
            console.log(tissue)
            single_tissue(value_dic,xais,tissue)
        })
    }
});


