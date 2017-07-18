package org.fyp.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/03/2017.
 */

@RestController
@RequestMapping("Beacons")
public class BeaconController extends MainController{



    @RequestMapping(value = "/loadData", method=RequestMethod.GET)
    public Collection<Beacon> loadTestData() throws Exception {

        loadData(new Beacon()     	, util.BEACONS      );
        loadData(new BonusCode()    , util.BONUS_CODES       );
        loadData(new Content()		, util.CONTENT  );
        loadData(new Favourite()	, util.FAVOURITES);
        loadData(new Location()   	, util.LOCATIONS    );
        loadData(new LoyaltyReward(), util.LOYALTY_REWARDS  );
        loadData(new Rating()       , util.RATINGS         );
        loadData(new Retailer()   	, util.RETAILERS    );
        loadData(new ShoppingCentre(), util.SHOPPING_CENTRE          );
        loadData(new User()    		, util.USERS     );
        loadData(new UserPoint()    , util.USER_POINTS     );
        loadData(new Visit()    	, util.VISITS     );
        loadData(new Zone()    		, util.ZONES     );

        return beaconRepo.findAll();
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Beacon beacon)   { beaconRepo.save(beacon);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Beacon> read()
    {
        Collection<Beacon>  beacons = beaconRepo.findAll();

        return beacons;
    }

    @RequestMapping(value = "/{beaconId}", method = RequestMethod.GET)
    public Beacon getBeacon(  @PathVariable("beaconId") int beaconId) throws ParseException {
        Beacon beacon = new Beacon();

        beacon = beaconRepo.findByBeaconId( beaconId );

        return beacon;
    }


    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Beacon beacon)
    {
        beaconRepo.save(beacon);
    }

    @RequestMapping(value = "/delete/", method=RequestMethod.GET)
    public void delete(Beacon beacon)     {  beaconRepo.delete(beacon);    }



}