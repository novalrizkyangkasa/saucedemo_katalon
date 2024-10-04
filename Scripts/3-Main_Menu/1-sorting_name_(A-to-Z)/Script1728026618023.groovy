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

//WebUI.callTestCase(findTestCase('2-Logged_In/7-Verify user able to successfully logged in'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/MainMenu/Sorting/span_Price (low to high)Name (A to Z)Name (_2206a4'))

WebUI.selectOptionByValue(findTestObject('Object Repository/MainMenu/Sorting/select_Name (A to Z)Name (Z to A)Price (low_f7e90a'), 
    'az', true)

// Definisikan XPath yang ingin digunakan
String xpathExpression = '//div[@id="inventory_container"]//div[@data-test="inventory-item-name"]'

// Buat TestObject secara dinamis menggunakan XPath
TestObject dynamicTestObject = new TestObject()

dynamicTestObject.addProperty('xpath', ConditionType.EQUALS, xpathExpression)

// Gunakan WebUI.findWebElements() untuk mendapatkan list elemen berdasarkan XPath
List<WebElement> productElements = WebUI.findWebElements(dynamicTestObject, 10 // Timeout 10 detik
    )

// Buat list untuk menyimpan nama-nama produk
List<WebElement> productNames = new ArrayList()

// Cek apakah ada setidaknya 6 produk
int maxProductsToCheck = Math.min(6, productElements.size())

// Jika ada 6 produk, lanjutkan pengecekan
if (productElements.size() == 6) {
    println('Ada cukup produk, melanjutkan sampling pengecekan 6 produk pertama.')

    // Loop untuk mengecek hingga 6 produk saja
    for (int i = 0; i < maxProductsToCheck; i++) {
        WebElement element = productElements.get(i)

        String productName = element.getText()

        productNames.add(productName + '\n')
    }
    
    // Cetak list nama produk yang diambil dari halaman untuk verifikasi
    KeywordUtil.logInfo('Nama produk yang diambil:\n' + productNames.join('\n')) // Jika kurang dari 6 elemen, cetak pesan dan hentikan eksekusi
} else {
    println('Jumlah produk kurang dari 6, tidak bisa melanjutkan pengecekan.')
}

// Buat salinan list dan urutkan secara ascending (A ke Z)
List<WebElement> sortedProductNames = new ArrayList(productNames)

sortedProductNames.sort()

// Cetak list nama produk yang diurutkan untuk verifikasi
KeywordUtil.logInfo('Nama produk yang diurutkan (A ke Z):\n' + sortedProductNames.join('\n'))

// Verifikasi apakah list asli sesuai dengan list yang diurutkan
boolean isSorted = productNames.equals(sortedProductNames)

if (isSorted) {
    println('Produk sudah diurutkan dari A ke Z.')
} else {
    println('Produk TIDAK diurutkan dari A ke Z.')
}

