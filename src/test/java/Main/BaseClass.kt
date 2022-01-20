package Main

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.util.concurrent.TimeUnit

class BaseClass {
    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeSuite
    fun setupDriver() {

        val url = URL("http://127.0.0.1:4723/wd/hub")
        val caps = DesiredCapabilities()

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android") // название платформы
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11") // версия ОС
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A50") // имя устройства
        caps.setCapability(MobileCapabilityType.APP, "/Users/handh/sportmaster-4.0.13.5605_dev_beta.apk")
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "ru.sportmaster.app.handh.dev")
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ru.sportmaster.app.presentation.start.StartActivity")
        caps.setCapability(MobileCapabilityType.NO_RESET, false) // не сбрасывать приложение в 0 перед новым запуском
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "7200")
        caps.setCapability(MobileCapabilityType.UDID, "R58M67DH10R")

        driver = AndroidDriver(url, caps) // установка драйвера и приложения на Android устройство

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS)

    }

    @AfterSuite
    fun end() {
        driver.quit()
    }

    @Test
    fun testOne() {
        TimeUnit.SECONDS.sleep(1)

        try {
            //нажимаем на кнопку
            lateinit var element: MobileElement // создаем объект MobileElement
            element = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")) // производим поиск элемента по локатору id
            element.click() // клик по элементу
            println("клик прошел успешно")
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        //Ввод текста в поле
        lateinit var element2: MobileElement //создаем объект MobileElement
        element2 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/editTextPhone")) //производим поиск элемента по локатору id
        element2.sendKeys("9999999988") // ввод текста в поле

        // клик на кнопку получить код
        lateinit var element3: MobileElement // создаем объект MobileElement
        element3 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonGetCode")) //производим поиск элемента по локатору id
        element3.click() //клик

        //Ввод полученного кода
        lateinit var element4: MobileElement
        element4 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/pinCodeEditText")) //производим поиск элемента по локатору id
        element4.sendKeys("1111") // ввод кода
        println("ввод кода-успешно")

        // даем доступ к геолокации
        lateinit var element5: MobileElement
        element5 = driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
        element5.click() // клик по элементу

        // выбираем город
        lateinit var element6: MobileElement
        element6 = driver.findElement(MobileBy.id("android:id/button1"))
        element6.click()

        // переходим в профиль
        lateinit var element7: MobileElement
        element7 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/profile_graph"))
        element7.click()



        TimeUnit.SECONDS.sleep(5)

    }
}