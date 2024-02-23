package com.zebrunner.carina.demo.web.pages.common;

import com.zebrunner.carina.demo.web.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ProductCard> getCards();

}
