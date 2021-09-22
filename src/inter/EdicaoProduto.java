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
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Produto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EdicaoProduto extends JInternalFrame {
	
	private JTextField textNome;
	private JTextField textPreco;
	private JButton btnAtualizar;
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
					EdicaoProduto frame = new EdicaoProduto();
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
	public EdicaoProduto() {
		setEnabled(false);
		setClosable(true);
		    setBounds(0, 0, 312, 387);
		    getContentPane().setBounds(0, 0, 306, 290);
		
			getContentPane().setEnabled(false);
			getContentPane().setBackground(new Color(219, 112, 147));
			getContentPane().setLayout(null);
			
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 490, 335);
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
			textPreco.setBounds(10, 178, 228, 20);
			panel.add(textPreco);
			
			JLabel lblPreco = new JLabel("Pre\u00E7o");
			lblPreco.setBounds(10, 153, 46, 14);
			panel.add(lblPreco);
			
			JLabel lbl_Quantidade = new JLabel("Quantidade");
			lbl_Quantidade.setBounds(293, 55, 70, 14);
			panel.add(lbl_Quantidade);
			
			
			btnAtualizar = new JButton("Atualizar");
		
			
			btnAtualizar.setBounds(293, 111, 113, 23);
			panel.add(btnAtualizar);
			
			JLabel lbl_codigo = new JLabel("C\u00F3digo");
			lbl_codigo.setBounds(10, 98, 46, 14);
			panel.add(lbl_codigo);
			
			text_codigo = new JTextField();
			text_codigo.setDocument(new SoNumeros());
			text_codigo.setColumns(10);
			text_codigo.setBounds(10, 112, 228, 20);
			panel.add(text_codigo);
			
			btnVoltar = new JButton("Voltar");
			
			
			btnVoltar.setBounds(293, 177, 113, 23);
			panel.add(btnVoltar);
			
			spinnerQuantidade = new JSpinner();
			spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerQuantidade.setBounds(377, 52, 29, 20);
			panel.add(spinnerQuantidade);
			setBounds(100, 100, 618, 387);
			text_codigo.setDocument(new SoNumeros());
			textPreco.setDocument(new SoDouble());

		}
	
	
	
	
	    public void limpar()
	    {
	    	this.textNome.setText("");
	    	this.text_codigo.setText("");
	    	this.textPreco.setText("");
	    }
	    
	    public void preencher(String nome, String codigo, String preco)
	    {
	    	this.textNome.setText(nome);
	    	this.textPreco.setText(preco);
	    	this.text_codigo.setText(codigo);
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

		
		public boolean atualizar(IEmpresaFachada fachada, Produto produtoSelecionado, GerenciarProdutos produtos, VenderProdutos vender, int index) throws StringVaziaException, NumberFormatException, CodigoPequenoException, NaoExisteException
		{
			if(this.textNome.getText().length() > 0 && this.text_codigo.getText().length() > 0 && this.textPreco.getText().length() > 0 && produtoSelecionado != null)
			{
				boolean sucesso = fachada.atualizarProduto(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), (Integer)this.spinnerQuantidade.getValue(), produtoSelecionado.getEmpresa(), produtoSelecionado);
				if(sucesso)
				{
					Produto produto = new Produto(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), (Integer)this.spinnerQuantidade.getValue(), produtoSelecionado.getEmpresa());
					vender.atualizar(produto, index);
					produtos.atualizar(produto, index);
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
		


		

		public JButton getBtnAtualizar() {
			return btnAtualizar;
		}

		public void setBtnAtualizar(JButton btnAdicionar) {
			this.btnAtualizar = btnAdicionar;
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
