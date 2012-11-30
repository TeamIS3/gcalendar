import java.util.SortedSet;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

/**
 * Class to render sets of Events
 *
 * @author cmcl
 */
public class EventRenderer extends JList
                           implements TableCellRenderer {
    Border unselectedBorder = null;
    Border selectedBorder = null;
    public EventRenderer() {
        setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table,
                                                   Object set,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        if (set == null) return null;
        SortedSet<Event> eventSet = (SortedSet<Event>) set;
        setListData(eventSet.toArray());
        if (isSelected) {
            if (selectedBorder == null) {
                selectedBorder = BorderFactory.createMatteBorder(2,5,2,5,
                                          table.getSelectionBackground());
            }
            setBorder(selectedBorder);
        } else {
            if (unselectedBorder == null) {
                unselectedBorder = BorderFactory.createMatteBorder(2,5,2,5,
                                          table.getBackground());
            }
            setBorder(unselectedBorder);
        }
        
        setToolTipText("Won't work");
        return this;
    }
}
