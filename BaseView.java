import java.util.*;

import javax.swing.*;
import java.awt.*;

/**
 * BaseView swing element code here
 * 
 * @author gordon
 * @author cmcl
 * @version 1.0
 */
public abstract class BaseView extends JPanel {
    private static final long serialVersionUID = 1L;
    protected JPanel viewPanel;
    protected JPanel panel;
    protected CalendarModel model;
    protected JButton nextB, previousB;
    protected Map<Date, List<Event>> dateMap;
    
    public BaseView(CalendarModel model) {
        super();
        setPreferredSize(new Dimension(900, 700));
        this.model = model;
        dateMap = new HashMap<Date, List<Event>>();
        populate();
    }
    
    /**
     * Populate the date map with events.
     */
    protected void populate() {
        
    }

    public void setupGui() {
        // Set up main panel for frame.
        this.setLayout(new BorderLayout());
        nextB = new JButton("Next");
        previousB = new JButton("Previous");
        panel = new JPanel(new GridBagLayout());
        setupCalendar();
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }

    /**
     * Method called by @see setupGui() to create the particular calendar view
     * e.g. week, month, year, etc.
     * 
     */
    protected abstract void setupCalendar();
}
