# HTMLReportsGenerationUsingJava

This project has been implemented to enable the capability of customised HTML reports generation for JUnit tests. It has been achieved through JUnit's TestWatcher class.
It provides <succeeded()> and <failed()> methods which have been overridden as part of a rule created in `ReportGeneratorRule` class. Depending upon the status of a JUnit test, the corresponding method is invoked.

The HTML report gets generated in a tabular format.
The methods have the ability to write the scenario level information in rows under that table.

## Sample Usage

To include HTML report generation capability for a JUnit test

1. Extend the `ReportGeneratorRule` class in the Junit test class
```
    public class JUnitSampleTest extends ReportGeneratorRule
```

2. Create a ReportHeadersDto object in the class and set the members of the object at the appropriate places. These values will be later populated in the HTML report
```
    dateAndTimer.startRunTimer();
    assertTrue(1 < 2);
    reportHeadersDto.setTimeTakenToRunTest(dateAndTimer.stopRunTimer());
```

For reference of a sample usage, refer to - `/src/test/java/com/htmlreport/testwatcher/tests/JUnitSampleTest.java`