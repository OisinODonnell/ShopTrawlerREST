package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

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


    @RequestMapping(value = "/reset",method=RequestMethod.PUT)
    public ResponseEntity<HashMap<String,String>>  reset(@RequestBody UserPoint userPoint) throws JsonProcessingException {

        UserPoint up = userPointRepo.findByRetaileridAndUserid(userPoint.getRetailerid(), userPoint.getUserid());
        respMap = new HashMap<>();


        /**
         * This endpoint is activated on the mobile client but triggered by the retailer on the client phone
         * The retailer provides a reward to the user, and thus resets their points accordingly
         * The userPoints are reduced by 1000.;
         */


        if (up != null) {
            if (up.getPoints() >= 1000) {

                up.setPoints(up.getPoints() - 1000);
                userPointRepo.save(up);
                userPointRepo.findByRetaileridAndUserid(userPoint.getRetailerid(), userPoint.getUserid());

                String jsonUserPoint = mapper.writeValueAsString(up);

                respMap.put("UserPoint", jsonUserPoint);
                respMap.put("message", "Reset Succeeded ... UserPoints reduced by 1000 Points");
                respMap.put("success", "0");
                respMap.put("httpStatus", "" + httpStatus);

            } else { // user points are less than 1000 so not reset can take place

                String jsonUserPoint = mapper.writeValueAsString(up);
                respMap.put("UserPoint", jsonUserPoint);
                respMap.put("message", "Reset Failed ... UserPoints are less than 1000");
                respMap.put("success", "1");
                respMap.put("httpStatus", "" + httpStatus);

            }
        } else { // user point record does not exist
            respMap.put("UserPoint","");
            respMap.put("message", "Reset Failed ... User Record for this retailer could not be found");
            respMap.put("success", "1");
            respMap.put("httpStatus", "" + httpStatus);
        }
        return new ResponseEntity<>(respMap, httpStatus);
    }



}
