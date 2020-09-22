package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleMesothelioma {
    @Id
    private String geneid;
    private float mesothelioma;
    private float mesothelioma1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getMesothelioma() {
        return mesothelioma;
    }

    public void setMesothelioma(float mesothelioma) {
        this.mesothelioma = mesothelioma;
    }

    public float getMesothelioma1() {
        return mesothelioma1;
    }

    public void setMesothelioma1(float mesothelioma1) {
        this.mesothelioma1 = mesothelioma1;
    }
}
