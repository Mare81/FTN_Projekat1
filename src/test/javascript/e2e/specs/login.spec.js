describe('Login page:', function() {
  beforeAll(function() {
    // Pre svega navigiramo na stranicu koju testiramo
    browser.navigate().to("localhost:8080/#/");
  });
  
  it('should successfully log in as "admin"', function() {
    accountMenu = element(by.id("account-menu"));
		accountMenu.click();
		var signIn = accountMenu.element(by.xpath("//a [@ui-sref=\"login\"]"));
		expect(signIn.isPresent()).toBe(true);
    expect(signIn.isDisplayed()).toBe(true);
		
		signIn.click(); //go to login page
    expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/login');
		var username = element(by.model("username"));
		var password = element(by.model("password"));
		var btnSignIn = element(by.buttonText('Sign in'));
		
		//check elements visibility
		expect(username.isPresent()).toBe(true);
    expect(username.isDisplayed()).toBe(true);
    expect(password.isPresent()).toBe(true);
    expect(password.isDisplayed()).toBe(true);
    expect(btnSignIn.isPresent()).toBe(true);
    expect(btnSignIn.isDisplayed()).toBe(true);
		
		//set username value
		username.clear(); //delete current value
		username.sendKeys("admin"); //send new value
		
		//set password value
		password.clear();
		password.sendKeys("admin");
		
		//click signin button
		btnSignIn.click();
		
		//get login message
		var message = element(by.binding('account.login')).getText();
		var expectedMessage = "You are logged in as user \"admin\".";
		//check login message
		expect(message).toEqual(expectedMessage);
  });
});