import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenuBar();
        setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}

