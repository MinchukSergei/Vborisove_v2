package by.bsu.famcs.minchuk.controllers;

/**
 * Created by minchuk on 24/10/15.
 */
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.RequestWrapper;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/home")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("personAttribute", new Person());
        return "registration";
    }




}
