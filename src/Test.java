import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{

    public static String removeGarbage(String temp) {
        int tempIndex = -1;
        int j = 0;
        if (!Character.isAlphabetic(temp.charAt(0))) {
            while (tempIndex == -1) {
                if (Character.isAlphabetic(temp.charAt(j)))
                    tempIndex = j;
                j++;
            }
            temp = temp.substring(tempIndex);
        }
        return temp;
    }

    public static String startAtL(String temp) {
        int tempIndex = -1;
        int j = 0;
        if (temp.charAt(0) != 'L') {
            while (tempIndex == -1) {
                if (temp.charAt(j) == 'L')
                    tempIndex = j;
                j++;
            }
            temp = temp.substring(tempIndex);
        }
        return temp;
    }

    public static ArrayList<ClassTime> createClassTime(ArrayList<String> timesToParse) {
        ArrayList<ClassTime> classTimes = new ArrayList<>();
        int time = 0;
        String type;
        String instructor = "?";
        String room;
        String temp;

        int endIndex;
        String day;
        String time1;
        String time2;
        int time1p;
        int time2p;

        for (int i = 0; i < timesToParse.size(); i++) {
            temp = timesToParse.get(i);

            endIndex = temp.indexOf('\t');
            type = temp.substring(0, endIndex);
            temp = temp.substring(endIndex + 1);

            /*
            String regex = "\\w*, [^\\s]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(temp);
            if (matcher.find()) {
                instructor = matcher.group();
                temp = temp.substring(0,matcher.start() - 1) + temp.substring(matcher.end());
            }
            */

            endIndex = temp.lastIndexOf('\t');
            room = temp.substring(endIndex + 1);
            temp = temp.substring(0, endIndex);

            endIndex = temp.lastIndexOf('\t');
            instructor = temp.substring(endIndex + 1);
            temp = temp.substring(0, endIndex);



            endIndex = temp.lastIndexOf('\t');
            day = temp.substring(endIndex + 1);
            temp = temp.substring(0, endIndex);

            System.out.println(day);
            System.out.println("Leftover: " + temp);

            endIndex = temp.lastIndexOf('-');

            if (room.equals("ONLINE")) {
                classTimes.add(new ClassTime(0, room, type, instructor));
            }
            else {

                time1 = temp.substring(0, endIndex);
                time2 = temp.substring(endIndex + 1);
                time1p = timeConversion(time1);
                time2p = timeConversion(time2);
                for (int j = 0; j < day.length(); j++) {
                    time = time2p;
                    time += time1p * 10000;

                    switch (day.charAt(j)) {
                        case 'M':
                            break;
                        case 'T':
                            if (j + 1 < day.length() && day.charAt(j + 1) == 'h') {
                                time += 300000000;
                                j++;
                            }
                            else
                                time += 100000000;
                            break;
                        case 'W':
                            time += 200000000;
                            break;
                        case 'F':
                            time += 400000000;
                            break;
                        case 'S':
                            time += 500000000;
                            break;
                        case 'U':
                            time += 600000000;
                            break;
                        default:
                            break;
                    }
                    classTimes.add(new ClassTime(time, room, type, instructor));
                }
            }
        }

        return classTimes;
    }

    static int timeConversion(String s) {
        String[] time = s.split(":");
        String amPm = time[1].substring(3, 5);
        int timeInt;

        time[1] = time[1].substring(0, 2);

        if (amPm.equals("AM") && time[0].equals("12"))
            time[0] = "00";
        else if (amPm.equals("PM") && Integer.parseInt(time[0]) < 12) {
            timeInt = Integer.parseInt(time[0]);
            timeInt = timeInt + 12;
            time[0] = String.valueOf(timeInt);
        }
        String result = time[0] + time[1];

        return Integer.parseInt(result);
    }

    public static void main(String[] args) throws Exception
    {

        String inputFileName = "resources/input.txt";

        Scanner fileReader = new Scanner(new File(inputFileName));

        String in = "";  //Stringbuilder!!

        boolean stay = true;

        while(stay){
            try{
                in += (" " + fileReader.nextLine());
            }catch (Exception ex){
                stay = false;
            }
        }

        String question = in;
        question = question.replace("\n", "").replace("\r", "");
        System.out.println(question);

        /*
        String outputFileName = "resources/output";
        BufferedWriter fileWriter;


        try {
            fileWriter = new BufferedWriter(new FileWriter(outputFileName + ".txt"));
            fileWriter.write(question);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        String regex = "(\\d{5}.+?)Class";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(question);
        // Check all occurrences

        ArrayList<String> courses = new ArrayList<>();

        while (matcher.find()) {
            String temp = matcher.group();
            temp = temp.substring(0, temp.length() - 6);
            courses.add(temp);
        }

        for (int i = 0; i < courses.size(); i++) {
            String temp = courses.get(i);
            int crn;
            String className;
            String instructor = "IDK";
            String type;
            ArrayList<Integer> classTimes;
            String room;


            crn = Integer.parseInt(temp.substring(0,5));

            temp = temp.substring(12);

            temp = removeGarbage(temp);

            className = temp.substring(0,9);


            temp = temp.substring(13);

            temp = removeGarbage(temp);

            regex = "((?:L|T).+?(?:ONLINE|\\d{4}))";

            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(temp);

            ArrayList<String> timesToParse = new ArrayList<>();

            String tempCopy = temp;

            while (matcher.find()) {
                String capture = matcher.group();
                timesToParse.add(capture);
                temp = temp.substring(0, matcher.start()) + temp.substring(matcher.end());
                matcher = pattern.matcher(temp);
            }



            /*
            int endIndex;
            endIndex = temp.indexOf(' ');
            type = temp.substring(0, endIndex);
            temp = temp.substring(endIndex + 1);

                        /*
            regex = "\\w*, [^\\s]+";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(temp);
            if (matcher.find()) {
                instructor = matcher.group();
                temp = temp.substring(0,matcher.start() - 1) + temp.substring(matcher.end());
            }
            endIndex = temp.lastIndexOf(' ');
            room = temp.substring(endIndex + 1);
            temp = temp.substring(0, endIndex);

            //classTimes = convertTimeToInt(temp);*/

            ArrayList<ClassTime> myClassTimes;
            myClassTimes = createClassTime(timesToParse);

            System.out.println(tempCopy);
            System.out.println(temp);

            System.out.println("CRN: " + crn);
            System.out.println("Class Name: " + className);

            for (int mCounter = 0; mCounter < myClassTimes.size(); mCounter++) {
                System.out.println(myClassTimes.get(mCounter));
            }



                        /*
            System.out.println("Instructor: " + instructor);
            System.out.println("Type: " + type);
            System.out.println("Room: " + room);*/

            /*for (int k = 0; k < classTimes.size(); k++) {
                System.out.println("Time: " + classTimes.get(k));
            }*/
            System.out.println();
        }




    }



}
