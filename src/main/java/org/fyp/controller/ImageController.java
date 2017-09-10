package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/07/2017.
 */

@RestController
@RequestMapping(value = {"Images","Image"})
public class ImageController extends MainController{

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Image image)   { imageRepo.save(image);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Image> read() {   return imageRepo.findAll();   }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Image image)
    {
        imageRepo.save(image);
    }

    @RequestMapping(value = "/delete/", method=RequestMethod.GET)
    public void delete(Image image)     {  imageRepo.delete(image);    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET)
    public Image getImage(  @PathVariable("imageId") int imageId) throws ParseException {
        return imageRepo.findByImageid( imageId );   }

}