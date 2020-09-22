package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleGiantcell {
    @Id
    private String geneid;
    private float giant_cell_tumor;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getGiant_cell_tumor() {
        return giant_cell_tumor;
    }

    public void setGiant_cell_tumor(float giant_cell_tumor) {
        this.giant_cell_tumor = giant_cell_tumor;
    }
}
