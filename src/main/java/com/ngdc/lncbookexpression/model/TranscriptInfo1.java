package com.ngdc.lncbookexpression.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TranscriptInfo1 {
    @Id
    private String transcriptid;
    private String chromosome;
    private String strand;
    private int start;
    private int end;
    private int exon_nums;
    private int length;
    private String classification;
    private int transcript_length;
    private String transcript_alias;

    public String getTranscript_alias() {

        return transcript_alias;
    }

    public void setTranscript_alias(String transcript_alias) {
        this.transcript_alias = transcript_alias;
    }

    public int getTranscript_length() {
        return transcript_length;
    }

    public void setTranscript_length(int transcript_length) {
        this.transcript_length = transcript_length;
    }

    public int getExon_nums() {
        return exon_nums;
    }

    public void setExon_nums(int exon_nums) {
        this.exon_nums = exon_nums;
    }

    public String getTranscriptid() {
        return transcriptid;
    }

    public void setTranscriptid(String transcriptid) {
        this.transcriptid = transcriptid;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

}
