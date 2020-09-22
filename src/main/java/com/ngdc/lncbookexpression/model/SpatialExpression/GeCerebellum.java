package com.ngdc.lncbookexpression.model.SpatialExpression;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeCerebellum {

    @Id
    private String geneid;
    private float four_week;
    private float five_week;
    private float seven_week;
    private float eight_week;
    private float nine_week;
    private float ten_week;
    private float eleven_week;
    private float twelve_week;
    private float thirteen_week;
    private float sixteen_week;
    private float neonate;
    private float infant;
    private float toddler;
    private float school_age_child;
    private float adolescent;
    private float young_adult;

    public String getGeneid() {
        return geneid;
    }
    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public float getFour_week() { return four_week; }
    public void setFour_week(float four_week) { this.four_week = four_week; }

    public float getFive_week() { return five_week; }
    public void setFive_week(float five_week) { this.five_week = five_week; }

    public float getSeven_week() { return seven_week; }
    public void setSeven_week(float seven_week) { this.seven_week = seven_week; }

    public float getEight_week() { return eight_week; }
    public void setEight_week(float eight_week) { this.eight_week = eight_week; }

    public float getNine_week() { return nine_week; }
    public void setNine_week(float nine_week) { this.nine_week = nine_week; }

    public float getTen_week() { return ten_week; }
    public void setTen_week(float ten_week) { this.ten_week = ten_week; }

    public float getEleven_week() { return eleven_week; }
    public void setEleven_week(float eleven_week) { this.eleven_week = eleven_week; }

    public float getTwelve_week() { return twelve_week; }
    public void setTwelve_week(float twelve_week) { this.twelve_week = twelve_week; }

    public float getThirteen_week() { return thirteen_week; }
    public void  setThirteen_week(float thirteen_week) { this.thirteen_week = thirteen_week; }

    public float getSixteen_week() { return sixteen_week; }
    public void setSixteen_week(float sixteen_week) { this.sixteen_week = sixteen_week; }

    public float getNeonate() { return neonate; }
    public void setNeonate(float neonate) { this.neonate = neonate;}

    public float getInfant() { return infant; }
    public void setInfant(float infant) { this.infant = infant; }

    public float getToddler() { return toddler; }
    public void setToddler(float toddler) { this.toddler = toddler; }

    public float getSchool_age_child() { return school_age_child; }
    public void setSchool_age_child(float school_age_child) { this.school_age_child = school_age_child; }

    public float getAdolescent() { return adolescent; }
    public void setAdolescent(float adolescent) { this.adolescent = adolescent; }

    public float getYoung_adult() { return young_adult; }
    public void setYoung_adult(float young_adult) { this.young_adult = young_adult; }


}
