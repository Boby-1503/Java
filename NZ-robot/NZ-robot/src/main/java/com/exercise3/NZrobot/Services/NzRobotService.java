//package com.exercise3.NZrobot.Services;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.Base64;
//
//@Service
//public class NzRobotService
//{
//    private WebClient client;
//    @Autowired
//    public NzRobotService(WebClient client)
//    {
//        this.client=client;
//    }
//    public String scrapping()
//    {
//
//       try
//       {
//
//           client.getPage("https://app.iponz.govt.nz/app/Extra/IP/TM/Qbe.aspx?sid=638365769348565047&op=EXTRA_tm_qbe&fcoOp=EXTRA__Default&directAccess=true");
//           HtmlPage page= (HtmlPage) client.getCurrentWindow().getEnclosedPage();
//           HtmlSpan classificationStatusSearch=page.getFirstByXPath("//span[@id='MainContent_ctrlTMSearch_hdrClassifStatusCriteria_lblheader']");
//           classificationStatusSearch.click();
//           Thread.sleep(20000);
//
//           HtmlAnchor selectStatus=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_lnkBtnSearch']");
//           selectStatus.click();
//           Thread.sleep(20000);
//
//           HtmlInput underOpposition1=page.getHtmlElementById("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_7");
//           HtmlInput underOpposition2=page.getHtmlElementById("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_8");
//           underOpposition1.setChecked(true);
//           underOpposition2.setChecked(true);
//           Thread.sleep(10000);
//           HtmlAnchor select=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_lnkBtnSelect']");
//           select.click();
//           Thread.sleep(20000);
//           HtmlAnchor search=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_lnkbtnSearch']");
//           search.click();
//           Thread.sleep(20000);
//           HtmlAnchor sortCaseNumber=page.getFirstByXPath("//th[@class='headersortedup']/a");
//           sortCaseNumber.click();
//           Thread.sleep(20000);
//           HtmlAnchor caseNumber=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlProcList_gvwIPCases_lnkBtnCaseBrowser_0']");
//           caseNumber.click();
//           Thread.sleep(20000);
//
//           HtmlPage ip= (HtmlPage) client.getCurrentWindow().getEnclosedPage();
//           HtmlSpan ipNumber=ip.getFirstByXPath("//span[@id='MainContent_ctrlTM_txtAppNr']");
//           String applicationNumber=ipNumber.getTextContent();
//
//           HtmlTableCell applicant_name=ip.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']//td[2]");
//           String applicantName=applicant_name.getTextContent();
//
//           HtmlTableCell applicant_address=ip.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlApplicant_ctrlApplicant_gvCustomers']//tr[@class='alt1']//td[3]");
//           String applicantAddress=applicant_address.getTextContent();
//
//           HtmlTableCell class_name=ip.getFirstByXPath("//div[@id='MainContent_ctrlTM_tblClass']//table/tbody/tr[1]/td[1]");
//           String className=class_name.getTextContent();
//
//           HtmlTableBody classNumber=ip.getFirstByXPath("//table[@id='MainContent_ctrlTM_ctrlClassif_gvClassifications']/tbody");
//           boolean row_skipped=false;
//           for(HtmlTableRow row: classNumber.getRows())
//           {
//               if(row_skipped) {
//                   HtmlTableCell class_number=row.getCell(0);
//                   String classNo=classNumber.getTextContent();
//               } else{
//                   row_skipped=true;
//               }
//           }
//
//
//           HtmlTableCell TmName=ip.getFirstByXPath("//tr[@id='MainContent_ctrlTM_trTMName']/td[2]");
//           String trademarkName=TmName.getTextContent();
//
//
//           HtmlTableCell TmType=ip.getFirstByXPath("//tr[@id='MainContent_ctrlTM_trTMType']/td[2]");
//           String trademarkType=TmType.getTextContent();
//
//           HtmlAnchor TmImage=page.getFirstByXPath("//a[@id='MainContent_ctrlTM_ctrlPictureList_lvDocumentView_hlnkCasePicture_0']");
//           TmImage.click();
//           Thread.sleep(20000);
//
//           String imageUrl=TmImage.getAttribute("thmb");
//           try(InputStream in=new URL(imageUrl).openStream())
//           {
//               String downloadPath = "C:\\TrademarkImage";
//               Path imageFile = Paths.get(downloadPath, "Tm.jpg");
//               Files.copy(in, imageFile, StandardCopyOption.REPLACE_EXISTING);
//
//               byte[] imageByte = Files.readAllBytes(imageFile);
//               String imageString = Base64.getEncoder().encodeToString(imageByte);
//               System.out.println("converted image is: " + imageString);
//           }
//           catch (IOException e)
//           {
//               e.printStackTrace();
//           }
//
//           HtmlTableCell case_type=ip.getFirstByXPath("//table[@id='MainContent_ctrlProcedureList_gvwIPCases']//tr[@class='alt1']/td[2]");
//           String caseType=case_type.getTextContent();
//
//           HtmlTableCell party_name=ip.getFirstByXPath("//table[@id='MainContent_ctrlProcedureList_gvwIPCases']//tr[@class='alt1']/td[7]");
//           String partyName=party_name.getTextContent();
//
//           HtmlListItem historyTab=ip.getFirstByXPath("//div[@id='MainContent_divMainTab']/ul/li[2]");
//           historyTab.click();
//           Thread.sleep(20000);
//
//           HtmlTableCell historyType=ip.getFirstByXPath("//table[@id='MainContent_ctrlHistoryList_gvHistory']//tr[@class='alt1']/td[1]");
//           String firstActionType=historyType.getTextContent();
//
//           HtmlTableCell creationDate=ip.getFirstByXPath("//table[@id='MainContent_ctrlHistoryList_gvHistory']//tr[@class='alt1']/td[3]");
//           String firstActionDate=creationDate.getTextContent();
//
//           return "xyz";
//
//       }
//       catch (Exception e)
//       {
//           e.printStackTrace();
//           return ""+e.getMessage();
//       }
//
//    }
//
//
//}