import java.util.SortedSet;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

/**
 * Class to render sets of Events
 *
 * @author cmcl
 */
public class EventRenderer extends JList
                           implements TableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table,
                                                   Object set,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        if (set == null) return null;
        SortedSet<Event> eventSet = (SortedSet<Event>) set;
        setListData(eventSet.toArray());
        return this;
    }
}
