import javax.swing.table.AbstractTableModel;
import java.util.Map;
import java.util.SortedSet;
import java.awt.*;
import java.util.TreeSet;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;

/**
 * This class represents each table's data model. This class 
 * represents months of any length, starting on any day of the
 * week.
 * 
 * @author gordon
 * @author VictorPantazi
 */
public class YearDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String[] names = new String[1];
    // Which day (0 based) does this month start on
    private int offset;
    private int days,max,t;
    private SortedSet<Event> data;
    private Map<Date, SortedSet<Event>> dateMap;
    private Date yearDate ;

    public YearDataModel(String name, int off, int d,
		Map<Date, SortedSet<Event>> dateMap) {
        offset = off;
        days = d;
        names[0] = name;
	this.dateMap=dateMap;
	this.yearDate =  new Date(YearView.currentDate);
        this.t = 0;
	this.max=0;
    }

    public String getColumnName(int col) {
        // Only display column name in first row.
        return col == 0 ? names[0] : null;
    }

    public int getOffset() {
        return offset;
    }

    public int getMax() {
        return max;
    }

    public int getBusyness() {
        return this.t;
  }

    public void setYearDateMonth(int i){
        yearDate.setMonth(i);
    }

    public Date getYearDate() {
        return yearDate;
    }

    public void incYearDate() {
        this.yearDate = yearDate.incrementMonth();
    }

    public void setData(SortedSet<Event> e) {
        data = e;
    }

    public int getDays() {
        return days;
    }

    public void setOffset(int i) {
        offset = i;
    }

 
    public void setDays(int i) {
        days = i;
    }

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        // Work out how many weeks + part weeks a month has. The valid
        // values are between 4 and 6.
        int result = (days + offset) / 7;
        if ((days + offset) % 7 != 0)
            result++;
        return result;
    }

    public Object getValueAt(int row, int col) {
        // Cells values are the ith day of the week. Cells before
        // first day in month are blank. Cells after last day in month
        // are blank.
        int i = ((7 * row) + (col + 1) - offset);
        return (i <= days && i > 0) ? i : null;
   /*     if (day != null) {
            Date date = new Date(day, yearDate.getMonth(),
                                 yearDate.getYear());
	    SortedSet<Event> set = dateMap.get(date);
	    
	    t = 0;
	    if(set!=null)
	    	t = set.size();
	    //System.out.println(t+" | "+max);
	    if(t>max)
		max=t;
	    //this.setBackground(new Color(t,t,t));
            //TableCellRenderer cell = this.getCellRenderer(row,col);
	    //cell.setBackground(new Color(t,t,t));
	    if (set == null) {
                set = new TreeSet<Event>();
            }
            Event e = new Event();
            e.setName(day.toString());
            set.add(e);
    	    return set;
        }
	return day;*/
    }

}
