var spatialtable = (function (url) {
    $('#spatial_table').bootstrapTable('destroy');
    $('#spatial_table').bootstrapTable({
        contentType: "application/x-www-form-urlencoded",
        method: "get",
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
        dataView: true,
        dataField: "geneInfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        formatLoadingMessage: function () {
            return "please waiting";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize
            };
            return param;
        },
        columns: [
            [{
                title: 'Gene ID',
                field: 'geneid',
                align: "center",
                formatter: function(value,row,index){
                    return "<a href='/gene?geneid=" + value + "'target='_blank'>" + value + "</a>"
                },
                colspan: 1,
                rowspan: 2,
                // sortable: true

            },
                {
                    title: 'Cancer Cell Line Association',
                    field: 'ccle',
                    colspan:1,
                    rowspan:2,
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "housekeeping") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="ccle"><label class="label label-primary">housekeeping</label>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        } else {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="ccle"><label class="label label-warning">' + value +'</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'Subcellular Association',
                    field: 'subcellular',
                    colspan:1,
                    rowspan:2,
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "housekeeping") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="subcellular"><label class="label label-primary">housekeeping</label>';
                        } else if (value == "NA") {
                            return '<label class="label label-default">N/A</label>'
                        } else {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="subcellular"><label class="label label-warning">' + value +'</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'Exosome-Assoicated',
                    field: 'development_association',
                    colspan:5,
                    rowspan:1,
                    align: "center",
                    // sortable: true
                },
                {
                    title: 'Virus Infection',
                    field: 'Preimplantation',
                    colspan:4,
                    rowspan:1,
                    align: "center",
                    // sortable: true
                }],

            [{
                title: 'Colorectal',
                field: 'colorectal',
                align: "center",
                formatter:function( value,row,index){
                    if (value === "upregulated") {
                        return '<a data-feature="' + value + '" class="spatial_feature" id="colorectal"><label class="label label-danger">Upregulated</label>';
                    } else if (value == "downregulated"){
                        return '<a data-feature="' + value + '" class="spatial_feature" id="colorectal"><label class="label label-primary">Downregulated</label></a>';
                    } else if (value == "NA") {
                        return '<label class="label">N/A</label>'
                    }
                },
                // sortable: true
                },
                {
                    title: 'Coronary',
                    field: 'coronary',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="coronary"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="coronary"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'Pancreatic',
                    field: 'pancreatic',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="pancreatic"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="pancreatic"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'Hepatocellular',
                    field: 'hepatocellular',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hepatocellular"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hepatocellular"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'ESCC',
                    field: 'escc',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="escc"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="escc"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'HIV',
                    field: 'hiv1',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hiv1"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hiv1"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'HBV',
                    field: 'hbv',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hbv"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hbv"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'HCV',
                    field: 'hcv',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hcv"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="hcv"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
                {
                    title: 'SARS-CoV2',
                    field: 'sars2',
                    align: "center",
                    formatter:function( value,row,index){
                        if (value === "upregulated") {
                            return '<a data-feature="' + value + '" class="spatial_feature" id="sars2"><label class="label label-danger">Upregulated</label>';
                        } else if (value == "downregulated"){
                            return '<a data-feature="' + value + '" class="spatial_feature" id="sars2"><label class="label label-primary">Downregulated</label></a>';
                        } else if (value == "NA") {
                            return '<label class="label">N/A</label>'
                        }
                    },
                    // sortable: true
                },
            ],

        ]
    });
});

var url3 = "http://localhost:8080/featured/spatial";
spatialtable(url3);

var all_params = new Array();
$(document).on("click", ".spatial_feature", function () {
    var value = $(this).attr("data-feature");
    var name = $(this).attr("id")

    $(".spatial_datatype").each(function(){
        if (name == $(this).attr("id")) {
            $(this).attr("disabled", "disabled");
            $(this).attr('checked', true);
        }
    });

    var param = name + '=' + '\'' + value + '\'';

    if (!all_params.length) {
        all_params = all_params.concat(param);
    } else if (all_params.join("&").indexOf(name) < 0 ) {
        all_params = all_params.concat(param);
    }

    var url = 'http://localhost:8080/featured/spatial/?' + all_params.join("&");
    spatialtable(url);
    if (value ==="dynamic") {
        var class_replace = "label label-danger"
    } else if (value === "stable") {
        class_replace = "label label-primary"
    } else {
        class_replace = "label label-warning"
    }
    $('#cancel_brain_label').removeClass();
    $('#cancel_brain_label').addClass(class_replace);
    $('#cancel_brain_label').addClass("name");
    $('#cancel_brain_label').text(value);

    $('#cancel_brain').show();

});

$("#cancel_brain").on("click",function () {
    var remove_name = $(this).attr("id").split("_")[1]
    console.log($(this).attr("id"));
    console.log(remove_name);
    for (var i=0; i<test.length;i++) {
        if (test[i].indexOf(remove_name)) {
            test = test.splice(test.indexOf(remove_name),1);
        }
    }
    console.log(test);
    $('#cancel_brain').hide();
});

var all_params = new Array();
$("#spatial_filter").on('click',function () {
    var param_list = new Array();
    var datatype_list = new Array();
    $(".spatial_datatype").each(function(){
        console.log(!$(this).prop("disabled"));
        if ($(this).is(":checked") && (!$(this).prop("disabled"))) {
            datatype_list.push($(this).attr("id"));
            $(this).attr("disabled","disabled");
            console.log(datatype_list);
        }
    });
    var check_feature = "";
    $(".check_spatial_feature").each(function(){
        if ($(this).is(":checked")) {
            check_feature = $(this).attr("id");
        }
    });
    for (var i=0;i<datatype_list.length;i++) {
        param_list.push(datatype_list[i]+ '=' + '\'' + check_feature + '\'');
    }
    all_params = all_params.concat(param_list);
    var url = 'http://localhost:8080/featured/spatial/?' + all_params.join("&");
    spatialtable(url);

    $(".check_spatial_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });

})

$(".check_spatial_feature").on('click',function () {

    if ($("#housekeeping").is(":checked")) {
        $("#upregulated").attr("disabled","disabled");
        $("#downregulated").attr("disabled","disabled");
    }

    else if ($("#upregulated").is(":checked")) {
        $("#housekeeping").attr("disabled","disabled");
        $("#downregulated").attr("disabled","disabled");
    }

    else if ($("#downregulated").is(":checked")) {
        $("#upregulated").attr("disabled","disabled");
        $("#housekeeping").attr("disabled","disabled");
    }

    else if (!$("#housekeeping").is(":checked")) {
        $("#housekeeping").removeAttr("disabled");
        $("#upregulated").removeAttr("disabled");
        $("#downregulated").removeAttr("disabled");
    }

    else if (!$("#upregulated").is(":checked")) {
        $("#upregulated").removeAttr("disabled");
        $("#housekeeping").removeAttr("disabled");
        $("#downregulated").removeAttr("disabled");
    }

    else if (!$("#downregulated").is(":checked")) {
        $("#downregulated").removeAttr("disabled");
        $("#housekeeping").removeAttr("disabled");
        $("#upregulated").removeAttr("disabled");
    }
})

$("#spatial_reset").on('click', function () {
    test = [];
    all_params = [];
    $(".spatial_datatype").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });
    $(".check_spatial_feature").each(function(){
        $(this).removeAttr("disabled");
        $(this).attr('checked',false);
    });
    var url = "http://localhost:8080/featured/spatial";
    spatialtable(url);
});

