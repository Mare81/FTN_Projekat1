var LoginPage = require('../page_objects/login.page.js');
var MenuPage = require('../page_objects/menu.page.js');
var HomePage = require('../page_objects/home.page.js');

describe('Login page:', function() {
  var loginPage;
  var menuPage;
  var homePage;
    
  beforeAll(function() {
    // Pre svega navigiramo na stranicu koju testiramo
    browser.navigate().to("localhost:8080/#/");
    loginPage = new LoginPage();
    menuPage = new MenuPage();
    homePage = new HomePage();
  });
  
  it('should successfully log in as "admin"', function() {
    // klik na account menu dropdown.
    menuPage.accountMenu.click();
    
    expect(menuPage.signIn.isPresent()).toBe(true);
    expect(menuPage.signIn.isDisplayed()).toBe(true);
		
    menuPage.signIn.click(); //go to login page
    expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/login');
    
    //check elements visibility
    expect(loginPage.username.isPresent()).toBe(true);
    expect(loginPage.username.isDisplayed()).toBe(true);
    expect(loginPage.password.isPresent()).toBe(true);
    expect(loginPage.password.isDisplayed()).toBe(true);
    expect(loginPage.signInBtn.isPresent()).toBe(true);
    expect(loginPage.signInBtn.isDisplayed()).toBe(true);
		
    // //set username value
    loginPage.username = 'admin';
    
    // //set password value
    loginPage.password = 'admin';
    
    // ili jednostavno loginPage.login('admin', 'admin')
    
    //click signin button
    loginPage.signInBtn.click();
    
    var expectedMessage = "You are logged in as user \"admin\".";
    // //check login message
    expect(homePage.loginConfirmationText).toEqual(expectedMessage);
  });
});
