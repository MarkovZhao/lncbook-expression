package com.ngdc.lncbookexpression.model.SpatialExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FtBrain {
    @Id
    private String geneid;
    private float tau;
    private String max_name;
    private float max_value;
    private String min_name;
    private float min_value;
    private float avg;
    private float median;
    private float cv;
    private int brand;
    private float p_value;
    private float r_squared;
    private String k_4;
    private String k_5;
    private String k_6;
    private String k_7;
    private String k_8;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getTau() {
        return tau;
    }

    public void setTau(float tau) {
        this.tau = tau;
    }

    public String getMax_name() {
        return max_name;
    }

    public void setMax_name(String max_name) {
        this.max_name = max_name;
    }

    public float getMax_value() {
        return max_value;
    }

    public void setMax_value(float max_value) {
        this.max_value = max_value;
    }

    public String getMin_name() {
        return min_name;
    }

    public void setMin_name(String min_name) {
        this.min_name = min_name;
    }

    public float getMin_value() {
        return min_value;
    }

    public void setMin_value(float min_value) {
        this.min_value = min_value;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public float getMedian() {
        return median;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public float getCv() {
        return cv;
    }

    public void setCv(float cv) {
        this.cv = cv;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getP_value() {
        return p_value;
    }

    public void setP_value(float p_value) {
        this.p_value = p_value;
    }

    public float getR_squared() {
        return r_squared;
    }

    public void setR_squared(float r_squared) {
        this.r_squared = r_squared;
    }

    public String getK_4() {
        return k_4;
    }

    public void setK_4(String k_4) {
        this.k_4 = k_4;
    }

    public String getK_5() {
        return k_5;
    }

    public void setK_5(String k_5) {
        this.k_5 = k_5;
    }

    public String getK_6() {
        return k_6;
    }

    public void setK_6(String k_6) {
        this.k_6 = k_6;
    }

    public String getK_7() {
        return k_7;
    }

    public void setK_7(String k_7) {
        this.k_7 = k_7;
    }

    public String getK_8() {
        return k_8;
    }

    public void setK_8(String k_8) {
        this.k_8 = k_8;
    }
}
