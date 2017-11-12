import com.sun.deploy.util.StringUtils;

public class ClassTime {

    private int time;

    private String type;
    private String instructor;
    private String room;

    /**
     * Constructor for ClassTime
     * Format of time: dhhmmhhmm (day (Mon 0 - Sun 6)|(begin time)|(end time)
     * If online class, then all zero!!!!
     */
    ClassTime(int time, String room, String type, String instructor) {
        boolean validTime = setTime(time);
        boolean validRoom = setRoom(room);
        this.type = type;
        this.instructor = instructor;
    }

    private boolean validTimeInt(int classTime) {
        int temp = classTime;
        int d = temp / 100000000;
        temp = temp - d*100000000;
        int beg = temp / 10000;
        temp = temp - d * 10000;
        int end = temp;

        if(classTime == 0){
            return true;
        } else if (!((d >= 0) && (d <= 6))) {
            return false;
        } else if ((beg >= end)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets the time field
     * Format of time: dhhmmhhmm (day (Mon 0 - Sun 6)|(begin time)|(end time)
     * If online class, then all zero!!!!
     * @param time the class time in number format
     * @return false if there is an conflict
     */
    public boolean setTime(int time) {
        this.time = time;

        return validTimeInt(time);
    }

    public boolean setRoom(String room) {
        this.room = room;
        return true; //create sanity check!
    }

    public int getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type + ";" + time + ";" + instructor + ";" + room;
    }

    /**
     * Creates a ClassTime object form the given String.
     * @param s  type + " " + time + " " + instructor + " " + room
     * @return a ClassTime object
     */
    public static ClassTime fromString(String s){
        String[] stringParts = s.split(";");


        boolean timeIsNumeric;
        int time = 0;
        try{
            time = Integer.parseInt(stringParts[1]);
            timeIsNumeric = true;
        }catch (Exception ex){
            timeIsNumeric = false;
        }

        if(stringParts.length != 4 || !timeIsNumeric){
            return null;
        }else{
            String type = stringParts[0];
            String instructor = stringParts[2];
            String room = stringParts[3];
            return new ClassTime(time,room, type, instructor);
        }
    }
}
