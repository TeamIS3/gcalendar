import javax.swing.*;
import java.awt.*;

/**
 * Main class for GUI
 *
 * @author cmcl
 * @version 1.0
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super();
    }
    
    public void setupGui() {
        setTitle("IS3 Calendar");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

