package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleMeningioma {
    @Id
    private String geneid;
    private float meningioma;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getMeningioma() {
        return meningioma;
    }

    public void setMeningioma(float meningioma) {
        this.meningioma = meningioma;
    }
}
