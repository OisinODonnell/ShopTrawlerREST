package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.scene.chart.Chart;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Ratings","Rating"}, method=RequestMethod.GET)
public class RatingController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<Rating> create(@RequestBody Rating rating) {
        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Rating> read() throws JsonProcessingException {
        return ratingRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Rating> update(@RequestBody Rating rating) {
        ratingRepo.save(rating);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = "/delete/{userid}/{retailerid}", method=RequestMethod.DELETE)
    public Collection<Rating> delete(@PathVariable ("userid") Integer userid,
                                     @PathVariable ("retailerid") Integer retailerid)     {
        ratingRepo.deleteByUseridAndRetailerid(userid, retailerid);
        return ratingRepo.findAll();
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Rating> findAllByRetailerId(@PathVariable("id") Integer id) {
        return ratingRepo.findAllByRetailerid(id); }

    @RequestMapping(value = "/User/{id}", method=RequestMethod.GET)
    public Collection<Rating> findAllByUserId(@PathVariable("id") Integer id) {
        return ratingRepo.findAllByUserid(id); }

    @RequestMapping(value = "/UserRetailer/{userid}/{retailerid}", method=RequestMethod.GET)
    public Rating findAllByUserRetailer(@PathVariable("userid")       Integer userid,
                                  @PathVariable("retailerid")   Integer retailerid) {
        return ratingRepo.findByUseridAndRetailerid(userid, retailerid);
    }


//    public Collection<RatingChart> getRatingCounts( Collection<Retailer> retailers, long startTimeOfAnalysis, long timeSpan) {
//
//        long                   endTime     = 0;
//        String                 formatOut   = "dd-MMM-yyyy";
//        Calendar               calendar    = Calendar.getInstance();
//        SimpleDateFormat       formatter   = new SimpleDateFormat( formatOut);
//        Collection<VisitChart> visitCharts = new ArrayList<>();
//
//        long                   startTime   = startTimeOfAnalysis;
//
//        for ( Retailer retailer: retailers ) {
//
//            VisitChart vChart     = new VisitChart();
//
//            vChart.setStoreName( retailer.getStoreName() );
//            vChart.setRetailerid( retailer.getRetailerid() );
//            endTime = startTime;
//
//            for (int period = 0 ; period < 12 ; period++) {
//                endTime += timeSpan;
//
//                int count = ratingRepo.countByZoneidAndEntryTimeBetween( retailer.getRetailerid(), new Timestamp( startTime ), new Timestamp( endTime ) );
//                calendar.setTimeInMillis(startTime);
//                String startDateStr = formatter.format(calendar.getTime());
//
//                vChart.add(count, startDateStr );
//                startTime = endTime;
//
//            }
//            startTime = startTimeOfAnalysis;
//            visitCharts.add(vChart);
//        }
//        return ratingCharts;
//    }


    
    
}