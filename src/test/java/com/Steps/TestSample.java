package com.Steps;

import org.openqa.selenium.support.PageFactory;

import com.Base.Base;
import com.Elements.staticVersion.HomePage;
import com.Elements.staticVersion.KingdomHeartsSearchPage;
import com.Elements.staticVersion.KingdomHeartsSeriesCharactersQuizPage;
import com.TestData.Characters;

public class TestSample {

	public static void main(String[] args) {

		// Open browser, go to URL, verify URL and title.
		Base.meth_openBrowser("chrome");
		Base.meth_goToURL(HomePage.url_homePage);
		Base.meth_verifyURL(HomePage.url_homePage);
		Base.meth_verifyTitle(HomePage.title_homePage);
		
		// Initialize HomePage elements, search 'kingdom hearts', verify URL and title.
		PageFactory.initElements(Base.obj_driver, HomePage.class);
		Base.meth_sendKeys(HomePage.el_searchBox, KingdomHeartsSearchPage.var_searchTerm);
		Base.meth_click(HomePage.el_searchButton);
		Base.meth_verifyURL(KingdomHeartsSearchPage.url_kingdomHeartsSearchPage);
		Base.meth_verifyTitle(KingdomHeartsSearchPage.title_kingdomHeartsSearchPage);
		
		// Initialize KingdomHeartsSearchPage elements, click on 'Kingdom Hearts Series Characters', verify URL and title.
		PageFactory.initElements(Base.obj_driver, KingdomHeartsSearchPage.class);
		Base.meth_waitForElementToBeClickable(KingdomHeartsSearchPage.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_click(KingdomHeartsSearchPage.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_verifyURL(KingdomHeartsSeriesCharactersQuizPage.url_kingdomHeartsSeriesCharactersQuiz);
		Base.meth_verifyTitle(KingdomHeartsSeriesCharactersQuizPage.title_kingdomHeartsSeriesCharactersQuiz);
		
		// Initialize KingdomHeartsSeriesCharactersQuizPage elements, click on 'Play Quiz', click text box, enter characters.
		PageFactory.initElements(Base.obj_driver, KingdomHeartsSeriesCharactersQuizPage.class);
		Base.meth_click(KingdomHeartsSeriesCharactersQuizPage.el_playQuizButton);
		while (!KingdomHeartsSeriesCharactersQuizPage.el_currentScore.getText().equals("239/239")) {
			for (int i = 0; i < Characters.meth_listSize(); i++) {
				Base.meth_sendKeys(KingdomHeartsSeriesCharactersQuizPage.el_enterNameTextBox, Characters.meth_character(i));
				Base.meth_clear(KingdomHeartsSeriesCharactersQuizPage.el_enterNameTextBox);
			}
		}
		
		// Close browser.
		Base.meth_quitBrowser();

	}

}
