package com.koch.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {
	public static void waitForVisibiltyOfWebElement(WebDriver driver,WebElement element,int timeout) {
		WebDriverWait  wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
    public static String getIntegerValueFromString(String str) {
    	str=str.replaceAll("\n", " ");
        String intValue=null;
        for(String s:str.toLowerCase().split(" ") ) {
               CharSequence ch=s;
               for(int i=0;i<ch.length();i++) {
                     if(Character.isDigit(ch.charAt(i))) {
                            intValue=s;
                            break;
                     }
               }     
        }
        return intValue;
 }
}
