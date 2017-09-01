package com.page.contact;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Test methods that call the PageObject methods
 * and contain the test assertions for the site menu
 */

public class testSIteMenus extends TestBase {

    Navigation nav = PageFactory.initElements(driver, Navigation.class);
    TestHelper testHelper = PageFactory.initElements(driver, TestHelper.class);

    @Then("^I should be able to navigate to the home menu$")
    public void i_should_be_able_to_navigate_to_the_home_menu() throws Throwable {

        List<String> labelList = new ArrayList();
        labelList.add("Contact");
        labelList.add("Careers");
        labelList.add("About");
        labelList.add("News");
        labelList.add("Prices");
        labelList.add("Technology");
        labelList.add("Works");
        labelList.add("Services");
        labelList.add("Home");

        Assert.assertEquals("The menus options are incorrect", labelList,
                nav.getListStringValuesForMenu());

        nav.clickHomeMenu();

    }

    // Left blank by default as it just loads on the Home Page - no action needed
    @Given("^I go to the QAWorks Home Page$")
    public void iGoToTheQAWorksHomePage() throws Throwable {
        nav.clickHomeMenu();

        Assert.assertEquals("The home menu button redirects to an incorrect url", testHelper.getHomePageUrlAttr(),
                testHelper.getHomePageUrl());
    }

    @Then("^I should be able to navigate to the services menu$")
    public void iShouldBeAbleToNavigateToTheServicesMenu() throws Throwable {
        nav.clickServicesMenu();

        Assert.assertEquals("The services menu button redirects to an incorrect url", testHelper.getServicePageUrlAttr(),
                testHelper.getServicePageUrl());
    }

    @Then("^I should be able to navigate to the works menu$")
    public void iShouldBeAbleToNavigateToTheWorksMenu() throws Throwable {
        nav.getWorksMenu();

        Assert.assertEquals("The works menu button redirects to an incorrect url", testHelper.getWorksPageUrlAttr(),
                testHelper.getWorksUrl());
    }

    @Then("^I should be able to navigate to the technology menu$")
    public void iShouldBeAbleToNavigateToTheTechnologyMenu() throws Throwable {
        nav.getTechnologyMenu();

        Assert.assertEquals("The technology menu button redirects to an incorrect url", testHelper.getTechnologyPageUrlAttr(),
                testHelper.getTechnologyUrl());
    }

    @Then("^I should be able to navigate to the news menu$")
    public void iShouldBeAbleToNavigateToTheNewsMenu() throws Throwable {
        nav.getNewsMenu();

        Assert.assertEquals("The news menu button redirects to an incorrect url", testHelper.getNewsPageUrlAttr(),
                testHelper.getNewsUrl());
    }

    @Then("^I should be able to navigate to the about menu$")
    public void iShouldBeAbleToNavigateToTheAboutMenu() throws Throwable {
        nav.getAboutMenu();

        Assert.assertEquals("The about menu button redirects to an incorrect url", testHelper.getAboutPageUrlAttr(),
                testHelper.getAboutUrl());
    }

    @Then("^I should be able to navigate to the careers menu$")
    public void iShouldBeAbleToNavigateToTheCareersMenu() throws Throwable {
        nav.getCareersMenu();

        Assert.assertEquals("The careers menu button redirects to an incorrect url", testHelper.getCareerPageUrlAttr(),
                testHelper.getCareersUrl());

        String currentHandle = nav.switchToWindowByTitle(driver, "Job Opportunities");
        driver.close(); // Close WINDOW_TITLE page or do other things
        driver.switchTo().window(currentHandle); // Return to current page


    }

    @Then("^I should be able to navigate to the contact us menu$")
    public void iShouldBeAbleToNavigateToTheContactUsMenu() throws Throwable {
        nav.getContactUsMenu();
        Assert.assertEquals("The prices menu button redirects to an incorrect url", testHelper.getContactUsAttrUrl(),
                testHelper.getContactUsUrl());
    }

    @Then("^I should be able to navigate to the prices menu$")
    public void iShouldBeAbleToNavigateToThePricesMenu() throws Throwable {
        nav.getPricesMenu();

        // Assertion fails due to page re-directing to Contact Us incorrectly
        Assert.assertEquals("The prices menu button redirects to an incorrect url", testHelper.getPricesPageUrlAttr(),
                testHelper.getPricesUrl());
    }


}

