package TestNGFramework_test;

import BaseTest.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Chap4Example extends BaseTest {

    @Test
    public void dialogBoxesCase() throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.click(driver.findElement(By.xpath("//a[normalize-space()='Dialog boxes']"))).build().perform();

        WebElement dialogTitle = driver.findElement(By.xpath("//h1[normalize-space()='Dialog boxes']"));

        Assert.assertEquals(dialogTitle.getText(), "Dialog boxes");

        //Launch alert
        actions.click(driver.findElement(By.xpath("//button[@id='my-alert']"))).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Launch confirm
        actions.click(driver.findElement(By.xpath("//button[@id='my-confirm']"))).build().perform();
        alert = driver.switchTo().alert();
        alert.dismiss();

        //Launch prompt
        actions.click(driver.findElement(By.xpath("//button[@id='my-prompt']"))).build().perform();
        alert = driver.switchTo().alert();
        alert.sendKeys("Nguyen Thien Khoa");
        alert.accept();

        //Launch modal
        actions.click(driver.findElement(By.xpath("//button[@id='my-modal']"))).build().perform();
        WebElement modalContent = driver.findElement(By.xpath("//div[@class='modal-content']"));
        Thread.sleep(500);
        WebElement modalTitle = modalContent.findElement(By.xpath("//h5[@id='exampleModalLabel']"));
        Assert.assertEquals(modalTitle.getText(), "Modal title");
        WebElement saveBtn = modalContent.findElement(By.xpath("//button[contains(text(),'Save')]"));
        actions.click(saveBtn).build().perform();
    }

    @Test
    public void iframeCase() {
        Actions actions = new Actions(driver);

        actions.click(driver.findElement(By.xpath("//a[normalize-space()='IFrames']"))).build().perform();

        WebElement iframeTitle = driver.findElement(By.xpath("//h1[normalize-space()='IFrame']"));

        Assert.assertEquals(iframeTitle.getText(), "IFrame");

        driver.switchTo().frame("my-iframe");

        WebElement contentIframe = driver.findElement(By.xpath("//p[contains(text(),'dolor sit amet consectetur adipiscing elit habitan')]"));

        Assert.assertEquals(contentIframe.getText(), "Lorem ipsum dolor sit amet consectetur adipiscing elit habitant metus, tincidunt maecenas posuere sollicitudin augue duis bibendum mauris eu, et dignissim magna ad nascetur suspendisse quis nunc. Fames est ligula molestie aliquam pretium bibendum nullam, sociosqu maecenas mus etiam consequat ornare leo, sem mattis varius luctus litora senectus. Parturient quis tristique erat natoque tortor nascetur, primis augue vivamus habitasse senectus porta leo, aenean potenti ante a nam.");
    }

    @Test
    public void cookiesCase() {
        Actions actions = new Actions(driver);

        actions.click(driver.findElement(By.xpath("//a[normalize-space()='Cookies']"))).build().perform();

        WebElement cookiesTitle = driver.findElement(By.xpath("//h1[normalize-space()='Cookies']"));

        Assert.assertEquals(cookiesTitle.getText(), "Cookies");

        String newName = "Nguyen Thien Khoa";
        String newDate = "28/02/2000";
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("name", newName));
        driver.manage().addCookie(new Cookie("date", newDate));
        
        actions.click(driver.findElement(By.xpath("//button[@id='refresh-cookies']"))).build().perform();
    }
}
