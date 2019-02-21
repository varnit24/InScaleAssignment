package com.varnit.inscale.Controller;

import com.varnit.inscale.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleSearch extends Base {


    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method would enter the search keyword and then validate if the first record that is
     * displayed is not other than the entered keyword
     *
     * @param
     * @return
     */
    public boolean validateSearch(String keywordSearch) {
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi' and @title='Search' and @role='combobox']")).sendKeys(keywordSearch);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='erkvQe']//li[1]")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='erkvQe' or @role='listbox']//li[0]/child::div[@role='option']/div/span")));
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe' or @role='listbox']//li/child::div[@role='option']/div/span"));

        boolean flag = false;

        if (list.size() < 1) {
            return flag;
        }
        if (list.get(0).getText().equals(keywordSearch)) {
            flag = true;
        }
        return flag;
    }
}


