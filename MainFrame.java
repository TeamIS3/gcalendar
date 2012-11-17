import java.util.Map;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Main class for GUI
 * 
 * @author cmcl
 * @version 1.0
 */
public class MainFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private BaseView[] views;
    private JButton currentButton;
    private Map<JButton, BaseView> viewMap;
    private JPanel viewPanel;
    private JScrollPane scrollPane;
    private EventDialog eventDialog;
    
    public MainFrame() {
        super();
    }

    public void setupGui() {
        setTitle("IS3 Calendar");
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        eventDialog = new EventDialog(this, "Add an Event");
        eventDialog.setVisible(false);
        eventDialog.pack();
        setJMenuBar(createMenuBar());
        
        
        views = new BaseView[3];

        viewMap = new HashMap<JButton, BaseView>();

        createViews();

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel upperPanel = new JPanel(new BorderLayout());
        viewPanel = new JPanel(new BorderLayout());
        upperPanel.add(viewPanel, BorderLayout.EAST);
        mainPanel.add(upperPanel, BorderLayout.NORTH);

        for (BaseView v : views)
            v.setupGui();

        scrollPane = new JScrollPane(views[1]);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        createButtons();

        getContentPane().add(mainPanel);
        // Create buttons
        pack();
        setVisible(true);
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        // File menu
        JMenu fileMenu = new JMenu("File");
        // File -> Exit
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Event menu
        JMenu eventMenu = new JMenu("Event");
        // Event -> New event
        JMenuItem newEventItem = new JMenuItem("New event");
        newEventItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventDialog.setVisible(true);
            }
        });
        eventMenu.add(newEventItem);
        // Event -> Edit event
        JMenuItem editEventItem = new JMenuItem("Edit event");
        eventMenu.add(editEventItem);
        // Event -> Delete event
        JMenuItem deleteEventItem = new JMenuItem("Delete event");
        eventMenu.add(deleteEventItem);
        // Event menu finished.
        menuBar.add(eventMenu);

        // Category menu
        JMenu categoryMenu = new JMenu("Category");
        // Category -> View categories
        JMenuItem viewCategoriesItem = new JMenuItem("View categories");
        categoryMenu.add(viewCategoriesItem);
        // Category menu finished.
        menuBar.add(categoryMenu);

        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        BaseView v = viewMap.get(source);
        if (v != null) {
            // Update the view.
            scrollPane.setViewportView(v);

            // Update enabled/disabled buttons.
            currentButton.setEnabled(true);
            source.setEnabled(false);
            currentButton = source;
        }
    }

    private void createButtons() {
        // Create view buttons.
        JButton week, month, year;
        viewMap.put(week = new JButton("Week"), views[0]);
        viewMap.put(month = new JButton("Month"), views[1]);
        viewMap.put(year = new JButton("Year"), views[2]);

        // Add to views
        viewPanel.add(week, BorderLayout.WEST);
        viewPanel.add(month, BorderLayout.CENTER);
        viewPanel.add(year, BorderLayout.EAST);
        for (JButton b : viewMap.keySet())
            b.addActionListener(this);

        // Default is month view
        currentButton = month;
        currentButton.setEnabled(false);
    }

    private void createViews() {
        views[0] = new WeekView();
        views[1] = new MonthView();
        views[2] = new YearView();
    }
}
