package testPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends TestUtil {

    @Test
    public void addItemsToTheCart(){
        LoginPage loginTest = new LoginPage(driver);
        ProductPage productPage = loginTest.login("standard_user", "secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        productPage.addItemToTheCart("backpack");
        softAssert.assertEquals(productPage.getItemsCart(), 1);

        productPage.addItemToTheCart("bolt-t-shirt");
        softAssert.assertEquals(productPage.getItemsCart(), 2);

        productPage.addItemToTheCart("bike-light");
        softAssert.assertEquals(productPage.getItemsCart(), 3);

        softAssert.assertAll();

    }
}
