package com.ngdc.lncbookexpression.model.TemporalExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DePancreaticNormal {
    @Id
    private String geneid;
    private float basemean;
    private float log2foldchange;
    private float lfcse;
    private float stat;
    private float pvalue;
    private float padj;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getBasemean() {
        return basemean;
    }

    public void setBasemean(float basemean) {
        this.basemean = basemean;
    }

    public float getLog2foldchange() {
        return log2foldchange;
    }

    public void setLog2foldchange(float log2foldchange) {
        this.log2foldchange = log2foldchange;
    }

    public float getLfcse() {
        return lfcse;
    }

    public void setLfcse(float lfcse) {
        this.lfcse = lfcse;
    }

    public float getStat() {
        return stat;
    }

    public void setStat(float stat) {
        this.stat = stat;
    }

    public float getPvalue() {
        return pvalue;
    }

    public void setPvalue(float pvalue) {
        this.pvalue = pvalue;
    }

    public float getPadj() {
        return padj;
    }

    public void setPadj(float padj) {
        this.padj = padj;
    }
}
