package com.projects.handle_components;

import com.projects.TestListener.pages.CustomerPage;
import com.projects.TestListener.pages.DashboardPage;
import com.projects.TestListener.pages.LoginPage;
import com.projects.common.BaseTest;
import com.projects.constants.ConfigData;
import com.projects.keywords.WebUI;
import com.projects.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Handle_Pagination_Table extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testCheckDataOnTable_Pagination() {

        String searchValue = "Viettel";

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashboardPage.clickMenuCustomers();

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='DataTables_Table_0_length']")));

        select.selectByVisibleText("10");
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        //WebUI.setText(By.xpath("//input[@type='search']"), searchValue);
        customerPage.searchCustomerOnTable(searchValue); //Tra ra 26 items

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='DataTables_Table_0_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            customerPage.checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[normalize-space()='Next']"));
                WebUI.sleep(2);
            }
        }

    }

}
