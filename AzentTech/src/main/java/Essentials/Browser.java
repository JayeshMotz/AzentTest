package Essentials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser extends GlobalVars {

    public WebDriver setup() {

	System.setProperty(ConfigFile.webDriver_chrome_property, ConfigFile.chromeDriver_path_76);

	try {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}

	return driver;
    }

    public void CloseBrowser() {
	try {
	    System.out.println("Reached the end, now the session will terminate");
	    driver.quit();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
