package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.Place;
import by.bsu.famcs.minchuk.services.PlaceService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PhotoController {

    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "/photo/{photoId}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getPhoto(@PathVariable String photoId) {
        return placeService.getPlaceById(Long.parseLong(photoId)).getImageBytes();
    }

    @RequestMapping(value = "/photo/{photoId}/switchLike", method = RequestMethod.GET)
    @ResponseBody
    public String switchLike(@PathVariable String photoId, HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("person");
        if (placeService.isLiked(person, Integer.parseInt(photoId))) {
            placeService.removeLike(person, Integer.parseInt(photoId));
            return "1";
        }
        placeService.setLike(person, Integer.parseInt(photoId));
        return "0";
    }

    @RequestMapping(value = "/photo/{photoId}/isLike", method = RequestMethod.GET)
    @ResponseBody
    public String isLike(@PathVariable String photoId, HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("person");
        if (placeService.isLiked(person, Integer.parseInt(photoId))) {
            return "1";
        }
        return "0";
    }

}
