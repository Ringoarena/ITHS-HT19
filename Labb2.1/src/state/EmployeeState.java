package state;

public abstract class EmployeeState {
    public abstract String getDescription();
    public abstract double raiseSalary(double currentSalary);
}
