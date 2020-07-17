package com.app.amazon.screen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.app.amazon.base.Testbase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

class AppLunchQuit extends Testbase {

	
	AndroidDriver<AndroidElement> driver;
    DesiredCapabilities caps;
    
	@BeforeTest
	public void setCapa() throws InterruptedException, IOException {
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "W89DN7UGWWPBHUJZ");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.mShop.android.shopping");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.android.home.HomeActivity");
		caps.setCapability("unicodeKeyboard", "true");
		caps.setCapability("resetKeyboard", "false");
		
	}
	@BeforeClass
	public void lunchApp() throws InterruptedException, MalformedURLException{
		// lunch app
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		Thread.sleep(10000);
		
	}
    @AfterTest
	public void quit() {
    	driver.quit();
		
	}

    
}
