package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Search {
    @Id
    private String geneid;
    private String symbol;
    private String transcriptid;
    private String sourceid;
    private String source;

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTranscriptid() {
        return transcriptid;
    }

    public void setTranscriptid(String transcriptid) {
        this.transcriptid = transcriptid;
    }
}
