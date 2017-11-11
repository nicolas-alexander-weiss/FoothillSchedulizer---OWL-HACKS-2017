import java.io.File;
import java.util.ArrayList;

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
     * load Classes
     * @param classNames
     * @param flag  1 -> load without checking | else: only Load classes that exists
     * @return Class[m][n(m)] | m = numb of different Classes | n(m) = number of different CRNs for this class
     */
    public static Class[][] loadClasses(ClassName[] classNames, int flag){
        ArrayList<Class[]> classes = new ArrayList<>();

        for(ClassName className : classNames){
            if(flag == 1){
                classes.add(loadClass(className));
            }else{
                if(classExists(className)){
                    classes.add(loadClass(className));
                }
            }
        }

        return classes.toArray();
    }

    private static Class[] loadClass(ClassName className) {
        return new Class[0];
    }

    /**
     * calling loadClass with flag = 1
     * @param classNames
     * @return
     */
    public static Class[][] loadClassesWithoutCheck(ClassName[] classNames){
        return loadClasses(classNames, 1);
    }


}
