package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
@RequestMapping(value = {"UserPoints","UserPoints"}, method=RequestMethod.GET)
public class UserPointController extends MainController {

    @RequestMapping(value = "/create",method=RequestMethod.GET)
    public void create(UserPoint userPoint)    {
        userPointRepo.save(userPoint);
    }

    @RequestMapping(value = {"", "/", "/read"},method=RequestMethod.GET)
    public Collection<UserPoint> read()    {
        return userPointRepo.findAll();
    }

    @RequestMapping(value = "/update",method=RequestMethod.GET)
    public void update(UserPoint userPoint)    { userPointRepo.save(userPoint); }

    @RequestMapping(value = "/delete",method=RequestMethod.GET)
    public void delete(UserPoint userPoint)    {
        userPointRepo.delete(userPoint);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<UserPoint> findAllByRetailerId(@PathVariable("id") Integer id)
    {
        return userPointRepo.findAllByRetailerid(id);
    }

}
