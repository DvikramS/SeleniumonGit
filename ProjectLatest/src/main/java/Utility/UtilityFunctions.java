package Utility;

import java.util.Hashtable;

import BasePage.Base;

public class UtilityFunctions {
	
	public static int testdataset;
	
	public static boolean IsExecutable(String testName, ExcelUtility xls) {
		for (int rNum = 2; rNum <= xls.getRowCount("TestCases"); rNum++) {
			if (testName.equals(xls.getCellData("TestCases", "TCID", rNum))) {
				if (xls.getCellData("testCases", "RunMode", rNum).equals("Y"))
					return true;
				else
					return false;
			}// end
		}
		return false;
	}
	public static int getRow(String testName, ExcelUtility xls) {
		int row=-1;
		for (int rNum = 2; rNum <= xls.getRowCount("TestCases"); rNum++) {
			if (testName.equals(xls.getCellData("TestCases", "TCID", rNum))) {
				row=rNum;
			}
		}
		return row;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	// Read data from the excel file. Takes two arguments - Test Case Name and
	// XLS_Reader object. Reads the test data from the Test Data excel and
	// return the test data in 2 D object array form
	public static Object[][] getData(String TestCaseName, ExcelUtility xls) {
		// find test in the excel file
		// find number of columns in the test
		// find number of rows in the test
		// print the data of the test
		// put the data in object array

		// Get the start row index for the test data of the given Test Case name
		int testCaseStartIndex = 0;

		for (int rNum = 1; rNum <= xls.getRowCount("TestData"); rNum++) {
			if (TestCaseName.equals(xls.getCellData("TestData", 1, rNum))) {
				testCaseStartIndex = rNum;
				break;
			}// end of if
		}// end of for
System.out.println(testCaseStartIndex);
		// Get the number of columns in the test data (which is available column
		// wise) for the given test case
		int testCaseDataColumnNamesStartIndex = testCaseStartIndex + 1;

		int Cols = 2;
		while (!(xls.getCellData("TestData", Cols,testCaseDataColumnNamesStartIndex).equals(""))) {
			Cols++;

		}// end of while

		int numberOfTestDataColumns = Cols - 2;

		int testCaseDataStartIndex = testCaseStartIndex + 2;

		int rows = 0;
		while (!xls.getCellData("TestData", 2, (testCaseDataStartIndex + rows))
				.equals("")) {
			rows++;
		} // end of while
		int numberofTestDataSets = rows;
		testdataset=numberofTestDataSets;
		// Store the test data sets of a single test case in an array of
		// HashTable. Each HasTable will contain one test data set
		Object[][] dataSetCollection = new Object[numberofTestDataSets][1];

		Hashtable<String, String> TestDataSet = null;
		String Datakey = "'";
		String Keyvalue = "";
		int index = 0;
		for (int r = testCaseDataStartIndex; r < (testCaseDataStartIndex + numberofTestDataSets); r++) {
			TestDataSet = new Hashtable<String, String>();

			for (int c = 2; c < (numberOfTestDataColumns + 2); c++) {

				Datakey = xls.getCellData("TestData", c,
						testCaseDataColumnNamesStartIndex);
				
				Keyvalue = xls.getCellData("TestData", c, r);
				TestDataSet.put(Datakey, Keyvalue);

			}// end of for
				// Once all the Column Name Value pair is stored in the
				// HashTable for a row, add this Hash Table in the 2 D array of
				// Objects
			dataSetCollection[index][0] = TestDataSet;
			index++;
		}// end of for

		return dataSetCollection;

	}// end of function
	
	// --------------------------------------------------------------------------------------------------------------------------------

	// Converts the ArrayList to comma separated string. Take argument as Array
	// List of type string and returns a comma separated string containing all
	// the values of the Array List
public static void main(String[] args) {
	boolean b=UtilityFunctions.IsExecutable("VerifyLogin", Base.xl);
	System.out.println(b);
}

}
