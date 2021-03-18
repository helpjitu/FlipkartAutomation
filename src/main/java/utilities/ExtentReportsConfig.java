package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsConfig {
    // directory where output is to be printed
    ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent.html");
    ExtentReports extent = new ExtentReports();
//    extent.AttachReporter(spark);


}
