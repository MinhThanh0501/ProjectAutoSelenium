package com.projects.CustomDriverParallelExecution.testcases;

import com.projects.CustomDriverParallelExecution.pages.CustomerPage;
import com.projects.CustomDriverParallelExecution.pages.DashboardPage;
import com.projects.CustomDriverParallelExecution.pages.LoginPage;
import com.projects.common.BaseTest;
import com.projects.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

        customerPage.clickButtonAddNew();

        String CUSTOMER_NAME = "FPT Software A7";
        customerPage.inputFormData(CUSTOMER_NAME);
        dashboardPage.clickMenuCustomers();
        customerPage.searchAndVerifyCustomer(CUSTOMER_NAME);
        customerPage.verifyCustomerDetail(CUSTOMER_NAME);

        //In ra emoji từ Telegram copy dán vào
        System.out.println("\uD83C\uDF80 \uD83D\uDD06 \uD83D\uDE1C \uD83D\uDE0B \uD83D\uDE01");

    }
}
