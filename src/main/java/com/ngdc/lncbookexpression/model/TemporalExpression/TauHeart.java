package com.ngdc.lncbookexpression.model.TemporalExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TauHeart {
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

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
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
}
