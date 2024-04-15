package com.projects.CustomDriverParallelExecution.testcases;

import com.projects.CustomDriverParallelExecution.pages.CustomerPage;
import com.projects.CustomDriverParallelExecution.pages.DashboardPage;
import com.projects.CustomDriverParallelExecution.pages.LoginPage;
import com.projects.common.BaseTest;
import com.projects.constants.ConfigData;
import com.projects.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }

    @Test
    public void testProjectRole(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("project@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportNotDisplay();
    }

}
