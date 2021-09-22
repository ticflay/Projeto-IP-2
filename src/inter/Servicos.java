package inter;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Servicos extends JPanel {

	/**
	 * Create the panel.
	 */
	public Servicos() {
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 112, 147));
		panel.setBounds(407, 166, 287, 10);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setBounds(0, 521, 1100, 100);
		add(panel_1);
		
		JLabel lbl_backser = new JLabel("New label");
		lbl_backser.setIcon(new ImageIcon(Servicos.class.getResource("/inter/Servi\u00E7os.png")));
		lbl_backser.setBounds(0, 0, 1100, 621);
		add(lbl_backser);

	}
}
