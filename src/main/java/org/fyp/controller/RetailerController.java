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
@RequestMapping(value = "Retailers", method= RequestMethod.GET)
public class RetailerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Retailer cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Retailer> read()
    {
        return cartItemRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Retailer cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Retailer cartItem)     {  cartItemRepo.delete(cartItem);}

}
