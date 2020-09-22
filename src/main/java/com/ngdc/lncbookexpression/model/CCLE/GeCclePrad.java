package com.ngdc.lncbookexpression.model.CCLE;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCclePrad {
    @Id
    private String geneid;
    private float prad;
    private float prad1;
    private float prad2;
    private float prad3;
    private float prad4;
    private float prad5;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getPrad() {
        return prad;
    }

    public void setPrad(float prad) {
        this.prad = prad;
    }

    public float getPrad1() {
        return prad1;
    }

    public void setPrad1(float prad1) {
        this.prad1 = prad1;
    }

    public float getPrad2() {
        return prad2;
    }

    public void setPrad2(float prad2) {
        this.prad2 = prad2;
    }

    public float getPrad3() {
        return prad3;
    }

    public void setPrad3(float prad3) {
        this.prad3 = prad3;
    }

    public float getPrad4() {
        return prad4;
    }

    public void setPrad4(float prad4) {
        this.prad4 = prad4;
    }

    public float getPrad5() {
        return prad5;
    }

    public void setPrad5(float prad5) {
        this.prad5 = prad5;
    }
}
