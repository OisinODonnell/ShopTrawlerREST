package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

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

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public ResponseEntity<HashMap<String,String>> delete(User user) {

        respMap.put("httpStatus",""+httpStatus);
        // check if user exists
        // delete
        // check if user has been deleted.

        if (userRepo.findByUserid(user.getUserid()) != null) {
            // delete user
            userRepo.delete(user);
            // check user has been deleted
            if (userRepo.findByUserid(user.getUserid()) == null) {
                // return success
                respMap.put("message","User deleted successfully");
                respMap.put("success","1");
            } else {
                // return failure
                respMap.put("message","User could not be deleted");
                respMap.put("success","0");
            }

        } else {
            respMap.put("message","User does not exist in database");
            respMap.put("success","0");
            // return user does not exist in db
        }

        return  new ResponseEntity<>(respMap, httpStatus);
    }

    @RequestMapping(value = "/deleteByEmail/{email:.+}", method=RequestMethod.GET)
    public ResponseEntity<HashMap<String,String>> delete(@PathVariable ("email") String email) {

        if (userRepo.findByEmailAddress(email) != null) {
            // delete user
            userRepo.deleteByEmailAddress(email);
            // check user has been deleted
            if (userRepo.findByEmailAddress(email) == null) {
                // return success
                respMap.put("message","User deleted successfully");
                respMap.put("success","1");
            } else {
                // return failure
                respMap.put("message","User could not be deleted By Email Address");
                respMap.put("success","0");
            }

        } else {
            respMap.put("message","User with this email [" + email + "] does not exist in database");
            respMap.put("success","0");
            // return user does not exist in db
        }
        return new ResponseEntity<>(respMap, httpStatus);
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public ResponseEntity<HashMap<String,String>> delete(@PathVariable ("id") int id) {

        if( userRepo.deleteByUserid(id) > 0) {
            // return success
            respMap.put("message","User deleted successfully");
            respMap.put("success","1");
        } else {
            // return failure
            respMap.put("message","User with this id [" + id + "] could not be deleted");
            respMap.put("success","0");
        }

        return new ResponseEntity<>(respMap, httpStatus);
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


    @RequestMapping(value = {"/activate/{id}"}, method=RequestMethod.GET)
    public ResponseEntity<HashMap<String,String>> activateUser(@PathVariable("id") int id)
    {
        User user = userRepo.findByUserid(id);
        if (user != null) {
            user.setActive((byte)1);
            respMap.put("message","User:" + user.buildFullname() + " is activated");
            respMap.put("success","1");
        } else {
            // return failure
            respMap.put("message","User could not be activated");
            respMap.put("success","0");
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }


}