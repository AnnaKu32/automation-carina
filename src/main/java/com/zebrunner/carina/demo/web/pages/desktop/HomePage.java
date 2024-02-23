package com.zebrunner.carina.demo.web.pages.desktop;

import com.zebrunner.carina.demo.web.pages.common.HomePageBase;
import com.zebrunner.carina.demo.web.components.Footer;
import com.zebrunner.carina.demo.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {

    @FindBy(xpath = "//header")
    private Header header;

    @FindBy(xpath = "//footer")
    private Footer footer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("base"));
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}


