package com.akshay.springbootfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>")
                .append("<head><title>Hello World!</title></head>")
                .append("<body><h1>my first page</h1></body>")
                .append("</html>");
        return sb.toString();
    }

    /*
        In order to build UI/HTML we need something known as views.
        These views are build using JSPs - Jakartha server pages.
        JSPs must be kept in the path - /src/main/resources/META-INF/resources/WEB-INF/jsp/
     */

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "hello";
    }
}
