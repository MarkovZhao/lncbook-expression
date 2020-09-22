$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/info?transid=' + transid,
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
        var trans_info = data;
        var exon_pos = trans_info.exonPosition.split(',');
        var symbol = "";
        var synonyms = "";
        if(trans_info.geneSymbol.length<3){
            symbol = "NA";
            synonyms = "NA"
            // console.log(symbol)
        }else{
            symbol = trans_info.geneSymbol;
            synonyms = trans_info.alias
        }

        var exon_str = "";
        for(var i=0;i<exon_pos.length;i++){
            exon_str += exon_pos[i];
            if(i%2==0){
                exon_str += ".."
            }else{
                exon_str += ", "
            }
        }
        var len = exon_str.split(',');
        var final_exon_pos = len.slice(0,len.length-1).join(', ');

        $("#transcript_table").append(
            "<tr><td width='40%'><strong>Transcript ID:</strong></td><td style='text-align: left;padding-left: 20px'>" + trans_info.transid + "</td></tr>" +
            "<tr><td><strong>Gene ID:</strong></td><td style='text-align: left;padding-left: 20px'><a href='/lncbook/gene?geneid=" + trans_info.geneid + "'target='_blank'>" + trans_info.geneid + "</a></td></tr>" +
            "<tr><td><strong>Chromosome:</strong></td><td style='text-align: left;padding-left: 20px'>"+ trans_info.chrome +"</td></tr>" +
            "<tr><td><strong>Start Site:</strong></td><td style='text-align: left;padding-left: 20px'>"+ trans_info.startsite +"</td></tr>" +
            "<tr><td><strong>End Site:</strong></td><td style='text-align: left;padding-left: 20px'>"+ trans_info.endsite +"</td></tr>" +
            "<tr><td><strong>Strand:</strong></td><td style='text-align: left;padding-left: 20px'>"+ trans_info.strand +"</td></tr>" +
            "<tr><td><strong>Length (nt):</strong></td><td style='text-align: left;padding-left: 20px'>" + trans_info.length +"</td></tr>" +
            "<tr><td><strong>Exon Number:</strong></td><td style='text-align: left;padding-left: 20px'>" + trans_info.exonNum +"</td></tr>" +
            "<tr><td><strong>Exon Position:</strong></td><td style='text-align: left;padding-left: 20px'><span>" + final_exon_pos +"</span></td></tr>" +
            "<tr><td><strong>Assembly:</strong></td><td style='text-align: left;padding-left: 20px'>hg19</td></tr>"
        );

        $('#transcript_table1').append(
            "<tr><td width='40%'><strong>ORF Length (nt):</strong></td><td style='text-align: left;padding-left: 20px'>" + trans_info.orfLength +"</td></tr>" +
            "<tr><td><strong>GC Content (%):</strong></td><td style='text-align: left;padding-left: 20px'>" + parseFloat(trans_info.gcContent).toFixed(3) +"</td></tr>" +
            "<tr><td><strong>Gene Symbol:</strong></td><td style='text-align: left;padding-left: 20px'>" + symbol +"</td></tr>" +
            "<tr><td><strong>Synonyms:</strong></td><td style='text-align: left;padding-left: 20px'>" + synonyms.split(',').join(', ') +"</td></tr>" +
            "<tr><td><strong><a href='/lncbook/faq#method10' target=\"_blank\" class=\"tooltip-test\" data-toggle=\"tooltip\" title=\"Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs, and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.\">Classification<span class=\"glyphicon glyphicon-question-sign\"></span></a>:</strong></td><td style='text-align: left;padding-left: 20px'>" + trans_info.classification +"</td></tr>"
        );

        $('#jbrowse').append(
            "<iframe src=\"https://bigd.big.ac.cn/browser/?data=data%2FHuman%2FlncrnaWiki&loc="+trans_info.chrome+"%3A"+trans_info.startsite+".."+trans_info.endsite+"&tracks=DNA%2CRefGene%2ClncRNA&highlight=\"" + "style=\"border-width:0\" width=100%\" height=\"450px\"></iframe>"
        )
    }

});


//miRNA 相互作用信息
$(function () {
    var transid = window.location.href.split("=")[1];
    $('#inter_table').bootstrapTable('destroy');
    $('#inter_table').bootstrapTable({
        method: "post",
        url: '/lncbook/trans/mirna?transid=' + transid,
        striped: true, //是否显示行间隔色
        cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,//是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: [5,10,20],
        search: false,
        // dataField: 'rows',
        // queryParamsType: "",
        silent: true,  //刷新事件必须设置
        sidePagination: "client",//分页方式：client客户端分页，server服务端分页（*）
        contentType: "application/x-www-form-urlencoded",//请求远程数据的内容类型。
        // queryParams: function queryParams(params) {
        //     var param ={
        //         page: params.pageNumber-1
        //     };
        //     return param;
        // },
        columns: [
            {
                title: 'Transcript ID',
                field: 'transid'
            }, {
                title: 'MiRNA ID',
                field: 'mirnaid',
                sortable: true,
                formatter: function(value,row,index){
                    return "<a href='http://www.mirbase.org/cgi-bin/query.pl?terms=" + value + "'target='_blank'>" + value + "</a>"
                }
            }, {
                title: 'Score',
                field: 'score',
                sortable: true
            }, {
                title: 'Energy',
                field: 'energy',
                sortable: true
            }, {
                title: 'Binding Start',
                field: 'rstart',
                sortable: true
            },
            {
                title: 'Binding End',
                field: 'rend',
                sortable: true
            },
            {
                title: "<a class=\"tooltip-test\" data-toggle=\"tooltip\" title=\"Whether miRNA:lncRNA experimentally support or not\">"+'Experimental<br>Evidence'+"<span class=\"glyphicon glyphicon-question-sign\"></span></a>",
                field: 'experiment',
                sortable: true,
                formatter: function(value,row,index) {
                    var a  ="";
                    if(value=="0"){
                        var a = "no"
                    }else{
                        var a = "yes"
                    }
                    return a;
                }
            }
        ]
    });
});

// $(function () {
//     var transid = window.location.href.split("=")[1];
//     $.ajax({
//         url: '/lncbook/trans/mirna?transid=' + transid,
//         type: 'POST',
//         dataType: 'json',
//         cache: false,
//         error: erryFunction,  //错误执行方法
//         success: succFunction //成功执行方法
//     });
//
//     function erryFunction() {
//         alert("error");
//     }
//
//     function succFunction(data) {
//         var mirna = '';
//         mirna = data["mirnaInteraction"];
//         $('#inter_table').DataTable( {
//             dom: 'Bfrtip',
//             select: true,
//             info: true,
//             // fixedHeader: {
//             //     header: true
//             // },
//             buttons: [
//                 'copyHtml5',
//                 {
//                     text: 'CSV',
//                     extend: 'csvHtml5',
//                     fieldSeparator: ',',
//                     extension: '.csv'
//                 }
//             ],
//             responsive: {
//                 details: {
//                     type: 'column',
//                     target: -1
//                 }
//             },
//             data: mirna,
//             columns: [
//                 {data: 'transid'
//                 },
//                 {data: 'mirnaid',
//                     render: function (data, type, row) {
//                         return "<a href='http://www.mirbase.org/cgi-bin/query.pl?terms=" + row.mirnaid + "'target='_blank'>" + row.mirnaid + "</a>"
//                     }
//                 },
//                 {data: 'rstart'},
//                 {data: 'rend'},
//                 {data: 'len'},
//                 {data: 'energy'},
//                 {data: 'score'},
//                 {data: 'experiment'}
//             ],
//             "fnRowCallback": function (nRow, aData) {
//                 // Bold the grade for all 'A' grade browsers
//                 // console.log(aData['energy']);
//                 i = aData['ok'];
//                 if (i === "0") {
//                     $('td', nRow).eq(7).html('yes');
//                 }else{
//                     $('td', nRow).eq(7).html('no');
//                 }
//             }
//         } );
//     }
// });


// 转录本alias信息
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/alias?transid=' + transid,
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

        var trans_alias = data["transcriptAlias"];
        $('#alias_table').DataTable( {
            searching: false,
            ordering:  false,
            paging: false,
            info: false,
            AutoWidth:true,
            // dom: 'Bfrtip',
            // buttons: [
            //     'copyHtml5',
            //     {
            //         text: 'CSV',
            //         extend: 'csvHtml5',
            //         fieldSeparator: ',',
            //         extension: '.csv'
            //     }],
            data: trans_alias,
            columns: [
                {data: 'gencode',
                    render: function (data, type, row) {
                        if(row.gencode=="-"){
                            return "NA";
                        }
                        if(/,/.test(row.gencode)){
                            var gene = row.gencode.split(',');
                            for(var i=0;i<gene.length;i++){
                                return gene[i];
                            }
                        }else {
                            return row.gencode;
                        }
                    }
                },
                {data: 'refseq',
                    render: function (data, type, row) {
                        if(row.refseq=="-"){
                            return "NA";
                        }else{
                            return "<a href='https://www.ncbi.nlm.nih.gov/nuccore/" + row.refseq + "'target='_blank'>" + row.refseq + "</a>"
                        }
                    }
                },
                {data: 'noncode',
                    render: function (data, type, row) {
                        if(row.noncode=="-"){
                            return "NA";
                        }if(/,/.test(row.noncode)){
                            var non = row.noncode.split(',');
                            var non1 = '';
                            for(var i=0;i<non.length;i++){
                                non1 = non1 + "<a href='http://www.noncode.org/show_rna.php?id=" + non[i].split('.')[0] +"&version=2&utd=1#"+"'target='_blank'>" + non[i]+'<br>'+ "</a>"
                            }
                            return non1;
                        }
                        else{
                            return "<a href='http://www.noncode.org/show_rna.php?id=" + row.noncode.split('.')[0] +"&version=2&utd=1#"+"'target='_blank'>" + row.noncode + "</a>"
                        }
                    }
                },
                {data: 'lncipedia',
                    render: function (data, type, row) {
                        if(row.lncipedia=="-"){
                            return "NA";
                        }
                        if(/,/.test(row.lncipedia)){
                            var gene = row.lncipedia.split(',');
                            var gene1 = '';
                            for(var i=0;i<gene.length;i++){
                                gene1 = gene1 + "<a href='https://lncipedia.org/db/transcript/"+ gene[i] + "'target='_blank'>" +gene[i]+'<br>'+"</a>"
                            }
                            return gene1;
                        }
                        else{
                            return "<a href='https://lncipedia.org/db/transcript/" + row.lncipedia + "'target='_blank'>" + row.lncipedia + "</a>"
                        }
                    }
                },
                {data: 'mitranscriptome'}
            ],
            "fnRowCallback": function (nRow, aData) {
                var i = aData['mitranscriptome'];
                // console.log(i);
                if (/-/.test(i)) {
                    $('td', nRow).eq(-1).html('NA');
                }else{
                    $('td', nRow).eq(-1).html(i);
                }
            }
        });
    }
});


//coding potential
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/transCp?transid=' + transid,
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
        var codp = data["transCp"];
        $('#cp_table').DataTable( {
            searching: false,
            ordering:  false,
            paging: false,
            info: false,
            AutoWidth:true,
            // dom: 'Bfrtip',
            // buttons: [
            //     'copyHtml5',
            //     {
            //         text: 'CSV',
            //         extend: 'csvHtml5',
            //         fieldSeparator: ',',
            //         extension: '.csv'
            //     }],
            data: codp,
            columns: [
                {
                    targets: 1,
                    data: null,
                    defaultContent: "Score"
                },
                {data: 'lgcScore',
                    render: function (data, type, row) {
                        return  parseFloat(row.lgcScore).toFixed(3);
                    }
                },
                {data: 'cpatScore',
                    render: function (data, type, row) {
                        return  parseFloat(row.cpatScore).toFixed(3);
                    }
                },
                {data: 'plekScore',
                    render: function (data, type, row) {
                        return  parseFloat(row.plekScore).toFixed(3);
                    }
                }
            ]
        } );

        if(parseFloat(codp[0].lgcScore) <= 0){
            // console.log(codp[0].lgcScore)
            var lgc_e = "Noncoding RNA"
        }else{
            lgc_e = "Coding RNA"
        }
        if(parseFloat(codp[0].cpatScore) < 0.364){
            var cpat_e = "Noncoding RNA"
        }else{
            cpat_e = "Coding RNA"
        }
        if(codp[0].plekScore ==="NA"){
            var plek_e = ""
        }else{
            plek_e = "Noncoding RNA"
        }
        $("#cp_table").append("<tr><td>Explanation</td><td>"+ cpat_e +"</td><td>"+ cpat_e +"</td><td>"+ plek_e +"</td></tr>")
    }
});


// lncRNA transcirpt 和snp的信息
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/snp?transid=' + transid,
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

        var snp_info = data["snp"];

        $('#snp_table').DataTable({
            dom: 'Bfrtip',
            select: true,
            info: true,
            scrollX: true,
            autoWidth: false,
            buttons: [
                'copyHtml5',
                {
                    text: 'CSV',
                    extend: 'csvHtml5',
                    fieldSeparator: ',',
                    extension: '.csv'
                }
            ],
            data: snp_info,
            columns: [
                {data: "transid"},
                {data: 'dbsnpid',
                    render: function (data, type, row) {
                        return "<a href='https://www.ncbi.nlm.nih.gov/snp/?term=" + row.dbsnpid + "'target='_blank'>" + row.dbsnpid + "</a>"
                    }},
                {data: 'chrome',
                    render: function (data, type, row) {
                        return "chr"+ row.chrome;
                    }
                },
                {data: 'position'},
                {data: 'ref'},
                {data: 'alt'},
                {data: 'clinvar'},
                {data: 'cosmic',
                    render: function (data, type, row) {
                        return "<div style='width: 100px;word-wrap: break-word'>"+ row.cosmic +"</div>";
                    }
                },
                {data: 'all0'},
                {data: 'eur'},
                {data: 'eas'},
                {data: 'amr'},
                {data: 'sas'},
                {data: 'afr'}
            ],
            order: [[ 7, "desc" ]]
        });
    }
});


// //切换显示备注信息，显示部分或者全部
// function changeShowRemarks(obj){//obj是td
//     var content = $(obj).attr("content");
//     if(content != null && content != ''){
//         if($(obj).attr("isDetail") == 'true'){//当前显示的是详细备注，切换到显示部分
//             //$(obj).removeAttr('isDetail');//remove也可以
//             $(obj).attr('isDetail',false);
//             $(obj).html(getPartialRemarksHtml(content));
//         }else{//当前显示的是部分备注信息，切换到显示全部
//             $(obj).attr('isDetail',true);
//             $(obj).html(getTotalRemarksHtml(content));
//         }
//     }
// }
// //部分备注信息
// function getPartialRemarksHtml(remarks){
//     return remarks.substr(0,10) + '&nbsp;&nbsp;<a href="javascript:void(0);" ><b>+</b></a>';
// }
//
// //全部备注信息
// function getTotalRemarksHtml(remarks){
//     return "<div style='width: 100px;word-wrap: break-word'>"+remarks +"</div>"+ '&nbsp;&nbsp;<a href="javascript:void(0);" ><b>-</b></a>';
// }

// $('[data-toggle="tooltip"]').tooltip();

//hpa tau table
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/hpaTransExpressionTau?transid=' + transid,
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
        var data1 = data['hpaTransExpressionTau'];
        //
        // console.log(data1);
        if(data1.length==0){
            return "";
        }else {
            $('#hpa_tau').bootstrapTable({
                // dataField: 'hpaTransExpressionTau',
                // method: 'get',
                striped: true,
                data: data1,
                columns: [
                    {
                        title: 'Maximum (FPKM)',
                        field: 'maxvalue0'
                    },
                    {
                    title: 'Average (FPKM)',
                    field: 'average'
                }, {
                    title: 'Median (FPKM)',
                    field: 'median'
                }, {
                    title: 'CV',
                    field: 'cv'
                },
                    {
                        title: "<a class=\"tooltip-test\" data-toggle=\"tooltip\" title=\"tissue-specific(TS:tau>=0.95) | housekeeping(HK:tau<=0.5&CV<=0.5)\">"+'&tau;-Value' +"<span class=\"glyphicon glyphicon-question-sign\"></span></a>",
                        field: 'tauvalue'
                    },
                    {
                        title: 'Expression Breadth',
                        field: 'tissuebreadth'
                    }
                ]
            });
        }
    }

});

//gtex tau table
$(function () {
    var transid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncbook/trans/gtextau?transid=' + transid,
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
        var data1 = data['gtexTransExpressionTau'];
        if(data1.length==""){
            return "";
        }else{
            $('#gtex_tau').bootstrapTable({
                data: data1,
                columns: [
                    {
                        title: 'Maximum (TPM)',
                        field: 'maxvalue0'
                    },
                    {
                    title: 'Average (TPM)',
                    field: 'average'
                }, {
                    title: 'Median (TPM)',
                    field: 'median'
                }, {
                    title: 'CV',
                    field: 'cv'
                }, {
                    title: "<a class=\"tooltip-test\" data-toggle=\"tooltip\" title=\"tissue-specific(TS:tau>=0.95) | housekeeping(HK:tau<=0.5&CV<=0.5)\">"+'&tau;-Value' +"<span class=\"glyphicon glyphicon-question-sign\"></span></a>",
                    field: 'tauvalue'
                }, {
                    title: 'Expression Breadth',
                    field: 'tissuebreadth'
                    }
                ]
            });
        }
    }
});