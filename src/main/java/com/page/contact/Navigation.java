package com.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * PageObject class for the site Navigation
 * Used to load the website and navigate through
 * the menus
 */

public class Navigation extends PageObjectsVariable {

    private WebDriver driver;
    @FindBy(xpath = CONTACT_US_MENU)
    private WebElement contactUsMenu;
    @FindBy(xpath = PAGE_MENU)
    private List<WebElement> pageMenu;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public static String switchToWindowByTitle(WebDriver driver, String windowTitle) {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (windowTitle.equalsIgnoreCase(driver.getTitle())) {
                break;
            }
        }

        return currentHandle;
    }

    public void goToContactMenu() { contactUsMenu.click(); }

    public List<String> getListStringValuesForMenu() {

        List<String> labelsList = new ArrayList<String>();

        //iterate through all the webElements
        for (WebElement webElement : pageMenu) {
            //add each webElements label to the labelsList
            labelsList.add(webElement.getText());
        }
        //return all the label texts t
        return labelsList;

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

    public void clickHomeMenu() {
        getMenusAsWebelement().get(8).click();
    }

    public void clickServicesMenu() {
        getMenusAsWebelement().get(7).click();
    }

    public void getWorksMenu() {
        getMenusAsWebelement().get(6).click();
    }

    public void getTechnologyMenu() {
        getMenusAsWebelement().get(5).click();
    }

    public void getNewsMenu() {
        getMenusAsWebelement().get(3).click();
    }

    public void getAboutMenu() {
        getMenusAsWebelement().get(2).click();
    }

    public void getCareersMenu() {
        getMenusAsWebelement().get(1).click();
    }

    public void getPricesMenu() {
        getMenusAsWebelement().get(4).click();
    }

    public void getContactUsMenu() { getMenusAsWebelement().get(0).click(); }


}
