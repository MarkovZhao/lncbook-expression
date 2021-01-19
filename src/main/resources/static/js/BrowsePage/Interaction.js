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
                title: 'PCG ID',
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
            {
                title: '<a href="/lncexpdb/help#structure" title="See more about contexts" target="_blank">Contexts <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'context',
                align: "center",
                // sortable: true,
            },
            {
                title: 'Breadth',
                field: 'breadth',
                align: "center",
                // sortable: true,
            },
        ]
    });
});

var url1 = "/lncexpdb/ce/interaction";
ce_table(url1)

// Select2
var url1 = "/lncexpdb/ce/interactionlncid";
var url_mRNA = "/lncexpdb/ce/interactionpcgid";
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

$('#featuremRNA').select2({
    minimumInputLength: 1,
    ajax: {
        url: url_mRNA,
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
        $('#featurelnc').removeAttr("disabled");
        url1 = "/lncexpdb/ce/interactionlncid";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "lncname") {
        $('#featurelnc').removeAttr("disabled");
        url1 = "/lncexpdb/ce/interactionlncname";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "all_lnc") {
        $('#featurelnc').attr('data-placeholder', '');
        $('#featurelnc').attr('disabled', 'disabled');
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

$('#feature_sect2').change(function () {
    var type = $('#ce_type').val();
    console.log(type)
    if ($('#feature_sect2').val() == "pcgid") {
        $('#featuremRNA').removeAttr("disabled");
        url1 = "/lncexpdb/ce/interactionpcgid";
        $('#featuremRNA').attr('data-placeholder', 'eg. ENSG00000152078.10');
    } else if ($('#feature_sect2').val() == "pcgname") {
        $('#featuremRNA').removeAttr("disabled");
        url1 = "/lncexpdb/ce/interactionpcgname";
        $('#featuremRNA').attr('data-placeholder', 'eg. TLCD4');
    } else {
        $('#featuremRNA').attr('disabled', 'disabled');
        $('#featuremRNA').attr('data-placeholder', '');
    }
    $('#featuremRNA').select2({
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
    var url = '/lncexpdb/ce/interaction';
    ce_table(url)
}

$('.lnc_filter').change(function () {
    var lnc_filter = $(".lnc_filter").val();
    var mRNA_filter = $(".mRNA_filter").val();
    var mRNA_dis = $(".mRNA_feature").val();
    console.log(lnc_filter)
    console.log(mRNA_filter)
    console.log(mRNA_dis)
    if (lnc_filter == "all_lnc") {
        console.log(lnc_filter)
        if (mRNA_filter == "all_pcg") {
            var url = '/lncexpdb/ce/interaction';
            console.log(url)
            ce_table(url)
        } else {
            var url = '/lncexpdb/ce/interactionby' + mRNA_filter + '?term=' + mRNA_dis;
            ce_table(url)
        }
    }
} )

$('.mRNA_filter').change(function () {
    var lnc_filter = $(".lnc_filter").val();
    var lnc_dis = $(".lnc_feature").val();
    var mRNA_filter = $(".mRNA_filter").val();
    var mRNA_dis = $(".mRNA_feature").val();
    console.log(lnc_filter)
    console.log(mRNA_filter)
    console.log(mRNA_dis)
    if (mRNA_filter == "all_pcg") {
        console.log(lnc_filter)
        if (lnc_filter == "all_lnc") {
            var url = '/lncexpdb/ce/interaction';
            console.log(url)
            ce_table(url)
        } else {
            var url = '/lncexpdb/ce/interactionby' + lnc_filter + '?term=' + lnc_dis;
            ce_table(url)
        }
    }
} )

$('.lnc_feature').change(function () {
    var dis = $('.lnc_feature').val();
    var v2 = $(".lnc_filter").val();
    var mRNA_dis = $('.mRNA_feature').val();
    var mRNA_v2 = $(".mRNA_filter").val();
    if (v2 == "all_lnc") {
        $('#featurelnc').attr('disabled', 'disabled');
    }
    if (v2 == "lncid") {
        if (mRNA_v2 == "all_pcg") {
            var url = '/lncexpdb/ce/interactionby' + v2 + '?term=' + dis;
            ce_table(url);
        } else if (mRNA_v2 == "pcgid") {
            var url = "/lncexpdb/ce/interactionbyall?pcg=\"" + mRNA_dis + "\"&geneid=\"" + dis + "\"";
            ce_table(url);
        } else {
            var url = "/lncexpdb/ce/interactionbyall?pcgname=\"" + mRNA_dis + "\"&geneid=\"" + dis + "\"";
            ce_table(url);
        }
    } else if (v2 == "lncname") {

        if (mRNA_v2 == "all_pcg") {
            var url = '/lncexpdb/ce/interactionby' + v2 + '?term=' + dis;
            console.log(url)
            ce_table(url);
        } else if (mRNA_v2 == "pcgid") {
            var url = "/lncexpdb/ce/interactionbyall?pcg=\"" + mRNA_dis + "\"&lncname=\"" + dis + "\"";
            console.log(url)
            ce_table(url);
        } else {
            var url = "/lncexpdb/ce/interactionbyall?pcgname=\"" + mRNA_dis + "\"&lncname=\"" + dis + "\"";
            console.log(url)
            ce_table(url);
        }
    }

    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/ce/interaction';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.lnc_feature').val();
    if(val=="" || val==null || val == ""){
        var url = '/lncexpdb/ce/interaction';
        ce_table(url)
    }
});


$('.mRNA_feature').change(function () {
    var dis = $('.lnc_feature').val();
    var v2 = $(".lnc_filter").val();
    var mRNA_dis = $('.mRNA_feature').val();
    var mRNA_v2 = $(".mRNA_filter").val();
    if (mRNA_v2 == "all_pcg") {
        $('#featuremRNA').attr('disabled', 'disabled');
    }
    if (mRNA_v2 == "pcgid") {
        if (v2 == "all_lnc") {
            var url = '/lncexpdb/ce/interactionby' + mRNA_v2 + '?term=' + mRNA_dis;
            ce_table(url);
        } else if (v2 == "lncid") {
            var url = "/lncexpdb/ce/interactionbyall?pcg=\"" + mRNA_dis + "\"&geneid=\"" + dis + "\"";
            ce_table(url);
        } else {
            var url = "/lncexpdb/ce/interactionbyall?pcg=\"" + mRNA_dis + "\"&lncname=\"" + dis + "\"";
            ce_table(url);
        }
    } else if (mRNA_v2 == "pcgname") {

        if (v2 == "all_lnc") {
            var url = '/lncexpdb/ce/interactionby' + mRNA_v2 + '?term=' + mRNA_dis;
            console.log(url)
            ce_table(url);
        } else if (v2 == "lncid") {
            var url = "/lncexpdb/ce/interactionbyall?pcgname=\"" + mRNA_dis + "\"&geneid=\"" + dis + "\"";
            console.log(url)
            ce_table(url);
        } else {
            var url = "/lncexpdb/ce/interactionbyall?pcgname=\"" + mRNA_dis + "\"&lncname=\"" + dis + "\"";
            console.log(url)
            ce_table(url);
        }
    }

    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/ce/interaction';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.lnc_feature').val();
    if(val=="" || val==null || val == ""){
        var url = '/lncexpdb/ce/interaction';
        ce_table(url)
    }
});