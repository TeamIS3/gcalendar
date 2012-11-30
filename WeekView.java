import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Week view for the calendar. A week is represented by a JTable
 *  of 8 columns, 0 column is a list of hours.
 * 
 * @author gordon
 * 
 */
public class WeekView extends BaseView {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTable week;
    private WeekDataModel weekView;
    private GridBagConstraints gbc;

    public WeekView(CalendarModel model, JLabel viewLabel) {
        super(model, viewLabel);
    }

    protected void setupCalendar() {
        // Create a GridBagLayout for the two buttons and JTable
        panel = new JPanel(new GridBagLayout());
        setUpGBC();
        addPreviousButton();
        addTable();
        addNextButton();
        this.add(panel, BorderLayout.CENTER);
    }

    private void setUpGBC() {
        gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
    }

    private void addTable() {
        weekView = new WeekDataModel();
        week = new JTable(weekView);
        week.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(week);
        week.setRowSelectionAllowed(false);
        week.setRowHeight(50);
        this.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane, gbc);
    }

    private void addPreviousButton() {
        previousB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to last week
                for (int i = 0; i < 7; i++)
                    currentDate = currentDate.decrement();
                // Update JLabel string to show new date
		weekView.setData(dateMap.get(currentDate));
                weekView.fireTableDataChanged();
                viewLabel.setText(WeekView.this.toString());
            }
        });
        panel.add(previousB);
    }

    private void addNextButton() {
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to next week
                for (int i = 0; i < 7; i++)
                    currentDate = currentDate.increment();
                // Update JLabel string to show new date
		weekView.setData(dateMap.get(currentDate));
                weekView.fireTableDataChanged();
                viewLabel.setText(WeekView.this.toString());
            }
        });
        panel.add(nextB);
    }

    public String toString() {
        // JLabel string shows current date's default format
        return currentDate.toString();
    }

}
