import javax.swing.*;
import java.awt.*;

/**
 * Main class for GUI
 *
 * @author cmcl
 * @version 1.0
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
        super();
    }
    
    public void setupGui() {
        setTitle("IS3 Calendar");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(Common.createMenuBar());
        setVisible(true);
    }
}

