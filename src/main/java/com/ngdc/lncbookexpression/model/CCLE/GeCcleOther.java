package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleOther {
    @Id
    private String geneid;
    private float other;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }
}
