import java.util.ArrayList;

public class Employee implements Comparable {
    private int tier;
    private int salary;
    private String name;
    private String department;
    private String title;

    public Employee (int salary, String name, String department, String title) {
        this.tier = 1;
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.title = title;

    }
    public int getTier() {
        return tier;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}