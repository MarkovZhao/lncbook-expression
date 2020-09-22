package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleGlioma {
    @Id
    private String geneid;
    private float glioma;
    private float glioma1;
    private float glioma2;
    private float glioma3;
    private float glioma4;
    private float glioma5;
    private float glioma6;
    private float glioma7;
    private float glioma8;
    private float glioma9;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getGlioma() {
        return glioma;
    }

    public void setGlioma(float glioma) {
        this.glioma = glioma;
    }

    public float getGlioma1() {
        return glioma1;
    }

    public void setGlioma1(float glioma1) {
        this.glioma1 = glioma1;
    }

    public float getGlioma2() {
        return glioma2;
    }

    public void setGlioma2(float glioma2) {
        this.glioma2 = glioma2;
    }

    public float getGlioma3() {
        return glioma3;
    }

    public void setGlioma3(float glioma3) {
        this.glioma3 = glioma3;
    }

    public float getGlioma4() {
        return glioma4;
    }

    public void setGlioma4(float glioma4) {
        this.glioma4 = glioma4;
    }

    public float getGlioma5() {
        return glioma5;
    }

    public void setGlioma5(float glioma5) {
        this.glioma5 = glioma5;
    }

    public float getGlioma6() {
        return glioma6;
    }

    public void setGlioma6(float glioma6) {
        this.glioma6 = glioma6;
    }

    public float getGlioma7() {
        return glioma7;
    }

    public void setGlioma7(float glioma7) {
        this.glioma7 = glioma7;
    }

    public float getGlioma8() {
        return glioma8;
    }

    public void setGlioma8(float glioma8) {
        this.glioma8 = glioma8;
    }

    public float getGlioma9() {
        return glioma9;
    }

    public void setGlioma9(float glioma9) {
        this.glioma9 = glioma9;
    }
}
