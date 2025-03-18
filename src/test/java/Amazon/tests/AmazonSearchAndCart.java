package Amazon.tests;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Amazon.TestComponents.BaseTest;
import Amazon.pages.CartPage;
import Amazon.pages.HomePage;
import Amazon.pages.ProductPage;
import Amazon.pages.ProductResultsPage;

public class AmazonSearchAndCart extends BaseTest{
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {	
    	driver = initializeDriver("edge");        
        homePage = new HomePage(driver);        
    	homePage.goTo();
    }

    @Test
    public void testAmazonSearchAndCart() throws InterruptedException {
        //Search for "iPhone 16"
        ProductResultsPage productResultsPage = homePage.searchForProduct("iPhone 16");
        
        //Scroll till the page navigation control
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,7000)");
        Thread.sleep(2500);
        
        // Click on page 2
        productResultsPage.goToPage2();
        //Click on the 5th product from the list
        String fifthProduct  =  productResultsPage.getFifthProduct();
        //System.out.println(fifthProduct);
        ProductPage productPage = productResultsPage.clickOnFifthProduct();
        //Switching to newly opened tab window
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        // Verify title in the newly opened tab
        String productTitle = productPage.getProductTitle();
        Assert.assertTrue(productTitle.contains("iPhone"), "Product title doesn't match.");
        //System.out.println(productTitle);
        Assert.assertEquals(productTitle, fifthProduct);
        
        //Add product to cart and close the side cart pop up
        productPage.addToCart();
        productPage.closeSideCartbar();
        
        //Navigate to the Cart and verify product
        CartPage cartPage = productPage.goToCart();
        
        String cartProductTitle = cartPage.getCartProductTitle();
        Assert.assertTrue(cartProductTitle.contains("iPhone"), "Product is not added to cart.");
        Assert.assertEquals(cartProductTitle, productTitle);
    }

    @AfterMethod
    public void cleanup() {
    	tearDown();
    }
}
