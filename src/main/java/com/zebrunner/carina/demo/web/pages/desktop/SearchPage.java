package com.zebrunner.carina.demo.web.pages.desktop;

import com.zebrunner.carina.demo.web.components.ProductCard;
import com.zebrunner.carina.demo.web.pages.common.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//ol[@class='products list items product-items']")
    private List<ProductCard> cards;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return cards;
    }

}
