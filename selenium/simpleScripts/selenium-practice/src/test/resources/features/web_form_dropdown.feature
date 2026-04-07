Feature: web form dropdown

  	
  	Scenario: User enters text into the password field
  		Given user is on the Selenium web form page
  		When user enters "secret123" into the password field
  		Then the password field value should be "secret123"

	Scenario: Disabled input should not be enabled
	  	Given user is on the Selenium web form page
	  	Then the disabled input should not be enabled

	Scenario: Readonly input should be readonly
  		Given user is on the Selenium web form page
  		Then the readonly input should be readonly

	Scenario: User submits the web form
  		Given user is on the Selenium web form page
  		When user clicks the submit button
  		Then the form should be submitted
	 