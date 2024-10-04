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

//WebUI.callTestCase(findTestCase('4-Add_to_Cart/1-verifyuser able to tap on add to cart on that item'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('MainMenu/List_content/div_Swag Labs'), 'Swag Labs')

WebUI.verifyElementText(findTestObject('MainMenu/your_cart/Your Cart_title'), 'Your Cart')

WebUI.verifyElementText(findTestObject('MainMenu/your_cart/QTY_title'), 'QTY')

WebUI.verifyElementText(findTestObject('MainMenu/your_cart/Description_title'), 'Description')

WebUI.verifyElementVisible(findTestObject('MainMenu/add_to_cart/a_1'))

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

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/cart_item_list'))

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/cart_quantity'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/Description_title'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/item_desc'))

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/item_pricebar'))

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/button_Remove'))

WebUI.verifyElementClickable(findTestObject('MainMenu/your_cart/button_Remove'))

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/button_Continue Shopping'))

WebUI.verifyElementClickable(findTestObject('MainMenu/your_cart/button_Continue Shopping'))

WebUI.verifyElementVisible(findTestObject('MainMenu/your_cart/button_Checkout'))

WebUI.verifyElementClickable(findTestObject('MainMenu/your_cart/button_Checkout'))

