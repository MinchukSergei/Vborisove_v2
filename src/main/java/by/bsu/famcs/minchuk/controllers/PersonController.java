package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import by.bsu.famcs.minchuk.services.PersonService;
import by.bsu.famcs.minchuk.services.PlaceService;
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
import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Autowired
    private PersonService personService;

    @Autowired
    private PlaceService placeService;

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
            return new ModelAndView("../../WEB-INF/view/registration", "error", "Error");
        } else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(registered.getUsername(),
                    newPerson.getPassword());

            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            request.getSession().setAttribute("person", registered);

            ModelAndView modelAndView = new ModelAndView("../../WEB-INF/view/gallary");

            List<Place> allPlaces = placeService.getAllPlaces();
            List<String> photos = new ArrayList<String>();
            List<Boolean> likedPhotos = new ArrayList<Boolean>();


            for (Place place : allPlaces) {
                photos.add("/photo/" + place.getId());
                likedPhotos.add(placeService.isLiked(registered, place.getId()));
            }

            modelAndView.addObject("places", allPlaces);
            modelAndView.addObject("photos", photos);
            modelAndView.addObject("likes", likedPhotos);

            return modelAndView;
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
