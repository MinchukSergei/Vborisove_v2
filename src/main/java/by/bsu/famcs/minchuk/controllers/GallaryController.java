package by.bsu.famcs.minchuk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GallaryController {
    @RequestMapping(value = "/gallary", method = RequestMethod.GET)
    public ModelAndView getGallery() {
        return new ModelAndView("../../WEB-INF/view/gallary");
    }
}
