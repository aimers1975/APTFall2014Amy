import junit.framework.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class TestAdnansSite extends TestCase {

    public static String loginTempSite(String username, String password, WebDriver thisdriver, String elementToFind, Boolean byTagname) {
        thisdriver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement query = thisdriver.findElement(By.name("userId"));
        for(int i=0; i<15; i++) {
            query.sendKeys(Keys.BACK_SPACE);
        }
        query.sendKeys(username);
        WebElement query2 = thisdriver.findElement(By.name("userPassword"));
        for(int i=0; i<15; i++) {
            query2.sendKeys(Keys.BACK_SPACE);
        }
        query2.sendKeys(password);

        query2.sendKeys(Keys.TAB);
        query2.sendKeys(Keys.ENTER);

        // Sleep until the div we want is visible or 5 seconds is over
        Long end = System.currentTimeMillis() + 20000;
        String resultdisplayed = "";
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv;
                if (byTagname) {  
                    resultsDiv = thisdriver.findElement(By.tagName(elementToFind)); 
                } else { 
                    resultsDiv = thisdriver.findElement(By.name(elementToFind)); 
                }
                if (resultsDiv.isDisplayed()) {
                    resultdisplayed = resultsDiv.getText();
                    System.out.println("Result is: " + resultdisplayed);
                    break;
                }
            } catch (Exception e) {
            }
        }
        return resultdisplayed;

    }

    public static String enterTemp(String temp, WebDriver driver) {
        Long end = System.currentTimeMillis() + 20000;
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.name("farenheitTemperature"));
                if (resultsDiv.isDisplayed()) {
                    for(int i=0; i<4; i++) {
                        resultsDiv.sendKeys(Keys.BACK_SPACE);
                    }
                    resultsDiv.sendKeys(temp);
                    resultsDiv.sendKeys(Keys.TAB);
                    resultsDiv.sendKeys(Keys.ENTER);
                    break;
                }
            } catch (Exception e) {
            }
        }
        end = System.currentTimeMillis() + 20000;
        String resultdisplayed = "";
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.tagName("h2"));
                if (resultsDiv.isDisplayed()) {
                    resultdisplayed = resultsDiv.getText();
                    System.out.println("Result was displayed: " + resultdisplayed);
                    break;
                } else {
                    
                }
            } catch (Exception e) {
            }
        }
        return resultdisplayed;
    }

 

    public static void testLowerCaseLogins() throws Exception {
                // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();
        System.out.println("Starting test lower case login.");
        String resultdisplayed = loginTempSite("andy","apple",driver, "h3",true);
        driver.quit();
        assertEquals(resultdisplayed,"Convert from Farenheit to Celsius");

        driver = new FirefoxDriver();
        resultdisplayed = loginTempSite("charley","china",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed,"Convert from Farenheit to Celsius");
        System.out.println("Ending lowercase login test.");       
    }
    
    public static void testUpperCaseLogins() {
        System.out.println("starting test upper case login.");
        WebDriver driver = new FirefoxDriver();
        String resultdisplayed = loginTempSite("bob","bathtub",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed, "Convert from Farenheit to Celsius");
        System.out.println("Ending test upper case login.");     
    }
    
    public static void testWrongCasePassword() {
        System.out.println("Starting test wrong case password");
        WebDriver driver = new FirefoxDriver();
        String resultdisplayed = loginTempSite("bob","BATHTUB",driver,"h2",true);
        driver.quit();
        assertEquals(resultdisplayed, "Input combination of user id and password is incorrect.");
        System.out.println("Wrong case password test complete.");

    }
    
    public static void testWrongUserWhitespace() {
        WebDriver driver = new FirefoxDriver();
        String resultdisplayed = loginTempSite("    ANDY  ","apple",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed, "Convert from Farenheit to Celsius");   

        driver = new FirefoxDriver();
        resultdisplayed = loginTempSite("    charley   ","china",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed, "Convert from Farenheit to Celsius");  
    }

    public static void testWrongPasswordWhitespace() {
        WebDriver driver = new FirefoxDriver();
        String resultdisplayed = loginTempSite("bob","    bathtub   ",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed, "Convert from Farenheit to Celsius");
        System.out.println("Wrong whitespace password test complete");
    }

    public static void testLockout() {

        WebDriver driver = new FirefoxDriver();
        String resultdisplayed = loginTempSite("charley","fail",driver,"h2",true);
        assertEquals(resultdisplayed, "Input combination of user id and password is incorrect.");
        resultdisplayed = loginTempSite("charley","fail",driver,"h2",true);
        assertEquals(resultdisplayed, "Input combination of user id and password is incorrect.");
        resultdisplayed = loginTempSite("charley","fail",driver,"h2",true);
        assertEquals(resultdisplayed, "Wait for 1 minute before trying to login again");

        driver = new FirefoxDriver();
        resultdisplayed = loginTempSite("charley","bathtub",driver,"h3",true);
        driver.quit();
        assertFalse(resultdisplayed.equals("Convert from Farenheit to Celsius")); 
        driver = new FirefoxDriver(); 
        Long end = System.currentTimeMillis() + 65000;
        int i = 0;
        while (System.currentTimeMillis() < end) {
            i++;
        }
        resultdisplayed = loginTempSite("charley","china",driver,"h3",true);
        driver.quit();
        assertEquals(resultdisplayed, "Convert from Farenheit to Celsius");   
        System.out.println("lockout test complete");
    }

    public static void testTempResultPrecision() {
        //97 or -3.14, but not 9.73E2)
        WebDriver driver = new FirefoxDriver();
        loginTempSite("bob","bathtub",driver,"h3",true);
        String resultdisplayed = enterTemp("213",driver);      
        driver.quit();
        //assertEquals(resultdisplayed, "213 Farenheit = 100.6 Celsius");

        driver = new FirefoxDriver();
        loginTempSite("charley","china",driver,"h3",true);
        resultdisplayed = enterTemp("432",driver);      
        driver.quit();
        //assertEquals(resultdisplayed, "432 Farenheit = 222.2 Celsius");

        driver = new FirefoxDriver();
        loginTempSite("bob","bathtub",driver,"h3",true);
        resultdisplayed = enterTemp("212",driver);      
        driver.quit();
        assertEquals(resultdisplayed, "212 Farenheit = 100.00 Celsius");

        driver = new FirefoxDriver();
        loginTempSite("andy","apple",driver,"h3",true);
        resultdisplayed = enterTemp("0",driver);      
        driver.quit();
        assertEquals(resultdisplayed, "0 Farenheit = 32.00 Celsius");

        System.out.println("Ending temp precision test.");

    }

    public static void testWongFormatTemp() {
        //97 or -3.14, but not 9.73E2)
        WebDriver driver = new FirefoxDriver();
        loginTempSite("bob","bathtub",driver,"h3",true);
        String resultdisplayed = enterTemp("9.73E2",driver);      
        driver.quit();
        assertEquals(resultdisplayed, "Need to enter a valid temperature!Got a NumberFormatException on 9.73E2"); 

        System.out.println("Wrong temp format test complete.");   
    }

    public static void testCorrectFormatTemp() {
        //97 or -3.14, but not 9.73E2)
        WebDriver driver = new FirefoxDriver();
        loginTempSite("bob","bathtub",driver,"h3",true);
        String resultdisplayed = enterTemp("97",driver);      
        driver.quit();
        assertEquals(resultdisplayed, "97 Farenheit = 36.11 Celsius");

        driver = new FirefoxDriver();
        loginTempSite("bob","bathtub",driver,"h3",true);
        resultdisplayed = enterTemp("-3.14",driver);      
        driver.quit();
        assertEquals(resultdisplayed, "-3.14 Farenheit = -19.52 Celsius");

        System.out.println("Correct temp format test complete.");   
    }

    public static void main(String[] args) throws Exception {

        String[] testCaseName = 
            { TestAdnansSite.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}