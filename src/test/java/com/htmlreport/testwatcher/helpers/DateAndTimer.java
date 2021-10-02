package com.htmlreport.testwatcher.helpers;

import org.apache.commons.lang3.time.StopWatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateAndTimer {

    private StopWatch runTimer;
    private static DateAndTimer instance = null;

    public static DateAndTimer getInstance(){
        if(instance == null){
            instance = new DateAndTimer();
        }
        return instance;
    }

    public void startRunTimer(){
        runTimer = new StopWatch();
        runTimer.start();
    }

    public long stopRunTimer(){
        runTimer.stop();
        return runTimer.getTime(TimeUnit.SECONDS);
    }

    public String getCurrentDateTimeStamp() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
        sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        return sdf.format(date);

    }

}
