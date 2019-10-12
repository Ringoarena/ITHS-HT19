package state;

public class NewEmployeeState extends EmployeeState {

    @Override
    public String getDescription() {
        return "New employee";
    }

    @Override
    public double raiseSalary(double currentSalary) {
        return currentSalary;
    }

    NewEmployeeState() {
    }
}
