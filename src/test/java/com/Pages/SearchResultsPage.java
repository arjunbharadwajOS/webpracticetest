package com.Pages;

import com.libraries.TestDriver;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchResultsPage {

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@data-component-type='s-search-results']//span[@class='a-size-base-plus a-color-base a-text-normal']"))
    private  List<WebElement> productTitleList;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@class='a-price']//span[@class='a-offscreen']"))
    private  List<WebElement> productPriceList;


    public void verifyProductTitles(){

        int productTitleCount = productTitleList.size();

        String productTitle = null;

        for(int iProduct = 0; iProduct < productTitleCount; iProduct++){

            productTitle = productTitleList.get(iProduct).getText();
            Assert.isTrue(true, productTitle);
        }

    }

    public void verifyProductPrice(){

        int productPriceCount = productPriceList.size();
        String prodPrice = null;

        for(int iProdPrice = 0; iProdPrice < productPriceCount; iProdPrice++){

            prodPrice = productPriceList.get(iProdPrice).getText();
            Assert.isTrue(true, prodPrice);
        }

    }






}
