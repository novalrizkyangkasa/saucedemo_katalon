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

//WebUI.callTestCase(findTestCase('5-Checkout_items/3-verify fisrt name, lastname, postal code field is mandatory'), [:], 
//    FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.clearText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(1)

WebUI.click(findTestObject('Checkout/detail_information/button_continue'))

WebUI.verifyElementVisible(findTestObject('Checkout/detail_information/error icon x'))

WebUI.verifyElementVisible(findTestObject('Checkout/detail_information/warning error message is showing'))

WebUI.verifyElementText(findTestObject('Checkout/detail_information/warrning message wording'), 'Error: First Name is required')

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

