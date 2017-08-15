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
@RequestMapping(value = {"UserPoint","UserPoints"}, method=RequestMethod.GET)
public class UserPointController extends MainController {

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public Collection<UserPoint> create(@RequestBody UserPoint userPoint)    {

        userPointRepo.save(userPoint);
        return userPointRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"},method=RequestMethod.GET)
    public Collection<UserPoint> read()    {
        return userPointRepo.findAll();
    }

    @RequestMapping(value = "/update",method=RequestMethod.PUT)
    public Collection<UserPoint> update(@RequestBody UserPoint userPoint)    {
        userPointRepo.save(userPoint);
        return userPointRepo.findAll();
    }

    @RequestMapping(value = "/delete/{userid}/{retailerid", method=RequestMethod.DELETE)
    public Collection<UserPoint> delete(@PathVariable("userid") Integer userid,
                                        @PathVariable("retailerid") Integer retailerid)    {
        userPointRepo.deleteByUseridAndRetailerid(userid, retailerid);
        return userPointRepo.findAll();
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<UserPoint> findAllByRetailerId(@PathVariable("id") Integer id) {
        return userPointRepo.findAllByRetailerid(id); }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<UserPoint> findAllByUserId(@PathVariable("id") Integer id) {
        return userPointRepo.findAllByUserid(id); }
}
