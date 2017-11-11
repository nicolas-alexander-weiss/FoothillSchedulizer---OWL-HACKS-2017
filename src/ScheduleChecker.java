import java.util.ArrayList;

public class ScheduleChecker {

    private ArrayList<Schedule> possibleSchedules;

    private Class[][] classes;

    private int[] iterator;

    public ScheduleChecker(Class[][] classes){
        this.classes = classes;
        possibleSchedules = new ArrayList<Schedule>();
        initIterator();
        computePossibleSchedules();
    }

    private void initIterator() {
        iterator = new int[classes.length];
        for(int i = 0; i < iterator.length; i++){
            iterator[i] = 0;
        }
    }

    private void computePossibleSchedules() {
        do{
            Schedule temp = getSchedule();
            if(temp != null){
                possibleSchedules.add(temp);
            }
        }while(recIncrement(0));
    }

    private Schedule getSchedule() {
        Schedule schedule = new Schedule();
        for(int i = 0; i < iterator.length; i++){
            if(!schedule.add(classes[i][iterator[i]])){
                return null;
            }
        }

        return schedule;
    }

    private boolean recIncrement(int index) {
        if(index >= classes.length){
            return false;
        }else if(iterator[index] >= classes[index].length - 1){
            iterator[index] = 0;
            return recIncrement(++index);
        }else{
            iterator[index]++;
            return true;
        }
    }


}
