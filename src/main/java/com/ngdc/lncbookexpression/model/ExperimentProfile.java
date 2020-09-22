package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExperimentProfile {
    @Id
    private String geneid;
    private String symbol;
    private String normal;
    private String ccle;
    private String subcellular;
    private String development;
    private String circadian;
    private String differentiation;
    private String preimplantation;
    private String exosome;
    private String virus;
    private int none;
    private int low;
    private int medium;
    private int high;
    private String classification;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
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

    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development;
    }

    public String getCircadian() {
        return circadian;
    }

    public void setCircadian(String circadian) {
        this.circadian = circadian;
    }

    public String getDifferentiation() {
        return differentiation;
    }

    public void setDifferentiation(String differentiation) {
        this.differentiation = differentiation;
    }

    public String getPreimplantation() {
        return preimplantation;
    }

    public void setPreimplantation(String preimplantation) {
        this.preimplantation = preimplantation;
    }

    public String getExosome() {
        return exosome;
    }

    public void setExosome(String exosome) {
        this.exosome = exosome;
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    public int getNone() {
        return none;
    }

    public void setNone(int none) {
        this.none = none;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
