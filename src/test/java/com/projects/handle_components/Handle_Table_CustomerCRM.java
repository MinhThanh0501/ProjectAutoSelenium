package com.projects.handle_components;

import com.projects.TestListener.pages.CustomerPage;
import com.projects.TestListener.pages.DashboardPage;
import com.projects.TestListener.pages.LoginPage;
import com.projects.common.BaseTest;
import com.projects.constants.ConfigData;
import org.testng.annotations.Test;

public class Handle_Table_CustomerCRM extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testCheckDataOnTable(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.searchCustomerOnTable("Viettel A1"); //Tra ra 25 records /page
        //customerPage.checkPageTotal(5);
        customerPage.checkSearchTableByColumn(3, "Viettel A1"); //So sanh contains
    }

}
