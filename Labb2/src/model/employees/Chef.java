package model.employees;

public class Chef extends Employee{

    int noOfDrinksDuringWork;
    public Chef(String name, String dob) {
        super(name, dob);
        setSalary(15000);
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
