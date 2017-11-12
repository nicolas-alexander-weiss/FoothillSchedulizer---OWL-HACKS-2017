public class ScheduleRate {


    public ScheduleRate(Schedule schedule, int prefTimeFrame){
        this.schedule = schedule;

        setTimePreference(prefTimeFrame);
    }

    private Schedule schedule;

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

    private void setTimePreference(int timeframe) {
        setTimePreference(timeframe / 10000, timeframe - startPreference * 10000);
    }


    public double timeRating(){

        boolean[][] booleanSchedule = schedule.getBooleanSchedule();

        int startH = startPreference / 100;
        int startM = startPreference - startH * 100;
        int begIndex = startH * 12 + startM / 5;

        int endH = endPreference / 100;
        int endM = endPreference - endH * 100;
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

    public double overallRating(double timeRatingWeight, double onlineClassesRatingWeight){

        double timeRating = timeRating();
        double onlineRating = onlineClassesRating();

        double weightedAverage = (timeRating*timeRatingWeight
                                    + onlineRating*onlineClassesRatingWeight)/
                                    (timeRatingWeight+onlineClassesRatingWeight);

        return weightedAverage;
    }

    private double onlineClassesRating() {
        int counterOnline = 0;
        int counterOffline = 0;

        for(Class classObject : schedule.getClassList()){
            for(ClassTime classTime : classObject.getClassTimes()){
                if(classTime.getRoom().toUpperCase().equals("ONLINE")){
                    return 1;
                }
            }
        }
        return -1;
    }

}
