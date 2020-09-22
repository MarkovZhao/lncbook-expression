package com.ngdc.lncbookexpression.view;

import com.ngdc.lncbookexpression.model.TranscriptInfo1;

import java.util.List;

public class GeneAlternativeVO <T>{
    private T geneAlternative;
    private List<TranscriptInfo1> transinfo;

    public T getGeneAlternative() {
        return geneAlternative;
    }
    public void setGeneAlternative(T geneAlternative) {
        this.geneAlternative = geneAlternative;
    }

    public List<TranscriptInfo1> getTransinfo() {
        return transinfo;
    }

    public void setTransinfo(List<TranscriptInfo1> transinfo) {
        this.transinfo = transinfo;
    }
}
