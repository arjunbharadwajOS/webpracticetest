package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement searchTextField;

    @FindBy(how = How.ID, using = "nav-search-submit-button")
    private WebElement searchTextButton;

    public void clickSearchTextField() {
        searchTextField.click();
    }

    public void enterSearchTextField(String searchText) {
        searchTextField.sendKeys(searchText);
    }

    public void clickPerformSearch() {
        searchTextButton.click();
    }

}
