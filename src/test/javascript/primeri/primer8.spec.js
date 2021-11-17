describe('Multi locator', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://www.calculator.net/');
    expect(browser.getCurrentUrl()).toEqual('https://www.calculator.net/');
  });
  
  it('should locate all "a" tags.', function() {
    var links = element.all(by.tagName("a"));
    expect(links.count()).toEqual(63);
    // For every link
    links.each(function(link) {
      // Get link's text
      link.getText().then(function(text) {
        // Log the text
        console.log(text);
      });
    });
  });
});