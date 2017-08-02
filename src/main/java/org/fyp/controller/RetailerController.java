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
@RequestMapping(value = {"Retailers","Retailer"}, method= RequestMethod.GET)
public class RetailerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Retailer retailer)
    {
        retailerRepo.save(retailer);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Retailer> read()
    {
        return retailerRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Retailer retailer)
    {
        retailerRepo.save(retailer);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Retailer retailer)     {  retailerRepo.delete(retailer);}

    @RequestMapping(value = {"/{id}"}, method=RequestMethod.GET)
    public Retailer getUserBy(@PathVariable("id") int id)
    {
        return retailerRepo.findByRetailerid(id);
    }




}
