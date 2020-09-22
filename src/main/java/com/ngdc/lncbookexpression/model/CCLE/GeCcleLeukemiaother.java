package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleLeukemiaother {
    @Id
    private String geneid;
    private float leukemia_other;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getLeukemia_other() {
        return leukemia_other;
    }

    public void setLeukemia_other(float leukemia_other) {
        this.leukemia_other = leukemia_other;
    }
}
