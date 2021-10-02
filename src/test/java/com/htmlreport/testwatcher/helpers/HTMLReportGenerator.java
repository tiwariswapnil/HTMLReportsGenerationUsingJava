package com.htmlreport.testwatcher.helpers;

import lombok.Getter;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLReportGenerator {

    @Getter
    BufferedWriter junitWriter;
    String htmlReportFile;
    File junitReport;
    private static HTMLReportGenerator instance = null;

    public static HTMLReportGenerator getInstance(){
        if(instance == null){
            instance = new HTMLReportGenerator();
        }
        return instance;
    }

    public void generateReportFile() throws IOException {
        createHTMLFile();
        junitReport = new File(htmlReportFile);
        junitWriter = new BufferedWriter(new FileWriter(junitReport, true));

        junitWriter.write("<html><body>");
        junitWriter.write("<h1>Test Execution Report-" + DateAndTimer.getInstance().getCurrentDateTimeStamp() + "</h1><br/>");
        junitWriter.write(createHTMLTable());
    }

    public void createHTMLFile(){
        htmlReportFile = System.getProperty("user.dir") +
                "\\TestReport.html";
    }

    public void writeHtmlFooterAndClose() throws IOException {
        junitWriter.write("</table></body>");
        junitWriter.close();
        Desktop.getDesktop().browse(junitReport.toURI());
    }

    private String createHTMLTable(){

        return "<table border ='1'>" +
                "<tr>" +
                "<td>Scenario</td>" +
                "<td>Scenario Description</td>" +
                "<td>Status</td>" +
                "<td>Time taken to execute the test</td>" +
                "</tr>";
    }
}
