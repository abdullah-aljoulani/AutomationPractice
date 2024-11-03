import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();

	String website = "https://codenboxautomationlab.com/practice/";

	Random rand = new Random();

	@BeforeTest
	public void setUp() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		driver.get(website);

	}

	@Test(priority = 1, enabled = false)
	public void RadioButton() {

		WebElement radioDev = driver.findElement(By.id("radio-btn-example"));

		radioDev.findElements(By.tagName("input"));

		int randomRadio = rand.nextInt(radioDev.findElements(By.tagName("input")).size());

		WebElement radioButton = radioDev.findElements(By.tagName("input")).get(randomRadio);

		radioButton.click();

		boolean Acutal = radioButton.isSelected();
		boolean Expected = true;

		Assert.assertEquals(Acutal, Expected);

	}

	@Test(priority = 2, enabled = false)
	public void DynamicDropdown() throws InterruptedException {

		String[] twoChar = { "az", "fa", "ua", "ma" };

		int randomChar = rand.nextInt(twoChar.length);

		String randInputData = twoChar[randomChar];

		WebElement textFeild = driver.findElement(By.id("autocomplete"));

		textFeild.sendKeys(randInputData);

		Thread.sleep(1000);

		textFeild.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String DataInsideMyInput = (String) js.executeScript("return arguments[0].value", textFeild);

		boolean Acuail = DataInsideMyInput.contains(randInputData.toLowerCase());

		Assert.assertEquals(Acuail, true);

	}
	
	@Test (priority = 3)
	public void StaticDropdown () {
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select selector = new Select(dropdown);
		
		int randomNumber = rand.nextInt(1,4);
		
		selector.selectByIndex(randomNumber);
		
		
	}
	
	
	
	
	
	

}
