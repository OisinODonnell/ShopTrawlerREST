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
@RequestMapping(value = {"Ratings","Rating"}, method=RequestMethod.GET)
public class RatingController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<Rating> create(@RequestBody Rating rating) {
        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Rating> read() throws JsonProcessingException {
        return ratingRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Rating> update(@RequestBody Rating rating) {
        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = "/delete/{userid}/{retailerid}", method=RequestMethod.DELETE)
    public Collection<Rating> delete(@PathVariable ("userid") Integer userid,
                                     @PathVariable ("retailerid") Integer retailerid)     {
        ratingRepo.deleteByUseridAndRetailerid(userid, retailerid);
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