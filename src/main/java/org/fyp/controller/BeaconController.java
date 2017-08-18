package org.fyp.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/07/2017.
 */

@RestController
@RequestMapping(value = {"Beacons","Beacon"})
public class BeaconController extends MainController{



    @RequestMapping(value = "/loadData", method=RequestMethod.GET)
    public Collection<Beacon> loadTestData() throws Exception {

        // The order of import is important to ensure data integrity
        // load some sample data to facilitate some testing

        loadData(new User()    		 , util.USERS            );
        loadData(new ShoppingCentre(), util.SHOPPING_CENTRE );
        loadData(new Location()   	 , util.LOCATIONS        );
        loadData(new Beacon()     	 , util.BEACONS          );
        loadData(new Zone()    		 , util.ZONES            );
        loadData(new Retailer()   	 , util.RETAILERS        );
        loadData(new Content()		 , util.CONTENT          );
        loadData(new Visit()    	 , util.VISITS           );
        loadData(new UserPoint()     , util.USER_POINTS      );
        loadData(new Favourite()	 , util.FAVOURITES       );
        loadData(new LoyaltyReward() , util.LOYALTY_REWARDS  );
        loadData(new BonusCode()     , util.BONUS_CODES      );
        loadData(new Rating()        , util.RATINGS          );

        return beaconRepo.findAll();
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<Beacon> create(@RequestBody Beacon beacon)   {
        beaconRepo.save(beacon);
        return beaconRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Beacon> read() {
        return beaconRepo.findAll();
    }

    @RequestMapping(value = "/{beaconId}", method = RequestMethod.GET)
    public Beacon getBeacon(  @PathVariable("beaconId") int beaconId) throws ParseException {
        return beaconRepo.findByBeaconid( beaconId );

    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Beacon> update(@RequestBody Beacon beacon)
    {

        beaconRepo.save(beacon);
        return beaconRepo.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Beacon> delete(@PathVariable ("id") Integer id)    {
        beaconRepo.deleteByBeaconid(id);
        return beaconRepo.findAll();
    }

}