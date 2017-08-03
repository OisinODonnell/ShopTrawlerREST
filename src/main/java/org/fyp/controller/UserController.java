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
    public Collection<User> create(User user) {
        userRepo.save(user);
        return userRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<User> read() {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(User user)
    {
        userRepo.save(user);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<User> delete(User user) {
        userRepo.delete(user);
        return userRepo.findAll();
    }

    @RequestMapping(value = "/deleteByEmail/{email}", method=RequestMethod.GET)
    public Collection<User> delete(@PathVariable ("email") String email) {
        userRepo.deleteByEmailAddres(email);
        return userRepo.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public Collection<User> delete(@PathVariable ("id") int id) {
        userRepo.deleteByUserid(id);
        return userRepo.findAll();
    }

    // the pathmapping variables are truncated after the '.', ie 'abc@dd.com' is truncated to 'abc@dd.'
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