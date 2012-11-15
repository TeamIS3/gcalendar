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
    
    public BaseView() {}
    
    public void setupGui() {
        // Set up main panel for frame.
		this.setLayout(new BorderLayout());
        
        // Create an upper panel to achieve the correct
        // layout.
        JPanel upperPanel = new JPanel(new BorderLayout());
        JPanel viewPanel = new JPanel(new BorderLayout());
        addViewButtons(viewPanel);
        upperPanel.add(viewPanel, BorderLayout.EAST);
        
        // Populate the main panel.
        this.add(upperPanel, BorderLayout.NORTH);
		setupCalendar();
    }
    
    /**
     * Method called by @see setupGui() to 
     * create the particular calendar view e.g. week, month,
     * year, etc.
     *
     */
    protected abstract void setupCalendar();
    
    private void addViewButtons(JPanel viewPanel) {
         // Create view buttons.
        JButton weekButton = new JButton("Week");
        JButton monthButton = new JButton("Month");
        JButton yearButton = new JButton("Year");
        
        viewPanel.add(weekButton, BorderLayout.WEST);
        viewPanel.add(monthButton, BorderLayout.CENTER);
        viewPanel.add(yearButton, BorderLayout.EAST);
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
}