package com.Elements.nonStatic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KingdomHeartsSeriesCharactersQuizPage {
	WebDriver obj_driver;

	public KingdomHeartsSeriesCharactersQuizPage(WebDriver param_driver) {
		obj_driver = param_driver;
		PageFactory.initElements(param_driver, this);
	}

	public String url_kingdomHeartsSeriesCharactersQuiz = "https://www.sporcle.com/games/Leo/kingdom_hearts_series_characters";
	public String title_kingdomHeartsSeriesCharactersQuiz = "Kingdom Hearts Series Characters Quiz";

	@FindBy(css = "div[id='button-play']")
	public WebElement el_playQuizButton;

	@FindBy(css = "input[id='gameinput']")
	public WebElement el_enterNameTextBox;

	@FindBy(css = "span[class='currentScore']")
	public WebElement el_currentScore;

}
