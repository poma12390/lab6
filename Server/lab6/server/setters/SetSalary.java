package lab6.server.setters;

import lab6.common.Worker;
import lab6.common.exceptions.InvalidSalaryException;

public class SetSalary {
    public static void setSalary(String salary, Worker bum) throws InvalidSalaryException, NumberFormatException{
        if (salary.isEmpty()) {
            throw new InvalidSalaryException();
        } else {
            float f = Float.parseFloat(salary);
            if (f == 0 | f < 0) {
                throw new InvalidSalaryException();
            } else {
                bum.setSalary(f);
            }
        }
    }
}
