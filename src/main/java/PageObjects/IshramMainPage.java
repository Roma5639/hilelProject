package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IshramMainPage extends BasePage {



    @FindBy(xpath = "//*[@id=\"post-505\"]/div[2]/a")
    WebElement readMoreButton;



    public IshramMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void pressReadMoreButton(){
        clickByWebElement(readMoreButton, 10);
    }
}
