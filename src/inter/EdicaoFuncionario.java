package inter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controladora.EmpresaFachada;
import controladora.FuncionarioController;
import controladora.IEmpresaFachada;
import exceptions.CodigoPequenoException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Funcionario;

public class EdicaoFuncionario extends JInternalFrame {
		private JTextField textNome;
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
	private JButton btnAtualizar;
	private JLabel lbl_Login;
	private JLabel lbl_codigo;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EdicaoFuncionario frame = new EdicaoFuncionario();
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
	public EdicaoFuncionario() {
		setEnabled(false);
		getContentPane().setBackground(new Color(219, 112, 147));
		getContentPane().setLayout(null);
		setBounds(0, 0, 600, 400);
		
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
		
		lbl_Login = new JLabel("Login");
		lbl_Login.setBounds(10, 111, 46, 14);
		panel.add(lbl_Login);
		
		JLabel lbl_GerP = new JLabel("O funcion\u00E1rio poder\u00E1 gerenciar \r\nprodutos e servi\u00E7os?");
		lbl_GerP.setBounds(269, 0, 276, 53);
		panel.add(lbl_GerP);
		
		rdbtn_GPyes = new JRadioButton("Sim");
		rdbtn_GPyes.setBackground(Color.WHITE);
		rdbtn_GPyes.setBounds(269, 33, 70, 23);
		panel.add(rdbtn_GPyes);
		
		rdbtn_GPno = new JRadioButton("N\u00E3o");
		rdbtn_GPno.setBackground(Color.WHITE);
		rdbtn_GPno.setBounds(362, 33, 70, 23);
		panel.add(rdbtn_GPno);
		
		GrupoGP.add(rdbtn_GPyes);
		GrupoGP.add(rdbtn_GPno);

		
		JLabel lbl_VendP = new JLabel("O funcion\u00E1rio poder\u00E1 vender produtos?");
		lbl_VendP.setBounds(269, 52, 276, 53);
		panel.add(lbl_VendP);
		
		rdbtn_VPyes = new JRadioButton("Sim");
		rdbtn_VPyes.setBackground(Color.WHITE);
		rdbtn_VPyes.setBounds(269, 88, 70, 23);
		panel.add(rdbtn_VPyes);
		
	    rdbtn_VPno = new JRadioButton("N\u00E3o");
		rdbtn_VPno.setBackground(Color.WHITE);
		rdbtn_VPno.setBounds(362, 88, 70, 23);
		panel.add(rdbtn_VPno);
		
		GroupVP.add(rdbtn_VPyes);
		GroupVP.add(rdbtn_VPno);
		
		JLabel lbl_PreS = new JLabel("O funcion\u00E1rio poder\u00E1 prestar servi\u00E7os?");
		lbl_PreS.setBounds(269, 103, 276, 53);
		panel.add(lbl_PreS);
		
		rdbtn_PSyes = new JRadioButton("Sim");
		rdbtn_PSyes.setBackground(Color.WHITE);
		rdbtn_PSyes.setBounds(269, 142, 70, 23);
		panel.add(rdbtn_PSyes);
		
		rdbtn_PSno = new JRadioButton("N\u00E3o");
		rdbtn_PSno.setBackground(Color.WHITE);
		rdbtn_PSno.setBounds(362, 142, 70, 23);
		panel.add(rdbtn_PSno);
		
		GroupPS.add(rdbtn_PSyes);
		GroupPS.add(rdbtn_PSno);
		
		JLabel lbl_GerF = new JLabel("O funcion\u00E1rio poder\u00E1 gerenciar funcion\u00E1rios?");
		lbl_GerF.setBounds(269, 158, 276, 53);
		panel.add(lbl_GerF);
		
		rdbtn_GFyes = new JRadioButton("Sim");
		rdbtn_GFyes.setBackground(Color.WHITE);
		rdbtn_GFyes.setBounds(269, 193, 70, 23);
		panel.add(rdbtn_GFyes);
		
		rdbtn_GFno = new JRadioButton("N\u00E3o");
		rdbtn_GFno.setBackground(Color.WHITE);
		rdbtn_GFno.setBounds(362, 193, 70, 23);
		panel.add(rdbtn_GFno);
		
		GroupGF.add(rdbtn_GFyes);
		GroupGF.add(rdbtn_GFno);
		
		
		btnAtualizar = new JButton("Atualizar");
		
		
		btnAtualizar.setBounds(10, 209, 82, 23);
		panel.add(btnAtualizar);
		
		lbl_codigo = new JLabel("C\u00F3digo");
		lbl_codigo.setBounds(10, 166, 46, 14);
		panel.add(lbl_codigo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(116, 209, 84, 23);
		panel.add(btnVoltar);
		setBounds(100, 100, 618, 387);

	}
	
	public boolean atualizar(Funcionario funcionarioSelecionado, IEmpresaFachada instance) throws NaoExisteException, LoginInvalidoException, CodigoPequenoException
	{
		try
		{
			this.preencher(funcionarioSelecionado);
			if(this.textNome.getText().length() > 0)
			{
				String nome = this.textNome.getText();
				return instance.atualizarFuncionario(funcionarioSelecionado, funcionarioSelecionado.getLogin(), funcionarioSelecionado.getSenha(), nome, this.rdbtn_VPyes.isSelected(), this.rdbtn_PSyes.isSelected(), this.rdbtn_GPyes.isSelected(), this.rdbtn_GFyes.isSelected(), funcionarioSelecionado.getCodigo());
			}else
			{
				throw new StringVaziaException("nome");
			}
					
		}catch(StringVaziaException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(NaoExisteException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(LoginInvalidoException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(CodigoPequenoException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
		
	}
	
	
	
	
	
	public void preencher(Funcionario funcionario)
	{
		
		this.textNome.setText(funcionario.getNome());
		this.rdbtn_GFno.setSelected(!funcionario.isGerenciaFuncionarios());
		this.rdbtn_GFyes.setSelected(funcionario.isGerenciaFuncionarios());
		this.rdbtn_GPno.setSelected(!funcionario.isGerenciaProdutosServicos());
		this.rdbtn_GPyes.setSelected(funcionario.isGerenciaProdutosServicos());
		this.rdbtn_PSno.setSelected(!funcionario.isVendeServico());
		this.rdbtn_PSyes.setSelected(funcionario.isVendeServico());
		this.rdbtn_VPno.setSelected(!funcionario.isVendeProduto());
		this.rdbtn_VPyes.setSelected(funcionario.isVendeProduto());
		this.lbl_Login.setText("Login: "+funcionario.getLogin());
		this.lbl_codigo.setText("Código: "+funcionario.getCodigo());
		

	}
	


	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
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
		return btnAtualizar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAtualizar = btnAdicionar;
	}
	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}
	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}
	public JLabel getLbl_Login() {
		return lbl_Login;
	}
	public void setLbl_Login(JLabel lbl_Login) {
		this.lbl_Login = lbl_Login;
	}
	public JLabel getLbl_codigo() {
		return lbl_codigo;
	}
	public void setLbl_codigo(JLabel lbl_codigo) {
		this.lbl_codigo = lbl_codigo;
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	
	

}