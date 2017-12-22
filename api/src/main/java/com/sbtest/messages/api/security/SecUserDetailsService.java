package com.sbtest.messages.api.security;

import com.sbtest.messages.api.dao.UserDAO;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
          I have used userRepository*/
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (DAOException e) {
            throw new UsernameNotFoundException("User not found due to database error.");
        }
        if(user == null){
            throw new UsernameNotFoundException("User not found:" + email);
        }else{
            UserDetails details = new SecUserDetails(user);

            return details;
        }
    }
}