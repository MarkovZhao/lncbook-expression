package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleCesc {
    @Id
    private String geneid;
    private float cesc;
    private float cesc1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getCesc() {
        return cesc;
    }

    public void setCesc(float cesc) {
        this.cesc = cesc;
    }

    public float getCesc1() {
        return cesc1;
    }

    public void setCesc1(float cesc1) {
        this.cesc1 = cesc1;
    }
}
