var pattern_ce_table = (function (url) {
    $('#pattern_ce_table').bootstrapTable('destroy');
    $('#pattern_ce_table').bootstrapTable({
        method: "post",
        url: url,
        striped: true, //是否显示行间隔色
        cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,//是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        //pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [5, 10, 20, 30],
        search: false,
        dataField: "geneInfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        showExport: true,
        exportDataType: 'all',
        exportTypes:[ 'csv', 'txt'],
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
                field: 'lnc_name',
                align: "center",
                // sortable: true
            },

            {
                title: 'LncRNA Location',
                field: 'lnc_location',
                align: "center",
                // sortable: true
            },

            {
                title: 'PCG ID',
                field: 'pcg',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='https://bigd.big.ac.cn/lncexpdb/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
            },
            {
                title: 'PCG Symbol',
                field: 'pcg_name',
                align: "center",
                // sortable: true,
            },
            {
                title: 'PCG Location',
                field: 'pcg_location',
                align: "center",
                // sortable: true,
            },
            {
                title: 'PCC',
                field: 'pcc',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },
            {
                title: 'P value',
                field: 'pvalue',
                align: "center",
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(2)
                }
            },
            {
                title: 'Distance',
                field: 'distance',
                align: "center",
                sortable: true,
            },
        ]
    });
});

var url1 = "/lncexpdb/ce/brain";
pattern_ce_table(url1)

var datatype = "";
$("#filter").on('click',function () {
    var all_params = new Array();
    $(".datatype").each(function(){

        if ($(this).is(":checked")) {
            datatype = $(this).attr("id");
            $(this).attr("disabled","disabled");
            console.log(datatype);
        }
    });

    $(".pattern_filter_ce").each(function(){
        var param_name = $(this).attr("name");
        var param_data = $(this).val();
        if (param_data != "") {
            var param = param_name + '=' + param_data;
            console.log(param)
            all_params.push(param);
            console.log(all_params)
        }
    });
    if (all_params.length == 0) {
        var url = '/lncexpdb/ce/' + datatype;
    } else {
        var url = '/lncexpdb/ce/' + datatype + '?' + all_params.join("&");
    }
    console.log(url)
    pattern_ce_table(url);

    $(".check_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });

})

$("#pattern_reset_ce").on('click', function () {
    var url = "/lncexpdb/ce/" + datatype;
    pattern_ce_table(url);

});

$("#reset").on('click', function () {
    var url = "/lncexpdb/ce/brain";
    pattern_ce_table(url);

});