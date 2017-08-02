package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Users","User"}, method= RequestMethod.GET)
public class UserController extends MainController {


    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(User user)
    {
        userRepo.save(user);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<User> read()
    {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(User user)
    {
        userRepo.save(user);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(User user)
    {
        userRepo.delete(user);
    }

    // the pathmapping variables are truncated after the '.'
    // additional regex chars necessary to retrieve the full parameter ':.+'
    @RequestMapping(value = "/ByEmail/{emailAddress:.+}", method=RequestMethod.GET)
    public User getUserByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        return userRepo.findByEmailAddress(emailAddress);
    }

    @RequestMapping(value = {"/{id}"}, method=RequestMethod.GET)
    public User getUserBy(@PathVariable("id") int id)
    {
        return userRepo.findByUserid(id);
    }


}