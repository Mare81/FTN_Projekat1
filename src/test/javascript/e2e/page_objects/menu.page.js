// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var MenuPage = function() {};

// Opis polja i metoda
MenuPage.prototype = Object.create({}, {
    
    // AccountMenu dropdown
    accountMenu: {
        get: function() {
            return element(by.id('account-menu'));
        }
    },
    
    // Sign up button
    signIn: {
        get: function() {
            return element(by.xpath('//a [@ui-sref="login"]'));
        }
    },
    
    // Log out button
    logOut: {
        get: function() {
            return element(by.id('logout'));
        }
    }
});

// Export klase
module.exports = MenuPage;