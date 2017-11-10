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
    public static void main(String[] args) throws Exception
    {
        String url = "https://www.foothill.edu/anthropology/schedule.php";
        Document document = Jsoup.connect(url).get();

        String question = document.select(".listings").text();
        System.out.println("Question: " + question + "\n");

        String outputFileName = "resources/output";
        BufferedWriter fileWriter;

        String regex = "(\\d{5}.+?)Class";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(question);
        // Check all occurrences

        ArrayList<String> stringsss = new ArrayList<>();

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /*
        try {
            while (matcher.find() ) {
                int i = matcher.start();
                if (i != 0) {
                    stringsss.add(wrapString.substring(0,i));
                    wrapString = wrapString.substring(i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < stringsss.size(); i++) {
            System.out.println(stringsss.get(i) + "\n");
        }

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
