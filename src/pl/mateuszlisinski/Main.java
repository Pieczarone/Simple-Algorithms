package pl.mateuszlisinski;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Main {

    public static int ArrayChallange(int[] arr){
        int output = 0;
        if (arr.length==0){
            return output;
        }
        for (int i = 0; i<arr.length-1; i++){
            for(int j = i + 1; j < arr.length; j++)
            if(arr[j]>arr[i]){
                output = Integer.max(output, arr[j] - arr[i]);
            }
        }
        return output;
    }

    public static String StringChallangee(String str){
        String times[] = str.split("-");
        String firstTime = times[0];
        String secondTime = times[1];
        DateFormat df = new SimpleDateFormat("hh:mmaa");
        DateFormat outputformat = new SimpleDateFormat("HH:mm");
        Date date = null;
        Date secondDate = null;
        String output = null;
        try{
            date = df.parse(firstTime);
            output = outputformat.format(date);
            date = outputformat.parse(output);
            secondDate = df.parse(secondTime);
            output = outputformat.format(secondDate);
            secondDate = outputformat.parse(output);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        long differenceTime = date.getTime()-secondDate.getTime();
        long difference = differenceTime/60/1000;
        if (date.compareTo(secondDate)>0){
            difference-=1440;
        }
        if(difference<0){
            difference*=-1;
        }
        str = Long.toString(difference);
        return str;
    }

    public static void main (String[] args) {
        System.out.println(StringChallangee("1:08pm-1:23am"));
        System.out.println(ArrayChallange(new int[] {14,20,4,12,5,11}));
    }

}

