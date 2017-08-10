package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"ShoppingCentres","ShoppingCentre"}, method= RequestMethod.GET)
public class ShoppingCentreController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public Collection<ShoppingCentre> create(ShoppingCentre shoppingCentre)
    {

        shoppingCentreRepo.save(shoppingCentre);
        return shoppingCentreRepo.findAll();
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<ShoppingCentre> read()
    {
        return shoppingCentreRepo.findAll();
    }

    @RequestMapping(value = "/update/{id}", method={RequestMethod.PUT})
    public void update( @RequestBody ShoppingCentre shoppingCentre, @PathVariable("id") int id, HttpServletResponse httpResponse)
    {

//        ShoppingCentre updatedSC = shoppingCentreRepo.save(shoppingCentre);
        if(!shoppingCentreRepo.exists(id)){
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        else{
            shoppingCentreRepo.save(shoppingCentre);
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }

//        return updatedSC;
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public Collection<ShoppingCentre> delete(ShoppingCentre shoppingCentre) {
        shoppingCentreRepo.delete(shoppingCentre);
        return shoppingCentreRepo.findAll();
    }

}
