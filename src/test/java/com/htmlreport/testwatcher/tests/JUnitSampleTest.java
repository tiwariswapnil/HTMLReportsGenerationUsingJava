package com.htmlreport.testwatcher.tests;

import com.htmlreport.testwatcher.helpers.DateAndTimer;
import com.htmlreport.testwatcher.models.ReportHeadersDto;
import com.htmlreport.testwatcher.rule.ReportGeneratorRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class JUnitSampleTest extends ReportGeneratorRule {

    DateAndTimer dateAndTimer;
    ReportHeadersDto reportHeadersDto;

    @Before
    public void setUp(){
        dateAndTimer = DateAndTimer.getInstance();
        reportHeadersDto = ReportHeadersDto.getInstance();
    }

    @Test
    public void sampleTest0() {
        dateAndTimer.startRunTimer();
        assertTrue(1 < 2);
        reportHeadersDto.setTimeTakenToRunTest(dateAndTimer.stopRunTimer());
    }

    @Test
    public void sampleTest1() {

        dateAndTimer.startRunTimer();
        assertTrue(1 > 2);
        reportHeadersDto.setTimeTakenToRunTest(dateAndTimer.stopRunTimer());
    }

    @Test
    public void sampleTest2() {

        dateAndTimer.startRunTimer();
        assertTrue(1 < 2);
        reportHeadersDto.setTimeTakenToRunTest(dateAndTimer.stopRunTimer());
    }

    @Test
    public void sampleTest4() {

        dateAndTimer.startRunTimer();
        assertTrue(1 > 2);
        reportHeadersDto.setTimeTakenToRunTest(dateAndTimer.stopRunTimer());
    }

}
