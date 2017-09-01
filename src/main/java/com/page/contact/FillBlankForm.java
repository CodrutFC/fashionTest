package com.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageObject class for the Contact Form
 * Fills in the contact form with the required
 * information
 */

public class FillBlankForm extends PageObjectsVariable {
    private WebDriver driver;

    @FindBy(id = CONTACT_MENU_NAME)
    private WebElement contactMenuName;
    @FindBy(id = CONTACT_MENU_EMAIL)
    private WebElement contactMenuEmail;
    @FindBy(id = CONTACT_MENU_MESSAGE)
    private WebElement contactMenuMessage;
    @FindBy(id = CONTACT_MENU_SEND)
    private WebElement contactMenuSend;

    public FillBlankForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterContactMenuName(String name) {

        contactMenuName.sendKeys(name);
    }

    public void enterContactMenuEmail(String email) {

        contactMenuEmail.sendKeys(email);
    }

    public void contactMenuMessage(String message) {

        contactMenuMessage.sendKeys(message);
    }

    public void contactMenuSend() {

        contactMenuSend.click();
    }
}
