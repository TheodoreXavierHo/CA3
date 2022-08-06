import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    private final ArrayList<Student> students = new ArrayList<>();
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Runs the programme and prints the options
        run();
    }

    public static void run() {
        System.out.printf("Welcome to the Student Tracker Application.%n%n");
        GradeTracker gradeTracker = new GradeTracker();

        int choice = 0;

        gradeTracker.students.add(new Student("Theodore", "12345"));
        gradeTracker.students.get(gradeTracker.getIndexNumber("Theodore")).
                setModules("PF", "PF01", "Java", 100);
        gradeTracker.students.
                get(gradeTracker.getIndexNumber("Theodore")).
                getModules().get(
                        gradeTracker.getIndexNumber("PF01")
                ).setAssessments("CA1", "CT", 100, 100);

        while (choice != 4) {
            choice = nextInt(String.format(
                    "%nPlease select the following menu options:%n" +
                    "1. Student Management%n" +
                    "2. Module Management%n" +
                    "3. Assessment Management%n" +
                    "4. End Programme%n" +
                    "Enter Choice: "));


            switch (choice) {
                case 1:
                    gradeTracker.studentManagementOptions();
                    break;
                case 2:
                    gradeTracker.moduleManagementOptions();
                    break;
                case 3:
                    gradeTracker.assessmentManagementOptions();
                    break;
                default:
                    if (choice != 4) {
                        System.out.println("Please select a correct option");
                    }
                    break;
            }
        }
        System.out.printf("%n%nApplication Closed!%nHave a Nice Day!");
    }

    // Student Management & Methods
    public void studentManagementOptions() {
        int subChoice = 0;
        while(subChoice != 5) {

            subChoice = nextInt(String.format(
                    "%nStudent Management Options:%n" +
                    "1. Create New Student%n" +
                    "2. Delete New Students%n" +
                    "3. Calculate Student's GPA%n" +
                    "4. View all Students%n" +
                    "5. Return to Main Menu%n" +
                    "Enter Choice: "));

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
                    if (subChoice != 5) {
                        System.out.printf("%nPlease select the correct option");
                    }
                    break;
            }
        }
    }

    public void addNewStudent() {
        String name = getStudentName();
        String studentID = getStudentID();

        // Check if student already exists
        if (!checkIfStudent(name,studentID)) {
            this.students.add(new Student(name, studentID));
            System.out.println("Name - Student ID");
            System.out.printf("%s - %s%n", this.students.get(getIndexNumber(name)).getName(),
                    this.students.get(getIndexNumber(name)).getStudentID());
            System.out.println();
            System.out.printf("%nStudent Added Successfully");
        } else {
            System.out.printf("%nStudent already exist!");
        }
        System.out.println();
    }

    public void deleteStudent() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();

            // Check if student already exists
            if (checkIfStudent(name,studentID)) {
                this.students.remove(getIndexNumber(name));
                System.out.printf("%nStudent Removed Successfully");
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void calculateStudentGPA() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();

            // Check if student already exists
            if (checkIfStudent(name,studentID)) {
                System.out.printf("%n%s's GPA is: %.2f", name,
                        this.students.get(getIndexNumber(name)).getGPA());
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void viewAllStudentDetails() {
        System.out.println("Name - Student ID");
        for (int i = 0; i < this.students.size(); i++) {
            System.out.printf("%d: %s - %s%n", i+1, this.students.get(i).getName(),
                    this.students.get(i).getStudentID());
        }
    }

    // Checks if the student exist in the Students Array List if so, return true if not returns false
    public boolean checkIfStudent(String name, String studentID) {
        if (this.students.size() > 0) {
            for (Student student : students) {
                if (student.getName().equals(name) &&
                        student.getStudentID().equals(studentID)) {
                    return true;
                }
            }
        }
        return false;
    }


    // Module Management & Methods
    public void moduleManagementOptions() {
        int subChoice = 0;
        while(subChoice != 6) {
            subChoice = nextInt(String.format(
                    "%nModule Management Options:%n" +
                    "1. Add modules to student%n" +
                    "2. Remove modules from student%n" +
                    "3. Calculate Student's marks for module%n" +
                    "4. Calculate Student's grade for module%n" +
                    "5. Display all Student's modules%n" +
                    "6. Return to Main Menu%n" +
                    "Enter Choice: "
            ));

            switch (subChoice) {
                case 1:
                    System.out.println();
                    addModule();
                    break;
                case 2:
                    System.out.println();
                    removeModule();
                    break;
                case 3:
                    System.out.println();
                    calculateStudentMarks();
                    break;
                case 4:
                    System.out.println();
                    calculateStudentGrade();
                    break;
                case 5:
                    System.out.println();
                    displayAllStudentModules();
                    break;
                default:
                    if (subChoice != 6) {
                        System.out.printf("%nPlease select the correct option");
                    }
                    break;
            }
        }
    }

    public void addModule() {
        String name = getStudentName();
        String studentID = getStudentID();
        if (students.size() > 0) {
            if (checkIfStudent(name, studentID)) {
                System.out.printf("%nEnter Module Name: ");
                String moduleName = input.nextLine();

                System.out.print("Enter Module Code: ");
                String moduleCode = input.nextLine();

                System.out.print("Enter Descriptor: ");
                String descriptor = input.nextLine();

                System.out.print("Enter CreditUnits: ");
                int creditUnits = input.nextInt();

                this.students.get(getIndexNumber(name)).
                        setModules(moduleName, moduleCode, descriptor, creditUnits);

                System.out.printf("%nProgramme - Module Code - Descriptor - Credit Units%n");
                this.students.get(getIndexNumber(name)).
                        getModuleList(this.students.
                        get(getIndexNumber(name)).getIndexNumber(moduleName));

            } else {
                System.out.printf("%nStudent does not exist!");
            }
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void removeModule() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();

            // Check if student already exists
            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    this.students.get(getIndexNumber(name)).
                            removeModules(this.students.get(getIndexNumber(name))
                                    .getIndexNumber(moduleName));

                    this.students.remove(getIndexNumber(name));
                    System.out.printf("%nModule Removed Successfully");
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();
        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void calculateStudentMarks() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    System.out.printf("%nTotal Marks: %.0f%%",
                            (this.students.get(getIndexNumber(name)).
                            getModules().get(students.get(getIndexNumber(name)).
                                    getIndexNumber(moduleName)).getOverallMarks()) * 100);
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void calculateStudentGrade() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    System.out.printf("%nGrade: %s", this.students.get(getIndexNumber(name)).
                            getModules().get(students.get(getIndexNumber(name)).
                                    getIndexNumber(moduleName)).getOverallGrade());
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void displayAllStudentModules() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();

            if (checkIfStudent(name,studentID)) {
                if (this.students.get(getIndexNumber(name)).getModules().isEmpty()) {
                    System.out.println("There is no modules assigned to " + name);
                } else {
                    System.out.printf("%nProgramme - Module Code - Descriptor - Credit Units%n");
                    this.students.get(getIndexNumber(name)).getAllModules();
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public boolean checkIfModule(String name, String moduleName) {
        if (this.students.get(getIndexNumber(name)).getModules().size() > 0) {
            return this.students.
                    get(getIndexNumber(name)).
                    getModules().
                    get(this.students.
                            get(getIndexNumber(name)).
                            getIndexNumber(moduleName)
                    ).getName().
                    equals(moduleName);
        } else {
            return false;
        }
    }


    // Assessment Management & Methods
    public void assessmentManagementOptions() {
        int subChoice = 0;
        while(subChoice != 5) {
            subChoice = nextInt(String.format(
                    "%nAssessment Management Options:%n" +
                    "1. Add any number of Assessments to a Module that is assigned to a student%n" +
                    "2. Remove any Assessment in a Module assigned to a student%n" +
                    "3. Set or Remove marks from Assessment%n" +
                    "4. Display all assessment for a module taken by a student%n" +
                    "5. Return to Main Menu%n" +
                    "Enter Choice: "
            ));

            switch (subChoice) {
                case 1:
                    System.out.println();
                    addAssessments();
                    break;
                case 2:
                    System.out.println();
                    removeAssessments();
                    break;
                case 3:
                    System.out.println();
                    addOrRemoveMarks();
                    break;
                case 4:
                    System.out.println();
                    displayAllStudentModelsAssessments();
                    break;
                default:
                    if (subChoice != 5) {
                        System.out.printf("%nPlease select the correct option");
                    }
                    break;
            }
        }
    }

    public void addAssessments() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();

            System.out.printf("%nEnter Assessment's Name: ");
            String assessmentName = input.nextLine();

            System.out.print("Enter Descriptor: ");
            String descriptor = input.nextLine();

            System.out.print("Enter total achievable marks: ");
            double totalMarks = input.nextDouble();

            System.out.print("Enter weightage percent: ");
            double weightage = input.nextDouble();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    this.students.
                            get(getIndexNumber(name)).
                            getModules().get(
                                    getIndexNumber(moduleName)
                            ).setAssessments(assessmentName, descriptor, totalMarks, weightage);

                    System.out.printf("%nTest - Descriptor - Total Achievable Marks - Weightage%n");
                    this.students.
                            get(getIndexNumber(name)).
                            getModules().get(getIndexNumber(moduleName)).
                            getAssessmentList(
                                    this.students.
                                    get(getIndexNumber(name)).
                                    getModules().
                                    get(getIndexNumber(moduleName)).
                                    getIndexNumber(assessmentName)
                            );
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void removeAssessments() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();
            String assessmentName = getAssessmentName();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    if (checkIfAssessment(name, moduleName, assessmentName)) {
                        this.students.
                                get(getIndexNumber(name)).
                                getModules().
                                get(getIndexNumber(moduleName)).
                                getAssessments().
                                remove(getIndexNumber(assessmentName));
                    } else {
                        System.out.println("There is no assessments assign to this modules!");
                    }
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void addOrRemoveMarks() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();
            String assessmentName = getAssessmentName();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    if (checkIfAssessment(name, moduleName, assessmentName)) {

                        int choice = nextInt(String.format(
                                "%nMarks Setter/Remover%n" +
                                "1. Set Marks%n" +
                                "2. Remove Marks%n" +
                                "3. Quit%n" +
                                "Enter: "));

                        switch (choice) {
                            case 1:
                                System.out.println("Marks between 0 to " + this.students.
                                        get(getIndexNumber(name)).
                                        getModules().
                                        get(this.students.
                                                get(getIndexNumber(name)).
                                                getIndexNumber(moduleName)
                                        ).
                                        getAssessments().
                                        get(this.students.
                                                get(getIndexNumber(name)).
                                                getModules().
                                                get(this.students.
                                                        get(getIndexNumber(name)).
                                                        getIndexNumber(moduleName)
                                                ).getIndexNumber(assessmentName)
                                        ).getTotalMarks());
                                System.out.printf("%nEnter Marks: ");
                                double marks = input.nextDouble();

                                // Add Marks
                                this.students.
                                        get(getIndexNumber(name)).
                                        getModules().
                                        get(this.students.
                                                get(getIndexNumber(name)).
                                                getIndexNumber(moduleName)
                                        ).
                                        getAssessments().
                                        get(this.students.
                                                get(getIndexNumber(name)).
                                                getModules().
                                                get(this.students.
                                                        get(getIndexNumber(name)).
                                                        getIndexNumber(moduleName)
                                                ).getIndexNumber(assessmentName)
                                        ).setMarks(marks);
                                break;
                            case 2:
                                // Remove Marks
                                this.students.
                                        get(getIndexNumber(name)).
                                        getModules().
                                        get(this.students.
                                                get(getIndexNumber(name)).
                                                getIndexNumber(moduleName)).
                                        getAssessments().remove(
                                                (this.students.
                                                        get(getIndexNumber(name)).
                                                        getModules().
                                                        get(this.students.
                                                                get(getIndexNumber(name)).
                                                                getIndexNumber(moduleName)
                                                        ).getIndexNumber(assessmentName)
                                                )
                                        );
                                break;
                        }
                    } else {
                        System.out.println("There is no assessments assign to this modules!");
                    }
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }

    public void displayAllStudentModelsAssessments() {
        if (this.students.size() > 0) {
            String name = getStudentName();
            String studentID = getStudentID();
            String moduleName = getModuleName();

            if (checkIfStudent(name,studentID)) {
                if (checkIfModule(name, moduleName)) {
                    if (this.students.get(getIndexNumber(name)).
                            getModules().get(this.students.get(
                                    getIndexNumber(name)).
                                    getIndexNumber(moduleName)
                            ).getAssessments().isEmpty()) {
                        System.out.printf("There is no assessments assigned to %s", moduleName);
                    } else {
                        System.out.printf("%nTest - Descriptor - Total Achievable Marks - Weightage%n");
                        this.students.
                                get(getIndexNumber(name)).
                                getModules().
                                get(this.students.get(
                                        getIndexNumber(name)).
                                        getIndexNumber(moduleName)).
                                getAllAssessments();
                    }
                } else {
                    System.out.println("There is no modules assign to this student!");
                }
            } else {
                System.out.printf("%nStudent does not exist!");
            }
            System.out.println();

        } else {
            System.out.printf("%nThere is no student in the list!");
        }
        System.out.println();
    }


    // Check if assessment exist in Array List if so, return true if not returns false
    public boolean checkIfAssessment(String name, String moduleName, String assessmentName) {
        if (this.students.get(getIndexNumber(name)).getModules().size() > 0) {
            return this.students.
                    get(getIndexNumber(name)).
                    getModules().
                    get(this.students.
                            get(getIndexNumber(name)).
                            getIndexNumber(moduleName)).
                    getAssessments().get(this.students.
                            get(getIndexNumber(name)).
                            getIndexNumber(moduleName)).
                    getName().
                    equals(assessmentName);
        } else {
            return false;
        }
    }

    // Commonly used methods
    // Gets Student name
    public String getStudentName() {
        // Ask user for name of student
        System.out.print("Enter student's name: ");
        return input.nextLine();
    }

    // Gets Student ID
    public String getStudentID() {
        // Ask user for studentID of student
        System.out.print("Enter studentID number: ");
        return input.nextLine();
    }

    // Gets Module Name
    public String getModuleName() {
        System.out.print("Enter Module Name: ");
        return input.nextLine();
    }

    // Gets Assessment Name
    public String getAssessmentName() {
        System.out.print("Enter Assessment's Name: ");
        return input.nextLine();
    }

    // Gets the Student's Index Number in the Students Array List
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

    // Code Found on https://coderanch.com/t/750095/java/catch-loop-input-mismatch-exception
    // Used for exception handling when user inputs a wrong data type into a Integer
    public static int nextInt(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            System.out.printf("Incorrect format for number%n" +
                    "Please re-enter number: ");
            input.next(); // remove and ignore next token
        }
        return input.nextInt();
    }
    /*. Unused Double Version
    public static double nextDouble(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            System.out.print(
                    "Incorrect format for number: please try again: ");
            input.next(); // remove and ignore next token
        }
        return input.nextDouble();
    }
     */
}

