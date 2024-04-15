package com.projects.CustomDriverParallelExecution.pages;

import com.projects.constants.ConfigData;
import com.projects.drivers.DriverManager;
import com.projects.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    private void setEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {
        WebUI.setText(inputPassword,password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
    }

    //Các hàm xử lý cho chính trang này
    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage();
    }
}
