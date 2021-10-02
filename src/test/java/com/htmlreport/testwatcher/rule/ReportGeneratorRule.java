package com.htmlreport.testwatcher.rule;

import com.htmlreport.testwatcher.helpers.HTMLReportGenerator;
import com.htmlreport.testwatcher.models.ReportHeadersDto;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.BufferedWriter;
import java.io.IOException;

public class ReportGeneratorRule {

    static HTMLReportGenerator htmlReportGenerator;
    BufferedWriter junitWriter = htmlReportGenerator.getJunitWriter();

    @BeforeClass
    public static void generateHTMLReport() throws IOException {
        htmlReportGenerator = HTMLReportGenerator.getInstance();
        htmlReportGenerator.generateReportFile();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        htmlReportGenerator.writeHtmlFooterAndClose();
    }

    @Rule
    public final TestRule junitWatcher = new TestWatcher() {

        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            try {
                junitWriter.write(writeScenariosInTable(description, "Passed"));
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                junitWriter.write(writeScenariosInTable(description, "Failed"));
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    };

    private  String writeScenariosInTable(Description description, String status){

        ReportHeadersDto reportHeadersDto = ReportHeadersDto.getInstance();
        reportHeadersDto.setStatus(status);
        reportHeadersDto.setScenario(description.getMethodName());
        reportHeadersDto.setScenarioDescription(description.getClassName());

        return "<tr>" +
                "<td>" + reportHeadersDto.getScenario() + "</td>" +
                "<td>" + reportHeadersDto.getScenarioDescription() + "</td>" +
                "<td>" + reportHeadersDto.getStatus() + "</td>" +
                "<td>" + reportHeadersDto.getTimeTakenToRunTest() + "</td>" +
                "</tr>" + "<br/>";
    }
}
