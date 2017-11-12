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

    public String toString() {
        String returnString = "Schedule:\n";
        for (int i = 0; i < classList.size(); i++) {
            Class tempClass = classList.get(i);
            returnString += tempClass.getCrn() + "\n"
            + tempClass.getName() + "\n";
            for (int j = 0; j < tempClass.getClassTimes().size(); j++) {
                ClassTime tempClassTime = tempClass.getClassTimes().get(j);
                returnString += tempClassTime.getType() + " ";
                if (tempClassTime.getTime() == 0)
                    returnString += "Online ";
                else {
                    int tempTime = tempClassTime.getTime();
                    String tempTimeString = String.valueOf(tempTime);
                    if (tempTimeString.length() > 8)
                        tempTimeString = tempTimeString.substring(1);
                    if (tempTimeString.length() < 8)
                        tempTimeString = "0" + tempTimeString;
                    returnString += tempTimeString.substring(0,2) + ":" + tempTimeString.substring(2,4) + "-" +
                            tempTimeString.substring(4,6) + ":" + tempTimeString.substring(6);
                    switch (tempTime / 100000000) {
                        case 0:
                            returnString += "M ";
                            break;
                        case 1:
                            returnString += "T ";
                            break;
                        case 2:
                            returnString += "W ";
                            break;
                        case 3:
                            returnString += "Th ";
                            break;
                        case 4:
                            returnString += "F ";
                            break;
                        case 5:
                            returnString += "S ";
                            break;
                        case 6:
                            returnString += "S ";
                            break;
                        default:
                            returnString += "ERROR";
                            break;
                    }

                }
                returnString += tempClassTime.getInstructor() + " " + tempClassTime.getRoom() + "\n";
            }
            returnString += "\n";
        }
        return returnString;
    }

}
