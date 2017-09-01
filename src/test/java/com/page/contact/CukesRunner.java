package com.page.contact;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * TestRunner - runs the tests and has set the
 * before and after methods ( setup and teardown )
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"}
)
public class CukesRunner extends TestBase {

    @BeforeClass
    public static void launchSetup() {
        TestBase.setup();
    }

    @AfterClass
    public static void launchTearDown() {
        TestBase.tearDownTest();
    }
}
