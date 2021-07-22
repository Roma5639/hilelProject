package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[1]/a/img")
    WebElement productInCart;



    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkProductInCart(){
        isWebElementDisplayed(productInCart);
    }
}
