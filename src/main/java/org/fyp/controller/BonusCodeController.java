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
    public ResponseEntity<HashMap<String,String>> update(@RequestBody BonusCode bonusCode) throws JsonProcessingException {
        /**
         * locate bonuscode, and set the userid and date and save
         * update user points
         */
        UserPoint userPoints = userPointRepo.findByRetaileridAndUserid(bonusCode.getRetailerid(), bonusCode.getUserid());
        BonusCode bc = bonusCodeRepo.findByBonusCodeid(bonusCode.getBonusCodeid());
        int userid = bc.getUserid();
        User user = userRepo.findByUserid(userid);

        String fullname = user.getFirstname() + " " + user.getSurname();

        if (bc == null) { // bonus code does not exist
            respMap.put( "message", "This BonusCode [ " +  bc.getBonusCodeid()+" ] does not exist in Database" );
            respMap.put( "success", "1" );
            respMap.put( "httpStatus", "" + httpStatus );

        } else if (bc.getUserid() != null) { // code already used
            respMap.put( "message", "This BonusCode [ " + bc.getBonusCodeid() +  " ] has already been claimed by User : [ "+ fullname + " ] on [ " + bonusCode.getDatetime() + " ]" );

            respMap.put( "message", "Code is already used by " );
            respMap.put( "success", "1" );
            respMap.put( "httpStatus", "" + httpStatus );

        } else { // code state valid
            // get value from bonuscode
            // update bc with userid
            // update bc with date/time code was used
            // update users points and bonuscode details.

            int bonus = bc.getValue();
            bc.setUserid(bonusCode.getUserid());
            bc.setDatetime(bonusCode.getDatetime());
            userPoints.add(bonus);
            bonusCodeRepo.save(bc);
            userPointRepo.save(userPoints);

            // return updated  userPoints for this user
            // return bonuscode with user and date applied to the code
            // convert objects to bonuscode and userpoints objects to json and add to respmap

            String jsonBonusCode = mapper.writeValueAsString(bc);
            String jsonUserPoint = mapper.writeValueAsString(userPoints);

            respMap.put("BonusCode",jsonBonusCode);
            respMap.put("UserPoint",jsonUserPoint);

            respMap.put( "message", "Content record already exists covering all or part of this period" );
            respMap.put( "success", "0" );
            respMap.put( "httpStatus", "" + httpStatus );
        }

        bonusCodeRepo.findAll();

        return new ResponseEntity<>(respMap, httpStatus);
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

        int count = bonusCodeRepo.countAllByRetaileridAndUseridNull( id );

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

        } else { // codes could not be created ... but return those which are still valid
            Collection<BonusCode>  bonusCodes = bonusCodeRepo.findAllByRetailerid(id);
            String jsonBonusCodes = mapper.writeValueAsString(bonusCodes);
            respMap.put("data", jsonBonusCodes);
            respMap.put("httpStatus", "" + HttpStatus.OK);
            respMap.put("success", "" + 0);
            respMap.put("message", count + " codes still available, no additional codes created");
        }
        return new ResponseEntity<>( respMap, httpStatus);
    }
}