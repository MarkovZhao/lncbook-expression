//Development Table
var development_pattern_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    console.log('/lncexpdb/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'')
    $.ajax({
        url: '/lncexpdb/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data["geneInfo"]
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['p_value'] = data[i].p_value;
            gene_arry['r_squared'] = data[i].r_squared;
            gene_arry['k_4'] = data[i].k_4;
            gene_arry['k_5'] = data[i].k_5;
            gene_arry['k_6'] = data[i].k_6;
            gene_arry['k_7'] = data[i].k_7;
            gene_arry['k_8'] = data[i].k_8;
            ccle_info.push(gene_arry)
        }

        $('#development_pattern_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            destroy: true,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'p_value',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'r_squared',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'k_4',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_5',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_6',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_7',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_8',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else if (data === "8"||data === "8.0") {
                            return "Cluster 8"
                        } else {
                            return "N/A"
                        }
                    }
                },
            ]
        });
    }
});
development_pattern_table("brain");
$("#development").on("change",function () {
    var tissue = $(this).val();
    console.log(tissue);
    development_pattern_table(tissue)
})

//Differentiation Table
var differentiation_pattern_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/lncexpdb/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data["geneInfo"]
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['p_value'] = data[i].p_value;
            gene_arry['r_squared'] = data[i].r_squared;
            gene_arry['k_4'] = data[i].k_4;
            gene_arry['k_5'] = data[i].k_5;
            gene_arry['k_6'] = data[i].k_6;
            gene_arry['k_7'] = data[i].k_7;
            gene_arry['k_8'] = data[i].k_8;
            ccle_info.push(gene_arry)
        }

        $('#differentiation_pattern_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            destroy: true,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'p_value',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'r_squared',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'k_4',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_5',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_6',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_7',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_8',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else if (data === "8"||data === "8.0") {
                            return "Cluster 8"
                        } else {
                            return "N/A"
                        }
                    }
                },
            ]
        });
    }
});
differentiation_pattern_table("differentiation")

//Preimplantation Table
var preimplantation_pattern_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/lncexpdb/pattern/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data["geneInfo"]
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['p_value'] = data[i].p_value;
            gene_arry['r_squared'] = data[i].r_squared;
            gene_arry['k_4'] = data[i].k_4;
            gene_arry['k_5'] = data[i].k_5;
            gene_arry['k_6'] = data[i].k_6;
            gene_arry['k_7'] = data[i].k_7;
            gene_arry['k_8'] = data[i].k_8;
            ccle_info.push(gene_arry)
        }

        $('#preimplantation_pattern_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            destroy: true,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'p_value',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'r_squared',
                    render: function (data, type, row) {
                        if (data === -1) {
                            return 'N/A';
                        }  else {
                            return Number(data).toFixed(2)
                        }
                    }
                },
                {data: 'k_4',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_5',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_6',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_7',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else {
                            return "N/A"
                        }
                    }
                },
                {data: 'k_8',
                    render: function (data, type, row) {
                        if (data === "1"||data === "1.0") {
                            return 'Cluster 1';
                        } else if (data === "2"||data === "2.0") {
                            return "Cluster 2"
                        } else if (data === "3"||data === "3.0") {
                            return "Cluster 3"
                        } else if (data === "4"||data === "4.0") {
                            return "Cluster 4"
                        } else if (data === "5"||data === "5.0") {
                            return "Cluster 5"
                        } else if (data === "6"||data === "6.0") {
                            return "Cluster 6"
                        } else if (data === "7"||data === "7.0") {
                            return "Cluster 7"
                        } else if (data === "8"||data === "8.0") {
                            return "Cluster 8"
                        } else {
                            return "N/A"
                        }
                    }
                },
            ]
        });
    }
});
preimplantation_pattern_table("preimplantation1");
$("#preimplantation").on("change",function () {
    var tissue = $(this).val();
    preimplantation_pattern_table(tissue)
})