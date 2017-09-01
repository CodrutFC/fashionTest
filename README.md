# pageContact
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
- The custom implementation of PageObjects ( to have multiple reusable items )
- Custom methods that loop through elements rather than having to go through one after another
- Custom TestHelper class the encapsulates all methods which return a value to be asserted on ( for ease of debugging when needed )

Improvements
- Must find a proper formatting for the code
- Perform more checks with assertions

Bugs encountered can be seen in the comments ( Assertions failing due to bugs have been moved towards the end of the tests so that when tested the majority of tests pass )
- Incorrect url redirect from Prices menu item
- Validation message is not refreshing as exepected when other information is entered for messaege/name
- Possible security issue caused by Stack Trace

* For more information check the comments left in the code
