package com.testng.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static String testResultFolderName;
	private static ExtentReports extent;
	
	//testResultFolderName= new SimpleD
	public static String reportFileName; //= "Test-Automation-Report"+".html";
	public static String fileSeperator; // = System.getProperty("file.separator");
	public static String reportFilePath; //= System.getProperty("user.dir")+fileSeperator+"TestReport";
	public static String reportFileLocation; //= reportFilePath+fileSeperator+reportFileName;
	
	
	/*public static void main(String[] args) {
		//getReportPath(reportFilePath);
		reportFilePath = System.getProperty("user.dir")+fileSeperator+"TestReport";
		getInstance();
	}*/
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}

	public static ExtentReports createInstance() {
		String fileName = getReportPath(reportFilePath);
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(fileName);
		htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReport.config().setChartVisibilityOnOpen(true);
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setDocumentTitle(reportFileName);
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setReportName(reportFileName);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("AUT", "QA");
		return extent;
		
	}
	
	private static String getReportPath(String path) {
		//testResultFolderName + "\\"+
		testResultFolderName = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		reportFileName= "Test-Automation-Report"+".html";
		fileSeperator = System.getProperty("file.separator");
		String reportFilePath= System.getProperty("user.dir")+fileSeperator+"TestReport"+"\\"+testResultFolderName;
		String reportFileLocation= reportFilePath+fileSeperator+reportFileName;
		
		//String path =reportFilePath;
		//System.out.println(path);
		File testDirector = new File(reportFilePath);
		if(!testDirector.exists()) {
			if(testDirector.mkdir()) {
				System.out.println("Director: " + reportFilePath + " is Created");
				return reportFileLocation;
				
			} else {
				System.out.println("Failed to create Director :" + reportFilePath);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + reportFilePath);
		}
		return reportFileLocation;
	}
}
