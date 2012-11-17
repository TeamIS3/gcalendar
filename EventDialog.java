import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Dialog to implement the event dialog box to add, edit or remove
 * an event.
 *
 * @author cmcl
 * @version 1.0
 */
public class EventDialog extends JDialog implements ActionListener {
    private JButton okayButton, delButton, cancelButton;

    public EventDialog(JFrame frame, String title) {
        super(frame, title, Dialog.ModalityType.DOCUMENT_MODAL);
        setLocationRelativeTo(frame);
        
        // Add panels to dialog
        add(createInputPanel(), BorderLayout.WEST);
        add(createSidePanel(), BorderLayout.EAST);
        add(createLowerPanel(), BorderLayout.SOUTH);
    }
    
    /**
     * Creates the panel that holds all input fields for the
     * event information.
     *
     * @return the input field panel.
     */
    public JPanel createInputPanel() {
        JPanel inputPanel = new SpacedPanel(new Dimension(5, 5));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        
        JTextField nameField = new JEventField("Enter event name...");
        inputPanel.add(nameField);
        inputPanel.add(new JEventField("Enter event location..."));
        
        JTextArea descArea = new JTextArea("Enter event description...");
        descArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        inputPanel.add(descArea);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
                                                             10));
        return inputPanel;
    }
    
    /**
     * Creates the panel that holds operational buttons,
     * add, cancel and delete.
     *
     * @returns the side panel.
     */
    public JPanel createSidePanel() {
        JPanel sidePanel = new SpacedPanel(new Dimension(5, 5));
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        
        cancelButton = new JButton("Cancel");
        delButton = new JButton("Delete");
        okayButton = new JButton("Okay");
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        delButton.addActionListener(this);
        okayButton.addActionListener(this);
        
        sidePanel.add(cancelButton);
        sidePanel.add(delButton);
        sidePanel.add(okayButton);
        
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
                                                            10));

        return sidePanel;    
    }
    
    
    /**
     * Creates the panel for buttons leading to more dialog
     * windows.
     *
     * @returns the dialog button panel.
     */
    public JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout());
        
        JPanel lowerLeftPanel = new SpacedPanel(new Dimension(5, 5));
        lowerLeftPanel.setLayout(new BoxLayout(lowerLeftPanel,
                                               BoxLayout.Y_AXIS));
        
        lowerLeftPanel.add(new JButton("Set reminder"));
        lowerLeftPanel.add(new JButton("Set repetition"));
        lowerLeftPanel.add(new JButton("Set category"));
        
        lowerPanel.add(lowerLeftPanel, BorderLayout.WEST);
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
                                                             10));
        return lowerPanel;
    }
    
    /**
     * Handles the Okay and Delete button actions for
     * creation of Events.
     */
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == okayButton) {
            System.err.println("I'm going to create an event now.");
        } else if (b == delButton) {
            System.err.println("I'm going to delete this event now.");
        }
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
                
                JButton b = new JButton("Open dialog");
                final JDialog dialog = new EventDialog(frame,
                                                       "This is a dialog");
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

