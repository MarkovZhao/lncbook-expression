//Transcripts 数据请求
// $(function () {
//     $.ajax({
//         url: '/LncExpDB/browse/lncall',
//         type: 'POST',
//         dataType: 'json',
//         cache: false,
//         error: erryFunction,  //错误执行方法
//         success: succFunction //成功执行方法
//     });
//     function erryFunction() {
//         alert("error");
//     }
//     function succFunction(data) {
//         var gene_alter = data['geneinfo'];
//         console.log(gene_alter);
//         var gene_info = [];
//         for(var i=0;i<gene_alter.length;i++){
//             var gene_arry = {};
//             gene_arry['geneid'] = gene_alter[i].geneid;
//             gene_arry['symbol'] = gene_alter[i].symbol;
//             gene_arry['classification'] = gene_alter[i].classification;
//             gene_arry['development'] = gene_alter[i].development;
//             gene_arry['preimplantation'] = gene_alter[i].preimplantation;
//             gene_arry['differentiation'] = gene_alter[i].differentiation;
//             gene_arry['exosome'] = gene_alter[i].exosome;
//             gene_arry['virus'] = gene_alter[i].virus;
//             gene_arry["normal"] = gene_alter[i].normal;
//             gene_arry['circadian'] = gene_alter[i].circadian;
//             gene_arry['ccle'] = gene_alter[i].ccle;
//             gene_arry['subcellular'] = gene_alter[i].subcellular;
//             gene_info.push(gene_arry)
//         }
//         console.log(data);
//
//         $('#featured_table').DataTable( {
//             data: gene_info,
//             columns: [
//                 {data: 'geneid',
//                     render: function (data, type, row) {
//                         return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + row.geneid + "'target='_blank'>" + row.geneid + "</a>"
//                     }
//                 },
//                 {data: 'symbol'},
//                 {data: 'classification'},
//                 {data: 'normal',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'development',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'preimplantation',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'differentiation',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'subcellular',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'exosome',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'ccle',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'virus',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//                 {data: 'circadian',
//                     render: function (data, type, row) {
//                         if (data === "True") {
//                             return '✔';
//                         } else {
//                             return "✘"
//                         }
//                     }
//                 },
//
//             ],
//             deferRender:    true,
//             scroller:       true,
//             "ordering": false,
//             "order": [],
//             initComplete: function () {
//                 var r = $('#featured_table tfoot tr');
//                 r.find('th').each(function(){
//                     $(this).css('padding', 8);
//                 });
//                 $('#featured_table thead').append(r);
//                 $('#search_0').css('text-align', 'center');
//
//                 this.api().columns([3,4,5, 6, 7,8,9,10,11]).every( function () {
//                     var column = this;
//                     var select = $('<select style="font-size: 10px"><option value="">Show All</option></select>')
//                         .appendTo( $(column.footer()).empty() )
//                         .on( 'change', function () {
//                             var val = $.fn.dataTable.util.escapeRegex(
//                                 $(this).val()
//                             );
//
//                             column
//                                 .search( val ? '^'+val+'$' : '', true, false )
//                                 .draw();
//                         } );
//
//                     column.data().unique().sort().each( function ( d, j ) {
//                         if (d === "True") {
//                             var tag = '✔';
//                         } else {
//                             var tag = "✘"
//                         }
//                         select.append( '<option value="'+tag+'">'+tag+'</option>' )
//                     } );
//                 } );
//             }
//         } );
//     }
// });

var ce_table = (function (url) {
    $('#featured_table').bootstrapTable('destroy');
    $('#featured_table').bootstrapTable({
        method: "post",
        url: url,
        striped: true, //是否显示行间隔色
        cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,//是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [10],
        search: false,
        dataField: "geneInfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        formatLoadingMessage: function () {
            return "<h4>Please wait...</h4>";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize,
                sortName: params.sortName,      //排序列名
                sortOrder: params.sortOrder     //排序
            };
            return param;
        },
        columns: [
            {
                title: 'Gene ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },

            },
            {
                title: 'Gene Symbol',
                field: 'symbol',
                align: "center",
            },

            {
                title: '<a href="/LncExpDB/help#classification" target="_blank" title' + '="Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into ' +
                    'seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, ' +
                    'and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs,' +
                    ' and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.">'+'Classification'+' ' +
                    '<span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'classification',
                align: "center",
            },

            {
                title: 'Normal Tissue/Cell Line',
                field: 'normal',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },

            },
            {
                title: 'Organ Development',
                field: 'development',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Preimplantation Embryo',
                field: 'preimplantation',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Cell Differentiation',
                field: 'differentiation',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Subcellular Localization',
                field: 'subcellular',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Exosome',
                field: 'exosome',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Cancer Cell Line',
                field: 'ccle',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Virus Infection',
                field: 'virus',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
            {
                title: 'Circadian Rhythm',
                field: 'circadian',
                align: "center",
                formatter: function (data, type, row) {
                    if (data === "True") {
                        return '✔';
                    } else {
                        return "✘"
                    }
                },
            },
        ]
    });
});

url1 = "/LncExpDB/browse/lncall"
ce_table(url1)

var url1 = "/LncExpDB/browse/geneidlist";

$('#featurelnc').select2({
    minimumInputLength: 1,
    ajax: {
        url: url1,
        data: function (params) {
            var query = {
                type: params.term
            };
            return query;
        },
        cache: false
    }
});

$('#feature_sect1').change(function () {

    if ($('#feature_sect1').val() == "geneid") {
        url1 = "/LncExpDB/browse/geneidlist";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "symbol") {
        url1 = "/LncExpDB/browse/symlist";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "classification") {
        url1 = "/LncExpDB/browse/classificationlist";
        $('#featurelnc').attr('data-placeholder', 'eg. Intergenic');
    }
    $('#featurelnc').select2({
        minimumInputLength: 1,
        ajax: {
            url: url1,
            data: function (params) {
                var query = {
                    type: params.term
                };
                return query;
            },
            cache: false
        }
    });
})


var list = document.getElementById("featurelnc");
if(list.options[0].value==""){
    var url = '/LncExpDB/browse/lncall';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".select_filter").val();
    var url = '/LncExpDB/browse/lncall?' +v2 + '=' + "'" + dis + "'";
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/LncExpDB/browse/lncall';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/LncExpDB/browse/lncall';
        ce_table(url)
    }
});

$('#classification').change(function () {
    var dis = $('#classification').val();
    if (dis != "All") {
        url_classification = '/LncExpDB/browse/classification' + "?term=" + encodeURIComponent(dis);
        ce_table(url_classification);
    }else{
        url = '/LncExpDB/browse/lncall';
        ce_table(url);
    }
})

$('.select').change(function () {
    var url = '/LncExpDB/browse/lncall?normal=' + "'" + $("#normal").val() + "'&development='" + $("#development").val() + "'&preimplantation='" + $("#preimplantation").val() + "'&differentiation='" + $("#differentiation").val() + "'&circadian='" + $("#circadian").val() + "'&ccle='" + $("#ccle").val() + "'&exosome='" + $("#exosome").val() + "'&virus='" + $("#virus").val() + "'&subcellular='" + $("#subcellular").val() + "'";
    console.log(url)
    ce_table(url);

});

$("#reset").on('click', function () {

    $('#normal').val("NA");
    $('#development').val("NA");
    $('#preimplantation').val("NA");
    $('#differentiation').val("NA");
    $('#subcellular').val("NA");
    $('#exosome').val("NA");
    $('#ccle').val("NA");
    $('#virus').val("NA");
    $('#circadian').val("NA");

    var url = "/LncExpDB/browse/lncall";
    ce_table(url);
});