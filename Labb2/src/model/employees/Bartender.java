package model.employees;

public class Bartender extends Employee {

    public Bartender(String name, String dob) {
        super(name, dob);
        setSalary(13000);

    }

    @Override
    public double bonus() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + " TIP placeholder";
    }
}
