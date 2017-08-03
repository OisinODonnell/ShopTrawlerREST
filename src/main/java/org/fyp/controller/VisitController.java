package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Visits","Visit"}, method= RequestMethod.GET)
public class VisitController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Visit visit) { visitRepo.save(visit);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Visit> read()
    {
        return visitRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Visit visit) { visitRepo.save(visit); }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Visit visit)     {  visitRepo.delete(visit);    }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Visit> listByUser(@PathVariable ("id") Integer id)
    {
        return visitRepo.findAllByUserid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Visit> listByRetailer(@PathVariable ("id") Integer id)
    {
        return visitRepo.findAllByZoneid(id);
    }


    /*
    TODO: These two need addition work, determine exactly what should be returned.
    eg Male : qty, Femail Qty
    < 15 : qty
    16 - 20 : qty
    21 - 25 : qty etc
     */


//    @RequestMapping(value = "/User/Age", method=RequestMethod.GET)
//    public Collection<Visit> listByAge(@PathVariable ("id") Integer id)
//    {
//        return visitRepo.findAllByAge(id);
//    }
//
//    @RequestMapping(value = "/User/Gender", method=RequestMethod.GET)
//    public Collection<Visit> listByGender()
//    {
//        return visitRepo.findAllByGender();
//    }








}
