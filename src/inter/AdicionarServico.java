package inter;

import java.awt.Color;
import texto.Servico;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controladora.IEmpresaFachada;
import controladora.ServicoController;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;

public class AdicionarServico extends JInternalFrame {

    private JTextField textNome;

	
	private JTextField text_codigo;
	private JButton btnVoltar;
	private JTextField textPreco;
	private JButton btnAdicionar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdicionarServico frame = new AdicionarServico();
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
	public AdicionarServico() {
		setEnabled(false);
		setClosable(true);
		getContentPane().setBackground(new Color(219, 112, 147));
		getContentPane().setLayout(null);
		setBounds(0, 0, 618, 408);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 582, 335);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 52, 190, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 37, 46, 14);
		panel.add(lblNome);
		
		
		
		
		
		JLabel lbl_codigo = new JLabel("C\u00F3digo");
		lbl_codigo.setBounds(10, 205, 46, 14);
		panel.add(lbl_codigo);
		
		text_codigo = new JTextField();
		text_codigo.setDocument(new SoNumeros());
		text_codigo.setColumns(10);
		text_codigo.setBounds(10, 218, 190, 20);
		panel.add(text_codigo);
		
		btnVoltar = new JButton("Voltar");
		
		
		btnVoltar.setBounds(290, 129, 140, 23);
		panel.add(btnVoltar);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(10, 130, 190, 20);
		panel.add(textPreco);
		
		JLabel lbl_preco = new JLabel("Pre\u00E7o\r\n");
		lbl_preco.setBounds(10, 115, 46, 14);
		panel.add(lbl_preco);
		
		btnAdicionar = new JButton("Adicionar\r\n");
		
		btnAdicionar.setBounds(287, 51, 143, 23);
		panel.add(btnAdicionar);
		setBounds(100, 100, 618, 387);

	}
	
	public boolean adicionar(IEmpresaFachada fachada, VenderServicos vender, GerenciarServicos servicos) throws StringVaziaException, NumberFormatException, CodigoPequenoException, JaExisteException
	{
		if(this.textNome.getText().length() > 0 && this.text_codigo.getText().length() > 0 & this.textPreco.getText().length() > 0)
		{
			boolean sucesso = fachada.adicionarServico(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), fachada.getEmpresaLogada());
			if(sucesso)
			{
				Servico servico = new Servico(this.textNome.getText(), Integer.parseInt(this.text_codigo.getText()), Double.parseDouble(this.textPreco.getText()), fachada.getEmpresaLogada());
				vender.adicionar(servico);
				servicos.adicionar(servico);
				JOptionPane.showMessageDialog(null, "Serviço adicionado com sucesso!");
				return true;
			}
		}else if(this.text_codigo.getText().length() <= 0)
		{
			throw new StringVaziaException("código");
		}else if(this.textNome.getText().length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(this.textPreco.getText().length() <= 0)
		{
			throw new StringVaziaException("preço");
		}
		return false;
	}
	
	public void limpar()
	{
		this.textNome.setText("");
		this.textPreco.setText("");
		this.text_codigo.setText("");
	}
	
	

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
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



	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}



	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}



	public JTextField getTextPreco() {
		return textPreco;
	}



	public void setTextPreco(JTextField textPreco) {
		this.textPreco = textPreco;
	}
	
	
	
}
