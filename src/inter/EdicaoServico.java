package inter;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controladora.IEmpresaFachada;
import controladora.ServicoController;
import exceptions.AbertoNoCarrinhoException;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Servico;
import java.awt.Font;

public class EdicaoServico extends JInternalFrame {
	private JTextField textNome;
	private JTextField textCodigo;
	private JTextField textPreco;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EdicaoServico frame = new EdicaoServico();
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
	public EdicaoServico() {
		setEnabled(false);
		setClosable(true);
		getContentPane().setBackground(new Color(219, 112, 147));
		setBounds(100, 100, 584, 253);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(20, 36, 46, 14);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(20, 51, 243, 26);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo\r\n");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(20, 104, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o\r\n");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreco.setBounds(315, 36, 46, 14);
		getContentPane().add(lblPreco);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(20, 122, 243, 26);
		getContentPane().add(textCodigo);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(315, 51, 243, 26);
		getContentPane().add(textPreco);
		
		btnAtualizar = new JButton("Atualizar\r\n");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnAtualizar.setBounds(315, 124, 100, 23);
		getContentPane().add(btnAtualizar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnVoltar.setBounds(458, 124, 100, 23);
		getContentPane().add(btnVoltar);

	}
	
	public boolean atualizarServico(GerenciarServicos servicos, IEmpresaFachada fachada, Servico servicoSelecionado, VenderServicos vender, int index) throws StringVaziaException, NumberFormatException, NaoExisteException, CodigoPequenoException, AbertoNoCarrinhoException, JaExisteException
	{
		if(this.textCodigo.getText().length() > 0 && this.textNome.getText().length() > 0 && this.textPreco.getText().length() > 0 && servicoSelecionado != null && !fachada.existeServicoCarrinho(servicoSelecionado))
		{
			boolean sucesso = fachada.atualizarServico(this.getTextNome().getText(), Integer.parseInt(this.textCodigo.getText()),Double.parseDouble(this.textPreco.getText()) , servicoSelecionado);
			if(sucesso)
			{
				Servico servico = new Servico(this.getTextNome().getText(), Integer.parseInt(this.textCodigo.getText()),Double.parseDouble(this.textPreco.getText()) , servicoSelecionado.getEmpresa());
				servicos.atualizar(servico, index);
				vender.atualizar(servico, index);
				return true;
			}
		}else if(this.textCodigo.getText().length() <= 0)
		{
			throw new StringVaziaException("código");
		}else if(this.textNome.getText().length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(this.textPreco.getText().length() <= 0)
		{
			throw new StringVaziaException("preço");
		
		}else if(fachada.existeServicoCarrinho(servicoSelecionado))
		{
			throw new AbertoNoCarrinhoException("serviço");
		}
		return false;
 	}
	
	public void limpar()
	{
		this.textCodigo.setText("");
		this.textNome.setText("");
		this.textPreco.setText("");
	}
	
	public void preencher(String nome, String preco, String codigo)
	{
		this.textNome.setText(nome);
		this.textCodigo.setText(codigo);
		this.textPreco.setText(preco);
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextCodigo() {
		return textCodigo;
	}

	public void setTextCodigo(JTextField textCodigo) {
		this.textCodigo = textCodigo;
	}

	public JTextField getTextPreco() {
		return textPreco;
	}

	public void setTextPreco(JTextField textPreco) {
		this.textPreco = textPreco;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}
	
	

}
