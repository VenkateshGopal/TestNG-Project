package net.docprep.commonfunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import net.docprep.applicationfunctions.ApplicationsVariables_Common;

public class CommonFunction {
	
	public static String configSheet;
	
	static Properties configProp = new Properties();
	
	//Read config file
	public static void readConfig() throws IOException {
		FileInputStream configFilePath = new FileInputStream(
				System.getProperty("user.dir") + "/Configuration/Config.properties");
		configProp.load(configFilePath);
		ApplicationsVariables_Common.testCasesPath = configProp.getProperty("TestCases");
		ApplicationsVariables_Common.testDataPath = configProp.getProperty("TestData");
		
		ApplicationsVariables_Common.refDocsPath = configProp.getProperty("ReferenceDocs");
		ApplicationsVariables_Common.exportFilePath = configProp.getProperty("ExportFilePath");
		System.out.println(ApplicationsVariables_Common.testCasesPath);
	}
	
	
}
	
