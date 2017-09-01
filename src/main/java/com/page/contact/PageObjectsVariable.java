package com.page.contact;

/**
 * Class used to encapsulate web elements
 * Set as global vars to be re-used and edited
 * when needed
 */

public class PageObjectsVariable {

    // PageObject vars FindBy Xpath
    public static final String CONTACT_US_MENU = "//*[@id='menu']/li/a[@href = '/contact.aspx']";
    public static final String CONTACT_EMAIL_LINK = "//*[@id='ContactHead']/a[@title = 'Email us!']";
    public static final String VACANCIES_LINK = "//*[@id='ContactHead']/a[contains(text(),'Check out our current vacancies')]";
    public static final String FORM_TITLE = "//*[@id='ContactMessageUs']/h2";
    public static final String PAGE_MENU = "//*[@id='menu']/li/a";

    // PageObject vars FindBy Id
    public static final String CONTACT_MENU_NAME = "ctl00_MainContent_NameBox";
    public static final String CONTACT_MENU_EMAIL = "ctl00_MainContent_EmailBox";
    public static final String CONTACT_MENU_MESSAGE = "ctl00_MainContent_MessageBox";
    public static final String CONTACT_MENU_SEND = "ctl00_MainContent_SendButton";
    public static final String CONTACT_PAGE_HEAD = "ContactHead";
    public static final String CONTACT_NAME_BOX = "ContactNameBox";
    public static final String CONTACT_EMAIL_BOX = "ContactEmailBox";
    public static final String CONTACT_MESSAGE_BOX = "ContactMessageBox";
    public static final String VALIDATION_HIDDEN_NAME = "ctl00_MainContent_rfvName";
    public static final String VALIDATION_HIDDEN_EMAIL = "ctl00_MainContent_rfvEmailAddress";
    public static final String VALIDATION_HIDDEN_MESSAGE = "ctl00_MainContent_rfvMessage";
    public static final String VALIDATE_ENTERED_EMAIL = "ctl00_MainContent_revEmailAddress";


}
