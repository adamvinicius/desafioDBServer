package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverQA {
	private WebDriver driver;
	
    public void start(String endereco){
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	driver.get(endereco);
    	driver.manage().window().maximize();
   }

	public WebElement findElement(String campo, String tipo) {
		
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
	
	public void click(String campo, String tipo) {
		
		findElement(campo, tipo).click();
	}
	
	public void waitElement(String campo, String tipo) {
		WebDriverWait driverWait = new WebDriverWait(driver, 15);
		
		if (tipo.equals("xpath")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(campo)));
		}else if (tipo.equals("id")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(campo)));
		}else if (tipo.equals("css")) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(campo)));
		}
		
		
	}

	public String getText(String campo, String tipo) {
		return findElement(campo, tipo).getText();
	}

	public void sendKeys(String texto, String campo, String tipo) {
		findElement(campo, tipo).clear();
		findElement(campo, tipo).sendKeys(texto);
		
	}
	
	public void selectText(String texto, String campo, String tipo) {
		WebElement element = findElement(campo, tipo);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(texto);
	}
	
	
	
	
}
