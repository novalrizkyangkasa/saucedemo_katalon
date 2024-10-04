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

//WebUI.callTestCase(findTestCase('5-Checkout_items/7-verify user able to fill with correct value'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'check redirect URL'
actualURL = WebUI.getUrl()

KeywordUtil.logInfo(actualURL)

expectedURL = 'https://www.saucedemo.com/checkout-step-two.html'

boolean validateURL = WebUI.verifyEqual(actualURL, expectedURL, FailureHandling.STOP_ON_FAILURE)

if (validateURL) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Redirected user go to URL link is expected. ' + actualURL // Jika teks salah, cetak pesan error dengan teks yang ditemukan
        )
} else {
    KeywordUtil.logInfo('Redirected user go to URL link is NOT expected. The expected is : ' + actualURL)
}

WebUI.verifyElementText(findTestObject('MainMenu/List_content/div_Swag Labs'), 'Swag Labs')

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

WebUI.verifyElementText(findTestObject('Object Repository/Checkout/checkout_overview/title_header_checkout_overview'), 'Checkout: Overview')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/list_cart_element'))

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_overview/QTY_section'))

WebUI.verifyElementText(findTestObject('Checkout/checkout_overview/QTY_section'), 'QTY')

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_overview/description_section'))

WebUI.verifyElementText(findTestObject('Checkout/checkout_overview/description_section'), 'Description')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/desc_section'))

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_overview/pricebar_section'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/Payment Information_section'))

WebUI.verifyElementText(findTestObject('Checkout/checkout_overview/Payment Information_section'), 'Payment Information:')

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_overview/Shipping_Information_section'))

WebUI.verifyElementText(findTestObject('Checkout/checkout_overview/Shipping_Information_section'), 'Shipping Information:')

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/Courier_Delivery'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/Price Total'))

//WebUI.verifyElementText(findTestObject('Checkout/checkout_overview/Price Total'), 'Price Total')
WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/Item total'))

// Ambil semua elemen harga item
List<WebElement> itemPrices = WebUI.findWebElements(findTestObject('Object Repository/Checkout/checkout_overview/pricebar_section'), 
    10)

// Total harga item
double totalPrice = 0.0

// Loop untuk menghitung total harga item
for (WebElement priceElement : itemPrices) {
    // Ambil teks harga dan hilangkan simbol "$"
    String priceText = priceElement.getText().replaceAll('[^\\d.]', '').trim( // Menghapus semua kecuali angka dan titik
        )

    // Ubah harga menjadi angka dan tambahkan ke total
    double price = Double.parseDouble(priceText)

    totalPrice += price //+= adalah operator penambahan singkat. Ini sama dengan menulis totalPrice = totalPrice + price.

    KeywordUtil.logInfo(String.valueOf(price) // Konversi double ke string dan tampilkan dalam log
        )
}

// Ambil subtotal dari elemen subtotal
String subtotalText = WebUI.getText(findTestObject('Object Repository/Checkout/checkout_overview/Price Total')).replace(
    'Item total: $', '').trim()

// Ubah subtotal menjadi angka
double subtotal = Double.parseDouble(subtotalText)

// Bandingkan total harga item dengan subtotal
if (totalPrice == subtotal) {
    KeywordUtil.logInfo((('Total item sudah benar.' + totalPrice) + ', dari penjumlahan: ') + String.valueOf(subtotal))
} else {
    KeywordUtil.markFailedAndStop((('Total item tidak sesuai! Harga item: ' + totalPrice) + ', dari harga penjumlahan: ') + 
        String.valueOf(subtotal))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/Tax'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/button_Cancel'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Checkout/checkout_overview/button_Cancel'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout/checkout_overview/button_Finish'))

WebUI.verifyElementClickable(findTestObject('Checkout/checkout_overview/button_Finish'), FailureHandling.STOP_ON_FAILURE)

