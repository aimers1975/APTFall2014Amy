import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSuggest {
    public static void main(String[] args) throws Exception {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();
        
        // Go to the Google Suggest home page
        driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese\n");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 1000000;
        //driver.implicitly_wait(0);
        while (System.currentTimeMillis() < end) {
            try {
                WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
                if (resultsDiv.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("No such element exception 1");
            }
            // If results have been returned, the results are displayed in a drop down.

        }

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
        }


        driver.quit();
    }
}