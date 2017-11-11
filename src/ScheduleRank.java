public class ScheduleRank {
    // Create a Professor object with the following!
    //      Difficulty Level
    //      Ratings Average (out of 5)
    //      Number of Ratings
    // Ensure the Professor get passed on the possibleSchedules


    private ArrsyList<schedule> possibleSchedules; // pass possible schedules here

    // int startPreference
    // int endPreference

    private int getTimePreference[] {
        // Prompt User for preference Time Start
        // Store input to getTimePreference[0]
        // Prompt User for preference Time End
        // Store input to getTimePreference[1]
    }

    private void rankingSchedules {
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
    }






    private int professorRank {
        // open professor object
        // int easygrades = professor.ratings - professor.difficulty
        // int qualityTeacher = professor.ratings + professor.difficulty
        // if easy grades {
            // return professor.numberOfRatings * easygrades
        // else return sum(professor.numberOfRatings) * qualityTeacher
    }
}
