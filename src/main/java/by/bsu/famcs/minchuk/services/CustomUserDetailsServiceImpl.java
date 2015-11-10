package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonService personService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.readByUserName(username);
        if (person == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + username);
        }

        Set<GrantedAuthority> authorities =  new HashSet<GrantedAuthority>();
        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), authorities);
    }
}
