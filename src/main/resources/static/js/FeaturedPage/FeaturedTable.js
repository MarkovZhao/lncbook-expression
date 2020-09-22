$(function () {
    $.ajax({
        url: 'https://bigd.big.ac.cn/LncExpDB/featured/temporal',
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
            gene_arry['brain'] = gene_alter[i].brain;
            gene_arry['cerebellum'] = gene_alter[i].cerebellum;
            gene_arry['heart'] = gene_alter[i].heart;
            gene_arry['kidney'] = gene_alter[i].kidney;
            gene_arry['liver'] = gene_alter[i].liver;
            gene_arry['ovary'] = gene_alter[i].ovary;
            gene_arry['testis'] = gene_alter[i].testis;
            gene_info.push(gene_arry)
        }

        $('#temporal_table').DataTable( {
            data: gene_info,
            columns: [
                {data: 'geneid',
                    render: function (data, type, row) {
                        return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + row.geneid + "'target='_blank'>" + row.geneid + "</a>"
                    }
                },
                {data: 'genename'},
                {data: 'brain',
                    render: function (data, type, row) {
                        var values = data.split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'cerebellum',
                    render: function (data, type, row) {
                        var values = row["cerebellum"].split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'heart',
                    render: function (data, type, row) {
                        var values = row["heart"].split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'kidney',
                    render: function (data, type, row) {
                        var values = row["kidney"].split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent</label';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'liver',
                    render: function (data, type, row) {
                        var values = row["liver"].split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'ovary',
                    render: function (data, type, row) {
                        console.log(data)
                        var values = data.split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent</l';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'testis',
                    render: function (data, type, row) {
                        var values = row["testis"].split(";");
                        var temp = [];
                        if (values.length == 1) {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    return 'Consistent';
                                } else if (values[i] == "dynamic") {
                                    return 'Dynamic';
                                } else if (values[i] == "N/A") {
                                    return 'N/A'
                                } else {
                                    return values[i]
                                }
                            }
                        } else {
                            for (var i=0;i<values.length;i++) {
                                if (values[i] === "stable") {
                                    temp.push('Consistent')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-primary">stable</label>';
                                } else if (values[i] == "dynamic") {
                                    temp.push('Dynamic')
                                    // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-danger">dynamic</label>';
                                }  else
                                    temp.push(values[i])
                                // return '<a data-feature="' + values[i] + '" class="feature" id="ovary"><label class="label label-warning">' + values[i] + '</label>'
                            }
                            return temp.join("&nbsp");
                        }
                    }
                },
                {data: 'geneid',
                    render: function (data, type, row) {
                        return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + data + "'target='_blank'>" + data + "</a>"
                    }
                },
            ],
            dom: 'Bfrtip',
            buttons: [
                'copyHtml5',
                'csvHtml5',
            ],
            deferRender:    true,
            scroller:       true,
            "order": [],
            initComplete: function () {
                var r = $('#temporal_table tfoot tr');
                r.find('th').each(function(){
                    $(this).css('padding', 8);
                });
                $('#temporal_table thead').append(r);
                $('#search_0').css('text-align', 'center');

                this.api().columns([2,3,4,5, 6, 7,8]).every( function () {
                    var column = this;
                    var select = $('<select style="font-size: 10px"><option value="">Show All</option></select>')
                        .appendTo( $(column.footer()).empty() )
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );

                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );

                    column.data().unique().sort().each( function ( d, j ) {
                        if (d === "Stable") {
                            var tag = 'Consistent';
                        } else if (d === "dynamic") {
                            var tag = 'Dynamic';
                        } else if (d === "N/A") {
                            var tag = 'N/A';
                        } else {
                            var tag = d
                        }
                        select.append( '<option value="'+tag+'">'+tag+'</option>' )
                    } );
                } );
            }
        } );
    }
});