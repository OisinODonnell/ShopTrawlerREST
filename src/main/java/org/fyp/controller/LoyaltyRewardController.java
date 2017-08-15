package org.fyp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by oisin on 18/07/2017.
 */



@RestController
@RequestMapping(value = {"LoyaltyRewards","LoyaltyReward"}, method=RequestMethod.GET)
public class LoyaltyRewardController extends MainController {


    @RequestMapping(value = "/ForApproval", method=RequestMethod.GET)
    public Collection<LoyaltyReward> forApproval() {
        return loyaltyRewardRepo.findAllByApproved(False);
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public Collection<LoyaltyReward> create(@RequestBody LoyaltyReward loyaltyReward)
    {

        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<LoyaltyReward> read() throws JsonProcessingException {
        return loyaltyRewardRepo.findAll(); }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<LoyaltyReward> update(@RequestBody LoyaltyReward loyaltyReward)
    {

        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<LoyaltyReward> delete(@PathVariable ("id") Integer id)     {
        loyaltyRewardRepo.deleteByLoyaltyRewardid(id);
        return loyaltyRewardRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public LoyaltyReward findById(@PathVariable("id") Integer id) {
        return loyaltyRewardRepo.findByLoyaltyRewardid(id);
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<LoyaltyReward> findAllByRetailerId(@PathVariable("id") Integer id) {
        return loyaltyRewardRepo.findAllByRetailerid(id); }


    @RequestMapping(value = "/approve", method=RequestMethod.PUT)
    public Collection<LoyaltyReward> approve(@RequestBody LoyaltyReward loyaltyReward)
    {
        loyaltyRewardRepo.save(loyaltyReward);
        return loyaltyRewardRepo.findAll();
    }

    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT)
    public void update(@RequestBody LoyaltyReward loyaltyReward, @PathParam( "id") Integer id)
    {
        loyaltyRewardRepo.save(loyaltyReward);
    }

}