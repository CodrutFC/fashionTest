package com.page.contact;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Test methods that call the PageObject methods
 * and contain the test assertions
 */

public class testContactPage extends TestBase {

    Navigation nav = PageFactory.initElements(driver, Navigation.class);
    FillBlankForm newForm = PageFactory.initElements(driver, FillBlankForm.class);
    TestHelper testHelper = PageFactory.initElements(driver, TestHelper.class);


    @Given("^I am on the QAWorks Site$")
    public void i_am_on_the_QAWorks_Site() throws Throwable {

        nav.goToContactMenu();
        List<String> labelList = new ArrayList();
        labelList.add("Contact");
        labelList.add("Want to know more about us?");
        labelList.add("Give us a call, send us a message or drop us an email");
        labelList.add("Looking for a career in Testing? Check out our current vacancies");

        Assert.assertEquals("The page header title is incorrect", labelList.get(0),
                testHelper.getContactPageHeader().get(0));
        Assert.assertEquals("The user question is incorrect for contact", labelList.get(1),
                testHelper.getContactPageHeader().get(1));
        Assert.assertEquals("The user contact instruction text is incorrect", labelList.get(2),
                testHelper.getContactPageHeader().get(2));
        Assert.assertEquals("The user career message is incorrect", labelList.get(3),
                testHelper.getContactPageHeader().get(3));

        Assert.assertTrue("The email link is incorrect",
                testHelper.getEmailLink().contains("mailto:enquiry@qaworks.com"));
        Assert.assertTrue("The vacancies link is incorrect",
                testHelper.getVacanciesLink().contains("http://careers.qaworks.com"));


    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void i_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable userInformation) throws Throwable {

        List<List<String>> information = userInformation.raw();
        newForm.enterContactMenuName(information.get(0).get(1));
        newForm.enterContactMenuEmail(information.get(1).get(1));
        newForm.contactMenuMessage(information.get(2).get(1));
        newForm.contactMenuSend();

        Assert.assertEquals("The form title is incorrect", "Send us a message",
                testHelper.getFormTitle().trim());
        Assert.assertEquals("The contact message box title is incorrect", "Message",
                testHelper.getContactMessageBox().trim());
        Assert.assertEquals("The submit button label is incorrect", "Send",
                testHelper.getContactMenuLabel().trim());
        Assert.assertEquals("The contact email box title is incorrect", "Email",
                testHelper.getContactEmailBox().trim());

        // Expecting for this assertion to fail due to an existing bug in the code ( div id id="ContactNameBox" is a parent
        // of div id ContactEmailBox - they should be siblings under the same div
        Assert.assertEquals("The contact name box title is incorrect", "Name",
                testHelper.getContactNameBox().trim());
    }

    @Then("^I should receive warning message when trying to send a blank form$")
    public void iShouldReceiveWarningMessageWhenTryingToSendABlankForm() throws Throwable {

        Assert.assertTrue("The value for the visibility attribute should be hidden for the name",
                testHelper.getNameValidationAttribute().contains("visibility: hidden"));
        Assert.assertTrue("The value for the visibility attribute should be hidden for the email",
                testHelper.getEmailValidationAttribute().contains("visibility: hidden"));
        Assert.assertTrue("The value for the visibility attribute should be hidden for the message",
                testHelper.getMessagelValidationAttribute().contains("visibility: hidden"));

        newForm.contactMenuSend();


        Assert.assertEquals("The email validation text is incorrect", "An Email address is required",
                testHelper.getValidationHiddenEmail());
        Assert.assertEquals("The name validation text is incorrect", "Your name is required",
                testHelper.getValidationHiddenName());
        Assert.assertEquals("The message validation text is incorrect", "Please type your message",
                testHelper.getValidationHiddenMessage());

        Assert.assertTrue("The value for the visibility attribute should be visible for the name",
                testHelper.getNameValidationAttribute().contains("visibility: visible"));
        Assert.assertTrue("The value for the visibility attribute should be visible for the email",
                testHelper.getEmailValidationAttribute().contains("visibility: visible"));
        Assert.assertTrue("The value for the visibility attribute should be visible for the message",
                testHelper.getMessagelValidationAttribute().contains("visibility: visible"));

    }

    @Then("^I should receive warning message when entering an invalid e-mail$")
    public void iShouldReceiveWarningMessageWhenEnteringAnInvalidEMail() throws Throwable {

        Assert.assertTrue("The validation message visibility attribute value should be hidden",
                testHelper.getValidateEnteredEmailAddressAtr().contains("visibility: hidden"));
        newForm.enterContactMenuEmail(RandomStringUtils.randomAlphabetic(100));

        newForm.contactMenuMessage(RandomStringUtils.randomAlphanumeric(100));
        newForm.contactMenuSend();

        // Assertions will fail due to an existing bug in the code - the validation message for the e-mail address
        // becomes hidden even if its incorrect when the send button is pressed
        Assert.assertTrue("The validation message visibility attribute value should be visible",
                testHelper.getValidateEnteredEmailAddressAtr().contains("visibility: visible"));
        Assert.assertEquals("The validate entered email address message is incorrect", "Invalid Email Address",
                testHelper.getValidateEnteredEmailMessage());


    }

    // New test created specifically to highlight a security bug
    // When the e-mail address is not valid, but all the other fields are filled
    // and the sent option is used
    @Then("^I should not be able to submit with an invalid e-mail address$")
    public void iShouldNotBeAbleToSubmitWithAnInvalidEMailAddress() throws Throwable {

        newForm.enterContactMenuEmail(RandomStringUtils.randomAlphabetic(100));
        newForm.contactMenuMessage(RandomStringUtils.randomAlphanumeric(100));
        newForm.enterContactMenuName(RandomStringUtils.randomAlphabetic(100));

        newForm.contactMenuSend();

        // Assertion fails due to the above bug - stack traces should not be visible and would be
        // best to hide due to leaking of information of the software design ( potential security flaw )
        Assert.assertEquals("The browser tab title is incorrect", "QAWorks",
                testHelper.getWebPageTitle());

    }

    // Introduced a short Thread.sleep as the website needs to be idle for 1 second for the
    // stack trace to bec
    @Then("^I wait for (\\d+) miliseconds$")
    public void iWaitForMiliseconds(int arg0) throws Throwable {

        Thread.sleep(arg0);
    }
}
