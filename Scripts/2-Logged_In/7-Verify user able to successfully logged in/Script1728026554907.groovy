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

//WebUI.callTestCase(findTestCase('2-Logged_In/6-Verify display error message if user fill with incorrect value on Password field'), 
//    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_user-name'))

WebUI.clearText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_password'))

WebUI.delay(1)

WebUI.refresh()

WebUI.verifyElementVisible(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.verifyElementClickable(findTestObject('Homepage/login_field/input_Swag Labs_login-button'))

WebUI.setText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_user-name'), 'standard_user')

valueuser = WebUI.getAttribute(findTestObject('Homepage/login_field/input_Swag Labs_user-name'), 'value')

KeywordUtil.logInfo(valueuser)

WebUI.verifyEqual(valueuser, 'standard_user', FailureHandling.STOP_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.click(findTestObject('Object Repository/Homepage/login_field/input_Swag Labs_login-button'))

WebUI.delay(2)

// Jalankan JavaScript untuk memperbarui cookie session-username
String cookieUpdateResult = WebUI.executeJavaScript(((((((((((('' + 'var cookieString = document.cookie;') + 'if(cookieString && cookieString.includes("session-username=")) {') + 
    'var cookieValue = cookieString.split("; ").find(row => row.startsWith("session-username=")).split("=")[1];') + // Tentukan waktu kedaluwarsa baru
    'var date = new Date();') + 'date.setTime(date.getTime() + (1 * 24 * 60 * 60 * 1000));') + // 7 hari
    'document.cookie = "session-username=" + cookieValue + "; expires=" + date.toUTCString() + "; path=/";') + // Log perubahan cookie ke konsol
    'console.log("Cookie updated to: session-username=" + cookieValue + "; expires=" + date.toUTCString());') + 'return "Cookie updated to: session-username=" + cookieValue + "; expires=" + date.toUTCString();') + 
    '} else {') + // Jika cookie session-username tidak ditemukan
    'console.log("No session-username cookie found.");') + 'return "No session-username cookie found."; ') + '}', null)

// Tampilkan hasil log ke dalam Katalon console log
WebUI.comment(cookieUpdateResult)

actualURL = WebUI.getUrl()

KeywordUtil.logInfo(actualURL)

expectedURL = 'https://www.saucedemo.com/inventory.html'

boolean validateURL = WebUI.verifyEqual(actualURL, expectedURL, FailureHandling.STOP_ON_FAILURE)

if (validateURL) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Redirected user go to URL link is expected. ' + actualURL // Jika teks salah, cetak pesan error dengan teks yang ditemukan
        )
} else {
    KeywordUtil.logInfo('Redirected user go to URL link is NOT expected. The expected is : ' + actualURL)
}

