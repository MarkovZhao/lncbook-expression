package com.ngdc.lncbookexpression.model.SpatialExpression;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;

@Entity
public class GeSrp253951 {
    @Id
    private String geneid;
    private float sars2;
    private float normal;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getSars2() {
        return sars2;
    }

    public void setSars2(float sars2) {
        this.sars2 = sars2;
    }

    public float getNormal() {
        return normal;
    }

    public void setNormal(float normal) {
        this.normal = normal;
    }
}
