package com.zebrunner.carina.demo.web.pages.common;

import com.zebrunner.carina.demo.web.components.Footer;
import com.zebrunner.carina.demo.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public abstract Header getHeader();

    public abstract Footer getFooter();

}
