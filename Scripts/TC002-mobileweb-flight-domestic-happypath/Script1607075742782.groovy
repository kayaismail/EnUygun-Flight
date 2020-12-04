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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration

void enterOneByOne(String value, TestObject location) {// degerleri tek tek girmemizi saglayacak fonksiyon
	//girilecek degeri ve konumunu parametre olarak alir
WebUI.click(location)

WebUI.sendKeys(location, Keys.chord(Keys.HOME))

for (int i = 0; i < value.length(); i++) {
String c = value.charAt(i)

println(c)

WebUI.sendKeys(location, c)
}
}

Map<String, String> mobileEmulation=new HashMap<>();
mobileEmulation.put("deviceName","Nexus 5"); 		// nexsus 5 telefonunda mobil web gorunumu 
RunConfiguration.setWebDriverPreferencesProperty("mobileEmulation",mobileEmulation);


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.enuygun.com/')

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/selectRoundTrip') //tek yon tikini kaldirir donus tarihi alani kendiliginden acilir
)
WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/openOriginInput') //mobilde oldugumuz icin nereden alanina tiklamamiz gerekiyor 
)

WebUI.setText(findTestObject('WebMobileTests/HomePageFormArea/openOriginInput'), 'istanbul' //nereden alanina istabul
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/autoCompleteFirstOriginResult') //otomatik ilk onerilen secilir
	)
WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/openDestinationInput') //mobilde oldugumuz icin nereye alanina tiklamamiz gerekiyor
)
WebUI.setText(findTestObject('WebMobileTests/HomePageFormArea/openDestinationInput'), 'izmir' //nereye alanina izmir yazilir
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/autoCompleteFirstDestinationResult') //otomatik ilk onerilen secilir
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/openDepartureDate') // gidis tarihi alanini acar
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/selectDepartureDate') //gidis tarihi secme 17 aralik
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/openReturnDate') // gidis tarihi alanini acar
)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/selectReturnDate') //donus tarihi secme 24 aralik
	)


WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/openPassengerCount') //yolcu sayisi bolumu acma
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/selectPassengerCount') //yolcu sayisi secme bu seneryoda iki yetiskin
	)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/okeyButtonInPassengerCount') // Tamam butonu
)

WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/directFlightCheckbox') //aktarmasiz secenegi
)


WebUI.click(findTestObject('WebMobileTests/HomePageFormArea/buttonFindTicket') //ucuz bilet bul butonuna tikla
	)

WebUI.click(findTestObject('WebMobileTests/FlightSelectionPage/selectFirstOfferForDepartureFlight') //gidis ucagi secimi ilk ucak
	)

WebUI.waitForElementPresent(findTestObject('WebMobileTests/FlightSelectionPage/selectFirstOfferForReturnFlight'), 3 //donus ucagi elementi beklenmesi
	)

WebUI.click(findTestObject('WebMobileTests/FlightSelectionPage/selectFirstOfferForReturnFlight') //donus ucagi secimi ilk ucak
	)
WebUI.scrollToElement(findTestObject('WebMobileTests/ReservationPage/ContactInfoArea/emailInput'), 3)


WebUI.setText(findTestObject('WebMobileTests/ReservationPage/ContactInfoArea/emailInput'), GlobalVariable.Email //mail alanina text ekleme
	)

TestObject telephone = findTestObject('WebMobileTests/ReservationPage/ContactInfoArea/phoneNumberInput')

enterOneByOne('555123400', telephone)

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerNameInput'), 'ismail')

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerSurnameInput'), 'kaya')

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthDay') // 1. yolcu dogum gunu bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthDay20') // 1. yolcu dogum gunu secme 20. gun
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthMonth') // 1. yolcu dogum ayi bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthMonth11') // 1. yolcu dogum ayi secme 11.ay
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthYear') // 1. yolcu dogum yili bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthYear1997') // 1. yolcu dogum yili secme 1997
	)

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerIDInput'), '48430376364')

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerGenderMan') // 1. yolcu cinsiyet
	)

TestObject hescode = findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerHesCodeInput')

WebUI.scrollToPosition(0, 250)

enterOneByOne('R9N1159117', hescode //1. yolcu hes kodunun tek tek girilmesi
	)

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/2ndPassengerNameInput'), 'zeynep')

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/2ndPassengerSurnameInput'), 'beyatli')

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/open2ndPassengerBirthDay') // 2. yolcu dogum gunu bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/select2ndPassengerBirthDay12') // 2. yolcu dogum gunu secme 12. gun
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/open2ndPassengerBirthMonth') // 2. yolcu dogum ayi bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/select2ndPassengerBirthMonth01') // 2. yolcu dogum ayi secme 1.ay
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/open2ndPassengerBirthYear') // 2. yolcu dogum yili bolmesi acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/select2ndPassengerBirthYear1999') // 2. yolcu dogum yili secme 1995
	)

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/2ndPassengerIDInput'), '48445375864')

WebUI.click(findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/select2ndPassengerGenderWoman') // 2. yolcu cinsiyet kadin
	)

TestObject hescode1 = findTestObject('WebMobileTests/ReservationPage/PassengerInfoArea/2ndPassenger/2ndPassengerHesCodeInput')

enterOneByOne('T7T9611318', hescode1 //2. yolcu hes kodunun tek tek girilmesi
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/selectAssurance') //Geri odeme guvencesi chackbox isaretlenmesi
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/InvoiceInfoArea/openInvoiceInfo') // fatura alanini acma
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/InvoiceInfoArea/selectInvoiceCountry') // fatura ulke secme Turkiye
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/InvoiceInfoArea/selectInvoiceCity') // fatura sehri secme istanbul
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/InvoiceInfoArea/selectInvoiceTown') // fatura ilcesi secme sariyer
	)

WebUI.setText(findTestObject('WebMobileTests/ReservationPage/InvoiceInfoArea/invoiceAddressInput'), 'Resitpasa mahallesi' // fatura adres detayi
	)

WebUI.click(findTestObject('WebMobileTests/ReservationPage/goToPaymentButton') // odemeye ilerle butonuna tiklanmasi
	)

WebUI.delay(10) //browser close calisadan odeme sayfasinin acildigi gozlemlemek icin gecikme
WebUI.closeBrowser()
