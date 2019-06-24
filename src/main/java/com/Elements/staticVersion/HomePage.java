package com.Elements.staticVersion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	public static String url_homePage = "https://www.sporcle.com/";
	public static String title_homePage = "Sporcle – World’s Largest Trivia Quiz Website";
	
	@FindBy(css = "input[class='textfield']")
	public static WebElement el_searchBox;
	
	@FindBy(css = "span[id='searchIcon']")
	public static WebElement el_searchButton;

}