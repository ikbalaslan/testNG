package techproed.tests.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;


public class ListenersTest4 {
@Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1(){
    Driver.getDriver().get("https://www.techproeducation.com");
    Assert.assertTrue(false);

}
}
//JUnit: A testing framework. Has less annotation compare to TestNG
//TestNG : An advanced testing framework. Advanced version of JUnit framework.
//Page Object Model: Popular Framework Design pattern. We use page object model for creating reusable page objects and methods.
//Maven : Project build tool. With maven, we can easily add other dependencies(junit,testng,selenium) to our projects
//Instead of importing the jar files, we just add the dependency in the pom.xml file. Then maven automatically jar pies for us.
//Developers may also use maven for their project built.
//Selenium:Selenium is a tool. Selenium is used to test web based application. We can also do mobile testing with 3rd party tool such as appium:
