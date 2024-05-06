package com.akshay.springbootfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

//    @Autowired
//    AuthenticationService authenticationService;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
      Dispatcher Servlet is a frontController of the Spring MVC.
      MVC - Model View Controller.
        1. Model - Carrier of the data
        2. View - Actual JSPs with markup/UI
        3. Controller - Which processor https requests, prepares model and selects correct view.

      * Dispatcher Servlet
      * Receives http request.
      * Identifies the correct controller.
      * Executes the controller.
      * Controller return model and view name.
      * Selects correct view using the View resolver.
      * Returns processed message view http response
     */

//    @Deprecated
//    @RequestMapping("/login-old")
//    public String goToLoginPageOld(@RequestParam(name = "name") String name, ModelMap modelMap) {
//        modelMap.addAttribute("name", name);
//        logger.info("Request Param is : {}", name);
//        return "loginOld";
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String goToLoginPage() {
//        return "login";
//    }

    /*
        The scope of values in a  model is limited to current request only by default.
     */

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
//        modelMap.addAttribute("name", name);
//        modelMap.addAttribute("password", password);
//        // adding a hardcoded authentication
//        if (authenticationService.authenticate(name, password)) {
//            return "welcome";
//        } else {
//            modelMap.put("error", "Invalid username or password");
//            return "login";
//        }
//    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap modelMap) {
        modelMap.addAttribute("name", getLoggedUserName());
        return "welcome";
    }

    private String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
