import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Week view for the calendar
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
                for(int i = 0; i < 7; i++) {
                    currentDate.decrement();
                }
                viewLabel.setText(WeekView.this.toString());
            }
        });
        panel.add(previousB);
    }

    private void addNextButton() {
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 7; i++) {
                    currentDate.increment();
                }
                viewLabel.setText(WeekView.this.toString());
            }
        });
        panel.add(nextB);
    }
    
    public String toString() {
        return currentDate.toString();
    }
}
