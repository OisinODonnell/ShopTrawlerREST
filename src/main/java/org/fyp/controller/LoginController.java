package org.fyp.controller;

import org.fyp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping("/")
public class LoginController extends MainController {

    int status = 0;
    String message = "";


    @RequestMapping(value = "login/{username}/{password}", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> login (@PathVariable("username") String username,
                                                         @PathVariable("password") String password) throws ParseException {
        // check username exists
        // check password matches
        // create session with userid, date and time
        // return success and usertype

        respMap = new HashMap<>();

        Timestamp startTime = getTimeStamp();
        User user = userRepo.findByEmailAddress(username);

        if (user != null) { // yes user with this username exists

            if (user.getPassword().equals(password)) {

                respMap.put( "message"   , user.getType() + " User " + user.getFirstname() + " with id " + user.getUserid() + " is logged in!");
                respMap.put( "userType"  , user.getType() );

                respMap.put( "name"      , user.getFirstname() );
                respMap.put( "httpStatus", "" + HttpStatus.OK );
                respMap.put( "startTime" , "" + startTime );
                respMap.put( "userId" , "" + user.getUserid() );
                respMap.put( "success" , "" + 1);

                httpStatus = HttpStatus.OK;

            } else { // password incorrect
                respMap.put( "message"   , "Username : [" + username + "] or password : [" + password + "] incorrect");
                respMap.put( "success" , "0");
                message = "Username or password incorrect";
                httpStatus = HttpStatus.OK;
            }
        } else { // username not found
            respMap.put( "message"   , "Username : [" + username + "] or password : [" + password + "] incorrect");
            respMap.put( "success" , ""+0);
            respMap.put("httpStatus", ""+ HttpStatus.OK);
            httpStatus = HttpStatus.OK;

        }

        return new ResponseEntity<>(respMap, httpStatus);
    }

    @RequestMapping(value = "/logout/{userId}/{startTime}", method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity logout (@PathVariable("userId") Integer userId,
                                  @PathVariable("startTime") Timestamp startTime) throws ParseException {
        // locate session with userId
        // locate this session based on its startTime
        // set endTimeStamp
        // save session details
        // return successful logout status

        respMap = new HashMap<>();

//        Collection<Session> sessions = sessionRepo.findAllByuserid(userId);
//        User user = userRepo.findByuserid(userId);
//
//        for (Session s : sessions) {
//            if (s.getDateStart().equals(startTime)) {
//                s.setDateEnd( getTimeStamp() );
//                sessionRepo.save(s);
//                message  = "User "+ user.getFirstname() + " has successfully Logged out";
//                httpStatus = HttpStatus.OK;
//                break;
//            } else {
//                message  = "Session could not be found to terminate";
//                httpStatus = HttpStatus.NOT_ACCEPTABLE;
//            }
//        }

        return new ResponseEntity<>(message, httpStatus);
    }
    @RequestMapping(value = "/register/retailer/{firstname}/{surname}/{emailAddress}/{password}/{userType}/{phone}/{retailerid}",
            method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> registerRetailer (@PathVariable("firstname")    String firstname,
                                                                    @PathVariable("surname")      String surname,
                                                                    @PathVariable("emailAddress") String emailAddress,
                                                                    @PathVariable("password")     String password,
                                                                    @PathVariable("userType")     String userType,
                                                                    @PathVariable("phone")        String phone,
                                                                    @PathVariable("retailerid")   String retailerid

    ) throws ParseException {
        // Check email is unique
        // check password conforms to correct format
        // create user
        // save user
        // return successful user creation status

        respMap = new HashMap<>();

        User user = userRepo.findByEmailAddress(emailAddress);

        if (user == null) {
            user = new User();
            if (checkPasswordFormat(password)) {
                user.setFirstname(firstname);
                user.setSurname(surname);
                user.setEmailAddress(emailAddress);
                user.setPassword(password);
                user.setPhone(phone);
                user.setType(userType);
                
                httpStatus = HttpStatus.OK;

                respMap.put("message","User created successfully");
                respMap.put("httpStatus",""+httpStatus);
                respMap.put("success","1");

                userRepo.save(user);

            } else {
                httpStatus = HttpStatus.OK;

                respMap.put("message","Password Incorrect: >= 6 and <= 20, at least one number, upper and lowercase character");
                respMap.put("success","0");
                respMap.put("httpStatus",""+httpStatus);
            }
        } else {
            httpStatus = HttpStatus.OK;

            respMap.put("message"," - This email address is already in use, please chose another email address");
            respMap.put("success","0");
            respMap.put("httpStatus",""+httpStatus);
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }
    @RequestMapping(value = "/register/admin/{firstname}/{surname}/{emailAddress}/{password}/{userType}/{phone}",
                    method= RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> registerAdmin (@PathVariable("firstname")      String firstname,
                                                                 @PathVariable("surname")        String surname,
                                                                 @PathVariable("emailAddress")   String emailAddress,
                                                                 @PathVariable("password")       String password,
                                                                 @PathVariable("userType")       String userType,
                                                                 @PathVariable("phone")          String phone,
                                                                 @PathVariable("retailerid")     int retailerid
                                                                 ) throws ParseException {
        // Check email is unique
        // check password conforms to correct format
        // create user
        // save user
        // return successful user creation status

        respMap = new HashMap<>();

        User user = userRepo.findByEmailAddress(emailAddress);

        if (user == null) {
            user = new User();
            String gender = "";
            int yob = 0;
            int userid = 0;

            if (checkPasswordFormat(password)) {
                user.setFirstname(firstname);
                user.setSurname(surname);
                user.setEmailAddress(emailAddress);
                user.setPassword(password);
                user.setType(userType);
                user.setPhone(phone);
                user.setActive(false);

                httpStatus = HttpStatus.OK;

                respMap.put("message","User created successfully");
                respMap.put("httpStatus",""+httpStatus);
                respMap.put("success","1");
                userRepo.save(user);

                // retrieve user, and pick up userid.
                // with this id go to retailer with retailerid and change userid to this userid.
                // update retailer.

            } else {
                httpStatus = HttpStatus.OK;
                respMap.put("message","Password Incorrect: >= 6 and <= 20, at least one number, upper and lowercase character");
                respMap.put("success","0");
                respMap.put("httpStatus",""+httpStatus);
            }
        } else {
            httpStatus = HttpStatus.OK;
            respMap.put("message"," - This email address is already in use, please chose another email address");
            respMap.put("success","0");
            respMap.put("httpStatus",""+httpStatus);
        }

        return new ResponseEntity<>(respMap, httpStatus);
    }

    private boolean checkPasswordFormat(String password) {

        //  ^            #   match from start
        //  (            #   Start of group
        //  (?=.*\d)     #   must contains one digit from 0-9
        //  (?=.*[a-z])  #   must contains one lowercase characters
        //  (?=.*[A-Z])) #   must contains one Uppercase character
        //          .    #   match anything with previous condition checking
        //  {8,20}       #   length at least 8 characters and maximum of 20

        String regex = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])).{6,20}";

        return password.matches(regex);
    }

}