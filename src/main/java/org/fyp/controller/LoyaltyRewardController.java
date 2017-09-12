package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * Created by oisin on 18/07/2017.
 */



@RestController
@RequestMapping(value = {"LoyaltyRewards","LoyaltyReward"}, method=RequestMethod.GET)
public class LoyaltyRewardController extends MainController {


    @RequestMapping(value = "/ForApproval", method=RequestMethod.GET)
    public Collection<LoyaltyReward> forApproval() {
        return loyaltyRewardRepo.findAllByApproved(false);
    }


    /**
     * Create operation is only complete by a retailer, so only return loyalty rewards
     * for this retailer
     * @param loyaltyReward
     * @return
     */

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<LoyaltyReward> create(@RequestBody LoyaltyReward loyaltyReward)
    {
        int retailerid = loyaltyReward.getRetailerid();
        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findByRetailerid(retailerid);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<LoyaltyReward> read() throws JsonProcessingException {
        return loyaltyRewardRepo.findAll(); }
    /**
     * Create operation is only complete by a retailer, so only return loyalty rewards
     * for this retailer
     * @param loyaltyReward
     * @return
     */
    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<LoyaltyReward> update(@RequestBody LoyaltyReward loyaltyReward)
    {
        int retailerid = loyaltyReward.getRetailerid();
        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findByRetailerid(retailerid);
    }
    /**
     * Create operation is only complete by a retailer, so only return loyalty rewards
     * for this retailer
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<LoyaltyReward> delete(@PathVariable ("id") Integer id)     {

        LoyaltyReward loyaltyReward = loyaltyRewardRepo.findByLoyaltyRewardid( id );
        int retailerid = loyaltyReward.getRetailerid();
        loyaltyRewardRepo.deleteByLoyaltyRewardid(id);
        return loyaltyRewardRepo.findByRetailerid(retailerid);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public LoyaltyReward findById(@PathVariable("id") Integer id) {
        return loyaltyRewardRepo.findByLoyaltyRewardid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<LoyaltyReward> findAllByRetailerId(@PathVariable("id") Integer id) {
        return loyaltyRewardRepo.findAllByRetailerid(id); }


    @RequestMapping(value = "/approve", method=RequestMethod.GET)
    public Collection<LoyaltyReward> approve(@RequestBody LoyaltyReward loyaltyReward)
    {
        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findAll();
    }

    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT)
    public void update(@RequestBody LoyaltyReward loyaltyReward, @PathParam( "id") Integer id)
    {
        loyaltyRewardRepo.save(loyaltyReward);
    }

    @RequestMapping(value = "/CheckDates", method=RequestMethod.PUT)
    public ResponseEntity checkDates(@RequestBody LoyaltyReward loyaltyReward) {

        Timestamp startDate = loyaltyReward.getStartDate();
        Timestamp endDate  = loyaltyReward.getEndDate();
        int retailerid =  loyaltyReward.getRetailerid();

        List<LoyaltyReward> starts = loyaltyRewardRepo.findByRetaileridAndStartDateBetween( retailerid, startDate, endDate);
        List<LoyaltyReward> ends   = loyaltyRewardRepo.findByRetaileridAndEndDateBetween(retailerid, startDate, endDate);
        List<LoyaltyReward> mixed  = loyaltyRewardRepo.findByRetaileridAndStartDateLessThanEqualAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndEndDateGreaterThanEqual(retailerid, startDate, endDate, startDate, endDate);

        int adjust = 0;
        Timestamp newStart = startDate;
        if (starts.size() > 0 ) {
            if (starts.get(0).getLoyaltyRewardid() == loyaltyReward.getLoyaltyRewardid())
                adjust -= 1;
            newStart = starts.get(0).getEndDate();
        }
        if (ends.size() > 0) {
            if (ends.get(0).getLoyaltyRewardid() == loyaltyReward.getLoyaltyRewardid())
                adjust -= 1;
            newStart = ends.get(0).getEndDate();
        }
        if (mixed.size() > 0) {
            if (mixed.get(0).getLoyaltyRewardid() == loyaltyReward.getLoyaltyRewardid())
                adjust -= 1;
            newStart = mixed.get(0).getEndDate();
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newStart);
        calendar.add(Calendar.HOUR, 24);
        Timestamp newDateNextDay = new Timestamp(calendar.getTimeInMillis());

        int total = starts.size() + ends.size() + mixed.size()  + adjust;

        if ( total == 0) {
            respMap.put("message","No Loyalty Reward record found covering these dates");
            respMap.put("httpStatus",""+httpStatus);
            respMap.put("success","1");

        } else {
            respMap.put( "earliestStartDate",newDateNextDay.toString());
            respMap.put( "message", "Loyalty Reward record already exists covering all or part of this period" );
            respMap.put( "success", "0" );
            respMap.put( "httpStatus", "" + httpStatus );

        }
        return new ResponseEntity<>(respMap, httpStatus);
    }

    @RequestMapping(value = "/create/default/{id}", method=RequestMethod.GET)
    public Collection<LoyaltyReward> create(@PathVariable ("id") int id) {

        // init dates
        Timestamp startDate = new Timestamp( System.currentTimeMillis( ) );
        Timestamp endDate   = new Timestamp( System.currentTimeMillis( ) );
        Timestamp today = startDate;

        // retrieve list of loyaltyRewards for this retailer sorted by start date
        List<LoyaltyReward> loyaltyRewards = loyaltyRewardRepo.findAllByRetaileridAndEndDateAfterOrderByStartDate(id, today);

        if (loyaltyRewards.size() == 0) { // no record exists
            startDate = today;

        } else if (loyaltyRewards.size() == 1) { // only one record exists // start date is set one day after the enddate
            if (compareDates(startDate, loyaltyRewards.get(0).getStartDate()) >= 0 )
                startDate = addDate(loyaltyRewards.get(0).getEndDate(),1,"day");

        } else { //multiple records found
            for(LoyaltyReward loyaltyReward: loyaltyRewards) {
                if (compareDates(startDate, loyaltyReward.getStartDate()) < 0)
                    break;
                startDate = addDate(loyaltyReward.getEndDate(),1,"day");
            }
        }

        LoyaltyReward loyaltyReward = new LoyaltyReward(); // sets some default values
        loyaltyReward.setStartDate( startDate); // add next date which is valid
        loyaltyReward.setEndDate( addDate(startDate, 1,"day"));
        loyaltyReward.setRetailerid( id );

        loyaltyRewardRepo.save(loyaltyReward);

        return loyaltyRewardRepo.findAllByRetailerid( id );
    }



}