package com.ngdc.lncbookexpression.model.CCLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCcleUpperaerodigestive {
    @Id
    private String geneid;
    private String upper_aerodigestive;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getUpper_aerodigestive() {
        return upper_aerodigestive;
    }

    public void setUpper_aerodigestive(String upper_aerodigestive) {
        this.upper_aerodigestive = upper_aerodigestive;
    }
}
