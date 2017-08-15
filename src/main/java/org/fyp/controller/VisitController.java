package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Created by oisin on 18/07/2017.
 *
  TODO : Create breakdwon by Gender - Retailer
  TODO : Create beakdown by Age - Retailer
  TODO : Create admin breakdown by retailer day/week/month.

 *
 */

@RestController
@RequestMapping(value = {"Visits","Visit"}, method= RequestMethod.GET)
public class VisitController extends MainController {

    // time constants
    long oneDay   = 100          * 60 * 60 * 24;
    long oneWeek  = oneDay       *  7;
    long weeks12  = oneWeek      * 12;
    long days12   = oneDay       * 12;
    long oneMonth = oneWeek * 52 / 12;
    long year     = oneWeek      * 52;


    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Visit>  create(@RequestBody Visit visit) {
        visitRepo.save(visit);
        return visitRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Visit> read()
    {

        return visitRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Visit>  update(@RequestBody Visit visit) {
        visitRepo.save(visit);
        return visitRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public Collection<Visit>  delete(@RequestBody Visit visit)     {
        visitRepo.delete(visit);
        return visitRepo.findAll();
    }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Visit> listByUser(@PathVariable ("id") Integer id)
    {
        return visitRepo.findAllByUserid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Visit> listByRetailer(@PathVariable ("id") Integer id)
    {
        return visitRepo.findAllByZoneid(id);
    }


    /*
    TODO: These two need addition work, determine exactly what should be returned.
    eg Male : qty, Femail Qty
    < 15 : qty
    16 - 20 : qty
    21 - 25 : qty etc
     */


//    @RequestMapping(value = "/User/Age", method=RequestMethod.GET)
//    public Collection<Visit> listByAge(@PathVariable ("id") Integer id)
//    {
//        return visitRepo.findAllByAge(id);
//    }
//
//    @RequestMapping(value = "/User/Gender", method=RequestMethod.GET)
//    public Collection<Visit> listByGender()
//    {
//        return visitRepo.findAllByGender();
//    }


    /**
     * 1. Admin create a count of visitors to each retailer each m onth for the past 12 months
     * 2. Retailer : Create a Monthly count for past 12 months, past 12weeks, past 12 days
     */



    public void countByRetailerByLast12Months(int id) {

        Retailer retailer        = retailerRepo.findByRetailerid(id);
        int      duration        = 3;
        long     timeNow         = System.currentTimeMillis();
        long     twelveMonthsAgo = timeNow - year;
        long     startTime       = twelveMonthsAgo;

        List<VisitCount> visitCounts = getCounts(id,retailer.getStoreName(), startTime, duration );


    }
    public void countByRetailerByLast12Weeks(int id) {

        // WeekOf / Retailer / visits;
        Retailer         retailer       = retailerRepo.findByRetailerid(id);
        int              duration       = 2;
        long             timeNow        = System.currentTimeMillis();
        long             TwelveWeeksAgo = timeNow - weeks12;
        long             startTime      = TwelveWeeksAgo;

        List<VisitCount> visitCounts = getCounts(id,retailer.getStoreName(), startTime, duration );

    }
    public void countByRetailerByLast12Days(int id) {
        Retailer         retailer       = retailerRepo.findByRetailerid(id);
        int              duration       = 1;
        long             timeNow        = System.currentTimeMillis();
        long             TwelveDaysAgo  = timeNow - (oneDay * 12);
        long             startTime      = TwelveDaysAgo;

        List<VisitCount> visitCounts = getCounts(id,retailer.getStoreName(), startTime, duration );


    }

    private List<VisitCount> getCounts(int id, String name, long startTime, int duration) {

        List<VisitCount> visitCounts = new ArrayList<>();
        long period = 0;
        int count = 0;

        if (duration == 1)  // 1 = day, 2 = week, 3 = month
            period = oneDay;
        else if (duration == 2)
            period = oneWeek;
        else
            period = oneMonth;


        for (int i = 0; i < 12; i++) {

            long      endTime   = startTime + period;
            Timestamp startDate = new Timestamp(startTime);
            Timestamp endDate   = new Timestamp(endTime  );
            count               = visitRepo.countAllBetweenDateAndDate(startDate, endDate);
            VisitCount vc       = new VisitCount(startDate, id, name, duration, count);
            visitCounts.add(vc);
            startTime = endTime;
        }
        return visitCounts;
    }


}
