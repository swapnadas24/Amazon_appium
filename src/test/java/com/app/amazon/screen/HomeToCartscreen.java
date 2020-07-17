package com.app.amazon.screen;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

class HomeToCartscreen extends AppLunchQuit {

    public void SignIn() throws InterruptedException {

        // Click Sign button
        driver.findElement(By.xpath(prop.getProperty("signIn_tab"))).click();
        Thread.sleep(10000);

        // Do login the app
        driver.findElement(By.xpath(prop.getProperty("mobileORemail"))).sendKeys(prop.getProperty("mobileNumber"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("click_Continue"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath(prop.getProperty("enter_password"))).sendKeys(prop.getProperty("password"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(prop.getProperty("click_login"))).click();
        Thread.sleep(10000);
/* 
        if (driver.findElement(By.xpath(prop.getProperty("sendOtp_tab"))).isDisplayed()) {

            // Enter OTP
            driver.findElement(By.xpath(prop.getProperty("sendOtp_tab"))).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(prop.getProperty("enter_OTP"))).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath(prop.getProperty("click_OTP_continue"))).click();
            Thread.sleep(3000);
        } */

        // Check home screen should come after login
        Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("home_screen"))).isDisplayed());
        Thread.sleep(3000);
    }

    public void addTocart_checkout() throws InterruptedException {

        // Click the search bar to search for a 65-inch TV
        AndroidElement searchbar = driver.findElement(By.xpath(prop.getProperty("search")));
        searchbar.click();
        Thread.sleep(1000);
        searchbar.sendKeys("65 inch tv");
        Thread.sleep(3000);

        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.LinearLayout\"), \"\")"));

        // Perform the action on the element
        element.click();
        Thread.sleep(5000);

        // Select the item, check the decription and do Add to cart
        driver.findElement(By.xpath(prop.getProperty("select_TV"))).click();
        Thread.sleep(2000);

        AndroidElement tvDescription_PDP = driver.findElement(By.xpath(prop.getProperty("tvDescription_PDP")));
        tvDescription_PDP.getText();

        driver.findElement(By.xpath(prop.getProperty("click_addToCart"))).click();
        Thread.sleep(15000);

        driver.findElement(By.xpath(prop.getProperty("Cart_page"))).click();
        Thread.sleep(2000);

        // Check product description on PDP and cart page are same
        AndroidElement tv_description_checkout = driver
                .findElement(By.xpath(prop.getProperty("tv_description_checkout")));

        Assert.assertEquals(tvDescription_PDP.getText(), tv_description_checkout.getText(),
                "Both the description of the item is same");
        Thread.sleep(2000);

        // Click Checkout
        driver.findElement(By.xpath(prop.getProperty("click_ProceedToBuy"))).click();
        Thread.sleep(5000);

    }

    @Test
    public void addtoCartTocheckout() throws InterruptedException {
        this.SignIn();
        this.addTocart_checkout();

    }

}