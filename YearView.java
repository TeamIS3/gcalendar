import javax.swing.*;

public class YearView extends BaseView {

    private static final long serialVersionUID = 1L;

    public YearView(CalendarModel model) {
        super(model);
    }

    public void setupCalendar() {
        add(new JLabel("YEAR VIEW"));
    }
}
