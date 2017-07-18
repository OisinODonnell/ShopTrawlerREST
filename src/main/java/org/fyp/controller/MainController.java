package org.fyp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fyp.model.*;
import org.fyp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public abstract class MainController {

    @Autowired
    BeaconRepository beaconRepo;
    @Autowired
    BonusCodeRepository bonusCodeRepo;
    @Autowired
    ContentRepository contentRepo;
    @Autowired
    FavouriteRepository favouriteRepo;
    @Autowired
    LocationRepository locationRepo;
    @Autowired
    LoyaltyRewardRepository loyaltyRewardRepo;
    @Autowired
    RatingRepository ratingRepo;
    @Autowired
    RetailerRepository retailerRepo;
    @Autowired
    ShoppingCentreRepository shoppingCentreRepo;
    @Autowired
    UserRepository userRepo;
	@Autowired
    UserPointRepository userPointRepo;
	@Autowired
    VisitRepository visitRepo;
	@Autowired
    ZoneRepository zoneRepo;

    ObjectMapper mapper = new ObjectMapper();


    Util util = new Util(); // singleton

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
                case "class org.fyp.model.BonusPoint":
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

}
