import javax.swing.*;

import java.awt.*;

/*
 * Encapsulates common attributes among event text fields.
 *
 * @author cmcl
 * @version 1.0
 */
public class JEventField extends JTextField {
    
    public JEventField(String text) {
        super(text);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

}
