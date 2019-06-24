package com.Steps;

import com.Base.Base;
import com.Elements.nonStatic.HomePage;
import com.Elements.nonStatic.KingdomHeartsSearchPage;
import com.Elements.nonStatic.KingdomHeartsSeriesCharactersQuizPage;
import com.TestData.Characters;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_with_Cucumber {
	HomePage page1;
	KingdomHeartsSearchPage page2;
	KingdomHeartsSeriesCharactersQuizPage page3;

	@Given("^I open \"([^\"]*)\" and navigate to Sporcle website$")
	public void i_open_and_navigate_to_Sporcle_website(String browser) {
		Base.meth_openBrowser(browser);
		page1 = new HomePage(Base.obj_driver);
		page2 = new KingdomHeartsSearchPage(Base.obj_driver);
		page3 = new KingdomHeartsSeriesCharactersQuizPage(Base.obj_driver);
		Base.meth_goToURL(page1.url_homePage);
		Base.meth_verifyURL(page1.url_homePage);
		Base.meth_verifyTitle(page1.title_homePage);
	}

	@When("^I enter search term and click on the characters quiz$")
	public void i_enter_search_term_and_click_on_the_characters_quiz() {
		Base.meth_sendKeys(page1.el_searchBox, page2.var_searchTerm);
		Base.meth_click(page1.el_searchButton);
		Base.meth_verifyURL(page2.url_kingdomHeartsSearchPage);
		Base.meth_verifyTitle(page2.title_kingdomHeartsSearchPage);
		Base.meth_waitForElementToBeClickable(page2.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_click(page2.el_kingdomHeartsSeriesCharactersLink);
		Base.meth_verifyURL(page3.url_kingdomHeartsSeriesCharactersQuiz);
		Base.meth_verifyTitle(page3.title_kingdomHeartsSeriesCharactersQuiz);
	}

	@When("^I enter the characters from my test data$")
	public void i_enter_the_characters_from_my_test_data() {
		Base.meth_click(page3.el_playQuizButton);
		while (!page3.el_currentScore.getText().equals("239/239")) {
			for (int i = 0; i < Characters.meth_listSize(); i++) {
				Base.meth_sendKeys(page3.el_enterNameTextBox, Characters.meth_character(i));
				Base.meth_clear(page3.el_enterNameTextBox);
			}
		}
	}

	@Then("^I will finish the quiz and the browser will close$")
	public void i_will_finish_the_quiz_and_the_browser_will_close() {
		Base.meth_quitBrowser();
	}

}
