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
}
