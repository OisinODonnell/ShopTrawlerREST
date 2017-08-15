package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

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

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<BonusCode> delete(@PathVariable("id") Integer id)    {
        bonusCodeRepo.deleteByBonusCodeid(id);
        return bonusCodeRepo.findAll();
    }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<BonusCode> listByUser(@PathVariable ("id") Integer id) {
        return bonusCodeRepo.findAllByUserid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<BonusCode> listByRetailer(@PathVariable ("id") Integer id) {
        return bonusCodeRepo.findAllByRetailerid(id);
    }
    @RequestMapping(value = "/Generate/{id}", method=RequestMethod.GET)
    public ResponseEntity<HashMap<String,String>> generateCodes(@PathVariable ("id") Integer id) throws JsonProcessingException {
        int       value      = 250;
        int       lowerLimit =   10;
        BonusCode bc         = new BonusCode();

        // only create codes if the remaining codes unused is less than 5.

        int count = bonusCodeRepo.countAllBRetaileridAndUseridNull( id );

        if (count < lowerLimit) {
            // ok create new codes
            for ( int i = 0; i < 10; i++ ) {
                // create new code
                bc = new BonusCode( value, id );
                // and persist to db.
                bonusCodeRepo.save( bc );
            }
            Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
            String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
            respMap.put("data", jsonBonusCodes);
            respMap.put("httpStatus", "" + HttpStatus.OK);
            respMap.put("success", "" + 1);
            respMap.put("message", "10 additional Bonus Codes Created");

        } else { // codes could not be created
            respMap.put("httpStatus", "" + HttpStatus.OK);
            respMap.put("success", "" + 0);
            respMap.put("message", "5 codes still available, no additional codes created");
        }
        return new ResponseEntity<>( respMap, httpStatus);
    }
}