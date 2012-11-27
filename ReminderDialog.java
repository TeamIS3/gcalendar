import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Dialog to set a reminder
 *
 * @author rifl
 * @author cmcl
 * @version 1.0
 */
public class ReminderDialog extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton okayButton, cancelButton;
    private ActionListener listener;
    private Reminder rem;
    
    /**
     * Constructor for a Reminder dialog.
     */
    public ReminderDialog(Window window, String title,
                          ActionListener listener) {
        super(window, title);
        
        rem = new Reminder();
        this.listener = listener;
        
        setLocationRelativeTo(window);

        add(createSelectionPanel(), BorderLayout.WEST);
		add(createMiddlePanel(),BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.EAST);
		
    }

    public Reminder getReminder(){
        return rem;
    }
    
    /**
     * Panel used for spacing purposes between Radio Button
	 * and okay/cancel buttons.
     */	
	private JPanel createMiddlePanel(){
		JPanel middlePanel=new JPanel(new BorderLayout());
		middlePanel.setPreferredSize(new Dimension(80,50));
		return middlePanel;
	}

    private JPanel createSelectionPanel() {
		
		final String start_text = "Number of...";
    	final JTextField quantity = new JEventField(start_text);
    	quantity.addFocusListener(new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
            if (quantity.getText().equals(start_text)) {
                quantity.setText("");
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
			 if (quantity.getText().equals("")) {
                quantity.setText(start_text);
            }
        }
    });

        JRadioButton minutesButton = new JRadioButton("Minutes");
		JRadioButton hoursButton = new JRadioButton("Hours");
		JRadioButton daysButton = new JRadioButton("Days");

		ButtonGroup group = new ButtonGroup();
    	group.add(minutesButton);
    	group.add(hoursButton);
    	group.add(daysButton);

		JPanel inputPanel = new JPanel();
		JPanel radioPanel = new JPanel(new GridLayout(3, 1));

		inputPanel.add(quantity);
        radioPanel.add(minutesButton);
        radioPanel.add(hoursButton);
        radioPanel.add(daysButton);

		//creates a space between input box and radio buttons
		JPanel selectionPanel = new JPanel(new BorderLayout(0, 10));
		selectionPanel.add(radioPanel,BorderLayout.SOUTH);
		selectionPanel.add(inputPanel,BorderLayout.NORTH);
        return selectionPanel;
    }
    
    /**
     * Create button panel for okay/cancel Buttons.
     */
    private JPanel createButtonPanel() {
		JPanel rightSide= new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1,0,5));
        JPanel rightSideFiller=new JPanel();

        okayButton = new JButton("Okay");
        cancelButton = new JButton("Close");
        
        okayButton.addActionListener(this);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);
        buttonPanel.add(okayButton);
		rightSide.add(buttonPanel,BorderLayout.NORTH);
		rightSide.add(rightSideFiller,BorderLayout.SOUTH);
        
        return rightSide;
    }
    
     public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == okayButton)
            listener.actionPerformed(e);
        setVisible(false);
    }
	public JButton getOkayButton(){
		return okayButton;
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
                final ReminderDialog dialog = new ReminderDialog(frame,
                                              "This is a reminder dialog",
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
