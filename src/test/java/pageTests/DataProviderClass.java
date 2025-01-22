package pageTests;



import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import utilities.ExcelReader;
import utilities.ConfigReader;
import utilities.Utility_Methods;


public class DataProviderClass {
	
	ConfigReader reader = new ConfigReader();
	ExcelReader excelReader = new ExcelReader(ConfigReader.getexcelfilepath());
	
	@DataProvider(name = "ValidLoginData")
	public String[][] getValidLoginData() throws IOException {
		int totalrows = excelReader.getRowCount("Login");
		int totalcols = excelReader.getCellCount("Login", 1);
		System.out.println("The Total Rows : " + totalrows);
		System.out.println("The Total Coulmns : " + totalcols);
		String[][] validLoginData = new String[1][3];
		validLoginData[0][0] = excelReader.getCellData("Login", 1, 0);
		validLoginData[0][1] = excelReader.getCellData("Login", 1, 1);
		validLoginData[0][2] = excelReader.getCellData("Login", 1, 2);
		return validLoginData; 
	}
	
	@DataProvider(name = "InValidLoginData")
	public String[][] getInValidLoginData() throws IOException {
		int totalrows = excelReader.getRowCount("Login");
		int totalcols = excelReader.getCellCount("Login", 1);
		String[][] invalidLoginData = new String[totalrows-1][3];
		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				invalidLoginData[i - 2][j] = excelReader.getCellData("Login", i, j);
			}
		}
		return invalidLoginData;
	}
	
	@DataProvider (name = "arrayexcel-reader")
	public Object[][] readCodeFromExcelSheet(Method m){
		Object[][] data = Utility_Methods.getTestDataFromExcel("ArrayCode");
		String code = null;
		String output = null;
		if (m.getName() == "testTryEditorWithValidCode") {
			code = (String)data[0][0];
			output = (String)data[0][1];
		} else if (m.getName() == "testTryEditorWithInvalidCode") { 
			code = (String)data[1][0];
			output = (String)data[1][1];
		}
		
		return new Object[][] {
			{code, output, 0},
			{code, output, 1},
			{code, output, 2},
			{code, output, 3},
		};
	}
	
	
	@DataProvider(name="Array Topics")
	public Object[][] topicsLinkedlist() {
		return new Object[][] {
			{0,"Arrays in Python","Assessment"},
			{1,"Arrays Using List","Assessment"},
			{2,"Basic Operations in Lists","Assessment"},
			{3,"Applications of Array","Assessment"}
		};
	}	

	@DataProvider (name = "Valid Python Code")
	public String[][] codeData() throws IOException {
		String codeValue = excelReader.getCellData("LLStackCode", 1, 0);
		String outputValue = excelReader.getCellData("LLStackCode", 1, 1);
		
		String code [][] = {
			{codeValue, outputValue}
		};
		
		return code;
	}

	@DataProvider (name = "Invalid Python Code")
	public String [][] invalidCodeData() throws IOException {
				String codeValue = excelReader.getCellData("LLStackCode", 2, 0);
				String outputValue = excelReader.getCellData("LLStackCode", 2, 1);
				String code[][]= {
				{codeValue,outputValue}
			};
				
		return code;
	}

	@DataProvider (name = "Open Sub Pages")
	public String [][] subPageExpUrl() throws IOException{
		int totalRows = excelReader.getRowCount("LLSubPages");
		String subPageExpUrl [][] = new String[totalRows][2];
		for (int rowIdx = 1; rowIdx <= totalRows; rowIdx++) {
			for (int colIdx = 0; colIdx <= 1; colIdx++) {
				subPageExpUrl[rowIdx - 1][colIdx] = excelReader.getCellData("LLSubPages", rowIdx, colIdx);
				}
		}
		return subPageExpUrl;
	}

	@DataProvider (name = "Open Try Editor From Sub Pages")
	public String [][] subPageTryEditorUrl() throws IOException{
		int totalRows = excelReader.getRowCount("TryEditorSubPages");
		String subPageTryEditorUrl [][] = new String [totalRows][2];
		for (int rowIdx = 1; rowIdx <= totalRows; rowIdx++) {
			for (int colIdx = 0; colIdx <= 1; colIdx++) {
				subPageTryEditorUrl[rowIdx -1][colIdx] = excelReader.getCellData("TryEditorSubPages", rowIdx, colIdx);
			}
		}
		return subPageTryEditorUrl;
	}

	@DataProvider (name = "Open Stack Sub Pages")
	public String [][] stackSubPageExpUrl() throws IOException {
		int totalRows = excelReader.getRowCount("StackSubPages");
		String  stackSubPageExpUrl[][] = new String [totalRows][2];
		for (int rowIdx = 1; rowIdx <= totalRows; rowIdx++) {
			for (int colIdx = 0; colIdx <=1; colIdx++) {
				stackSubPageExpUrl [rowIdx -1][colIdx] = excelReader.getCellData("StackSubPages", rowIdx, colIdx);
			}
		}
		return stackSubPageExpUrl;
	}
	
	@DataProvider (name = "Open Try Editor from Stack Sub pages")
	public String [][] stackSubPageTryEditorUrl () throws IOException{
		int totalRows = excelReader.getRowCount("StackTryEditorSubPages");
		String stackSubPageTryEditorUrl[][] = new String [totalRows][2];
		for (int rowIdx = 1; rowIdx <= totalRows; rowIdx++) {
			for (int colIdx = 0; colIdx <=1; colIdx++) {
				stackSubPageTryEditorUrl [rowIdx -1] [colIdx] = excelReader.getCellData("StackTryEditorSubPages", rowIdx, colIdx);
			}
		}
		return stackSubPageTryEditorUrl;
	}


@DataProvider (name = "Valid Input")
public String[][] CodeData() throws IOException {
	String codeValue = excelReader.getCellData("QueueCode", 1, 0);
	String outputValue = excelReader.getCellData("QueueCode", 1, 1);
	
	String code [][] = {
		{codeValue, outputValue}
	};
	
	return code;
}

@DataProvider (name = "Invalid Input")
public String [][] InvalidCodeData() throws IOException {
			String codeValue = excelReader.getCellData("QueueCode", 2, 0);
			String outputValue = excelReader.getCellData("QueueCode", 2, 1);
			String code[][]= {
			{codeValue,outputValue}
		};
			
	return code;
}
@DataProvider (name = "Graph Valid Input")
public String[][] GraphCodeData() throws IOException {
	String codeValue = excelReader.getCellData("GraphCode", 1, 0);
	String outputValue = excelReader.getCellData("GraphCode", 1, 1);
	
	String code [][] = {
		{codeValue, outputValue}
	};
	
	return code;
}

@DataProvider (name = "Graph Invalid Input")
public String [][] GraphInvalidCodeData() throws IOException {
			String codeValue = excelReader.getCellData("GraphCode", 2, 0);
			String outputValue = excelReader.getCellData("GraphCode", 2, 1);
			String code[][]= {
			{codeValue,outputValue}
		};
			
	return code;
}
}