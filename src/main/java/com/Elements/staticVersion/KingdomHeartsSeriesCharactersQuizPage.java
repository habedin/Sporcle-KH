package com.Elements.staticVersion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KingdomHeartsSeriesCharactersQuizPage {
	
	public static String url_kingdomHeartsSeriesCharactersQuiz = "https://www.sporcle.com/games/Leo/kingdom_hearts_series_characters";
	public static String title_kingdomHeartsSeriesCharactersQuiz = "Kingdom Hearts Series Characters Quiz";
	
	@FindBy(css = "div[id='button-play']")
	public static WebElement el_playQuizButton;
	
	@FindBy(css = "input[id='gameinput']")
	public static WebElement el_enterNameTextBox;
	
	@FindBy(css = "span[class='currentScore']")
	public static WebElement el_currentScore;

}
