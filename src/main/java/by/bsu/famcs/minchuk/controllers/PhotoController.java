package by.bsu.famcs.minchuk.controllers;

import by.bsu.famcs.minchuk.model.Comment;
import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.services.PlaceService;
import by.bsu.famcs.minchuk.utils.handlers.Pair;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


    @RequestMapping(value = "/photo/{photoId}/addComment", method = RequestMethod.POST)
    @ResponseBody
    public void addComment(@RequestParam String commentSrc,
                           @PathVariable String photoId,
                           HttpServletRequest request) {
        Comment newComment = new Comment();
        newComment.setPerson((Person) request.getSession().getAttribute("person"));
        newComment.setPlace(placeService.getPlaceById(Integer.parseInt(photoId)));
        newComment.setCommentSource(commentSrc);
        placeService.addComment(newComment);
    }


    @RequestMapping(value = "/photo/{photoId}/getComments", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getComments(@PathVariable String photoId) {
        List<Pair<String, String>> commentSource = new ArrayList<Pair<String, String>>();
        List<Comment> comments = placeService.getCommentsByPlaceId(Integer.parseInt(photoId));

        for (Comment com : comments) {
            commentSource.add(new Pair<String, String>(com.getCommentSource(), com.getPerson().getName()));
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(commentSource);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }



}
