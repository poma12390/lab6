package lab6.common.dto;

import lab6.common.Worker;

import java.util.List;

public class FilterBySalaryCommandDto extends AbstractDto{
    private float salary;

    public float getSalary() {
        return salary;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    private List<Worker> workers;

    public void setSalary(float salary) {
        this.salary = salary;
    }
}




