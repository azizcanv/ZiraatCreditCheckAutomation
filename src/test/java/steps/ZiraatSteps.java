package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.CreditCalculatePage;
import pages.ZiraatPage;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class ZiraatSteps {

    ZiraatPage ZiraatPage = new ZiraatPage();
    CreditCalculatePage CreditCalculatePage = new CreditCalculatePage();

    private WebDriver driver;

    @Given("Ziraat anasayfası açılır")
    public void ziraatAnasayfasiAcilir() {
        driver = Driver.getDriver();
        driver.get("https://www.ziraatbank.com.tr/tr");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @When("Bireysel -> Krediler tıklanır")
    public void bireyselKredilerTiklanir() {
        ZiraatPage.clickBireyselButton();
        ZiraatPage.clickKredilerButton();
        ZiraatPage.clickTuketiciKredisiButton();
    }
    @Then("Hesaplama aracı tıklanır")
    public void hesaplamaAraciTiklanir() {
        ZiraatPage.clickHesaplamaAraciButton();
    }
    @Given("^(.*) (.*) (.*) seçilir$")
    public void krediBilgileriSecilir(String kredituru, String tutar, String vade) {
        CreditCalculatePage.clickChoicesButton(kredituru);
        CreditCalculatePage.typePrice(tutar);
        CreditCalculatePage.typeExpiry(vade);
    }
    @When("Hesapla tıklanır")
    public void hesaplaTiklanir() throws InterruptedException {
        CreditCalculatePage.clickHesaplaButton();
        Thread.sleep(3000);
    }
    @Then("Hesap kontrol edilir")
    public void hesapKontrolEdilir() {
        CreditCalculatePage.hesaplaControl();
    }

    @AfterTest
    public void killDriver() {
        driver.close();
    }
}