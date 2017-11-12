import java.util.ArrayList;

public class ScheduleRank {



    private final int TIME_RATING_IN_FUNCTION_MAX = 999;


    public ScheduleRank(ArrayList<Schedule> possibleSchedules){
        this.possibleSchedules = possibleSchedules;
    }


    private ArrayList<Schedule> possibleSchedules;
    // private int[]


    //Preference in which time frame the classes should usually be.
    private int startPreference;
    private int endPreference;

    /**
     * format: hhmm
     * @param start
     * @param end
     */
    private void setTimePreference(int start, int end) {
        startPreference = start;
        endPreference = end;
    }


    public static double timeRating(Schedule schedule, int start, int end){

        boolean[][] booleanSchedule = schedule.getBooleanSchedule();

        int startH = start / 100;
        int startM = start - startH * 100;
        int begIndex = startH * 12 + startM / 5;

        int endH = end / 100;
        int endM = end - endH * 100;
        int endIndex = endH * 12 + endM / 5;

        int rating = 0;
        int counter = 0;

        for(int d = 0; d < booleanSchedule.length; d++){
            for(int i = 0; i < booleanSchedule[d].length; i++){
                if(booleanSchedule[d][i]){
                    if(i >= begIndex && i <= endIndex){
                        rating++;
                    }else{
                        rating--;
                    }
                    counter++;
                }
            }
        }
        if(counter == 0){
            return 0;
        }

        return (rating /(double) counter);
    }


    private void rankingSchedules() {
        // get Time Ranking for each possible Schedule
            // through timeRank()

        // get Professor Ranking for each possible Schedule
            // through professorRank()

        // Prompt user for preference between Teacher or schedule

        // Declare int rankPoints to each possible Schedule

        // for each individual possible Schedule
            // if (Teacher > Schedule) {
                // int rankPoints = professorRank - timeRank
            // else if (Schedule > Teacher) {
                // int rankPoints = sum(professor.numberofratings) * timeRank - professorRank
            // else
                // int rankPoints = professorRank + sqrt(timeRank * sum(professor.numberofratings)

        // sort schedules by highest rankPoints
    }
    private int timeRank() {
        // pass time of Possible Schedules here

        // convert boolean schedule to int

        // b = convert time prefence into an array of schedule
            // ie [6][24*12] kind of matrix
            // place +1 if fall under time preference
            // ie for int start = starttime's array index, start < end
                // where end = endtime's array index
            // place -1 if a[count] != 1 (via for loop)

        // create new array [6][24*12]

        // c = multiply time preference with Possible Schedule's array
            // through each corresponding index
            // ie a[k][j] * b[k][j}

        // return sum(c)

        // **if no time preference, let b[any position] = 1

        return 0;
    }






    private int professorRank() {
        // open professor object
        // int easygrades = professor.ratings - professor.difficulty
        // int qualityTeacher = professor.ratings + professor.difficulty
        // if easy grades {
            // return professor.numberOfRatings * easygrades
        // else return sum(professor.numberOfRatings) * qualityTeacher

        return 0;
    }
}
