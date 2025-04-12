package com.robloxtest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter html = new ExtentSparkReporter("test-output/roblox-report.html");
            html.config().setReportName("Roblox Selenium Test Report");
            html.config().setDocumentTitle("Roblox Automation Report");
            html.config().setEncoding("utf-8");
            html.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(html);
            extent.setSystemInfo("Tester", "Fherdy");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}