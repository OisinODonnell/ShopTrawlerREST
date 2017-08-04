package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "RetailerBlock", method= RequestMethod.GET)
public class RetailerBlockController extends MainController {




    // Queries involving more than one entity
    @RequestMapping(value = "/{retailerid}/{userid}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> getRetailerBlock(@PathVariable("retailerid") Integer retailerid,
                                                                   @PathVariable("userid") Integer userid)      throws JsonProcessingException {


        respMap = new HashMap<>();

        // retrieve the data to build into the RetailerBlock
        Retailer retailer = retailerRepo.findByRetailerid(retailerid);
        Collection<Content> contents = contentRepo.findAllByRetailerid(retailerid);
        Collection<LoyaltyReward> loyaltyAwards = loyaltyRewardRepo.findAllByRetailerid(retailerid);
        UserPoint userPoints = userPointRepo.findByRetaileridAndUserid(userid, retailerid);

        RetailerBlock rb = new RetailerBlock(retailer);

        String rbJson = mapper.writeValueAsString(rb);
        respMap.put("RetailerBlock",rbJson);


        // return collections
        return new ResponseEntity<>(respMap, httpStatus);
    }
}
