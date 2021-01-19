//lncRNA 表达的数据请求
$(document).on("click", "a[name='view_expression']", function () {
    $("#expression_plot").show();
    $("a[name='hide_expression']").html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $("a[name='hide_expression']").attr("name","view_expression");
    $(this).html("<span class=\"glyphicon glyphicon-minus\"></span>");
    $(this).attr("name","hide_expression");
    var geneid = $(this).data("id");

    $.ajax({
        url: '/lncexpdb/gene/ccle?geneid=' + geneid,
        type: 'POST',
        dataType: 'json',
        cache: false,
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    });

    function erryFunction() {
        alert("error");
    }
    function succFunction(data) {
        // var colors = ['rgba(93, 164, 214, 0.5)', 'rgba(255, 144, 14, 0.5)', 'rgba(44, 160, 101, 0.5)', 'rgba(255, 65, 54, 0.5)', 'rgba(207, 114, 255, 0.5)', 'rgba(127, 96, 0, 0.5)', 'rgba(255, 140, 184, 0.5)',
        //     'rgba(79, 90, 117, 0.5)', 'rgba(222, 223, 0, 0.5)'];

        var ex_value = new Array();

        for (var cancer in data) {
            var temp_list = new Array();
            var gene_ex = data[cancer][0];
            for (var key in gene_ex) {
                temp_list.push(parseFloat(gene_ex[key]))
            }
            ex_value.push(temp_list.slice(1,temp_list.length));
        }
        // $("#gene_expression").html(value1.join(","))
        $(function () {
            var boxSize = $('#expression_plot').width();
            var data = [];
            var cancers = ["ALL","Bile duct","BLCA","BRCA","CESC","CLL","COAD/READ","Colorectal","DLBC", "ESCA",
                "Ewings Sarcoma","GBM","Giant Cell Tumor","Glioma","HNSC", "KIRC","LAML","Leukemia Other","LCML","LGG",
                "LIHC", "LUAD", "Lung_NSC","LUSC","Lymphoma Other","Lymphoma Hodgkin","MB","Melanoma","Meningioma",
                "MESO","Mesothelioma","MM","N/A","NB","OV", "Ovary","PAAD","Pancreas","PRAD", "SARC","SCLC","SKCM",
                "Soft Tissle", "STAD","THCA","UCEC","Urinary Tract","Upper Aerodigestive"]

            for ( var i = 0; i < 48; i ++ ) {
                var result = {
                    type: 'violin',
                    y: ex_value[i],
                    name: cancers[i],
                    hoveron: "points+kde",
                    // fillcolor: 'cls',
                    points: true,
                    meanline: { visible: true },
                    line: { color: 'rgba(43, 140, 190)' },
                    box: {
                        visible: true,
                        fillcolor: '#ffff',
                        line: {color: 'rgb(255, 255, 255)'}
                    },
                    marker: {
                        size: 2
                    },
                    line: {
                        width: 1
                    }
                };
                data.push(result);
            };

            layout = {
                title: 'Cancer cell lines (' + geneid + ")",
                font: {
                    family: 'Arial, sans-serif',
                    size: 14,
                    color: '#000000'
                },
                yaxis: {
                    autorange: true,
                    showgrid: true,
                    zeroline: true,
                    dtick: 5,
                    gridcolor: 'rgb(255, 255, 255)',
                    gridwidth: 1,
                    zerolinecolor: 'rgb(255, 255, 255)',
                    zerolinewidth: 2
                },
                height: 400,
                width: boxSize,
                margin: {
                    l: 40,
                    r: 30,
                    b: 122,
                    t: 30
                },
                yaxis: {
                    title: 'TPM',
                    zeroline: false
                },
                xaxis: {
                    tickangle: -45,
                    fontsize: 20,
                    font: {
                        family: 'Arial, sans-serif',
                        size: 20,
                        color: 'grey',
                    },
                    fontFamily: 'Arial',
                    autorange: true,
                },
                paper_bgcolor: 'rgb(255, 255, 255)',
                plot_bgcolor: 'rgb(255, 255, 255)',
                showlegend: false
            };

            var config = {
                toImageButtonOptions: {
                    format: 'svg',
                    filename: "Expression profile of cancer cell lines of " + geneid,
                    width: 1340,
                    height: 550,
                },
                displaylogo: false,
                displayModeBar: true,
                modeBarButtonsToRemove: ['zoom2d', "zoomIn2d", "zoomOut2d", "autoScale2d",
                    "hoverClosestCartesian", "hoverCompareCartesian"],
                responsive: true
            };

            Plotly.newPlot('expression_plot', data, layout,config);
            window.addEventListener("resize",function() {
                var newBoxWidth = $('#cell_line_plot').width();
                var newBoxLayout = {
                    title: 'Expression profile of exosomes during normal and cancer group',
                    yaxis: {
                        autorange: true,
                        showgrid: true,
                        zeroline: true,
                        dtick: 5,
                        gridcolor: 'rgb(255, 255, 255)',
                        gridwidth: 1,
                        zerolinecolor: 'rgb(255, 255, 255)',
                        zerolinewidth: 2
                    },
                    height: 400,
                    // width: newBoxWidth,
                    width: newBoxWidth,
                    margin: {
                        l: 40,
                        r: 30,
                        b: 122,
                        t: 30
                    },
                    yaxis: {
                        title: 'TPM',
                        zeroline: false
                    },
                    xaxis: {
                        tickangle: -45,
                        fontsize: 20,
                        fontFamily: 'Arial'
                    },
                    paper_bgcolor: 'rgb(255, 255, 255)',
                    plot_bgcolor: 'rgb(255, 255, 255)',
                    showlegend: false
                };

                Plotly.newPlot('expression_plot', data, newBoxLayout,config);
            });

        });
    }

});

$(document).on("click", "a[name='hide_expression']", function () {
    $("#expression_plot").hide();
    $(this).html("<span class=\"glyphicon glyphicon-plus\"></span>");
    $(this).attr("name","view_expression");
});