package com.projects.constants;

import com.projects.helpers.PropertiesHelper;

public class ConfigData {
//    public static String URL = "https://crm.projects.com/admin/authentication";
//    public static String EMAIL = "admin@example.com";
//    public static String PASSWORD = "123456";

    public static String URL = PropertiesHelper.getValue("url");
    public static String EMAIL = PropertiesHelper.getValue("email");
    public static String PASSWORD = PropertiesHelper.getValue("password");
}
