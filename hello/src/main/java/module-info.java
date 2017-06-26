module jpms.demo.hello {
    requires jpms.demo.api;
    provides ro.fortsoft.jpms.demo.api.Greeting with ro.fortsoft.jpms.demo.hello.HelloGreeting;
}
