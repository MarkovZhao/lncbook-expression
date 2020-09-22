//lncRNA 表达的数据请求

$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/LncExpDB/gene/exosome?geneid=' + geneid,
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
        var colors = ['rgba(93, 164, 214, 0.5)', 'rgba(255, 144, 14, 0.5)', 'rgba(44, 160, 101, 0.5)', 'rgba(255, 65, 54, 0.5)', 'rgba(207, 114, 255, 0.5)', 'rgba(127, 96, 0, 0.5)', 'rgba(255, 140, 184, 0.5)',
            'rgba(79, 90, 117, 0.5)', 'rgba(222, 223, 0, 0.5)'];
        var cancers = new Array();
        var ex_value = new Array();
        var gene_ex = data["exorbase"][0];

        for (var key in gene_ex) {
            var new_key = key.replace(/\d+/g,"");
            if (cancers.indexOf(new_key) < 0) {
                cancers.push(new_key);
            }
        }

        for (var i=1;i<cancers.length;i++) {
            var temp_list = new Array();
            var cancer = cancers[i];
            for (var key in gene_ex) {
                var new_key = key.replace(/\d+/g,"");
                if (cancer == new_key) {
                    temp_list.push(gene_ex[key])
                }
            }
            ex_value.push(temp_list);
        }

        // $("#gene_expression").html(value1.join(","))
        $(function () {
            var boxSize = $('#exosome_plot').width();
            var data = [];
            var cancers = ["GeneID","Normal","Hepatocellular \nCarcinoma","Pancreatic \nCarcinoma",
                "Colorectal Cancer","Coronary heart \ndisease"]
            for ( var i = 1; i < cancers.length; i ++ ) {
                var result = {
                    type: 'box',
                    y: ex_value[i-1],
                    name: cancers[i],
                    boxpoints: 'all',
                    jitter: 0.5,
                    whiskerwidth: 0.2,
                    fillcolor: 'cls',
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
                title: 'Exosomes from Disease Group and <br> Healthy Control ('  + geneid + ")",
                font: {
                    family: 'Arial, sans-serif',
                    size: 13,
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
                // width: 150,
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
                    tickangle: -30,
                    fontsize: 6,
                    fontFamily: 'Arial'
                },
                paper_bgcolor: 'rgb(255, 255, 255)',
                plot_bgcolor: 'rgb(255, 255, 255)',
                showlegend: false
            };

            Plotly.newPlot('exosome_plot', data, layout);

            window.addEventListener("resize",function() {
                var newBoxWidth = $('#exosome_plot').width();
                var newBoxLayout = {
                    title: 'Exosomes from Disease Group and <br> Healthy Control ('  + geneid + ")",
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
                        tickangle: -30,
                        fontsize: 6,
                        fontFamily: 'Arial'
                    },
                    paper_bgcolor: 'rgb(255, 255, 255)',
                    plot_bgcolor: 'rgb(255, 255, 255)',
                    showlegend: false
                };

                Plotly.newPlot('exosome_plot', data, newBoxLayout);
            });

        });
    }

});