package com.zebrunner.carina.demo.web.pages.common;

import com.zebrunner.carina.demo.web.components.common.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderBase getHeader();

    public abstract ProductPageBase clickProductItem();

}
