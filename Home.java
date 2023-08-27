package itmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove, client, project, department, vendor, order, payment;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("IT CONSULTANCY MANAGEMENT");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add details");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View details");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update details");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove details");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        client = new JButton("Client details");
        client.setBounds(650, 200, 150, 40);
        client.addActionListener(this);
        image.add(client);

        project = new JButton("Project details");
        project.setBounds(820, 200, 150, 40);
        project.addActionListener(this);
        image.add(project);

        department = new JButton("Department details");
        department.setBounds(650, 260, 150, 40);
        department.addActionListener(this);
        image.add(department);

        vendor = new JButton("Vendor details");
        vendor.setBounds(820, 260, 150, 40);
        vendor.addActionListener(this);
        image.add(vendor);

        order = new JButton("Order details");
        order.setBounds(735, 320, 150, 40);
        order.addActionListener(this);
        image.add(order);

        payment = new JButton("Payment details");
        payment.setBounds(735, 380, 150, 40);
        payment.addActionListener(this);
        image.add(payment);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == client) {
            setVisible(false);
            new ClientDetails();
        } else if (ae.getSource() == project) {
            setVisible(false);
            new ProjectDetails();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new DepartmentDetails();
        } else if (ae.getSource() == vendor) {
            setVisible(false);
            new VendorDetails();
        } else if (ae.getSource() == order) {
            setVisible(false);
            new OrderDetails();
        } else if (ae.getSource() == payment) {
            setVisible(false);
            new PaymentDetails();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
