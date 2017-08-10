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
@RequestMapping(value = {"Content","Contents"}, method= RequestMethod.GET)
public class ContentController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public Collection<Content> create(Content content) {
        contentRepo.save(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Content> read() {
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public Collection<Content> update(Content content) {
        contentRepo.save(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<Content> delete(Content content)     {
        contentRepo.delete(content);
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/Retailer/{id}", method=RequestMethod.GET)
    public Collection<Content> findAllByRetailerId(@PathVariable("id") Integer id) {
        Collection<Content> contents = contentRepo.findAllByRetailerid(id);
        return contents; // contentRepo.findAllByRetailerid(id);
    }

}
