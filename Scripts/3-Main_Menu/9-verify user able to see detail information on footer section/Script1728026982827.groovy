import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
// Untuk membuat dan menggunakan TestObject secara dinamis
import com.kms.katalon.core.testobject.ConditionType as ConditionType
// Untuk keyword WebUI di Katalon
import org.openqa.selenium.WebElement as WebElement
import java.util.List as List

//WebUI.callTestCase(findTestCase('3-Main_Menu/8-verify user able to see detail information'), [:], FailureHandling.STOP_ON_FAILURE)

'Footer section'
WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_Twitter'))

WebUI.click(findTestObject('MainMenu/List_content/a_Twitter'))

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

String currentUrl = WebUI.getUrl()

// Verifikasi apakah URL yang terbuka adalah URL Twitter
'Footer section - Twitter'
String expectedurltwitter = 'https://x.com/saucelabs'

if (currentUrl.contains(expectedurltwitter)) {
    KeywordUtil.logInfo('Halaman di tab baru diarahkan ke URL Twitter dengan benar: ' + currentUrl)
} else {
    KeywordUtil.logInfo('Halaman di tab baru TIDAK diarahkan ke URL Twitter. URL saat ini: ' + currentUrl)
}

// Tutup tab baru
WebUI.closeWindowIndex(1)

// Beralih kembali ke tab asli (tab pertama)
WebUI.switchToWindowIndex(0)

WebUI.delay(5)

'Footer section - Facebook'
WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_Facebook'))

WebUI.click(findTestObject('MainMenu/List_content/a_Facebook'))

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

currentUrl = WebUI.getUrl()

// Verifikasi apakah URL yang terbuka adalah URL Facebook
String expectedurlfb = 'https://www.facebook.com/saucelabs'

if (currentUrl.contains(expectedurlfb)) {
    KeywordUtil.logInfo('Halaman di tab baru diarahkan ke URL Facebook dengan benar: ' + currentUrl)
} else {
    KeywordUtil.logInfo('Halaman di tab baru TIDAK diarahkan ke URL Facebook. URL saat ini: ' + currentUrl)
}

// Tutup tab baru
WebUI.closeWindowIndex(1)

// Beralih kembali ke tab asli (tab pertama)
WebUI.switchToWindowIndex(0)

WebUI.delay(5)

'Footer section - linkedin'
WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_LinkedIn'))

WebUI.click(findTestObject('MainMenu/List_content/a_LinkedIn'))

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

currentUrl = WebUI.getUrl()

// Verifikasi apakah URL yang terbuka adalah URL Linkedin
String expectedurllinkedin = 'https://www.linkedin.com/company/sauce-labs/'

if (currentUrl.contains(expectedurllinkedin)) {
    KeywordUtil.logInfo('Halaman di tab baru diarahkan ke URL Linkedin dengan benar: ' + currentUrl)
} else {
    KeywordUtil.logInfo('Halaman di tab baru TIDAK diarahkan ke URL Linkedin. URL saat ini: ' + currentUrl)
}

// Tutup tab baru
WebUI.closeWindowIndex(1)

// Beralih kembali ke tab asli (tab pertama)
WebUI.switchToWindowIndex(0)

WebUI.verifyElementText(findTestObject('MainMenu/List_content/title footer'), '© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy')

