package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleSofttissue {
    @Id
    private String geneid;
    private String soft_tissue;
    private String soft_tissue1;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getSoft_tissue() {
        return soft_tissue;
    }

    public void setSoft_tissue(String soft_tissue) {
        this.soft_tissue = soft_tissue;
    }

    public String getSoft_tissue1() {
        return soft_tissue1;
    }

    public void setSoft_tissue1(String soft_tissue1) {
        this.soft_tissue1 = soft_tissue1;
    }
}
