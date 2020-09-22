package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleMelanoma {
    @Id
    private String geneid;
    private float melanoma;
    private float melanoma1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getMelanoma() {
        return melanoma;
    }

    public void setMelanoma(float melanoma) {
        this.melanoma = melanoma;
    }

    public float getMelanoma1() {
        return melanoma1;
    }

    public void setMelanoma1(float melanoma1) {
        this.melanoma1 = melanoma1;
    }
}
