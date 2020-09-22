package com.ngdc.lncbookexpression.view;

public class TissueDeveVO <T>{
    private T brain;
    private T cerebellum;
    private T heart;
    private T kidney;
    private T liver;
    private T ovary;
    private T testis;


    public T getBrain() {
        return brain;
    }
    public void setBrain(T brain) {
        this.brain = brain;
    }

    public T getCerebellum() {
        return cerebellum;
    }
    public void setCerebellum(T cerebellum) {
        this.cerebellum = cerebellum;
    }

    public T getHeart() { return heart; }
    public void setHeart(T heart) { this.heart = heart; }

    public T getKidney() {
        return kidney;
    }

    public void setKidney(T kidney) {
        this.kidney = kidney;
    }

    public T getLiver() {
        return liver;
    }

    public void setLiver(T liver) {
        this.liver = liver;
    }

    public T getOvary() {
        return ovary;
    }

    public void setOvary(T ovary) {
        this.ovary = ovary;
    }

    public T getTestis() {
        return testis;
    }

    public void setTestis(T testis) {
        this.testis = testis;
    }

}
