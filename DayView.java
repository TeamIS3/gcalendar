import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * day view for the calendar. A day is represented by a JTable
 *  of 1 columns, 0 column is a list of hours.
 * 
 * 
 * 
 */
public class DayView extends BaseView {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTable day;
    private DayDataModel dayView;
    private GridBagConstraints gbc;

    public DayView(CalendarModel model, JLabel viewLabel) {
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
        dayView = new DayDataModel();
        day = new JTable(dayView);
        day.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(day);
        day.setRowSelectionAllowed(false);
        day.setRowHeight(50);
        this.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane, gbc);
    }

    private void addPreviousButton() {
        previousB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to last day
                for (int i = 0; i < 1; i++)
                    currentDate.decrement();
                // Update JLabel string to show new date
                viewLabel.setText(DayView.this.toString());
            }
        });
        panel.add(previousB);
    }

    private void addNextButton() {
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to next day
                for (int i = 0; i < 1; i++)
                    currentDate.increment();
                // Update JLabel string to show new date
                viewLabel.setText(DayView.this.toString());
            }
        });
        panel.add(nextB);
    }

    public String toString() {
        // JLabel string shows current date's default format
        return currentDate.toString();
    }

}
