package com.Steps;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Elements.nonStatic.HomePage;
import com.Elements.nonStatic.KingdomHeartsSearchPage;
import com.Elements.nonStatic.KingdomHeartsSeriesCharactersQuizPage;
import com.TestData.Characters;

public class Test_with_Testng {
	HomePage page1;
	KingdomHeartsSearchPage page2;
	KingdomHeartsSeriesCharactersQuizPage page3;
	
	@BeforeClass
	@Parameters ("browser")
	public void meth_goToSporcle(@Optional("firefox") String browser) {
		Base.meth_openBrowser(browser);
		page1 = new HomePage(Base.obj_driver);
		page2 = new KingdomHeartsSearchPage(Base.obj_driver);
		page3 = new KingdomHeartsSeriesCharactersQuizPage(Base.obj_driver);
		Base.meth_goToURL(page1.url_homePage);
		Base.meth_verifyURL(page1.url_homePage);
		Base.meth_verifyTitle(page1.title_homePage);
	}
	
	@Test
	public void meth_searchKingdomHearts() {		  
		  Base.meth_sendKeys(page1.el_searchBox, page2.var_searchTerm);
		  Base.meth_click(page1.el_searchButton);
		  Base.meth_verifyURL(page2.url_kingdomHeartsSearchPage);
		  Base.meth_verifyTitle(page2.title_kingdomHeartsSearchPage);
	}
	
	@Test (dependsOnMethods = "meth_searchKingdomHearts")
	public void meth_goToCharactersQuiz() {
		Base.meth_waitForElementToBeClickable(page2.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_click(page2.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_verifyURL(page3.url_kingdomHeartsSeriesCharactersQuiz);
		Base.meth_verifyTitle(page3.title_kingdomHeartsSeriesCharactersQuiz);
	}
	
	@Test (dependsOnMethods = "meth_goToCharactersQuiz")
	public void meth_takeQuiz() {
		Base.meth_click(page3.el_playQuizButton);
		while (!page3.el_currentScore.getText().equals("239/239")) {
			for (int i = 0; i < Characters.meth_listSize(); i++) {
				Base.meth_sendKeys(page3.el_enterNameTextBox, Characters.meth_character(i));
				Base.meth_clear(page3.el_enterNameTextBox);
			}
		}
	}
	
	@AfterClass
	public void meth_finishTest() throws InterruptedException {
		Thread.sleep(1000);
		Base.meth_quitBrowser();
	}

}