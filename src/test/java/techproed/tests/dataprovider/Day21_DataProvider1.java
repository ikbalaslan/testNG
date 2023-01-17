package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Day21_DataProvider1 {
    /*
    What is data provider ?
    ****Data provider is used to get list of data
    ****We can get data from external files , such as excel or json files.
    ****DataProvider is an annotation of testNG
    ****I use Data Provider to get data such as credentials from excel sheet
    -----------------------------------------------------------
    How to you get data in your testNG framework ?
    ****In DataProvider method, I use @DataProvider annotations , in Test method I give the name in the parameter
    -----------------------------------------------------------
    Data Provider has 2 parameters :
    ****1.Name : Used to give custom name for DataProvider   @DataProvider(name = "my_smoke_data")
    ****2. parallel keyword : Used to parallel testing. Default is parallel=false. We can make parallel = true

    Data Provider loops without needing loops . Just like a lambda.
     */
//DATA PROVIDER METHOD
   @DataProvider(name = "my_smoke_data",parallel = true)
    public Object[][] customerData(){
       //Test DATA
        Object [][] customerCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerCredentials;
    }

    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest1(String username , String password){
        System.out.println("USERNAME : " + username + " | PASSWORD : " + password );
    }

    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest2(String username , String password){
        System.out.println(username+ " | "+password);
    }
}
