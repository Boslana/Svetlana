package Tests

import Locators.*
import Main.TestMetchods
import constructor_classes.locatorsTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestOne: TestMetchods() {

    @Test
    fun testOne() {
        TimeUnit.SECONDS.sleep(10)

        try {

        //клик по крестику
        clickToElement(
                    locatorType = locatorsTypes.xpath,
                    locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        //Ввод текста в поле
        inputTextInField(
                locatorType = locatorsTypes.id,
                locator = AuthorizationScreenLocators().phoneNumberFieldOnAuthorizationScreen.andriodId,
                inputText = "9999999988"
        )

        // нажатие на кнопку Получить код
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = AuthorizationScreenLocators().getCodeButtonOnAuthorizationScreen.andriodId
        )

        //Ввод полученного кода
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = SMSCodeVerificationScreenLocators().codFieldOnSMSCodeVerificationScreen.andriodId,
            inputText = "1111"
        )

        // даем доступ к геолокации
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = DialogAndAlertLocators().allowGeoLocationOnUseButton.andriodId
        )

        // выбираем город
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = SelectionCityScreenLocators().yesButtonOnSelectionCityScreenLocators.andriodId
        )

        // переходим в профиль
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = TabbarLocators().profileButton.andriodId
        )

        // нажатие на иконку "Редактировать"
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = ProfileScreenLocators().editProfileButtonOnProfileScreen.andriodId
        )

        // очищаем поле Имя
        cleanField(
                locatorType = locatorsTypes.id,
                locator = EditProfileScreenLocators().editTextFirstNameOnEditProfileScreen.andriodId
        )
        // свайп вниз
        swipeOnScreen(
                startCordX = 500,
                startCordY = 1555,
                moveCordX = 500,
                moveCordY = 1200,
        )

        // нажатие на кнопку "Выйти из профиля"
        clickToElement(
                locatorType = locatorsTypes.id,
                locator = EditProfileScreenLocators().logoutButtonOnEditProfileScreen.andriodId
        )

        // проверка кнопки "Войти" на экране профиля
        checkAvailableElement(
                locatorType = locatorsTypes.id,
                locator = ProfileScreenLocators().checkSignInButtonOnProfileScreen.andriodId
        )
        println("Кнопка Войти присутствует на экане")

        // проверка текста в элементе
        checkTextInElement(
                locatorType = locatorsTypes.id,
                locator = ProfileScreenLocators().checkSignInButtonOnProfileScreen.andriodId,
                text = "Войти"
        )
        println("Текс Войти есть в элементе")

        TimeUnit.SECONDS.sleep(5)

    }
}