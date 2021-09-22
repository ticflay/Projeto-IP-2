package inter;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controladora.FuncionarioController;
import controladora.IEmpresaFachada;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Funcionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoFuncionario extends JInternalFrame {
	private JTextField textNome;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JRadioButton rdbtn_GPyes;
	private JRadioButton rdbtn_GPno;
	private ButtonGroup GrupoGP = new ButtonGroup();
	private JRadioButton rdbtn_VPyes;
	private JRadioButton rdbtn_VPno;
	private ButtonGroup GroupVP = new ButtonGroup();
	private JRadioButton rdbtn_PSyes;
	private JRadioButton rdbtn_PSno;
	private ButtonGroup GroupPS = new ButtonGroup();
	private JRadioButton rdbtn_GFyes;
	private JRadioButton rdbtn_GFno;
	private ButtonGroup GroupGF = new ButtonGroup();
	private JButton btnAdicionar;
	private JTextField text_codigo;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NovoFuncionario frame = new NovoFuncionario();
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
	public NovoFuncionario() {
		getContentPane().setBackground(new Color(219, 112, 147));
		getContentPane().setLayout(null);
		setBounds(0, 0, 619, 400);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 582, 335);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 24, 190, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(10, 80, 190, 20);
		panel.add(textLogin);
		
		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(10, 125, 190, 20);
		panel.add(textSenha);
		
		JLabel lbl_Login = new JLabel("Login");
		lbl_Login.setBounds(10, 55, 46, 14);
		panel.add(lbl_Login);
		
		JLabel lbl_Senha = new JLabel("Senha");
		lbl_Senha.setBounds(10, 111, 46, 14);
		panel.add(lbl_Senha);
		
		JLabel lbl_GerP = new JLabel("O funcion\u00E1rio poder\u00E1 gerenciar \r\nprodutos e servi\u00E7os?");
		lbl_GerP.setBounds(269, 8, 276, 53);
		panel.add(lbl_GerP);
		
		rdbtn_GPyes = new JRadioButton("Sim");
		rdbtn_GPyes.setBackground(Color.WHITE);
		rdbtn_GPyes.setBounds(269, 40, 70, 23);
		panel.add(rdbtn_GPyes);
		
		rdbtn_GPno = new JRadioButton("N\u00E3o");
		rdbtn_GPno.setBackground(Color.WHITE);
		rdbtn_GPno.setBounds(362, 40, 70, 23);
		panel.add(rdbtn_GPno);
		
		GrupoGP.add(rdbtn_GPyes);
		GrupoGP.add(rdbtn_GPno);

		
		JLabel lbl_VendP = new JLabel("O funcion\u00E1rio poder\u00E1 vender produtos?");
		lbl_VendP.setBounds(269, 55, 276, 53);
		panel.add(lbl_VendP);
		
		rdbtn_VPyes = new JRadioButton("Sim");
		rdbtn_VPyes.setBackground(Color.WHITE);
		rdbtn_VPyes.setBounds(269, 85, 70, 23);
		panel.add(rdbtn_VPyes);
		
	    rdbtn_VPno = new JRadioButton("N\u00E3o");
		rdbtn_VPno.setBackground(Color.WHITE);
		rdbtn_VPno.setBounds(362, 85, 70, 23);
		panel.add(rdbtn_VPno);
		
		GroupVP.add(rdbtn_VPyes);
		GroupVP.add(rdbtn_VPno);
		
		JLabel lbl_PreS = new JLabel("O funcion\u00E1rio poder\u00E1 prestar servi\u00E7os?");
		lbl_PreS.setBounds(269, 92, 276, 53);
		panel.add(lbl_PreS);
		
		rdbtn_PSyes = new JRadioButton("Sim");
		rdbtn_PSyes.setBackground(Color.WHITE);
		rdbtn_PSyes.setBounds(269, 124, 70, 23);
		panel.add(rdbtn_PSyes);
		
		rdbtn_PSno = new JRadioButton("N\u00E3o");
		rdbtn_PSno.setBackground(Color.WHITE);
		rdbtn_PSno.setBounds(362, 124, 70, 23);
		panel.add(rdbtn_PSno);
		
		GroupPS.add(rdbtn_PSyes);
		GroupPS.add(rdbtn_PSno);
		
		JLabel lbl_GerF = new JLabel("O funcion\u00E1rio poder\u00E1 gerenciar funcion\u00E1rios?");
		lbl_GerF.setBounds(269, 137, 276, 53);
		panel.add(lbl_GerF);
		
		rdbtn_GFyes = new JRadioButton("Sim");
		rdbtn_GFyes.setBackground(Color.WHITE);
		rdbtn_GFyes.setBounds(269, 170, 70, 23);
		panel.add(rdbtn_GFyes);
		
		rdbtn_GFno = new JRadioButton("N\u00E3o");
		rdbtn_GFno.setBackground(Color.WHITE);
		rdbtn_GFno.setBounds(362, 170, 70, 23);
		panel.add(rdbtn_GFno);
		
		GroupGF.add(rdbtn_GFyes);
		GroupGF.add(rdbtn_GFno);
		
		
		
		
		
	
	
		
		btnAdicionar = new JButton();
		btnAdicionar.setBounds(269, 201, 84, 23);
		panel.add(btnAdicionar);
		
		JLabel lbl_codigo = new JLabel("C\u00F3digo");
		lbl_codigo.setBounds(10, 156, 46, 14);
		panel.add(lbl_codigo);
		
		text_codigo = new JTextField();
		text_codigo.setDocument(new SoNumeros());
		text_codigo.setColumns(10);
		text_codigo.setBounds(10, 171, 190, 20);
		panel.add(text_codigo);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setBounds(418, 201, 84, 23);
		panel.add(btnVoltar);
		setBounds(100, 100, 618, 387);

	}
	
	
	public boolean adicionar(IEmpresaFachada fachada, GerenciarFuncionarios funcionarios) throws NumberFormatException, LoginInvalidoException, StringVaziaException, CodigoPequenoException, JaExisteException
	{
		if(this.textNome.getText().length() > 0 && this.textLogin.getText().length() > 0 && this.getText_codigo().getText().length() > 0 && this.textSenha.getPassword().length > 0 && fachada.getEmpresaLogada() != null)
		{
			boolean sucesso = fachada.cadastrarFuncionario(this.textLogin.getText(), this.textSenha.getPassword(), this.getTextNome().getText(), this.rdbtn_VPyes.isSelected(), this.rdbtn_PSyes.isSelected(), this.rdbtn_GPyes.isSelected(), this.rdbtn_GFyes.isSelected(), Integer.parseInt(this.text_codigo.getText()), fachada.getEmpresaLogada());
			if(sucesso)
			{
				
				Funcionario funcionario = new Funcionario(this.textLogin.getText(), this.textSenha.getPassword(), this.getTextNome().getText(), this.rdbtn_VPyes.isSelected(), this.rdbtn_PSyes.isSelected(), this.rdbtn_GPyes.isSelected(), this.rdbtn_GFyes.isSelected(), Integer.parseInt(this.text_codigo.getText()), fachada.getEmpresaLogada());
				funcionarios.adicionar(funcionario);
				return true;
			}
		}else if(this.textNome.getText().length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(this.textLogin.getText().length() <= 0)
		{
			throw new StringVaziaException("login");
		}else if(this.text_codigo.getText().length() <= 0)
		{
			throw new StringVaziaException("senha");
		}else if(this.textSenha.getPassword().length <= 0)
		{
			throw new StringVaziaException("senha");
		}
		return false;
	}
	
	public void limpar()
	{
		textNome.setText("");
		textLogin.setText("");
		text_codigo.setText("");
		textSenha.setText("");
		this.rdbtn_GFno.setSelected(false);
		this.rdbtn_GFyes.setSelected(false);
		this.rdbtn_GPno.setSelected(false);
		this.rdbtn_GPyes.setSelected(false);
		this.rdbtn_PSno.setSelected(false);
		this.rdbtn_PSyes.setSelected(false);
		this.rdbtn_VPno.setSelected(false);
		this.rdbtn_VPyes.setSelected(false);
	}
	

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextLogin() {
		return textLogin;
	}

	public void setTextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}

	public JPasswordField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JPasswordField textSenha) {
		this.textSenha = textSenha;
	}

	public JRadioButton getRdbtn_GPyes() {
		return rdbtn_GPyes;
	}

	public void setRdbtn_GPyes(JRadioButton rdbtn_GPyes) {
		this.rdbtn_GPyes = rdbtn_GPyes;
	}

	public JRadioButton getRdbtn_GPno() {
		return rdbtn_GPno;
	}

	public void setRdbtn_GPno(JRadioButton rdbtn_GPno) {
		this.rdbtn_GPno = rdbtn_GPno;
	}

	public ButtonGroup getGrupoGP() {
		return GrupoGP;
	}

	public void setGrupoGP(ButtonGroup grupoGP) {
		GrupoGP = grupoGP;
	}

	public JRadioButton getRdbtn_VPyes() {
		return rdbtn_VPyes;
	}

	public void setRdbtn_VPyes(JRadioButton rdbtn_VPyes) {
		this.rdbtn_VPyes = rdbtn_VPyes;
	}

	public JRadioButton getRdbtn_VPno() {
		return rdbtn_VPno;
	}

	public void setRdbtn_VPno(JRadioButton rdbtn_VPno) {
		this.rdbtn_VPno = rdbtn_VPno;
	}

	public ButtonGroup getGroupVP() {
		return GroupVP;
	}

	public void setGroupVP(ButtonGroup groupVP) {
		GroupVP = groupVP;
	}

	public JRadioButton getRdbtn_PSyes() {
		return rdbtn_PSyes;
	}

	public void setRdbtn_PSyes(JRadioButton rdbtn_PSyes) {
		this.rdbtn_PSyes = rdbtn_PSyes;
	}

	public JRadioButton getRdbtn_PSno() {
		return rdbtn_PSno;
	}

	public void setRdbtn_PSno(JRadioButton rdbtn_PSno) {
		this.rdbtn_PSno = rdbtn_PSno;
	}

	public ButtonGroup getGroupPS() {
		return GroupPS;
	}

	public void setGroupPS(ButtonGroup groupPS) {
		GroupPS = groupPS;
	}

	public JRadioButton getRdbtn_GFyes() {
		return rdbtn_GFyes;
	}

	public void setRdbtn_GFyes(JRadioButton rdbtn_GFyes) {
		this.rdbtn_GFyes = rdbtn_GFyes;
	}

	public JRadioButton getRdbtn_GFno() {
		return rdbtn_GFno;
	}

	public void setRdbtn_GFno(JRadioButton rdbtn_GFno) {
		this.rdbtn_GFno = rdbtn_GFno;
	}

	public ButtonGroup getGroupGF() {
		return GroupGF;
	}

	public void setGroupGF(ButtonGroup groupGF) {
		GroupGF = groupGF;
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
	
}
