import java.io.File;

public class ClassLoader {
    private ClassLoader(){

    }


    /**
     * Checks if the class the user entered exists
     * @param className ClassName Object, containing department and name string
     * @return class file found
     */
    public static boolean classExists(ClassName className){
        String filePath = "resources/" + className.getDepartment().toUpperCase() + "/" + className.getName().toUpperCase();
        return (new File(filePath)).exists();
    }

    /**
     *
     * @param names
     * @param flag 0 -> only Load classes that exists
     * @return
     */
    public static Class[][] loadClasses(String[] names, int flag){

    }


}
