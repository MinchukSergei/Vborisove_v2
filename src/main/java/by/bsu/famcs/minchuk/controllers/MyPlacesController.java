package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import by.bsu.famcs.minchuk.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyPlacesController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/myPhotos", method = RequestMethod.GET)
    public ModelAndView getMyPhotos(HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("person");

        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/view/myplaces");

        List<Place> allPlacesOfThePerson = placeService.getPlacesOfThePerson(person.getUsername());
        List<String> allPhotos = new ArrayList<String>();
        for (Place place : allPlacesOfThePerson) {
            allPhotos.add("/photo/" + place.getId());
        }
        modelAndView.addObject("myPlaces", allPlacesOfThePerson);
        modelAndView.addObject("myPhotos", allPhotos);
        return modelAndView;
    }

    @RequestMapping(value = "/myPhotos", method = RequestMethod.POST)
    public String addNewPhoto(@ModelAttribute("place") Place newPlace, @RequestParam MultipartFile photo,
                              HttpServletRequest request) {

        Person currentPerson = (Person)request.getSession().getAttribute("person");
        Place place = getNewPlace(newPlace, currentPerson, photo);
        placeService.createNewPlace(place);

        return "redirect:/myPhotos";
    }

    @RequestMapping(value = "/myPhotos/{photoId}/delete", method = RequestMethod.GET)
    public String deletePlace(@PathVariable String photoId) {
        placeService.deletePlaceById(Long.parseLong(photoId));
        return "redirect:/myPhotos";
    }

    private Place getNewPlace(Place newPlace, Person person, MultipartFile photo) {
        Place place = new Place();
        place.setName(newPlace.getName());
        place.setDescription(newPlace.getDescription());
        place.setPerson(person);
        if (!photo.isEmpty()) {
            try {
                byte[] bytes = photo.getBytes();
                place.setImageBytes(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return place;
    }
}
