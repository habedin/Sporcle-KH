package com.Elements.staticVersion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KingdomHeartsSearchPage {
	
	public static String url_kingdomHeartsSearchPage = "https://www.sporcle.com/search/quizzes/?p=1&s=kingdom+hearts";
	public static String title_kingdomHeartsSearchPage = "Sporcle Search for 'kingdom hearts'";
	
	public static String var_searchTerm = "kingdom hearts";
	
	@FindBy(xpath = "//a[contains(text(), 'Kingdom Hearts Series Characters')]")
	public static WebElement el_kingdomHeartsSeriesCharactersLink;

}
