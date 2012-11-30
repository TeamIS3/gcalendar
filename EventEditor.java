import java.util.SortedSet;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

public class EventEditor extends AbstractCellEditor
                         implements TableCellEditor, ActionListener {
    private SortedSet<Event> eventSet;
    private JButton button;
    protected static final String EDIT = "edit";
    
    private EventRenderer ev = new EventRenderer();
    public EventEditor() {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (EDIT.equals(e.getActionCommand())) {
            System.err.println("Fucking clicked");

            //Make the renderer reappear.
            fireEditingStopped();
        } else {
            System.err.println("Sumit else.");
        }
    }
    
    // Implement the one CellEditor method that
    // AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return eventSet;
    }
    
    //Implement the one method defined by TableCellEditor.
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row,
                                                 int column) {
        eventSet = (SortedSet<Event>) value;
        return ev;
    }
}


