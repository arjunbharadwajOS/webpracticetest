package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

    public void applyAdditionalFilters(String screensize, String resolution1, String resolution2) throws InterruptedException {
        int filtersCount = filterList.size();
        int applyFilters = 0;

        for (int jCount = 0; jCount < filtersCount; jCount++)
        {
            if(filterList.get(jCount).getText().equalsIgnoreCase(screensize) && applyFilters == 0){
                filterList.get(jCount).click();
                applyFilters++;
            }else if(filterList.get(jCount).getText().equalsIgnoreCase(resolution1) && applyFilters < 2){
                filterList.get(jCount).click();
                Thread.sleep(5000);
                applyFilters++;
            }else if(filterList.get(jCount).getText().equalsIgnoreCase(resolution2) && applyFilters == 2 ){
                filterList.get(jCount).click();
                break;
            }
        }

    }




}
