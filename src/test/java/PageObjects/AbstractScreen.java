package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract page object.
 */
public abstract class AbstractScreen {

    protected final AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
        return (MobileElement)(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void takeScreenShot(){
        driver.getScreenshotAs(OutputType.BASE64);
    }


    // add here going back etc etc


}
