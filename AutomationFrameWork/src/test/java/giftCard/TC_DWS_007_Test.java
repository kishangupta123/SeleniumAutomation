package giftCard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenersUtility;
import objectrepository.HomePage;

@Listeners(ListenersUtility.class)
public class TC_DWS_007_Test extends BaseClass {
	@Test
	public void clickOnGiftCard() throws EncryptedDocumentException, IOException {
		hp = new HomePage(driver);
		hp.getGiftCardsLink().click();
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("gifts", 1, 0),
				"Gift Cards page is not displayed");
		test.log(Status.PASS, "Gift Cards page is displayed");
	}
}
