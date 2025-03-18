package Amazon.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Amazon.pages.CartPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
	}
	
    By cartIconButton = By.id("nav-cart");
    protected By productTitles = By.cssSelector(".s-main-slot .s-result-item");
    By cartProductTitle = By.xpath("//div[@class='sc-list-item-content']//span[@class='a-truncate-cut']");
    
	    public CartPage goToCart() 
	    {
	       driver.findElement(cartIconButton).click();
	       waitForpresenceOfElements(cartProductTitle);
	       return new CartPage(driver);
	    }
	   
	    public void waitForpresenceOfElements(By by)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	    }
	    
	    public List<WebElement> getProductTitles() 
	    {
	    	waitForpresenceOfElements(productTitles);
	        return driver.findElements(productTitles);
	    }
}
