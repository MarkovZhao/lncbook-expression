package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TimeFeatured {
    @Id
    private String geneid;
    private String genename;
    private String brain;
    private String cerebellum;
    private String heart;
    private String kidney;
    private String liver;
    private String testis;
    private String ovary;
    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getGenename() {
        return genename;
    }

    public void setGenename(String genename) {
        this.genename = genename;
    }

    public String getBrain() {
        return brain;
    }

    public void setBrain(String brain) {
        this.brain = brain;
    }

    public String getCerebellum() {
        return cerebellum;
    }

    public void setCerebellum(String cerebellum) {
        this.cerebellum = cerebellum;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String getTestis() {
        return testis;
    }

    public void setTestis(String testis) {
        this.testis = testis;
    }

    public String getOvary() {
        return ovary;
    }

    public void setOvary(String ovary) {
        this.ovary = ovary;
    }
}
