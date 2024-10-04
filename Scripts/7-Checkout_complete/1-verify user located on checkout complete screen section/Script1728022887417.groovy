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

//WebUI.callTestCase(findTestCase('6-Final-Checkout_overview/3-verify user able tap on finish button after check price total is same based on count each item on step 1'), 
//    [:], FailureHandling.STOP_ON_FAILURE)

'check redirect URL'
actualURL = WebUI.getUrl()

KeywordUtil.logInfo(actualURL)

expectedURL = 'https://www.saucedemo.com/checkout-complete.html'

boolean validateURL = WebUI.verifyEqual(actualURL, expectedURL, FailureHandling.STOP_ON_FAILURE)

if (validateURL) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Redirected user go to URL link is expected. ' + actualURL // Jika teks salah, cetak pesan error dengan teks yang ditemukan
        )
} else {
    KeywordUtil.logInfo('Redirected user go to URL link is NOT expected. The expected is : ' + actualURL)
}

WebUI.verifyElementText(findTestObject('MainMenu/List_content/div_Swag Labs'), 'Swag Labs')

WebUI.verifyElementNotPresent(findTestObject('Checkout_complete/Page_Swag Labs/badge count items added to cart'), 0)

// Klik tombol "hamburger"
'Check inside hamburger menu/sidebar menu'
WebUI.click(findTestObject('MainMenu/List_content/button_Open Menu'))

// Verifikasi apakah ada elemen "All Items"
if (WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_All Items'), FailureHandling.STOP_ON_FAILURE)) {
    // Jika teks sesuai, cetak log bahwa menu All Items terlihat
    println('Menu "All Items" terlihat.' // Jika teks tidak sesuai, cetak log bahwa menu All Items tidak terlihat
        )

    if (WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_About'), FailureHandling.STOP_ON_FAILURE)) {
        // Jika teks sesuai, cetak log bahwa menu About terlihat
        println('Menu "About" terlihat.' // Jika teks tidak sesuai, cetak log bahwa menu About tidak terlihat
            )
    } else {
        println('Menu "About" TIDAK terlihat.')
    }
    
    if (WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_Logout'), FailureHandling.STOP_ON_FAILURE)) {
        // Jika teks sesuai, cetak log bahwa menu Logout terlihat
        println('Menu "Logout" terlihat.' // Jika teks tidak sesuai, cetak log bahwa menu Logout tidak terlihat
            )
    } else {
        println('Menu "Logout" TIDAK terlihat.')
    }
    
    if (WebUI.verifyElementVisible(findTestObject('MainMenu/List_content/a_Reset App State'), FailureHandling.STOP_ON_FAILURE)) {
        // Jika teks sesuai, cetak log bahwa menu Reset App State terlihat
        println('Menu "Reset App State" terlihat.' // Jika teks tidak sesuai, cetak log bahwa menu Reset App State tidak terlihat
            )
    } else {
        println('Menu "Reset App State" TIDAK terlihat.')
    }
} else {
    println('Menu "All Items" TIDAK terlihat.')
}

WebUI.click(findTestObject('MainMenu/List_content/button_Close Menu'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/title_Checkout Complete'))

WebUI.verifyElementText(findTestObject('Checkout_complete/Page_Swag Labs/title_Checkout Complete'), 'Checkout: Complete!')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/icon_Checkout Complete_pony_express'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/title_Thank you for your order'))

WebUI.verifyElementText(findTestObject('Checkout_complete/Page_Swag Labs/title_Thank you for your order'), 'Thank you for your order!')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/desc_Your order has been dispatched'))

WebUI.verifyElementText(findTestObject('Checkout_complete/Page_Swag Labs/desc_Your order has been dispatched'), 'Your order has been dispatched, and will arrive just as fast as the pony can get there!')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/button_Back Home'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Checkout_complete/Page_Swag Labs/button_Back Home'))

