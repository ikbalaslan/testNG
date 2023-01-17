package techproed.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Day16_SoftAssert {
    @Test
    public void softAssertTest(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Line 11 Code");
        softAssert.assertEquals(3,5);
        System.out.println("Line 13 Code");
        softAssert.assertAll();
    }
}
/*
What is the difference between assertion and verification ?
 -Assertion means hard assertion. Verification means soft assertion . Verification is similar to  if else statement
  - If hard assertion fails, rest of the test case stops.
Whatis the difference between soft assert and hard assert ?
  - Hard assertion stops execution, after assertion failure. Soft assert continues to execute even after failure
  - We need to create a soft assert object to do soft assertion
  - assertAll() need to be used in soft assert to make the actual result
Which assertion do you prefer ? Why ?
  - I used both. Both assertion are useful. But I used hard assertion the most, because I need to fix the issue the moment it shows up.
    it usually doesn't make sense to wait for other tests if there is a failure
  - If there are lots of test cases , I prefer to use hard assert to find the wrond test case quickly to fix it.
  - If I use soft assertion, It will run all the tests every time even there are wrong cases in them. I usually use soft assertion
    when I write new test cases to see if all good or some fails.

 */