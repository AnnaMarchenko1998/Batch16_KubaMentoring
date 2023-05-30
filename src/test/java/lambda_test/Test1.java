package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement inputForm = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        inputForm.click();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Anna");
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("a@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("1234");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("Grandtex");
        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("grandtex.com");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']")); //option[.='Ukraine']
        country.sendKeys("Ukraine");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Schaumburg");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("92 Aster dr");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("apt.2123");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("IL");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("60126");
        WebElement submitBttn = driver.findElement(By.xpath("//button[.='Submit']"));
        submitBttn.click();
        WebElement text = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
        String expectedText = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertEquals(text.getText().trim(),expectedText);
        driver.quit();

    }
}
