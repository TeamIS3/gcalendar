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
		setSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = new JPanel();
		main.setLayout(new BorderLayout());
		getContentPane().add(main);
		setJMenuBar(Common.createMenuBar());
		generateMonthGrid();
		setVisible(true);
	}

	private static void generateMonthGrid() {
		TableModel monthView = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;

			private String[] names = { "Monday", "Tuesday", "Wednesday",
					"Thursday", "Friday", "Saturday", "Sunday" };

			public String getColumnName(int col) {
				return names[col];
			}

			public int getColumnCount() {
				return 7;
			}

			public int getRowCount() {
				return 6;
			}

			public Object getValueAt(int row, int col) {
				int offset = 3;
				int i = ((7 * row) + (col + 1) - offset);
				return (i < 32 && i > 0) ? i : null;
			}
		};
		JTable month = new JTable(monthView);
		JScrollPane scrollPane = new JScrollPane(month);
		main.add(scrollPane, BorderLayout.CENTER);
	}
}
