package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Write down the following test into RegisterTest class
 * 1. verifyThatSignInPageDisplay
 * -> Click on the 'Create an Account' link
 * -> Verify the Text 'Create New Customer Account'
 * 2. userShouldRegisterAccountSuccessfully
 * -> Click on the 'Create an Account' link
 * -> Enter First Name
 * -> Enter Last name
 * -> Click on checkbox sign Up for newsletter
 * -> Enter Email
 * -> Enter Password
 * -> Enter Confirm Password
 * -> Click on Create an Account button
 * -> verify the text 'Thank you for registering with Main Website store.'
 * -> Click on down arrow near Welcome
 * -> Click on Sign Out Link
 * -> Verify the text 'You are signed out'
 */
public class RegisterTest extends BaseTest {

    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException {

        driver.findElement(By.xpath("(//a[.='Create an Account'])[1]")).click();
        Thread.sleep(2000);
        String expectedText = "Create New Customer Account";
        WebElement actualText = driver.findElement(By.xpath("//span[text()='Create New Customer Account']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);
        Thread.sleep(2000);
        System.out.println("verifyThatSignInPageDisplay Method ran successfully");

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("(//a[.='Create an Account'])[1]")).click();                   // Click on Create an Account
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Prime");  // Enter First name
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Testing");  // Enter Last name
        Thread.sleep(2000);
        //driver.findElement(By.xpath("")).click();                   // Click on the checkbox sign for newsletter
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("PrimeTestl@gmail.com");                // Enter Email
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234Prime");                // Enter Password
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("1234Prime");                // Enter Confirm Password

        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();                   // Click on create an account button

        // Verify the text - 'Thank you for registering with Main Website Store.'
        String expectedText = "Thank you for registering with Main Website Store.";
        WebElement actualText = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);
        Thread.sleep(2000);

        //Assert.assertEquals("Dhara","nimesh");

        driver.findElement(By.xpath("(//button[@tabindex='-1' ])[1]")).click();           // click on down arrow near Welcome

        driver.findElement(By.xpath("( //li[@class='authorization-link'])[1]")).click();           // Click on sign out link

        // Verify the text 'You are signed out.'
        String expectedText2 = "You are signed out";
        WebElement actualText2 = driver.findElement(By.xpath("//span[text()='You are signed out']"));
        String actualtest2 = actualText2.getText();
        Assert.assertEquals(expectedText2,actualtest2);


    }
}
