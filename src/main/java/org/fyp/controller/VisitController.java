package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


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
    final long ONE_DAY   = 100 * 60 * 60 * 24 * 10;
    final long ONE_WEEK  = ONE_DAY  *  7;
    final long WEEKS_12  = ONE_WEEK * 12 ;
    final long DAYS_12   = ONE_DAY  * 12 ;
    final long ONE_MONTH = ONE_WEEK * 52 / 12;
    final long YEAR      = ONE_WEEK * 52 ;

    final int DAY   = 1;
    final int WEEK  = 2;
    final int MONTH = 3;

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



    @RequestMapping(value = "/Report/Admin/Day", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportAdminDay() {
        return getRetailerCounts( retailerRepo.findAll(), getStartTime(DAY), ONE_DAY); }
    @RequestMapping(value = "/Report/Admin/Week", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportAdminWeek() {
        return getRetailerCounts( retailerRepo.findAll(), getStartTime(WEEK), ONE_WEEK); }
    @RequestMapping(value = "/Report/Admin/Month", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportAdminMonth() {
        return getRetailerCounts( retailerRepo.findAll(), getStartTime(MONTH), ONE_MONTH); }

    public Collection<VisitChart> getRetailerCounts(Retailer retailer, long startTimeOfAnalysis,  long timeSpan) {

        Collection<Retailer> retailers = new ArrayList<>(  );
        retailers.add( retailer );

        return getRetailerCounts( retailerRepo.findAll(), getStartTime(DAY), ONE_DAY);
    }



    public Collection<VisitChart> getRetailerCounts(Collection<Retailer> retailers, long startTimeOfAnalysis,  long timeSpan) {

        long                   endTime     = 0;
        String                 formatOut   = "dd-MMM-yyyy";
        Calendar               calendar    = Calendar.getInstance();
        SimpleDateFormat       formatter   = new SimpleDateFormat(formatOut);
        Collection<VisitChart> visitCharts = new ArrayList<>();
        long                   startTime   = startTimeOfAnalysis;

        for ( Retailer retailer: retailers ) {

            VisitChart vChart     = new VisitChart();

            vChart.setStoreName( retailer.getStoreName() );
            vChart.setRetailerid( retailer.getRetailerid() );
            endTime = startTime;

            for (int period = 0 ; period < 12 ; period++) {
                endTime += timeSpan;

                int count = visitRepo.countByZoneidAndEntryTimeBetween( retailer.getRetailerid(), new Timestamp( startTime ), new Timestamp( endTime ) );
                calendar.setTimeInMillis(startTime);
                String startDateStr = formatter.format(calendar.getTime());

                vChart.add(count, startDateStr );
                startTime = endTime;

            }
            startTime = startTimeOfAnalysis;
            visitCharts.add(vChart);
        }
        return visitCharts;
    }

    @RequestMapping(value = "/Report/Retailer/Day/{id}", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportRetailerDay(@PathVariable("id") int id) {
        return getRetailerCounts( retailerRepo.findAllByRetailerid(id), getStartTime(DAY), ONE_DAY); }
    @RequestMapping(value = "/Report/Retailer/Week/{id}", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportRetailerWeek(@PathVariable("id") int id) {
        return getRetailerCounts( retailerRepo.findAllByRetailerid(id), getStartTime(WEEK), ONE_WEEK); }
    @RequestMapping(value = "/Report/Retailer/Month/{id}", method=RequestMethod.GET)
    public Collection<VisitChart> visitReportRetailerMonth(@PathVariable("id") int id) {
        return getRetailerCounts( retailerRepo.findAllByRetailerid(id), getStartTime(MONTH), ONE_MONTH); }

    public Long getStartTime(int duration) {
        long timeNow   = System.currentTimeMillis();
        long start ;

        if (duration == 1)  // 1 = day, 2 = week, 3 = month
            start = DAYS_12;
        else if (duration == 2)
            start = WEEKS_12;
        else
            start = YEAR;

        return timeNow - start;
    }
}
