describe('Percentage Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://www.calculator.net/percent-calculator.html');
    expect(browser.getCurrentUrl()).toEqual('https://www.calculator.net/percent-calculator.html');
  });
  
  it('should correctly set the first value to 10.', function() {
    // Enter value 10 in the first number of the percent Calculator
    element(by.id("cpar1")).sendKeys("10");
    browser.sleep(5000);
    // Get the text box from the application
    var result = element(by.id("cpar1")).getAttribute("value");
    // Verify result
    expect(result).toEqual('10');
  });
});