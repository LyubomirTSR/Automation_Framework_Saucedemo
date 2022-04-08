package qa.automation;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;
import java.io.IOException;

public class UnsuccessfulLogin extends TestUtil {

    @DataProvider(name = "csvWrongUserList")
    public static Object[][] readUsersFromWrongCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/wrongUsers.csv");
    }

    @Test(dataProvider = "csvWrongUserList")
    public void UnsuccessfulLoginTest(String accountName , String password){

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(accountName, password);

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }

}
