import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

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
        
        App.startMenu();


    }

}