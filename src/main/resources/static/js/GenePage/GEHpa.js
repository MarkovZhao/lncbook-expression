//lncRNA 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/hpa?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#hpa_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["hpa"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,tissue_name.length);
        var value1 = ex_value.slice(1,ex_value.length);
        $(function () {
            $('#hpa_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "Normal Tissues from The Human Protein Atlas (" +  geneid + ")",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight:"bold",
                    }
                },
                xAxis: {
                    categories: ["Brain","Lung","Urinary Bladder","Kidney","Adrenal","Thyroid Gland","Heart",
                        "Lymphnode","Spleen","Bone Marrow","Tonsil","Appendix","Colon","Esophagus",
                        "Gall Bladder","Small Intestine","Saliva Secreting Gland","Stomach","Liver",
                        "Duodenum","Pancreas","Rectum","Endometrium","Ovary","Testis","Prostate Gland",
                        "Placenta","Fallpian Tube","Skeletal Muscle","Smooth Muscle Tissue","Zone of Skin","Fat"],
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


