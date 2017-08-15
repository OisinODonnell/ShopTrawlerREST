package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.deploy.net.HttpResponse;
import org.fyp.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 18/07/2017.
 */

@RestController
@RequestMapping(value = {"ShoppingCentres","ShoppingCentre"}, method= RequestMethod.GET)
public class ShoppingCentreController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<ShoppingCentre> create(@RequestBody ShoppingCentre shoppingCentre)
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
    public void update(@RequestBody ShoppingCentre shoppingCentre, @PathParam("id") Integer id  )
    {

//        ShoppingCentre updatedSC = shoppingCentreRepo.save(shoppingCentre);
//        if(!shoppingCentreRepo.exists(shoppingCentre.getShoppingCentreid())){
//            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        }
//        else{

            shoppingCentreRepo.save(shoppingCentre);

//            httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
//        }

//        return updatedSC;
    }
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<ShoppingCentre> delete(@PathVariable("id") Integer id)    {
        shoppingCentreRepo.deleteByShoppingCentreid(id);
        return shoppingCentreRepo.findAll();
    }

}
