// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var HomePage = function() {}

// Opis polja i metoda
HomePage.prototype = Object.create({}, {
    
    // Login Confirmation text
    loginConfirmationText: {
        get: function() {
            return element(by.binding('account.login')).getText();
        }
    }
});

// Export klase
module.exports = HomePage;