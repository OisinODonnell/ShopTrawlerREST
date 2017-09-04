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
    int       lowerLimit =   20;
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
        /**
         * locate bonuscode, and set the userid and date and save
         * update user points
         */
        UserPoint userPoints = userPointRepo.findByRetaileridAndUserid(bonusCode.getRetailerid(), bonusCode.getUserid());
        BonusCode bc = bonusCodeRepo.findByBonusCodeid(bonusCode.getBonusCodeid());
        int bonus = bc.getValue();
        bc.setUserid(bonusCode.getUserid());
        bc.setDatetime(bonusCode.getDatetime());
        userPoints.add(bonus);

        bonusCodeRepo.save(bc);
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
    @RequestMapping(value = "/Generate/{value}/{id}", method=RequestMethod.PUT)
    public ResponseEntity<HashMap<String,String>> generateCodes(@PathVariable ("value") Integer value,
                                                                @PathVariable ("id") Integer id ) throws JsonProcessingException {

        respMap.put("httpStatus", "" + HttpStatus.OK);

        int count250 = bonusCodeRepo.countAllByRetaileridAndUseridNullAndValue( id , 250);
        int count500 = bonusCodeRepo.countAllByRetaileridAndUseridNullAndValue( id , 500);

        if (value == 250)  {
            if (count250 < lowerLimit) {
                generateNewCodes(value,20, id);
                Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
                String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
                respMap.put("data", jsonBonusCodes);
                respMap.put("success", "" + 1);
                respMap.put("message", "20 additional Bonus Codes Created of value = 250");
            } else {
                Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
                String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
                respMap.put("success", "" + 0);
                respMap.put("data", jsonBonusCodes);
                respMap.put("message", count250 + " codes still available ... No additional Bonus Codes Created");
            }
        }
        else if (value == 500) {
            if ( count500 < lowerLimit ) {
                generateNewCodes(value,20, id);

                Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
                String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
                respMap.put("data", jsonBonusCodes);
                respMap.put("success", "" + 1);
                respMap.put("message", "20 additional Bonus Codes Created of value = 500");

            } else {
                Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
                String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
                respMap.put("data", jsonBonusCodes);
                respMap.put("success", "" + 0);
                respMap.put("message", count500 + " codes still available ... No additional Bonus Codes Created");
            }
        } else { // wrong value passed ... only 250 or 500 allowed
            Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
            String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
            respMap.put("data", jsonBonusCodes);
            respMap.put("success", "" + 0);
            respMap.put("message", "Incorrect value code passed, no additional Bon us Codes created");
        }

        return new ResponseEntity<>( respMap, httpStatus);
    }

    public void generateNewCodes(int value, int qty, int id) {
        BonusCode bc         = new BonusCode();
        for ( int i = 0; i < 20 ; i++ ) {
            // create new code
            bc = new BonusCode ( value, id );
            // and persist to db.
            bonusCodeRepo.save( bc );
        }
    }
}