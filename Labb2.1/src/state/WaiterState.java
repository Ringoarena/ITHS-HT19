package state;

public class WaiterState extends EmployeeState {

    @Override
    public String getDescription() {
        return "Waiter";
    }

    @Override
    public double raiseSalary(double currentSalary) {
        return currentSalary*1.05;
    }

    WaiterState() {
    }
}
