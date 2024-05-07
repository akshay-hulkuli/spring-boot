package com.akshay.springbootrestfulwebservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    /*
        When we say @Controller we are more focused into MVC.
        The controller is expected to return VIEW / JSP.
        But when we say @RestController we are dealing with Json data mostly.
        To return string data we need to explicitly specify @RequestBody in case of @Controller
     */

    /*
        Spring Boot has 2 important features 1. starter project and Auto configuration.
        Starter project spring-boot-starter-web provides Spring-MVC, tomcat, Jackson for JSON conversion etc.
        Auto-configuration by checking what are the classes available auto-configures things.
        It configures DispatcherServlet, @RequestBody, required json converter, Error Mapping (error page), tomcat server etc.
     */

    @Autowired
    private MessageSource messageSource;


    //@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello-world");
    }

    // Path parameters
    @GetMapping("hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

    @GetMapping("/hello-world-internationalization")
    public String helloWorldInternationalization() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }
}
