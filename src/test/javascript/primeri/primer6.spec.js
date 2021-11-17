describe('Jquery demo', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://jqueryui.com/droppable/#default');
    expect(browser.getCurrentUrl()).toEqual('https://jqueryui.com/droppable/#default');
  });
  
  it('should drag and drop an element.', function() {
    var act = browser.actions();
    
    var iFrame = element(by.tagName("iframe"));
    // Promise to log the iFrame size
    iFrame.getSize().then(function(size) {
      console.log(size);
    });
    // Switch iframe
    browser.switchTo().frame(iFrame.getWebElement());
    browser.ignoreSynchronization = true;
    //select source element
    var From = element(by.id("draggable"));
    // Promise to log the element location
    From.getLocation().then(function(location) {
      console.log(location);
    });
    //select destination element
    var To = element(by.id("droppable"));
    // Promise to log the element location
    To.getLocation().then(function(location) {
      console.log(location);
    });
    browser.sleep(3000);
    //do drag and drop
    act.dragAndDrop(From, To).perform();
    browser.sleep(3000);
  });
});