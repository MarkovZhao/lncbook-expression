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
                    return "<a href='https://bigd.big.ac.cn/LncExpDB/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
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
                title: '<a href="/LncExpDB/help#structure" title="See more about contexts" target="_blank">Contexts <span class="glyphicon glyphicon-question-sign"></span></a>',
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

var url1 = "/LncExpDB/ce/interaction";
ce_table(url1)

// Select2
var url1 = "/LncExpDB/ce/interactionlncid";

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
        url1 = "/LncExpDB/ce/interactionlncid";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "lncname") {
        url1 = "/LncExpDB/ce/interactionlncname";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "pcgid") {
        url1 = "/LncExpDB/ce/interactionpcgid";
        $('#featurelnc').attr('data-placeholder', 'eg. ENSG00000152078.10');
    } else if ($('#feature_sect1').val() == "pcgname") {
        url1 = "/LncExpDB/ce/interactionpcgname";
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
    var url = '/LncExpDB/ce/interaction';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".filter").val();
    var url = '/LncExpDB/ce/interactionby' + v2 + '?term=' + dis;
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/LncExpDB/ce/interaction';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/LncExpDB/ce/interaction';
        ce_table(url)
    }
});