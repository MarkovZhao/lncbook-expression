package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleBreast {
    @Id
    private String geneid;
    private float breast;
    private float breast1;
    private float breast2;
    private float breast3;
    private float breast4;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getBreast() {
        return breast;
    }

    public void setBreast(float breast) {
        this.breast = breast;
    }

    public float getBreast1() {
        return breast1;
    }

    public void setBreast1(float breast1) {
        this.breast1 = breast1;
    }

    public float getBreast2() {
        return breast2;
    }

    public void setBreast2(float breast2) {
        this.breast2 = breast2;
    }

    public float getBreast3() {
        return breast3;
    }

    public void setBreast3(float breast3) {
        this.breast3 = breast3;
    }

    public float getBreast4() {
        return breast4;
    }

    public void setBreast4(float breast4) {
        this.breast4 = breast4;
    }
}
