package pages;

import PageObjectModel.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZiraatPage extends AbstractClass {

    WebDriver driver;

    public ZiraatPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[@href='/tr/bireysel'])[2]")
    private WebElement bireyselButton;

    public void clickBireyselButton(){
        clickFunction(bireyselButton);
    }

    @FindBy(xpath = "(//a[@href='/tr/bireysel/krediler'])[4]")
    private WebElement kredilerButton;

    public void clickKredilerButton(){
        clickFunction(kredilerButton);
    }

    @FindBy(xpath = "//a[text()='Tüketici Kredisi']")
    private WebElement tuketiciKredisiButton;

    public void clickTuketiciKredisiButton(){
        clickFunction(tuketiciKredisiButton);
    }

    @FindBy(xpath = "(//a[@class='btn btn-gray'])[1]")
    private WebElement hesaplamaAraciButton;

    public void clickHesaplamaAraciButton(){
        clickFunction(hesaplamaAraciButton);
    }
}