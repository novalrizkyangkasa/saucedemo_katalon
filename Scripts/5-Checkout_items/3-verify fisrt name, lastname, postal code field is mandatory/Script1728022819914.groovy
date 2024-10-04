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

//WebUI.callTestCase(findTestCase('5-Checkout_items/2-verify user able to see detail information on footer section'), [:], 
//    FailureHandling.STOP_ON_FAILURE)

'verify first name field is mandatory field'
WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'), 
    'test')

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'), 
    '6131')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Checkout/verify mandatory field/input_Cancel_continue'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/verify mandatory field/div_Error First Name is required'))

WebUI.verifyElementText(findTestObject('Checkout/verify mandatory field/div_Error First Name is required'), 'Error: First Name is required')

// Ambil URL saat ini
String currentUrl = WebUI.getUrl()

// Cek apakah URL saat ini adalah checkout-step-two.html
if (currentUrl.equals('https://www.saucedemo.com/checkout-step-two.html')) {
    // Jika diarahkan ke halaman checkout-step-two, hentikan eksekusi dengan STOP_ON_FAILURE
    WebUI.comment('User diarahkan ke halaman checkout-step-two, seharusnya tidak diarahkan karena belum mengisi data diri.')

    WebUI.verifyNotEqual(currentUrl, 'https://www.saucedemo.com/checkout-step-two.html', FailureHandling.STOP_ON_FAILURE // Jika URL bukan checkout-step-two.html, lanjutkan tes
        )
} else {
    KeywordUtil.logInfo('User tidak diarahkan ke halaman checkout-step-two, validasi berhasil.')
}

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.delay(1)

WebUI.refresh()

'verify last name field is mandatory field'
WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_firstName'), 
    'test2')

WebUI.delay(2)

WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'), 
    '6131')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Checkout/verify mandatory field/input_Cancel_continue'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/verify mandatory field/div_Error Last Name is required'))

WebUI.verifyElementText(findTestObject('Checkout/verify mandatory field/div_Error Last Name is required'), 'Error: Last Name is required')

// Cek apakah URL saat ini adalah checkout-step-two.html
if (currentUrl.equals('https://www.saucedemo.com/checkout-step-two.html')) {
    // Jika diarahkan ke halaman checkout-step-two, hentikan eksekusi dengan STOP_ON_FAILURE
    WebUI.comment('User diarahkan ke halaman checkout-step-two, seharusnya tidak diarahkan karena belum mengisi data diri.')

    WebUI.verifyNotEqual(currentUrl, 'https://www.saucedemo.com/checkout-step-two.html', FailureHandling.STOP_ON_FAILURE // Jika URL bukan checkout-step-two.html, lanjutkan tes
        )
} else {
    KeywordUtil.logInfo('User tidak diarahkan ke halaman checkout-step-two, validasi berhasil.')
}

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.delay(1)

WebUI.refresh()

'verify zip/postal code field is mandatory field'
WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.setText(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'), 'text')

WebUI.delay(2)

WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'), 
    'test')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Checkout/verify mandatory field/input_Cancel_continue'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/verify mandatory field/div_Error Postal Code is required'))

WebUI.verifyElementText(findTestObject('Checkout/verify mandatory field/div_Error Postal Code is required'), 'Error: Postal Code is required')

// Cek apakah URL saat ini adalah checkout-step-two.html
if (currentUrl.equals('https://www.saucedemo.com/checkout-step-two.html')) {
    // Jika diarahkan ke halaman checkout-step-two, hentikan eksekusi dengan STOP_ON_FAILURE
    WebUI.comment('User diarahkan ke halaman checkout-step-two, seharusnya tidak diarahkan karena belum mengisi data diri.')

    WebUI.verifyNotEqual(currentUrl, 'https://www.saucedemo.com/checkout-step-two.html', FailureHandling.STOP_ON_FAILURE // Jika URL bukan checkout-step-two.html, lanjutkan tes
        )
} else {
    KeywordUtil.logInfo('User tidak diarahkan ke halaman checkout-step-two, validasi berhasil.')
}

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

