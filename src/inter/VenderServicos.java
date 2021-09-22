package inter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controladora.IEmpresaFachada;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Servico;

public class VenderServicos extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JList ListaVenda;
	private DefaultListModel model = new DefaultListModel();
	private JButton btnAdicionarAoCarrinho;
	private JButton btnVisualizarCarrinho;
	
	public VenderServicos() {
		
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 62, 623, 489);
		add(panel);
		
		ListaVenda = new JList();
		ListaVenda.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		ListaVenda.setBounds(26, 29, 554, 387);
		panel.add(ListaVenda);
		
		btnAdicionarAoCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionarAoCarrinho.setBounds(792, 185, 226, 34);
		add(btnAdicionarAoCarrinho);
		
		btnVisualizarCarrinho = new JButton("Visualizar Carrinho");
		
		btnVisualizarCarrinho.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVisualizarCarrinho.setBounds(792, 268, 226, 34);
		add(btnVisualizarCarrinho);

	}
	
	public void adicionar(Servico servico)
	{
		ListaVenda.setModel(model);
		model.addElement(servico);
	}
	
	public boolean adicionarAoCarrinho(IEmpresaFachada fachada, VisualizarCarrinho carrinho) throws NaoExisteException, JaExisteException
	{
		Servico servicoSelecionado = (Servico)this.ListaVenda.getSelectedValue();
		if(servicoSelecionado != null)
		{
			boolean sucesso = fachada.cadastrarCarrinho(servicoSelecionado);
			if(sucesso)
			{
				carrinho.adicionarServico(servicoSelecionado);
				return true;
			}
		}
		return false;
	}
	
	public void esvaziar()
	{
		this.model.clear();
	}
	
	public void atualizar(Servico servico, int index)
	{
		this.model.setElementAt(servico, index);
	}

	public void remover(int index)
	{
		this.model.remove(index);
	}
	
	public JList getListaVenda() {
		return ListaVenda;
	}

	public void setListaVenda(JList listaVenda) {
		ListaVenda = listaVenda;
	}

	public JButton getBtnAdicionarAoCarrinho() {
		return btnAdicionarAoCarrinho;
	}

	public void setBtnAdicionarAoCarrinho(JButton btnAdicionarAoCarrinho) {
		this.btnAdicionarAoCarrinho = btnAdicionarAoCarrinho;
	}

	public JButton getBtnVisualizarCarrinho() {
		return btnVisualizarCarrinho;
	}

	public void setBtnVisualizarCarrinho(JButton btnVisualizarCarrinho) {
		this.btnVisualizarCarrinho = btnVisualizarCarrinho;
	}

	public DefaultListModel getModel() {
		return model;
	}

	public void setModel(DefaultListModel model) {
		this.model = model;
	}
	
	

}
