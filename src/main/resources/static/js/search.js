$("#selected").on("change",function () {
    if ($("#selected").val() == "gene"){
        $("#input_id").attr("placeholder","Find a gene using ID in lncbook");
        $("#input_id").val('');
        $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
            "<a href=\"/lncbook/gene?geneid=HSALNG0000001\">HSALNG0000001</a>;\n" +
            "<a href=\"/lncbook/gene?geneid=HSALNG0000002\">HSALNG0000002</a>;\n" +
            "<a href=\"/lncbook/gene?geneid=HSALNG0000003\">HSALNG0000003</a>\n" +
            "</span>");

        $("#search_id").click(function () {
            var geneid = $("#input_id").val();
            if(geneid != ""){
                window.location= "/lncbook/gene?geneid=" + geneid
            }else{
                window.location= "/lncbook/index"
            }
        });
    }

    if($("#selected").val() == "transcript"){
        $("#input_id").attr("placeholder","Find a transcript using ID in lncbook");
        $("#input_id").val('');
        $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
            "<a href=\"/lncbook/transcript?transid=HSALNT0000001\">HSALNT0000001</a>;\n" +
            "<a href=\"/lncbook/transcript?transid=HSALNT0000002\">HSALNT0000002</a>;\n" +
            "<a href=\"/lncbook/transcript?transid=HSALNT0000003\">HSALNT0000003</a>\n" +
            "</span>");

        $("#search_id").click(function () {
            var transid = $("#input_id").val();
            if(transid !=""){
                window.location= "/lncbook/transcript?transid=" + transid
            }else {
                window.location= "/lncbook/index"
            }
        });
    }

    if($("#selected").val() == "feature"){
        $("#input_id").attr("placeholder","Find experiment support lncRNA");
        $("#input_id").val('');
        $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
            "<a href=\"\">PRKCZ-AS1</a>;\n" +
            "<a href=\"/\">MALAT1</a>;\n" +
            "<a href=\"/\">HOTAIR</a>\n" +
            "</span>");
    }

    if($("#selected").val() == "Function"){
        $("#input_id").attr("placeholder","Find functional lncRNAs");
        $("#input_id").val('');
        $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
            "<a href=\"/\">Transcriptional Regulation</a>;\n" +
            "<a href=\"/\">Development-involvement</a>;\n" +
            "<a href=\"/\">Biomarker</a>\n" +
            "</span>");

        $("#search_id").click(function () {
            var value = $("#input_id").val();
            if(value !=""){
                window.location= "/lncbook/function";
            }else {
                window.location= "/lncbook/index"
            }
        });
    }

    if($("#selected").val() == "Disease"){
        $("#input_id").attr("placeholder","Find disease association lncRNAs");
        $("#input_id").val('');
        $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
            "<a href=\"\">Cardiovascular Disease</a>;\n" +
            "<a href=\"\">Bladder Cancer</a>;\n" +
            "<a href=\"\">Alzheimer's Disease</a>\n" +
            "</span>");

    }
});

if($("#selected").val()=="gene"){
    $("#input_id").attr("placeholder","Find a gene using ID in lncbook");
    $("#input_id").val('');
    $('#exp').html("<span class=\"help-block text-center\">e.g.,\n" +
        "<a href=\"/lncbook/gene?geneid=HSALNG0000001\">HSALNG0000001</a>;\n" +
        "<a href=\"/lncbook/gene?geneid=HSALNG0000002\">HSALNG0000002</a>;\n" +
        "<a href=\"/lncbook/gene?geneid=HSALNG0000003\">HSALNG0000003</a>\n" +
        "</span>");

    $("#search_id").click(function () {
        var geneid = $("#input_id").val();
        if(geneid != ""){
            window.location= "/lncbook/gene?geneid=" + geneid
        }else{
            window.location= "/lncbook/index"
        }
    });
}



