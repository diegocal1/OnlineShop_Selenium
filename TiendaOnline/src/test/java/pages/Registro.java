package pages;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

public class Registro {

static WebDriver driver; 

Faker faker; 



@BeforeSuite
public void SetUp() {
	faker = new Faker();
	driver= new ChromeDriver();
	System.out.println("Inicio suite de pruebas");
}
	public String Url = "http://www.testingyes.com/onlineshop/";
	
	@BeforeTest
	public void SetBaseUrl() {
	driver.get(Url);
	}
	
    @BeforeClass
	public void maximizarVentana() {
		driver.manage().window().maximize();
		System.out.println("BEFORE CLASS");
	}
	
	@Test
	public void RegistroUsuario() throws InterruptedException {

    WebElement signBtn = driver.findElement(By.id("_desktop_user_info"));
    signBtn.click();
    
    WebElement newAcount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
    newAcount.click();
    
    WebElement genderBtn = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input"));
    genderBtn.click();
    
    WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[2]/div[1]/input"));
    nameInput.sendKeys(faker.name().fullName());
   
    WebElement lastNameInput = driver.findElement(By.name("lastname"));
    lastNameInput.sendKeys(faker.name().lastName());
    
    WebElement emailInput = driver.findElement(By.name("email"));
    emailInput.sendKeys(faker.internet().emailAddress());
    
    WebElement paswInput = driver.findElement(By.name("password"));
    paswInput .sendKeys(faker.internet().password());
    
    WebElement birthdayInput = driver.findElement(By.name("birthday"));
    birthdayInput .sendKeys("05/31/1990");
    
    WebElement offerCheckbox = driver.findElement(By.name("optin"));
    offerCheckbox.click();
    
    WebElement newsLetterCheckbox = driver.findElement(By.name("newsletter"));
    newsLetterCheckbox.click();
    
    WebElement privacyChekbox= driver.findElement(By.name("psgdpr"));
    privacyChekbox.click();
    
    WebElement saveBtn= driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
    saveBtn.click();
  

	Thread.sleep(5000);

}
	@AfterTest
	public void cerrarPagina() {

		driver.close();

	}
	
	@AfterSuite
	void finSuite() {
		System.out.println("Fin suite de pruebas");
	}
}//fin class
