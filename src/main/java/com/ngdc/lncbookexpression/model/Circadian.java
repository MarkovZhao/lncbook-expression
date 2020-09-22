package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circadian {
    @Id
    private String geneid;
    private float jtk_pvalue;
    private float jtk_bhq;
    private float jtk_period;
    private float jtk_adjphase;
    private float jtk_amplitude;
    private float ls_pvalue;
    private float ls_bhq;
    private float ls_period;
    private float ls_adjphase;
    private float ls_amplitude;
    private float meta2d_pvalue;
    private float meta2d_bhq;
    private float meta2d_period;
    private float meta2d_phase;
    private float meta2d_base;
    private float meta2d_amp;
    private float meta2d_ramp;
    private float meta2d_adjphase;
    private float meta2d_amplitude;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getJtk_pvalue() {
        return jtk_pvalue;
    }

    public void setJtk_pvalue(float jtk_pvalue) {
        this.jtk_pvalue = jtk_pvalue;
    }

    public float getJtk_bhq() {
        return jtk_bhq;
    }

    public void setJtk_bhq(float jtk_bhq) {
        this.jtk_bhq = jtk_bhq;
    }

    public float getJtk_period() {
        return jtk_period;
    }

    public void setJtk_period(float jtk_period) {
        this.jtk_period = jtk_period;
    }

    public float getJtk_adjphase() {
        return jtk_adjphase;
    }

    public void setJtk_adjphase(float jtk_adjphase) {
        this.jtk_adjphase = jtk_adjphase;
    }

    public float getJtk_amplitude() {
        return jtk_amplitude;
    }

    public void setJtk_amplitude(float jtk_amplitude) {
        this.jtk_amplitude = jtk_amplitude;
    }

    public float getLs_pvalue() {
        return ls_pvalue;
    }

    public void setLs_pvalue(float ls_pvalue) {
        this.ls_pvalue = ls_pvalue;
    }

    public float getLs_bhq() {
        return ls_bhq;
    }

    public void setLs_bhq(float ls_bhq) {
        this.ls_bhq = ls_bhq;
    }

    public float getLs_period() {
        return ls_period;
    }

    public void setLs_period(float ls_period) {
        this.ls_period = ls_period;
    }

    public float getLs_adjphase() {
        return ls_adjphase;
    }

    public void setLs_adjphase(float ls_adjphase) {
        this.ls_adjphase = ls_adjphase;
    }

    public float getLs_amplitude() {
        return ls_amplitude;
    }

    public void setLs_amplitude(float ls_amplitude) {
        this.ls_amplitude = ls_amplitude;
    }

    public float getMeta2d_pvalue() {
        return meta2d_pvalue;
    }

    public void setMeta2d_pvalue(float meta2d_pvalue) {
        this.meta2d_pvalue = meta2d_pvalue;
    }

    public float getMeta2d_bhq() {
        return meta2d_bhq;
    }

    public void setMeta2d_bhq(float meta2d_bhq) {
        this.meta2d_bhq = meta2d_bhq;
    }

    public float getMeta2d_period() {
        return meta2d_period;
    }

    public void setMeta2d_period(float meta2d_period) {
        this.meta2d_period = meta2d_period;
    }

    public float getMeta2d_phase() {
        return meta2d_phase;
    }

    public void setMeta2d_phase(float meta2d_phase) {
        this.meta2d_phase = meta2d_phase;
    }

    public float getMeta2d_base() {
        return meta2d_base;
    }

    public void setMeta2d_base(float meta2d_base) {
        this.meta2d_base = meta2d_base;
    }

    public float getMeta2d_amp() {
        return meta2d_amp;
    }

    public void setMeta2d_amp(float meta2d_amp) {
        this.meta2d_amp = meta2d_amp;
    }

    public float getMeta2d_ramp() {
        return meta2d_ramp;
    }

    public void setMeta2d_ramp(float meta2d_ramp) {
        this.meta2d_ramp = meta2d_ramp;
    }

    public float getMeta2d_adjphase() {
        return meta2d_adjphase;
    }

    public void setMeta2d_adjphase(float meta2d_adjphase) {
        this.meta2d_adjphase = meta2d_adjphase;
    }

    public float getMeta2d_amplitude() {
        return meta2d_amplitude;
    }

    public void setMeta2d_amplitude(float meta2d_amplitude) {
        this.meta2d_amplitude = meta2d_amplitude;
    }
}
