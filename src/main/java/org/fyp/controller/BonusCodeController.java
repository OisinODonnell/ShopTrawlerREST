package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 02/04/2017.
 */
@RestController
@RequestMapping(value = "BonusCodes", method=RequestMethod.GET)
public class BonusCodeController extends MainController{

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(BonusCode bonusCode)    {
        bonusCodeRepo.save(bonusCode);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<BonusCode> read()    {
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(BonusCode bonusCode)    {
        bonusCodeRepo.save(bonusCode);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(BonusCode bonusCode)    {
        bonusCodeRepo.delete(bonusCode);
    }

}
