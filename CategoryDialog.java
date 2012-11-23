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
public class CategoryDialog extends JDialog implements ActionListener {
    
   	private JRadioButton homeButton,WorkButton,otherButton;
    private JButton cancelButton;
    private ActionListener listener;
    
    /**
     * Constructor for a Repetition dialog.
     */
    public CategoryDialog(Window window, String title,
                      ActionListener listener) {
        super(window, title);
        this.listener = listener;
        
        setLocationRelativeTo(window);
		add(createRadioPanel(), BorderLayout.WEST);
		add(createMiddlePanel(),BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.EAST);
    }
    
    /**
     * Create the middle panel of Dialog which contains the
		input box associated with 'every' radio button
     */
	private JPanel createMiddlePanel(){
		JPanel middlePanel=new JPanel();
		JLabel topLabel=new JLabel("          ");
		middlePanel.add(topLabel);
		return middlePanel;
		
	}
    private JPanel createRadioPanel() {
        JRadioButton workButton = new JRadioButton("Work");
		JRadioButton homeButton = new JRadioButton("Home");
		JRadioButton otherButton= new JRadioButton("Other");

		ButtonGroup group = new ButtonGroup();
    	group.add(workButton);
    	group.add(homeButton);
		group.add(otherButton);
		JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        radioPanel.add(workButton);
        radioPanel.add(homeButton);
        radioPanel.add(otherButton);
        return radioPanel;
    }
    
    /**
     * Create button panel for okay/cancel buttons.
     */
    private JPanel createButtonPanel() {
		JPanel buttonPanel= new JPanel(new BorderLayout());
        cancelButton = new JButton("Close");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);
		buttonPanel.add(cancelButton,BorderLayout.NORTH);
     
        return buttonPanel;
    }
    
     public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == cancelButton) {
  
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
                final CategoryDialog dialog = new CategoryDialog(frame,
                                                 "This is a Category dialog",
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
