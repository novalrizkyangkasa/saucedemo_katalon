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

//WebUI.callTestCase(findTestCase('5-Checkout_items/4-verify system can identify if information buyer is not filled (blank all)'), 
//    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.refresh()

WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'))

WebUI.setText(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_firstName'), '123456')

WebUI.delay(2)

WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_lastName'))

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_lastName'), 
    'test')

WebUI.delay(2)

WebUI.click(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.delay(2)

WebUI.focus(findTestObject('Checkout/verify mandatory field/input_Checkout Your Information_postalCode'))

WebUI.setText(findTestObject('Object Repository/Checkout/verify mandatory field/input_Checkout Your Information_postalCode'), 
    '6131')

WebUI.click(findTestObject('Object Repository/Checkout/verify mandatory field/input_Cancel_continue'))

WebUI.delay(2)

// Dapatkan URL saat ini
String currentUrl = WebUI.getUrl()

// URL yang diharapkan
String expectedUrl = 'https://www.saucedemo.com/checkout-step-one.html'

WebUI.delay(1)

// Cek apakah URL saat ini sesuai dengan yang diharapkan
if (!(currentUrl.equals(expectedUrl))) {
    // Jika URL tidak sesuai, hentikan test case dan tampilkan pesan error
    WebUI.comment('Error with note: Inputan form sebelumnya pada firstname tidak sesuai format.')

//    WebUI.closeBrowser() // Hentikan test case dengan menutup browser
} else {
    WebUI.comment('Form Inputan telah diisi dengan benar, melanjutkan testcase.')
}

