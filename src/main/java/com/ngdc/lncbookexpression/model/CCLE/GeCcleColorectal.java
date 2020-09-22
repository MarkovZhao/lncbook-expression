package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleColorectal {
    @Id
    private String geneid;
    private float colorectal;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getColorectal() {
        return colorectal;
    }

    public void setColorectal(float colorectal) {
        this.colorectal = colorectal;
    }
}
