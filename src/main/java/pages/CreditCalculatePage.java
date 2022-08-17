package pages;

import PageObjectModel.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreditCalculatePage extends AbstractClass{

    WebDriver driver;

    public CreditCalculatePage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void clickChoicesButton(String kredituru){

        driver.findElement(By.xpath("//a[@class='selected']")).click();
        driver.findElement(By.linkText(kredituru)).click();
    }

    //@FindBy(id = "calc-tutar")
    //private WebElement price;

    public void typePrice(String tutar){
        WebElement price = driver.findElement(By.id("calc-tutar"));
        price.clear();
        sendKeysFunction(price,tutar);
    }

    //@FindBy(id = "calc-vade")
    //private WebElement expiry;

    public void typeExpiry(String vade){
        WebElement expiry = driver.findElement(By.id("calc-vade"));
        expiry.clear();
        sendKeysFunction(expiry,vade);
    }

    @FindBy(xpath = "//a[@class='btn btn-red calculation-btn']")
    private WebElement hesaplaButton;

    public void clickHesaplaButton(){
        clickFunction(hesaplaButton);
    }

    public void hesaplaControl(){
        boolean Display = driver.findElement(By.xpath("//div[@class='icon-ok icon']")).isDisplayed();
        System.out.println("Başarılı bir şekilde hesaplandı "+Display);
        WebElement hesap = driver.findElement(By.xpath("//div[@class='result-right']"));
        String s = hesap.getText();
        System.out.println("Hesap Sonucu:\n" + s);
    }

}
