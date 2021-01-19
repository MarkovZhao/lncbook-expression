$(function () {
    $.ajax({
        url: '/lncexpdb/hkts/srp150867',
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
            data: gene_info,
            columns: [
                {data: 'geneid',
                    render: function (data, type, row) {
                        return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + row.geneid + "'target='_blank'>" + row.geneid + "</a>"
                    }
                },
                {data: 'genename'},
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
                {data: 'geneid',
                    render: function (data, type, row) {
                        return "<a name='view_expression'  data-id='" + row.geneid + "'><span class=\"glyphicon glyphicon-plus\"></span></a>";

                    }
                },
            ],
            dom: 'Bfrtip',
            buttons: [
              'copyHtml5',
                {
                    text:'CSV',
                    extend: 'csvHtml5',
                    fieldSeparator: ',',
                    extension: '.csv'
                }
            ],
            deferRender:    true,
            scroller:       true,
            "order": [],
            initComplete: function () {
                var r = $('#hkts_table tfoot tr');
                r.find('th').each(function(){
                    $(this).css('padding', 8);
                });
                $('#hkts_table thead').append(r);
                $('#search_0').css('text-align', 'center');

                this.api().columns([2,3,4,5, 6, 7,8,9,10]).every( function () {
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
                        if (d === "Yes") {
                            var tag = '✔';
                        } else {
                            var tag = "✘"
                        }
                        select.append( '<option value="'+tag+'">'+tag+'</option>' )
                    } );
                } );
            }
        } );
    }
});

var ce_table = (function (url) {
    $('#ce_table').bootstrapTable('destroy');
    $('#ce_table').bootstrapTable({
        method: "post",
        url: url,
        striped: true, //是否显示行间隔色
        cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,//是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [5, 10, 20, 30],
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
                title: 'LncRNA ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true

            },
            {
                title: 'LncRNA Symbol',
                field: 'lncname',
                align: "center",
                // sortable: true
            },

            {
                title: 'LncRNA Location',
                field: 'lnclocation',
                align: "center",
                // sortable: true
            },

            {
                title: '<a title="PCG: Protein-Coding Gene">'+'PCG ID'+ ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'pcg',
                align: "center",
            },
            {
                title: 'PCG Symbol',
                field: 'pcgname',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://www.genecards.org/cgi-bin/carddisp.pl?gene=" + value + "'target='_blank'>" + value + "</a>"
                },
                // sortable: true,
            },
            {
                title: 'PCG Location',
                field: 'pcglocation',
                align: "center",
                // sortable: true,
            },
            {
                title: '<a title="Pearson Correlation Coefficient">R <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'pcc',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                },
            },
            {
                title: 'P value',
                field: 'pvalue',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                },
            },

            {
                title: '<a title="Trans indicates that lncRNA and PCG are located in different chromosomes.">Distance <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'distance',
                align: "center",
                formatter: function(value,row,index){
                    if (value==-1) {
                        return "<i>Trans</i>"
                    } else {
                        return value;
                    }
                },
            },
        ]
    });
});

var url1 = "/lncexpdb/ce/subcellular";
ce_table(url1)

if ($('#ce_chkBrowse').is(":checked")) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').show();
    $('#ce_hkr').show();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
}else if($('#ce_chkTissue').is(":checked")){
    $('#ce_tissuename').attr("disabled", false);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
}else if($('#ce_chkDiy').is(":checked")){
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", false);
    $('#ce_tau2').attr("disabled", false);
    $('#ce_cv1').attr("disabled", false);
    $('#ce_cv2').attr("disabled", false);
    $('#ce_minBreadth').attr("disabled", false);
    $('#ce_maxBreadth').attr("disabled", false);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    // $('#ce_tau').show();
    // $('#ce_reset').show()
}

$('#ce_chkBrowse').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').show();
    $('#ce_hkr').show();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
});

$('#ce_chkTissue').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", false);
    $('#ce_tau1').attr("disabled", true);
    $('#ce_tau2').attr("disabled", true);
    $('#ce_cv1').attr("disabled", true);
    $('#ce_cv2').attr("disabled", true);
    $('#ce_minBreadth').attr("disabled", true);
    $('#ce_maxBreadth').attr("disabled", true);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').hide();
    // $('#ce_reset').hide()
});

$('#ce_chkDiy').on('click', function (e) {
    $('#ce_tissuename').attr("disabled", true);
    $('#ce_tau1').attr("disabled", false);
    $('#ce_tau2').attr("disabled", false);
    $('#ce_cv1').attr("disabled", false);
    $('#ce_cv2').attr("disabled", false);
    $('#ce_minBreadth').attr("disabled", false);
    $('#ce_maxBreadth').attr("disabled", false);
    $('#ce_tsr').hide();
    $('#ce_hkr').hide();
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    // $('#ce_tau').show();
    // $('#ce_reset').show();
});

$('#ce_chkTissue').on("click", function () {
    var url_tissue = "/lncexpdb/hkts/subcellular/tissuename";
    console.log(url_tissue)
    $('#ce_tissuename').select2({
        ajax: {
            url: url_tissue,
            dataType: 'json'
        }
    });
});

$('#ce_hkr').on("click",function () {
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    $("#ce_table").bootstrapTable('refreshOptions', {url:'/lncexpdb/ce/subcellulardistance?start=-2&end=-0.1',  silent: true, pageNumber: 1, pageSize: 10});
});


$('#ce_tsr').click(function () {
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    $("#ce_table").bootstrapTable('refreshOptions', {url:'/lncexpdb/ce/subcellulardistance?start=0',  silent: true, pageNumber: 1, pageSize: 10});
});

$('#ce_tau').on('click', function () {
    $('#ce_tissuename').attr("disabled",true);
    var $btn = $(this).button("loading");
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    var pvalue = $('input[name="ce_tau2"]').val();
    var pcc = $('input[name="ce_minBreadth"]').val();
    var mindis = $('input[name="ce_cv1"]').val();
    var maxdis = $('input[name="ce_cv2"]').val();
    var url = '/lncexpdb/ce/subcellular' + 'filter?pvalue_start=0&pvalue_end=' + pvalue + '&pcc_start=' + pcc + '&pcc_end=1' + '&distance_start=' + mindis + '&distance_end=' + maxdis;
    $("#ce_table").bootstrapTable('refreshOptions', {url:url,  silent: true, pageNumber: 1, pageSize: 10});
    $btn.button("reset")
});

$("#ce_reset").on('click', function () {

    $('input[name="ce_tau1"]').val(0);
    $('input[name="ce_tau2"]').val(1);
    $('input[name="ce_cv1"]').val(0);
    $('input[name="ce_cv2"]').val(1);
    $('input[name="ce_minBreadth"]').val(0);
    $('input[name="ce_maxBreadth"]').val(1000);
    $("#featurelnc").empty();
    $('#featurelnc_cancel').hide();
    var url = "/lncexpdb/ce/subcellular";
    ce_table(url);
    var url_tissue = "/lncexpdb/ce/subcellular/tissuename";
    $('#ce_tissuename').select2({
        ajax: {
            url: url_tissue,
            dataType: 'json'
        }
    });
});

// Select2
var url1 = "/lncexpdb/ce/subcellularlncid";

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
    var type = $('#ce_type').val();
    console.log(type)
    if ($('#feature_sect1').val() == "lncid") {
        url1 = "/lncexpdb/ce/subcellularlncid";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "lncname") {
        url1 = "/lncexpdb/ce/subcellularlncname";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "pcgid") {
        url1 = "/lncexpdb/ce/subcellularpcgid";
        $('#featurelnc').attr('data-placeholder', 'eg. ENSG00000152078.10');
    } else if ($('#feature_sect1').val() == "pcgname") {
        url1 = "/lncexpdb/ce/subcellularpcgname";
        $('#featurelnc').attr('data-placeholder', 'eg. TLCD4');
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
    var url = '/lncexpdb/ce/subcellular';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".filter").val();
    var url = '/lncexpdb/ce/subcellularby' + v2 + '?term=' + dis;
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/ce/subcellular';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/lncexpdb/ce/subcellular';
        ce_table(url)
    }
});