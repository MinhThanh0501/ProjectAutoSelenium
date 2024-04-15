package com.projects.CustomDriverParallelExecution.pages;

import com.projects.drivers.DriverManager;
import com.projects.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[normalize-space()='Logout']");
    private By menuReports = By.xpath("//span[normalize-space()='Reports']");

    public void clickMenuDashboard(){
        WebUI.clickElement(menuDashboard);
    }

    public CustomerPage clickMenuCustomers(){
        WebUI.clickElement(menuCustomers);

        return new CustomerPage();
    }

    public void clickMenuProjects(){
        WebUI.clickElement(menuProjects);
    }

    public LoginPage logOut(){
        WebUI.clickElement(dropdownProfile);
        WebUI.clickElement(optionLogout);

        return new LoginPage();
    }

    public void verifyMenuReportDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuReports), "Menu Report not exist.");
        Assert.assertTrue(DriverManager.getDriver().findElement(menuReports).isDisplayed(), "Menu Report not display.");
    }

    public void verifyMenuReportNotDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.checkElementExist(menuReports), "Menu Report is displayed.");
    }

}
