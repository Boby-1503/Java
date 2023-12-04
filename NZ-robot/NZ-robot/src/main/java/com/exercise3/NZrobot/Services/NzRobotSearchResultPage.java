package com.exercise3.NZrobot.Services;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class NzRobotSearchResultPage
{
    private WebClient webClient;
    private HtmlPage page;
    public NzRobotSearchResultPage(WebClient webClient,HtmlPage page)
    {
        this.webClient=webClient;
        this.page= page;

    }
    public NzRobotSearchResultPage(){};

    public void searchResult() throws IOException, InterruptedException
    {
        HtmlAnchor sortCaseNumber=page.getFirstByXPath("//th[@class='headersortedup']/a");
        sortCaseNumber.click();
        Thread.sleep(30000);

        HtmlAnchor caseNumber=page.getFirstByXPath("//a[@id='MainContent_ctrlTMSearch_ctrlProcList_gvwIPCases_lnkBtnCaseBrowser_0']");
        caseNumber.click();

    }
}
