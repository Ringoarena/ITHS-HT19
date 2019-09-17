package model.employees;

public class HR extends Employee {

    public HR(String name, String dob, GenderType gender) {
        super(name, dob, gender);
        setSalary(16000);
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
