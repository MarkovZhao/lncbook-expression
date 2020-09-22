package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleLcml {
    @Id
    private String geneid;
    private float lcml;
    private float lcml1;
    private float lcml2;
    private float lcml3;
    private float lcml4;
    private float lcml5;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getLcml() {
        return lcml;
    }

    public void setLcml(float lcml) {
        this.lcml = lcml;
    }

    public float getLcml1() {
        return lcml1;
    }

    public void setLcml1(float lcml1) {
        this.lcml1 = lcml1;
    }

    public float getLcml2() {
        return lcml2;
    }

    public void setLcml2(float lcml2) {
        this.lcml2 = lcml2;
    }

    public float getLcml3() {
        return lcml3;
    }

    public void setLcml3(float lcml3) {
        this.lcml3 = lcml3;
    }

    public float getLcml4() {
        return lcml4;
    }

    public void setLcml4(float lcml4) {
        this.lcml4 = lcml4;
    }

    public float getLcml5() {
        return lcml5;
    }

    public void setLcml5(float lcml5) {
        this.lcml5 = lcml5;
    }
}
