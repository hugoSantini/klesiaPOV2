import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class US1_CAS1{

    ChromeOptions driver;

    @Given("Mon navigateur et ouvert sans cookies")
    public void mon_navigateur_et_ouvert_sans_cookies() {
        System.out.println("Etape - Mon navigateur est ouvert");
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("Je suis sur la page de connexion du formulaire d'imposition")
    public void je_suis_sur_la_page_de_connexion_du_formulaire_d_imposition() {
        System.out.println("Etape - Je suis sur la page de connexion");
        driver.navigate().to("https://re7-contact.klesia.fr/form");
    }

    @When("Je rentre mon identifiant : {string}")
    public void je_rentre_mon_identifiant(String ID) {
        System.out.println("Etape - Rentrer l'ID");
        System.out.println("Mon identifiant est : " + ID);
        driver.findElement(By.id("username")).sendKeys(ID);


    }
    @When("Je rentre mon mdp : {string}")
    public void je_rentre_mon_mdp(String MDP) {
        System.out.println("Etape - Rentrer le MDP");
        System.out.println("Mon Mot de Passe est : " + MDP);
        driver.findElement(By.id("password")).sendKeys(MDP);

    }

    @When("J'appuye sur 'Se connecter'")
    public void j_appuye_sur_se_connecter() {
        System.out.println("Etape - Cliquer sur \"Se connecter\"");
        driver.findElement(By.name("login")).click();
    }

    @Then("J'arrive sur la page première page du formulaire")
    public void j_arrive_sur_la_page_première_page_du_formulaire() {
        System.out.println("J'arrive sur la premier page du formulaire");
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertEquals("https://re7-contact.klesia.fr/form", currentURL);
    }
}
