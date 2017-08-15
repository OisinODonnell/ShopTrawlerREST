package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */



@RestController
@RequestMapping(value = {"Locations","Location"}, method=RequestMethod.GET)
public class LocationController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<Location> create(@RequestBody Location location) {
        locationRepo.save(location);
        return locationRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Location> read() throws JsonProcessingException {
        return locationRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Location> update(@RequestBody Location location) {
        locationRepo.save(location);
        return locationRepo.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Location> delete(@PathVariable("id") Integer id)    {
        locationRepo.deleteByLocationid(id);
        return locationRepo.findAll();
    }
}