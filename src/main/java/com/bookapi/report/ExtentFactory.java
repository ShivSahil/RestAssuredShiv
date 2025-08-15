package com.bookapi.report;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bookapi.logs.ConsoleColors;


public class ExtentFactory implements ITestListener {
	
	private static ThreadLocal<ExtentTest> extent = new ThreadLocal<>();
	private static ExtentReports report;
	private static ExtentFactory instance = new ExtentFactory();

//	// class with private constructor can not be initialized
//	private ExtentFactory() { 
//	}

	// ONLY ONE instance of extentfactory class exists
	public static ExtentFactory getInstance() {
		return instance;
	} 
	
	public ExtentTest getExtentTest() {
		return extent.get();
	}

	public void onStart(ITestContext context) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd_MMMM_hh_a_mm_ss");
		String name = simpledate.format(cal.getTime());

		// Path makes sure that codes works with both ubuntu and windows
		String path = Paths.get(System.getProperty("user.dir"), "report", name + "_Report.html").toString();

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Name of Report created by Shiv Sahil Guleri");
		reporter.config().setDocumentTitle("Title of page created by Shiv Sahil Guleri");

		report = new ExtentReports();
		report.attachReporter(reporter);
		// name of the tester and environment is harcoded to my name. But I can easily
		// replace with them with data from config.properties
		report.setSystemInfo("Automation Tester", "Shiv Sahil Guleri");
		report.setSystemInfo("Contact Details", "+91 8209060559");

	}

	public void onTestStart(ITestResult result) {
		
		ExtentTest extentTest = report.createTest(result.getMethod().getDescription());
		System.out.println(ConsoleColors.BLUE_UNDERLINED+result.getMethod().getMethodName()+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE+result.getMethod().getDescription()+ConsoleColors.RESET);
		extent.set(extentTest);
	}


	public void onTestSkipped(ITestResult result) {
		extent.get().fail(result.getMethod().getDescription() + " skipped");
		System.out.println("===============TEST CASES ENDED======================");
	}
	
	public void onTestFailure(ITestResult result) {
		extent.get().fail(result.getMethod().getDescription() + " failed: " + result.getThrowable());
		System.out.println("===============TEST CASES ENDED======================");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("===============TEST CASES ENDED======================");
	}


	public void onFinish(ITestContext context) {
		report.flush();
	}
}
