package by.bsu.famcs.minchuk.services;

import by.bsu.famcs.minchuk.model.Person;
import by.bsu.famcs.minchuk.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userDetailsService")
public class CustomUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    private Set<GrantedAuthority> buildUA (Set<UserRole> ur) {
        Set<GrantedAuthority> setAuthorities = new HashSet<GrantedAuthority>();
        for (UserRole userRole : ur) {
            setAuthorities.add (new SimpleGrantedAuthority(userRole.getRole()));
        }
        return setAuthorities;
    }
}
