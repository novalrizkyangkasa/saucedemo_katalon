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

//WebUI.callTestCase(findTestCase('2-Logged_In/5-Verify display error message if user fill with incorrect value on Username field'), 
//    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_user-name'))
WebUI.clearText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_password'))

WebUI.delay(1)

WebUI.refresh()

WebUI.verifyElementVisible(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.verifyElementClickable(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.setText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_user-name'), 'standard_test')

valueuser = WebUI.getAttribute(findTestObject('Homepage/login_field/input_Swag Labs_user-name'), 'value')

KeywordUtil.logInfo(valueuser)

WebUI.verifyEqual(valueuser, 'standard_test', FailureHandling.STOP_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_password'), 'NSA6IISBn+B+Vz8v9fu4Zw==')

WebUI.click(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_login-button'))

//WebUI.verifyElementVisible(findTestObject('Homepage/login_field/svg_Swag Labs_svg-inline--fa fa-times-circle fa-w-16 error_icon'))

WebUI.verifyElementVisible(findTestObject('Homepage/login_field/h3_Epic sadface Username and password do no_0e8909'))

actualmessage = WebUI.getText(findTestObject('Homepage/login_field/h3_Epic sadface Username and password do no_0e8909'))

KeywordUtil.logInfo(actualmessage)

expectedmessage = 'Epic sadface: Username and password do not match any user in this service'

boolean validatemessage = WebUI.verifyMatch(actualmessage, expectedmessage, false, FailureHandling.CONTINUE_ON_FAILURE)

if (validatemessage) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Warning Error Message already expected. ' + actualmessage //12
        // Jika teks salah, cetak pesan error dengan teks yang ditemukan
        )
} else {
    KeywordUtil.logInfo('Warning Error Message is not expected. The expected is : ' + actualmessage)
}

