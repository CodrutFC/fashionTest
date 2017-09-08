package com.page.contact;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class testIPhoneOnlineData extends TestBase {
    Navigation nav = PageFactory.initElements(driver, Navigation.class);

    @Given("^I go to the Google web page$")
    public void i_go_to_the_Google_web_page() {

        Assert.assertTrue("The url is incorrect", nav.getPageUrl(driver).contains("www.google.co.uk"));
    }

    @Then("^I should be able to search for Iphone$")
    public void i_should_be_able_to_search_for_Iphone() {


        nav.searchBar("iPhone uk");
        nav.searchButtonClick();
    }

    @Then("^I should be able to go to the Amazon url$")
    public void i_should_be_able_to_locate_the_Amazon_UK_url() {

        nav.getAmazonSearchResult();
    }

    @When("^I should be able to get the iPhone with the most space$")
    public void i_locate_the_Amazon_UK_url_I_should_be_able_to_click_it() {


        nav.getAmazonProduct();

        Assert.assertTrue("The product price is bigger than 800 gbp",
                Double.parseDouble(nav.getProdPrice().replace("£", "")) <= 800);
    }

    @Then("^I should be able to have all the information logged$")
    public void iShouldBeAbleToHaveAllTheInformationLogged() {

        System.out.println("The product title is" + " " + nav.getProdTitle());
        System.out.println("The product price is " + " " + nav.getProdPrice());
        System.out.println("The product url is" + " " + driver.getCurrentUrl());
    }
}
