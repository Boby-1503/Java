package com.exercise3.NZrobot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
public class Decision
{
    private long id;
    private String reference;
    private String judgementDate;

    private String level;
    private String nature;
    private String robotSource;


    public void setId(long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setJudgementDate(String judgementDate) {
        this.judgementDate = judgementDate;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setRobotSource(String robotSource) {
        this.robotSource = robotSource;
    }

    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getJudgementDate() {
        return judgementDate;
    }

    public String getLevel() {
        return level;
    }

    public String getNature() {
        return nature;
    }

    public String getRobotSource() {
        return robotSource;
    }
}