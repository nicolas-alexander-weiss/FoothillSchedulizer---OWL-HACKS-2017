public class ClassName {
    private String name;
    private String department;

    public ClassName(String department, String name) {
        this.department = department;
        this.name = name;
    }

    public ClassName(String className){
        String[] deptCode = className.split(" ");

        department = deptCode[0];
        name = deptCode[1];
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
}
