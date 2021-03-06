package org.fyp.controller;

import org.fyp.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;




/**
 * Created by oisin on 18/07/2017.
 */
@RestController
@RequestMapping(value = {"Content","Contents"}, method= RequestMethod.GET)
public class ContentController extends MainController {

    /**
     * Create / Delete and Update content is performed by the retailer only,
     * so when data is returned, only return data for that retailer.
     * Approve is performed by the administrator and hence all the content is returned.
     * (not approved yet)
     * @return
     */


    @RequestMapping(value = "/ForApproval", method=RequestMethod.GET)
    public Collection<Content> forApproval() {
        return contentRepo.findAllByApproved(false);
    }

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public Collection<Content> create(@RequestBody Content content) {
        int retailerid = content.getRetailerid();
        contentRepo.save(content);
        return contentRepo.findByRetailerid(retailerid);
    }
    @RequestMapping(value = "/create/default/{id}", method=RequestMethod.GET)
    public Collection<Content> create(@PathVariable ("id") int id) {

        // init dates
        Timestamp startDate = new Timestamp( System.currentTimeMillis( ) );
        Timestamp endDate   = new Timestamp( System.currentTimeMillis( ) );
        Timestamp today = startDate;

        // retrieve list of contents for this retailer sorted by start date
        List<Content> contents = contentRepo.findAllByRetaileridAndEndDateAfterOrderByStartDate(id, today);

        if (contents.size() == 0) { // no record exists
            startDate = today;

        } else if (contents.size() == 1) { // only one record exists // start date is set one day after the enddate
            if (compareDates(startDate, contents.get(0).getStartDate()) >= 0 )
                startDate = addDate(contents.get(0).getEndDate(),1,"day");

        } else { //multiple records found
            for(Content content: contents) {
                if (compareDates(startDate, content.getStartDate()) < 0)
                    break;
                startDate = addDate(content.getEndDate(),1,"day");
            }
        }

        Content content = new Content(); // sets some default values
        content.setStartDate( startDate); // add next date which is valid
        content.setEndDate( addDate(startDate, 1,"day"));
        content.setRetailerid( id );

        contentRepo.save(content);

        return contentRepo.findAllByRetailerid( id );
    }


    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Content> read() {
        return contentRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Collection<Content> update(@RequestBody Content content) {

        int retailerid = content.getRetailerid();
        contentRepo.save(content);
        return contentRepo.findByRetailerid(retailerid);
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE)
    public Collection<Content> delete(@PathVariable("id") Integer id) {

        Content content = contentRepo.findByContentid(id);

        int retailerid = content.getRetailerid();
        contentRepo.deleteByContentid(id);
        return contentRepo.findByRetailerid(retailerid);
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
    public Collection<Content> update( @RequestBody Content content, @PathParam( "id") Integer id  ) {

        int retailerid = content.getRetailerid();
        contentRepo.save(content);
        return contentRepo.findByRetailerid(retailerid);
    }

    @RequestMapping(value = "/CheckDates", method=RequestMethod.PUT)
    public ResponseEntity checkDates( @RequestBody Content content) {

        int countStart = contentRepo.countByRetaileridAndStartDateBetween(content.getRetailerid(), content.getStartDate(), content.getEndDate());
        int countEnd = contentRepo.countByRetaileridAndEndDateBetween(content.getRetailerid(), content.getStartDate(), content.getEndDate());
        int totalCount = countStart + countEnd;

        //--

        Timestamp startDate  = content.getStartDate();
        Timestamp endDate    = content.getEndDate();
        int       retailerid = content.getRetailerid();

        List<Content> starts = contentRepo.findByRetaileridAndStartDateBetween( retailerid, startDate, endDate);
        List<Content> ends   = contentRepo.findByRetaileridAndEndDateBetween( retailerid, startDate, endDate);
        List<Content> mixed  = contentRepo.findByRetaileridAndStartDateLessThanEqualAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndEndDateGreaterThanEqual(retailerid, startDate, endDate, startDate, endDate);

        Timestamp newStart = startDate;
        if (starts.size() > 0 ) {
            newStart = starts.get(0).getEndDate();
        }
        if (ends.size() > 0) {
            newStart = ends.get(0).getEndDate();
        }
        if (mixed.size() > 0) {
            newStart = mixed.get(0).getEndDate();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newStart);
        calendar.add(Calendar.HOUR, 24);
        Timestamp newDateNextDay = new Timestamp(calendar.getTimeInMillis());


        if ( totalCount == 0) {
            respMap.put("message","No Content found covering these dates");
            respMap.put("success","1");
            respMap.put("httpStatus","" + httpStatus);

        } else {
            respMap.put( "earliestStartDate",newDateNextDay.toString());
            respMap.put( "message", "Content record already exists covering all or part of this period" );
            respMap.put( "success", "0" );
            respMap.put( "httpStatus", "" + httpStatus );
        }
        return new ResponseEntity<>(respMap, httpStatus);
    }

}
