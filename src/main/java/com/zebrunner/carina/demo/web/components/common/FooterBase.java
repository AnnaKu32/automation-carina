package com.zebrunner.carina.demo.web.components.common;

import com.zebrunner.carina.demo.web.pages.desktop.AdvancedSearchFormPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class FooterBase extends AbstractUIObject {

    public FooterBase(WebDriver driver) {
        super(driver);
    }

    public abstract AdvancedSearchFormPage clickAdvancedSearchLink();
}
