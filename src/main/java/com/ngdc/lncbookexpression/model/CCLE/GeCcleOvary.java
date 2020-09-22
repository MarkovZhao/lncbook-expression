package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleOvary {
    @Id
    private String geneid;
    private float ovary;
    private float ovary1;
    private float ovary2;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getOvary() {
        return ovary;
    }

    public void setOvary(float ovary) {
        this.ovary = ovary;
    }

    public float getOvary1() {
        return ovary1;
    }

    public void setOvary1(float ovary1) {
        this.ovary1 = ovary1;
    }

    public float getOvary2() {
        return ovary2;
    }

    public void setOvary2(float ovary2) {
        this.ovary2 = ovary2;
    }
}
