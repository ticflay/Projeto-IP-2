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
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.SenhasDiferentesException;
import exceptions.StringVaziaException;

import texto.Empresa;
import controladora.IEmpresaFachada;
public class CadastroEmpresa extends JPanel {
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField text_user;
	private JPanel linha2;
	private JPanel linha3;
	private JPanel linha4;
	private JPanel fundo_rosa;
	private JLabel lbl_cadastrese;
	private JLabel lbl_user;
	private JLabel lbl_pass1;
	private JLabel lbl_pass2;
	private JButton btn_prox = new JButton("Pr\u00F3ximo\r\n");
	private JLabel lbl_nome;
	private JTextField text_nome;
	private JPanel linha1;

	/**
	 * Create the panel.
	 */
	
	public JPasswordField getPass1() {
		return pass1;
	}
	public JLabel getLbl_nome() {
		return lbl_nome;
	}
	public void setLbl_nome(JLabel lbl_nome) {
		this.lbl_nome = lbl_nome;
	}
	public JTextField getText_nome() {
		return text_nome;
	}
	public void setText_nome(JTextField text_nome) {
		this.text_nome = text_nome;
	}
	public void setPass1(JPasswordField pass1) {
		this.pass1 = pass1;
	}
	public void setPass1_EMPRESA(JPasswordField pass1) {
		this.pass1 = pass1;
	}
	public JPasswordField getPass2() {
		return pass2;
	}
	public void setPass2(JPasswordField pass2) {
		this.pass2 = pass2;
	}
	public JTextField getText_user() {
		return text_user;
	}
	public void setText_user(JTextField text_user) {
		this.text_user = text_user;
	}
	public JPanel getLinha1() {
		return linha2;
	}
	public void setLinha1(JPanel linha1) {
		this.linha2 = linha1;
	}
	public JPanel getLinha2() {
		return linha3;
	}
	public void setLinha2(JPanel linha2) {
		this.linha3 = linha2;
	}
	public JPanel getLinha3() {
		return linha4;
	}
	public void setLinha3(JPanel linha3) {
		this.linha4 = linha3;
	}
	public JPanel getFundo_rosa() {
		return fundo_rosa;
	}
	public void setFundo_rosa(JPanel fundo_rosa) {
		this.fundo_rosa = fundo_rosa;
	}
	public JLabel getLbl_cadastrese() {
		return lbl_cadastrese;
	}
	public void setLbl_cadastrese(JLabel lbl_cadastrese) {
		this.lbl_cadastrese = lbl_cadastrese;
	}
	public JLabel getLbl_user() {
		return lbl_user;
	}
	public void setLbl_user(JLabel lbl_user) {
		this.lbl_user = lbl_user;
	}
	public JLabel getLbl_pass1() {
		return lbl_pass1;
	}
	public void setLbl_pass1(JLabel lbl_pass1) {
		this.lbl_pass1 = lbl_pass1;
	}
	public JLabel getLbl_pass2() {
		return lbl_pass2;
	}
	public void setLbl_pass2(JLabel lbl_pass2) {
		this.lbl_pass2 = lbl_pass2;
	}
	public JButton getBtn_prox() {
		return btn_prox;
	}
	public void setBtn_prox(JButton btn_prox) {
		this.btn_prox = btn_prox;
	}
	public CadastroEmpresa() {
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		
		fundo_rosa = new JPanel();
		fundo_rosa.setBackground(new Color(219, 112, 147));
		fundo_rosa.setBounds(280, 62, 529, 478);
		add(fundo_rosa);
		fundo_rosa.setLayout(null);
		
		linha2 = new JPanel();
		linha2.setBackground(Color.BLACK);
		linha2.setBounds(93, 213, 341, 1);
		fundo_rosa.add(linha2);
		
		linha3 = new JPanel();
		linha3.setBackground(Color.BLACK);
		linha3.setBounds(93, 290, 341, 1);
		fundo_rosa.add(linha3);
		
		linha4 = new JPanel();
		linha4.setForeground(Color.BLACK);
		linha4.setBackground(Color.BLACK);
		linha4.setBounds(93, 365, 341, 1);
		fundo_rosa.add(linha4);
		
		
	
		
		btn_prox.setBackground(Color.BLACK);
		btn_prox.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_prox.setForeground(Color.BLACK);
		btn_prox.setBounds(172, 415, 164, 27);
		fundo_rosa.add(btn_prox);
		
		pass1 = new JPasswordField();
		pass1.setBackground(new Color(219, 112, 147));
		pass1.setForeground(Color.BLACK);
		pass1.setBounds(93, 262, 341, 27);
		fundo_rosa.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setForeground(Color.BLACK);
		pass2.setBackground(new Color(219, 112, 147));
		pass2.setBounds(93, 336, 341, 27);
		fundo_rosa.add(pass2);
		text_user = new JTextField();
		text_user.setForeground(Color.BLACK);
		text_user.setBackground(new Color(219, 112, 147));
		text_user.setColumns(10);
		text_user.setBounds(93, 184, 341, 27);
		fundo_rosa.add(text_user);
		
		lbl_cadastrese = new JLabel("CADASTRE SUA EMPRESA\r\n");
		lbl_cadastrese.setBounds(93, 74, 333, 27);
		fundo_rosa.add(lbl_cadastrese);
		
		lbl_user = new JLabel("Usu\u00E1rio");
		lbl_user.setBounds(93, 163, 71, 20);
		fundo_rosa.add(lbl_user);
		
		lbl_pass1 = new JLabel("Senha\r\n");
		lbl_pass1.setBounds(92, 240, 58, 20);
		fundo_rosa.add(lbl_pass1);
		
		lbl_pass2 = new JLabel("Repita sua senha\r\n");
		lbl_pass2.setBounds(93, 311, 146, 20);
		fundo_rosa.add(lbl_pass2);
		
		lbl_nome = new JLabel("Nome:\r\n");
		lbl_nome.setBounds(91, 112, 46, 14);
		fundo_rosa.add(lbl_nome);
		
		text_nome = new JTextField();
		text_nome.setForeground(Color.BLACK);
		text_nome.setColumns(10);
		text_nome.setBackground(new Color(219, 112, 147));
		text_nome.setBounds(93, 125, 341, 27);
		fundo_rosa.add(text_nome);
		
		linha1 = new JPanel();
		linha1.setBackground(Color.BLACK);
		linha1.setBounds(93, 151, 341, 1);
		fundo_rosa.add(linha1);
		
		
		JLabel lbl_backcad = new JLabel("New label");
		lbl_backcad.setForeground(Color.WHITE);
		lbl_backcad.setIcon(new ImageIcon(CadastroEmpresa.class.getResource("/inter/CAD_empresa.png")));
		lbl_backcad.setBounds(10, 0, 1100, 621);
		add(lbl_backcad);
	}
	
	public boolean cadastrar(IEmpresaFachada fachada) throws SenhasDiferentesException, StringVaziaException, JaExisteException, LoginInvalidoException
	{
		if(this.text_nome.getText().length() > 0 && this.text_user.getText().length() > 0 && this.pass1.getPassword().length > 0 && this.pass2.getPassword().length > 0)
		{
			
			return fachada.cadastrarEmpresa(this.text_user.getText(), this.pass1.getPassword(), this.pass2.getPassword(), this.text_nome.getText());
		}else if(this.text_nome.getText().length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(this.text_user.getText().length() <= 0)
		{
			throw new StringVaziaException("login");
			
		}else if(this.pass1.getPassword().length <= 0)
		{
			throw new StringVaziaException("senha");
		}else if(this.pass2.getPassword().length <= 0)
		{
			throw new StringVaziaException("'Repita sua senha'");
		}
		return false;
	}
	
	public void limpar()
	{
		this.text_nome.setText("");
		this.text_user.setText("");
		this.pass1.setText("");
		this.pass2.setText("");
	}

}
