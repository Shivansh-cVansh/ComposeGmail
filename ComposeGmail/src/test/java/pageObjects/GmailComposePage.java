package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailComposePage {
    WebDriver driver;

    
    public GmailComposePage() {
        System.setProperty("webdriver.chrome.driver", "C:/Workspace2/ComposeGmail/Drivers");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    
    public GmailComposePage(WebDriver driver) {
        this.driver = driver;
    }

    
    By composeButton = By.xpath("//div[text()='Compose']");
    By recipientField = By.name("to");
    By subjectField = By.name("subjectbox");
    By bodyField = By.xpath("//div[@aria-label='Message Body']");
    By sendButton = By.xpath("//div[text()='Send']");

  
    public void clickComposeButton() {
        driver.findElement(composeButton).click();
    }

    public void enterRecipient(String recipient) {
        driver.findElement(recipientField).sendKeys(recipient);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
    }

    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }

   
    public WebDriver getDriver() {
        return driver;
    }

    
    public void navigateToGmail() {
        driver.get("https://mail.google.com/");
    }

    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
