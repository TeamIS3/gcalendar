import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

/**
 * Week view for the calendar
 * 
 * @author gordon
 *
 */
public class WeekView extends BaseView {

    private static final long serialVersionUID = 1L;

    public WeekView() {
        super();
    }

    protected void setupCalendar() {
        TableModel weekView = new WeekDataModel();
        JTable month = new JTable(weekView);
        month.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(month);
        month.setRowHeight(100);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}