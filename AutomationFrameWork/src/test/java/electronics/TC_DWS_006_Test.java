package electronics;

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
public class TC_DWS_006_Test extends BaseClass {
	@Test
	public void clickOnElectronics() throws EncryptedDocumentException, IOException {

		hp = new HomePage(driver);
		hp.getElectronicsLink().click();
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("electronics", 1, 0),
				"Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is displayed");
	}
}
