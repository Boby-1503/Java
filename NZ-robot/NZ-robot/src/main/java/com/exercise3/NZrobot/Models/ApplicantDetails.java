package com.exercise3.NZrobot.Models;

public class ApplicantDetails
{
    private String applicantId;
    private String applicantAddress;
    private String applicantName;
    private String applicationNumber;

    public ApplicantDetails(String applicantId, String applicantAddress, String applicantName, String applicationNumber) {
        this.applicantId = applicantId;
        this.applicantAddress = applicantAddress;
        this.applicantName = applicantName;
        this.applicationNumber = applicationNumber;
    }

    public ApplicantDetails() {
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }
}
