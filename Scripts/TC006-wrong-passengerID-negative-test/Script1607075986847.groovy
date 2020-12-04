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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.enuygun.com/')

WebUI.setText(findTestObject('WebUITests/HomePageFormArea/openOriginInput'), 'istanbul' //nereden alanina istabul
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/autoCompleteFirstOriginResult') //otomatik ilk onerilen secilir
    )

WebUI.setText(findTestObject('WebUITests/HomePageFormArea/openDestinationInput'), 'izmir' //nereye alanina izmir yazili
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/autoCompleteFirstDestinationResult') //otomatik ilk onerilen secilir
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/openDepartureDate') // gidis tarihi alanini acar 
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/selectDepartureDate') //gidis tarihi secme 17 aralik
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/oneWayCheckbox') //tek yon tikini kaldirir donus tarihi alani kendiliginden acilir 
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/selectReturnDate') //donus tarihi secme 24 aralik
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/directFlightCheckbox') //aktarmasiz secenegi
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/openPassengerCount') //yolcu sayisi bolumu acma
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/selectPassengerCount') //yolcu sayisi secme bu seneryoda iki yetiskin
    )

WebUI.click(findTestObject('WebUITests/HomePageFormArea/buttonFindTicket') //ucuz bilet bul butonuna tikla
    )

WebUI.click(findTestObject('WebUITests/FlightSelectionPage/selectFirstOfferForDepartureFlight') //gidis ucagi secimi ilk ucak
    )

WebUI.waitForElementPresent(findTestObject('WebUITests/FlightSelectionPage/selectFirstOfferForReturnFlight'), 3 //donus ucagi elementi beklenmesi
    )

WebUI.click(findTestObject('WebUITests/FlightSelectionPage/selectFirstOfferForReturnFlight') //donus ucagi secimi ilk ucak
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/ContactInfoArea/emailInput') //mail alanina tiklama 
    )

WebUI.setText(findTestObject('WebUITests/ReservationPage/ContactInfoArea/emailInput'), GlobalVariable.Email //mail alanina text ekleme
    )

TestObject telephone = findTestObject('WebUITests/ReservationPage/ContactInfoArea/phoneNumberInput')

enterOneByOne('348976400', telephone)

WebUI.setText(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerNameInput'), 'ismail')

WebUI.setText(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerSurnameInput'), 'kaya')

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthDay') // 1. yolcu dogum gunu bolmesi acma
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthDay20') // 1. yolcu dogum gunu secme 20. gun
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthMonth') // 1. yolcu dogum ayi bolmesi acma
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthMonth11') // 1. yolcu dogum ayi secme 11.ay
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/open1stPassengerBirthYear') // 1. yolcu dogum yili bolmesi acma 
    )

WebUI.click(findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/select1stPassengerBirthYear1997') // 1. yolcu dogum yili secme 1997
    )

TestObject ID = findTestObject('WebUITests/ReservationPage/PassengerInfoArea/1stPassenger/1stPassengerIDInput') // 1/ yolcu tc kimlik konumunun atanmasi

enterOneByOne('484300064', ID) // 1/ yolcu tc kimlik girilmesi eksik ve algoritmaya uygun degil

WebUI.click(findTestObject('WebUITests/ReservationPage/goToPaymentButton') // odemeye ilerle butonuna tiklanmasi
)

WebUI.verifyTextPresent('Lütfen yolcuya ait TC Kimlik Numarasını girin.', false) // uyarinin sayfanin herhangi bir yerinde olup olmadigini kotrol ediyoruz
 

WebUI.delay(3)
WebUI.closeBrowser()

