import java.util.*;

public class Company {
    
    public static final int EMPLOYEE = 1;
    public static final int MANAGER = 2;
    public static final int DIRECTOR = 3;
    public static final double SHARE_PRICE = 123.45;

    private String name;
    private List<Employee> staff;
    private static Company company;
    
    public static Company getInstance() throws Exception {
        if (company == null) {
            company = new Company("Halffoods");
        }
        return company;
    }

    private Company(String name) throws Exception {
        this.name = name;
        this.staff = new ArrayList<>();

        staff.add(new Director(145000, 1000, 10000, "Jun Yang", "Marketing", "Director of Marketing", new ArrayList<>(), Company.DIRECTOR));
        staff.add(new Director(215000, 2500, 15000, "Andy Zhu", "Engineering", "Director of Engineering", new ArrayList<>(), Company.DIRECTOR));
        staff.add(new Director(1650000, 1500, 25000, "John Cena", "Sales", "Director of Sales", new ArrayList<>(), Company.DIRECTOR));
    }
    

     public void staffEngineeringDepartment() throws Exception {
        Director director = this.getDirector("Engineering");

        if (director != null) {
            Manager qaManager = new Manager(155000, 7500, "Sara Lance", "Engineering", "QA Manager", new ArrayList<>(), Company.MANAGER);
            Manager devManager = new Manager(185000, 10000, "Curtis Holt", "Engineering", "Development Manager", new ArrayList<>(), Company.MANAGER);

            director.hire(qaManager);
            director.hire(devManager);

            Employee qaEmployee1 = new Employee(110000, "Moira Queen", "Engineering", "QA Analyst III");
            Employee qaEmployee2 = new Employee(95000, "Quentin Lance", "Engineering", "QA Analyst II");
            Employee qaEmployee3 = new Employee(80000, "Slade Wilson", "Engineering", "QA Analyst I");

            qaManager.hire(qaEmployee1);
            qaManager.hire(qaEmployee2);
            qaManager.hire(qaEmployee3);

            Employee devEmployee1 = new Employee(125000, "Adrian Chase", "Engineering", "QA Analyst III");
            Employee devEmployee2 = new Employee(105000, "Rene Ramirez", "Engineering", "QA Analyst II");
            Employee devEmployee3 = new Employee(85000, "Dinah Drake", "Engineering", "QA Analyst I");

            devManager.hire(devEmployee1);
            devManager.hire(devEmployee2);
            devManager.hire(devEmployee3);

            }
        }

        public void staffMarketingDepartment() throws Exception {
            Director director = this.getDirector("Marketing");
    
            if (director != null) {
                Manager socialManager = new Manager(115000, 5000, "Malcolm Merlyn", "Marketing", "Social Media Manager", new ArrayList<>(), Company.MANAGER);
    
                director.hire(socialManager);
    
                Employee socialEmployee1 = new Employee(85000, "Thea Queen", "Marketing", "Social Media Analyst III");
                Employee socialEmployee2 = new Employee(65000, "Tommy Merlyn", "Marketing", "Social Media Analyst II");
                Employee socialEmployee3 = new Employee(45000, "Roy Harper", "Marketing", "Social Media Analyst I");
    
                socialManager.hire(socialEmployee1);
                socialManager.hire(socialEmployee2);
                socialManager.hire(socialEmployee3);
            }
        }

        public void staffSalesDepartment() throws Exception {
            Director director = this.getDirector("Sales");
    
            if (director != null) {
                Manager insideSalesManager = new Manager(115000, 15000, "Ricardo Diaz", "Sales", "Inside Sales Manager", new ArrayList<>(), Company.MANAGER);
                Manager outsideSalesManager = new Manager(125000, 25000, "Mar Novu", "Sales", "Outside Sales Manager", new ArrayList<>(), Company.MANAGER);
    
                director.hire(insideSalesManager);
                director.hire(outsideSalesManager);
    
                Employee insideSalesEmployee1 = new Employee(105000, "Emilko Queen", "Marketing", "Inside Sales Reprsentative III");
                Employee insideSalesEmployee2 = new Employee(90000, "Mia Smoak", "Marketing", "Inside Sales Representative II");
    
                insideSalesManager.hire(insideSalesEmployee1);
                insideSalesManager.hire(insideSalesEmployee2);
    
                Employee outsideSalesEmployee1 = new Employee(110000, "William Clayton", "Marketing", "Outside Sales Representative III");
                Employee outsideSalesEmployee2 = new Employee(95000, "Connor Hawke", "Marketing", "Outside Sales Representative II");
    
                outsideSalesManager.hire(outsideSalesEmployee1);
                outsideSalesManager.hire(outsideSalesEmployee2);
            }
        }

        public void reduceStaff(String department, String name) throws Exception {
            Director director = this.getDirector(department);
            Employee employee = this.getEmployee(name);
        
            director.fire(employee);
        }
        

        public void adjustSalaries(String department, String name, int number) throws Exception {
            Director director = this.getDirector(department);
            Employee toGetAdjust = this.getEmployee(name);

            this.printEmployeeDetails(toGetAdjust);
            director.adjustSalary(number, toGetAdjust);
        }

        public void testInvalidOperations() {
            Director director1 = this.getDirector("Marketing");
            Director director2 = this.getDirector("Sales");
            Manager manager1 = (Manager) this.getEmployee("Sara Lance");
            Manager manager2 = (Manager) this.getEmployee("Ricardo Diaz");
    
            try {
                director1.fire(manager1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            try {
                director1.fire(director2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            try {
                Director director = new Director(100000, 0, 0, "Invalid Hire", "Human Resources", "Director of Human Resources", new ArrayList<>(), Company.DIRECTOR);
                manager1.hire(director);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            try {
                Director director = new Director(100000, 0, 0, "Invalid Hire", "Human Resources", "Director of Human Resources", new ArrayList<>(Arrays.asList(new Employee[] { director1, director2 })), Company.DIRECTOR);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            try {
                director1.adjustSalary(10000, manager2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private Director getDirector(String department) {
            for (Employee employee : staff) {
                if (employee.getDepartment().equals(department)) {
                    return (Director) employee;
                }
            }
            return null;
        }
    
        private Employee getEmployee(String name) {
            for (Employee director : staff) {
                Director director1 = (Director) director;
                for (Employee manager: director1.getManagers()) {
                    if (manager.getName().equals(name)) return manager;
                    Manager manager1 = (Manager) manager;
                    for (Employee employee: manager1.getEmployees()) {
                        if (employee.getName().equals(name)) return employee;
                    }
                }
            }
            return null;
        }
    
        private void printEmployeeDetails(Director director) {
            System.out.println("Employee     : " + director.getName());
            System.out.println("Department   : " + director.getDepartment());
            System.out.println("Title        : " + director.getTitle());
            System.out.println("Compensation : " + ((double) director.getSalary() + director.getBonus() + director.getStockShares()));
            System.out.println();
        }
    
        private void printEmployeeDetails(Manager manager) {
            System.out.println("Employee     : " + manager.getName());
            System.out.println("Department   : " + manager.getDepartment());
            System.out.println("Title        : " + manager.getTitle());
            System.out.println("Compensation : " + ((double) manager.getSalary() + manager.getBonus()));
            System.out.println();
        }
    
        private void printEmployeeDetails(Employee employee) {
            System.out.println("Employee     : " + employee.getName());
            System.out.println("Department   : " + employee.getDepartment());
            System.out.println("Title        : " + employee.getTitle());
            System.out.println("Compensation : " + ((double) employee.getSalary()));
            System.out.println();
        }
    
        protected void printOrganizationChart() {
            System.out.println();
            if (staff.size() > 0) {
                System.out.println("Company Org Chart");
                sortStaff();
                for (Employee director : staff) {
                    System.out.println(" - " + director.getName() + ", " + director.getTitle());
                    for (Employee manager: ((Director) director).getManagers()) {
                        if (manager.getTier() <= 1) {
                            System.out.println("   - " + manager.getName() + ", " + manager.getTitle());
                        } else {
                            System.out.println("   - " + manager.getName() + ", " + manager.getTitle());
                            for (Employee employee : ((Manager) manager).getEmployees()) {
                                System.out.println("     - " + employee.getName() + ", " + employee.getTitle());
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    
        public void sortStaff() {
            List<Employee> tempStaff = new ArrayList<>();
            int size = staff.size();
            Employee first;
            for (int x = 0; x < size; x++) {
                first = staff.get(0);
                for (Employee director : staff) {
                    if (director.getDepartment().compareTo(first.getDepartment()) < 0) first = director;
                }
                tempStaff.add(staff.get(staff.indexOf(first)));
                staff.remove(first);
            }
            staff = tempStaff;
        }
    }

