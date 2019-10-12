package Action_Item;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Action_Item_InClass {

    //Declare driver variable

    WebDriver driver = null;

    @BeforeSuite
    public void openBrowser () throws IOException {
        driver = Reusable_Library.navigate(driver, "https://www.yahoo.com/");

    }//end of @BeforeSuite

    @Test
    public void FullTest(){
        //Assert that we are on the correct page by checking the title =Yahoo
        Assert.assertEquals(driver.getTitle(), "Yahoo");

        //3. Display the count of options on the left side panel
        try {
            Thread.sleep(3000);

            List<WebElement> tabsCount = (List<WebElement>) driver.findElements(By.xpath("//*[contains(@class,'Mstart(21px)')]"));
            System.out.println ("tab count is " + tabsCount.size());

        }catch(Exception e){
            System.out.println("Unable to count tabs because " + e);

        }


        //4. Enter 'Nutrition' on the search bar on top
         Reusable_Library.userInput(driver, "//*[@name='p']", "Nutrition","Search Bar");

        //5. Click on the 'Search' Button

        Reusable_Library.click(driver, "//*[@id='uh-search-button']", "clickButton");










    }// end of test













}//end of action item
