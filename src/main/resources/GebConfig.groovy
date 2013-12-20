import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { new FirefoxDriver() }
System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver.exe").getAbsolutePath())
driver = { new ChromeDriver() }
quitCachedDriverOnShutdown = false


environments {
    // run as “mvn -Dgeb.env=chrome test”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        //http://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver.exe").getAbsolutePath())
        driver = { new ChromeDriver() }
    }
    ie {
        // download the 32 bits. https://code.google.com/p/selenium/downloads/list
        //The IEDriverServer exectuable must be downloaded and placed in your PATH.
//        On IE 7 or higher on Windows Vista or Windows 7, you must set the Protected Mode settings for each zone to be
// the same value. The value can be on or off, as long as it is the same for every zone.
// To set the Protected Mode settings, choose "Internet Options..." from the Tools menu, and click on the Security tab.
// For each zone, there will be a check box at the bottom of the tab labeled "Enable Protected Mode".
//                The browser zoom level must be set to 100% so that the native mouse events can be set to the correct coordinates.
        System.setProperty("webdriver.ie.driver", new File("drivers/IEDriverServer.exe").getAbsolutePath())
        driver = { new InternetExplorerDriver() }
    }
}