import java.util.ArrayList;

public class Director extends Manager {

    private int stockShares;

    public Director (int salary, int bonus, int stockShares, String name, String department, String title, ArrayList<Employee> reports, int tier) throws Exception {
        super(salary, bonus, name, department, title, reports, tier);

        for(Employee employee: reports) {
            if(employee.getTier() >= 3) throw new Exception("ERROR: cannot supervise an Employee of an equal or greater tier.");
        }

        this.stockShares = stockShares;
    }

    public int getStockShares() {
        return stockShares;
    }

}