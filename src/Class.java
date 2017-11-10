import java.util.ArrayList;

public class Class {

    private String id;

    private String instructor;

    private ArrayList<Integer> classTimes;


    public Class(String name, String id, String instructor, int[] classTimes){
        this.id = id;
        this.instructor = instructor;
        setClassTimes(classTimes);
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


    public int[] getClassTimes(){
        int[] classTimes = new int[this.classTimes.size()];
        for(int i = 0; i < this.classTimes.size(); i++){
            classTimes[i] = this.classTimes.get(i);
        }
        return classTimes;
    }

    /**
     * Sets the instance field classTimes
     * Format of int: dhhmmhhmm (day (Mon 0 - Sun 6)|(begin time)|(end time)
     * @param classTimes array of int of class intervals
     * @return false if there is an conflict
     */
    public boolean setClassTimes(int[] classTimes){
        this.classTimes = new ArrayList<Integer>();
        boolean ret = true;
        for(int classTime : classTimes){
            if(ret && !validTimeInt(classTime)){
                ret = false;
            }
            this.classTimes.add(new Integer(classTime));
        }
        return ret;
    }

    private boolean validTimeInt(int classTime) {
        int temp = classTime;
        int d = temp / 100000000;
        temp = temp - d*100000000;
        int beg = temp / 10000;
        temp = temp - d * 10000;
        int end = temp;

        if (!((d >= 0) && (d <= 6))) {
            return false;
        } else if ((beg >= end)) {
            return false;
        } else {
            return true;
        }
    }

}
