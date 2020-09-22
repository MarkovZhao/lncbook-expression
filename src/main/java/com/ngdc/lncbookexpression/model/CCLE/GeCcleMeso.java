package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleMeso {
    @Id
    private String geneid;
    private float meso;
    private float meso1;
    private float meso2;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getMeso() {
        return meso;
    }

    public void setMeso(float meso) {
        this.meso = meso;
    }

    public float getMeso1() {
        return meso1;
    }

    public void setMeso1(float meso1) {
        this.meso1 = meso1;
    }

    public float getMeso2() {
        return meso2;
    }

    public void setMeso2(float meso2) {
        this.meso2 = meso2;
    }
}
