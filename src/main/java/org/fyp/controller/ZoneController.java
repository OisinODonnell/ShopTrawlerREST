package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"Zones","Zone"}, method=RequestMethod.GET)
public class ZoneController extends MainController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Collection<Zone> create(@RequestBody Zone zone) {
        zoneRepo.save(zone);
        return zoneRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method = RequestMethod.GET)
    public Collection<Zone> read() throws JsonProcessingException {
        return zoneRepo.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Collection<Zone> update(@RequestBody Zone zone) {
        zoneRepo.save(zone);
        return zoneRepo.findAll();
    }
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Zone> delete(@PathVariable ("id") Integer id)     {
        zoneRepo.deleteByZoneid(id);
        return zoneRepo.findAll();
    }

}