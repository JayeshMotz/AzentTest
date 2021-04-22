package Essentials;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExecuteLogic extends AT_Utils {

    public abstract void Logic(int i) throws Exception;

    // Reading excel sheet and executing user given logic
    public void ReadExcel_Executelogic(String Filepath) throws Exception {

	String FilePath = Filepath;

	try {
	    fi = new FileInputStream(FilePath);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	Thread.sleep(ConfigFile.Medium_Wait);

	String FileExt = FilePath.substring(FilePath.indexOf("."));

	if (FileExt.equals(".xlsx")) {
	    workbook = new XSSFWorkbook(fi);
	} else if (FileExt.equals(".xls")) {
	    workbook = new HSSFWorkbook(fi);
	}

	int totalSheet = workbook.getNumberOfSheets();

	if (totalSheet < 0) {
	    System.out.println("The File Is Empty!!!");
	} else {
	    for (int i = 0; i < 1; i++) {

		Logic(i);
		Status = "passed";

	    }
	}

	fi.close();

    }

}
