package Automation_Amity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amity {

	@Test
	public void TestCase_1_SearchUserWithPartialTextMatch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		1. Navigate
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		2. Type the following credentials:
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

//		3. Click Login button
		WebElement login_button = driver.findElement(By.className("oxd-button"));
		login_button.click();

//		4. Click on PIM from side menu bar
		WebElement PIM = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		PIM.click();
//		Thread.sleep(500);

//		5. Type "ch" in the Employee Name text input field
		WebElement Employee_Name = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		Employee_Name.sendKeys("ch");
		Thread.sleep(5000);

//		Expected Results:
//		Verify user can see a list of predicted users that has "ch" in their names
//		(ignore case/not case sensitive)
		List<WebElement> employeeList = driver.findElements(By.cssSelector(".oxd-autocomplete-dropdown"));
		System.out.println("Length = " + employeeList.size());
		Assert.assertTrue(employeeList.size() == 1);

//		Another way for verifying
//		List<WebElement> employeeList = driver.findElements(By.cssSelector(".oxd-autocomplete-dropdown"));
//	    System.out.println("Length = " + employeeList.size());
//	    Assert.assertTrue(employeeList.size() == 1);

//		6. Click on green Search button
		WebElement Search_Button = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
		Search_Button.click();
		Thread.sleep(3000);

//		Expected Results:
		boolean areFirstThreeEmployeesDisplayed = false;
		WebElement employeeListFirstName1 = driver.findElement(By.xpath("//div[contains(text(),'Charlie')]"));
		Thread.sleep(500);
		WebElement employeeListlastName1 = driver.findElement(By.xpath("//div[contains(text(),'Carter')]"));
		Thread.sleep(500);
		WebElement employeeListFirstName2 = driver.findElement(By.xpath("//div[contains(text(),'Chenzira')]"));
		Thread.sleep(500);
		WebElement employeeListlastName2 = driver.findElement(By.xpath("//div[contains(text(),'Chuki')]"));
		Thread.sleep(500);
		WebElement employeeListFirstName3 = driver.findElement(By.xpath("//div[contains(text(),'Dominic')]"));
		Thread.sleep(500);
		WebElement employeeListlastName3 = driver.findElement(By.xpath("//div[contains(text(),'Chase')]"));
		Thread.sleep(500);

		if ((employeeListFirstName1.getText().toLowerCase().contains("ch")
				|| employeeListlastName1.getText().toLowerCase().contains("ch"))
				&& (employeeListFirstName2.getText().toLowerCase().contains("ch")
						|| employeeListlastName2.getText().toLowerCase().contains("ch"))
				&& (employeeListFirstName3.getText().toLowerCase().contains("ch")
						|| employeeListlastName3.getText().toLowerCase().contains("ch"))) {
			areFirstThreeEmployeesDisplayed = true;
		} else {
			areFirstThreeEmployeesDisplayed = false;
		}

		Assert.assertTrue(areFirstThreeEmployeesDisplayed);
		driver.close();
	}

	@Test
	public void TestCase_2_VerifyUserCanAddPayGrades() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		1. Navigate
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		2. Type the following credentials:
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

//		3. Click Login button
		WebElement login_button = driver.findElement(By.className("oxd-button"));
		login_button.click();
		
//		4. Click on Admin from side menu bar
		WebElement Admin_Button = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
		Admin_Button.click();
		
//		5. Click Job dropdown
		WebElement Job_Dropdown = driver
				.findElement(By.xpath("//span[normalize-space()='Job']//i[@class='oxd-icon bi-chevron-down']"));
		Job_Dropdown.click();
		
//		6. Click Pay Grades
		WebElement Pay_Grade = driver.findElement(By.xpath("(//a[normalize-space()='Pay Grades'])[1]"));
		Pay_Grade.click();

//		7. Click green +Add button
		WebElement Add_Button = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		Add_Button.click();

//		8. Type "Indian Rupee" in the name input field
		WebElement Name_Input = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name_Input.sendKeys("Indian Rupee");

//		9. Click green Save button
		WebElement Save_Button = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		Save_Button.click();

//		10. Click green + Add button on the Currencies section 
		WebElement Add_currencies = driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"));
		Add_currencies.click();

//		12. Type Minimum Salary as 30000
		WebElement Minimum_Salary = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
		Minimum_Salary.sendKeys("30000");

//		11. Select Indian Rupee from Current dropdown
		WebElement Current_Dropdown = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
		Current_Dropdown.click();
		Current_Dropdown.sendKeys("iii" + Keys.ENTER);

//		13. Type Maximum Salary as 100000
		WebElement maximum_Salary = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]"));
		maximum_Salary.sendKeys("100000");

//		14. Click green Save button on Currencies section
		WebElement Save_Button_currencies = driver
				.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]"));
		Save_Button_currencies.click();

//		Expected Result
//		1. Verify user can observe the added records in the Currencies section
		WebElement addedCurrency = driver.findElement(By.xpath("//div[normalize-space()='Indian Rupee']"));
		Assert.assertNotNull(addedCurrency);

		Thread.sleep(3000);
		driver.close();
	}

}
