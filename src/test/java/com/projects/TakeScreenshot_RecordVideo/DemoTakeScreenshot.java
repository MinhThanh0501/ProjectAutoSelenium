package com.projects.TakeScreenshot_RecordVideo;

import com.projects.CustomDriverParallelExecution.pages.LoginPage;
import com.projects.common.BaseTest;
import com.projects.helpers.CaptureHelper;
import com.projects.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoTakeScreenshot extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        CaptureHelper.startRecord("testLoginCRM_Success");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );

        //CaptureHelper.takeScreenshot("testLoginCRM_Success");

        //CaptureHelper.stopRecord();

        loginPage.verifyLoginSuccess();

    }

    @Test
    public void testLoginCRM_Fail() {
        System.out.println("=====testLoginCRM_Success=====");
        CaptureHelper.startRecord("testLoginCRM_Fail");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2)
        );

        //CaptureHelper.takeScreenshot("testLoginCRM_Fail");

        //CaptureHelper.stopRecord();

        loginPage.verifyLoginSuccess();

    }

}
