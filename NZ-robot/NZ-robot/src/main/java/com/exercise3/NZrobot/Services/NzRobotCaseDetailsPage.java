package com.exercise3.NZrobot.Services;

import com.exercise3.NZrobot.Models.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class NzRobotCaseDetailsPage
{
    private WebClient webClient;
    private HtmlPage page;


    public NzRobotCaseDetailsPage(WebClient webClient)
    {
        this.webClient=webClient;
        this.page= (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();

    }

    public NzRobotCaseDetailsPage(){};

    public Decision caseData() throws InterruptedException
    {
        Decision decision=new Decision();

        HtmlTableCell judgement_date=page.getFirstByXPath("//div[@id='MainContent_ctrlTM_tblCaseData']/div/table//tr/td[4]");
        String judgementDate=judgement_date.getTextContent().trim();
        Thread.sleep(20000);

        decision.setJudgementDate(judgementDate);
        return decision;

    }

    public ApplicantDetails applicantDetails() throws InterruptedException {
        ApplicantDetails applicantDetails = new ApplicantDetails();

        HtmlSpan applicationNumber=page.getFirstByXPath("//span[@id='MainContent_ctrlTM_txtAppNr']");
        String application_number=applicationNumber.getTextContent();
        Thread.sleep(20000);


        HtmlSpan applicant_id=page.getFirstByXPath("//span[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers_lblCodeNumber_0']");
        String applicantId=applicant_id.getTextContent();

        HtmlTableCell applicant_name=page.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']//td[2]");
        String applicantName=applicant_name.getTextContent();

        HtmlTableCell applicant_address=page.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']//td[3]");
        String applicantAddress=applicant_address.getTextContent();

        applicantDetails.setApplicationNumber(application_number);
        applicantDetails.setApplicantId(applicantId);
        applicantDetails.setApplicantAddress(applicantName);
        applicantDetails.setApplicantName(applicantAddress);

        return applicantDetails;
    }


    public  Classification classification () throws InterruptedException, IOException
    {

        Classification classification=new Classification();

        HtmlTableCell class_name=page.getFirstByXPath("//div[@id='MainContent_ctrlTM_tblClass']//table/tbody/tr[1]/td[1]");
        String className=class_name.getTextContent();

        HtmlTableCell classNum=page.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlClassif_gvClassifications']/tbody/tr/td[1]");
        String classNumber=classNum.getTextContent();

        HtmlTableCell TmName=page.getFirstByXPath("//tr[@id='MainContent_ctrlTM_trTMName']/td[2]");
        String trademarkName=TmName.getTextContent().trim();


        HtmlTableCell TmType=page.getFirstByXPath("//tr[@id='MainContent_ctrlTM_trTMType']/td[2]");
        String trademarkType=TmType.getTextContent().trim();

        HtmlAnchor TmImage=page.getFirstByXPath("//a[@id='MainContent_ctrlTM_ctrlPictureList_lvDocumentView_hlnkCasePicture_0']");


           String imageUrl=TmImage.getAttribute("thmb");
           HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
           Thread.sleep(20000);
           try(InputStream in=new URL(imageUrl).openStream())
           {
               String downloadPath = "C:\\TrademarkImage";
               Path imageFile = Paths.get(downloadPath, "Tm.jpg");
               Files.copy(in, imageFile, StandardCopyOption.REPLACE_EXISTING);

               byte[] imageByte = Files.readAllBytes(imageFile);
               String imageString = Base64.getEncoder().encodeToString(imageByte);
               classification.setImage(imageString);

               System.out.println("Image in bytes: " + imageString);
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
           classification.setName(trademarkName);
           classification.setType(trademarkType);
           classification.setClassNumber(classNumber);

        Thread.sleep(20000);

        return classification;
    }

    public Party party()
    {
        Party party=new Party();

        HtmlTableCell case_type=page.getFirstByXPath("//table[@id='MainContent_ctrlProcedureList_gvwIPCases']//tr[@class='alt1']/td[2]");
        String caseType=case_type.getTextContent();

        HtmlTableCell party_name=page.getFirstByXPath("//table[@id='MainContent_ctrlProcedureList_gvwIPCases']//tr[@class='alt1']/td[7]");
        String partyName=party_name.getTextContent();

        party.setName(partyName);

        return party;
    }

    public Binder firstActionDetails() throws InterruptedException, IOException
    {
        Binder binder=new Binder();

        HtmlTableCell historyType=page.getFirstByXPath("//table[@id='MainContent_ctrlHistoryList_gvHistory']//tr[@class='alt1']/td[1]");
        String firstActionType=historyType.getTextContent();

        HtmlTableCell creationDate=page.getFirstByXPath("//table[@id='MainContent_ctrlHistoryList_gvHistory']//tr[@class='alt1']/td[3]");
        String firstActionDate=creationDate.getTextContent();

        binder.setFirstActionDate(firstActionDate);
        binder.setFirstActionType(firstActionType);
        return binder;

    }
}
