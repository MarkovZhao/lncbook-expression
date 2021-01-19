$(function () {
    var geneid = window.location.href.split("=")[1].split("#")[0];
    $.ajax({
        url: '/lncexpdb/gene/info?geneid=' + geneid,
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
        var gene_info = '';
        gene_info = data["geneInfo"][0];
        var symbol = [];
        console.log(data["geneInfo"].length);
        for (var i=0;i<data["geneInfo"].length;i++) {
            symbol.push(data["geneInfo"][i]["sourceid"] + "|" + data["geneInfo"][i]["source"])
        }
        var arr = [];
        for(var i=0;i<symbol.length;i++){
            if (arr.indexOf(symbol[i])==-1){
                arr.push(symbol[i]);
            }
        }
        console.log(arr)
        var geneset = "";
        for (var i=0;i<arr.length;i++) {
            if (arr[i].split("|")[1]=="NONCODE") {
                geneset += "<a href='http://www.noncode.org/show_gene.php?id=" + arr[i].split("|")[0].split(".")[0] + "&version=" + arr[i].split("|")[0].split(".")[1] + "&org=Human' target='_blank'>" + arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); " + "</a>";
            // } else if (arr[i].split("|")[1]=="RefLnc") {
            //     geneset += "<a href='http://reflnc.gao-lab.org/transcript/" + arr[i].split("|")[0] + ".html" + "' target='_blank'>" + arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); " + "</a>";
            } else if (arr[i].split("|")[1]=="LNCipedia") {
                geneset += "<a href='https://lncipedia.org/db/gene/" + arr[i].split("|")[0] + "' target='_blank'>" + arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); " + "</a>";
            } else if (arr[i].split("|")[1]=="GENCODE") {
                geneset += "<a href='http://www.ensembl.org/Homo_sapiens/Gene/Summary?db=core;g=" + arr[i].split("|")[0] + "' target='_blank'>" + arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); " + "</a>";
            } else if (arr[i].split("|")[1]=="RefSeq") {
                geneset += "<a href='https://www.ncbi.nlm.nih.gov/nuccore/" + arr[i].split("|")[0] + "' target='_blank'>" + arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); " + "</a>";
            } else {
                geneset += arr[i].split("|")[0] + " (" + arr[i].split("|")[1] + "); ";
            }
        }
        var largest_id = parseInt(gene_info.geneid.replace(/[^0-9]/ig,""))
        if (largest_id <= 141630) {
            $("#gene_table").append(
                "<tr><td width='40%'><strong>Gene ID:</strong></td><td style='text-align: left;padding-left: 20px'>" + "<a href='https://bigd.big.ac.cn/lncbook/gene?geneid=" + gene_info.geneid + "' target='_blank' title=\"Jump to LncBook\">" + gene_info.geneid + "</a>" + "</td></tr>" +
                "<tr><td width='40%'><strong>Gene Symbol:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.symbol + "</td></tr>" +
                "<tr><td><strong>Chromosome:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.chromosome + "</td></tr>" +
                "<tr><td><strong>Start Site:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.start + "</td></tr>" +
                "<tr><td><strong>End Site:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.end + "</td></tr>" +
                "<tr><td><strong>Strand:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.strand + "</td></tr>"
            );
        } else {
            $("#gene_table").append(
                "<tr><td width='40%'><strong>Gene ID:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.geneid + "</td></tr>" +
                "<tr><td width='40%'><strong>Gene Symbol:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.symbol + "</td></tr>" +
                "<tr><td><strong>Chromosome:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.chromosome + "</td></tr>" +
                "<tr><td><strong>Start Site:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.start + "</td></tr>" +
                "<tr><td><strong>End Site:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.end + "</td></tr>" +
                "<tr><td><strong>Strand:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.strand + "</td></tr>"
            );
        }
        $('#gene_table1').append(
            "<tr><td><strong><a href='/lncexpdb/help#classification' target='_blank' title=\"Based on their genomic locations in respect to protein-coding genes, we classified lncRNAs into seven groups, Intergenic, Intronic (S), Intronic (AS), Overlapping (S), Overlapping (AS), Sense, and Antisense. S in the bracket represents that lncRNAs are in the same strand of protein-coding RNAs, and AS represents lncRNAs are in the antisense strand of protein-coding RNAs.\">Classification <span class=\"glyphicon glyphicon-question-sign\"></span> </a>:</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.classification +"</td></tr>" +
            "<tr><td width='40%'><strong>Gene Length (nt):</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.gene_length +"</td></tr>" +
            "<tr><td width='40%'><strong>Exon Length (nt):</strong></td><td style='text-align: left;padding-left: 20px'>" + gene_info.length +"</td></tr>" +
            "<tr><td><strong>UCSC Genome Browser:</strong></td>" + "<td style='text-align: left;padding-left: 20px'><a href='http://genome.ucsc.edu/s/lizhao/lncexpdb_UCSC?position=" + gene_info.chromosome + ":" + gene_info.start + "-" + gene_info.end + "' target='_blank'><span class='glyphicon glyphicon-eye-open'></span></a></td></tr>" +
            "<tr><td><strong>Assembly:</strong></td><td style='text-align: left;padding-left: 20px'>hg38</td></tr>"
        );
        $('#gene_table2').append(
            "<tr><td><strong>External Links:</strong></td><td style='text-align: left;padding-left: 20px'>"+ geneset +"</td></tr>"
        );

    }
});


//Transcripts 数据请求
$(function () {
    var geneid = window.location.href.split("=")[1];
    $.ajax({
        url: '/lncexpdb/gene/alternative?geneid=' + geneid,
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

        var gene_alter = data['transinfo'];
        var gene_info = [];
        for(var i=0;i<gene_alter.length;i++){
            var gene_arry = {};
            var largest_id = parseInt(gene_alter[i].transcriptid.replace(/[^0-9]/ig,""))
            if (largest_id <= 289524) {
                gene_arry['transcriptid'] = "<a href='https://bigd.big.ac.cn/lncbook/transcript?transid=" + gene_alter[i].transcriptid + "' target='_blank'>" + gene_alter[i].transcriptid + "</a>";
            } else {
                gene_arry['transcriptid'] = gene_alter[i].transcriptid;
            }
            gene_arry['chromosome'] = gene_alter[i].chromosome;
            gene_arry['strand'] = gene_alter[i].strand;
            gene_arry['start'] = gene_alter[i].start;
            gene_arry['end'] = gene_alter[i].end;
            gene_arry['length'] = gene_alter[i].length;
            gene_arry['transcript_length'] = gene_alter[i].transcript_length;
            gene_arry['exon'] = gene_alter[i].exon_nums;
            gene_arry['classification'] = gene_alter[i].classification;
            gene_arry['alias'] = gene_alter[i].transcript_alias;
            gene_info.push(gene_arry)
        }

        $('#transcript_table').DataTable( {
            searching: true,
            ordering:  true,
            paging: true,
            lengthChange: false,
            info: true,
            autoWidth:false,
            data: gene_info,
            columns: [
                {data: 'transcriptid'},
                {data: 'chromosome'},
                {data: 'strand'},
                {data: 'start'},
                {data: 'end'},
                {data: 'transcript_length'},
                {data: 'length'},
                {data: 'exon'},
                {data: 'classification'},
                {data: 'alias'}
            ],

        } );
    }
});


//切换显示备注信息，显示部分或者全部
function changeShowRemarks(obj){//obj是td
    var content = $(obj).attr("content");
    if(content != null && content != ''){
        if($(obj).attr("isDetail") == 'true'){//当前显示的是详细备注，切换到显示部分
            //$(obj).removeAttr('isDetail');//remove也可以
            $(obj).attr('isDetail',false);
            $(obj).html(getPartialRemarksHtml(content));
        }else{//当前显示的是部分备注信息，切换到显示全部
            $(obj).attr('isDetail',true);
            $(obj).html(getTotalRemarksHtml(content));
        }
    }
}
//部分备注信息
function getPartialRemarksHtml(remarks){
    return remarks.substr(0,10) + '&nbsp;&nbsp;<a href="javascript:void(0);" ><b>+</b></a>';
}

//全部备注信息
function getTotalRemarksHtml(remarks){
    return "<div style='width: 100px;word-wrap: break-word'>"+remarks +"</div>" + '&nbsp;&nbsp;<a href="javascript:void(0);" ><b>-</b></a>';
}
