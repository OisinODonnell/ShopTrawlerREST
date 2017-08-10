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
@RequestMapping(value = {"Locations","Location"}, method=RequestMethod.GET)
public class LocationController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public Collection<Location> create(Location location) {
        locationRepo.save(location);
        return locationRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Location> read() throws JsonProcessingException {
        return locationRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public Collection<Location> update(Location location) {
        locationRepo.save(location);
        return locationRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<Location> delete(Location location) {
        locationRepo.delete(location);
        return locationRepo.findAll();
    }


}