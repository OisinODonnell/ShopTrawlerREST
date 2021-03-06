package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Users","User"}, method= RequestMethod.GET)
public class UserController extends MainController {


    /**
     * The method was commented out, as this is not the route to creating a new user.
     * @return
     */
//    @RequestMapping(value = "/create", method=RequestMethod.POST)
//    public Collection<User> create(@RequestBody User user) {
//        userRepo.save(user);
//        return userRepo.findAll();
//    }


    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<User> read() {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public void update(@RequestBody User user)
    {
        userRepo.save(user);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public ResponseEntity<HashMap<String,String>> delete(@RequestBody User user) {

        respMap.put("httpStatus",""+httpStatus);
        // check if user exists
        // delete
        // check if user has been deleted.

        if (userRepo.findByUserid(user.getUserid()) != null) {
            // delete user
            userPointRepo.deleteAllByUserid(user.getUserid());
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

    @RequestMapping(value = "/deleteByEmail/{email:.+}", method=RequestMethod.DELETE)
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

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
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
            user.setApproved(true);
            respMap.put("message","User:" + user.buildFullname() + " is activated");
            respMap.put("success","1");
        } else {
            // return failure
            respMap.put("message","User could not be activated");
            respMap.put("success","0");
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }

    @RequestMapping(value = "/ForApproval", method=RequestMethod.GET)
    public Collection<User> forApproval() {
        return userRepo.findAllByApproved(false);  }

    @RequestMapping(value = "/approve", method=RequestMethod.PUT)
    public Collection<User> approve(@RequestBody User user) {
        userRepo.save(user);
        return userRepo.findAll(); }

    @RequestMapping(value = "/update/{id}", method={RequestMethod.PUT})
    public void update( @RequestBody User user, @PathParam( "id") Integer id  ) {
        userRepo.save(user);
    }

    @RequestMapping(value = "/NotManagers", method=RequestMethod.GET)
    public Collection<User> notManagers() {

        // find from the list of users if any are yet to be assigned a s store managers

        List<User> users       = userRepo.findAllByType( "Retailer" );
        List<User> notManagers = new ArrayList<>( );

        for ( User user : users ) {
            Retailer retailer = retailerRepo.findByManagerid( user.getUserid( ) );
            if ( retailer == null )
                notManagers.add( user );

        }


        return notManagers;
    }

}