import java.util.ArrayList;

public class Schedule {

    private boolean[][] booleanSchedule;

    private ArrayList<Class> classList;

    public Schedule(){
        classList = new ArrayList<Class>();
        booleanSchedule = new boolean[7][];
        for(int i = 0; i < booleanSchedule.length; i++){
            booleanSchedule[i] = new boolean[24*12*5];
        }
    }

    public boolean[][] getBooleanSchedule() {
        return booleanSchedule;
    }

    public boolean add(Class classObject){

        ArrayList<ClassTime> classTimes = classObject.getClassTimes();

        for(ClassTime classTime : classTimes){
            int time = classTime.getTime();
            int temp = time;
            int d = time / 100000000;
            temp -= d*100000000;
            int begH = temp /1000000;
            temp -= begH * 1000000;
            int begM = temp/10000;
            temp -= begM * 10000;
            int endH = temp / 100;
            temp -= endH * 100;
            int endM = temp;

            int begIndex = (begM/5) + (begH*12);
            int endIndex = (endM/5) + (endH*12);

            for (int i = begIndex; i < endIndex; i++){
                /*
                if(d >= booleanSchedule.length || d < 0){
                    int p = 0;
                    if(i >= booleanSchedule[d].length || i < 0){
                        p = 1;
                    }
                }
                */
                if(booleanSchedule[d][i]){
                    return false;
                }else{
                    booleanSchedule[d][i] = true;
                }
            }
        }

        classList.add(classObject);
        return true;
    }

}
