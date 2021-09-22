package inter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import texto.Produto;

public class ContagemEditarProduto extends JInternalFrame {
	private JButton btnAtualizar;
	private JSpinner spinner;
	private int quantidadeMaxima = 0;
	private int quantidadeInicial = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ContagemEditarProduto frame = new ContagemEditarProduto();
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
	public ContagemEditarProduto() {
		getContentPane().setBackground(new Color(255, 255, 240));
		setBounds(100, 100, 145, 209);
		getContentPane().setLayout(null);

		spinner = new JSpinner();
				spinner.setFont(new Font("Tahoma", Font.BOLD, 31));
		spinner.setBounds(0, 0, 125, 81);
		getContentPane().add(spinner);
		
		btnAtualizar = new JButton("Atualizar");
		
		
		btnAtualizar.setBounds(0, 105, 129, 23);
		getContentPane().add(btnAtualizar);
	}
	
	
	public void setQuantidadeMaximaInicial(Produto produtoEmpresa, Produto produtoCarrinho)
	{
		quantidadeMaxima = produtoEmpresa.getQuantidade();
		quantidadeInicial = produtoCarrinho.getQuantidade();
		spinner.setModel(new SpinnerNumberModel(new Integer(quantidadeInicial), new Integer(0), new Integer(quantidadeMaxima), new Integer(1)));

	}



	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public void setBtnAtualizar(JButton btnAdicionar) {
		this.btnAtualizar = btnAdicionar;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public int getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(int quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	public int getQuantidadeInicial() {
		return quantidadeInicial;
	}

	public void setQuantidadeInicial(int quantidadeInicial) {
		this.quantidadeInicial = quantidadeInicial;
	}
	
	


}
