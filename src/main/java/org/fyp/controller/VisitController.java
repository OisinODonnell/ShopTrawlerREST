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

    private final int pointsPerVisit = 10;
    private final String rewardImage = "Reward Image";
    private final String rewardTitle = "Reward Title";
    private final int visitTime = 10;

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Visit>  create(@RequestBody Visit visit) {
        visitRepo.save(visit);
        return visitRepo.findAll();
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public Collection<Visit>  add(@RequestBody Visit visit) {

        int retailerid = visit.getZoneid();

        // get duration of visit
        Timestamp enter = visit.getEntryTime();
        Timestamp exit = visit.getExitTime();
        long diff = exit.getTime() - enter.getTime();
        int duration = (int) (diff / (60 * 1000));
        visit.setDuration(duration);
        visitRepo.save(visit);

        // add visit points if appropriate

        int visitTime = getVisitTime(visit);
        int points = getPointsPerVisit(visit);
        if (duration >= visitTime) {
            UserPoint up = userPointRepo.findByRetaileridAndUserid(visit.getZoneid(), visit.getUserid());
            up.add(points);
            userPointRepo.save(up);
        }

        return visitRepo.findAll();
    }

    private int getPointsPerVisit(Visit visit) {
        Timestamp currentTime = new Timestamp( System.currentTimeMillis( ) );
        LoyaltyReward loyaltyReward = loyaltyRewardRepo.findByRetaileridAndStartDateBeforeAndEndDateAfter(visit.getZoneid(),currentTime, currentTime );

        if (loyaltyReward != null) {
            return loyaltyReward.getPointsPerVisit();
        } else {
            return 10;
        }
    }

    private int getVisitTime(Visit visit) {
        Timestamp currentTime = new Timestamp( System.currentTimeMillis( ) );
        LoyaltyReward loyaltyReward = loyaltyRewardRepo.findByRetaileridAndStartDateBeforeAndEndDateAfter(visit.getZoneid(),currentTime, currentTime );

        if (loyaltyReward != null) {
            return loyaltyReward.getVisitTime();
        } else {
            return 10;
        }
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Visit> read() { return visitRepo.findAll(); }

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


    /**
     * 1. Admin create a count of visitors to each retailer each month for the past 12 months
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

    @RequestMapping(value = "/Report/Gender/Admin", method=RequestMethod.GET)
    public Collection<GenderChart> getVisitsByRetailerAndGender() {
        Collection<GenderChart> genderCharts = new ArrayList<>();
        Collection<Retailer>    retailers    = retailerRepo.findAll();

        for (Retailer retailer : retailers) {

            GenderChart gc = getVisitsByRetailerAndGender( retailer.getRetailerid());
            genderCharts.add( gc);
        }
        return genderCharts;
    }
    @RequestMapping(value = "/Report/Gender/Retailer/{id}", method=RequestMethod.GET)
    public GenderChart getVisitsByRetailerAndGender( @PathVariable( "id") Integer id) {

        Retailer          retailer    = retailerRepo.findByRetailerid(id);
        GenderChart       genderChart = new GenderChart();
        Collection<Visit> visits      = visitRepo.findAllByZoneid(retailer.getRetailerid());
        genderChart.setRetailerid( retailer.getRetailerid());
        genderChart.setStoreName( retailer.getStoreName());

        int males = 0;
        int females = 0;

        for (Visit visit : visits) {
            User user = userRepo.findByUserid(visit.getUserid());
            if (user.getGender().equals("Male")) {
                males ++;
            } else {
                females ++;
            }
        }
        genderChart.setFemaleCount( females);
        genderChart.setMaleCount( males);

        return genderChart;
    }

    @RequestMapping(value = "/Report/Age/Admin", method=RequestMethod.GET)
    public Collection<AgeChart> getVisitsByAge() {

        Collection<AgeChart> ageCharts = new ArrayList<>();
        for (Retailer retailer : retailerRepo.findAll()) {
            ageCharts.add( getVisitsByAgeRetailer( retailer.getRetailerid()) );
        }
        return ageCharts;
    }

    /**
     *
     * @param id
     * @return age counts by age bracket and gender
     */
    @RequestMapping(value = "/Report/Age/Retailer/{id}", method=RequestMethod.GET)
    public AgeChart getVisitsByAgeRetailer( @PathVariable( "id") int id) {
        Collection<Visit> visits   = visitRepo.findAllByZoneid(id);
        AgeChart          ageChart = new AgeChart();
        int               thisYear = Calendar.getInstance().get(Calendar.YEAR);

        Retailer retailer = retailerRepo.findByRetailerid(id);
        ageChart.setRetailerid( id);
        List<Integer> counts = new ArrayList<>();
        List<Integer> females = new ArrayList<>();
        List<Integer> males = new ArrayList<>();
        ageChart.setStoreName( retailer.getStoreName());

        // initilise count collector arrarys
        for (int i = 0; i< 8;i++) {
            counts.add(0);
            females.add(0);
            males.add(0);
        }

        // init temp count holders
        int count = 0;
        int genderCount = 0;

        for (Visit visit : visits) {
            User user = userRepo.findByUserid(visit.getUserid());
            int userYob = user.getYob();
            String gender = user.getGender();

            int age = thisYear - userYob;
            if ( age > 80 ) {
                count = counts.get(7) + 1;
                counts.set(7,count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(7) + 1;
                    males.set(7,genderCount);
                } else {
                    genderCount = females.get(7) + 1;
                    females.set(7,genderCount);
                }

            } else if (age > 70) {
                count = counts.get(6) + 1;
                counts.set(6, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(6) + 1;
                    males.set(6,genderCount);
                } else {
                    genderCount = females.get(6) + 1;
                    females.set(6,genderCount);
                }
            } else if (age > 60) {
                count = counts.get(5) + 1;
                counts.set(5, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(5) + 1;
                    males.set(5,genderCount);
                } else {
                    genderCount = females.get(5) + 1;
                    females.set(5,genderCount);
                }
            } else if (age > 50) {
                count = counts.get(4) + 1;
                counts.set(4, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(4) + 1;
                    males.set(4,genderCount);
                } else {
                    genderCount = females.get(4) + 1;
                    females.set(4,genderCount);
                }
            } else if (age > 40) {
                count = counts.get(3) + 1;
                counts.set(3, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(3) + 1;
                    males.set(3,genderCount);
                } else {
                    genderCount = females.get(3) + 1;
                    females.set(3,genderCount);
                }
            } else if (age > 30) {
                count = counts.get(2) + 1;
                counts.set(2, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(2) + 1;
                    males.set(2,genderCount);
                } else {
                    genderCount = females.get(2) + 1;
                    females.set(2,genderCount);
                }
            } else if (age > 20) {
                count = counts.get(1) + 1;
                counts.set(1, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(1) + 1;
                    males.set(1,genderCount);
                } else {
                    genderCount = females.get(1) + 1;
                    females.set(1,genderCount);
                }
            } else { // must bve < 20
                count = counts.get(0) + 1;
                counts.set(0, count);
                if (user.getGender().equals("Male")) {
                    genderCount = males.get(0) + 1;
                    males.set(0,genderCount);
                } else {
                    genderCount = females.get(0) + 1;
                    females.set(0,genderCount);
                }
            }

        }
        ageChart.setCounts( counts);
        ageChart.setFemaleCounts( females);
        ageChart.setMaleCounts( males);

        return ageChart;
    }



    public Collection<VisitChart> getRetailerCounts(Retailer retailer, long startTimeOfAnalysis,  long timeSpan) {

        Collection<Retailer> retailers = new ArrayList<>(  );
        retailers.add( retailer );

        return getRetailerCounts( retailerRepo.findAll(), getStartTime(DAY), ONE_DAY);
    }


    /**
     * This is the main data collector for counting visits
     * for each retailer, determine the start and end of first period,
     * count all the data found between these two endpoints,
     * add to array.
     * @param retailers
     * @param startTimeOfAnalysis
     * @param timeSpan
     * @return
     */
    public Collection<VisitChart> getRetailerCounts(Collection<Retailer> retailers,
                                                    long startTimeOfAnalysis,
                                                    long timeSpan) {

        long                   endTime     = 0;
        String                 formatOut   = "dd-MMM-yyyy";
        Calendar               calendar    = Calendar.getInstance();
        SimpleDateFormat       formatter   = new SimpleDateFormat(formatOut);
        Collection<VisitChart> visitCharts = new ArrayList<>();
        long                   startTime   = startTimeOfAnalysis;

        for ( Retailer retailer: retailers ) {

            VisitChart vChart     = new VisitChart();

            // pickup the storeName from the retailerid and add to visit chart
            vChart.setStoreName( retailer.getStoreName() );
            vChart.setRetailerid( retailer.getRetailerid() );
            endTime = startTime;

            /**
             * timespan = 1Day / Week or Month
             * count the data between two time points
             * add the details to the chart
             * next period.
             */

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

    /**
     * @param period
     * @return determine the start date of the analysis based on whether its a Day Week or Month
     * period passed in
     */
    public Long getStartTime(int period) {
        long timeNow   = System.currentTimeMillis();
        long start ;

        if (period == 1)  // 1 = day, 2 = week, 3 = month
            start = DAYS_12;
        else if (period == 2)
            start = WEEKS_12;
        else
            start = YEAR;

        return timeNow - start;
    }












}
