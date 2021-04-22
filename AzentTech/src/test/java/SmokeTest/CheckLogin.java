package SmokeTest;

import org.testng.annotations.Test;
import Essentials.ConfigFile;
import Essentials.ExecuteLogic;

public class CheckLogin extends ExecuteLogic {
	@Test(description = "This test cover the following scenarios :- 1) Login to Application 2) Logout of APplication")
	public void testLogin() throws Exception {
		OpenBrowser();

		ReadNAssign(ConfigFile.xlPath_credentials);
		ReadExcel_Executelogic(ConfigFile.xlPath_credentials);

		CloseBrowser();
	}

	@Override
	public void Logic(int i) throws Exception {
		// TODO Auto-generated method stub
		sheet = workbook.getSheetAt(i);
		lastrow = sheet.getLastRowNum();
		String SheetName = workbook.getSheetName(i);
		if (SheetName.equalsIgnoreCase("Creds")) {

			for (int j = 1; j <= lastrow; j++) {
				row = sheet.getRow(j);

				String Username = row.getCell(in1).toString();
				String Password = row.getCell(in2).toString();

				if (Username.equals("") || Password.equals("")) {
					break;
				}

				lc.Login(Username, Password);
				lc.Logout();
			}
		}
	}
}
