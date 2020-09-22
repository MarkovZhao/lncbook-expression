package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleThca {
    @Id
    private String geneid;
    private float thca;
    private float thca1;
    private float thca2;
    private float thca3;
    private float thca4;
    private float thca5;
    private float thca6;
    private float thca7;
    private float thca8;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getThca() {
        return thca;
    }

    public void setThca(float thca) {
        this.thca = thca;
    }

    public float getThca1() {
        return thca1;
    }

    public void setThca1(float thca1) {
        this.thca1 = thca1;
    }

    public float getThca2() {
        return thca2;
    }

    public void setThca2(float thca2) {
        this.thca2 = thca2;
    }

    public float getThca3() {
        return thca3;
    }

    public void setThca3(float thca3) {
        this.thca3 = thca3;
    }

    public float getThca4() {
        return thca4;
    }

    public void setThca4(float thca4) {
        this.thca4 = thca4;
    }

    public float getThca5() {
        return thca5;
    }

    public void setThca5(float thca5) {
        this.thca5 = thca5;
    }

    public float getThca6() {
        return thca6;
    }

    public void setThca6(float thca6) {
        this.thca6 = thca6;
    }

    public float getThca7() {
        return thca7;
    }

    public void setThca7(float thca7) {
        this.thca7 = thca7;
    }

    public float getThca8() {
        return thca8;
    }

    public void setThca8(float thca8) {
        this.thca8 = thca8;
    }
}
