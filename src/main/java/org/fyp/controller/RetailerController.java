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
@RequestMapping(value = {"Retailers","Retailer"}, method= RequestMethod.GET)
public class RetailerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Retailer> create(@RequestBody Retailer retailer)
    {
        retailerRepo.save(retailer);
        return retailerRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Retailer> read()
    {
        return retailerRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Retailer> update(@RequestBody Retailer retailer) {
        retailerRepo.save(retailer);
        return retailerRepo.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Retailer> delete(@PathVariable ("id") Integer id)     {
        retailerRepo.deleteByRetailerid(id);
        return retailerRepo.findAll();
    }

    @RequestMapping(value = {"/{id}"}, method=RequestMethod.GET)
    public Retailer getUserBy(@PathVariable("id") int id)
    {
        return retailerRepo.findByRetailerid(id);
    }




}
