public class ClassName {
    private String name;
    private String department;

    public ClassName(String department, String name) {
        this.department = department;
        this.name = name;
    }

    /**
     * Takes className as CS1A and splits in CS and 1A
     * @param className CS1A
     */
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
