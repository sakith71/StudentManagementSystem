import java.io.*;
import java.util.*;

/**
 * A management system for handling student registrations, deletions, and queries.
 * Provides functionalities to store and load student details, and generate reports.
 */
public class StudentManagementSystem {
    /**
     * The total number of seats available for students.
     */
    private static final int allStudents = 100;
    /**
     * The current count of registered students.
     */
    private static int registerStudents = 0;
    /**
     * An array to store the student objects.
     */
    public static Student[] students = new Student[allStudents];

    /**
     * The main method serves as the entry point for the Student Activity Management System.
     * It displays a menu of options for managing student information and processes user input accordingly.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("\tWelcome to Student Activity Management System");
        boolean isValid = true;
        while (isValid) {
            System.out.println("\n============= Student Management System Menu =============");
            System.out.println("\t\t1. Check available seats");
            System.out.println("\t\t2. Register student (with ID)");
            System.out.println("\t\t3. Delete student");
            System.out.println("\t\t4. Find student (with student ID)");
            System.out.println("\t\t5. Store student details into a file");
            System.out.println("\t\t6. Load student details from the file");
            System.out.println("\t\t7. View the list of students based on their names");
            System.out.println("\t\t8. Additional Controls");
            System.out.println("\t\t9. Exit");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please select an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkAvailableSeats();
                        break;
                    case 2:
                        registerStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        findStudent();
                        break;
                    case 5:
                        storeStudentDetailsToFile();
                        break;
                    case 6:
                        loadStudentDetailsFromFile();
                        break;
                    case 7:
                        viewStudentsByName();
                        break;
                    case 8:
                        additionalControlsMenu();
                        break;
                    case 9:
                        System.out.println("Exiting program.....");
                        isValid = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 9.");
                        break;
                }
            }catch (InputMismatchException ex) {
                System.out.println("WARNING!..... Please enter a valid integer.");
            }
        }
    }

    private static void checkAvailableSeats() {
        System.out.println("Available seats: " + (allStudents - registerStudents));
    }

    private static void registerStudent() {
        if (registerStudents < allStudents) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID to register (w1234567): ");
            String registerStudentId;
            while(true) {
                registerStudentId = scanner.next();
                if (registerStudentId.matches("w\\d{7}") && registerStudentId.length() == 8) {
                    for (int i = 0; i < registerStudents; i++) {
                        if (students[i] != null && registerStudentId.equals(students[i].getStudentId())) {
                            System.out.println("This studentID already register please check it ");
                            return;
                        }
                    }break;
                }else System.out.print("Enter valid student ID to register: ");
            }

            scanner.nextLine();
            System.out.print("Enter student name to register: ");
            String registerStudentName;
            while (true) {
                registerStudentName = scanner.nextLine().toUpperCase();
                if (!registerStudentName.matches("[A-Z]*$") || registerStudentName.isBlank()) {
                    System.out.println("Invalid name");
                    System.out.print("Enter valid student name to register: ");
                } else break;
            }
            Student newStudent = new Student(registerStudentId, registerStudentName);

            for (int i = 0; i < 3; i++) {
                while(true) {
                    try {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Enter marks for Module " + (i + 1) + ": ");
                        double marks = scanner1.nextDouble();
                        if (marks >= 0 && marks <= 100) {
                            newStudent.addModule(i + 1, marks);
                            break;
                        }
                    }catch (InputMismatchException ex) {
                        System.out.println("Please enter a valid integer or double number");
                    }
                }
            }
            students[registerStudents] = newStudent;
            registerStudents++;
            System.out.println("Student registered successfully.");
        } else {
            System.out.println("No available seats for new students.");
        }
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete(w1234567): ");
        String deleteStudentID;
        while(true) {
            deleteStudentID = scanner.next();
            if (deleteStudentID.matches("w\\d{7}") && deleteStudentID.length() == 8) {
                break;
            }
            System.out.print("Enter valid student ID to delete: ");
        }

        boolean found = false;
        for (int i = 0; i < registerStudents; i++) {
            if (students[i].getStudentId().equals(deleteStudentID)) {
                found = true;
                for (int j = i; j < registerStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                registerStudents--;
                System.out.println("Student with ID " + deleteStudentID + " deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + deleteStudentID + " not found.");
        }
    }

    private static void findStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to find(w1234567): ");
        String findStudentID;
        while(true) {
            findStudentID = scanner.next();
            if (findStudentID.matches("w\\d{7}") && findStudentID.length() == 8) {
                break;
            }
            System.out.print("Enter valid student ID to find: ");
        }

        boolean found = false;
        for (int i = 0; i < registerStudents; i++) {
            if (students[i].getStudentId().equals(findStudentID)) {
                found = true;
                System.out.println("Student found:");
                System.out.println("ID: " + students[i].getStudentId());
                System.out.println("Name: " + students[i].getStudentName());
                System.out.println("Module Marks:");
                Module[] modules = students[i].getModules();
                for (Module module : modules) {
                    if (module != null) {
                        System.out.println("Module " + module.getModuleNumber() + ": " + module.getMarks());
                    }
                }
                System.out.println("Average Marks: " + students[i].calculateAverageMarks());
                System.out.println("Grade: " + students[i].calculateGrade());
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + findStudentID + " not found.");
        }
    }

    private static void storeStudentDetailsToFile() {
        try (PrintWriter writer = new PrintWriter("students.txt")) {
            for (int i = 0; i < registerStudents; i++) {
                writer.println(students[i].getStudentId() + ", " + students[i].getStudentName() + ", " + modulesToString(students[i].getModules(), students[i].getModuleCount()));
            }
            System.out.println("Student details stored in file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }



    private static void loadStudentDetailsFromFile() {

        try (Scanner fileScanner = new Scanner(new File("students.txt"))) {
            registerStudents = 0;
            while (fileScanner.hasNextLine() && registerStudents < allStudents) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                String[] moduleMarks = parts[2].trim().split("\\s+");
                Student student = new Student(id, name);
                for (int i = 0; i < moduleMarks.length; i++) {
                    student.addModule(i + 1, Double.parseDouble(moduleMarks[i]));
                }
                students[registerStudents] = student;
                registerStudents++;
            }
            System.out.println("Student details loaded from file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void viewStudentsByName() {
        if (registerStudents == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        for (int i = 0; i < registerStudents - 1; i++) {
            for (int j = 0; j < registerStudents - i - 1; j++) {
                if (students[j].getStudentName().compareTo(students[j + 1].getStudentName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("List of students sorted by name:");
        for (int i = 0; i < registerStudents; i++) {
            System.out.println(" Name: " + students[i].getStudentName()+" , ID: " + students[i].getStudentId());
        }
    }

    private static void additionalControlsMenu() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\n============= Additional Controls Menu =============");
            System.out.println("\t\tC. Generate summary of the system");
            System.out.println("\t\tD. Generate complete report with list of students");
            System.out.println("\t\tE. Back to main menu");
            System.out.print("Enter your choice (C/D/E): ");
            choice = scanner.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'C':
                    generateSystemSummary();
                    break;
                case 'D':
                    generateCompleteReport();
                    break;
                case 'E':
                    System.out.println("Returning to main menu....");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter C, D, or E.");
            }

        } while (choice != 'E');
    }

    private static void generateSystemSummary() {
        int totalRegistrations = registerStudents;
        int module1PassCount = 0, module2PassCount = 0, module3PassCount = 0;

        for (int i = 0; i < registerStudents; i++) {
            Module[] modules = students[i].getModules();
            if (modules[0] != null && modules[0].getMarks() > 40) {
                module1PassCount++;
            }
            if (modules[1] != null && modules[1].getMarks() > 40) {
                module2PassCount++;
            }
            if (modules[2] != null && modules[2].getMarks() > 40) {
                module3PassCount++;
            }
        }

        System.out.println("\n============= System Summary =============");
        System.out.println("Total student registrations: " + totalRegistrations);
        System.out.println("Module 1: Students scored more than 40 marks: " + module1PassCount);
        System.out.println("Module 2: Students scored more than 40 marks: " + module2PassCount);
        System.out.println("Module 3: Students scored more than 40 marks: " + module3PassCount+ "\n");
    }
    private static void generateCompleteReport() {
        // Bubble sort by average marks (highest to lowest)
        for (int i = 0; i < registerStudents - 1; i++) {
            for (int j = 0; j < registerStudents - i - 1; j++) {
                if (students[j].calculateAverageMarks() < students[j + 1].calculateAverageMarks()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\n============= Complete Report =============");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "Student ID", "Student Name", "Module 1", "Module 2", "Module 3", "Total", "Average", "Grade");

        for (int i = 0; i < registerStudents; i++) {
            double totalMarks = 0;
            Module[] modules = students[i].getModules();
            for (Module module : modules) {
                if (module != null) {
                    totalMarks += module.getMarks();
                }
            }
            double averageMarks = students[i].calculateAverageMarks();
            String grade = students[i].calculateGrade();

            System.out.printf("%-10s | %-20s | %-10.2f | %-10.2f | %-10.2f | %-10.2f | %-10.2f | %-10s\n",
                    students[i].getStudentId(), students[i].getStudentName(),
                    modules[0] != null ? modules[0].getMarks() : 0,
                    modules[1] != null ? modules[1].getMarks() : 0,
                    modules[2] != null ? modules[2].getMarks() : 0,
                    totalMarks, averageMarks, grade);
        }
    }

    private static String modulesToString(Module[] modules, int moduleCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moduleCount; i++) {
            sb.append(modules[i].getMarks()).append(" ");
        }
        return sb.toString().trim();
    }

}
