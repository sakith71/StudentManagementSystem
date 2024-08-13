public class Student {
    private String studentId;
    private String studentName;
    private Module[] modules;
    private int moduleCount;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.modules = new Module[3]; // Assuming each student has 3 modules
        this.moduleCount = 0;
    }

    public void addModule(int moduleNumber, double marks) {
        if (moduleCount < 3) {
            Module module = new Module(moduleNumber, marks);
            modules[moduleCount++] = module;
        } else {
            System.out.println("Cannot add more than 3 modules per student.");
        }
    }

    public double calculateAverageMarks() {
        if (moduleCount == 0) {
            return 0.0;
        }

        double totalMarks = 0;
        for (int i = 0; i < moduleCount; i++) {
            totalMarks += modules[i].getMarks();
        }

        return totalMarks / moduleCount;
    }

    public String calculateGrade() {
        double averageMarks = calculateAverageMarks();
        if (averageMarks >= 80) {
            return "Distinction";
        } else if (averageMarks >= 70) {
            return "Merit";
        } else if (averageMarks >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Module[] getModules() {
        return modules;
    }

    public void setModules(Module[] modules) {
        this.modules = modules;
    }

    public int getModuleCount() {
        return moduleCount;
    }

    public void setModuleCount(int moduleCount) {
        this.moduleCount = moduleCount;
    }
}
