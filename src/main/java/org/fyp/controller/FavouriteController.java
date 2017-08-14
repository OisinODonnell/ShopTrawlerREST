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
@RequestMapping(value = {"Favourites","Favourite"}, method=RequestMethod.GET)
public class FavouriteController extends MainController {

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<Favourite> create(@RequestBody Favourite favourite)    {

        favouriteRepo.save(favourite);
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Favourite> read()    {
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Favourite> update(@RequestBody Favourite favourite)    {

        favouriteRepo.delete(favourite);
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public Collection<Favourite> delete(@RequestBody Favourite favourite)    {

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