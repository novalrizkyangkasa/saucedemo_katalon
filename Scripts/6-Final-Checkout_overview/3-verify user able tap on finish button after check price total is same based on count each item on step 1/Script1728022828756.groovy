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

//WebUI.callTestCase(findTestCase('6-Final-Checkout_overview/2-verify user able to see detail information on footer section'), 
//    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_overview/button_Finish'))

WebUI.click(findTestObject('Checkout/checkout_overview/button_Finish'))

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

