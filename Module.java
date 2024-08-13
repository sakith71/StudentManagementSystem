public class Module {
    private int moduleNumber;
    private double marks;

    public Module(int moduleNumber, double marks) {
        this.moduleNumber = moduleNumber;
        this.marks = marks;
    }

    public int getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(int moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
