import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

        return (Class[][])classes.toArray();
    }

    /**
     * calling loadClass with flag = 1
     * @param classNames
     * @return
     */
    public static Class[][] loadClassesWithoutCheck(ClassName[] classNames){
        return loadClasses(classNames, 1);
    }

    private static Class[] loadClass(ClassName className) {
        String filePath = "resources/" + className.getDepartment().toUpperCase() + "/" + className.getName().toUpperCase();
        File classFile = new File(filePath);
        ArrayList<Class> arrayList = new ArrayList<>();
        StringBuilder fileString = new StringBuilder("");
        try {
            Scanner input = new Scanner(classFile);
            fileString.append(input.nextLine());
            while(true){
                fileString.append("\n" + input.nextLine());
            }
        } catch (Exception e) {
        }

        String fileS = fileString.toString();

        String[] classStrings = fileS.split("\n\n");

        for(int i = 0; i < classStrings.length; i++){
            Class c = Class.fromString(classStrings[i]);
            if(c!=null){
                arrayList.add(c);
            }
        }


        return (Class[]) arrayList.toArray();
    }




}
