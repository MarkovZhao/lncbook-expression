package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCircadian {
    @Id
    private String geneid;
    private float one_hr;
    private float three_hr;
    private float five_hr;
    private float seven_hr;
    private float nine_hr;
    private float eleven_hr;
    private float thirteen_hr;
    private float fifteen_hr;
    private float seventeen_hr;
    private float nineteen_hr;
    private float twentyone_hr;
    private float twentythree_hr;
    private float twentyfive_hr;
    private float twentyseven_hr;
    private float twentynine_hr;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getOne_hr() {
        return one_hr;
    }

    public void setOne_hr(float one_hr) {
        this.one_hr = one_hr;
    }

    public float getThree_hr() {
        return three_hr;
    }

    public void setThree_hr(float three_hr) {
        this.three_hr = three_hr;
    }

    public float getFive_hr() {
        return five_hr;
    }

    public void setFive_hr(float five_hr) {
        this.five_hr = five_hr;
    }

    public float getSeven_hr() {
        return seven_hr;
    }

    public void setSeven_hr(float seven_hr) {
        this.seven_hr = seven_hr;
    }

    public float getNine_hr() {
        return nine_hr;
    }

    public void setNine_hr(float nine_hr) {
        this.nine_hr = nine_hr;
    }

    public float getEleven_hr() {
        return eleven_hr;
    }

    public void setEleven_hr(float eleven_hr) {
        this.eleven_hr = eleven_hr;
    }

    public float getThirteen_hr() {
        return thirteen_hr;
    }

    public void setThirteen_hr(float thirteen_hr) {
        this.thirteen_hr = thirteen_hr;
    }

    public float getFifteen_hr() {
        return fifteen_hr;
    }

    public void setFifteen_hr(float fifteen_hr) {
        this.fifteen_hr = fifteen_hr;
    }

    public float getSeventeen_hr() {
        return seventeen_hr;
    }

    public void setSeventeen_hr(float seventeen_hr) {
        this.seventeen_hr = seventeen_hr;
    }

    public float getNineteen_hr() {
        return nineteen_hr;
    }

    public void setNineteen_hr(float nineteen_hr) {
        this.nineteen_hr = nineteen_hr;
    }

    public float getTwentyone_hr() {
        return twentyone_hr;
    }

    public void setTwentyone_hr(float twentyone_hr) {
        this.twentyone_hr = twentyone_hr;
    }

    public float getTwentythree_hr() {
        return twentythree_hr;
    }

    public void setTwentythree_hr(float twentythree_hr) {
        this.twentythree_hr = twentythree_hr;
    }

    public float getTwentyfive_hr() {
        return twentyfive_hr;
    }

    public void setTwentyfive_hr(float twentyfive_hr) {
        this.twentyfive_hr = twentyfive_hr;
    }

    public float getTwentyseven_hr() {
        return twentyseven_hr;
    }

    public void setTwentyseven_hr(float twentyseven_hr) {
        this.twentyseven_hr = twentyseven_hr;
    }

    public float getTwentynine_hr() {
        return twentynine_hr;
    }

    public void setTwentynine_hr(float twentynine_hr) {
        this.twentynine_hr = twentynine_hr;
    }
}
