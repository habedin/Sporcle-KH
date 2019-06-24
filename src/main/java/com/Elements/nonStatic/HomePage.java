package com.Elements.nonStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver obj_driver;
	
	public HomePage(WebDriver param_driver) { 
		obj_driver = param_driver;
		PageFactory.initElements(param_driver, this); 
	}
	
	public String url_homePage = "https://www.sporcle.com/";
	public String title_homePage = "Sporcle – World’s Largest Trivia Quiz Website";
	
	@FindBy(css = "input[class='textfield']")
	public WebElement el_searchBox;
	
	@FindBy(css = "span[id='searchIcon']")
	public WebElement el_searchButton;

}