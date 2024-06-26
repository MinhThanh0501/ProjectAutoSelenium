package com.projects.dataprovider;

import com.projects.dataprovider.DataProviderFactory;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DemoDataProvider {

    @Test(dataProvider = "DataLoginSuccess", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password) {
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);
    }

    @Test(dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginDataFromExcelMultipleRow(Hashtable<String, String> data) {
        System.out.println("EMAIL: " + data.get("EMAIL"));
        System.out.println("PASSWORD: " + data.get("PASSWORD"));
    }

}
