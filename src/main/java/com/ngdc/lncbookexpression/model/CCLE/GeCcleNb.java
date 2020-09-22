package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleNb {
    @Id
    private String geneid;
    private float nb;
    private float nb1;
    private float nb2;
    private float nb3;
    private float nb4;
    private float nb5;
    private float nb6;
    private float nb7;
    private float nb8;
    private float nb9;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getNb() {
        return nb;
    }

    public void setNb(float nb) {
        this.nb = nb;
    }

    public float getNb1() {
        return nb1;
    }

    public void setNb1(float nb1) {
        this.nb1 = nb1;
    }

    public float getNb2() {
        return nb2;
    }

    public void setNb2(float nb2) {
        this.nb2 = nb2;
    }

    public float getNb3() {
        return nb3;
    }

    public void setNb3(float nb3) {
        this.nb3 = nb3;
    }

    public float getNb4() {
        return nb4;
    }

    public void setNb4(float nb4) {
        this.nb4 = nb4;
    }

    public float getNb5() {
        return nb5;
    }

    public void setNb5(float nb5) {
        this.nb5 = nb5;
    }

    public float getNb6() {
        return nb6;
    }

    public void setNb6(float nb6) {
        this.nb6 = nb6;
    }

    public float getNb7() {
        return nb7;
    }

    public void setNb7(float nb7) {
        this.nb7 = nb7;
    }

    public float getNb8() {
        return nb8;
    }

    public void setNb8(float nb8) {
        this.nb8 = nb8;
    }

    public float getNb9() {
        return nb9;
    }

    public void setNb9(float nb9) {
        this.nb9 = nb9;
    }
}
