package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PersonController {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistration() {
        return new ModelAndView("../../WEB-INF/view/registration");
    }

    @RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("person") Person newPerson,
                                     BindingResult result, Errors errors, HttpServletRequest request) {
        Person registered = new Person();
        if (!result.hasErrors()) {
            registered = createUserAccount(newPerson);
        }
        if (registered == null) {
            result.rejectValue("username", "message.regError", "Wrong username or password");
        }
        if (result.hasErrors()) {
            return new ModelAndView("../../WEB-INF/view/registration", "person", newPerson);
        } else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(registered.getUsername(),
                    newPerson.getPassword());

            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            request.getSession().setAttribute("person", registered);

            return new ModelAndView("../../WEB-INF/view/gallary");
        }


    }

    private Person createUserAccount(Person newPerson) {
        Person registered;
        try {
            registered = personService.registerNewUserAccount(newPerson);
        } catch (NullPointerException e) {
            return null;
        }
        return registered;
    }
}
