package com.ngdc.lncbookexpression.model.CancerMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cm {
    @Id
    private String id;
    private String cancer;
    private String new_number;
    private String new_rank;
    private String new_percent;
    private String new_cumrisk;
    private String death_number;
    private String deathrank;
    private String death_percent;
    private String death_cumrisk;
    private String prevalence_number;
    private String prevalence_prop;
    private String country;
    private String continent;
    private String code;

    private String continent_incirank;
    private String continent_mortrank;

    private String world_incirank;
    private String world_mortrank;

    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getNew_number() {
        return new_number;
    }

    public void setNew_number(String new_number) {
        this.new_number = new_number;
    }

    public String getNew_rank() {
        return new_rank;
    }

    public void setNew_rank(String new_rank) {
        this.new_rank = new_rank;
    }

    public String getNew_percent() {
        return new_percent;
    }

    public void setNew_percent(String new_percent) {
        this.new_percent = new_percent;
    }

    public String getNew_cumrisk() {
        return new_cumrisk;
    }

    public void setNew_cumrisk(String new_cumrisk) {
        this.new_cumrisk = new_cumrisk;
    }

    public String getDeath_number() {
        return death_number;
    }

    public void setDeath_number(String death_number) {
        this.death_number = death_number;
    }

    public String getDeathrank() {
        return deathrank;
    }

    public void setDeathrank(String deathrank) {
        this.deathrank = deathrank;
    }

    public String getDeath_percent() {
        return death_percent;
    }

    public void setDeath_percent(String death_percent) {
        this.death_percent = death_percent;
    }

    public String getDeath_cumrisk() {
        return death_cumrisk;
    }

    public void setDeath_cumrisk(String death_cumrisk) {
        this.death_cumrisk = death_cumrisk;
    }

    public String getPrevalence_number() {
        return prevalence_number;
    }

    public void setPrevalence_number(String prevalence_number) {
        this.prevalence_number = prevalence_number;
    }

    public String getPrevalence_prop() {
        return prevalence_prop;
    }

    public void setPrevalence_prop(String prevalence_prop) {
        this.prevalence_prop = prevalence_prop;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent_incirank() {
        return continent_incirank;
    }

    public void setContinent_incirank(String continent_incirank) {
        this.continent_incirank = continent_incirank;
    }

    public String getContinent_mortrank() {
        return continent_mortrank;
    }

    public void setContinent_mortrank(String continent_mortrank) {
        this.continent_mortrank = continent_mortrank;
    }

    public String getWorld_incirank() {
        return world_incirank;
    }

    public void setWorld_incirank(String world_incirank) {
        this.world_incirank = world_incirank;
    }

    public String getWorld_mortrank() {
        return world_mortrank;
    }

    public void setWorld_mortrank(String world_mortrank) {
        this.world_mortrank = world_mortrank;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
