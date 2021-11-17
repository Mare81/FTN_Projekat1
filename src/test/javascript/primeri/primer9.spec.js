describe('Angular selectors', function() {
  beforeAll(function() {
    // Post je ssluzba angular aplikacija, onda samo treba da odemo na sajt
    // browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('/');
    expect(browser.getCurrentUrl()).toEqual('http://localhost:8080/#/');
  });
  
  it('should read the correct version', function() {
    var version = element(by.binding('VERSION'));
    expect(version.getText()).toEqual('v0.0.1-SNAPSHOT');
  });
  
  it('should have the correct language options.', function() {
    // Click on language dropdown
    var languageDropdown = element(by.linkText('Language'));
    languageDropdown.click();
    
    var languages = element.all(by.repeater('language in languages'));
    expect(languages.count()).toEqual(2);
    
    var firstLanguage = languages.first();
    // ili languages.get(0)
    var secondLanguage = languages.last();2
    // ili languages.get(1)
    
    expect(firstLanguage.getText()).toEqual('English');
    expect(secondLanguage.getText()).toEqual('Français');
  });
});