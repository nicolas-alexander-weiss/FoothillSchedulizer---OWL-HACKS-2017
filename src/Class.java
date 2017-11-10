import java.util.ArrayList;

public class Class {

    private int crn;

    private String name;

    private String instructor;

    private ArrayList<ClassTime> classTimes;


    /**
     *
     * @param crn CRN Number
     * @param name e.g. CS1A
     * @param instructor instructor name
     * @param classTime ArrayList of ClassTime
     */
    public Class(int crn, String name, String instructor, ArrayList<ClassTime> classTime){
        this.crn = crn;
        this.name = name;
        this.instructor = instructor;
        this.classTimes = new ArrayList<ClassTime>(classTime);
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

    public String getInstructor(){
        return instructor;
    }

    public ArrayList<ClassTime> getClassTimes(){
        return new ArrayList<ClassTime>(this.classTimes);
    }

}
