package com.Pages;

import com.libraries.TestDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FiltersPage {

    public FiltersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindAll(@FindBy(how = How.XPATH, using = "//*[@id='brandsRefinements']//span[@class='a-list-item']"))
    private  List<WebElement> brandItems;
    @FindAll(@FindBy(how = How.XPATH, using = "//*[@id='filters']//span[@class='a-list-item']"))
    private List<WebElement> filterList;

    public void applyBrandFilters(String brand){
        int brandItemsCount  = brandItems.size();

        for (int iCount = 0; iCount < brandItemsCount; iCount++)
        {
            if(brandItems.get(iCount).getText().equalsIgnoreCase(brand)){
                brandItems.get(iCount).click();
                break;
            }
        }
    }

    public void applyAdditionalFilters(String screensize, String resolution1, String resolution2) {
        int filtersCount = filterList.size();
        int applyFilters = 0;
        WebDriverWait wait = new WebDriverWait(TestDriver.getDriver(), Duration.ofSeconds(10));
        WebElement filterElement = null;

        for (int jCount = 0; jCount < filtersCount; jCount++)
        {
            if(filterList.get(jCount).getText().equalsIgnoreCase(screensize) && applyFilters == 0){
                filterElement = wait.until(ExpectedConditions.elementToBeClickable(filterList.get(jCount)));
                filterElement.click();
                applyFilters++;
            }else if(filterList.get(jCount).getText().equalsIgnoreCase(resolution1) && applyFilters < 2){
                filterElement = wait.until(ExpectedConditions.elementToBeClickable(filterList.get(jCount)));
                filterElement.click();
                applyFilters++;
            }else if(filterList.get(jCount).getText().equalsIgnoreCase(resolution2) && applyFilters == 2 ){
                filterElement = wait.until(ExpectedConditions.elementToBeClickable(filterList.get(jCount)));
                filterElement.click();
                break;
            }
        }

    }




}
