package com.zebrunner.carina.demo.web.pages.android;

import com.zebrunner.carina.demo.web.pages.common.CartPageBase;
import com.zebrunner.carina.demo.web.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']")
    private ExtendedWebElement productHeader;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='counter plus button']")
    private ExtendedWebElement quantityUp;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='counter minus button']")
    private ExtendedWebElement quantityDown;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add To Cart button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='%s circle']")
    private ExtendedWebElement colorType;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void increaseQuantity(){
        quantityUp.click();
    }

    public void decreaseQuantity(){
        quantityDown.click();
    }

    public void addProductToCart(){
        addToCartButton.click();
    }

    public boolean isAddToCartButtonEnabled() {
        return addToCartButton.isEnabled();
    }

    public void selectColor(String color) {
        colorType.format(color).click();
    }

    public String getCartBadgeText() {
        return cartBadge.getText();
    }

    @Override
    public CartPageBase clickCartBadge() {
        cartBadge.click();
        return new CartPage(getDriver());
    }
}
