package inter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipalLogado extends JPanel {
	private JLabel lbl_nome;

	/**
	 * Create the panel.
	 */
	public TelaPrincipalLogado() {
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1100, 169);
		panel.setBackground(new Color(219, 112, 147));
		add(panel);
		panel.setLayout(null);
		
		lbl_nome = new JLabel("Bem-vindo //NOME// ao Selling Guide.");
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 44));
		lbl_nome.setBounds(0, 0, 1100, 169);
		panel.add(lbl_nome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipalLogado.class.getResource("/inter/Tela_logado.png")));
		lblNewLabel.setBounds(0, 168, 1100, 453);
		add(lblNewLabel);

	}

	public JLabel getLbl_nome() {
		return lbl_nome;
	}

	public void setLbl_nome(JLabel lbl_nome) {
		this.lbl_nome = lbl_nome;
	}
}
