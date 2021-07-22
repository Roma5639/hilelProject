package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a/img[2]")
    WebElement tokyoTalkies;

    @FindBy(xpath = "//*[@data-product-id='704']")
    WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[1]/a")
    WebElement wishlistButton;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/h3/a")
    WebElement pinkTSHIRT;

    @FindBy(xpath = "//*[@class=\"noo-search\"]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"form-control\"]")
    WebElement searchInputField;

    @FindBy(xpath = "//*[@name=\"filter_size\"]")
    WebElement filterSize;

    @FindBy(xpath = "//*[@value=\"94\"]")
    WebElement option4th;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/h3/a")
    WebElement firstProductInSearchResults;


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  public void moveMouseToTheItem(){
        scrollDown();
        moveToElement(tokyoTalkies);

  }

  public void addToWishlist(){
        clickByWebElement(addToFavoriteButton);
        clickByWebElement(wishlistButton);
    }

    public void chooseProduct(){
        waitUntilElementToBeClickableAndClick(pinkTSHIRT,10);
    }


    public void enterSearchQuery() {
        clickByWebElement(searchButton);
        sendKeysToWebElement(searchInputField, 4, "blue");
        pressEnter(searchInputField);
    }

    public void chooseSizeFilter() {
        clickByWebElement(filterSize, 5);
        clickByWebElement(option4th);
    }

    public void chooseFirstProductInSearch() {
        pageLoadTimeout();
        clickByWebElement(firstProductInSearchResults, 5);
    }

}

