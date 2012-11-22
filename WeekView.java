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
    private JButton nextB, previousB;
    private GridBagConstraints gbc;

    public WeekView(CalendarModel model) {
        super(model);
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
        previousB = new JButton("Previous");
        previousB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.add(previousB);
    }

    private void addNextButton() {
        nextB = new JButton("Next");
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.add(nextB);
    }
}
