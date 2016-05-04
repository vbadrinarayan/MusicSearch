package com.music.app.utility;

import android.util.Log;

/**
 * Util.
 */
public class Util {

    private static final String TAG = Util.class.getSimpleName();

    public static String getDuration(Integer trackTimeMillis) {

        int timeConstant=60;
        int seconds=1000;
        int minute = timeConstant * seconds;
        //hh:mm
        String text = "00:00";
        try{
            if (trackTimeMillis > minute)
            {
                int minutes = trackTimeMillis / minute;
                int hours=0;
                if(minutes>timeConstant){
                    hours=minutes/timeConstant;
                    minutes=minutes%timeConstant;
                }
                String strhours=""+hours;
                String strMins=""+minutes;
                if(hours<10)
                    strhours="0"+hours;
                if(minutes<10)
                    strMins="0"+minutes;
                text = strhours+":"+strMins;
            }
        }catch(Exception e){
            Log.i(TAG, e.getMessage());
        }

        return text;
    }
}
