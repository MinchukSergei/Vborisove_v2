package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import by.bsu.famcs.minchuk.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class GallaryController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/gallary", method = RequestMethod.GET)
    public ModelAndView getGallery(HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("person");

        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/view/gallary");
        List<Place> allPlaces = placeService.getAllPlaces();
        List<String> photos = new ArrayList<String>();
        List<Boolean> likedPhotos = new ArrayList<Boolean>();

        for (Place place : allPlaces) {
            photos.add("/photo/" + place.getId());
            likedPhotos.add(placeService.isLiked(person, place.getId()));
        }

        modelAndView.addObject("places", allPlaces);
        modelAndView.addObject("photos", photos);
        modelAndView.addObject("likes", likedPhotos);

        return modelAndView;
    }
}
