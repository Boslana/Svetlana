package Main

import constructor_classes.locatorsTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.testng.AssertJUnit
import utils.PlatformTouchAction
import java.time.Duration
import java.util.concurrent.TimeUnit

open class TestMetchods: BaseClass() {

    fun clickToElement(locatorType: String, locator: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.click()
        TimeUnit.SECONDS.sleep(1)
    }

    fun inputTextInField(locatorType: String, locator: String, inputText: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.sendKeys(inputText)
        TimeUnit.SECONDS.sleep(1)
    }

    // свайп до координат
    fun swipeOnScreen(
            startCordX: Int,
            startCordY: Int,
            moveCordX: Int,
            moveCordY: Int,
    ) {
        PlatformTouchAction(driver)
            .longPress(PointOption.point(startCordX, startCordY))
            .moveTo(PointOption.point(moveCordX, moveCordY))
            .release()
            .perform()
    }

    // Тап по координатам на экране
    fun tapByCoordinates(
            cordX: Int,
            cordY: Int,
    ) {
        PlatformTouchAction(driver)
                .tap(PointOption.point(cordX, cordY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .perform()
    }


    // проверка доступности элемента
    fun checkAvailableElement (locatorType: String, locator: String) {
        var checkAvailableElement = false // создаем обхект типа boolean
        when (locatorType) {
        locatorsTypes.id -> checkAvailableElement = driver.findElement(MobileBy.id(locator)).isEnabled
        locatorsTypes.xpath -> checkAvailableElement = driver.findElement(MobileBy.xpath(locator)).isEnabled
        }
        AssertJUnit.assertTrue(checkAvailableElement)
    }

    // проверка текста в элементе
    fun checkTextInElement (locatorType: String, locator: String, text: String) {
        lateinit var element: MobileElement
        var elementAttribute = "" // создаем объект с пустой строкой
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
            elementAttribute = element.getAttribute("text")
            AssertJUnit.assertEquals(elementAttribute,text)
    }

    //очищение поля
    fun cleanField (locatorType: String, locator: String) {
        lateinit var element: MobileElement
        when (locatorType) {
            locatorsTypes.id -> element = driver.findElement(MobileBy.id(locator))
            locatorsTypes.xpath -> element = driver.findElement(MobileBy.xpath(locator))
        }
        element.clear() //очищение
    }
}