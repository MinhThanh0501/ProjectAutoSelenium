package com.projects.ReadPropertiesFile;

import com.projects.constants.ConfigData;
import com.projects.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadProperties {
    @Test
    public void testReadPropertiesFile(){
        PropertiesHelper.loadAllFiles();

        System.out.println(ConfigData.URL);
        System.out.println(PropertiesHelper.getValue("email"));
        System.out.println(PropertiesHelper.getValue("password"));

        //Gộp nhiều file
        System.out.println(PropertiesHelper.getValue("key1"));
        System.out.println(PropertiesHelper.getValue("key2"));

        //Set file
        PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
        PropertiesHelper.setValue("message", "Add customer successfully");
    }
}
