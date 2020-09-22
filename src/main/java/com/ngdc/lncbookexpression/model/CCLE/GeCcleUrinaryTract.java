package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleUrinaryTract {
    @Id
    private String geneid;
    private float urinary_tract;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getUrinary_tract() {
        return urinary_tract;
    }

    public void setUrinary_tract(float urinary_tract) {
        this.urinary_tract = urinary_tract;
    }
}
