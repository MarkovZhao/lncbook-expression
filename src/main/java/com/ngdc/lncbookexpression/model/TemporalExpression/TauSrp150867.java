package com.ngdc.lncbookexpression.model.TemporalExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TauSrp150867 {
    @Id
    private String geneid;
    private String genename;
    private String erm;
    private String kdel;
    private String lma;
    private String mito;
    private String nes;
    private String nik;
    private String nucleus;
    private String nucpore;
    private String omm;
    private String breadth;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getGenename() {
        return genename;
    }

    public void setGenename(String genename) {
        this.genename = genename;
    }

    public String getErm() {
        return erm;
    }

    public void setErm(String erm) {
        this.erm = erm;
    }

    public String getKdel() {
        return kdel;
    }

    public void setKdel(String kdel) {
        this.kdel = kdel;
    }

    public String getLma() {
        return lma;
    }

    public void setLma(String lma) {
        this.lma = lma;
    }

    public String getMito() {
        return mito;
    }

    public void setMito(String mito) {
        this.mito = mito;
    }

    public String getNes() {
        return nes;
    }

    public void setNes(String nes) {
        this.nes = nes;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNucleus() {
        return nucleus;
    }

    public void setNucleus(String nucleus) {
        this.nucleus = nucleus;
    }

    public String getNucpore() {
        return nucpore;
    }

    public void setNucpore(String nucpore) {
        this.nucpore = nucpore;
    }

    public String getOmm() {
        return omm;
    }

    public void setOmm(String omm) {
        this.omm = omm;
    }

    public String getBreadth() {
        return breadth;
    }

    public void setBreadth(String breadth) {
        this.breadth = breadth;
    }
}
