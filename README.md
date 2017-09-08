# Selenium Test
Test - Cucumber and Selenium with Java

All dependencies can be found in the pom.xml file :
- org.seleniumhq.selenium
- io.github.bonigarcia
- org.seleniumhq.selenium
- junit
- info.cukes ( cucumber-junit )
- info.cukes ( cucumber-java )

IDE use IntelliJ with Selenium Plugin and Cucumber Plugin.
Type of project Maven Project.

To build simply import the project and use the pom.xml to import the dependencies.

Highlights 
- The value "iPhone UK" is searched as string due to the google search for "iPhone" not showing any Amazon.co.uk results ( may be caused by my current location )
- Check for the page to load based on the results found
- Clicked on the first Amazon result ( used the Amazon page options to locate the product with the most gb )
- Performed tests based on the device located on the previous step
