public class NicoTest {
    public static void main(String[] args){

        ClassName[] classNames = {new ClassName("MATH", "001A")
                , new ClassName("MATH", "002B")
                , new ClassName("PHYS", "006")};

        Class[][] classes = ClassLoader.loadClassesWithoutCheck(classNames);

        ScheduleChecker scheduleChecker = new ScheduleChecker(classes);

        Schedule[] schedules = scheduleChecker.getPossibleSchedules();

        //System.out.println("TimeRating: " + ScheduleRank.timeRating(schedules[0],840,1500));

        Schedule[] possibleSchedules = scheduleChecker.getPossibleSchedules();

        for (int j = 0; j < possibleSchedules.length; j++) {
            System.out.println(possibleSchedules[j]);
        }

    }
}
