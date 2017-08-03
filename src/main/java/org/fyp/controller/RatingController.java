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
@RequestMapping(value = {"Ratings","Rating"}, method=RequestMethod.GET)
public class RatingController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public Collection<Rating> create(Rating rating)
    {

        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Rating> read() throws JsonProcessingException {
        return ratingRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public Collection<Rating> update(Rating rating)
    {

        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<Rating> delete(Rating rating)
    {

        ratingRepo.delete(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Rating> findAllByRetailerId(@PathVariable("id") Integer id) {
        return ratingRepo.findAllByRetailerid(id); }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Rating> findAllByUserId(@PathVariable("id") Integer id) {
        return ratingRepo.findAllByUserid(id); }

    @RequestMapping(value = "/UserRetailer/{userid}/{retailerid}", method=RequestMethod.GET)
    public Rating findAllByUserRetailer(@PathVariable("userid")       Integer userid,
                                  @PathVariable("retailerid")   Integer retailerid) {
        return ratingRepo.findByUseridAndRetailerid(userid, retailerid);
    }
    
    
}