package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping(value = "Main", method= RequestMethod.GET)
public class ComplexController extends MainController{


    // Queries involving more than one entity
    @RequestMapping(value = "/VUR", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> getVisitsUsersRetailers() throws JsonProcessingException {

        respMap = new HashMap<>();

        // retrieve data
        Collection< Visit > visits       = visitRepo.findAll();
        Collection< User > users         = userRepo.findAll();
        Collection< Retailer > retailers = retailerRepo.findAll();

        // convert to json
        String visitsStr    = mapper.writeValueAsString(visits);
        String usersStr     = mapper.writeValueAsString(users);
        String retailersStr = mapper.writeValueAsString(retailers);

        // assemble into a response map
        respMap.put ("Visits"   , visitsStr    );
        respMap.put ("Users"    , usersStr     );
        respMap.put ("Retailers", retailersStr );

        // return collections
        return new ResponseEntity<>(respMap, httpStatus);
    }
    @RequestMapping(value = "/UR", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> getUsersRetailers()     {

        respMap = new HashMap<>();

        Collection< User > users         = userRepo.findAll();
        Collection< Retailer > retailers = retailerRepo.findAll();

        Gson gson = new Gson();

        respMap.put ("Users"    , gson.toJson(users)     );
        respMap.put ("Retailers", gson.toJson(retailers) );

        return new ResponseEntity<>(respMap, httpStatus);
    }

}
