package Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Amazon.AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductResultsPage extends AbstractComponent {
    WebDriver driver;

    By page2Button = By.xpath("//li[@class='s-list-item-margin-right-adjustment']/span/a[text()='2']");


    public ProductResultsPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }


    public void goToPage2() {
    	waitForpresenceOfElements(productTitles);
        driver.findElement(page2Button).click();
    }


    public ProductPage clickOnFifthProduct() {
        List<WebElement> products = getProductTitles();
        if (products.size() >= 5) {

            WebElement fifthProduct = products.get(4);
            WebElement productTitle = fifthProduct.findElement(By.cssSelector("a h2"));
            productTitle.click();
        } else {
            System.out.println("There are less than 5 products in the search results.");
        }
		return new ProductPage(driver);
        
    }
    
    public String getFifthProduct() {
        String fifthProduct = null;
    	List<WebElement> products = getProductTitles();
        if (products.size() >= 5) {
            WebElement fifthProductEle = products.get(4);
            WebElement productTitleEle = fifthProductEle.findElement(By.cssSelector("a h2"));
            fifthProduct =  productTitleEle.getText();
            
        } else {
            System.out.println("There are less than 5 products in the search results.");
        }

		return fifthProduct;
        
    }
}

