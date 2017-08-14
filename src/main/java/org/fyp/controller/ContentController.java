package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */
@RestController
@RequestMapping(value = {"Content","Contents"}, method= RequestMethod.GET)
public class ContentController extends MainController {

    @RequestMapping(value = "/ForApproval", method=RequestMethod.GET)
    public Collection<Content> forApproval() {
        return contentRepo.findAllByApproved(False);
    }

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Content> create(@RequestBody Content content) {
        contentRepo.save(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Content> read() {
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Content> update(@RequestBody Content content) {
        contentRepo.save(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    public Collection<Content> delete(@RequestBody Content content)     {
        contentRepo.delete(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Content> findAllByRetailerId(@PathVariable("id") Integer id) {
        Collection<Content> contents = contentRepo.findAllByRetailerid(id);
        return contents; // contentRepo.findAllByRetailerid(id);
    }

    @RequestMapping(value = "/approve", method=RequestMethod.PUT)
    public Collection<Content> approve(@RequestBody Content content)
    {
        contentRepo.save(content);
        return contentRepo.findAll();
    }
    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT)
    public void update( @RequestBody Content content, @PathParam( "id") Integer id  ) {
        contentRepo.save(content);
    }

}
