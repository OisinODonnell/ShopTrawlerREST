package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Visits","Visit"}, method= RequestMethod.GET)
public class VisitController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Visit visit) { visitRepo.save(visit);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Visit> read()
    {
        return visitRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Visit visit) { visitRepo.save(visit); }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Visit visit)     {  visitRepo.delete(visit);    }

}
