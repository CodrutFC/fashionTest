package com.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PageObject class for the Objects returned for testing
 * As opposed to other PageObjects its methods return
 * values to be used in assertions
 */

public class TestHelper extends PageObjectsVariable {

    private WebDriver driver;
    @FindBy(id = CONTACT_PAGE_HEAD)
    private WebElement contactPageHead;
    @FindBy(xpath = CONTACT_EMAIL_LINK)
    private WebElement contactEmailLink;
    @FindBy(xpath = VACANCIES_LINK)
    private WebElement vacanciesLink;
    @FindBy(xpath = FORM_TITLE)
    private WebElement formTitle;
    @FindBy(id = CONTACT_NAME_BOX)
    private WebElement contactNameBox;
    @FindBy(id = CONTACT_EMAIL_BOX)
    private WebElement contactEmailBox;
    @FindBy(id = CONTACT_MESSAGE_BOX)
    private WebElement contactMessageBox;
    @FindBy(id = CONTACT_MENU_SEND)
    private WebElement contactMenuButton;
    @FindBy(id = VALIDATION_HIDDEN_NAME)
    private WebElement validationHiddenName;
    @FindBy(id = VALIDATION_HIDDEN_EMAIL)
    private WebElement validationHiddenEmail;
    @FindBy(id = VALIDATION_HIDDEN_MESSAGE)
    private WebElement validationHiddenMessage;
    @FindBy(id = VALIDATE_ENTERED_EMAIL)
    private WebElement validateEnteredEmail;
    @FindBy(xpath = PAGE_MENU)
    private List<WebElement> pageMenu;


    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    Navigation nav = PageFactory.initElements(driver, Navigation.class);

    public ArrayList<String> getContactPageHeader() {
        String content = contactPageHead.getText();

        String s[] = content.split("\\r?\\n");
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(s));

        return arrList;
    }


    public String getEmailLink() {
        return contactEmailLink.getAttribute("href");
    }

    public String getVacanciesLink() {
        return vacanciesLink.getAttribute("href");
    }

    public String getFormTitle() {
        return formTitle.getText();
    }

    public String getContactNameBox() {
        return contactNameBox.getText();
    }

    public String getContactEmailBox() {
        return contactEmailBox.getText();
    }

    public String getContactMessageBox() {
        return contactMessageBox.getText();
    }

    public String getContactMenuLabel() {
        return contactMenuButton.getAttribute("value");
    }

    public String getValidationHiddenName() {
        return validationHiddenName.getText();
    }

    public String getValidationHiddenEmail() {
        return validationHiddenEmail.getText();
    }

    public String getValidationHiddenMessage() {
        return validationHiddenMessage.getText();
    }

    public String getValidateEnteredEmailMessage() {
        return validateEnteredEmail.getText();
    }

    public String getNameValidationAttribute() {
        return validationHiddenName.getAttribute("style");
    }

    public String getEmailValidationAttribute() {
        return validationHiddenEmail.getAttribute("style");
    }

    public String getMessagelValidationAttribute() {
        return validationHiddenMessage.getAttribute("style");
    }

    public String getValidateEnteredEmailAddressAtr() {
        return validateEnteredEmail.getAttribute("style");
    }

    public String getWebPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getMenusAsWebelement() {

        List<WebElement> elementList = new ArrayList<>();

        //iterate through all the webElements
        for (WebElement webElement : pageMenu) {
            //add each webElements label to the labelsList
            elementList.add(webElement);
        }
        //return all the label texts t
        return elementList;

    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

    public String getHomePageUrlAttr() {
        return getMenusAsWebelement().get(8).getAttribute("href");
    }

    public String getServicePageUrl() {
        return driver.getCurrentUrl();
    }

    public String getServicePageUrlAttr() {
        return getMenusAsWebelement().get(7).getAttribute("href");
    }

    public String getWorksUrl() {
        return driver.getCurrentUrl();
    }

    public String getWorksPageUrlAttr() {
        return getMenusAsWebelement().get(6).getAttribute("href");
    }

    public String getNewsUrl() {
        return driver.getCurrentUrl();
    }

    public String getNewsPageUrlAttr() {
        return getMenusAsWebelement().get(3).getAttribute("href");
    }

    public String getTechnologyUrl() {
        return driver.getCurrentUrl();
    }

    public String getTechnologyPageUrlAttr() {
        return getMenusAsWebelement().get(5).getAttribute("href");
    }

    public String getAboutUrl() {
        return driver.getCurrentUrl();
    }

    public String getAboutPageUrlAttr() {
        return getMenusAsWebelement().get(2).getAttribute("href");
    }

    public String getCareersUrl() {
        return driver.getCurrentUrl();
    }

    public String getCareerPageUrlAttr() {
        return getMenusAsWebelement().get(1).getAttribute("href");
    }

    public String getPricesUrl() {
        return driver.getCurrentUrl();
    }

    public String getPricesPageUrlAttr() {
        return getMenusAsWebelement().get(4).getAttribute("href");
    }

    public String getContactUsUrl() {
        return driver.getCurrentUrl();
    }

    public String getContactUsAttrUrl() {
        return getMenusAsWebelement().get(0).getAttribute("href");
    }

}
