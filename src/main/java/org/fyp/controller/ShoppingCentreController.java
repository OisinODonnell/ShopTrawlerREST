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
@RequestMapping(value = "ShoppingCentres", method= RequestMethod.GET)
public class ShoppingCentreController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(ShoppingCentre shoppingCentre)
    {
        shoppingCentreRepo.save(shoppingCentre);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<ShoppingCentre> read()
    {
        return shoppingCentreRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(ShoppingCentre shoppingCentre)
    {
        shoppingCentreRepo.save(shoppingCentre);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(ShoppingCentre shoppingCentre) { shoppingCentreRepo.delete(shoppingCentre);    }





}
