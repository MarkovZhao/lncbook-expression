package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Featured {
    @Id
    private String geneid;
    private String brain;
    private String cerebellum;
    private String heart;
    private String kidney;
    private String liver;
    private String testis;
    private String ovary;
    private String colorectal;
    private String coronary;
    private String pancreatic;
    private String hepatocellular;
    private String escc;
    private String hiv1;
    private String hbv;
    private String hcv;
    private String sars2;
    private String sars2cell;
    private String iavcell;
    private String ccle;
    private String subcellular;
    private String pre1;
    private String pre2;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
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

    public String getColorectal() {
        return colorectal;
    }

    public void setColorectal(String colorectal) {
        this.colorectal = colorectal;
    }

    public String getCoronary() {
        return coronary;
    }

    public void setCoronary(String coronary) {
        this.coronary = coronary;
    }

    public String getPancreatic() {
        return pancreatic;
    }

    public void setPancreatic(String pancreatic) {
        this.pancreatic = pancreatic;
    }

    public String getHepatocellular() {
        return hepatocellular;
    }

    public void setHepatocellular(String hepatocellular) {
        this.hepatocellular = hepatocellular;
    }

    public String getEscc() {
        return escc;
    }

    public void setEscc(String escc) {
        this.escc = escc;
    }

    public String getHiv1() {
        return hiv1;
    }

    public void setHiv1(String hiv1) {
        this.hiv1 = hiv1;
    }

    public String getHbv() {
        return hbv;
    }

    public void setHbv(String hbv) {
        this.hbv = hbv;
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv;
    }

    public String getSars2() {
        return sars2;
    }

    public void setSars2(String sars2) {
        this.sars2 = sars2;
    }

    public String getSars2cell() {
        return sars2cell;
    }

    public void setSars2cell(String sars2cell) {
        this.sars2cell = sars2cell;
    }

    public String getIavcell() {
        return iavcell;
    }

    public void setIavcell(String iavcell) {
        this.iavcell = iavcell;
    }

    public String getCcle() {
        return ccle;
    }

    public void setCcle(String ccle) {
        this.ccle = ccle;
    }

    public String getSubcellular() {
        return subcellular;
    }

    public void setSubcellular(String subcellular) {
        this.subcellular = subcellular;
    }

    public String getPre1() {
        return pre1;
    }

    public void setPre1(String pre1) {
        this.pre1 = pre1;
    }

    public String getPre2() {
        return pre2;
    }

    public void setPre2(String pre2) {
        this.pre2 = pre2;
    }
}
