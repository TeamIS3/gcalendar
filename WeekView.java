import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

public class WeekView extends BaseView {
    public WeekView() {
        super();
    }
    
    public void setupCalendar() {
        JLabel label = new JLabel("WEEK VIEW");
        this.add(label, BorderLayout.CENTER);
    }
}