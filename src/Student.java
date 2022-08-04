import java.util.ArrayList;

public class Student {
    private String name; // Student Name
    private String studentID; // Student ID (The description of the module.)
    private ArrayList<Module> modules; // A list of Modules the Student is taking.

    public Student (String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public int getTotalCreditUnits() {
        int total = 0;
        for (Module module : modules) {
            total += module.getCreditUnits();
        }
        return total;
    }






    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public void getAllModules() {
        this.modules.forEach(modules -> {
            System.out.println(modules.getName() + " - " + modules.getModuleCode()
                    + " - " + modules.getDescription() + " - " + modules.getCreditUnits());
        });
    }

    public void getModule(int index) {
        System.out.printf("%s - %s - %s - %d%n", this.modules.get(index).getName(),
                this.modules.get(index).getModuleCode(),
                this.modules.get(index).getDescription(),
                this.modules.get(index).getCreditUnits());
    }
}
