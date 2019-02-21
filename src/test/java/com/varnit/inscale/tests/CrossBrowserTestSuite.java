package com.varnit.inscale.tests;
/*
@author:Varnit
 */

import com.varnit.inscale.Controller.TopDanmarkHomePage;
import com.varnit.inscale.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserTestSuite extends Base {
    TopDanmarkHomePage topDanmarkHomePage;
    private WebDriver driver = null;

    @Parameters("browser")
    @BeforeTest()
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
            this.driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");

            this.driver = new FirefoxDriver();
        }
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        topDanmarkHomePage = new TopDanmarkHomePage(this.driver);

    }

    @Test(alwaysRun = true)
    public void validateCrossBrowser() {
        this.driver.get(prop.getProperty("crossBrowserUrl"));
        topDanmarkHomePage.waitForLogo();
        System.out.println("Title: " + topDanmarkHomePage.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("Topdanmark Forsikring og Pension"));
        Assert.assertEquals(topDanmarkHomePage.getTitle(), "Topdanmark Forsikring og Pension");
    }

    @AfterTest()
    public void tearDown() {
        this.driver.quit();
    }
}
