package org.fyp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import org.fyp.model.*;
import org.fyp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = {"Main"}, method= RequestMethod.GET)
public abstract class MainController {

    // setup references to the repositores used by all the controllers
    @Autowired    BeaconRepository          beaconRepo;
    @Autowired    BonusCodeRepository       bonusCodeRepo;
    @Autowired    ContentRepository         contentRepo;
    @Autowired    FavouriteRepository       favouriteRepo;
    @Autowired    LocationRepository        locationRepo;
    @Autowired    LoyaltyRewardRepository   loyaltyRewardRepo;
    @Autowired    RatingRepository          ratingRepo;
    @Autowired    RetailerRepository        retailerRepo;
    @Autowired    ShoppingCentreRepository  shoppingCentreRepo;
    @Autowired    UserRepository            userRepo;
	@Autowired    UserPointRepository       userPointRepo;
	@Autowired    VisitRepository           visitRepo;
    @Autowired    ZoneRepository            zoneRepo;
    @Autowired    ImageRepository           imageRepo;

    // used to convert an object into json.
    ObjectMapper mapper = new ObjectMapper();
    //Object to JSON in String
    // eg; String jsonInString = mapper.writeValueAsString(obj);

    Gson gson = new Gson();
    HttpStatus httpStatus = HttpStatus.OK;
    Util util = new Util(); // singleton

    // response object for building up a response to the user
    HashMap<String, String> respMap = new HashMap<>();

    // used when setting byte values in entities
    final byte True = 1;
    final byte False = 0;


    /*
    Using Generics to determine what type of opbects to create
     */


    @SuppressWarnings("unchecked")
    public <E> void loadData(E item, String file) throws Exception {

        // read csv file into an array or arrays
        List<List<String>> records = util.readCSV(file);

        String className = item.getClass().toString();

        // add records to list
        for (List<String> attributes : records)

            switch (className) {
                case "class org.fyp.model.Beacon":
                    beaconRepo.save(new Beacon(attributes));
                    break;
                case "class org.fyp.model.BonusCode":
                    bonusCodeRepo.save(new BonusCode(attributes));
                    break;
                case "class org.fyp.model.Content":
                    contentRepo.save(new Content(attributes));
                    break;
                case "class org.fyp.model.Favourite":
                    favouriteRepo.save( new Favourite(attributes));
                    break;
                case "class org.fyp.model.Location":
                    locationRepo.save( new Location(attributes));
                    break;
                case "class org.fyp.model.LoyaltyReward":
                    loyaltyRewardRepo.save( new LoyaltyReward(attributes));
                    break;
                case "class org.fyp.model.Rating":
                    ratingRepo.save( new Rating(attributes));
                    break;
                case "class org.fyp.model.Retailer":
                    retailerRepo.save( new Retailer(attributes));
                    break;
                case "class org.fyp.model.ShoppingCentre":
                    shoppingCentreRepo.save( new ShoppingCentre(attributes));
                    break;
                case "class org.fyp.model.User":
                    userRepo.save( new User(attributes));
                    break;
                case "class org.fyp.model.UserPoint":
                    userPointRepo.save( new UserPoint(attributes));
                    break;
                case "class org.fyp.model.Visit":
                    visitRepo.save( new Visit(attributes));
                    break;
                case "class org.fyp.model.Zone":
                    zoneRepo.save( new Zone(attributes));
                    break;
            }

    }
    // Command Pattern
    public <T> T getRepo(Callable<T> func) throws Exception {

        return func.call();
    }
    public Integer compareDates(Timestamp date1, Timestamp date2) {

        String           formatOut = "dd-MMM-yyyy";
        Calendar         dateA     = Calendar.getInstance();
        Calendar         dateB     = Calendar.getInstance();
        SimpleDateFormat df        = new SimpleDateFormat( formatOut);

        int comparison = 0;

        // reset time to enable day comparisons to succeed
        dateA.setTimeInMillis(date1.getTime());
        dateA.set(Calendar.HOUR_OF_DAY, 0);
        dateA.set(Calendar.MINUTE, 0);
        dateA.set(Calendar.SECOND, 0);
        dateA.set(Calendar.MILLISECOND, 0);
        dateB.setTimeInMillis(date2.getTime());
        dateB.set(Calendar.HOUR_OF_DAY, 0);
        dateB.set(Calendar.MINUTE, 0);
        dateB.set(Calendar.SECOND, 0);
        dateB.set(Calendar.MILLISECOND, 0);

        // not quite right yet, but will do for now.
        // will not respond well when dates are within same day, at least not what I wat.

        if (dateA.compareTo( dateB )  == 0 ) comparison =  0;
        if (dateA.compareTo( dateB )  <  0 ) comparison =  -1;
        if (dateA.compareTo( dateB )  >  0 ) comparison =  1;

        return comparison;
    }

    public Timestamp getTimeStamp() {
        java.util.Date date = new java.util.Date();
        // omit milliseconds
        long time = 1000 * (date.getTime()/ 1000);
        date.setTime(time);

        return new java.sql.Timestamp(date.getTime());
    }

    public void uploadFile(String path) {

        /*
        filename = <fileid>.png
        locate and return file
         */
    }

    public Integer saveFile(String path, String filename) {
        Integer id = 0;
        /*
        upload fils from path/filename.png (only png accepted
        create entry in imageDb
        get image id
        save as <id>.png

         */

        return id;
    }

    public Timestamp addDate(Timestamp start , int quantity, String type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);

        switch(type) {
            case "minute" :
                cal.add(Calendar.MINUTE, 1);
                break;
            case "hour" :
                cal.add(Calendar.HOUR_OF_DAY, 1);
                break;
            case "day":
                cal.add(Calendar.DATE, 1);
                break;
            case "week" :
                cal.add(Calendar.DATE, 7);
                break;
            case "month":
                cal.add(Calendar.MONTH, 1);
                break;
            case "year":
                cal.add(Calendar.YEAR, 1);
                break;

        }

        return new Timestamp(cal.getTimeInMillis());

    }


}
