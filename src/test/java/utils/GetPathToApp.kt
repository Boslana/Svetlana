package utils

import java.io.File

class GetPathToApp {
    private var apkName: String? = null
    private var appName: String? = null

    private val matchingFileApk = APK_PATH.listFiles { _, name ->
        if (name.contains("sportmaster"))
            apkName = name
        name.startsWith("sportmaster")
    }
    private val matchingFileApp = APP_PATH.listFiles { _, name ->
        if (name.contains("sportmaster"))
            appName = name
        name.startsWith("sportmaster")
    }
    val fullLocalAppLocalPathIOS = "/Users/$USER_NAME/handh/$appName"
    val fullAppLocalPathAndroid = "/Users/$USER_NAME/handh/$apkName"

    companion object {
        private val USER_NAME: String = System.getProperty("user.name")
        private val F = File("/Users/$USER_NAME/Library/Developer/Xcode/DerivedData/")
        private val APK_PATH = File("/Users/$USER_NAME/handh")
        private val APP_PATH = File("/Users/$USER_NAME/handh")

    }
}

val appPath = GetPathToApp()