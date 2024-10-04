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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

//WebUI.callTestCase(findTestCase('3-Main_Menu/9-verify user able to see detail information on footer section'), [:], FailureHandling.STOP_ON_FAILURE)

// Definisikan XPath yang ingin digunakan
String xpathExpression = '//div[@data-test="inventory-list"]//div[@data-test="inventory-item"]'

// Buat TestObject secara dinamis menggunakan XPath
TestObject dynamicTestObject = new TestObject()

dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, xpathExpression)

// Gunakan WebUI.findWebElements() untuk mendapatkan list elemen berdasarkan XPath
List<WebElement> listitem = WebUI.findWebElements(dynamicTestObject, 10 // Timeout 10 detik
    )

KeywordUtil.logInfo('list yang terlihat:\n' + listitem.join('\n'))

// Definisikan urutan item yang ingin diklik (misal urutan ke-2 atau ke-3)
int urutanItem1 = 3 // Ubah sesuai dengan urutan yang diinginkan (dimulai dari 1)

int urutanItem2 = 4 // Ubah sesuai dengan urutan yang diinginkan (dimulai dari 1)

//Cek apakah ada elemen yang ditemukan - item ke 1
if (listitem.size() > 0) {
    WebUI.delay(2)

    WebElement item = listitem.get(urutanItem1 - 1)

    // Cetak teks item yang dipilih untuk verifikasi
    KeywordUtil.logInfo((('Item urutan ke-' + urutanItem1) + ': ') + item.getText())

    // Dapatkan teks dari item
    String item1Text = item.getText()

    // Simpan teks item1 ke dalam GlobalVariable
    GlobalVariable.item1Text = item1Text

    WebElement addToCartButton = item.findElement(By.xpath('.//button[contains(@data-test, \'add-to-cart\')]'))

    WebUI.delay(2)

    addToCartButton.click()

    // Log bahwa item telah berhasil diklik
    KeywordUtil.logInfo(('Tombol Add to Cart pada item urutan ke-' + urutanItem1) + ' berhasil diklik.')

    WebUI.delay(2)

    //Cek apakah ada elemen yang ditemukan - item ke 2
    if (listitem.size() > 0) {
        WebUI.delay(2)

        WebElement item2 = listitem.get(urutanItem2 - 1)

        // Cetak teks item yang dipilih untuk verifikasi
        KeywordUtil.logInfo((('Item urutan ke-' + urutanItem2) + ': ') + item2.getText())

        // Dapatkan teks dari item
        String item2Text = item2.getText()

        // Simpan teks item1 ke dalam GlobalVariable
        GlobalVariable.item2Text = item2Text

        WebElement addToCartButton2 = item2.findElement(By.xpath('.//button[contains(@data-test, \'add-to-cart\')]'))

        WebUI.delay(2)

        addToCartButton2.click()

        // Log bahwa item telah berhasil diklik
        KeywordUtil.logInfo(('Tombol Add to Cart pada item urutan ke-' + urutanItem2) + ' berhasil diklik.')
    } else {
        println('Tidak ada cukup elemen yang ditemukan. Jumlah item yang ditemukan: ' + listitem.size())
    }
    
    if (WebUI.verifyElementVisible(findTestObject('MainMenu/add_to_cart/span_1'))) {
        // Jika elemen terlihat, identifikasi dari elemen cartIcon (pastikan 'cartIcon' sudah didefinisikan)
        WebElement cartIcon = WebUI.findWebElement(findTestObject('MainMenu/add_to_cart/span_1'))

        // Melakukan tindakan yang diperlukan dengan cartIcon
        KeywordUtil.logInfo('Tombol badge keranjang belanja terlihat: ' + cartIcon.getText())

        // Simpan teks dari cartIcon ke dalam GlobalVariable
        GlobalVariable.totalitem = cartIcon.getText()
    } else {
        KeywordUtil.logInfo('Tombol badge keranjang belanja TIDAK terlihat.')
    }
} else {
    println('Tidak ada cukup elemen yang ditemukan. Jumlah item yang ditemukan: ' + listitem.size())
}

WebUI.delay(3)

WebUI.click(findTestObject('MainMenu/add_to_cart/a_1'))

WebUI.delay(3)

'check redirect URL'
actualURL = WebUI.getUrl()

KeywordUtil.logInfo(actualURL)

expectedURL = 'https://www.saucedemo.com/cart.html'

boolean validateURL = WebUI.verifyEqual(actualURL, expectedURL, FailureHandling.STOP_ON_FAILURE)

if (validateURL) {
    // Jika teks benar, cetak pesan dinamis dengan teks yang ditemukan
    KeywordUtil.logInfo('Redirected user go to URL link is expected. ' + actualURL // Jika teks salah, cetak pesan error dengan teks yang ditemukan
        )
} else {
    KeywordUtil.logInfo('Redirected user go to URL link is NOT expected. The expected is : ' + actualURL)
}

// Definisikan XPath yang ingin digunakan
'check on cart page'
String xpathExpression2 = '//*[@data-test="inventory-item" and @class="cart_item"]'

// Ambil totalitem dari GlobalVariable
String totalitemglobal = GlobalVariable.totalitem

KeywordUtil.logInfo('total item globalvariable: ' + totalitemglobal)

// Buat TestObject secara dinamis menggunakan XPath
TestObject dynamicTestObject2 = new TestObject()

dynamicTestObject2.addProperty('xpath', ConditionType.EQUALS, xpathExpression2)

// Gunakan WebUI.findWebElements() untuk mendapatkan list elemen berdasarkan XPath
List<WebElement> cartlist = WebUI.findWebElements(dynamicTestObject2, 10 // Timeout 10 detik
    )

// Cek apakah ada elemen yang ditemukan dalam cartlist
if (cartlist.size() > 0) {
    // Jika ada elemen di dalam cartlist
    KeywordUtil.logInfo(('Terdapat ' + cartlist.size()) + ' item di dalam keranjang belanja.') //	
    //	if(cartlist.contains(totalitemglobal)) {
    //		KeywordUtil.logInfo('Total Item cartlist sama dengan Jumlah di keranjang: ' + totalitemglobal)
    //		} else {
    //			KeywordUtil.logInfo('Teks cartlist tidak sama dengan item2.')
    //	}
    // Jika tidak ada elemen di dalam cartlist, gunakan FailureHandling untuk menghentikan eksekusi
} else {
    WebUI.verifyElementVisible(dynamicTestObject2, FailureHandling.STOP_ON_FAILURE)
}

