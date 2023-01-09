package es.nhs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 01/12/2022
 */
public class Utils
{
    /**
     * Pareseo de Horas
     *
     * @param dateString Hora en formato String
     * @return Hora en formato Date
     */
    public Date parsearHorasDate(final String dateString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }
}
