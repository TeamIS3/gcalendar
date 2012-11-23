import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Dialog to set a repetitive event
 *
 * @author rifl
 * @version 1.0
 */
public class RepetitionDialog extends JDialog implements ActionListener {
    
	private JTextField quantity;
   	private JRadioButton dailyButton, weeklyButton, fortButton,
			monthlyButton, yearlyButton, everyButton;
    private JButton okayButton, cancelButton;
    private ActionListener listener;
    private Repetition rep;

    /**
     * Constructor for a Repetition dialog.
     */
    public RepetitionDialog(Window window, String title,
                      ActionListener listener) {
        super(window, title);
        this.listener = listener;
        
        setLocationRelativeTo(window);
		add(createRadioPanel(), BorderLayout.WEST);
		add(createMiddlePanel(),BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.EAST);
    }
    
    public Repetition getRepetition(){
        return rep;
    }

    /**
     * Create the middle panel of Dialog which contains the
		input box associated with 'every' radio button
     */
	private JPanel createMiddlePanel(){
		JPanel middlePanel=new JPanel(new BorderLayout());
		JLabel topLabel=new JLabel("");	
		JLabel middleLabel=new JLabel("");
		JPanel lowerPanel= new JPanel(new BorderLayout());

		JTextField quantity=new JEventField("      ");
		JLabel daysLabel=new JLabel("  Days");

		lowerPanel.add(quantity,BorderLayout.WEST);
		lowerPanel.add(daysLabel,BorderLayout.EAST);
		middlePanel.add(topLabel,BorderLayout.NORTH);
		middlePanel.add(topLabel,BorderLayout.CENTER);
		middlePanel.add(lowerPanel,BorderLayout.SOUTH);
		return middlePanel;
		
	}
    private JPanel createRadioPanel() {
        JRadioButton dailyButton = new JRadioButton("Daily");
		JRadioButton weeklyButton = new JRadioButton("Weekly");
		JRadioButton fortButton = new JRadioButton("Fortnightly");
		JRadioButton monthlyButton = new JRadioButton("Monthly");
		JRadioButton yearlyButton = new JRadioButton("Yearly");
		JRadioButton everyButton = new JRadioButton("Every");

		ButtonGroup group = new ButtonGroup();
    	group.add(dailyButton);
    	group.add(weeklyButton);
    	group.add(fortButton);
		group.add(monthlyButton);
		group.add(yearlyButton);
		group.add(everyButton);

		JPanel radioPanel = new JPanel(new GridLayout(6, 1));
        radioPanel.add(dailyButton);
        radioPanel.add(weeklyButton);
        radioPanel.add(fortButton);
		radioPanel.add(monthlyButton);
        radioPanel.add(yearlyButton);
        radioPanel.add(everyButton);
        return radioPanel;
    }
    
    /**
     * Create button panel for okay/cancel buttons.
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
        if (b == okayButton) {
            if(dailyButton.isSelected())
                rep = new Repetition("Daily", 1);
            else if(weeklyButton.isSelected())
                rep = new Repetition("Weekly", 1);
            else if(fortButton.isSelected())
                rep = new Repetition("Fortnightly", 1);
            else if(monthlyButton.isSelected())
                rep = new Repetition("Monthly", 1);
            else if(yearlyButton.isSelected())
                rep = new Repetition("Yearly", 1);
            else{
                int repetitions = Integer.parseInt(quantity.getText());
                rep = new Repetition("Days", repetitions);
            }
            listener.actionPerformed(e);
        }
        setVisible(false);
        
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
                final RepetitionDialog dialog = new RepetitionDialog(frame,
                                                 "This is a repetition dialog",
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
