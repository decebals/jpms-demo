module jpms.demo.app {
    requires jpms.demo.api;
    uses ro.fortsoft.jpms.demo.api.Greeting;
    provides ro.fortsoft.jpms.demo.api.Greeting with ro.fortsoft.jpms.demo.WhazzupGreeting, ro.fortsoft.jpms.demo.HowdyGreeting;
}