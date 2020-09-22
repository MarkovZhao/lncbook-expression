package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleMb {
    @Id
    private String geneid;
    private float mb;
    private float mb1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getMb() {
        return mb;
    }

    public void setMb(float mb) {
        this.mb = mb;
    }

    public float getMb1() {
        return mb1;
    }

    public void setMb1(float mb1) {
        this.mb1 = mb1;
    }
}
