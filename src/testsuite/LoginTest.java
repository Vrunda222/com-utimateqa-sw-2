package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        //Verify the text ‘Welcome Back!’
        Assert.assertEquals("Not redirected to login page", "Welcome Back!", driver.findElement(By.xpath("//h2[@class='page__heading']")).getText());
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("vrunda@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Verify the error message ‘Invalid email or password.’
        Assert.assertEquals("Not redirected to login page","Invalid email or password.", driver.findElement(By.className("form-error__list-item")).getText());
    }


    @After
    public void tearDown(){
        //closeBrowser();
    }
}
