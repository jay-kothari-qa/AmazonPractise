package Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Amazon.AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent{
    WebDriver driver;

    By productTitle = By.id("productTitle");
    By addToCartButton = By.xpath("(//span[@id='submit.add-to-cart'])[2]");
    By closeSideCart = By.id("attach-close_sideSheet-link");


    public ProductPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }


    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
    
    public void closeSideCartbar() {
    	waitForpresenceOfElements(closeSideCart);
        driver.findElement(closeSideCart).click();
    }
    

    
}
