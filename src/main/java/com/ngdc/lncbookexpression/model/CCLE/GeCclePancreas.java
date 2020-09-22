package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCclePancreas {
    @Id
    private String geneid;
    private float pancreas;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getPancreas() {
        return pancreas;
    }

    public void setPancreas(float pancreas) {
        this.pancreas = pancreas;
    }
}
