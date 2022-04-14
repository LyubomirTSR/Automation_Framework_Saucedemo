package qa.automation;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProducts extends TestUtil {

    @Test
    public void addItemsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemsToCart("fleece-jacket");
        productsPage.addItemsToCart("onesie");

        WebElement cart_button = driver.findElement(By.className("shopping_cart_link"));
        cart_button.click();

        WebElement checkout_button = driver.findElement(By.id("checkout"));
        checkout_button.click();

        WebElement first_name = driver.findElement(By.id("first-name"));
        first_name.click();
        first_name.sendKeys("Lyubomir");

        WebElement last_name = driver.findElement(By.id("last-name"));
        last_name.click();
        last_name.sendKeys("Rangelov");

        WebElement post_code = driver.findElement(By.id("postal-code"));
        post_code.click();
        post_code.sendKeys("1000");

        WebElement continue_button = driver.findElement(By.id("continue"));
        continue_button.click();

        WebElement Finish_button = driver.findElement(By.id("finish"));
        Finish_button.click();

        WebElement showBUtton = driver.findElement(By.className("pony_express"));
        Assert.assertTrue(showBUtton.isDisplayed());

    }


}
