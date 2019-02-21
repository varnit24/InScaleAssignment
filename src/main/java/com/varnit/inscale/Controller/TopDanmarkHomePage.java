package com.varnit.inscale.Controller;
/**
 * @author:Varnit
 */

import com.varnit.inscale.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopDanmarkHomePage extends Base {

    private WebDriver driver = null;

    public TopDanmarkHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForLogo() {
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='navbar-brand__logo']")));
    }

    public String getTitle() {
        return this.driver.getTitle();
    }
}
