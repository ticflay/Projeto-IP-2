package inter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladora.FuncionarioController;
import controladora.IEmpresaFachada;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.VoceNaoTemPermissaoException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarFuncionarios extends JPanel {

	/**
	 * Create the panel.
	 */
   private JList list_func;
   private JPanel panel_rosa;
   private JPanel panel_inferior;
   private DefaultListModel model = new DefaultListModel();
   private JTextField text_pesquisar;
   private JButton btnAdicionar;
   private JButton btnRemover;
   private JButton btnAtualizar;
   private JButton btn_pesquisar;


	public GerenciarFuncionarios() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		panel_rosa = new JPanel();
		panel_rosa.setBounds(0, 0, 1100, 90);
		panel_rosa.setBackground(new Color(219, 112, 147));
		add(panel_rosa);
		panel_rosa.setLayout(null);
		
		JLabel lbl_S = new JLabel("S");
		lbl_S.setFont(new Font("Adobe Devanagari", Font.BOLD, 99));
		lbl_S.setBounds(10, -32, 104, 122);
		panel_rosa.add(lbl_S);
		
		JLabel lbl_G = new JLabel("G");
		lbl_G.setFont(new Font("Adobe Devanagari", Font.BOLD, 88));
		lbl_G.setBounds(48, -17, 146, 107);
		panel_rosa.add(lbl_G);
		
		panel_inferior = new JPanel();
		panel_inferior.setBounds(0, 90, 1100, 549);
		add(panel_inferior);
		panel_inferior.setLayout(null);
		
		list_func = new JList();
		
	
		list_func.setBounds(0, 0, 663, 538);
		panel_inferior.add(list_func);
		
		btnAdicionar = new JButton("Adicionar ");
		
		btnAdicionar.setBounds(779, 244, 226, 34);
		panel_inferior.add(btnAdicionar);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnRemover = new JButton("Remover");
		
		btnRemover.setBounds(779, 313, 226, 34);
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_inferior.add(btnRemover);
		
		btnAtualizar = new JButton("Atualizar");
		
		btnAtualizar.setBounds(779, 378, 226, 34);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_inferior.add(btnAtualizar);
		
		text_pesquisar = new JTextField();
		text_pesquisar.setBounds(761, 49, 244, 28);
		panel_inferior.add(text_pesquisar);
		text_pesquisar.setColumns(10);
		
		JLabel lbl_pesquisar = new JLabel("Pesquisar");
		lbl_pesquisar.setBounds(761, 24, 83, 14);
		panel_inferior.add(lbl_pesquisar);
		
		btn_pesquisar = new JButton("New button");
		btn_pesquisar.setBounds(1037, 49, 33, 26);
		panel_inferior.add(btn_pesquisar);
		
		
	 
		
	
		
		
		
		
		

	}
	
	public boolean remover(IEmpresaFachada fachada) throws NaoExisteException, LoginInvalidoException, VoceNaoTemPermissaoException
	{
		Funcionario funcionarioSelecionado = (Funcionario)this.list_func.getSelectedValue();
		int index = this.list_func.getSelectedIndex();
		if(index > 0 && !funcionarioSelecionado.equals(fachada.getLogadoFuncionario()))
		{
			this.remover(index);
			return fachada.removerFuncionario(funcionarioSelecionado);
		}else if(index <= 0)
		{
			throw new VoceNaoTemPermissaoException("remover o proprietário!");
		}else if(funcionarioSelecionado.equals(fachada.getLogadoFuncionario()))
		{
			throw new VoceNaoTemPermissaoException("remover sua própria conta!");
		}
		return false;
		
	}
	
	public void adicionar(Funcionario funcionario)
	{
		list_func.setModel(model);
		model.addElement(funcionario);
		
	}
	
	public void adicionar(Dono dono)
	{
		list_func.setModel(model);
		model.addElement(dono);
	}
	
	public void esvaziar()
	{
		this.model.clear();
	}

	public void atualizar(Funcionario funcionario, int index)
	{
		this.model.set(index, funcionario);
	}
	
	public void remover(int index)
	{
		this.model.removeElementAt(index);
	}

	public JList getList_func() {
		return list_func;
	}


	public void setList_func(JList list_func) {
		this.list_func = list_func;
	}


	public JPanel getPanel_rosa() {
		return panel_rosa;
	}


	public void setPanel_rosa(JPanel panel_rosa) {
		this.panel_rosa = panel_rosa;
	}


	public JPanel getPanel_inferior() {
		return panel_inferior;
	}


	public void setPanel_inferior(JPanel panel_inferior) {
		this.panel_inferior = panel_inferior;
	}


	public DefaultListModel getModel() {
		return model;
	}


	public void setModel(DefaultListModel model) {
		this.model = model;
	}


	public JTextField getText_pesquisar() {
		return text_pesquisar;
	}


	public void setText_pesquisar(JTextField text_pesquisar) {
		this.text_pesquisar = text_pesquisar;
	}


	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}


	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}


	public JButton getBtnRemover() {
		return btnRemover;
	}


	public void setBtnRemover(JButton btnRemover) {
		this.btnRemover = btnRemover;
	}


	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}


	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}


	public JButton getBtn_pesquisar() {
		return btn_pesquisar;
	}


	public void setBtn_pesquisar(JButton btn_pesquisar) {
		this.btn_pesquisar = btn_pesquisar;
	}

	

}
