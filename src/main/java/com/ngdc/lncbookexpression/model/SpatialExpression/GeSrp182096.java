package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeSrp182096 {
    @Id
    private String geneid;
    private float healthy;
    private float hbc;
    private float hcv;
    private float hiv;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getHealthy() {
        return healthy;
    }

    public void setHealthy(float healthy) {
        this.healthy = healthy;
    }

    public float getHbc() {
        return hbc;
    }

    public void setHbc(float hbc) {
        this.hbc = hbc;
    }

    public float getHcv() {
        return hcv;
    }

    public void setHcv(float hcv) {
        this.hcv = hcv;
    }

    public float getHiv() {
        return hiv;
    }

    public void setHiv(float hiv) {
        this.hiv = hiv;
    }
}
