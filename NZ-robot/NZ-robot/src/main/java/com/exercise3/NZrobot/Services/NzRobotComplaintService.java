package com.exercise3.NZrobot.Services;
import com.exercise3.NZrobot.Models.*;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NzRobotComplaintService
{
    public WebClient webClient;

    @Autowired
    public NzRobotComplaintService(WebClient webClient)
    {
        this.webClient=webClient;
    }

    public Binder nzRobot()
    {
        ApplicantDetails applicantDetails = new ApplicantDetails();
        Classification classification = new Classification();
        Decision decision=new Decision();
        Docket docket = new Docket();
        Party party = new Party();
        Right right = new Right();
        Binder binder = new Binder();
        try
        {
            NzRobotHomePage nzRobotHomePageService=new NzRobotHomePage(webClient);

            nzRobotHomePageService.openWebsite();
            nzRobotHomePageService.classficationStatus();
            nzRobotHomePageService.selectStatus();

            nzRobotHomePageService.selectCaseStatus();


            NzRobotSearchResultPage nzRobotSearchResultService=new NzRobotSearchResultPage(webClient,nzRobotHomePageService.searchButton());
            nzRobotSearchResultService.searchResult();
            Thread.sleep(20000);

            NzRobotCaseDetailsPage nzRobotCaseDetailsService=new NzRobotCaseDetailsPage(webClient);
            nzRobotCaseDetailsService.caseData();
            Thread.sleep(20000);

            Binder b=nzRobotCaseDetailsService.firstActionDetails();

            binder.setApplicantDetails(nzRobotCaseDetailsService.applicantDetails());
            binder.setClassification(nzRobotCaseDetailsService.classification());
            binder.setParty(nzRobotCaseDetailsService.party());
            binder.setDecision(nzRobotCaseDetailsService.caseData());
            binder.setFirstActionDate(b.getFirstActionDate());
            binder.setFirstActionType(b.getFirstActionType());



            NzRobotDocumentTab nzRobotDocumentTab=new NzRobotDocumentTab(webClient);
            nzRobotDocumentTab.downloadPdfFile();
            Thread.sleep(20000);

            String downloadPath="C:\\NzRobotPdf";
            nzRobotDocumentTab.jsonFile(downloadPath,binder);
            Thread.sleep(20000);


            return binder;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

}
