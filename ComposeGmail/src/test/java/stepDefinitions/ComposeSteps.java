package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ComposeSteps {
	WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the user opens the Gmail login page")
    public void the_user_opens_the_Gmail_login_page() {
        driver.get("https://mail.google.com/");
    }

    @When("the user enters valid credentials and clicks login")
    public void the_user_enters_valid_credentials_and_clicks_login() throws InterruptedException {
        driver.findElement(By.id("identifierId")).sendKeys("your-email@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("your-password");
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(5000);
    }

    @Then("the user should see their Gmail inbox")
    public void the_user_should_see_their_Gmail_inbox() {
        Assert.assertTrue("Inbox is not visible.", driver.getTitle().contains("Inbox"));
    }

    @Given("the user is on the Gmail compose page")
    public void the_user_is_on_the_Gmail_compose_page() {
        driver.findElement(By.cssSelector(".T-I.T-I-KE.L3")).click();
    }

    @When("the user enters a valid recipient, subject, and body")
    public void the_user_enters_a_valid_recipient_subject_and_body() {
        driver.findElement(By.name("to")).sendKeys("recipient-email@gmail.com");
        driver.findElement(By.name("subjectbox")).sendKeys("Incubyte");
        driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("QA test for Incubyte");
    }

    @When("the user leaves the recipient field empty and enters the subject and body")
    public void the_user_leaves_the_recipient_field_empty() {
        driver.findElement(By.name("subjectbox")).sendKeys("Incubyte");
        driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("QA test for Incubyte");
    }

    @When("the user enters an invalid recipient email and enters the subject and body")
    public void the_user_enters_an_invalid_recipient_email() {
        driver.findElement(By.name("to")).sendKeys("invalid-email");
        driver.findElement(By.name("subjectbox")).sendKeys("Incubyte");
        driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("QA test for Incubyte");
    }

    @And("clicks the send button")
    public void clicks_the_send_button() {
        driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3")).click();
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        WebElement confirmation = driver.findElement(By.cssSelector(".bAq"));
        Assert.assertTrue("Email was not sent successfully.", confirmation.isDisplayed());
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        WebElement error = driver.findElement(By.cssSelector(".Kj-JD-Jl"));
        Assert.assertTrue("Error message was not displayed.", error.isDisplayed());
    }
}