import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Common extends JFrame {

	private static final long serialVersionUID = 1L;

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