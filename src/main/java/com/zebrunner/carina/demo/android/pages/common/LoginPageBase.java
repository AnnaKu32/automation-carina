package com.zebrunner.carina.demo.web.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void putUserDataToForm(String user, String password);

    public abstract boolean isErrorMessageDisplayed();
}
