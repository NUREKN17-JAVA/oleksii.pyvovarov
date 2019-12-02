package ua.nure.kn.pyvovarov.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel implements ActionListener {

private MainFrame parent;
private JPanel buttonPanel;
private JPanel fieldPanel;
private JButton cancelButton;
private JButton okButton;
private JTextField dayOfBirthField;
private JTextField lastNameField;
private JTextField firstNameField;

public AddPanel(MainFrame parent) {
	this.parent = parent;
	initialize();
}

private void initialize() {
	// TODO Auto-generated method stub
	this.setLayout(new BorderLayout());
	this.add(getFieldPanel(), BorderLayout.NORTH);
	this.add(getButtonPanel(), BorderLayout.SOUTH);
}

private JPanel getButtonPanel() {
	// TODO Auto-generated method stub
	if (buttonPanel == null) {
		buttonPanel = new JPanel();
		buttonPanel.add(getOkButton(), null);
		buttonPanel.add(getCancelButton(), null);
	}
	return buttonPanel;
}

private JButton getCancelButton() {
	// TODO Auto-generated method stub
	if (cancelButton == null) {
		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		cancelButton.setName("cancelButton");
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);
	}
	return cancelButton;
}

private JButton getOkButton() {
	// TODO Auto-generated method stub
	if (okButton == null) {
		okButton = new JButton();
		okButton.setText("Ok");
		okButton.setName("okButton");
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
	}
	return okButton;
}

private JPanel getFieldPanel() {
	// TODO Auto-generated method stub
	if (fieldPanel == null) {
		fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(2, 3));
		addLabeledField(fieldPanel, "Name", getFirstNameField());
		addLabeledField(fieldPanel, "Surname", getLastNameField());
		addLabeledField(fieldPanel, "Date of birth", getDateOfBirthField());
	}
	return fieldPanel;
}

private JTextField getDateOfBirthField() {
	// TODO Auto-generated method stub
	if (dayOfBirthField == null) {
		dayOfBirthField = new JTextField();
		dayOfBirthField.setName("dayOfBirthField");
	}
	return dayOfBirthField;
}

private JTextField getLastNameField() {
	// TODO Auto-generated method stub
	if (lastNameField == null) {
		lastNameField = new JTextField();
		lastNameField.setName("lastNameField");
	}
	return lastNameField;
}

private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
	// TODO Auto-generated method stub
	JLabel label = new JLabel(labelText);
	label.setLabelFor(textField);
	panel.add(label);
	panel.add(textField);
}

private JTextField getFirstNameField() {
	// TODO Auto-generated method stub
	if (firstNameField == null) {
		firstNameField = new JTextField();
		firstNameField.setName("firstNameField");
	}
	return firstNameField;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}