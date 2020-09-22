package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleLymphomaHodgkin {
    @Id
    private String geneid;
    private float lymphoma_hodgkin;
    private float lymphoma_hodgkin1;
    private float lymphoma_hodgkin2;
    private float lymphoma_hodgkin3;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getLymphoma_hodgkin() {
        return lymphoma_hodgkin;
    }

    public void setLymphoma_hodgkin(float lymphoma_hodgkin) {
        this.lymphoma_hodgkin = lymphoma_hodgkin;
    }

    public float getLymphoma_hodgkin1() {
        return lymphoma_hodgkin1;
    }

    public void setLymphoma_hodgkin1(float lymphoma_hodgkin1) {
        this.lymphoma_hodgkin1 = lymphoma_hodgkin1;
    }

    public float getLymphoma_hodgkin2() {
        return lymphoma_hodgkin2;
    }

    public void setLymphoma_hodgkin2(float lymphoma_hodgkin2) {
        this.lymphoma_hodgkin2 = lymphoma_hodgkin2;
    }

    public float getLymphoma_hodgkin3() {
        return lymphoma_hodgkin3;
    }

    public void setLymphoma_hodgkin3(float lymphoma_hodgkin3) {
        this.lymphoma_hodgkin3 = lymphoma_hodgkin3;
    }
}
