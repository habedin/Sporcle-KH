package com.Elements.nonStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KingdomHeartsSearchPage {
	WebDriver obj_driver;
	
	public KingdomHeartsSearchPage(WebDriver param_driver) { 
		obj_driver = param_driver;
		PageFactory.initElements(param_driver, this); 
	}
	
	public String url_kingdomHeartsSearchPage = "https://www.sporcle.com/search/quizzes/?p=1&s=kingdom+hearts";
	public String title_kingdomHeartsSearchPage = "Sporcle Search for 'kingdom hearts'";
	
	public String var_searchTerm = "kingdom hearts";
	
	@FindBy(xpath = "//a[contains(text(), 'Kingdom Hearts Series Characters')]")
	public WebElement el_kingdomHeartsSeriesCharactersLink;

}
