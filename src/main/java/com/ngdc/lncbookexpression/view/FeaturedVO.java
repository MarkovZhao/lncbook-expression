package com.ngdc.lncbookexpression.view;

public class FeaturedVO <T>{
    private T geneinfo;
    private T featured;

    public T getFeatured() {
        return featured;
    }

    public void setFeatured(T featured) {
        this.featured = featured;
    }

    public T getGeneinfo() {
        return geneinfo;
    }

    public void setGeneinfo(T geneinfo) {
        this.geneinfo = geneinfo;
    }
}
