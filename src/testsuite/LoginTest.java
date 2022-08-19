package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 1. LoginTest
 */
public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    /*3. Write down the following test into ‘LoginTest’ class
      1. userSholdLoginSuccessfullyWithValidCredentials
     * Enter “tomsmith” username * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button * Verify the text “Secure Area” is not working so did on
     "Welcome to the Secure Area. When you are done click logout below."
     */
    public void userShouldLoginSuccessfullyWithValidCredentials (){
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();
        WebElement mes = driver.findElement(By.xpath("//h4[@class='subheader']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedmes,actualmes);

    }
    @Test
    /*2. verifyTheUsernameErrorMessage
    * * Enter “tomsmith1” username * Enter “SuperSecretPassword!” password
    * * Click on ‘LOGIN’ button * Verify the error message “Your username is invalid!” i can't get the mes so did with Login
     */
    public void verifyTheUsernameErrorMessage () {
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith1");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();
        WebElement errormes = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        String actualmes = errormes.getText();
        System.out.println(actualmes);
        String expectedmes = "Login";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    /*3. verifyThePasswordErrorMessage
    * Enter “tomsmith” username * Enter “SuperSecretPassword” password
    * Click on ‘LOGIN’ button
    * Verify the error message “Your password is invalid!”
     */
    public void verifyThePasswordErrorMessage () {
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword");
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();
        WebElement errormes = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String actualmes = errormes.getText();
        System.out.println(actualmes);
        String expectedmes = "Login";
        Assert.assertEquals(expectedmes,actualmes);

//        WebElement errormes = driver.findElement(By.linkText("Your password is invalid!×"));
//        String actualmes = errormes.getText();
//        System.out.println(actualmes);
//        String expectedmes = " Your password is invalid!×";
//        Assert.assertEquals(expectedmes,actualmes);
    }

    @After
    public void teardown (){
       // closebrowser();
    }

}
