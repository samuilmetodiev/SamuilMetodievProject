package testPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTest extends TestUtil {


    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

    }


    @Test (dataProvider = "wrongUsers")
    public void unsuccessfulLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(username,password);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }


    @DataProvider(name = "wrongUsers")
    public Object[][] readUsersFromCsv() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object [][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;
        } catch (IOException e) {
            System.out.println("Not Possible to find the file!");
            return null;
        } catch (CsvException e){
            return null;
        }
    }
}


