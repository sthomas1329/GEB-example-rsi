import geb.spock.GebSpec
import org.openqa.selenium.Keys


class GoogleSearchSpec extends GebSpec {

    def "can search Google for string test"() {
        given:
        to GoogleSearchPage

        and:
		searchField << "test"
		
        when:
		searchField << Keys.chord(Keys.ENTER)
		//waitFor { searchButton.clickable }
		//searchButton.click()

        then:
        at GoogleSearchResultsPage
		
		and:
		waitFor { testResultLink.present }
		assert testResultLink.isDisplayed() == true 
    }
	
	def "can search Google for string bananas"() {
		given:
		to GoogleSearchPage

		and:
		searchField << "bananas"
		
		when:
		searchField << Keys.chord(Keys.ENTER)

		then:
		at GoogleSearchResultsPage
		
		and:
		waitFor { bananasResultLink.present }
		assert bananasResultLink.isDisplayed() == true
		
	}
	
	def "can search Google using Page Object Method"() {
		given:
		to GoogleSearchPage

		when:
		searchGoogle "test"

		then:
		at GoogleSearchResultsPage
		
		and:
		waitFor { testResultLink.present }
		assert testResultLink.isDisplayed() == true
		
	}
	
	
	
	def "can click on link for search result"() {
		given:
		to GoogleSearchPage
		
		and:
		searchGoogle "test"
		
		and:
		at GoogleSearchResultsPage
		
		when: 
		waitFor { testResultLink }
		testResultLink.click()
		
		then:
		currentUrl.contains "speedtest.net"
	}
}