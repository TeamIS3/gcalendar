import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

import java.awt.*;

/**
 * Main class for GUI
 * 
 * @author cmcl
 * @version 1.0
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
	}

	public void setupGui() {
		setTitle("IS3 Calendar");
		setSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setJMenuBar(createMenuBar());
        
		BaseView mainPanel = new MonthView();
        mainPanel.setupGui();
        
        getContentPane().add(mainPanel);
		setVisible(true);
	}
    
    public static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		// File menu
		JMenu fileMenu = new JMenu("File");
		// File -> Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);

		// Event menu
		JMenu eventMenu = new JMenu("Event");
		// Event -> New event
		JMenuItem newEventItem = new JMenuItem("New event");
		eventMenu.add(newEventItem);
		// Event -> Edit event
		JMenuItem editEventItem = new JMenuItem("Edit event");
		eventMenu.add(editEventItem);
		// Event -> Delete event
		JMenuItem deleteEventItem = new JMenuItem("Delete event");
		eventMenu.add(deleteEventItem);
		// Event menu finished.
		menuBar.add(eventMenu);

		// Category menu
		JMenu categoryMenu = new JMenu("Category");
		// Category -> View categories
		JMenuItem viewCategoriesItem = new JMenuItem("View categories");
		categoryMenu.add(viewCategoriesItem);
		// Category menu finished.
		menuBar.add(categoryMenu);

		return menuBar;
	}
}
