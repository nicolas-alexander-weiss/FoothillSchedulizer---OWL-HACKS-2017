public class NicoTest {
    public static void main(String[] args){

        ClassName[] classNames = {new ClassName("MATH", "001A")
                , new ClassName("MATH", "002B")
                , new ClassName("PHYS", "006")};

        Class[][] classes = ClassLoader.loadClassesWithoutCheck(classNames);

        ScheduleChecker scheduleChecker = new ScheduleChecker(classes);


    }
}
