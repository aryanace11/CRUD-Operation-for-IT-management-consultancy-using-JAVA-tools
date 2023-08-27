package itmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Client {

    private String clientId;
    private String clientName;
    private String contactPerson;
    private String phone;
    private String address;
    private String email;

    public Client(String clientId, String clientName, String contactPerson, String phone, String address, String email) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}

public class ClientDetails extends JFrame implements ActionListener {

    JTextField tfClientId, tfClientName, tfContactPerson, tfPhone, tfAddress, tfEmail;
    JButton save;

    ClientDetails() {
        setTitle("Client Details");
        setLayout(null);

        JLabel label = new JLabel("Client Details");
        label.setFont(new Font("Raleway", Font.BOLD, 25));
        label.setBounds(150, 20, 300, 40);
        add(label);

        JLabel lblClientId = new JLabel("Client ID");
        lblClientId.setBounds(30, 80, 100, 30);
        add(lblClientId);

        tfClientId = new JTextField();
        tfClientId.setBounds(150, 80, 200, 30);
        add(tfClientId);

        JLabel lblClientName = new JLabel("Client Name");
        lblClientName.setBounds(30, 130, 100, 30);
        add(lblClientName);

        tfClientName = new JTextField();
        tfClientName.setBounds(150, 130, 200, 30);
        add(tfClientName);

        JLabel lblContactPerson = new JLabel("Contact Person");
        lblContactPerson.setBounds(30, 180, 100, 30);
        add(lblContactPerson);

        tfContactPerson = new JTextField();
        tfContactPerson.setBounds(150, 180, 200, 30);
        add(tfContactPerson);

        JLabel lblPhone = new JLabel("Phone No");
        lblPhone.setBounds(30, 230, 100, 30);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(150, 230, 200, 30);
        add(tfPhone);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 280, 100, 30);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(150, 280, 200, 30);
        add(tfAddress);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 330, 100, 30);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(150, 330, 200, 30);
        add(tfEmail);

        save = new JButton("Save");
        save.setBounds(150, 380, 100, 30);
        save.addActionListener(this);
        add(save);

        setSize(400, 480);
        setLocation(500, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            try {
                String clientId = tfClientId.getText();
                String clientName = tfClientName.getText();
                String contactPerson = tfContactPerson.getText();
                String phone = tfPhone.getText();
                String address = tfAddress.getText();
                String email = tfEmail.getText();

                Client client = new Client(clientId, clientName, contactPerson, phone, address, email);
                Conn c = new Conn();

                String query = "INSERT INTO clients (client_id, client_name, contact_person, phone, address, email) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, client.getClientId());
                ps.setString(2, client.getClientName());
                ps.setString(3, client.getContactPerson());
                ps.setString(4, client.getPhone());
                ps.setString(5, client.getAddress());
                ps.setString(6, client.getEmail());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Client details saved successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error while saving client details");
                }

                c.c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ClientDetails();
    }
}
