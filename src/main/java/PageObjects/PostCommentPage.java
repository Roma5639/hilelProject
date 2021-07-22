package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostCommentPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"author\"]")
    WebElement yourNameField;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement yourEmailField;

    @FindBy(xpath = "//*[@id=\"comment\"]")
    WebElement yourCommentField;

    @FindBy(css = "#submit")
    WebElement postCommentButton;

    @FindBy(xpath = "//*[@id=\"error-page\"]")
    WebElement warningMessage;


    String commentText  = "Some Comment";

    String email  = "testwork2021@gmail.com";

    String name  = "Roman";


    public PostCommentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void fillRequiredFields(){
        sendKeysToWebElement(yourNameField, 10, name);
        sendKeysToWebElement(yourEmailField, 10, email);
        sendKeysToWebElement(yourCommentField, 10, commentText);
    }


    public void pressPostCommentButton(){
        clickByWebElement(postCommentButton, 5);
    }

    public void checkCaptchaMessageIsDisplayed(){
        waitTextToBePresentInWebElement(warningMessage, "Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");

    }
}
