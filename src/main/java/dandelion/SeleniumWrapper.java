package dandelion;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Selenium WebDriverの簡易wrapper.
 */
public class SeleniumWrapper {

    /**
     * 自 singleton Instance.
     */
    private static SeleniumWrapper ownInstance;

    /**
     * WebDriver singleton instance.
     */
    private static WebDriver webDriverInstance;

    enum WebDriverNames {
        Chrome, IE, FireFox
    }

    public static SeleniumWrapper getInstance() {
        if(ownInstance == null) {
            ownInstance = new SeleniumWrapper();
        }
        return ownInstance;
    }

    /**
     * 指定されたWebDriverでブラウザを開きます。
     * 開いたWebDriverはシングルトンインスタンスとして保持します。
     * @param driver
     */
    public void Open(WebDriverNames driver){
        switch (driver){
            case Chrome:
                this.webDriverInstance = new ChromeDriver();
                break;
            case IE:
                this.webDriverInstance = new ChromeDriver();
                break;
            case FireFox:
                this.webDriverInstance = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("指定されたWebDriver名'%1'には対応していません。", driver));
        }
        this.webDriverInstance.get("https://www.google.com/");
    }

    /**
     * 起動済みのブラウザでスクリーンショットを撮る。
     */
    public void takeScreenShot(Path outputPath) {
        System.out.println("= Screen Shot =");
        File img = ((TakesScreenshot)this.webDriverInstance).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(img, outputPath.toFile());
            System.out.println("Name : " + outputPath.toFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ブラウザ閉じる
     */
    public void quit() {
        if(this.webDriverInstance != null) {
            this.webDriverInstance.quit();
        }
    }
}
