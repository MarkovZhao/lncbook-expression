//lncRNA 表达的数据请求
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/encode?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#encode_plot").html('<h4>Please wait...</h4>');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        var tissue_name = new Array();
        var ex_value = new Array();
        var gene_ex = data["encode"][0];

        for (var key in gene_ex) {
            tissue_name.push(key);
            ex_value.push(parseFloat(gene_ex[key]))
        }
        var name1 = tissue_name.slice(1,tissue_name.length);
        var value1 = ex_value.slice(1,ex_value.length);
        $(function () {
            $('#encode_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: "ENCODE Primary Cell Lines (" +  geneid + ")",
                    style:{
                        color:"#000000",
                        fontFamily:"Arial",
                        fontWeight:"bold",
                    }
                },
                xAxis: {
                    categories: ["Airway Epithelial","Aortic Smooth Muscle","Articular Chondrocyte of Knee Joint",
                    "Astrocyte","Bladder Microvascular Endothelial","Bronchial Epithelial","Bronchial Smooth Muscle",
                    "Bronchus Fibroblast of Lung","Cardiac Atrium Fibroblast","Cardiac Ventricle Fibroblast","Dermis Blood Vessel Endothelial",
                    "Dermis Microvascular Lymphatairwayic Vessel Endothelial","Dermis Lymphatic Vessel Endothelial",
                    "Endothelial Cell of Coronary Artery","Endometrial Microvascular Endothelial Cells","Eepithelial Cell of Alveolus of Lung",
                    "Epithelial Cell of Umbilical Artery","Epithelial Cell of Proximal Tubule","Fibroblast of Dermis","Fibroblast of Lung",
                    "Fibroblast of The Aortic Adventitia","Fibroblast of Villous Mesenchyme","Glomerular Endothelial",
                    "Hair Follicle Dermal Papilla Cell","Hair Follicular Keratinocyte","Kidney Epithelial","Lung Microvascular Endothelial",
                    "Mammary epithelial","Mammary microvascular endothelial","Melanocyte of skin","Mesangial","Mesenchymal Stem Cell of Adipose",
                    "Mesenchymal Stem Cell of The Bone Marrow","Mesenchymal Stem Cell of Wharton","Myometrial",
                    "Nasal Cavity Respiratory Epithelium Epithelial Cell of Viscerocr","Osteoblast","Pericardium Fibroblast","Pericyte","Placental Epithelial",
                    "Pulmonary Artery Endothelial","Regular Cardiac Myocyte","Renal Cortical Epithelial","Skeletal Muscle Myoblast","Skeletal Muscle Satellite","Smooth Muscle Cell of Bladder",
                    "Smooth Muscle Cell of The Coronary Artery","Smooth Muscle Cell of The Pulmonary Artery","Smooth Muscle Cell of The Umbilical Artery",
                    "Smooth Muscle Cell of Trachea","Subcutaneous Preadipocyte","Thoracic Aorta Endothelial","Tracheal Epithelial","Uterine Smooth Muscle",
                    "Vein Endothelial"],
                    lineColor: "#000000",
                    tickColor: "#000000",
                    style:{
                        fontSize: '17px',
                        color:"#000000",
                        fontWeight: 'bold',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -60,
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


