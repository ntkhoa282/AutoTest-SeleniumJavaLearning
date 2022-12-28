package TestNGFramework_test;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class chap3_example extends BaseTest {
    @Test
    public void dropDownMenuCase() {
        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//a[normalize-space()='Dropdown menu']")).click();

        WebElement dropdownTitle = driver.findElement(By.xpath("//h1[normalize-space()='Dropdown menu']"));

        Assert.assertEquals(dropdownTitle.getText(), "Dropdown menu");

        WebElement leftClick = driver.findElement(By.id("my-dropdown-1"));

        actions.click(leftClick).build().perform();

        WebElement rightClick = driver.findElement(By.id("my-dropdown-2"));

        actions.contextClick(rightClick).build().perform();

        WebElement doubleClick = driver.findElement(By.id("my-dropdown-3"));

        actions.doubleClick(doubleClick).build().perform();
    }

    @Test
    public void dragAndDropCase() {
        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//a[normalize-space()='Drag and drop']")).click();

        WebElement dragTitle = driver.findElement(By.xpath("//h1[normalize-space()='Drag and drop']"));

        Assert.assertEquals(dragTitle.getText(), "Drag and drop");

        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("target"));

        actions.dragAndDrop(draggable, target).build().perform();

    }

    @Test
    public void testWebForm() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Web form']")).click();
        //get title
        WebElement titleWF = driver.findElement(By.xpath("//h1[normalize-space()='Web form']"));
        //Check title
        Assert.assertEquals(titleWF.getText(), "Web form");

        driver.findElement(By.xpath("//input[@id='my-text-id']")).sendKeys("hello Khoa");

        driver.findElement(By.xpath("//input[@name='my-password']")).sendKeys("123456");

        driver.findElement(By.xpath("//textarea[@name='my-textarea']")).sendKeys("hello world");

        boolean checked = driver.findElement(By.id("my-radio-2")).isSelected();

        if (!checked) {
            driver.findElement(By.id("my-radio-2")).click();
        }

        Select dropDownSelect = new Select(driver.findElement(By.xpath("//select[@name='my-select']")));

        Assert.assertFalse(dropDownSelect.isMultiple());

        dropDownSelect.selectByVisibleText("Two");
        //Dropdown datalist
        WebElement inputDataList = driver.findElement(By.xpath("//input[@placeholder='Type to search...']"));

        String dataListValue = driver.findElement(By.xpath("//option[@value='Los Angeles']")).getAttribute("value");

        inputDataList.sendKeys(dataListValue);
        //Color picker
        WebElement colorPicker = driver.findElement(By.xpath("//input[@name='my-colors']"));

        colorPicker.sendKeys("#ffffff");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).submit();

        WebElement submittedTitle = driver.findElement(By.xpath("//h1[normalize-space()='Form submitted']"));

        Assert.assertEquals(submittedTitle.getText(), "Form submitted");
    }
}
