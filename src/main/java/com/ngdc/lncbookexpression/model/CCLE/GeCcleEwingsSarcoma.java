package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleEwingsSarcoma {
    @Id
    private String geneid;
    private float ewings_sarcoma;
    private float ewings_sarcoma1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getEwings_sarcoma() {
        return ewings_sarcoma;
    }

    public void setEwings_sarcoma(float ewings_sarcoma) {
        this.ewings_sarcoma = ewings_sarcoma;
    }

    public float getEwings_sarcoma1() {
        return ewings_sarcoma1;
    }

    public void setEwings_sarcoma1(float ewings_sarcoma1) {
        this.ewings_sarcoma1 = ewings_sarcoma1;
    }
}
