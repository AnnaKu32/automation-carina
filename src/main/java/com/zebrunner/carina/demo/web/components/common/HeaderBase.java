package com.zebrunner.carina.demo.web.components.common;

import com.zebrunner.carina.demo.web.pages.desktop.RegistrationPage;
import com.zebrunner.carina.demo.web.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {
    public HeaderBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPage clickSignInLink();

    public abstract RegistrationPage clickCreateAccountLink();

    public abstract boolean isUsernameInWelcomeMessage(String username);
}
