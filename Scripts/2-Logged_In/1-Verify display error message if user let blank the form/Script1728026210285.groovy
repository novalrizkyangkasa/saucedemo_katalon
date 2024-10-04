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

//WebUI.callTestCase(findTestCase('1-Landing_Page/2-verify on login form'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.verifyElementClickable(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.click(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

//WebUI.verifyElementVisible(findTestObject('Homepage/login_field/svg_Swag Labs_svg-inline--fa fa-times-circle fa-w-16 error_icon'))

WebUI.verifyElementVisible(findTestObject('Homepage/login_field/h3_Epic sadface Username is required'))

//8 - Actual Wording
actualmessage = WebUI.getText(findTestObject('Homepage/login_field/h3_Epic sadface Username is required'))

KeywordUtil.logInfo(actualmessage)

//9 - Expected Wording
expectedmessage = 'Epic sadface: Username is required'

//10
boolean validatemessage = WebUI.verifyMatch(actualmessage, expectedmessage, false, FailureHandling.CONTINUE_ON_FAILURE)

//11
if (validatemessage) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Warning Error Message already expected. ' + actualmessage) //12
    // Jika teks salah, cetak pesan error dengan teks yang ditemukan
} else {
    KeywordUtil.logInfo('Warning Error Message is not expected. The expected is : ' + actualmessage)
}

