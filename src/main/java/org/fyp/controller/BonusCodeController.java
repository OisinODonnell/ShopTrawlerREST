package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
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
    public ResponseEntity<HashMap<String,String>> update(@RequestBody BonusCode bonusCode) throws JsonProcessingException {
        /**
         * locate bonuscode, and set the userid and date and save
         * update user points
         */

        BonusCode bc = bonusCodeRepo.findByBonusCodeid(bonusCode.getBonusCodeid());

        int userid = bonusCode.getUserid();
        User user = userRepo.findByUserid(userid);



        if (bc == null) { // bonus code does not exist

            respMap.put( "message", "Invalid Bonus Code" );
            respMap.put( "success", "1" );
            respMap.put( "httpStatus", "" + httpStatus );

        } else if (bc.getUserid() != null) { // code already used

            String fullname = user.getFirstname() + " " + user.getSurname();
            String message = "Bonus Code already used";
            respMap.put("message", message);
            respMap.put("success", "1");
            respMap.put("httpStatus", "" + httpStatus);

        } else if (bc.getRetailerid() != bonusCode.getRetailerid()) { // retailer ids dont match

            String message = "Invalid Bonus Code";
            respMap.put("message", message);
            respMap.put("success", "1");
            respMap.put("httpStatus", "" + httpStatus);

        } else { // code state valid

            // get value from bonuscode
            // update bc with userid
            // update bc with date/time code was used
            // update users points and bonuscode details.

            UserPoint userPoints = userPointRepo.findByRetaileridAndUserid(bc.getRetailerid(), bonusCode.getUserid());
            if (userPoints == null) {
                UserPoint up = new UserPoint();
                up.setPoints(0);
                up.setRetailerid(bonusCode.getRetailerid());
                up.setUserid(bonusCode.getUserid());
                userPointRepo.save(up);
                userPoints = up;
            }

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

            respMap.put( "message", "Bonus Code accepted and UserPoints updated" );
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


    @RequestMapping(value = "/Generate/{value}/{id}", method=RequestMethod.PUT)
    public ResponseEntity<HashMap<String,String>> generateCodes250( @PathVariable ("value") Integer value,
                                                                    @PathVariable ("id") Integer id) throws JsonProcessingException {

        Collection<BonusCode>  bonusCodes = new ArrayList<>();

        if (value == 250 || value == 500) {

            int count = bonusCodeRepo.countAllByRetaileridAndUseridNullAndValue( id, value );

            if ( count < lowerLimit ) {
                bonusCodes = generateCodes( value, id );
                String jsonBonusCodes = mapper.writeValueAsString( bonusCodes );
                respMap.put( "data", jsonBonusCodes );
                respMap.put( "success", "" + 1 );
                respMap.put( "message", "10 additional [ " + value + " ] Point Bonus Codes Created" );

            } else { // codes could not be created ... but return those which are still valid
                bonusCodes = bonusCodeRepo.findAllByRetailerid( id );
                String jsonBonusCodes = mapper.writeValueAsString( bonusCodes );
                respMap.put( "data", jsonBonusCodes );
                respMap.put( "success", "" + 0 );
                respMap.put( "message", "[ " + count + " ] codes still available, no additional codes created" );
            }
        } else {
            bonusCodes = bonusCodeRepo.findAllByRetailerid( id );
            String jsonBonusCodes = mapper.writeValueAsString( bonusCodes );
            respMap.put( "data", jsonBonusCodes );
            respMap.put( "success", "" + 0 );
            respMap.put( "message", "Incorrect Value of Bonus Code passed ... must be 250 or 500" );
        }
        respMap.put("httpStatus", "" + HttpStatus.OK);

        return new ResponseEntity<>( respMap, httpStatus);
    }


    public Collection<BonusCode> generateCodes(int value, int id) {

        BonusCode bc = new BonusCode();

        for ( int i = 0; i < 10; i++ ) {
            // create new code
            bc = new BonusCode( value, id );
            // and persist to db.
            bonusCodeRepo.save( bc );
        }

        return bonusCodeRepo.findAllByRetailerid( id );
    }






}