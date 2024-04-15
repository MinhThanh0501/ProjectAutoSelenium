package com.projects.TestListener.testcases;

import com.projects.TestListener.pages.CustomerPage;
import com.projects.TestListener.pages.DashboardPage;
import com.projects.TestListener.pages.LoginPage;
import com.projects.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage() {
        //loginPage = new LoginPage(driver);
        //loginPage.loginCRM("admin@example.com", "123456");
        //loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        //dashboardPage.clickMenuCustomers();

        //customerPage = new CustomerPage(driver);
        //customerPage.verifyRedirectCustomerPageSuccess();

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();

    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();

    }

}
