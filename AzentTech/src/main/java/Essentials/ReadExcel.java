package Essentials;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel extends GlobalVars {

    public void ReadNAssign(String XlPath) {

	ArrayList<String> HeaderList = new ArrayList<String>();

	try {
	    String FilePath = XlPath;
	    fi = new FileInputStream(FilePath);
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

		for (int i = 0; i < totalSheet; i++) {
		    sheet = workbook.getSheetAt(i);
		    row = sheet.getRow(0);
		    SheetName = workbook.getSheetName(i);

		    int MaxCell = row.getLastCellNum();

		    for (int j = 0; j < MaxCell; j++) {
			Cell cel = row.getCell(j);
			if (cel.toString() == "") {
			    break;
			}

			if (SheetName.equalsIgnoreCase("Creds")) {
			    HeaderList.add(cel.toString());
			}
			if (SheetName.equalsIgnoreCase("emailDetails")) {
			    HeaderList.add(cel.toString());
			}
		    }
		}

		// Seed Data

		if (!HeaderList.isEmpty()) {
		    in1 = HeaderList.indexOf("UserName");
		    in2 = HeaderList.indexOf("Password");
		}
	    }
	    fi.close();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    // driver.quit();
	}
    }

}
