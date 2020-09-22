package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleBileDuct {
    @Id
    private String geneid;
    private float bile_duct;
    private float bile_duct1;
    private float bile_duct2;
    private float bile_duct3;
    private float bile_duct4;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getBile_duct() {
        return bile_duct;
    }

    public void setBile_duct(float bile_duct) {
        this.bile_duct = bile_duct;
    }

    public float getBile_duct1() {
        return bile_duct1;
    }

    public void setBile_duct1(float bile_duct1) {
        this.bile_duct1 = bile_duct1;
    }

    public float getBile_duct2() {
        return bile_duct2;
    }

    public void setBile_duct2(float bile_duct2) {
        this.bile_duct2 = bile_duct2;
    }

    public float getBile_duct3() {
        return bile_duct3;
    }

    public void setBile_duct3(float bile_duct3) {
        this.bile_duct3 = bile_duct3;
    }

    public float getBile_duct4() {
        return bile_duct4;
    }

    public void setBile_duct4(float bile_duct4) {
        this.bile_duct4 = bile_duct4;
    }
}
