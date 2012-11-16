import javax.swing.*;


import java.awt.*;

/**
 * Panel that provides universal spacing for child
 * components.
 *
 * @author cmcl
 * @version 1.0
 */
public class SpacedPanel extends JPanel {
    private Dimension d;
    
    public SpacedPanel(LayoutManager layout, Dimension d) {
        super(layout);
        this.d = d;
    }
    
    public SpacedPanel(Dimension d) {
        super(new FlowLayout());
        this.d = d;
    }
    
    public Component add(Component comp) {
        super.add(comp);
        super.add(new Box.Filler(d, d, d));
        return comp;
    }

}
