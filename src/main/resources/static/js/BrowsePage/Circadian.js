var hkts_table = (function (url) {
    $('#hkts_table').bootstrapTable('destroy');
    $('#hkts_table').bootstrapTable({
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
        search: true,
        showColumns:true,
        dataField: "geneInfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "client",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        formatLoadingMessage: function () {
            return "<h4>Please wait...</h4>";
        },
        queryParams: function queryParams(params) {
            var param ={
                page: params.pageNumber-1,
                size: params.pageSize,
                sortName: params.sortName,      //排序列名
                sortOrder: params.sortOrder,     //排序
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
                // sortable: true

            },
            {
              title: 'Gene Symbol',
              field: 'symbol',
              align: 'center'
            },
            {
                title: '<a title="Meta2d is a function that incorporates ARSER, JTK_CYCLE and Lomb-Scargle to detect rhythmic\n' +
                    'signals from time-series datasets.">Meta2d pvalue <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'meta2d_pvalue',
                align: "center",
                visible: true,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: '<a title="FDR based on integrated pvalue">Meta2d BH.Q <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'meta2d_bhq',
                align: "center",
                visible: true,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'Meta2d Period',
                field: 'meta2d_period',
                visible: true,
                align: "center",
                sortable: true,
            },
            {
                title: 'Meta2d adjphase',
                field: 'meta2d_adjphase',
                align: "center",
                visible: true,
                sortable: true,
            },
            {
                title: 'Meta2d Amplitude',
                field: 'meta2d_amplitude',
                align: "center",
                visible: true,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'JTK pvalue',
                field: 'jtk_pvalue',
                align: "center",
                sortable: true,
                visible: false,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'JTK BH.Q',
                field: 'jtk_bhq',
                align: "center",
                sortable: true,
                visible: false,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'JTK Period',
                field: 'jtk_period',
                align: "center",
                sortable: true,
                visible: false,
            },
            {
                title: 'JTK adjphase',
                field: 'jtk_adjphase',
                align: "center",
                sortable: true,
                visible: false,
            },
            {
                title: 'JTK Amplitude',
                field: 'jtk_amplitude',
                align: "center",
                sortable: true,
                visible: false,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'LS pvalue',
                field: 'ls_pvalue',
                align: "center",
                visible: false,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'LS BH.Q',
                field: 'ls_bhq',
                align: "center",
                visible: false,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'LS Period',
                field: 'ls_period',
                visible: false,
                align: "center",
                sortable: true,
            },
            {
                title: 'LS adjphase',
                field: 'ls_adjphase',
                align: "center",
                visible: false,
                sortable: true,
            },
            {
                title: 'LS Amplitude',
                field: 'ls_amplitude',
                align: "center",
                visible: false,
                sortable: true,
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },

            {
                title: 'Chart',
                field: 'ls_amplitude',
                align: "center",
                formatter: function (value, row, index) {
                    return "<a name='view_expression'  data-id='" + row.geneid + "'><span class=\"glyphicon glyphicon-plus\"></span></a>";
                }
            },
        ]
    });
});

var url1 = "/LncExpDB/de/circadian";
hkts_table(url1)

if ($('#chkBrowse').is(":checked")) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').show();
    $('#hkr').show();
    // $('#tau').hide();
    // $('#reset').hide()
}else if($('#chkTissue').is(":checked")){
    $('#tissuename').attr("disabled", false);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').hide();
    $('#hkr').hide();
    // $('#tau').hide();
    // $('#reset').hide()
}else if($('#chkDiy').is(":checked")){
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", false);
    $('#tau2').attr("disabled", false);
    $('#cv1').attr("disabled", false);
    $('#cv2').attr("disabled", false);
    $('#minBreadth').attr("disabled", false);
    $('#maxBreadth').attr("disabled", false);
    $('#tsr').hide();
    $('#hkr').hide();
    // $('#tau').show();
    // $('#reset').show()
}

$('#chkBrowse').on('click', function (e) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').show();
    $('#hkr').show();
    // $('#tau').hide();
    // $('#reset').hide()
});

$('#chkTissue').on('click', function (e) {
    $('#tissuename').attr("disabled", false);
    $('#tau1').attr("disabled", true);
    $('#tau2').attr("disabled", true);
    $('#cv1').attr("disabled", true);
    $('#cv2').attr("disabled", true);
    $('#minBreadth').attr("disabled", true);
    $('#maxBreadth').attr("disabled", true);
    $('#tsr').hide();
    $('#hkr').hide();
    // $('#tau').hide();
    // $('#reset').hide()
});

$('#chkDiy').on('click', function (e) {
    $('#tissuename').attr("disabled", true);
    $('#tau1').attr("disabled", false);
    $('#tau2').attr("disabled", false);
    $('#cv1').attr("disabled", false);
    $('#cv2').attr("disabled", false);
    $('#minBreadth').attr("disabled", false);
    $('#maxBreadth').attr("disabled", false);
    $('#tsr').hide();
    $('#hkr').hide();
    // $('#tau').show();
    // $('#reset').show();
});

$('#hkr').on("click",function () {
    var type = $('#type').val();
    $('#tissuename').empty();
    $("#hkts_table").bootstrapTable('refreshOptions', {url:'/LncExpDB/hkts/differentiation' + '?' +'tau1=0&tau2=0.5&cv1=0&cv2=0.5',  silent: true, pageNumber: 1, pageSize: 10});
});


$('#tsr').click(function () {
    var type = $('#type').val();
    $('#tissuename').empty();
    $("#hkts_table").bootstrapTable('refreshOptions', {url:'/LncExpDB/hkts/differentiation' + '?' +'tau1=0.95&tau2=1',  silent: true, pageNumber: 1, pageSize: 10});
});

$('#tau').on('click', function () {
    $('#tissuename').attr("disabled",true);
    var $btn = $(this).button("loading");
    $('#tissuename').empty();
    var tau1 = $('input[name="tau1"]').val();
    var tau2 = $('input[name="tau2"]').val();
    var minBreadth = $('input[name="minBreadth"]').val();
    var maxBreadth = $('input[name="maxBreadth"]').val();
    var cv1 = $('input[name="cv1"]').val();
    var cv2 = $('input[name="cv2"]').val();
    var url = '/LncExpDB/hkts/differentiation' + "?tau1="+ tau1 + '&tau2=' + tau2 + '&minBreadth=' + minBreadth + '&maxBreadth=' + maxBreadth + '&cv1=' + cv1 + '&cv2=' + cv2;
    hkts_table(url);
    $btn.button("reset")
});

$("#reset").on('click', function () {

    $('input[name="tau1"]').val(0);
    $('input[name="tau2"]').val(1);
    $('input[name="cv1"]').val(0);
    $('input[name="cv2"]').val(3);
    $('input[name="minBreadth"]').val(0);
    $('input[name="maxBreadth"]').val(16);
    var url = "/LncExpDB/hkts/differentiation";
    hkts_table(url);
    var url_tissue = "/LncExpDB/hkts/differentiation/tissuename";
    $('#tissuename').select2({
        ajax: {
            url: url_tissue,
            dataType: 'json'
        }
    });
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
        //pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [5, 10, 20, 30],
        search: false,
        dataField: "geneInfo",
        queryParamsType: "",
        silent: true,  //刷新事件必须设
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        formatLoadingMessage: function () {
            return "please wait";
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
                title: '<a title="PCG: Protein-Coding Gene">'+'PCG ID'+ ' <span class="glyphicon glyphicon-question-sign"></span></a>',
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
                title: '<a title="Pearson Correlation Coefficient">'+'R'+'' + ' <span class="glyphicon glyphicon-question-sign"></span></a>',
                field: 'pcc',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
            },
            {
                title: 'P value',
                field: 'pvalue',
                align: "center",
                formatter: function (value,row,index) {
                    return Number(value).toFixed(3)
                }
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

var url1 = "/LncExpDB/ce/circadian";
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
    var url_tissue = "/LncExpDB/hkts/differentiation/tissuename";
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
    url = '/LncExpDB/ce/circadiandistance?start=-2&end=-0.1'
    ce_table(url)
});

$('#ce_tsr').click(function () {
    var type = $('#ce_type').val();
    $('#ce_tissuename').empty();
    url = '/LncExpDB/ce/circadiandistance?start=0'
    ce_table(url)
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
    var url = '/LncExpDB/ce/circadianfilter?pvalue_start=0&pvalue_end=' + pvalue + '&pcc_start=' + pcc + '&pcc_end=1' + '&distance_start=' + mindis + '&distance_end=' + maxdis;
    ce_table(url);
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
    var url = "/LncExpDB/ce/circadian";
    ce_table(url);
});

// Select2
var url1 = "/LncExpDB/ce/circadianlncid";

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
        url1 = "/LncExpDB/ce/circadianlncid";
        $('#featurelnc').attr('data-placeholder', 'eg. HSALNG000002');
    } else if ($('#feature_sect1').val() == "lncname") {
        url1 = "/LncExpDB/ce/circadianlncname";
        $('#featurelnc').attr('data-placeholder', 'eg. MALAT1');
    } else if ($('#feature_sect1').val() == "pcgid") {
        url1 = "/LncExpDB/ce/circadianpcgid";
        $('#featurelnc').attr('data-placeholder', 'eg. ENSG00000152078.10');
    } else if ($('#feature_sect1').val() == "pcgname") {
        url1 = "/LncExpDB/ce/circadianpcgname";
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
    var url = '/LncExpDB/ce/circadian';
    ce_table(url)
}

$('.feature').change(function () {
    var dis = $('.feature').val();
    var v2 = $(".filter").val();
    var url = '/LncExpDB/ce/circadianby' + v2 + '?term=' + dis;
    console.log(url)
    ce_table(url);
    if($(this).val() != null && $(this).val()!=""){
        $('#featurelnc_cancel').show();
    }else{
        $('#featurelnc_cancel').hide();
    }
    $("#featurelnc_cancel").on("click",function () {
        var url = '/LncExpDB/ce/circadian';
        ce_table(url);
        $("#featurelnc").empty();
        $('#featurelnc_cancel').hide();
    });

    var val = $('.feature').val();
    if(val=="" || val==null){
        var url = '/LncExpDB/ce/circadian';
        ce_table(url)
    }
});