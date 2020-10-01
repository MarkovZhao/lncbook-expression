$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/hkts/srp150867byid?geneid=' + geneid,
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
        var gene_alter = data['geneinfo'];
        console.log(gene_alter);
        var gene_info = [];
        for(var i=0;i<gene_alter.length;i++){
            var gene_arry = {};
            gene_arry['geneid'] = gene_alter[i].geneid;
            gene_arry['genename'] = gene_alter[i].genename;
            gene_arry['erm'] = gene_alter[i].erm;
            gene_arry['kdel'] = gene_alter[i].kdel;
            gene_arry['lma'] = gene_alter[i].lma;
            gene_arry['mito'] = gene_alter[i].mito;
            gene_arry['nes'] = gene_alter[i].nes;
            gene_arry['nik'] = gene_alter[i].nik;
            gene_arry['nucleus'] = gene_alter[i].nucleus;
            gene_arry['nucpore'] = gene_alter[i].nucpore;
            gene_arry['omm'] = gene_alter[i].omm;
            gene_arry['breadth'] = gene_alter[i].breadth;
            gene_info.push(gene_arry)
        }
        console.log(data);

        $('#hkts_table').DataTable( {
            searching: false,
            lengthChange: false,
            paging: false,
            info: false,
            ordering:false,
            scrollX:false,
            AutoWidth:false,
            data: gene_info,
            columns: [
                {data: 'geneid',
                },
                {data: 'erm',
                    render: function (data, type, row) {
                        if (row.erm === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'kdel',
                    render: function (data, type, row) {
                        if (row.kdel === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'lma',
                    render: function (data, type, row) {
                        if (row.lma === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'mito',
                    render: function (data, type, row) {
                        if (row.mito === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'nes',
                    render: function (data, type, row) {
                        if (row.nes === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'nik',
                    render: function (data, type, row) {
                        if (row.nik === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'nucleus',
                    render: function (data, type, row) {
                        if (row.nucleus === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'nucpore',
                    render: function (data, type, row) {
                        if (row.nucpore === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'omm',
                    render: function (data, type, row) {
                        if (row.omm === "Yes") {
                            return '✔';
                        } else {
                            return "✘"
                        }
                    }
                },
                {data: 'breadth'},
            ],

        } );
    }
});

