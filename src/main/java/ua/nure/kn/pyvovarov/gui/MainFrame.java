package ua.nure.kn.pyvovarov.gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.*;

public class MainFrame extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private JPanel contentPanel;
	private BrowserPanel browserPanel;
	public MainFrame() {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}
	public void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("”правление пользовател€ми");
		this.setContentPane(getContentPanel());	
	}
	private JPanel getContentPanel() {
if(contentPanel === null) {
	contentPanel = new JPanel();
	contentPanel.setLayout(new BorderLayout());
	contentPanel.add(getBrowserPanel(),BorderLayout.CENTER);
}
		return contentPanel;
		
	}
	private JPanel getBrowserPanel() {
if(browserPanel == null) {
	browserPanel = new BrowserPanel(this);
}
		return browserPanel;
	}
}