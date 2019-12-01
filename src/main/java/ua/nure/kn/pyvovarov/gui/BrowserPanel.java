package ua.nure.kn.pyvovarov.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class BrowserPanel extends JPanel {
private MainFrame parent;
private static final String BROWSE_PANEL_COMPONENT_NAME = "browsePanel";

public BrowserPanel(MainFrame mainFrame) {
parent  = mainFrame;
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
	return null;
}

private JPanel getTablePanel() {
	// TODO Auto-generated method stub
	return null;
}
}
