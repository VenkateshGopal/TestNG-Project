package net.docprep.commonfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.testng.base.TestBase;

import net.docprep.applicationfunctions.ApplicationsVariables_Common;

//import ApplicationsVariables_Common;

public class GetTestCases {
	
	static Properties configProp = new Properties();
	public static ExcelUtility excelutil = new ExcelUtility();
	//public static ExcelUtility excelUtil = new ExcelUtility();
	public static XSSFWorkbook wbConfig = null;
	public static XSSFWorkbook wbTestData = null;
	public static XSSFSheet wsScenariosheet = null;
	public static XSSFSheet wsTestDataSheet = null;
	public static int tcRowNum;
	public static String methodToBeExecuted = null;
	public static XmlSuite suite = new XmlSuite();
	public static XmlTest xmlTest;	
	public static XmlClass testClassAs = new XmlClass ();
	public static XmlClass testClassAsia = new XmlClass ();
	public static XmlClass testClass = new XmlClass ();
	public static List<XmlInclude> methodsToRunAs = new ArrayList<XmlInclude> ();
	public static List<XmlInclude> methodsToRunAsia = new ArrayList<XmlInclude> ();
	public static List<XmlInclude> methodsToRun = new ArrayList<XmlInclude> ();
	
	public static ArrayList<String> methodsList = new ArrayList<>();
			
	public static XmlSuite testCasesToRun() throws IOException, InvalidFormatException {
		
		FileInputStream configFilePath = new FileInputStream(
				System.getProperty("user.dir") + "/Configuration/Config.properties");
		configProp.load(configFilePath);
		ApplicationsVariables_Common.testCasesPath = configProp.getProperty("TestCases");
		ApplicationsVariables_Common.testDataPath = configProp.getProperty("TestData");
		
		ApplicationsVariables_Common.refDocsPath = configProp.getProperty("ReferenceDocs");
		ApplicationsVariables_Common.exportFilePath = configProp.getProperty("ExportFilePath");
		//System.out.println(ApplicationsVariables_Common.testCasesPath);
		wbConfig = new XSSFWorkbook(new File(ApplicationsVariables_Common.testCasesPath));
		wbTestData = new XSSFWorkbook(new File(ApplicationsVariables_Common.testDataPath));
		wsScenariosheet= wbConfig.getSheet("Config");
		
		Iterator<Row> rowIterator = wsScenariosheet.iterator();
		rowIterator.next();	
		generateTestNGSuite();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int rowNum= row.getRowNum();
			String ScenarioToBeExecute= excelutil.getcellvalue("Run Mode", rowNum, wsScenariosheet);
			String ScenarioName= excelutil.getcellvalue("Scenario Name", rowNum, wsScenariosheet);
			String ModuleName= excelutil.getcellvalue("Module Name", rowNum, wsScenariosheet);
			if(ScenarioToBeExecute.equalsIgnoreCase("Y")) {
			wsTestDataSheet= wbTestData.getSheet(ScenarioName);
			//System.out.println("wsTestDataSheet" + ScenarioName);
			Iterator<Row> tcIterator = wsTestDataSheet.iterator();
			tcIterator.next();
			while (tcIterator.hasNext()) {
				Row tcRow = tcIterator.next();
				tcRowNum = tcRow.getRowNum();
				String tcName= excelutil.getcellvalue("scenario", tcRowNum, wsTestDataSheet);
				String tcToBeExecuted = excelutil.getcellvalue("RunMode", tcRowNum, wsTestDataSheet);
				if(tcToBeExecuted.equalsIgnoreCase("Y")) {
					methodToBeExecuted = tcName;
					System.out.println(methodToBeExecuted);
					methodsList.add(methodToBeExecuted);					
					}
				}
			}
			wsTestDataSheet= wbTestData.getSheet(ScenarioName);
		}
		wbConfig.close();
		/*testClassAs.setName("net.docprep.commonfunctions.AfterSuiteTest");
		methodsToRunAs.add(new XmlInclude("afterSuite"));
		testClassAs.setIncludedMethods(methodsToRunAs);*/
		for (String tc : methodsList) {
			System.out.println(tc);			
				methodsToRun.add(new XmlInclude(tc));
				//System.out.println("TC Selected for non ASIA");
				testClass.setName("com.testng.test.SignInPageTest");
				testClass.setIncludedMethods(methodsToRun);
				boolean flag = methodsToRun.isEmpty();
				if(flag ==false) {
					xmlTest.setXmlClasses(Arrays.asList(new XmlClass[] {testClass,testClassAs} ));				
			}
		}	
		return suite;
	}
	
	@SuppressWarnings("deprecation")
	public static void generateTestNGSuite() {
		suite.setName("DocPrep Automation");
		suite.setThreadCount(10);
		
		xmlTest = new XmlTest(suite);
		xmlTest.setName("Regression");
		xmlTest.setPreserveOrder("true");
		
	}
	
	public static void writeTestngXml() throws IOException {
		File file = new File("testng01.xml");
		System.out.println("file " + file);
		
		FileWriter writer = new FileWriter(file);
		writer.write(suite.toXml());
		writer.close();
	}
	@Test
	//@BeforeMethod
	public static void getCases() throws Exception {
		System.out.println("get cases");
		testCasesToRun();
		writeTestngXml();
	}

}
