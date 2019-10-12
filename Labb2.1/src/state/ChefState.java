package state;

public class ChefState extends EmployeeState {

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
