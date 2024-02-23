package com.zebrunner.carina.demo.android;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.enums.ProductDetail;
import com.zebrunner.carina.demo.enums.Status;
import com.zebrunner.carina.demo.enums.User;
import com.zebrunner.carina.demo.gui.components.common.NavBarMenuBase;
import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.zebrunner.carina.demo.enums.User.INVALID;
import static com.zebrunner.carina.demo.enums.Status.FAIL;
import static com.zebrunner.carina.demo.enums.Status.SUCCESS;
import static com.zebrunner.carina.demo.enums.User.PASSWORD;
import static com.zebrunner.carina.demo.enums.User.USER;

public class UserAccountTest extends AbstractTest {
    @DataProvider(name = "useTestDataSignIn")
    public Object[][] userSignInDataProvider() {
        return new Object[][]{
                {USER, PASSWORD, SUCCESS},
                {USER, INVALID, FAIL},
                {INVALID, PASSWORD, FAIL}
        };
    }

    @Test(dataProvider = "useTestDataSignIn", description = "JIRA#DEMO-B001")
    public void testUserLogIn(User user, User password, Status message){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Homepage is not opened");

        NavBarMenuBase navBarMenu = homePage.getHeader().clickNavBarMenu();
        LoginPageBase loginPage =  navBarMenu.clickLogInLink();

        loginPage.putUserDataToForm(String.valueOf(user), String.valueOf(password));

        if(message.equals(SUCCESS)){
            Assert.assertTrue(homePage.isPageOpened(), "Homepage doesn't show after successful login");
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed after failed login");
        }
    }

    @BeforeMethod
    public void setDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel_3a");
        desiredCapabilities.setCapability("appium:deviceType", "phone");
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");
        desiredCapabilities.setCapability("appium:app", "=C:/Users/anna0/Documents/demo-app/Android-MyDemoAppRN.1.3.0.build-244.apk"); //link to app: https://github.com/saucelabs/my-demo-app-rn
        desiredCapabilities.setCapability("appium:appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
    }
}
