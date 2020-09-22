package com.ngdc.lncbookexpression.model.SpatialExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeOvary {
    @Id
    private String geneid;
    private float four_week;
    private float five_week;
    private float six_week;
    private float seven_week;
    private float eight_week;
    private float nine_week;
    private float ten_week;
    private float eleven_week;
    private float twelve_week;
    private float thirteen_week;
    private float sixteen_week;
    private float enghteen_week;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getFour_week() {
        return four_week;
    }

    public void setFour_week(float four_week) {
        this.four_week = four_week;
    }

    public float getFive_week() {
        return five_week;
    }

    public void setFive_week(float five_week) {
        this.five_week = five_week;
    }

    public float getSix_week() {
        return six_week;
    }

    public void setSix_week(float six_week) {
        this.six_week = six_week;
    }

    public float getSeven_week() {
        return seven_week;
    }

    public void setSeven_week(float seven_week) {
        this.seven_week = seven_week;
    }

    public float getEight_week() {
        return eight_week;
    }

    public void setEight_week(float eight_week) {
        this.eight_week = eight_week;
    }

    public float getNine_week() {
        return nine_week;
    }

    public void setNine_week(float nine_week) {
        this.nine_week = nine_week;
    }

    public float getTen_week() {
        return ten_week;
    }

    public void setTen_week(float ten_week) {
        this.ten_week = ten_week;
    }

    public float getEleven_week() {
        return eleven_week;
    }

    public void setEleven_week(float eleven_week) {
        this.eleven_week = eleven_week;
    }

    public float getTwelve_week() {
        return twelve_week;
    }

    public void setTwelve_week(float twelve_week) {
        this.twelve_week = twelve_week;
    }

    public float getThirteen_week() {
        return thirteen_week;
    }

    public void setThirteen_week(float thirteen_week) {
        this.thirteen_week = thirteen_week;
    }

    public float getSixteen_week() {
        return sixteen_week;
    }

    public void setSixteen_week(float sixteen_week) {
        this.sixteen_week = sixteen_week;
    }

    public float getEnghteen_week() {
        return enghteen_week;
    }

    public void setEnghteen_week(float enghteen_week) {
        this.enghteen_week = enghteen_week;
    }
}
