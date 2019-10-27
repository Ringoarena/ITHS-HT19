package sortingStrategy;

import model.Employee;

import java.util.Comparator;

public class NameSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if (e1.getName().compareTo(e2.getName()) == 0) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        } else {
            return e1.getName().compareTo(e2.getName());
        }
    }
}
