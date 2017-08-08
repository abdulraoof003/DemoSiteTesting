package Test;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {


		@FindBy(css = "table  tbody  tr  td:nth-child(1)  table  tbody  tr:nth-child(1)  td:nth-child(2)  p  input")
		private WebElement enterusernameInput;
		
		
		@FindBy(css = "table  tbody tr:nth-child(2)  td:nth-child(2)  p  input")
		private WebElement enterpassWordInput;
		
		
		@FindBy(css = "table  tbody  tr:nth-child(3) td:nth-child(2) p input")
		private WebElement submitButton;
		

		public void usernameInput(String username) 
			{
			enterusernameInput.sendKeys(username);
			}
		
		public void passWordInput(String password) 
			{enterpassWordInput.sendKeys(password);
			}
		
		public void submitUserReg() {
			submitButton.click();
		}
	
	
}
