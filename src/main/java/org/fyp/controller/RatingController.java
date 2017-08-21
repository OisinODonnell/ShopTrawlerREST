package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.scene.chart.Chart;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    /**
     *
     * @return return an average rating for each retailer
     */
    @RequestMapping(value = "/Admin/Average", method=RequestMethod.GET)
    public Collection<RatingCount> findAllByRetailerId() {
        return getRatings();
    }

    /**
     *
     * @param id
     * @return return the average rating for a specif retailer
     */
    @RequestMapping(value = "/Retailer/Average/{id}", method=RequestMethod.GET)
    public RatingCount findAllCountsByRetailerId(@PathVariable("id") Integer id) {
        return getRetailerRating(id);
    }

    /**
     *
     * @param id
     * @return Return a list of ratings from one user
     */
    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Rating> findAllByUserId(@PathVariable("id") Integer id) {
        return ratingRepo.findAllByUserid(id); }

    /**
     *
     * @param userid
     * @param retailerid
     * @return return a specific rating made by a user on a retailer
     */
    @RequestMapping(value = "/UserRetailer/{userid}/{retailerid}", method=RequestMethod.GET)
    public Rating findAllByUserRetailer(@PathVariable("userid")       Integer userid,
                                  @PathVariable("retailerid")   Integer retailerid) {
        return ratingRepo.findByUseridAndRetailerid(userid, retailerid);
    }

    /**
     *
     * @return Return an average rating for each retailer
     */
    @RequestMapping(value = "/Report/Admin", method=RequestMethod.GET)
    public Collection<RatingCount> getRatings() {
        Collection<Retailer> retailers = retailerRepo.findAll();
        Collection<RatingCount> ratingCounts = new ArrayList<>();

        for (Retailer retailer: retailers) {
            Integer ratingSum = 0;
            Collection<Rating> ratings = ratingRepo.findAllByRetailerid(retailer.getRetailerid());
            RatingCount rc = getRetailerRating(retailer.getRetailerid());
            ratingCounts.add(rc);
        }
        return ratingCounts;
    }

    @RequestMapping(value = "/Report/Retailer/{id}", method=RequestMethod.GET)
    public RatingCount getRetailerRating(@PathVariable("id") Integer retailerid) {
        Retailer retailer = retailerRepo.findByRetailerid(retailerid);
        String storeName = retailer.getStoreName();
        Collection<Rating> ratings = ratingRepo.findAllByRetailerid( retailerid );
        int ratingSum = 0;
        float avgRating = 0;
        for (Rating rating : ratings) {
            ratingSum += rating.getRating();
        }
        avgRating = (float) ratingSum/ratings.size();
        RatingCount rc = new RatingCount( retailerid, storeName, avgRating );

        return rc;
    }





    
    
}