package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleLymphomaOther {
    @Id
    private String geneid;
    private float lymphoma_other;
    private float lymphoma_other1;
    private float lymphoma_other2;
    private float lymphoma_other3;
    private float lymphoma_other4;
    private float lymphoma_other5;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getLymphoma_other() {
        return lymphoma_other;
    }

    public void setLymphoma_other(float lymphoma_other) {
        this.lymphoma_other = lymphoma_other;
    }

    public float getLymphoma_other1() {
        return lymphoma_other1;
    }

    public void setLymphoma_other1(float lymphoma_other1) {
        this.lymphoma_other1 = lymphoma_other1;
    }

    public float getLymphoma_other2() {
        return lymphoma_other2;
    }

    public void setLymphoma_other2(float lymphoma_other2) {
        this.lymphoma_other2 = lymphoma_other2;
    }

    public float getLymphoma_other3() {
        return lymphoma_other3;
    }

    public void setLymphoma_other3(float lymphoma_other3) {
        this.lymphoma_other3 = lymphoma_other3;
    }

    public float getLymphoma_other4() {
        return lymphoma_other4;
    }

    public void setLymphoma_other4(float lymphoma_other4) {
        this.lymphoma_other4 = lymphoma_other4;
    }

    public float getLymphoma_other5() {
        return lymphoma_other5;
    }

    public void setLymphoma_other5(float lymphoma_other5) {
        this.lymphoma_other5 = lymphoma_other5;
    }
}
