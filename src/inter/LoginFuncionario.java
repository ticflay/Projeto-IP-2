package inter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controladora.EmpresaController;
import controladora.IEmpresaFachada;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import exceptions.StringVaziaException;

import texto.Empresa;

public class LoginFuncionario extends JPanel {

	private JTextField text_user;
	private JPasswordField pass;
	private JButton btn_entrar;

	public JButton getBtn_entrar() {
		return btn_entrar;
	}


	public void setBtn_entrar(JButton btn_entrar) {
		this.btn_entrar = btn_entrar;
	}


	public JTextField getText_user() {
		return text_user;
	}


	public void setText_user(JTextField text_user) {
		this.text_user = text_user;
	}


	public JPasswordField getPass() {
		return pass;
	}


	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}


	/**
	 * Create the panel.
	 */
	public LoginFuncionario() {
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		JPanel linha1 = new JPanel();
		linha1.setBackground(Color.BLACK);
		linha1.setBounds(375, 317, 345, 1);
		add(linha1);
		
		JPanel linha2 = new JPanel();
		linha2.setBackground(Color.BLACK);
		linha2.setBounds(375, 405, 345, 1);
		add(linha2);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 112, 147));
		panel.setBounds(315, 140, 471, 381);
		add(panel);
		panel.setLayout(null);
		
		text_user = new JTextField();
		text_user.setBackground(new Color(219, 112, 147));
		text_user.setBounds(58, 141, 348, 33);
		panel.add(text_user);
		text_user.setColumns(10);
		
		
		
		pass = new JPasswordField();
		pass.setBackground(new Color(219, 112, 147));
		pass.setBounds(58, 233, 348, 33);
		panel.add(pass);
		pass.setColumns(10);
		
		btn_entrar = new JButton("Entrar");
	
		
		btn_entrar.setBounds(125, 328, 208, 27);
		panel.add(btn_entrar);
		btn_entrar.setForeground(new Color(0, 0, 0));
		btn_entrar.setFont(new Font("Arial", Font.BOLD, 16));
		btn_entrar.setBackground(new Color(219, 112, 147));
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setBounds(58, 122, 70, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha\r\n");
		lblNewLabel_1.setBounds(58, 212, 57, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fa\u00E7a o login na sua conta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(58, 49, 248, 33);
		panel.add(lblNewLabel_2);
		

		JLabel lb_login = new JLabel("New label");
		lb_login.setIcon(new ImageIcon(LoginEmpresa.class.getResource("/inter/LOGIN.png")));
		lb_login.setBounds(0, 0, 1100, 621);
		add(lb_login);
		
		
		
		
	
	}
	

	public boolean entrar(Empresa empresa, IEmpresaFachada fachada) throws SenhasDiferentesException, NaoExisteException, LoginInvalidoException, StringVaziaException
	{
		if(this.text_user.getText().length() > 0 && this.pass.getPassword().length > 0 && empresa != null)
		{
			return fachada.entrar(this.text_user.getText(), this.pass.getPassword(), empresa);
		}else if(this.text_user.getText().length() <= 0)
		{
			throw new StringVaziaException("login");
		}else if(this.pass.getPassword().length <= 0)
		{
			throw new StringVaziaException("senha");
		}
		return false;
	}
	
	
	public void limpar()
	{
		this.text_user.setText("");
		this.pass.setText("");
	}
}
