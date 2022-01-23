package Locators

import constructor_classes.LocatorsConstructor

class AuthorizationScreenLocators {

    val phoneNumberFieldOnAuthorizationScreen = LocatorsConstructor(
            andriodId = "ru.sportmaster.app.handh.dev:id/editTextPhone"
    )

    val getCodeButtonOnAuthorizationScreen = LocatorsConstructor (
            andriodId = "ru.sportmaster.app.handh.dev:id/buttonGetCode"
            )
}