package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 5.Write down the following test into ‘SaleTest’ class
 * ->Click on ‘Sale’ Menu tab
 * ->Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
 * ->Verify the text ‘Jackets’ is displayed
 * ->Count the Total Item Displayed on Page
 * and print the name of all items into console.
 * ->Verify total 12 Items displayed on page.
 */
public class SaleTest extends BaseTest {

    @Test
    public void verifyTheTotalItemsDisplayOnTheWomensJacketsPage() throws InterruptedException {

        driver.findElement(By.xpath("//span[.='Sale']")).click();       // Click on Sale Menu tab
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[.='Jackets'])[3]")).click();       // click on jackets link
        Thread.sleep(2000);

        // verify the text 'Jackets' is displayed
        String expectedText = "Jackets";
        WebElement actualText = driver.findElement(By.xpath("(//span[.='Jackets'])[3]"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText, actualTest);
        Thread.sleep(2000);

        // Count the total item Displayed on page and print the name of all items into console.
//        List<WebElement> items = driver.findElements(By.id("toolbar-amount"));
//        int totalItems = items.size();
//        System.out.println("Total Item Displayed " + totalItems);
//        Thread.sleep(5000);
//
//        for (WebElement item : items) {
//            String itemName = item.getText();
//            System.out.println(" Item Name : " + itemName);
//        }

        /**
         * List<WebElement> linksElement = driver.findElements(By.tagName("strong"));
         *         System.out.println("Total links are : " + linksElement.size());
         *
         *         for(WebElement link : linksElement){
         *             System.out.println(link.getText());
         *             System.out.println(link.getAttribute("class"));
         */

        String actual = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        List<WebElement> itemsName = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        System.out.println("Total Items : " + items.size());

        for (WebElement list : itemsName) {
            System.out.println(list.getText());
        }

        int count = 12;
        int actualCount = items.size();
        Assert.assertEquals(count, actualCount);
    }
}
