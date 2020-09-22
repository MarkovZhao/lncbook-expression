package com.ngdc.lncbookexpression.model.CoExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CeEncode {
    @Id
    int id;
    private String geneid;
    private String pcg;
    private String lncname;
    private String lnclocation;
    private String pcgname;
    private String pcglocation;
    private float distance;
    private float pcc;
    private float pvalue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getPcg() {
        return pcg;
    }

    public void setPcg(String pcg) {
        this.pcg = pcg;
    }

    public String getLncname() {
        return lncname;
    }

    public void setLncname(String lncname) {
        this.lncname = lncname;
    }

    public String getLnclocation() {
        return lnclocation;
    }

    public void setLnclocation(String lnclocation) {
        this.lnclocation = lnclocation;
    }

    public String getPcgname() {
        return pcgname;
    }

    public void setPcgname(String pcgname) {
        this.pcgname = pcgname;
    }

    public String getPcglocation() {
        return pcglocation;
    }

    public void setPcglocation(String pcglocation) {
        this.pcglocation = pcglocation;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getPcc() {
        return pcc;
    }

    public void setPcc(float pcc) {
        this.pcc = pcc;
    }

    public float getPvalue() {
        return pvalue;
    }

    public void setPvalue(float pvalue) {
        this.pvalue = pvalue;
    }
}

