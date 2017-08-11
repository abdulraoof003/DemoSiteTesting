package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class setupSearchCars {


		@FindBy(css = "#postcode")
		private WebElement setpostcodeInput;
		


		public void userpostcodeInput(String postcode) 
			{
			setpostcodeInput.sendKeys(postcode);
			}


		}
	
	

