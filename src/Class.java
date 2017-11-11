import java.util.ArrayList;

public class Class {

    private int crn;

    private String name;

    private ArrayList<ClassTime> classTimes;


    /**
     *
     * @param crn CRN Number
     * @param name e.g. CS1A
     * @param classTime ArrayList of ClassTime
     */
    public Class(int crn, String name, ArrayList<ClassTime> classTime){
        this.crn = crn;
        this.name = name;
        this.classTimes = new ArrayList<>(classTime);
    }

    /*
    public Class(String name, String id, String instructor, String[] classTimes){
        this.id = id;
        this.instructor = instructor;

        int[] times = new int[classTimes.length];
        for(int i = 0; i < classTimes.length; i++){
            times[i] = Integer.parseInt(classTimes[i]);
        }
        setClassTimes(classTimes);
    }
*/


    public String getName(){
        return this.name;
    }

    public int getCrn() {
        return crn;
    }

    public ArrayList<ClassTime> getClassTimes(){
        return new ArrayList<>(this.classTimes);
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("");
        ret.append(crn);
        ret.append("\n");
        ret.append(name);

        for(ClassTime classTime : classTimes){
            ret.append("\n");
            ret.append(classTime.toString());
        }
        return ret.toString();
    }

    /**
     * Format:
     * //crn as int//
     * //ClassName//
     * //classTime1.toString()//
     * ...
     * //classTimeN.toString()//
     * @param s
     * @return
     */
    public static Class fromString(String s){
        String[] lines = s.split("\n");
        ArrayList<ClassTime> classTimes = new ArrayList<>();

        boolean crnIsNumeric;
        int crn = 0;
        try{
            crn = Integer.parseInt(lines[0]);
            crnIsNumeric = true;
        }catch (Exception ex){
            crnIsNumeric = false;
        }

        if(!(lines.length > 2) || crnIsNumeric){
            return null;
        }else{
            for(int i = 2; i < lines.length; i++){
                classTimes.add(ClassTime.fromString(lines[i]));
            }
            return new Class(crn, lines[1], classTimes);
        }
    }

}
