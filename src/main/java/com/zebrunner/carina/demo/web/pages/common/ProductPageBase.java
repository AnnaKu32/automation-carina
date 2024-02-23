package com.zebrunner.carina.demo.web.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectSize(String size);

    public abstract void selectColor(String color);

    public abstract void clickAddToCart();

    public abstract boolean verifyProductAddedToCart(String product);

    public abstract boolean isErrorMessageDisplayed();
}
