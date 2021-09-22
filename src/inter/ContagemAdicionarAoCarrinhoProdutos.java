package inter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import texto.Produto;

public class ContagemAdicionarAoCarrinhoProdutos extends JInternalFrame {

	private JButton btnAdicionar;
	private JSpinner spinner;
	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ContagemAdicionarAoCarrinhoProdutos frame = new ContagemAdicionarAoCarrinhoProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContagemAdicionarAoCarrinhoProdutos() {
		getContentPane().setBackground(new Color(255, 255, 240));
		setBounds(100, 100, 145, 209);
		getContentPane().setLayout(null);
		
		
		
	    spinner = new JSpinner();
		
		spinner.setFont(new Font("Tahoma", Font.BOLD, 31));
		spinner.setBounds(0, 0, 125, 81);
		getContentPane().add(spinner);
		
		btnAdicionar = new JButton("Adicionar");
		
		btnAdicionar.setBounds(0, 105, 129, 23);
		getContentPane().add(btnAdicionar);

	}
	
	public void setQuantidadeMaxima(Produto produto)
	{
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(produto.getQuantidade()), new Integer(1)));
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	
	
}
