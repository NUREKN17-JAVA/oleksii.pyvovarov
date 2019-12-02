package ua.nure.kn.pyvovarov.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ua.nure.kn.pyvovarov.db.DataBaseException;

import java.util.ArrayList;


public class BrowserPanel extends JPanel implements ActionListeneristener {
private MainFrame parent;
private JPanel buttonPanel;
private JButton addButton;
private JButton detailsButton;
private JButton deleteButton;
private JButton editButton;
private JScrollPane tablePanel;
private JTable userTable;
private static final String BROWSE_PANEL_COMPONENT_NAME = "browsePanel";

public BrowserPanel(MainFrame frame) {
	parent = frame;
	initialize();
}

private void initialize() {
	// TODO Auto-generated method stub
	this.setName(BROWSE_PANEL_COMPONENT_NAME);
	this.setLayout(new BorderLayout());
	this.add(getTablePanel(),BorderLayout.CENTER);
	this.add(getButtonsPanel(),BorderLayout.CENTER);

}

private JPanel getButtonsPanel() {
	// TODO Auto-generated method stub
	if (buttonPanel == null) {
		buttonPanel = new JPanel();
		buttonPanel.add(getAddButton(), null);
		buttonPanel.add(getEditButton(), null);
		buttonPanel.add(getDeleteButton(), null);
		buttonPanel.add(getDetailsButton(), null);
	}
	return buttonPanel;
}

private JButton getDetailsButton() {
	// TODO Auto-generated method stub
	if (detailsButton == null) {
		detailsButton = new JButton();
		detailsButton.setText("Details");
		detailsButton.setName("detailsButton");
		addButton.setActionCommand("details");
		detailsButton.addActionListener(this);
	}
	return detailsButton;
}

private JButton getDeleteButton() {
	// TODO Auto-generated method stub
	if (deleteButton == null) {
		deleteButton = new JButton();
		deleteButton.setText("Delete");
		deleteButton.setName("deleteButton");
		addButton.setActionCommand("delete");
		deleteButton.addActionListener(this);
	}
	return deleteButton;
}

private JButton getEditButton() {
	// TODO Auto-generated method stub
	if (editButton == null) {
		editButton = new JButton();
		editButton.setText("Edit");
		editButton.setName("editButton");
		addButton.setActionCommand("edit");
		editButton.addActionListener(this);
	}
	return editButton;
}

private JButton getAddButton() {
	// TODO Auto-generated method stub
	if (addButton == null) {
		addButton = new JButton();
		addButton.setText("Add");
		addButton.setName("addButton");
		addButton.setActionCommand("add");
		addButton.addActionListener(this);
	}
	return addButton;
}

private JPanel getTablePanel() {
	// TODO Auto-generated method stub
	if(tablePanel == null) {
		tablePanel = new JScrollPane(getUserTable());
	}
	return tablePanel;
}

private JTable getUserTable() {
	// TODO Auto-generated method stub
	if (userTable == null) {
		userTable = new JTable();
		userTable.setName("userTable");
	}
	return userTable;
}
public void initTable() {
	UserTableModel model;
	try {
		model = new UserTableModel(parent.getDao().findAll());
	} catch (DataBaseException e) {
		model = new UserTableModel(new ArrayList());
		JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	//userTable.setModel(model);
	getUserTable().setModel(model);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String actionCommand = e.getActionCommand();
	if ("add".equalsIgnoreCase(actionCommand)) {
		this.setVisible(false);
		parent.showAddPanel();
	}
}
}
