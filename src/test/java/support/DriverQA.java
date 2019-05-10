package support;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverQA {
	
	private static ChromeOptions options;
	
	private static WebDriver driver;
	
    public static void start(String endereco){
    	options = new ChromeOptions();
    	options.addArguments("--headless");
		options.addArguments("window-size=1200x800");
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver(options);
    	
    	driver.get(endereco);
    	driver.manage().window().maximize();
   }

	public static WebElement findElement(String campo, String tipo) {
		
		WebElement element;
		
		if (tipo.equals("xpath")) {
			element = driver.findElement(By.xpath(campo));
		}else if (tipo.equals("id")) {
			element = driver.findElement(By.id(campo));
		}else if (tipo.equals("css")) {
			element = driver.findElement(By.cssSelector(campo));
		}else {
			element = null;
		}
		
		return element;
		
	}
	
	public static void click(String campo, String tipo) {
		
		findElement(campo, tipo).click();
	}
	
	public static void waitElement(String campo, String tipo) {
		WebDriverWait driverWait = new WebDriverWait(driver, 15);
		
		if (tipo.equals("xpath")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(campo)));
		}else if (tipo.equals("id")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(campo)));
		}else if (tipo.equals("css")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(campo)));
		}
		
		
	}

	public static String getText(String campo, String tipo) {
		return findElement(campo, tipo).getText();
	}

	public static void sendKeys(String texto, String campo, String tipo) {
		findElement(campo, tipo).clear();
		findElement(campo, tipo).sendKeys(texto);
		
	}
	
	public static void selectText(String texto, String campo, String tipo) {
		WebElement element = findElement(campo, tipo);
        Select dropdown = new Select(element);
        try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        dropdown.selectByVisibleText(texto);
	}
	
	public static void PrintScreen(String nome_arquivo) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("target/reports/"+nome_arquivo+".png"));
		
	}
	
	
	
	
}
