package Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Amazon.AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By cartButton = By.name("submit.addToCart");

    public HomePage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }
    

    public ProductResultsPage searchForProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(productName);
        driver.findElement(searchButton).click();
        waitForpresenceOfElements(cartButton);
        return new ProductResultsPage(driver);
		
    }
    
	public void goTo()
	{
		driver.get("https://www.amazon.in/");
	}
}