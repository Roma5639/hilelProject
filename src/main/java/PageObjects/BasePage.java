package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }

    public void sendKeysToWebElement(WebElement element, int howMuchTimeToWait, String text){
        WebDriverWait wait = new WebDriverWait(driver, howMuchTimeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public void clickByLocator(By locator){
        getWebElement(locator).click();
    }

    public void clickByWebElement(WebElement element){
        element.click();
    }


    public void clickByWebElement(WebElement element, int howMuchTimeToWait){
        WebDriverWait wait = new WebDriverWait(driver, howMuchTimeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitTextToBePresentInElement(By locator, String text){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator,
                text));
    }

    public void longClickByWebElement(WebElement element, String path) {

        try {
            WebElement button = driver.findElement(By.xpath(path));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath(path));
            button.click();
        }
    }

    public void waitTextToBePresentInWebElement(WebElement element, String text){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element,
                text));
    }


    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        Action mouseOver = actions.moveToElement(element).build();
        mouseOver.perform();
    }

    public void scrollDown() {
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("scroll(0, 5000)"); // if the element is at bottom.
    }

    public void isElementDisplayed(By locator){
        getWebElement(locator).isDisplayed();
    }
    public void isWebElementDisplayed(WebElement element){
        element.isDisplayed();
    }
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.RETURN);
    }

    public void waitUntilElementToBeClickableAndClick(WebElement element, int howMuchTimeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, howMuchTimeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void pageLoadTimeout() {
            driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

}