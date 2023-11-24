package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1. userShouldLoginSuccessfullyWithValidCredentials()
 *  -> Click on -Sign In- link
 *  -> Enter valid Email
 *  -> Enter valid Password
 *  -> Click on -Sign In- button
 *  -> Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 *  -> Click on -Sign In- link
 *  -> Enter valid Email
 *  -> Enter valid Password
 *  -> Click on -Sign In- button
 *  -> Verify the error message
 *      ‘The account sign-in was incorrect or your account is disabled temporarily.
 *          Please wait and try again later.’
 * 3. userShouldLogOutSuccessfully
 *  -> Click on ‘Sign In’ link
 *  -> Enter valid Email
 *  -> Enter valid Password
 *  -> Click on ‘Sign In’ button
 *  -> Verify the ‘Welcome’ text is display
 *  -> Click on down arrow near Welcome
 *  -> Click on Sign Out link
 *  -> Verify the text ‘You are signed out’
 */

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginSuccessfullyWithValid() throws InterruptedException {

        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();       // click on 'Sign In' link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("anb@gmail.com");  // enter valid email
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Anb123anb");  // enter valid password
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();       // Click on 'Sign in' button
        Thread.sleep(2000);

        // verify the 'Welcome' Text is displayed
        String expectedText = "Welcome, anb bna!";
        WebElement actualText = driver.findElement(By.xpath("(//span[text()='Welcome, anb bna!'])[1]"));
        String actualTest = actualText.getText();
        Assert.assertEquals("Welcome",expectedText,actualTest);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException {

        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();       // click on 'Sign In' link
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("anb@gmail.com");  // enter valid email
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Anb123an");  // enter valid password
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();       // Click on 'Sign in' button
        Thread.sleep(2000);

        // verify the text - The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualText = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);
       // Assert.assertEquals("Thank you for registering with Main Website Store.'","'Thank you for registering with Main Website Store.", "Thank you for registering with Main Website Store.");

    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();       // click on 'Sign In' link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anb@gmail.com");  // enter valid email
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Anb123anb");  // enter valid password
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Sign In'])[1]")).click();       // Click on 'Sign in' button
        Thread.sleep(2000);

        // verify the 'Welcome' Text is displayed
        String expectedText = "Welcome, anb bna!";
        WebElement actualText = driver.findElement(By.xpath("(//span[text()='Welcome, anb bna!'])[1]"));
        String actualTest = actualText.getText();
        Assert.assertEquals("Welcome",expectedText,actualTest);

        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();       //  Click on down arrow near welcome
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[contains(text(),'Sign Out')])[1]")).click();       // Click on Sign Out Link
        Thread.sleep(2000);

        // verify the text - 'You are signed out'
        String expectedText2 = "You are signed out";
        WebElement actualText2 = driver.findElement(By.xpath("//span[.='You are signed out']"));
        String actualTest2 = actualText2.getText();
        Assert.assertEquals(expectedText2,actualTest2);
        Thread.sleep(2000);
    }

}
