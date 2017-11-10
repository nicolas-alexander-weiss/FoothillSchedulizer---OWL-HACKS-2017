import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        String url = "https://www.foothill.edu/anthropology/schedule.php";
        Document document = Jsoup.connect(url).get();

        String question = document.select(".listings").text();
        System.out.println("Question: " + question + "\n");

        int wrapLength = 100;
        String wrapString = new String();

        while(question.length()>wrapLength){
            int lastIndex = question.lastIndexOf(" ", wrapLength);
            wrapString = wrapString.concat(question.substring(0, lastIndex));
            wrapString = wrapString.concat("\n");

            question = question.substring(lastIndex+1, question.length());
        }

        System.out.println(wrapString);

        String outputFileName = "resources/output";
        BufferedWriter fileWriter;

        try {
            fileWriter = new BufferedWriter(new FileWriter(outputFileName + ".txt"));
            fileWriter.write(wrapString);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
