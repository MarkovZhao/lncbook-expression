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
                    return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },

            },
            {
                title: 'Gene Symbol',
                field: 'symbol',
                align: "center",
            },

            {
                title: '<a href="/lncexpdb/help#classification" target="_blank" title' + '="Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into ' +
                    'seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, ' +
                    'and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs,' +
                    ' and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.">'+'Classification'+' ' +
                    '<span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'classification',
                align: "center",
            },
            {
                title: 'Chart',
                field: 'geneid',
                formatter: function (value, row, index) {
                    return "<a name='view_expression'  data-id='" + row.geneid + "'><span class=\"glyphicon glyphicon-plus\"></span></a>";
                }

            },
            {
                title: 'Normal Tissue/Cell Line',
                field: 'normal',
            },
            {
                title: 'Organ Development',
                field: 'development',
            },
            {
                title: 'Preimplantation Embryo',
                field: 'preimplantation',
            },
            {
                title: 'Cell Differentiation',
                field: 'differentiation',
            },
            {
                title: 'Subcellular Localization',
                field: 'subcellular',
            },
            {
                title: 'Exosome',
                field: 'exosome',
            },
            {
                title: 'Cancer Cell Line',
                field: 'ccle',
            },
            {
                title: 'Virus Infection',
                field: 'virus',
            },
            {
                title: 'Circadian Rhythm',
                field: 'circadian',
            }
        ]
    });
});

url1 = "/lncexpdb/profile/allprofile"
ce_table(url1)

var url1 = "/lncexpdb/profile/geneidlist";

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
        url1 = "/lncexpdb/profile/geneidlist";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "symbol") {
        url1 = "/lncexpdb/profile/symlist";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "classification") {
        url1 = "/lncexpdb/profile/classificationidlist";
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
    var url = '/lncexpdb/profile/allprofile';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".select_filter").val();
    var url = '/lncexpdb/profile/allprofile?' +v2 + '=' + "'" + dis + "'";
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/lncexpdb/profile/allprofile';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/lncexpdb/profile/allprofile';
        ce_table(url)
    }
});

$('#classification').change(function () {
    var dis = $('#classification').val();
    if (dis != "All") {
        url_classification = '/lncexpdb/profile/classification' + "?term=" + encodeURIComponent(dis);
        ce_table(url_classification);
    }else{
        url = '/lncexpdb/profile/allprofile';
        ce_table(url);
    }
})

$('.select').change(function () {
    var url = '/lncexpdb/profile/allprofile?normal=' + "'" + $("#normal").val() + "'&development='" + $("#development").val() + "'&preimplantation='" + $("#preimplantation").val() + "'&differentiation='" + $("#differentiation").val() + "'&circadian='" + $("#circadian").val() + "'&ccle='" + $("#ccle").val() + "'&exosome='" + $("#exosome").val() + "'&virus='" + $("#virus").val() + "'&subcellular='" + $("#subcellular").val() + "'";
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

    var url = "/lncexpdb/profile/allprofile";
    ce_table(url);
});