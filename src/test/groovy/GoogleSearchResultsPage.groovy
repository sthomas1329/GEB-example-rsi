import geb.Page
import org.openqa.selenium.By;

class GoogleSearchResultsPage extends Page {

	static at = { title.contains("Google Search") }
	
	static content = {
		testResultLink { $(By.partialLinkText("Speedtest by Ookla")) }
		bananasResultLink { $(By.partialLinkText("11 Evidence-Based Health Benefits of Bananas")) }
	}	
}
