//Circadian Table
$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/de/circadian?geneid=' + '\'' + geneid + '\'',
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
        var ccle_info = [];
        for(var i=0;i<data.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = data[i].geneid;
            gene_arry['jtk_pvalue'] = data[i].jtk_pvalue;
            gene_arry['jtk_bhq'] = data[i].jtk_bhq;
            gene_arry['jtk_period'] = data[i].jtk_period;
            gene_arry['jtk_adjphase'] = data[i].jtk_adjphase;
            gene_arry['jtk_amplitude'] = data[i].jtk_amplitude;
            gene_arry['ls_pvalue'] = data[i].ls_pvalue;
            gene_arry['ls_bhq'] = data[i].ls_bhq;
            gene_arry['ls_period'] = data[i].ls_period;
            gene_arry['ls_adjphase'] = data[i].ls_adjphase;
            gene_arry['ls_amplitude'] = data[i].ls_amplitude;

            gene_arry['meta2d_pvalue'] = data[i].meta2d_pvalue;
            gene_arry['meta2d_bhq'] = data[i].meta2d_bhq;
            gene_arry['meta2d_period'] = data[i].meta2d_period;
            gene_arry['meta2d_adjphase'] = data[i].meta2d_adjphase;
            gene_arry['meta2d_amplitude'] = data[i].meta2d_amplitude;
            ccle_info.push(gene_arry)
        }

        $('#circadian_table').DataTable({
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: ccle_info,
            columns: [
                {data: "geneid"},
                {data: 'jtk_pvalue',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'jtk_bhq',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'jtk_period'},
                {data: 'jtk_adjphase'},
                {data: 'jtk_amplitude',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'ls_pvalue',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'ls_bhq',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'ls_period'},
                {data: 'ls_adjphase',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'ls_amplitude',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'meta2d_pvalue',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'meta2d_bhq',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'meta2d_period'},
                {data: 'meta2d_adjphase',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
                {data: 'meta2d_amplitude',
                    render: function (data, type, row) {
                        return Number(data).toFixed(3)
                    }
                },
            ]
        });
    }
});