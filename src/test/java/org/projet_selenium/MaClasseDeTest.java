package org.projet_selenium;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MaClasseDeTest {
	
	WebDriver driver;
	String title = "HTML5 Hotel Room Booking";
	String name = "Resa 1";
	long pause = 7000;
	
	@Before
	public void setUp() throws Exception {
		driver = OutilsTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//nettoyage BDD
		BddOutils.deleteAllData("src\\test\\resources\\delete.xml");
		//JDD insert resa 1er jour
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		
		//JDD nettoyage
		BddOutils.deleteAllData("src\\test\\resources\\delete.xml");
		
	}
	
	@Test
	public void excercice() throws SQLException, Exception {
		
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		PagePlaning page_Planing = PageFactory.initElements(driver, PagePlaning.class);
		
		assertTrue(driver.getTitle().contains(title));
		
		page_Planing.first_case.click();
		
		driver.switchTo().frame(0);
		
		assertTrue(page_Planing.form_reservation.isDisplayed());
		
		OutilsTechnique.remplirChamp(page_Planing.name_field, name);
		
		page_Planing.btn_save.click();
		
		driver.switchTo().defaultContent();
		
		BddOutils.compareData("reservations", "src\\test\\resources\\reservationroom1.xml", "id");
		
		assertTrue(page_Planing.reservation.getText().contains(name));
		
		Actions a = new Actions(driver);
		a.clickAndHold(page_Planing.reservation_space1).moveToElement(page_Planing.reservation_space2).release().build().perform();
		
		assertTrue("Le message d'update n'est pas apparu",page_Planing.update_message.isDisplayed());
		
		Thread.sleep(pause);
		
		assertFalse("Le message est toujours la",page_Planing.update_message.isDisplayed());
		
		//compare JDD
		
		a.moveToElement(page_Planing.reservation_space1).build().perform();
		a.moveToElement(page_Planing.btn_delete).click().build().perform();
		
		assertTrue("Le message de delete n'est pas apparu",page_Planing.delete_message.isDisplayed());
		
		Thread.sleep(pause);
		
		assertFalse("Le message de delete n'a pas disparu",page_Planing.delete_message.isDisplayed());
		
		//compare JDD resa 1
	
	}

}
