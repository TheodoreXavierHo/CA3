import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    private final ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        // Runs the programme and prints the options
        run();
    }

    public static void run() {
        // System.out.printf("Welcome to the Student Tracker Application.%n%n");
        // Wrote bottom as a slight joke.
        System.out.printf("%s %s %s %s %s %s.%n%n", "Welcome", "to", "the", "Student", "Tracker", "Application");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        GradeTracker gradeTracker = new GradeTracker();

        while (choice != 4) {
            System.out.printf("%nPlease select the following menu options:%n" +
                    "1. Student Management%n" +
                    "2. Module Management%n" +
                    "3. Assessment Management%n" +
                    "4. End Programme%n" +
                    "> ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    gradeTracker.studentManagementOptions(); // DONE
                    break;
                case 2:
                    gradeTracker.moduleManagementOptions();
                    break;
                case 3:
                    gradeTracker.assessmentManagementOptions();
                    break;
                default:
                    System.out.println("Please select the correct option");
                    break;
            }
        }
        System.out.printf("Application Closed!%nHave a Nice Day!");
    }

    public void studentManagementOptions() {
        Scanner input = new Scanner(System.in);
        int subChoice = 0;
        while(subChoice !=5) {
            System.out.printf("%nStudent Management Options:%n" +
                    "1. Create New Student%n" +
                    "2. Delete New Students%n" +
                    "3. Calculate Student's GPA%n" +
                    "4. View all Students%n" +
                    "5. Return to Main Menu%n" +
                    "> ");
            subChoice = input.nextInt();

            switch (subChoice) {
                case 1:
                    System.out.println();
                    addNewStudent();
                    break;
                case 2:
                    System.out.println();
                    deleteStudent();
                    break;
                case 3:
                    System.out.println();
                    calculateStudentGPA();
                    break;
                case 4:
                    System.out.println();
                    viewAllStudentDetails();
                    break;
                default:
                    System.out.printf("%nPlease select the correct option");
                    break;
            }
        }
    }

    public void addNewStudent() {
        Scanner input = new Scanner(System.in);

        // Ask user for name of student
        System.out.print("Please enter student's name: ");
        String name = input.nextLine();

        // Ask user for studentID of student
        System.out.print("Please enter studentID number: ");
        String studentID = input.nextLine();

        // Check if student already exists
        if (!checkIfStudent(name,studentID)) {
            this.students.add(new Student(name, studentID));
            System.out.printf("%nStudent Added Successfully");
        } else {
            System.out.printf("%nStudent already exist!");
        }
        System.out.println();
    }

    public void deleteStudent() {
        Scanner input = new Scanner(System.in);

        if (this.students.size() > 0) {
            // Ask user for name of student
            System.out.print("Please enter student's name: ");
            String name = input.nextLine();

            // Ask user for studentID of student
            System.out.print("Please enter studentID number: ");
            String studentID = input.nextLine();

            // Check if student already exists
            if (checkIfStudent(name,studentID)) {
                this.students.remove(getIndexNumber(name));
                System.out.printf("%nStudent Removed Successfully");
            } else {
                System.out.printf("%nStudent dose not exist!");
            }
            System.out.println();
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
    }

    public void calculateStudentGPA() {
        Scanner input = new Scanner(System.in);
        if (this.students.size() > 0) {
            // Ask user for name of student
            System.out.print("Please enter student's name: ");
            String name = input.nextLine();

            // Ask user for studentID of student
            System.out.print("Please enter studentID number: ");
            String studentID = input.nextLine();

            // Check if student already exists
            if (checkIfStudent(name,studentID)) {
                System.out.printf("%n%s's GPA is: %.2f", name, this.students.get(getIndexNumber(name)).getGPA());
            } else {
                System.out.printf("%nStudent dose not exist!");
            }
            System.out.println();
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
    }

    public void viewAllStudentDetails() {
        for (int i = 0; i < this.students.size(); i++) {
            System.out.printf("%d: %s - %s%n", i+1, this.students.get(i).getName(),
                    this.students.get(i).getStudentID());
        }
    }










    public void moduleManagementOptions() {
        //Scanner input = new Scanner(System.in);
    }

    public void assessmentManagementOptions() {
        //Scanner input = new Scanner(System.in);
    }

    public int getIndexNumber(String name) {
        int index = 0;
        if (this.students.size() > 0){
            for (int x = 0; x < this.students.size(); x++) {
                if ((this.students.get(x).getName()).equals(name)) {
                    index = x;
                    break;
                }
            }
        }
        return index;
    }

    public boolean checkIfStudent(String name, String studentID) {
        if (this.students.size() > 0) {
            for (Student student : students) {
                if (student.getName().equals(name) && student.getStudentID().equals(studentID)) {
                    return true;
                }
            }
        }
        return false;
    }
}





















































/*.
    public static int getIndexNumber(String name, ArrayList<Assessment> assessments) {
        int index = -1;
        for (int x = 0; x < (assessments.size()); x++) {
            if ((assessments.get(x).getName()).equals(name)) {
                index = x;
                break;
            }
        }

        return index;
    }
}
*/

/*.
Have it when running the getIndexNumber to have a check if getIndexNumber is -1;
throw an IllegalArgumentException or ask the user to retype in the name or there is no
user by that name.

if (getIndexNumber(name, assessments) == -1) {
    throw new IllegalArgumentException("There is no user by that name");
    // Or something like this
}
*/

/* Test Code.
   To be removed after released version 1.0

        Module test = new Module("PF", "PF001", "Program", 100);

        ArrayList<Assessment> assessments = new ArrayList<>();

        System.out.println("Before");
        test.getAllAssessments();

        assessments.add(new Assessment("CA1", "Descriptor1" , 100, 10));
        assessments.add(new Assessment("CA2", "Descriptor2" , 100, 20));
        assessments.add(new Assessment("CA3", "Descriptor3" , 100, 30));

        System.out.println("After");
        test.setAssessments(assessments);

        test.getAllAssessments();

        System.out.println();
        test.getAssessment(1);

        assessments.add(new Assessment("CA4", "Des4", 100, 40));

        System.out.println("After");
        test.setAssessments(assessments);

        test.getAllAssessments();

        int index = getIndexNumber("CA2", assessments);

        System.out.println(" ");
        test.getAssessment(index);

Other Test Code
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jack", "91823"));
        System.out.println(students.get(0).getName()
                + " - " + students.get(0).getStudentID());
        students.get(0).setModules("PF","PFO"," ",100);
        students.get(0).setModules("CN","CNO"," ",100);

        students.get(0).getAllModules();
 */

/*. Some more Test code to be removed.
   public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jack", "91823"));
        System.out.println(students.get(0).getName()
                + " - " + students.get(0).getStudentID());
        students.get(0).setModules("PF", "PFO", "DES", 100);
        students.get(0).setModules("CN", "CNO", "DES2", 100);
        students.get(0).getModules().get(0).setName("Test");

        students.get(0).getAllModules();

        Module module = students.get(0).getModules().get(0);

        module.setAssessments("CA1", "TEST", 100, 100);
        module.setAssessments("CA2", "TEST", 100, 100);
        module.getAllAssessments();

        Assessment assessment = module.getAssessments().get(0);
        Assessment assessment2 = module.getAssessments().get(1);
        System.out.println(assessment.getName());
        System.out.println(assessment2.getName());

        module.getAssessmentList(0);
        module.getAssessmentList(1);

        module.getAssessments().get(0).setMarks(90);
        module.getAssessments().get(1).setMarks(90);
        System.out.println(module.getOverallMarks());
        System.out.println(module.getOverallTotalMarks());
        System.out.println(module.getOverallGrade());
        System.out.println(module.getGradePoint(module.getOverallGrade()));
    }
 */
