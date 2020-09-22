//lncRNA 表达的数据请求
$(document).on("click", "a[name='view_expression']", function () {
    $("#expression_plot").show();
    $("a[name='hide_expression']").html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $("a[name='hide_expression']").attr("name","view_expression");
    $(this).html("<span class=\"glyphicon glyphicon-minus\"></span>");
    $(this).attr("name","hide_expression");
    var geneid = $(this).data("id");
    var type = $("#type").val();

    $.ajax({
        url: '/LncExpDB/gene/' + type + '?geneid=' + geneid,
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
        var time_points = new Array();
        var ex_value = new Array();
        if (type == "hpa") {
            var data_set = "hpa";
            var tag = "HPA";
            var angle = 30;
            var title = "Normal Tissues from The Human Protein Atlas ("  + geneid + ")"
            var category = ["Brain","Lung","Urinary Bladder","Kidney","Adrenal","Thyroid Gland","Heart",
                    "Lymphnode","Spleen","Bone Marrow","Tonsil","Appendix","Colon","Esophagus",
                    "Gall Bladder","Small Intestine","Saliva Secreting Gland","Stomach","Liver",
                    "Duodenum","Pancreas","Rectum","Endometrium","Ovary","Testis","Prostate Gland",
                    "Placenta","Fallpian Tube","Skeletal Muscle","Smooth Muscle Tissue","Zone of Skin","Fat"];
        } else {
            var data_set = "encode";
            var tag = "ENCODE";
            var angle = 60;
            var title = "ENCODE Primary Cell Lines ("  + geneid + ")"
            var category = ["Airway epithelial","Aortic smooth muscle","Articular chondrocyte of knee joint",
                "Astrocyte","Bladder microvascular endothelial","Bronchial epithelial","Bronchial smooth muscle",
                "Bronchus fibroblast of lung","Cardiac atrium fibroblast","Cardiac ventricle fibroblast","Dermis blood vessel endothelial",
                "Dermis microvascular lymphatic vessel endothelial","Dermis lymphatic vessel endothelial",
                "Endothelial cell of coronary artery","Endometrial microvascular endothelial cells","Eepithelial cell of alveolus of lung",
                "Epithelial cell of umbilical artery","Epithelial cell of proximal tubule","Fibroblast of dermis","Fibroblast of lung",
                "Fibroblast of the aortic adventitia","Fibroblast of villous mesenchyme","Glomerular endothelial",
                "Hair follicle dermal papilla cell","Hair follicular keratinocyte","Kidney epithelial","Lung microvascular endothelial",
                "Mammary epithelial","Mammary microvascular endothelial","Melanocyte of skin","Mesangial","Mesenchymal stem cell of adipose",
                "Mesenchymal stem cell of the bone marrow","Mesenchymal stem cell of Wharton","Myometrial",
                "Nasal cavity respiratory epithelium epithelial cell of viscerocr","Osteoblast","Pericardium fibroblast","Pericyte","Placental epithelial",
                "Pulmonary artery endothelial","Regular cardiac myocyte","Renal cortical epithelial","Skeletal muscle satellite","Smooth muscle cell of bladder",
                "Smooth muscle cell of the coronary artery","Smooth muscle cell of the pulmonary artery","Smooth muscle cell of the umbilical artery",
                "Smooth muscle cell of trachea","Subcutaneous preadipocyte","Thoracic aorta endothelial","Tracheal epithelial","Uterine smooth muscle",
                "Vein endothelial"];
        }
        var gene_ex = data[data_set][0];

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
            ex_value.push(tpm);

        }

        var name1 = time_points.slice(1,time_points.length);

        var value1 = ex_value;
        $(function () {
            $('#expression_plot').highcharts({
                chart: {
                    type: 'column'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                title: { text: title
                },
                xAxis: {
                    categories: category,
                    style:{
                        fontSize: '17px',
                        fontFamily: 'Arial, sans-serif'
                    },
                    labels: {
                        rotation: -angle,
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
                    name: "TPM",
                    data: value1,
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