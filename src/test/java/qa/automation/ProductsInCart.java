package qa.automation;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;




public class ProductsInCart extends TestUtil {


    @Test
    public void addItemsToCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemsToCart("bike-light");
        productsPage.addItemsToCart("backpack");

        Assert.assertEquals(productsPage.getItemsInTheCart(),2);

    }
}
