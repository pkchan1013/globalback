package com.hk.cityu.globalback.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.function.Consumer;

public class SeleniumLib {
    private final ChromeOptions co = new ChromeOptions().addArguments("--headless");

    public void getLambdaList(String url, String xpath, Consumer<? super WebElement> action){
        WebDriver driver = new ChromeDriver(co);
        driver.get(url);
        //It will have List<WebElement>, and then this can be forEach-ed
        driver.findElements(By.xpath(xpath)).forEach(action);
        driver.close();
    }
}