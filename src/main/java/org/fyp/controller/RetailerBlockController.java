package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;


@RestController
@RequestMapping( value = "RetailerBlock", method = RequestMethod.GET )
public class RetailerBlockController extends MainController {


    // Queries involving more than one entity
    @RequestMapping( value = "/{retailerid}/{userid}", method = RequestMethod.GET )
    @ResponseBody
    public RetailerBlock
    /* public ResponseEntity<HashMap<String, String>> */ getRetailerBlock( @PathVariable( "retailerid" ) Integer retailerid,
                                                                     @PathVariable( "userid" ) Integer userid ) throws JsonProcessingException {
        // retrieve the data to build into the RetailerBlock
        Timestamp currentTime = new Timestamp( System.currentTimeMillis( ) );
        RetailerBlock rb = new RetailerBlock( );

        Retailer retailer = retailerRepo.findByRetailerid( retailerid );

        if (retailer != null) {
            // only grab the extra content if retailer exists
            Content       content       = contentRepo.findByRetaileridAndStartDateBeforeAndEndDateAfter( retailerid, currentTime, currentTime );
            LoyaltyReward loyaltyReward = loyaltyRewardRepo.findByRetaileridAndStartDateBeforeAndEndDateAfter( retailerid, currentTime, currentTime );
            UserPoint     userPoints    = userPointRepo.findByRetaileridAndUserid( userid, retailerid );

            User user = userRepo.findByUserid(userid);

            // create new RetailerBlock
            rb.update( retailer );
            rb.update( content );
            rb.update( loyaltyReward );
            rb.update( userPoints );
            rb.update( user );
        } else {
            rb = null;
        }

        return rb;
    }
}

