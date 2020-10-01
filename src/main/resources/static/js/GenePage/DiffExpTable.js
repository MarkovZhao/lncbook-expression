//Exosomes Differential Expression Table
var exosome_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/lncexpdb/de/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var data = data['geneInfo'];
        var ccle_info = [];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['basemean'] = data[i].basemean;
            gene_arry['log2foldchange'] = data[i].log2foldchange;
            gene_arry['lfcse'] = data[i].lfcse;
            gene_arry['stat'] = data[i].stat;
            gene_arry['pvalue'] = data[i].pvalue;
            gene_arry['padj'] = data[i].padj;
            ccle_info.push(gene_arry)
        }

        $('#exosome_table').DataTable({
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
                {data: 'basemean',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'log2foldchange',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'lfcse',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'stat',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'pvalue',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'padj',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
            ]
        });
    }
});
exosome_table("colorectal");
$("#exosome").on("change",function () {
    var tissue = $(this).val();
    exosome_table(tissue)
})

//Virus Differential Expression Table
var virus_table = (function (tissue) {
    var geneid = window.location.href.split("=")[1].split("#")[0];

    $.ajax({
        url: '/lncexpdb/de/' +  tissue + '?geneid=' + '\'' + geneid + '\'',
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: succFunction //成功执行方法
    });

    function succFunction(data) {
        var ccle_info = [];
        var data = data['geneInfo'];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['basemean'] = data[i].basemean;
            gene_arry['log2foldchange'] = data[i].log2foldchange;
            gene_arry['lfcse'] = data[i].lfcse;
            gene_arry['stat'] = data[i].stat;
            gene_arry['pvalue'] = data[i].pvalue;
            gene_arry['padj'] = data[i].padj;
            ccle_info.push(gene_arry)
        }

        $('#virus_table').DataTable({
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
                {data: 'basemean',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'log2foldchange',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'lfcse',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'stat',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'pvalue',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
                {data: 'padj',
                    render: function (data, type, row) {
                        return Number(data).toFixed(2)
                    }
                },
            ]
        });
    }
});
virus_table("sars2");
$("#virus").on("change",function () {
    var tissue = $(this).val();
    virus_table(tissue)
})
