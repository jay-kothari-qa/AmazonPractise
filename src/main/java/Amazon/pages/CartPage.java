package Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Amazon.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    By cartProductTitle = By.xpath("//div[@class='sc-list-item-content']//span[@class='a-truncate-cut']");

    public CartPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    public String getCartProductTitle() {
        return driver.findElement(cartProductTitle).getText();
    }
}
