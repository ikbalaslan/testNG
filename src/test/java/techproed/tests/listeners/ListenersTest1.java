package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import java.util.NoSuchElementException;
//USE @LISTENER ANNOTATION to CONNECT TEST CLASS TO THE LISTENERS
@Listeners(techproed.utilities.Listeners.class) //-> PATH OF LISTENERS UTILITY
public class ListenersTest1 {
    @Test
    public void test1(){
        System.out.println("Test case 1 PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("Test case 2 FAIL");
    Assert.assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("Test case 3 SKIPPED");
        throw new SkipException("SKIP THIS TEST CASE");
    }
    @Test
    public void test4(){
        System.out.println("Test case 4 No SUCH ELEMENT EXCEPTION");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.xpath("assadsf"));//NO SUCH ELEMENT EXCEPTION
    }


}
