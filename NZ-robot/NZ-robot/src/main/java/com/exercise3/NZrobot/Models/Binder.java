package com.exercise3.NZrobot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Binder {
    private long id;
    private String firstActionType;
    private String firstActionDate;
    private String domain;
    private ApplicantDetails applicantDetails;
    private Classification classification;
    private Decision decision;
    private Party party;


    public void setId(long id) {
        this.id = id;
    }

    public void setFirstActionType(String firstActionType) {
        this.firstActionType = firstActionType;
    }

    public void setFirstActionDate(String firstActionDate) {
        this.firstActionDate = firstActionDate;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setApplicantDetails(ApplicantDetails applicantDetails) {
        this.applicantDetails = applicantDetails;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public long getId() {
        return id;
    }

    public String getFirstActionType() {
        return firstActionType;
    }

    public String getFirstActionDate() {
        return firstActionDate;
    }

    public String getDomain() {
        return domain;
    }

    public ApplicantDetails getApplicantDetails() {
        return applicantDetails;
    }

    public Classification getClassification() {
        return classification;
    }

    public Decision getDecision() {
        return decision;
    }

    public Party getParty() {
        return party;
    }
}
