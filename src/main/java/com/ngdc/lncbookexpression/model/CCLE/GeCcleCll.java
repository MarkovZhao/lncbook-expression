package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleCll {
    @Id
    private String geneid;
    private float cll;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getCll() {
        return cll;
    }

    public void setCll(float cll) {
        this.cll = cll;
    }
}
