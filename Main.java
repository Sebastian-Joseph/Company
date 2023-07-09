import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Setting up terminal
        Company company = Company.getInstance();
        company.printOrganizationChart();
        company.staffEngineeringDepartment();
        company.staffMarketingDepartment();
        company.staffSalesDepartment();
        company.printOrganizationChart();
        company.reduceStaff("Engineering", "Slade Wilson");
        company.adjustSalaries("Marketing", "Roy Harper", -5000);
        company.testInvalidOperations();
        
        // Sets up GUI
        JFrame frame = new JFrame("Grocery Store");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        JLabel label = new JLabel("JFrame By Example");  
        JButton button = new JButton();  
        button.setText("Button");  
        panel.add(label);  
        panel.add(button);  
        frame.add(panel);  
        frame.setSize(200, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);

    }
}