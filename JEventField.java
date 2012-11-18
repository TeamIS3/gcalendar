import javax.swing.*;

import java.awt.*;

/*
 * Encapsulates common attributes among event text fields.
 *
 * @author cmcl
 * @version 1.0
 */
public class JEventField extends JTextField {
    
    public JEventField() {
        this(null);
    }
    
    public JEventField(String text) {
        this(text, 0);
    }
    
    public JEventField(String text, int ncolumns) {
        super(text, ncolumns);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}
