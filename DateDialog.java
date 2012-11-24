import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Dialog to select a date.
 *
 * @author cmcl
 * @version 1.0
 */
public class DateDialog extends JDialog implements ActionListener {
 
    private static final long serialVersionUID = 1L;
    private Date currentDate; // date user selected on last viewing.
    private JComboBox dayBox, monthBox, yearBox;
    private JButton okayButton, cancelButton;
    private ActionListener listener;
    
    /**
     * Constructor for a date dialog.
     *
     * @param listener listens for changes to the date and updates
     * the parent component's fields accordingly. The information
     * is also used to modify Events that owns the date information.
     */
    public DateDialog(Window window, String title,
                      ActionListener listener) {
        super(window, title);
        
        currentDate = new Date(1, 1, 2011);
        this.listener = listener;
        
        setLocationRelativeTo(window);
        
        add(createDatePanel(), BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }
    
    public void setDate(Date d) {
        currentDate = d;
        updateSelections();
    }
    
    public Date getDate() { return currentDate; }
    
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == okayButton) {
            Date d = new Date ((Integer)dayBox.getSelectedItem(),
                               (Integer)monthBox.getSelectedItem(),
                               (Integer)yearBox.getSelectedItem());
            if (d.isValid()) {
                currentDate.setDay(d.getDay());
                currentDate.setMonth(d.getMonth());
                currentDate.setYear(d.getYear());
                setVisible(false);
                // Ensure listener is called after the date is updated.
                listener.actionPerformed(e);
            } else {
                String title = "Date error";
                String msg = d.toString() + " is not a valid date.";
                JOptionPane.showMessageDialog(this, msg, title,
                                              JOptionPane.ERROR_MESSAGE);
            }
        } else if (b == cancelButton) setVisible(false);
    }
    
    /**
     * Update the date components from the currently selected
     * date.
     */
    private void updateSelections() {
        dayBox.setSelectedItem(currentDate.getDay());
        monthBox.setSelectedItem(currentDate.getMonth());
        yearBox.setSelectedItem(currentDate.getYear());
    }
    
    /**
     * Create the panel to hold the date selection
     * boxes.
     */
    private JPanel createDatePanel() {
        JPanel datePanel = new SpacedPanel(new Dimension(5, 5));
        
        dayBox = new JComboBox(Date.days);
        monthBox = new JComboBox(Date.months);
        yearBox = new JComboBox(Date.years);
        
        updateSelections();
        
        datePanel.add(dayBox);
        datePanel.add(monthBox);
        datePanel.add(yearBox);
        return datePanel;
    }
    
    /**
     * Create button panel for selecting a date.
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new SpacedPanel(new Dimension(5, 5));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, 
                            BoxLayout.X_AXIS));
        
        okayButton = new JButton("Okay");
        cancelButton = new JButton("Cancel");
        
        okayButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        buttonPanel.add(okayButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.
                createEmptyBorder(10, 10, 10,10));
        return buttonPanel;
    }
    
    
    /**
     * main method to simply test the dialog class
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Dialog test");
                frame.setLocation(200, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                ActionListener testListener = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.err.println("Listening in on 'okay' "+
                                           "button clicks.");
                    }
                };
                
                JButton b = new JButton("Open dialog");
                final DateDialog dialog = new DateDialog(frame,
                                         "This is a date dialog",
                                         testListener);
                dialog.setVisible(false);
                dialog.pack();
                
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(true);
                    }
                });
                frame.getContentPane().add(b);
                
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
