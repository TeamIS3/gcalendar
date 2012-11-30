import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class represents a given year by a grid of tables, each table
 * represents a single month.
 * 
 * @author gordon
 * @author VictorPantazi
 */
public class YearView extends BaseView {

    private static final long serialVersionUID = 1L;
    private int localMonth;
    private JPanel gridPanel;
    private YearDataModel yearView;
    // 1 Jan 2011 is a Saturday
    private int offset = 5;
    // Local copy of array of month names
    private String[] names = { "Jan", "Feb", "Mar", "Apr", "May",
            "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    // Local copy of an array of ints.
    private int[] days = { 31, 29, 31, 30, 31, 30, 31,
                           31, 30, 31, 30, 31 };

    public YearView(CalendarModel model, JLabel viewLabel) {
        super(model, viewLabel);
    }

    public void setupCalendar() {
        // Create a four column grid layout panel
        gridPanel = new JPanel(new GridLayout(0, 4));
        panel.setLayout(new BorderLayout());
        panel.add(gridPanel, BorderLayout.CENTER);
        /*
         * Represent each month of the year as a table. Each "cell"
         * of the grid layout plays host to a month.
         */
        addPreviousButton();
        updateMonths();
        addNextButton();
        this.add(panel);
    }
    
    private void updateMonths() {
	Date temp = currentDate;
        offset = Date.getDayFromDate(new Date(1, 1, currentDate.getYear()));
        // Check to see if we need to represent February as 29 days
        days[1] = currentDate.isLeapYear() ? 29 : 28;
        for (int i = 0; i < 12; i++){
            localMonth = i+1;
            addTable(i);
	}
	currentDate = temp;
    }

    private void addTable(int i) {
        yearView = new YearDataModel(names[i], offset, days[i], dateMap);
        yearView.setData(dateMap.get(currentDate));
        // Work out where in the week this month starts
        offset = (offset + days[i]) % 7;
	yearView.setYearDateMonth(localMonth);
        JTable month = new JTable(yearView);
        month.getTableHeader().setReorderingAllowed(false);
        month.setRowSelectionAllowed(false);
        month.setRowHeight(30);
 //       month.setDefaultRenderer(Object.class, new EventRenderer());  //!!!!
//	month.setBackground(new Color((float)(1-(localMonth/12.0)),(float)0.2,
//				(float)0.1));
        JScrollPane scrollPane = new JScrollPane(month);
        this.add(scrollPane, BorderLayout.CENTER); 
        gridPanel.add(scrollPane);
    }
    
    private void addPreviousButton() {
        previousB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to last year
                currentDate.setYear(currentDate.getYear()-1);
                panel.remove(gridPanel);
                gridPanel = new JPanel(gridPanel.getLayout());
                updateMonths();
                panel.add(gridPanel, BorderLayout.CENTER);
		yearView.setData(dateMap.get(currentDate));
                yearView.fireTableDataChanged();
                // Update JLabel string to show new date
                viewLabel.setText(YearView.this.toString());
            }
        });
        panel.add(previousB, BorderLayout.WEST);
    }

    private void addNextButton() {
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move on to next year
                currentDate.setYear(currentDate.getYear()+1);
                panel.remove(gridPanel);
                gridPanel = new JPanel(gridPanel.getLayout());
                updateMonths();
                panel.add(gridPanel, BorderLayout.CENTER);
		yearView.setData(dateMap.get(currentDate));
                yearView.fireTableDataChanged();
                // Update JLabel string to show new date
                viewLabel.setText(YearView.this.toString());
            }
        });
        panel.add(nextB, BorderLayout.EAST);
    }

    public String toString() {
        return currentDate.getYear() + "";
    }
    
}
