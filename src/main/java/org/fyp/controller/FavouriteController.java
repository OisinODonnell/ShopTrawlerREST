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
@RequestMapping(value = {"Favourites","Favourite"}, method=RequestMethod.GET)
public class FavouriteController extends MainController {

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public Collection<Favourite> create(Favourite favourite)    {

        favouriteRepo.save(favourite);
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Favourite> read()    {
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public Collection<Favourite> update(Favourite favourite)    {

        favouriteRepo.delete(favourite);
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<Favourite> delete(Favourite favourite)    {

        favouriteRepo.save(favourite);
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Favourite> listByUser(@PathVariable ("id") Integer id) {
        return favouriteRepo.findAllByUserid(id); }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Favourite> listByRetailer(@PathVariable ("id") Integer id) {
        return favouriteRepo.findAllByRetailerid(id); }
}