import java.io.File;

public class ClassLoader {
    private ClassLoader(){

    }


    /**
     * Checks if the class the user entered exists
     * @param depmt e.g. MATH or ANTH
     * @param name e.g. 1A or 2B
     * @return class file found
     */
    public static boolean classExists(String depmt, String name){
        String filePath = "resources/" + depmt.toUpperCase() + "/" + name.toUpperCase();
        return (new File(filePath)).exists();
    }




}
