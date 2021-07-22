package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailsPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"pa_color\"]")
    WebElement productColorField;

    @FindBy(xpath = "//*[@value=\"pink\"]")
    public WebElement productColorPink;

    @FindBy(xpath = "//*[@id=\"pa_size\"]")
    WebElement productSizeField;

    @FindBy(xpath = "//*[@id=\"pa_size\"]/option[3]")
    public WebElement productSizeSecondOption;

    @FindBy(xpath = "//*[@id=\"pa_size\"]/option[3]")
    public WebElement productSize37Option;

    @FindBy(xpath = "//*[@value=\"blue\"]")
    public WebElement productColorBlue;

    @FindBy(xpath = "//*[@class=\"qty-increase\"]")
    WebElement productQtyIncreaseButton;

    @FindBy(xpath = "//*[@class=\"single_add_to_cart_button button alt\"]")
    WebElement addProductToCartButton;

    @FindBy(xpath = "//*[@class=\"woocommerce-Price-amount amount\"]")
    WebElement cartButton;

    public final String pathToCartButton = "//*[@class=\"woocommerce-Price-amount amount\"]";



    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setProductColor(WebElement color){
        waitUntilElementToBeClickableAndClick(productColorField, 10);
        clickByWebElement(color);

    }

    public void setProductSize(WebElement size){
        clickByWebElement(productSizeField);
        clickByWebElement(size);
    }

    public void setProductQuantity(){
        clickByWebElement(productQtyIncreaseButton);
        clickByWebElement(productQtyIncreaseButton);
    }

    public void addProductAndGoToCart(){
        clickByWebElement(addProductToCartButton);
        longClickByWebElement(cartButton, pathToCartButton);
    }
}
