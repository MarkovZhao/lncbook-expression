package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeneAlternative {
    @Id
    private String geneid;
    private String transcriptid;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getTranscriptid() {
        return transcriptid;
    }

    public void setTranscriptid(String transcriptid) {
        this.transcriptid = transcriptid;
    }
}
