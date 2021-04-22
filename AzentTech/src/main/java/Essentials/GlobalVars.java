package Essentials;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalVars {
	
	
	public static WebDriver driver;
	protected static Sheet sheet;
	protected static Row row;
	protected static int lastrow;
	protected static String BrowserName, Site_url, Status, SheetName, SuiteName, TestName, TestDescription;
	
	public static WebElement dyname, ele;
	public static List<WebElement> DynamicElement;
	
	
	protected static FileInputStream fi;
	// Create workbook instance referencing the file created above
	protected static Workbook workbook = null;
	
	protected static WebDriverWait wait;
	public static WebDriverEventListener eventListener;
	public static EventFiringWebDriver ev_driver;

	protected static int in1 = 0, in2 = 0, in3 = 0, in4 = 0, in5 = 0;
	


}
