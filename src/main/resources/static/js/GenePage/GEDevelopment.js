//lncRNA 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
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
        $("#development_plot").html('<h4>Please wait...</h4>');
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
            null_dic[tissue] = null_value.slice(1,null_value.length)
        }
        var brain = value_dic["brain"].concat(null_dic["cerebellum"],null_dic["heart"],null_dic["kidney"],
            null_dic["liver"],null_dic["ovary"],null_dic["testis"]);
        var cerebellum = null_dic["brain"].concat(value_dic["cerebellum"],null_dic["heart"],null_dic["kidney"],
            null_dic["liver"],null_dic["ovary"],null_dic["testis"]);
        var heart = null_dic["brain"].concat(null_dic["cerebellum"],value_dic["heart"],null_dic["kidney"],
            null_dic["liver"],null_dic["ovary"],null_dic["testis"]);
        var kidney = null_dic["brain"].concat(null_dic["cerebellum"],null_dic["heart"],value_dic["kidney"],
            null_dic["liver"],null_dic["ovary"],null_dic["testis"]);
        var liver = null_dic["brain"].concat(null_dic["cerebellum"],null_dic["heart"],null_dic["kidney"],
            value_dic["liver"],null_dic["ovary"],null_dic["testis"]);
        var ovary = null_dic["brain"].concat(null_dic["cerebellum"],null_dic["heart"],null_dic["kidney"],
            null_dic["liver"],value_dic["ovary"],null_dic["testis"]);
        var testis = null_dic["brain"].concat(null_dic["cerebellum"],null_dic["heart"],null_dic["kidney"],
            null_dic["liver"],null_dic["ovary"],value_dic["testis"]);

        $(function () {
            $('#development_plot').highcharts({
                chart: {
                    type: 'spline'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Development of 7 Organs from Early Organogenesis to Adulthood ("  + geneid + ")"
                },
                xAxis: {
                    categories: ["Four week","Five week","Seven week"
                        ,"Eight week","Nine week","Ten week","Eleven week",
                        "Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week"
                        ,"Twenty week","Neonate","Infant","Toddler","School age child","Adolescent","Young adult",
                        "Four week","Five week","Seven week","Eight week","Nine week","Ten week","Eleven week",
                        "Twelve week","Thirteen week","Sixteen week","Neonate","Infant","Toddler","School age child",
                        "Adolescent","Young adult","Four week","Five week","Six week","Seven week","Eight week",
                        "Nine week","Ten week", "Eleven week","Twelve week","Thirteen week","Sixteen week",
                        "Eighteen week","Nineteen week", "Neonate","Infant","Toddler","Adolescent","Young adult",
                        "Four week","Five week","Six week","Seven week","Eight week","Nine week","Ten week",
                        "Eleven week","Twelve week","Thirteen week","Sixteen week","Eighteen week","Nineteen week",
                        "Neonate","Infant","Toddler","School age child","Four week","Five week","Six week",
                        "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week",
                        "Sixteen week","Eighteen week","Nineteen week","Neonate","Infant","Toddler","School age child",
                        "Adolescent","Young adult","Middle adult","Elderly","Four week","Five week","Six week",
                        "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week",
                        "Thirteen week","Sixteen week","Eighteen week","Four week","Five week","Six week",
                        "Seven week","Eight week","Nine week","Ten week","Eleven week","Twelve week","Thirteen week",
                        "Sixteen week","Eighteen week","Nineteen week","Infant","Toddler","Adolescent","Young adult",
                        "Middle adult","Elderly"],
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
                        name: 'brain',
                        data: brain
                    },
                    {
                        name: 'cerebellum',
                        data: cerebellum
                    },
                    {
                        name: 'heart',
                        data: heart
                    },
                    {
                        name: 'kidney',
                        data: kidney
                    },
                    {
                        name: 'liver',
                        data: liver
                    },
                    {
                        name: 'testis',
                        data: testis
                    },
                    {
                        name: 'ovary',
                        data: ovary
                    }
                ],
                legend: {
                    enabled: true
                }
            });
        });
    }
});


