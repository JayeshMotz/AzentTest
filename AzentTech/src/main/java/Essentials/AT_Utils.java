package Essentials;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.AT.LoginClass;

public class AT_Utils extends ReadExcel {
	
    protected static Browser bw = new Browser();
    protected static LoginClass lc = new LoginClass();

    public void OpenBrowser() throws Exception {

	try {
	    bw.setup();

	    ev_driver = new EventFiringWebDriver(driver);

	    WebEventListener eventListener = new WebEventListener();
	    ev_driver.register(eventListener);

	    driver = ev_driver;

	    Site_url = ConfigFile.url;
	    driver.get(Site_url);
	    DynamicWait(AT_Locators.lpBtns);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

    public void CloseBrowser() {
	bw.CloseBrowser();
    }

    public static void ScrollPage(By Locator) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView()", driver.findElement(Locator));
    }

    public static void ScrollPage(WebElement ele) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView()", ele);
    }

    public static void DynamicWaitforElementtobePresent(By Locator) {
	dyname = null;
	System.out.println("Waiting for element to be present");
	wait = new WebDriverWait(driver, 120);

	try {
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    System.out.println("Element was not found to be present on screen, after waiting for 120 second.");
	    e1.printStackTrace();
	}

	DynamicElement = driver.findElements(Locator);
	int k = 0;
	int size = DynamicElement.size();
	for (int i = 0; i < size; i++) {
	    if (DynamicElement.get(i).isEnabled()) {
		k = i;
		break;
	    }
	}

	if (k == 0) {
	    dyname = driver.findElement(Locator);
	} else {
	    dyname = DynamicElement.get(k);
	}

	ScrollPage(dyname);

    }

    public static void DynamicWait(By Locator) throws InterruptedException {

	DynamicWaitforElementtobePresent(Locator);

	System.out.println("Waiting for Element " + dyname + " to visible");

	wait.until(ExpectedConditions.visibilityOf(dyname));
	System.out.println("Waiting for Element " + dyname + " to clickable");
	wait.until(ExpectedConditions.elementToBeClickable(dyname));
	System.out.println("Element is present and clickable");

    }

    public static void FindSheet(String Name, int i) {

	int totalSheets = workbook.getNumberOfSheets();
	int l = 0;

	for (int j = 0; j < totalSheets; j++) {
	    SheetName = workbook.getSheetName(j);
	    if (SheetName.equalsIgnoreCase(Name)) {
		l = j;
		break;
	    }
	}
	sheet = workbook.getSheetAt(i + l);
	lastrow = sheet.getLastRowNum();

    }

    @Override
    public void ReadNAssign(String XlPath) {
	// TODO Auto-generated method stub
	super.ReadNAssign(XlPath);
    }

}
