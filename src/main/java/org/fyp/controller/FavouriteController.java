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
    public void create(Favourite favourite)    {
        favouriteRepo.save(favourite);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Favourite> read()    {
        return favouriteRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Favourite favourite)    {
        favouriteRepo.delete(favourite);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Favourite favourite)    {
        favouriteRepo.save(favourite);
    }

}