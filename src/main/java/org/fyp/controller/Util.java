package org.fyp.controller;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by oisin on 18/07/2017.
 */
public class Util {

    private final String BASE_PATH      = "src/main/resources/static/";
    final String BEACONS        = BASE_PATH + "beacons.csv";
    final String BONUS_CODES     = BASE_PATH + "bonuscodes.csv";
    final String CONTENT        = BASE_PATH + "content.csv";
    final String FAVOURITES     = BASE_PATH + "favourites.csv";
    final String LOCATIONS      = BASE_PATH + "locations.csv";
    final String LOYALTY_REWARDS= BASE_PATH + "loyalty_rewards.csv";
    final String RATINGS      	= BASE_PATH + "ratings.csv";
    final String RETAILERS    	= BASE_PATH + "retailers.csv";
    final String SHOPPING_CENTRE = BASE_PATH + "shoppingCentre.csv";
    final String USERS      	= BASE_PATH + "users.csv";
    final String USER_POINTS    = BASE_PATH + "user_points.csv";
    final String VISITS      	= BASE_PATH + "visits.csv";
    final String ZONES      	= BASE_PATH + "zones.csv";

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    /**
     * Read entire file into and array of arrays
     */
    public List<List<String>> readCSV(String file)
    {
        /*
            Reads CSV file into array of lines, each line parsed into an array of atring tokens
            Trims empty rows and empty columns
         */

        List<String> lines = new ArrayList<>();
        List<String[]> parsedLines = new ArrayList<>();
        List<List<String>> newList = new ArrayList<>();
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(file));
            parsedLines  =  reader.readAll();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get the length of the first row of attributes ... use this to check the rest
        int columns = parsedLines.get(0).length;



        // trim extra/empty rows

        for(String[] record : parsedLines) {
            List<String> attribs = Arrays.asList(record);
            // skip over an empty rows
            if (attribs.size() == columns) {
                // skip over lines where first attribute is empty ... none should be empty
                if (attribs.get(0).length() != 0)
                    newList.add(attribs);
            }
        }

        // trim extra/empty columns

        // first find the no of columns with data from first line in file
        // use this to grab rest lines.
        int emptyColumn = 0;
        for (int i = 0 ; i < newList.get(0).size() ; i++) {
            List<String> list = newList.get(0);
            if (list.get(i).length()==0) {
                emptyColumn = i;
                break;
            }
        }

        List<List<String>> trimmedList = new ArrayList<>();

        if (emptyColumn != 0 ) { // value set in block above ... extra column(s) found

            for (List<String> list : newList) {

                List<String> choppedList = list.subList(0, emptyColumn);
                trimmedList.add(choppedList);

            }
        } // no value set ... =>  no extra columns
        else {
            trimmedList = newList;
        }

        // remove top line with variable names from array
        trimmedList.remove(0);

        return trimmedList;
    }

    /**
     * The csv file is slurped into a array of lines
     * each line is then split into each part.
     * the return value is an array or arrays

     */
    public List<List<String>> readCSVrandom(String file, int quantity)
    {
        // contents of CSV file
        List  lines = readCSV(file);

        List<List<String>> parsedLines = parse(lines);

        // container for a random selection from this CSV file
        List<List<String>> randomSet = new ArrayList<>();

        // max count random number generator can create an entry for.
        int count = lines.size();

        // pick out a random set of entries from the file, based on the amount of entries in the file.
        Random generator = new Random();
        for(int i=0 ; i < quantity; i++ ) {
            randomSet.add(parsedLines.get( generator.nextInt(count) ));
        }
        return randomSet;
    }

    /**
     * parse each line into an array
     */
    private List<List<String>> parse(List<String> lines) {

        List<List<String>> parsedLines = new ArrayList<>();

        for(String line : lines) {
            String[] pLine = line.split(",");
            List<String> parsedLine = Arrays.asList(pLine);
        }
        return parsedLines;
    }

}
