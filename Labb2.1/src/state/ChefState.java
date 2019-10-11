package state;

public class ChefState implements EmployeeState {

    @Override
    public String getDescription() {
        return "Chef";
    }

    @Override
    public double raiseSalary(double currentSalary) {
        return currentSalary * 1.1;
    }

    ChefState() {
    }
}
