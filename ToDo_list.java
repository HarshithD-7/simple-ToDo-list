/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.technohacks_internship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo_list extends JFrame {
    DefaultListModel<String> toDoListModel;
    JList<String> toDoList;
    JScrollPane scrollPane;
    JTextField itemTextField;
    JButton addButton;
    JButton removeButton;
    JTextArea viewTextArea;

    public ToDo_list() {
  
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);

        scrollPane = new JScrollPane(toDoList);

        itemTextField = new JTextField();

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = itemTextField.getText();
                if (!newItem.isEmpty()) {
                    toDoListModel.addElement(newItem);
                    itemTextField.setText("");
                }
            }
        });

        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toDoListModel.remove(selectedIndex);
                }
            }
        });

        viewTextArea = new JTextArea();
        viewTextArea.setEditable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.8;
        gbc.weighty = 0.0;
        add(itemTextField, gbc);

        gbc.gridx++;
        gbc.weightx = 0.1;
        add(addButton, gbc);

        gbc.gridx++;
        gbc.weightx = 0.1;
        add(removeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        add(viewTextArea, gbc);

        toDoList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedItem = toDoListModel.getElementAt(selectedIndex);
                    viewTextArea.setText("Selected Item: " + selectedItem);
                } else {
                    viewTextArea.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ToDo_list toDoListGUI = new ToDo_list();
                toDoListGUI.setVisible(true);
            }
        });
    }
}
