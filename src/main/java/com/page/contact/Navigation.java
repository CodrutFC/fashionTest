package com.page.contact;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * PageObject class for the site Navigation
 * Used to load the website and navigate through
 * the web pages
 */


public class Navigation extends PageObjectsVariable {

    private WebDriver driver;

    @FindBy(id = GOOGLE_SEARCH)
    private WebElement search;
    @FindBy(name = SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(className = SEARCH_RESULTS)
    private WebElement searchResults;
    @FindBy(xpath = AMAZON_PRODUCTS_XPATH)
    private List<WebElement> amazonProd;
    @FindBy(id = IPHONE_PRODUCT_SIZE)
    private List<WebElement> iPhoneSize;
    @FindBy(id = PROD_TITLE)
    private WebElement prodTitle;
    @FindBy(id = PROD_PRICE)
    private WebElement prodPrice;


    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void searchBar(String searchItem) {
        search.sendKeys(searchItem);
    }

    public void searchButtonClick() {
        searchButton.click();

    }

    // Returns the search result Amazon web page and clicks on it
    public void getAmazonSearchResult() {
        List<WebElement> linkElements = new ArrayList<WebElement>();
        ListIterator<WebElement> itr = null;
        WebElement toClick = null;

        int pageNumber = 1;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean flag = false;
        while (!flag) {
            linkElements = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By
                            .xpath(SEARCH_RESULT_XPATH)));
            itr = linkElements.listIterator(); // re-initializing iterator
            while (itr.hasNext()) {
                toClick = itr.next();
                if (toClick.getAttribute("href").contains("amazon.co.uk")) {
                    toClick.sendKeys(Keys.RETURN);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                driver.findElement(By.xpath(NEXT_BUTTON_XPATH))
                        .click();
                pageNumber++;
                linkElements.clear(); // clean list
            }
        }
    }

    // Gets the Amazon product with the highest number of Gb storage
    // based on the logic that the last element of the list will be the
    // one with the highest number of gb
    public void getAmazonProduct() {

        List<WebElement> labelsList = new ArrayList<WebElement>();

        for (WebElement webElement : amazonProd) {
            //add each webElements label to the labelsList
            labelsList.add(webElement);
        }

        WebElement element = labelsList.get(amazonProd.size() - 1);

        // Stopping refresh of page on load as it is taking too long to load
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }


    public String getProdTitle() {

        return prodTitle.getText();
    }

    public String getProdPrice() {
        return prodPrice.getText();
    }
}
