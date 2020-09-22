package com.ngdc.lncbookexpression.model.SpatialExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeSrp150867 {
    @Id
    private String geneid;
    private float nucleus_ratio;
    private float nik_ratio;
    private float nucpore_ratio;
    private float lma_ratio;
    private float kdel_ratio;
    private float erm_ratio;
    private float nes_ratio;
    private float mito_ratio;
    private float omm_ratio;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getNucleus_ratio() {
        return nucleus_ratio;
    }

    public void setNucleus_ratio(float nucleus_ratio) {
        this.nucleus_ratio = nucleus_ratio;
    }

    public float getNik_ratio() {
        return nik_ratio;
    }

    public void setNik_ratio(float nik_ratio) {
        this.nik_ratio = nik_ratio;
    }

    public float getNucpore_ratio() {
        return nucpore_ratio;
    }

    public void setNucpore_ratio(float nucpore_ratio) {
        this.nucpore_ratio = nucpore_ratio;
    }

    public float getLma_ratio() {
        return lma_ratio;
    }

    public void setLma_ratio(float lma_ratio) {
        this.lma_ratio = lma_ratio;
    }

    public float getKdel_ratio() {
        return kdel_ratio;
    }

    public void setKdel_ratio(float kdel_ratio) {
        this.kdel_ratio = kdel_ratio;
    }

    public float getErm_ratio() {
        return erm_ratio;
    }

    public void setErm_ratio(float erm_ratio) {
        this.erm_ratio = erm_ratio;
    }

    public float getNes_ratio() {
        return nes_ratio;
    }

    public void setNes_ratio(float nes_ratio) {
        this.nes_ratio = nes_ratio;
    }

    public float getMito_ratio() {
        return mito_ratio;
    }

    public void setMito_ratio(float mito_ratio) {
        this.mito_ratio = mito_ratio;
    }

    public float getOmm_ratio() {
        return omm_ratio;
    }

    public void setOmm_ratio(float omm_ratio) {
        this.omm_ratio = omm_ratio;
    }
}
