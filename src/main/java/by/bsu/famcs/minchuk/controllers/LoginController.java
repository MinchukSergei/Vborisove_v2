package by.bsu.famcs.minchuk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/view/login");
        if (request.getParameter("error") != null) {
            modelAndView.addObject("error", "Wrong credentials");
        }
        return modelAndView;
    }
}
