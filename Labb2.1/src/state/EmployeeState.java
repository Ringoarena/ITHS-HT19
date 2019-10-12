package state;

public abstract class EmployeeState {
    private static NewEmployeeState newEmployeeState;
    private static WaiterState waiterState;
    private static ChefState chefState;

    public static EmployeeState getInstance(int decision) {
        switch (decision) {
            case 0:
                if (newEmployeeState == null) {
                    newEmployeeState = new NewEmployeeState();
                }
                return newEmployeeState;
            case 1:
                if (waiterState == null) {
                    waiterState = new WaiterState();
                }
                return waiterState;
            case 2:
                if (chefState == null) {
                    chefState = new ChefState();
                }
                return chefState;
            default:
                return null;
        }
    }

    public abstract String getDescription();
    public abstract double raiseSalary(double currentSalary);
}
