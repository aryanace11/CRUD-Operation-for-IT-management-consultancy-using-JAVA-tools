package itmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Project {

    private String projectId;
    private String projectName;
    private String startDate;
    private String endDate;
    private String status;
    private String projectDescription;
    private String clients;
    private String consultants;

    public Project(String projectId, String projectName, String startDate, String endDate, String status,
                   String projectDescription, String clients, String consultants) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projectDescription = projectDescription;
        this.clients = clients;
        this.consultants = consultants;
    }

    // Add getters for all fields
    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getClients() {
        return clients;
    }

    public String getConsultants() {
        return consultants;
    }
}

public class ProjectDetails extends JFrame implements ActionListener {

    JTextField tfProjectId, tfProjectName, tfStartDate, tfEndDate, tfStatus, tfProjectDescription, tfClients, tfConsultants;
    JButton save;

    ProjectDetails() {
        setTitle("Project Details");
        setLayout(null);

        JLabel label = new JLabel("Project Details");
        label.setFont(new Font("Raleway", Font.BOLD, 25));
        label.setBounds(150, 20, 300, 40);
        add(label);

        JLabel lblProjectId = new JLabel("Project ID");
        lblProjectId.setBounds(30, 80, 100, 30);
        add(lblProjectId);

        tfProjectId = new JTextField();
        tfProjectId.setBounds(150, 80, 200, 30);
        add(tfProjectId);

        JLabel lblProjectName = new JLabel("Project Name");
        lblProjectName.setBounds(30, 130, 100, 30);
        add(lblProjectName);

        tfProjectName = new JTextField();
        tfProjectName.setBounds(150, 130, 200, 30);
        add(tfProjectName);

        JLabel lblStartDate = new JLabel("Start Date");
        lblStartDate.setBounds(30, 180, 100, 30);
        add(lblStartDate);

        tfStartDate = new JTextField();
        tfStartDate.setBounds(150, 180, 200, 30);
        add(tfStartDate);

        JLabel lblEndDate = new JLabel("End Date");
        lblEndDate.setBounds(30, 230, 100, 30);
        add(lblEndDate);

        tfEndDate = new JTextField();
        tfEndDate.setBounds(150, 230, 200, 30);
        add(tfEndDate);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(30, 280, 100, 30);
        add(lblStatus);

        tfStatus = new JTextField();
        tfStatus.setBounds(150, 280, 200, 30);
        add(tfStatus);

        JLabel lblProjectDescription = new JLabel("Project Description");
        lblProjectDescription.setBounds(30, 330, 150, 30);
        add(lblProjectDescription);

        tfProjectDescription = new JTextField();
        tfProjectDescription.setBounds(150, 330, 200, 30);
        add(tfProjectDescription);

        JLabel lblClients = new JLabel("Clients");
        lblClients.setBounds(30, 380, 100, 30);
        add(lblClients);

        tfClients = new JTextField();
        tfClients.setBounds(150, 380, 200, 30);
        add(tfClients);

        JLabel lblConsultants = new JLabel("Consultants");
        lblConsultants.setBounds(30, 430, 100, 30);
        add(lblConsultants);

        tfConsultants = new JTextField();
        tfConsultants.setBounds(150, 430, 200, 30);
        add(tfConsultants);

        save = new JButton("Save");
        save.setBounds(150, 480, 100, 30);
        save.addActionListener(this);
        add(save);

        setSize(500, 600);
        setLocation(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            try {
                String projectId = tfProjectId.getText();
                String projectName = tfProjectName.getText();
                String startDate = tfStartDate.getText();
                String endDate = tfEndDate.getText();
                String status = tfStatus.getText();
                String projectDescription = tfProjectDescription.getText();
                String clients = tfClients.getText();
                String consultants = tfConsultants.getText();

                Project project = new Project(projectId, projectName, startDate, endDate, status,
                                              projectDescription, clients, consultants);
                Conn c = new Conn();

                String query = "INSERT INTO projects (project_id, project_name, start_date, end_date, status, project_description, clients, consultants) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, project.getProjectId());
                ps.setString(2, project.getProjectName());
                ps.setString(3, project.getStartDate());
                ps.setString(4, project.getEndDate());
                ps.setString(5, project.getStatus());
                ps.setString(6, project.getProjectDescription());
                ps.setString(7, project.getClients());
                ps.setString(8, project.getConsultants());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Project details saved successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error while saving project details");
                }

                c.c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProjectDetails();
    }
}
