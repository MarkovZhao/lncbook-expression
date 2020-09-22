// hpa lncRNA expression 数据请求
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/hpaTranscriptExpression?transid=' + transid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#transcript_expression").html('loading...');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {

        // var tissue_name = new Array();
        var ex_value = new Array();
        var trans_ex = data["hpaTransExpression"][0];

        for (var key in trans_ex) {
            // tissue_name.push(key);
            ex_value.push(parseFloat(trans_ex[key]))
        }
        // var name1 = tissue_name.slice(1,33);
        var value1 = ex_value.slice(1,33);
        // $("#transcript_expression").html(value1.join(","));
        $(function () {
            $('#transcript_expression').highcharts({
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Data Set: HPA'
                },
                credits: {
                    text: '',
                    href: 'http://www.example.com'
                },
                xAxis: {
                    categories:['Adipose Tissue', 'Adrenal','Appendix','Bone Marrow','Brain','Colon','Duodenum','Endometrium','Esophagus','Fallpian Tube','Gall Bladder',
                    'Heart','Kidney','Liver','Lung','LymphNode','Ovary','Pancreas','Placenta','Prostate Gland','Rectum','Saliva Secreting Gland','Skeletal Muscle','Small Intestine',
                    'Smooth Muscle Tissue','Spleen','Stomach','Testis','Thyroid Gland','Tonsil','Urinary Bladder','Zone of Skin'],
                    style:{
                        fontSize: '13px',
                        fontFamily: 'Arial, sans-serif'
                    },
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'FPKM',
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Arial, sans-serif'
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
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
                    name: 'HPA',
                    data: value1
                }],
                legend: {
                    enabled: false
                }
            });
        });
    }
});

// GTEx lncRNA expression 数据请求

$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/gtextrans?transid=' + transid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });
    function LoadFunction() {
        $("#transcript_expression").html('loading...');
    }
    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        // console.log(data.gtexTransExpression.length);
        if(data.gtexTransExpression.length ===0){
            return "";
        }else{
            // $("#gtex").append("<h4 class=\"passage-header\" >Expression <a href=\"https://www.gtexportal.org/\" target=\"_blank\">(Data Source: The Genotype-Tissue Expression project)</a></h4>");

            // var gtex_tissue = new Array();
            var ex_value = new Array();
            var gtex_ex = data["gtexTransExpression"][0];

            for (var key in gtex_ex) {
                // gtex_tissue.push(key);
                ex_value.push(parseFloat(gtex_ex[key]))
            }
            // var name1 = gtex_tissue.slice(1, 54);
            var value1 = ex_value.slice(1, 54);
            // $("#transcript_expression").html(value1.join(","))
            $(function () {
                $('#gtex_expression').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Data Set: GTEx'
                    },
                    credits: {
                        text: '',
                        href: 'http://www.example.com'
                    },
                    xAxis: {
                        categories: ['Adipose Subcutaneous', 'Adipose Visceral(Omentum)', 'Adrenal Gland', 'Artery Aorta', 'Artery Coronary', 'Artery Tibial', 'Bladder', 'Brain Amygdala', 'Brain Anteriorcingulatecortex(BA24)', 'Brain-Caudate(basalganglia)', 'Brain Cerebellar Hemisphere', 'Brain Cerebellum', 'Brain Cortex', 'Brain FrontalCortex(BA9)', 'Brain Hippocampus', 'Brain Hypothalamus', 'Brain Nucleusaccumbens(basalganglia)', 'Brain Putamen(basalganglia)', 'Brain Spinalcord(cervicalc-1)', 'Brain Substantianigra', 'Breast Mammary Tissue', 'Cells EBV transformedlymphocytes', 'Cells Transformedfibroblasts', 'Cervix Ectocervix', 'Cervix Endocervix', 'Colon Sigmoid', 'Colon Transverse', 'Esophagus GastroesophagealJunction', 'Esophagus Mucosa', 'Esophagus Muscularis', 'Fallopian Tube', 'Heart Atrial Appendage', 'Heart Left Ventricle', 'Kidney Cortex', 'Liver', 'Lung', 'Minor Salivary Gland', 'Muscle Skeletal', 'Nerve Tibial', 'Ovary', 'Pancreas', 'Pituitary', 'Prostate', 'Skin NotSunExposed(Suprapubic)', 'Skin SunExposed(Lowerleg)', 'Small Intestine TerminalIleum', 'Spleen', 'Stomach', 'Testis', 'Thyroid', 'Uterus', 'Vagina', 'WholeBlood'],
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Arial, sans-serif'
                        },
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'TPM',
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Arial, sans-serif'
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
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
                        name: 'GTEx',
                        data: value1
                    }],
                    legend: {
                        enabled: false
                    }
                });
            });
        }
    }
});