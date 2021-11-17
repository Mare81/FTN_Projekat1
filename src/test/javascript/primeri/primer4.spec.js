describe('Mortgage Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://www.calculator.net/mortgage-calculator.html');
    expect(browser.getCurrentUrl()).toEqual('https://www.calculator.net/mortgage-calculator.html');
  });
  
  it('should check a checkbox button.', function() {
    browser.sleep(4000);
    // Click on Checkbox Button
    element(by.id("caddoptional")).click();
    expect(element(by.id("caddoptional")).isSelected()).toBe(false);
    expect(element(by.id("caddoptional")).isEnabled()).toBe(true);
    expect(element(by.id("caddoptional")).isPresent()).toBe(true);
    expect(element(by.id("caddoptional")).isDisplayed()).toBe(false);
    
    browser.sleep(4000);
  });
});