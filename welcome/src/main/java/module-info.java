module jpms.demo.welcome {
    requires jpms.demo.api;
    exports ro.fortsoft.jpms.demo.welcome;
    provides ro.fortsoft.jpms.demo.api.Greeting with ro.fortsoft.jpms.demo.welcome.WelcomeGreeting;
}