package com.ngdc.lncbookexpression.dto;

public class DEdto {
    String geneid;
    String basemean;
    String log1;
    String log2;
    String lfcse;
    String stat;
    String pvalue;
    String padj;
    String symbol;

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

    public String getBasemean() {
        return basemean;
    }

    public void setBasemean(String basemean) {
        this.basemean = basemean;
    }

    public String getLog1() {
        return log1;
    }

    public void setLog1(String log1) {
        this.log1 = log1;
    }

    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2;
    }

    public String getLfcse() {
        return lfcse;
    }

    public void setLfcse(String lfcse) {
        this.lfcse = lfcse;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public String getPadj() {
        return padj;
    }

    public void setPadj(String padj) {
        this.padj = padj;
    }
}
