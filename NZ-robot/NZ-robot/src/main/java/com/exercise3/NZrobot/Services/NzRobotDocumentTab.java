package com.exercise3.NZrobot.Services;

import com.exercise3.NZrobot.Models.Binder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NzRobotDocumentTab
{
    private WebClient webClient;
    private HtmlPage page;
    public NzRobotDocumentTab(WebClient webClient)
    {
        this.webClient=webClient;
        this.page= (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
    }

    public NzRobotDocumentTab(){};

    public void downloadPdfFile() throws IOException, InterruptedException
    {
//        HtmlAnchor documentTab=page.getFirstByXPath("//li[@id='MainContent_liDocuments']/a");
//        documentTab.click();
//        Thread.sleep(20000);

        HtmlAnchor pdfLink=page.getFirstByXPath("//a[@id='MainContent_ctrlDocumentList_gvDocuments_hnkView_0']");
        String pdflink=pdfLink.getAttribute("href");
        HttpURLConnection connection = (HttpURLConnection) new URL(pdflink).openConnection();
        Thread.sleep(20000);
        String downloadPath="C:\\NzRobotPdf";
        try (InputStream in = new URL(pdflink).openStream())
        {
            Path pdfFile = Paths.get(downloadPath,"decision_reference.pdf");
            Files.copy(in, pdfFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("PDF Downloaded at: "+ pdfFile.toAbsolutePath());

        }
        catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public void jsonFile(String downloadPath, Binder binder) {
        try{
            String binderResponse = convertToString(binder);
            Path outputPath = Paths.get(downloadPath,"decisionReference.js");
            Files.write(outputPath, binderResponse.getBytes());


        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public static String convertToString(Binder binder) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(binder);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
