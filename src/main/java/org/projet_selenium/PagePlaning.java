package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePlaning {
	
	@FindBy (xpath = "//div[@class='scheduler_default_cell'][1]")
	WebElement first_case;
	
	@FindBy (xpath = "//form")
	WebElement form_reservation;
	
	@FindBy (xpath = "//input[@id='name']")
	WebElement name_field;
	
	@FindBy (xpath = "//input[@value='Save']")
	WebElement btn_save;
	
	@FindBy (xpath = "//div[@class='scheduler_default_event_inner']")
	WebElement reservation;
	
	@FindBy(xpath = "//div[@class='scheduler_default_event scheduler_default_event_line0']")
	WebElement reservation_space1;
	
	@FindBy(xpath = "//div[@class='scheduler_default_cell scheduler_default_cell_business']")
	WebElement reservation_space2;
	
	@FindBy(xpath = "//div[@class='scheduler_default_message']")
	WebElement update_message;
	
	@FindBy(xpath = "//div[@class='scheduler_default_event_delete']")
	WebElement btn_delete;
	
	@FindBy(xpath = "//div[contains(.,'Deleted')]")
	WebElement delete_message;

}
