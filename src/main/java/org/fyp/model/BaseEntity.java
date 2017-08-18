package org.fyp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oisin on 30/03/2017.
 */
public abstract class BaseEntity {

    /**
     * Conversion methods used when taking data in from a csv file.
     */

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private Integer valueToInteger = null;
    private Date parsedDate = new Date();
    private BigDecimal valueToBigDecimal = null;

    // used when setting byte values in entities
    final byte True = 1;
    final byte False = 0;

    public Integer toInteger(String value)
    {

        try {
            valueToInteger = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        return valueToInteger;
    }

    public BigDecimal toBigDecimal(String value)
    {

        try {
            valueToBigDecimal = new BigDecimal(value.replaceAll(",", ""));
        } catch (NumberFormatException e)  {
            System.out.println(e);
        }

        return valueToBigDecimal;
    }

    public byte[] toByteArray(String value) {       return  value.getBytes(); }

    public boolean toBoolean(String value) {

            return ( value.equals( "true" ) ) || ( value.equals( "1" ) || (value.equals("TRUE")) );
    }


    public Byte toByte(String value) {

        int number = Integer.parseInt(value);
        return value.getBytes()[0];
    }

    public Timestamp toTimestamp(String value)  {

        try {
            parsedDate = dateFormat.parse(value);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return  new Timestamp(parsedDate.getTime());
    }
}
