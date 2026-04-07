Feature: web form dropdown
	Scenario: User selects an option from the web form dropdown
		Given user is on the Selenium web form page
    	When user selects "Two" from the select dropdown
    	Then "Two" should be selected in the select dropdown
    	
    Scenario: User selects an option by index from the select dropdown
  		Given user is on the Selenium web form page
  		When user selects option at index 2 from the select dropdown
  		Then "Two" should be selected in the select dropdown
  	
  	Scenario: User enters value into the datalist
  		Given user is on the Selenium web form page
  		When user enters "New York" into the datalist
  		Then "New York" should be retrieved from the datalist
  		
  	Scenario: User enters text into the text input
  		Given user is on the Selenium web form page
  		When user enters "hello" into the text input
  		Then the text input value should be "hello"

	Scenario: User enters text into the textarea
  		Given user is on the Selenium web form page
  		When user enters the following text into the textarea:
   		 """
    	first line
    	second line
    	third line
   		 """
  		Then the textarea value should be:
   		 """
	    first line
	    second line
	    third line
	    """
	 
	 Scenario: User unselects the checked checkbox
	 	Given user is on the Selenium web form page
	 	When user unselects the "checked" checkbox
	 	Then the "checked" checkbox should not be selected
	 
	 Scenario: User selects the default checkbox
	 	Given user is on the Selenium web form page
	 	When user selects the "default" checkbox
	 	Then the "default" checkbox should be selected
	 
	 Scenario: User selects the default radio button
	 	Given user is on the Selenium web form page
	 	When user selects the "default" radio button
	 	Then the "default" radio button should be selected
	 	And the "checked" radio button should not be selected
	
	Scenario: User uploads a file
  		Given user is on the Selenium web form page
  		When user uploads a file
  		Then the uploaded file name should be shown
  	
  	Scenario: User selects a date in the date input field
  		Given user is on the Selenium web form page
  		When user selects a date "2026-04-10"
  		Then the displayed date should be shown as "2026-04-10"
  	
  	Scenario: User sets the color picker value
  		Given user is on the Selenium web form page
  		When user sets the color picker to "#ff0000"
  		Then the color picker value should be "#ff0000"
  	
  	Scenario: User sets the range picker value
  		Given user is on the Selenium web form page
  		When user sets the range value to "4"
  		Then the range value should be "4"
  	
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
	 