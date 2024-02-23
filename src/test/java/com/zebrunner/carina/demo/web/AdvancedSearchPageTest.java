package com.zebrunner.carina.demo.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.web.pages.common.SearchPageBase;
import com.zebrunner.carina.demo.web.pages.desktop.AdvancedSearchFormPage;
import com.zebrunner.carina.demo.web.pages.desktop.HomePage;
import com.zebrunner.carina.demo.web.pages.common.HomePageBase;
import com.zebrunner.carina.demo.web.components.ProductCard;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.zebrunner.carina.demo.enums.ProductDetail.*;
import static com.zebrunner.carina.demo.enums.Status.FAIL;
import static com.zebrunner.carina.demo.enums.Status.SUCCESS;

public class AdvancedSearchPageTest extends AbstractTest {

    @DataProvider(name = "useAdvancedSearchTestData")
    public Object[][] searchAdvancedDataProvider() {
        return new Object[][]{
                {PRODUCT_NAME1, QUANTITY, INVALID, INVALID, PRICE_FROM, PRICE_TO, SUCCESS},
                {PRODUCT_NAME1, QUANTITY, INVALID, INVALID, PRICE_TO, PRICE_FROM, FAIL},
                {INVALID, INVALID, INVALID, INVALID, INVALID, INVALID, FAIL},
        };
    }

    @Test(dataProvider = "useAdvancedSearchTestData", description = "JIRA#DEMO-B001")
    public void verifySearchForm(ProductDetail productName, ProductDetail sku, ProductDetail description, ProductDetail shortDescription,
                                 ProductDetail priceFrom, ProductDetail priceTo, Status message){

        HomePageBase page = new HomePage(getDriver());
        page.open();
        Assert.assertTrue(page.isPageOpened(), "Home page doesn't open");

        AdvancedSearchFormPage advancedSearchForm =  page.getFooter().clickAdvancedSearchLink();
        advancedSearchForm.putDataToSearchForm(String.valueOf(productName), String.valueOf(sku),
                String.valueOf(description), String.valueOf(shortDescription), String.valueOf(priceFrom), String.valueOf(priceTo));

        SearchPageBase searchPage =  advancedSearchForm.clickSearchButton();
        Assert.assertTrue(page.getCurrentUrl().toLowerCase().contains(String.valueOf(productName).toLowerCase().replace(" ", "+")),
                "URL doesn't contain the product");
        List<ProductCard> cards = searchPage.getCards();

        if(message.equals(SUCCESS)){
            for (ProductCard card: cards){
                Assert.assertTrue(card.getTitleText().toLowerCase().contains(String.valueOf(productName).toLowerCase()),
                        String.format("Product with name '%s doesn't contain the product name in it's title", card.getTitleText()));
            }
        } else {
            Assert.assertTrue(advancedSearchForm.isPageOpened(), "Test failed because the user didn't stay on the advanced search page");
        }
    }

}
