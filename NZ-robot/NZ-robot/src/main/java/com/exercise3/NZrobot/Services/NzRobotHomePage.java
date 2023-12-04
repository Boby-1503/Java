package com.exercise3.NZrobot.Services;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;



import java.io.IOException;

public class NzRobotHomePage
{
    private WebClient webClient;
    private HtmlPage page;

    public NzRobotHomePage(WebClient webClient)
    {
        this.webClient=webClient;
    }
    public NzRobotHomePage(){};

    public void openWebsite() throws IOException, InterruptedException {
        webClient.getPage("https://app.iponz.govt.nz/app/Extra/IP/TM/Qbe.aspx?sid=638365769348565047&op=EXTRA_tm_qbe&fcoOp=EXTRA__Default&directAccess=true");
        Thread.sleep(20000);

        this.page= (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
    }

    public void classficationStatus() throws IOException, InterruptedException
    {
        HtmlSpan classificationStatusSearch=page.getFirstByXPath("//span[@id='MainContent_ctrlTMSearch_hdrClassifStatusCriteria_lblheader']");
        classificationStatusSearch.click();
        Thread.sleep(20000);


    }

    public void selectStatus() throws IOException, InterruptedException
    {
        HtmlAnchor selectStatus=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_lnkBtnSearch']");
        selectStatus.click();
        Thread.sleep(20000);


    }

    public void selectCaseStatus() throws InterruptedException, IOException {
        HtmlInput underOpposition1=page.getHtmlElementById("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_7");
        HtmlInput underOpposition2=page.getHtmlElementById("MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_ctrlCaseStatusSearch_ctrlCaseStatusList_gvCaseStatuss_chckbxSelected_8");
        underOpposition1.setChecked(true);
        underOpposition2.setChecked(true);
        HtmlAnchor select=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlCaseStatusSearchDialog_lnkBtnSelect']");
           select.click();
           Thread.sleep(20000);

    }

   public HtmlPage searchButton() throws IOException, InterruptedException {
       HtmlAnchor search=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_lnkbtnSearch']");
       search.click();
       Thread.sleep(20000);
       return page;

   }


}
