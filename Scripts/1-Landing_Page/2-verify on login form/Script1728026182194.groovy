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

//WebUI.callTestCase(findTestCase('1-Landing_Page/1-verify title'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Homepage/Page_Swag Labs/input_Swag Labs_user-name'))

placeholderusername = WebUI.getAttribute(findTestObject('Homepage/Page_Swag Labs/input_Swag Labs_user-name'), 'placeholder')

WebUI.verifyEqual(placeholderusername, 'Username')

WebUI.verifyElementVisible(findTestObject('Homepage/Page_Swag Labs/input_Swag Labs_password'))

placeholderpassword = WebUI.getAttribute(findTestObject('Homepage/Page_Swag Labs/input_Swag Labs_password'), 'placeholder')

WebUI.verifyEqual(placeholderpassword, 'Password')

WebUI.verifyElementVisible(findTestObject('Homepage/Page_Swag Labs/div_Swag Labs_login_button_container'))

WebUI.verifyElementClickable(findTestObject('Homepage/Page_Swag Labs/div_Swag Labs_login_button_container'))

//10 (USERNAME SECTION)
username = WebUI.getText(findTestObject('Homepage/Page_Swag Labs/div_Accepted usernames arestandard_userlock_f87578'))

//11
listusername = username.replace('Accepted usernames are:', '').trim()

//12
listusername = listusername.split('\n')

//13
KeywordUtil.logInfo(listusername.join('\n'))

//14
expected = [findTestData('List_User/list_user').getValue('username', 1), findTestData('List_User/list_user').getValue('username', 
        2), findTestData('List_User/list_user').getValue('username', 3), findTestData('List_User/list_user').getValue('username', 
        4), findTestData('List_User/list_user').getValue('username', 5), findTestData('List_User/list_user').getValue('username', 
        6)]

//15
for (int i = 0; i < listusername.size(); i++) {
    WebUI.verifyEqual(listusername[i], expected[i])
}

//16 (PASSWORD SECTION)
password = WebUI.getText(findTestObject('Homepage/Page_Swag Labs/div_Password for all userssecret_sauce'))

//17
listpassword = password.replace('Password for all users:', '').trim()

//18
listpassword = listpassword.split('\n')

//19
KeywordUtil.logInfo(listpassword.join('\n'))

//20
expected = [findTestData('List_User/list_user').getValue('password', 1)]

//21
for (int i = 0; i < listpassword.size(); i++) {
    WebUI.verifyEqual(listpassword[i], expected[i])
}

