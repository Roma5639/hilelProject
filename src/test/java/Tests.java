import Base.BaseTest;
import PageObjects.*;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    /**
     * 1. Openshop.demoqa.com
     * 2. FavoriteTokyo-Talkies(AddtoWishlist)
     * 3. Openwishlist
     * 4. VerifythatTokyo-Talkiesispresentinwishlist
     */

    @Test
    public void addItemToWishlist(){
        MainPage mainPage = new MainPage(getDriver());
        WishListPage wishListPage = new WishListPage(getDriver());
        mainPage.moveMouseToTheItem();
        mainPage.addToWishlist();
        wishListPage.isItemAdded();
    }


    /**
     * 1. Openshop.demoqa.com
     * 2. Choose“PINKDROPSHOULDEROVERSIZEDTSHIRT”
     * 3. ChangeColortoPink
     * 4. Changesizeto37
     * 5. Changequantityto3
     * 6. Addtocart
     * 7. Navigatetocartandverifythatproductpresentincart
     */

    @Test
    public void addItemToCart(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.chooseProduct();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.setProductColor(productDetailsPage.productColorPink);
        productDetailsPage.setProductSize(productDetailsPage.productSizeSecondOption);
        productDetailsPage.setProductQuantity();
        productDetailsPage.addProductAndGoToCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.checkProductInCart();
    }


    /**
     * 1. Open http://shop.demoqa.com/author/lsharm/
     * 2. Tap Read more
     * 3. Try to add comment without setting captcha
     * 4. Verify that you redirected to error page with
     * “Error: You entered an incorrect CAPTCHA answer.
     * Please go back and try again.” message
     */
    @Test
    public void captchaRequiredMessageCheck(){
        getDriver().get(" http://shop.demoqa.com/author/lsharm/");
        IshramMainPage ishramMainPage = new IshramMainPage(getDriver());
        ishramMainPage.pressReadMoreButton();
        PostCommentPage postCommentPage = new PostCommentPage(getDriver());
        postCommentPage.fillRequiredFields();
        postCommentPage.pressPostCommentButton();
        postCommentPage.checkCaptchaMessageIsDisplayed();

    }

    /**
     * 1. Open http://shop.demoqa.com/
     * 2. Search “Blue” query
     * 3. Select 37 size
     * 4. Choose first one product
     * 5. Choose color
     * 6. Choose size
     * 7. Add to cart
     * 8. Navigate to cart and verify that product present in cart
     */
    @Test
    public void verifyProductPresentInCart(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.enterSearchQuery();
        mainPage.chooseSizeFilter();
        mainPage.pageLoadTimeout();
        mainPage.chooseFirstProductInSearch();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.setProductColor(productDetailsPage.productColorBlue);
        productDetailsPage.setProductSize(productDetailsPage.productSize37Option);
        productDetailsPage.addProductAndGoToCart();
        CartPage cartPage = new CartPage(getDriver());
        cartPage.checkProductInCart();

    }

}
