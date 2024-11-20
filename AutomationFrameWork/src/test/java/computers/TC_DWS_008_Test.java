package computers;

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
public class TC_DWS_008_Test extends BaseClass {
	@Test
	public void clickOnComputers() throws EncryptedDocumentException, IOException {

		hp = new HomePage(driver);
		hp.getComputerLink().click();
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("computers", 1, 0),
				"Computers page is not displayed");
		test.log(Status.PASS, "Computers page is displayed");
	}
}