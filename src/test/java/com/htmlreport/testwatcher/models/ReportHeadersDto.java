package com.htmlreport.testwatcher.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReportHeadersDto {
    public static ThreadLocal<ReportHeadersDto> reportHeadersDtoThreadLocal = new ThreadLocal<ReportHeadersDto>();

    public String scenario;
    public String scenarioDescription;
    public String status;

    public double timeTakenToRunTest;

    public static ReportHeadersDto getInstance(){
        if(reportHeadersDtoThreadLocal.get() == null){
            reportHeadersDtoThreadLocal.set(new ReportHeadersDto());
        }
        return reportHeadersDtoThreadLocal.get();
    }

    public static void setInstance(ReportHeadersDto reportHeadersDto){
        reportHeadersDtoThreadLocal.set(reportHeadersDto);
    }
}
