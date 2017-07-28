package org.fyp.Service;

import org.fyp.model.CustomUserDetails;
import org.fyp.model.User;
import org.fyp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

        Collection<User> users = userRepo.findAll();

        User user = userRepo.findByEmailAddress(emailAddress);
        if (user == null) {
            throw new UsernameNotFoundException(emailAddress);
        }
        return new CustomUserDetails(user);
    }

}
