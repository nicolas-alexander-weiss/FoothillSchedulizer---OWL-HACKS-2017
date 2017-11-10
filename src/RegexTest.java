import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 *
 * @author Foothill College, Sean O
 */
public class RegexTest {

    private static String getUrlSource(String url) throws IOException {
        URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        return a.toString();
    }

    public static void main(String[] args) {

        String outputFileName = "resources/output";
        BufferedWriter fileWriter;
        String output = "error";
        try {
            output = getUrlSource("https://www.foothill.edu/math/schedule.php");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            fileWriter = new BufferedWriter(new FileWriter(outputFileName + ".txt"));
            fileWriter.write(output);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
