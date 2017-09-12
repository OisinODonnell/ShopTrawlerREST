package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 18/07/2017.
 */


@RestController
@RequestMapping(value = {"Retailers","Retailer"}, method= RequestMethod.GET)
public class RetailerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Retailer> create(@RequestBody Retailer retailer)
    {
        Zone zone = new Zone();
        retailerRepo.save(retailer);
        zoneRepo.save(zone);
        updateUserPoints(retailer);
        return retailerRepo.findAll();
    }
    @RequestMapping(value = "/create/default", method=RequestMethod.POST)
    public Collection<Retailer> createDefault()
    {
        Retailer retailer = new Retailer();
        retailerRepo.save(retailer);

        updateUserPoints(retailer);
        return retailerRepo.findAll();
    }

    private void updateUserPoints(Retailer retailer) {
        List<User> users = userRepo.findAll();
        for (User user : users) {
            UserPoint up = new UserPoint(user.getUserid(), retailer.getRetailerid(), 0);
            userPointRepo.save(up);
        }

    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Retailer> read()
    {
        return retailerRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Retailer> update(@RequestBody Retailer retailer) {
        // for this app zoneid == retailerid
        int id = retailer.getRetailerid();
        if (retailer.getZoneid() == null)
            retailer.setZoneid( id );
        retailerRepo.save(retailer);
        return retailerRepo.findAll();
    }
    @RequestMapping(value = "/Retailer/update", method=RequestMethod.PUT)
    public Retailer updateRetailer(@RequestBody Retailer retailer) {
        // for this app zoneid == retailerid
        int id = retailer.getRetailerid();
        if (retailer.getZoneid() == null)
            retailer.setZoneid( id );
        retailerRepo.save( retailer );
        return retailerRepo.findByRetailerid(retailer.getRetailerid());
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Retailer> delete(@PathVariable ("id") Integer id)     {
        retailerRepo.deleteByRetailerid(id);
        return retailerRepo.findAll();
    }

    @RequestMapping(value = {"/{id}"}, method=RequestMethod.GET)
    public Retailer getRetailerBy(@PathVariable("id") int id)
    {
        return retailerRepo.findByRetailerid(id);
    }




}
