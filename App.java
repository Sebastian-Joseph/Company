import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import java.awt.*;

public class App {
    private static JFrame frame;
    private static Dimension maxSize = new Dimension(100, 50);

    public static void startMenu() {
        frame = new JFrame("Employee Management System");
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel startLabel = new JLabel("Employee Management System");
        JButton startButton = new JButton("Start");

        startPanel.add(startButton);
        mainPanel.add(startLabel, BorderLayout.NORTH);
        mainPanel.add(startPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setSize(500, 300);
                SignIn();
            }
        });
    }

    /*public static void mainView() {
        JPanel viewPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome! What type of employee are you?");
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));

        JButton directorButton = new JButton("Director");
        JButton managerButton = new JButton("Manager");
        JButton employeeButton = new JButton("Employee");

        directorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        managerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        directorButton.setMaximumSize(maxSize);
        managerButton.setMaximumSize(maxSize);
        employeeButton.setMaximumSize(maxSize);

        viewPanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        viewPanel.add(directorButton);
        viewPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        viewPanel.add(managerButton);
        viewPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        viewPanel.add(employeeButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(viewPanel);
        frame.revalidate();
        frame.repaint();

        directorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                directorSignIn();
            }
        });

        managerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                managerView();
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeView();
            }
        });
    } */

    public static void addButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public static void SignIn() {
        JPanel directorCredentials = new JPanel();
        directorCredentials.setLayout(new BoxLayout(directorCredentials, BoxLayout.Y_AXIS));

        JLabel directorWelcome = new JLabel("Enter your name and department here.");
        directorWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField name = new JTextField("Name");
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setMaximumSize(new Dimension(200, 30)); // Set the desired size

        name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (name.getText().equals("Name")) {
                    name.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (name.getText().isEmpty()) {
                    name.setText("Name");
                }
            }
        });

        JTextField department = new JTextField("Department");
        department.setAlignmentX(Component.CENTER_ALIGNMENT);
        department.setMaximumSize(new Dimension(200, 30)); // Set the desired size

        department.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (department.getText().equals("Department")) {
                    department.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (department.getText().isEmpty()) {
                    department.setText("Department");
                }
            }
        });

        String fieldName = name.getText();

        if (Manager.findEmployee(fieldName) == 1) {
            // Do a new method here 
        } else {
            // Do a popup here
        }

        directorCredentials.add(directorWelcome);
        directorCredentials.add(Box.createRigidArea(new Dimension(0, 15)));
        directorCredentials.add(name);
        directorCredentials.add(Box.createRigidArea(new Dimension(0, 15)));
        directorCredentials.add(department);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(directorCredentials);
        frame.revalidate();
        frame.repaint();
    }

}
