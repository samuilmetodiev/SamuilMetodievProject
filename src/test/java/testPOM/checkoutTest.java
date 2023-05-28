package testPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class checkoutTest extends TestUtil {




    @Test
    private void successfulCheckout(){
        LoginPage loginTest = new LoginPage(driver);
        ProductPage productPage = loginTest.login("standard_user", "secret_sauce");

        productPage.addItemToTheCart("backpack");
        Assert.assertEquals(productPage.getItemsCart(), 1);

        CheckoutPage.

    }






}
