package com.example.android.newsapp.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Utils {
    public static String getDate(String stringDate) {
        // 2018-05-17T17:08:00Z
        //stringDate = stringDate.replaceAll("Z$", " Z");

        SimpleDateFormat inputFormatter =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE);
        SimpleDateFormat outputFormatter =
                new SimpleDateFormat("EEEE d MMM ''yy", Locale.FRANCE);

        Date date = null;
        try {
            date = inputFormatter.parse(stringDate);
            stringDate = outputFormatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stringDate;
    }
}