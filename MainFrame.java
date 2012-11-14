import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

/**
 * Main class for GUI
 * 
 * @author cmcl
 * @version 1.0
 */
public class MainFrame extends JFrame {
	private static JPanel main;

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
	}

	public void setupGui() {
		setTitle("IS3 Calendar");
		setSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = new JPanel();
		main.setLayout(new BorderLayout());
		getContentPane().add(main);
		setJMenuBar(Common.createMenuBar());
		generateMonthGrid();
		setVisible(true);
	}

	private static void generateMonthGrid() {
		TableModel monthView = new MonthDataModel(3);
		JTable month = new JTable(monthView);
		JScrollPane scrollPane = new JScrollPane(month);
		month.setRowHeight(100);
		main.add(scrollPane, BorderLayout.CENTER);
	}
}
