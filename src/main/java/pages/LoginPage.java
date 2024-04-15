package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setTxtUsername(String username){
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    @FindBy(id = "user-name")
    public WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

}
