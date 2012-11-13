import javax.swing.*;

/**
 * Main class for application. Just creates the GUI frame.
 * 
 * @author cmcl
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		final MainFrame app = new MainFrame();
		// Send to queue for Event Dispatch Thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				app.setupGui();
			}
		});
	}
}
