package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */



@RestController
@RequestMapping(value = "LoyaltyRewards", method=RequestMethod.GET)
public class LoyaltyRewardController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(LoyaltyReward loyaltyReward)
    {
        loyaltyRewardRepo.save(loyaltyReward);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<LoyaltyReward> read() throws JsonProcessingException {
        return loyaltyRewardRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(LoyaltyReward loyaltyReward)
    {
        loyaltyRewardRepo.save(loyaltyReward);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(LoyaltyReward loyaltyReward)
    {
        loyaltyRewardRepo.delete(loyaltyReward);
    }

}