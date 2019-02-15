import geb.Page
import org.openqa.selenium.Keys
import org.openqa.selenium.By;

class GoogleSearchPage extends Page {

    static at = { title == "Google" }

    static content = {
        searchField { $(By.className("gLFyf")) }
		//searchButton(to: GoogleSearchResultsPage) { $("input[value='Google Search']") }
		searchButton(to: GoogleSearchResultsPage) { $(".aajZCb > div:nth-child(4) > center:nth-child(2) > input:nth-child(1)") }
				
	}
	
	void searchGoogle(String searchTerm) {
		searchField.value searchTerm
		searchField << Keys.chord(Keys.ENTER)
	}
}