package com.practicetest;

import com.Pages.FiltersPage;
import com.Pages.HomePage;
import com.Pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.libraries.TestDriver;

public class StepDefinitions {

    @Given("^User is on AmazonAU page \"([^\"]*)\"$" )
    public void IBackgroundLaunchBrowser(String url) throws Throwable {
        TestDriver.getDriver().get(url);
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void i_search_for_text(String searchText) {

        HomePage home = new HomePage(TestDriver.getDriver());

        home.clickSearchTextField();
        home.enterSearchTextField(searchText);
        home.clickPerformSearch();

    }

    @When("^I select filters on the lefthand panel \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_select_filters_on_the_lefthand_panel(String brand, String screensize, String resolution1, String resolution2) {
        FiltersPage filterPage = new FiltersPage(TestDriver.getDriver());

        filterPage.applyBrandFilters(brand);
        filterPage.applyAdditionalFilters(screensize, resolution1, resolution2);
    }

    @Then("^I verify the search results are displayed and sorted by price$" )
    public void IVerifySearchResults() throws Throwable {
        SearchResultsPage searchResultsPage = new SearchResultsPage(TestDriver.getDriver());

        searchResultsPage.verifyProductTitles();
        searchResultsPage.verifyProductPrice();

    }

}
