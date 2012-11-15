import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

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
    private JPanel viewPanel;
    
    public BaseView() {
        super();
        setPreferredSize(new Dimension(900, 700));
    }
    
    public void setupGui() {
        // Set up main panel for frame.
		this.setLayout(new BorderLayout());
        
		setupCalendar();
    }
    
    public JPanel getViewPanel() { return viewPanel; }
    
    /**
     * Method called by @see setupGui() to 
     * create the particular calendar view e.g. week, month,
     * year, etc.
     *
     */
    protected abstract void setupCalendar();
}
