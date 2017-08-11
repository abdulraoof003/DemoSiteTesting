package Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegPage2 {



		@FindBy(css = "#email_create")
		private WebElement setemailInput;
		
	
		@FindBy(name = "username")
		private WebElement setusernameInput;
		
		
		@FindBy(css = "table  tbody tr:nth-child(2) td:nth-child(2) p  input")
		private WebElement setpassWordInput;
		
		
		@FindBy(css = "table  tbody  tr:nth-child(3) td:nth-child(2) p input")
		private WebElement submitButton;

		
		public void setemailInput(String email) 
		{
		setusernameInput.sendKeys(email);
		}
		

		public void usernameInput(String username) 
			{
			setusernameInput.sendKeys(username);
			}
		
		public void setpassWordInput(String password) 
			{setpassWordInput.sendKeys(password);
			}
		
		public void submitUserReg() {
			submitButton.click();
		}
	
	
}
