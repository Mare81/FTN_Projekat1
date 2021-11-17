describe('Interest Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://www.calculator.net/interest-calculator.html');
    expect(browser.getCurrentUrl()).toEqual('https://www.calculator.net/interest-calculator.html');
  });
  
  it('should select the "continuously" option from a dropdown.', function() {
    browser.sleep(3000);
    // Click on Checkbox Button
    // Clicking the required item
    element(by.cssContainingText('#ccompound option', 'continuously')).click();
    
    browser.sleep(3000);
    expect(element(by.css('#ccompound option:checked')).getText()).toBe('continuously');
    // ili 
    expect(element(by.cssContainingText('#ccompound option', 'continuously')).isSelected()).toBe(true);
    expect(element(by.id("ccompound")).isEnabled()).toBe(true);
    expect(element(by.id("ccompound")).isPresent()).toBe(true);
	expect(element(by.id("ccompound")).isDisplayed()).toBe(true);
  });
});