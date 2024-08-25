import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCatatanKeuangan {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 31");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "12");
        dc.setCapability("appium:appPackage","com.chad.financialrecord");
        dc.setCapability("appium:appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,dc);
    }

    @AfterClass
    public void finish() {
        delay(3);
        driver.quit();
    }

    @Test(priority = 1)
    public void testIncomeGaji(){//function untuk input pemasukkan Gaji
        delay(10);
        //klik pada button +
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(5);
        //klik untuk pilih pemasukkan
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click();
        delay(5);
        //klik untuk menu date
        driver.findElementById("com.chad.financialrecord:id/tvDate").click();
        delay(2);
        //klik untuk pilih tanggal yang diinginkan
        driver.findElementByXPath("//android.view.View[@content-desc='25 Agustus 2024']").click();
        delay(2);
        //klik button oke
        driver.findElementById("android:id/button1").click();
        delay(2);
        //klik pada bar kategori
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(5);
        //klik pada list kategori yg diinginkan
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Gaji']").click();
        delay(5);
        //input amount
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("5000000");
        delay(5);
        //input note
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Gaji Agustus");
        delay(5);
        //klik button simpan
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(5);
        //membaca nilai kategori
        String actualGaji = driver.findElementById("com.chad.financialrecord:id/tvName").getText();
        Assert.assertEquals(actualGaji,"Gaji");
        //membaca nilai amount
        String actualAmount = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvAmount' and @text='5.000.000']").getText();
        Assert.assertEquals(actualAmount,"5.000.000");
        System.out.println("Income Gaji Success");
    }

    @Test(priority = 2)
    public void testIncomeDividen() {//function untuk input pemasukkan Dividen
        delay(10);
        //klik pada button +
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(5);
        //klik untuk pilih pemasukkan
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click();
        delay(5);
        //klik untuk menu date
        driver.findElementById("com.chad.financialrecord:id/tvDate").click();
        delay(2);
        //klik untuk pilih tanggal yang diinginkan
        driver.findElementByXPath("//android.view.View[@content-desc='26 Agustus 2024']").click();
        delay(2);
        //klik button oke
        driver.findElementById("android:id/button1").click();
        delay(2);
        //klik pada bar kategori
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(5);
        //klik pada list kategori yg diinginkan
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Dividen']").click();
        delay(5);
        //input amount
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("250000");
        delay(5);
        //input note
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Dividen Agustus");
        delay(5);
        //klik button simpan
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(5);
        //membaca nilai kategori
        String actualDividen = driver.findElementById("com.chad.financialrecord:id/tvName").getText();
        Assert.assertEquals(actualDividen,"Dividen");
        //membaca nilai amount
        String actualAmount = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvAmount' and @text='250.000']").getText();
        Assert.assertEquals(actualAmount,"250.000");
        System.out.println("Income Dividen Success");
    }


    @Test(priority = 3)
    public void testSpendTransportasi() {//function untuk input pengeluaran Transportasi
        delay(10);
        //klik pada button +
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(5);
        //klik untuk menu date
        driver.findElementById("com.chad.financialrecord:id/tvDate").click();
        delay(2);
        //klik untuk pilih tanggal yang diinginkan
        driver.findElementByXPath("//android.view.View[@content-desc='26 Agustus 2024']").click();
        delay(2);
        //klik button oke
        driver.findElementById("android:id/button1").click();
        delay(2);
        //klik pada bar kategori
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(5);
        scrollToText("Transportasi");//scroll ke kategori Transportasi
        //klik pada list kategori yg diinginkan
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Transportasi']").click();
        delay(5);
        //input amount
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("50000");
        delay(5);
        //input note
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Transportasi Ojek");
        delay(5);
        //klik button simpan
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(5);
        //membaca nilai kategori
        String actualTransport = driver.findElementById("com.chad.financialrecord:id/tvName").getText();
        Assert.assertEquals(actualTransport,"Transportasi");
        //membaca nilai amount
        String actualAmount = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvAmount' and @text='50.000']").getText();
        Assert.assertEquals(actualAmount,"50.000");
        System.out.println("Spend Transportasi Success");
    }

    @Test(priority = 4)
    public void testSpendHiburan() {//function untuk input pengeluaran Hiburan
        delay(10);
        //klik pada button +
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(5);
        //klik untuk menu date
        driver.findElementById("com.chad.financialrecord:id/tvDate").click();
        delay(2);
        //klik untuk pilih tanggal yang diinginkan
        driver.findElementByXPath("//android.view.View[@content-desc='28 Agustus 2024']").click();
        delay(2);
        //klik button oke
        driver.findElementById("android:id/button1").click();
        delay(2);
        //klik pada bar kategori
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(5);
        scrollToText("Hiburan");//scroll ke kategori Hiburan
        //klik pada list kategori yg diinginkan
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Hiburan']").click();
        delay(5);
        //input amount
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("500000");
        delay(5);
        //input note
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Hiburan Game");
        delay(5);
        //klik button simpan
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(5);
        //membaca nilai kategori
        String actualHiburan = driver.findElementById("com.chad.financialrecord:id/tvName").getText();
        Assert.assertEquals(actualHiburan,"Hiburan");
        //membaca nilai amount
        String actualAmount = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvAmount' and @text='500.000']").getText();
        Assert.assertEquals(actualAmount,"500.000");
        System.out.println("Spend Hiburan Success");
    }

    @Test(priority = 5)
    public void testSpendKesehatan() {//function untuk input pengeluaran Kesehatan
        delay(10);
        //klik pada button +
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(5);
        //klik untuk menu date
        driver.findElementById("com.chad.financialrecord:id/tvDate").click();
        delay(2);
        //klik untuk pilih tanggal yang diinginkan
        driver.findElementByXPath("//android.view.View[@content-desc='30 Agustus 2024']").click();
        delay(2);
        //klik button oke
        driver.findElementById("android:id/button1").click();
        delay(2);
        //klik pada bar kategori
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        delay(5);
        scrollToText("Kesehatan");//scroll ke kategori Kesehatan
        //klik pada list kategori yg diinginkan
        driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Kesehatan']").click();
        delay(5);
        //input amount
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("1000000");
        delay(5);
        //input note
        driver.findElementById("com.chad.financialrecord:id/etNote").sendKeys("Kesehatan Mental");
        delay(5);
        //klik button simpan
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(5);
        //membaca nilai kategori
        String actualKesehatan = driver.findElementById("com.chad.financialrecord:id/tvName").getText();
        Assert.assertEquals(actualKesehatan,"Kesehatan");
        //membaca nilai amount
        String actualAmount = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvAmount' and @text='1.000.000']").getText();
        Assert.assertEquals(actualAmount,"1.000.000");
        System.out.println("Spend Kesehatan Success");
    }

    @Test(priority = 6)
    public void testSaving() {//function untuk cek Saldo
        delay(10);
        //membaca nilai saldo
        String actualSave = driver.findElementById("com.chad.financialrecord:id/tvBalance").getText();
        Assert.assertEquals(actualSave,"3.700.000");
        System.out.println(actualSave);//menampilkan output amount pada terminal
        System.out.println("Total Saldo Success");
    }


    private void scrollToText(String text) {//function untuk scroll & search kategori
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        );
    }

    public void delay(long detik) {//function untuk delay
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
