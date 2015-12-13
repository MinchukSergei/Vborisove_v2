package by.bsu.famcs.minchuk.utils.handlers;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PersonService personService;

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        User authPerson = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personService.readByUserName(authPerson.getUsername());
        session.setAttribute("person", person);

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.sendRedirect("/gallary");
    }
}
