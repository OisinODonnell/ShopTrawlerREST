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
@RequestMapping(value = {"Zones","Zone"}, method=RequestMethod.GET)
public class ZoneController extends MainController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Collection<Zone> create(Zone zone) {
        zoneRepo.save(zone);
        return zoneRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method = RequestMethod.GET)
    public Collection<Zone> read() throws JsonProcessingException {

        return zoneRepo.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Collection<Zone> update(Zone zone) {
        zoneRepo.save(zone);
        return zoneRepo.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Collection<Zone> delete(Zone zone) {
        zoneRepo.delete(zone);
        return zoneRepo.findAll();
    }

}