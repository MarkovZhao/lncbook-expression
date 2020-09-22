package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GeneInfo {
    private String geneid;
    private String symbol;
    private String classification;
    private String chromosome;
    private String strand;
    private int start;
    private int end;
    private int length;
    private int transNumber;
    private int gene_length;
    @Id
    private String sourceid;
    private String source;

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(int transNumber) {
        this.transNumber = transNumber;
    }

    public int getGene_length() {
        return gene_length;
    }

    public void setGene_length(int gene_length) {
        this.gene_length = gene_length;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
