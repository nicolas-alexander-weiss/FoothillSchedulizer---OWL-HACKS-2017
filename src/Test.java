import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void main(String[] args) throws Exception
    {
        String url = "https://www.foothill.edu/anthropology/schedule.php";
        Document document = Jsoup.connect(url).get();

        String question = document.select(".listings").text();

        String outputFileName = "resources/output";
        BufferedWriter fileWriter;

        String regex = "(\\d{5}.+?)Class";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(question);
        // Check all occurrences

        ArrayList<String> courses = new ArrayList<>();

        while (matcher.find()) {
            courses.add(matcher.group());
        }

        for (int i = 0; i < courses.size(); i++) {
            String temp = courses.get(i);
            int crn;
            String className;
            String instructor = "IDK";
            String type;

            crn = Integer.parseInt(temp.substring(0,5));

            temp = temp.substring(12);

            temp = removeGarbage(temp);
            className = temp.substring(0,9);

            regex = "\\w*, [^\\s]+";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(temp);
            if (matcher.find()) {
                instructor = matcher.group();
            }
            temp = temp.substring(13);

            temp = startAtL(temp);

            int endIndex;
            endIndex = temp.indexOf(' ');
            type = temp.substring(0, endIndex);
            temp = temp.substring(endIndex + 1);

            System.out.println(temp);
            System.out.println("CRN: " + crn);
            System.out.println("Class Name: " + className);
            System.out.println("Instructor: " + instructor);
            System.out.println("Type: " + type + "\n");
        }


        /*
        try {
            fileWriter = new BufferedWriter(new FileWriter(outputFileName + ".txt"));
            fileWriter.write(wrapString);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }



}
