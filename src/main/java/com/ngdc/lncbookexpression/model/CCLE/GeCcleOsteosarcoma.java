package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleOsteosarcoma {
    @Id
    private String geneid;
    private float osteosarcoma;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getOsteosarcoma() {
        return osteosarcoma;
    }

    public void setOsteosarcoma(float osteosarcoma) {
        this.osteosarcoma = osteosarcoma;
    }
}
