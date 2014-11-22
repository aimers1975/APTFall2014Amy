import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class AdnansSite {

    public static void testLowerCaseLogins() {

    }

    public static void testUpperCaseLogins() {

    }

    public static void testWrongCasePassword() {

    }

    public static void testWrongUserWhitespace() {

    }
    public static void testWrongPasswordWhitespace() {

    }

    public static void testLockout() {

    }

    public static void testTempResultPrecision() {

    }

    public static void testWongFormatTemp() {

    }

    public static void testTemperatureInputCase() {
        
    }

    public static void main(String[] args) throws Exception {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();
        
        // Go to the Google Suggest home page
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
        // Enter the query string "Cheese"

        WebElement query = driver.findElement(By.name("userId"));
        for(int i=0; i<15; i++) {
            query.sendKeys(Keys.BACK_SPACE);
        }
        query.sendKeys("andy");
        WebElement query2 = driver.findElement(By.name("userPassword"));
        for(int i=0; i<15; i++) {
            query2.sendKeys(Keys.BACK_SPACE);
        }
        query2.sendKeys("apple");

        query2.sendKeys(Keys.TAB);
        query2.sendKeys(Keys.ENTER);

        // Sleep until the div we want is visible or 5 seconds is over
        Long end = System.currentTimeMillis() + 10000;
        //driver.implicitly_wait(0);
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.name("farenheitTemperature"));
                if (resultsDiv.isDisplayed()) {
                    System.out.println("Login login andy Successful.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("No such element exception 1");
            }
            // If results have been returned, the results are displayed in a drop down.

        }

/*
        // And now list the suggestions
        try {
            List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
            System.out.println("The suggestions are: " + Integer.toString(allSuggestions.size()));
                    //driver.implicitly_wait(10);
            for (WebElement suggestion : allSuggestions) {
                System.out.println(suggestion.getText());
            }
        } catch (Exception e) {
            System.out.println("Caught no such element exception");
        }*/
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        query = driver.findElement(By.name("userId"));
        for(int i=0; i<15; i++) {
            query.sendKeys(Keys.BACK_SPACE);
        }
        query.sendKeys("bob");
        query2 = driver.findElement(By.name("userPassword"));
        for(int i=0; i<15; i++) {
            query2.sendKeys(Keys.BACK_SPACE);
        }
        query2.sendKeys("bathtub");

        query2.sendKeys(Keys.TAB);
        query2.sendKeys(Keys.ENTER);
                
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.name("farenheitTemperature"));
                if (resultsDiv.isDisplayed()) {
                    System.out.println("Login bob Successful.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("No such element exception 1");
            }
            // If results have been returned, the results are displayed in a drop down.

        }

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        query = driver.findElement(By.name("userId"));
        for(int i=0; i<15; i++) {
            query.sendKeys(Keys.BACK_SPACE);
        }
        query.sendKeys("charley");
        query2 = driver.findElement(By.name("userPassword"));
        for(int i=0; i<15; i++) {
            query2.sendKeys(Keys.BACK_SPACE);
        }
        query2.sendKeys("china");

        query2.sendKeys(Keys.TAB);
        query2.sendKeys(Keys.ENTER);
            
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.name("farenheitTemperature"));
                if (resultsDiv.isDisplayed()) {
                    System.out.println("Login charley Successful.");
                    break;
                } else {
                    System.out.println("Result was not displayed fast enough.");
                }
            } catch (Exception e) {
                System.out.println("No such element exception 1");
            }
            // If results have been returned, the results are displayed in a drop down.

        }
        System.out.println("Ending test.");

        driver.quit();
    }
}