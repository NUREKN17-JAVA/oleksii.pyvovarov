package ua.nure.kn.pyvovarov.gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.*;

import ua.nure.kn.pyvovarov.db.Dao;
import ua.nure.kn.pyvovarov.db.DaoFactory;

public class MainFrame extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private JPanel contentPanel;
	private AddPanel addPanel;
	private BrowserPanel browserPanel;
	private Dao dao;

	public Dao getDao() {
		return dao;
	}
	public MainFrame() {
		// TODO Auto-generated constructor stub
		super();
		dao = DaoFactory.getInstance().getUserDao();
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
((BrowserPanel) browserPanel).initTable();
		return browserPanel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}
	public void showAddPanel() {
		// TODO Auto-generated method stub
		showPanel(getAddPanel());
	}

	private void showPanel(JPanel panel) {
		// TODO Auto-generated method stub
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		panel.repaint();
	}

	public void showBrowsePanel() {
		// TODO Auto-generated method stub
		showPanel(getBrowsePanel());
	}
	
	private AddPanel getAddPanel() {
		// TODO Auto-generated method stub
		if (addPanel == null) {
			addPanel = new AddPanel(this);
		}
		return addPanel;
		}

}