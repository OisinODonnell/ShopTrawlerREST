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
@RequestMapping(value = "Ratings", method=RequestMethod.GET)
public class RatingController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Rating rating)
    {
        ratingRepo.save(rating);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Rating> read() throws JsonProcessingException {
        return ratingRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Rating rating)
    {
        ratingRepo.save(rating);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Rating rating)
    {
        ratingRepo.delete(rating);
    }

    
}