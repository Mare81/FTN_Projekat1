describe('Percentage Calculator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://www.calculator.net/');
    expect(browser.getCurrentUrl()).toEqual('https://www.calculator.net/');
  });
  
  it('should correctly calculate 10% of 50.', function() {
    // Click on Percent Calculators
    element(by.xpath(".//*[@id=\"hl3\"]/li[3]/a")).click();
    // Enter value 10 in the first number of the percent Calculator
    element(by.id("cpar1")).sendKeys("10");
    // Enter value 50 in the second number of the percent Calculator
    element(by.id("cpar2")).sendKeys("50");
    // Click Calculate Button
    element(by.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();
    // Get the Result Text based on its xpath
    var result = element(by.css("#content > p.verybigtext > font > b")).getText();
    // Verify result
    expect(result).toEqual('5');
  });
});