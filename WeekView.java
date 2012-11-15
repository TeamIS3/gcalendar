import javax.swing.*;
import java.awt.*;

public class WeekView extends BaseView {

    private static final long serialVersionUID = 1L;

    public WeekView() {
        super();
    }

    public void setupCalendar() {
        JLabel label = new JLabel("WEEK VIEW");
        this.add(label, BorderLayout.CENTER);
    }
}