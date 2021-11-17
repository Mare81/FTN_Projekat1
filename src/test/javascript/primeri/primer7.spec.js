describe('Multiple select demo', function() {
  beforeAll(function() {
    // Ignorisemo sinhronizaciju sa Angularom jer testiramo sajt koji nije napisan u Angularu.
    // Ova linija se ne pise za prave Angular aplikacije.
    browser.ignoreSynchronization = true;
    // Odlazimo na sajt
    browser.get('https://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx');
    expect(browser.getCurrentUrl()).toEqual('https://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx');
  });
  
  it('should select three elements.', function() {
    element(by.id("ControlOptionsTopHolder_lbSelectionMode_B-1")).click();
    var option = element(by.id("ControlOptionsTopHolder_lbSelectionMode_DDD_L_LBI1T0"));
    
    // Eksplicitno čeka da pojavi element na prozoru.
    browser.wait(function() {
        return option.isDisplayed();
    }, 50000);
    option.click();
    
    browser.sleep(5000);
    // Perform Multiple Select
    builder = new browser.actions();
    select = element(by.id("ContentHolder_lbFeatures_LBT"));
    options = select.all(by.tagName("td"));
    expect(options.count()).toEqual(8);
    multipleSelect = builder.keyDown(protractor.Key.CONTROL).click(options.get(2)).click(options.get(4))
            .click(options.get(6));
    multipleSelect.perform();
    browser.sleep(4000);
  });
});