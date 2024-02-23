package com.zebrunner.carina.demo.web.components.mobile;

import com.zebrunner.carina.demo.web.components.common.NavBarMenuBase;
import com.zebrunner.carina.demo.web.pages.android.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavBarMenu extends NavBarMenuBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='menu item log in']")
    private ExtendedWebElement logInLink;

    public NavBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public LoginPage clickLogInLink() {
        logInLink.click();
        return new LoginPage(getDriver());
    }
}
