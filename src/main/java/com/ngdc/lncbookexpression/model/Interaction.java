package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interaction {
    @Id
    int ID;
    private String geneid;
    private String pcg;
    private String lncname;
    private String lnclocation;
    private String pcgname;
    private String pcglocation;
    private float distance;

    private int breadth;
    private String context;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getPcg() {
        return pcg;
    }

    public void setPcg(String pcg) {
        this.pcg = pcg;
    }

    public String getLncname() {
        return lncname;
    }

    public void setLncname(String lncname) {
        this.lncname = lncname;
    }

    public String getLnclocation() {
        return lnclocation;
    }

    public void setLnclocation(String lnclocation) {
        this.lnclocation = lnclocation;
    }

    public String getPcgname() {
        return pcgname;
    }

    public void setPcgname(String pcgname) {
        this.pcgname = pcgname;
    }

    public String getPcglocation() {
        return pcglocation;
    }

    public void setPcglocation(String pcglocation) {
        this.pcglocation = pcglocation;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
