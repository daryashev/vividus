Meta:
    @epic vividus-plugin-rest-api

Lifecycle:
Before:
Scope: STORY
Given I am on page with URL `https://google.com`

Scenario: Verify step Then I verify assertions matching '$assertionsPattern'
Then number of elements found by `By.xpath(//input[@*='q'])` is = `1`
Then the text 'Doctor Who?!' exists
Then I verify assertions matching '.*Doctor Who.*'
Then the text 'Extermina-a-a-a-a-te' exists
