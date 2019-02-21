package com.varnit.inscale.tests;

import com.varnit.inscale.Controller.GoogleSearch;
import com.varnit.inscale.base.Base;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends Base {
    GoogleSearch googleSearch;

    @BeforeClass
    public void setup() {
        googleSearch = new GoogleSearch(driver);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("googleUrl"));
    }

    @Parameters("keyword")
    @Test
    public void validateFirstRecordInGoogleSearch(String search) {
        boolean flag = googleSearch.validateSearch(search);
        Assert.assertTrue(flag);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
