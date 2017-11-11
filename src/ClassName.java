public class ClassName {
    private String name;
    private String department;

    public ClassName(String className){
        String[] deptCode = className.split(" ");

        name = deptCode[0];
        department = deptCode[1];
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}
