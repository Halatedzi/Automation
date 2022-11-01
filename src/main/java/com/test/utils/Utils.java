package com.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static WebDriver driver;

    public WebDriver setupWebdriver(String browserName) throws Exception {

        String windowsDriverLocation = "./drivers/windows/";
        String macDriverLocation = "./drivers/mac/";

        System.out.println("Browser name : " + browserName);

        try {

            if(browserName.equalsIgnoreCase("chrome")){
                String chromeDriverPath = null;

                if(this.getOSName().contains("Windows")){
                    chromeDriverPath = windowsDriverLocation + "chromedriver.exe";
                }else if(this.getOSName().contains("Mac OS")){
                    chromeDriverPath = macDriverLocation + "chromedriver";
                }

                String absoluteChromeDriverPath = toAbsolutePath(chromeDriverPath);
                System.setProperty("webdriver.chrome.driver",absoluteChromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension",false);
                options.addArguments("--no-sandbox");

                driver = new ChromeDriver(options);
            }
        }catch (Exception e){
            throw new Exception("Driver not found : " + e);
        }
        return driver;
    }

    public String getOSName(){

        String OSType;
        String OSName = "";

        OSType = System.getProperty("os.name");

        if(OSType.contains("Windows") || OSType.contains("windows")){
            OSName = "Windows";
        }else if(OSType.contains("Mac") || OSType.contains("mac")){
            OSName = "Mac";
        }

        return OSType;
    }

    public static String toAbsolutePath(String relativePath){
        Path relPath = Paths.get(relativePath);
        Path absolutePath= null;

        if(!relPath.isAbsolute()){
            Path base = Paths.get("");
            absolutePath = base.resolve(relPath).toAbsolutePath();
        }

        return absolutePath.normalize().toString();
    }

    public String getConfigPropertyValue(String propertyFileName, String propertyName){
        String value = null;

        try{
            FileInputStream fileIS = new FileInputStream(new File(propertyFileName));
            Properties prop = new Properties();
            prop.load(fileIS);

            value = prop.getProperty(propertyName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

}
