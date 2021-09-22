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
import texto.Produto;


public class VenderProdutos extends JPanel {

	 private JList ListaVenda;
	 private DefaultListModel model = new DefaultListModel();
	 private JButton btnAdicionarAoCarrinho;
	 private JButton btnVisualizarCarrinho;
	 private JPanel panel;
	 
	/**
	 * Create the panel.
	 */
	public VenderProdutos() {

		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		btnAdicionarAoCarrinho = new JButton("Adicionar ao carrinho");
		
		btnAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionarAoCarrinho.setBounds(830, 244, 226, 34);
		add(btnAdicionarAoCarrinho);
		
		btnVisualizarCarrinho = new JButton("Visualizar Carrinho");
		
		btnVisualizarCarrinho.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVisualizarCarrinho.setBounds(830, 314, 226, 34);
		add(btnVisualizarCarrinho);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(36, 124, 623, 475);
		add(panel);
		panel.setLayout(null);
		
		ListaVenda = new JList();
		ListaVenda.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ListaVenda.setBounds(29, 26, 560, 422);
		panel.add(ListaVenda);
	}
	
	public boolean adicionarAoCarrinho(IEmpresaFachada fachada, int quantidade, VisualizarCarrinho carrinho) throws NaoExisteException, JaExisteException
	{
		Produto produtoSelecionado = (Produto)this.ListaVenda.getSelectedValue();
		if(produtoSelecionado != null)
	    {
			Produto produtoNovo = new Produto();
			produtoNovo.setCodigo(produtoSelecionado.getCodigo());
			produtoNovo.setEmpresa(produtoSelecionado.getEmpresa());
			produtoNovo.setNome(produtoSelecionado.getNome());
			produtoNovo.setPreco(produtoSelecionado.getPreco());
			produtoNovo.setQuantidade(quantidade);
			boolean sucesso = fachada.cadastrarCarrinho(produtoNovo);
			if(sucesso)
			{
				carrinho.adicionarProdutos(produtoNovo);
				return true;
			}
		}
		return false;
	}


	public void adicionar(Produto produto)
	{
		ListaVenda.setModel(model);
		model.addElement(produto);
	}

	
	public void remover(int index)
	{
		this.model.removeElementAt(index);
	}
	
	public void esvaziar()
	{
		this.model.clear();
	}
	
	
	public void atualizar(Produto produto, int index)
	{
		this.model.setElementAt(produto, index);
	}
	
	public DefaultListModel getModel() {
		return model;
	}

	public void setModel(DefaultListModel model) {
		this.model = model;
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
	
	
}
