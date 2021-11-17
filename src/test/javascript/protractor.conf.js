var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');
var SpecReporter = require('jasmine-spec-reporter');

exports.config = {
    seleniumServerJar: '../../../node_modules/protractor/selenium/selenium-server-standalone-2.47.1.jar',
    chromeDriver: '../../../chromedriver',
    allScriptsTimeout: 20000,

    specs: [
        // Primeri se mogu pokrenuti svi zajedno
        'primeri/primer1.spec.js',
        'primeri/primer2.spec.js',
        'primeri/primer3.spec.js',
        'primeri/primer4.spec.js',
        'primeri/primer5.spec.js',
        'primeri/primer6.spec.js',
        'primeri/primer7.spec.js',
        'primeri/primer8.spec.js',
        'primeri/primer9.spec.js',
        
        // Pokretati zasebno
        // 'e2e/specs/login.spec.js',
        // 'e2e/specs/login_with_page.spec.js'
    ],

    capabilities: {
        'browserName': 'chrome'
    },

    directConnect: true,

    baseUrl: 'http://localhost:8080/',

    framework: 'jasmine2',

    jasmineNodeOpts: {
        showColors: true,
        isVerbose: true,
        defaultTimeoutInterval: 60000,
        print: function() {}
    },

    onPrepare: function() {
        // Postavljamo prozor na fullscreen
        browser.driver.manage().window().maximize();
        
        // Registrujemo reportere
        jasmine.getEnv().addReporter(new Jasmine2HtmlReporter({
            savePath: "./target/reports/e2e/",
            takeScreenshots: true,
            takeScreenshotsOnlyOnFailures: true,
            fixedScreenshotName: true
        }));
        jasmine.getEnv().addReporter(new SpecReporter({
            displayStacktrace: 'all',
            displaySpecDuration: true, 
            displayFailuresSummary: false, 
            displayPendingSummary: false,  
        }));
    }
};
