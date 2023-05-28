package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends  BasePage {

    @FindBy(id = "shopping_cart_container")
    private WebElement cartBtn;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(id = "pony_express")
    private WebElement completeImage;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public pageCheckout(String username, String lastname, int postcode) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(username);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys((String.valueOf(postcode)));

        finishBtn.click();

        return new pageCheckout


    }
}




