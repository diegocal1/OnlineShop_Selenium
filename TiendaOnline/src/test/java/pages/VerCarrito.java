package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

public class VerCarrito{

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
	public void VerItem () throws InterruptedException {

    //Ver articulo		
    WebElement item1 = driver.findElement(By.xpath("//img[@alt='Hummingbird printed t-shirt']"));
    item1.click();
    //Agregar al carrito
    WebElement addtoCart = driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button"));
    addtoCart.click();
    //Ir al pago
    
    //Configuro la espera explicita
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
    
    WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));
    checkoutBtn.click();
    //Pago
    WebElement checkoutBtnFinal = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")));
    checkoutBtnFinal.click();
    //
    WebElement genderRadioBtn = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input"));
    genderRadioBtn.click();
   
    WebElement firstNameInput = driver.findElement(By.name("firstname"));
    firstNameInput.sendKeys(faker.name().firstName());
    
    WebElement lastnameInput = driver.findElement(By.name("lastname"));
    lastnameInput.sendKeys(faker.name().lastName());
    
    WebElement emailInput = driver.findElement(By.name("email"));
    emailInput.sendKeys(faker.internet().emailAddress());
    
    
    WebElement offerCheckbox = driver.findElement(By.name("optin"));
    offerCheckbox.click();
    
    WebElement newsCheckbox = driver.findElement(By.name("newsletter"));
    newsCheckbox.click();
    
    WebElement privacyCheckbox = driver.findElement(By.name("psgdpr"));
    privacyCheckbox.click();
    
    WebElement continueBtn = driver.findElement(By.cssSelector("#customer-form > footer > button"));
    continueBtn.click();
   
    
    WebElement adressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address1")));
    adressInput.sendKeys("Jackson Wy");
    
    
    WebElement cityInput = driver.findElement(By.name("city"));
    cityInput.sendKeys("Jackson");
    
    //lista desplegable con value
	WebElement state = driver.findElement(By.name("id_state"));
	Select stateListaDesplegable = new Select(state);
	stateListaDesplegable.selectByValue("47");
	
	 WebElement postalCodeInput = driver.findElement(By.name("postcode"));
	 postalCodeInput.sendKeys("84043");
	 
	WebElement countryInput = driver.findElement(By.name("id_country"));
	Select countryListaDesplegable= new Select(countryInput);
	countryListaDesplegable.selectByVisibleText("United States");
	
	WebElement phoneInput = driver.findElement(By.name("phone"));
	phoneInput.sendKeys("2432343232");
	
	/*WebElement invoiceInput = driver.findElement(By.id("use_same_address"));
	invoiceInput.click();*/
	
	WebElement continueCheckoutBtn = driver.findElement(By.name("confirm-addresses"));
	continueCheckoutBtn.click();
	

	WebElement continueChekoutBtn = driver.findElement(By.name("confirmDeliveryOption"));
	continueChekoutBtn.click();
	
	WebElement paymentOption = driver.findElement(By.id("payment-option-1"));
	paymentOption.click();
	
	WebElement termsRadio = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
	termsRadio.click();
	
	WebElement placeOrderBtn = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
	placeOrderBtn.click();
	
	
	}
    

  
	@AfterTest
	public void cerrarPagina() {

		driver.quit();	}
	
	@AfterSuite
	void finSuite() {
		System.out.println("Fin suite de pruebas");
	}
}//fin class

