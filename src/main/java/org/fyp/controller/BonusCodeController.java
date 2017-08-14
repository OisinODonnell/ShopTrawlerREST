package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 02/04/2017.
 */
@RestController
@RequestMapping(value = {"BonusCode","BonusCodes"}, method=RequestMethod.GET)
public class BonusCodeController extends MainController{

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<BonusCode> create(@RequestBody BonusCode bonusCode)    {

        bonusCodeRepo.save(bonusCode);
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<BonusCode> read()    {
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<BonusCode> update(@RequestBody BonusCode bonusCode)    {


        bonusCodeRepo.save(bonusCode);
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public Collection<BonusCode> delete(@RequestBody BonusCode bonusCode)    {

        bonusCodeRepo.delete(bonusCode);
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<BonusCode> listByUser(@PathVariable ("id") Integer id)
    {
        return bonusCodeRepo.findAllByUserid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<BonusCode> listByRetailer(@PathVariable ("id") Integer id)
    {
        return bonusCodeRepo.findAllByRetailerid(id);
    }

}
