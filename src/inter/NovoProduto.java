package inter;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controladora.IEmpresaFachada;
import controladora.ProdutoController;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Produto;

public class NovoProduto extends JInternalFrame {
	private JTextField textNome;
	private JTextField textPreco;
		private JButton btnAdicionar;
	private JTextField text_codigo;
	private JButton btnVoltar;
	private JSpinner spinnerQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NovoProduto frame = new NovoProduto();
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
	
	public NovoProduto() {
		setClosable(true);
		setEnabled(false);
		getContentPane().setEnabled(false);
		getContentPane().setBackground(new Color(219, 112, 147));
		getContentPane().setLayout(null);
		setBounds(0, 0, 618, 439);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 526, 355);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 52, 228, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 37, 46, 14);
		panel.add(lblNome);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(10, 188, 228, 20);
		panel.add(textPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 163, 46, 14);
		panel.add(lblPreco);
		
		JLabel lbl_Quantidade = new JLabel("Quantidade");
		lbl_Quantidade.setBounds(312, 52, 70, 14);
		panel.add(lbl_Quantidade);
		
		
		btnAdicionar = new JButton("Adicionar");
	
		
		
		btnAdicionar.setBounds(317, 111, 104, 23);
		panel.add(btnAdicionar);
		
		JLabel lbl_codigo = new JLabel("C\u00F3digo");
		lbl_codigo.setBounds(10, 98, 46, 14);
		panel.add(lbl_codigo);
		
		text_codigo = new JTextField();
		text_codigo.setDocument(new SoNumeros());
		text_codigo.setColumns(10);
		text_codigo.setBounds(10, 112, 228, 20);
		panel.add(text_codigo);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setBounds(317, 176, 104, 23);
		panel.add(btnVoltar);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerQuantidade.setBounds(392, 52, 29, 20);
		panel.add(spinnerQuantidade);
		setBounds(100, 100, 618, 387);
		
		text_codigo.setDocument(new SoNumeros());
		textPreco.setDocument(new SoDouble());

	}
	
	public boolean adicionar(IEmpresaFachada fachada, GerenciarProdutos produtos, VenderProdutos vender) throws  NumberFormatException, NaoExisteException, StringVaziaException, CodigoPequenoException
	{
		if(this.textNome.getText().length() > 0 && this.text_codigo.getText().length() > 0 && this.textPreco.getText().length() > 0 && fachada.getEmpresaLogada() != null)
		{
			boolean sucesso = fachada.cadastrarProduto(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), (Integer)this.spinnerQuantidade.getValue(), fachada.getEmpresaLogada());
			
			if(sucesso)
			{
				Produto produto = new Produto(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), (Integer)this.spinnerQuantidade.getValue(), fachada.getEmpresaLogada());
				produtos.adicionar(produto);
				vender.adicionar(produto);
				return true;
			}
		}else if(this.textNome.getText().length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(this.text_codigo.getText().length() <= 0)
		{
			throw new StringVaziaException("código");
		}else if(this.textPreco.getText().length() <= 0)
		{
			throw new StringVaziaException("preço");
		}
		return false;
		
	}
	
	public void limparTexto()
	{
		this.textNome.setText("");
		this.text_codigo.setText("");
		this.textPreco.setText("");
		this.spinnerQuantidade.setValue(0);
	}
	
	

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextPreco() {
		return textPreco;
	}

	public void setTextPreco(JTextField textLogin) {
		this.textPreco = textLogin;
	}

	
	
	


	

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	public JTextField getText_codigo() {
		return text_codigo;
	}

	public void setText_codigo(JTextField text_codigo) {
		this.text_codigo = text_codigo;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JSpinner getSpinnerQuantidade() {
		return spinnerQuantidade;
	}

	public void setSpinnerQuantidade(JSpinner spinnerQuantidade) {
		this.spinnerQuantidade = spinnerQuantidade;
	}
	
}
