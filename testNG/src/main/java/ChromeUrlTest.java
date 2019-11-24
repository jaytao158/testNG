import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class ChromeUrlTest {
    public static WebDriver driver;

    public WebDriver startChrome(String url) throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\gj\\testNG\\src\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            System.out.println("成功打开谷歌浏览器！");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("打开谷歌浏览器时出错了"+e);
        }
        return driver;
    }

    //关闭浏览器
    public void tearDownBrowser() throws Exception {
        try {
            Thread.sleep(2000);
            driver.close();
            System.out.println("成功关闭浏览器！");
        } catch (Exception e) {
            System.out.println("关闭浏览器时出错了" + e);
        }
    }


    public void searchAndSelectTest(){
        try {
            driver=startChrome("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("selenium");
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]/div/span")).click();
            tearDownBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ChromeUrlTest test = new ChromeUrlTest();
        test.searchAndSelectTest();
    }


}
