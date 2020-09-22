package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleLgg {
    @Id
    private String geneid;
    private float lgg;
    private float lgg1;
    private float lgg2;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getLgg() {
        return lgg;
    }

    public void setLgg(float lgg) {
        this.lgg = lgg;
    }

    public float getLgg1() {
        return lgg1;
    }

    public void setLgg1(float lgg1) {
        this.lgg1 = lgg1;
    }

    public float getLgg2() {
        return lgg2;
    }

    public void setLgg2(float lgg2) {
        this.lgg2 = lgg2;
    }
}
