package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


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
