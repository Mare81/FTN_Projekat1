// Prazan konstruktor
// Posto je "element" globalna funkcija, ne moramo da prosledimo nista.
var LoginPage = function() {}

// Opis polja i metoda
LoginPage.prototype = Object.create({}, {
    
    // Username polje
    username: {
        get: function() {
            return element(by.model('username'));
        },
        set: function(value) {
            this.username.clear();
            this.username.sendKeys(value);
        }
    },
    
    // Password polje
    password: {
        get: function() {
            return element(by.model('password'));
        },
        set: function(value) {
            this.password.clear();
            this.password.sendKeys(value);
        }
    },
    
    // Sign in button
    signInBtn: {
        get: function() {
            return element(by.buttonText('Sign in'));
        }
    },
    
    // Metoda za prelazak na ovu stranicu
    navigateToPage: {
        value: function() {
            browser.get('http://localhost:8080/#/login');
        }
    },
    
    // Metoda za login
    login: {
        value: function(usernameString, passwordString) {
            this.username = usernameString;
            this.password = passwordString;
            this.signInBtn.click();
        }
    }
});

// Export klase
module.exports = LoginPage;
