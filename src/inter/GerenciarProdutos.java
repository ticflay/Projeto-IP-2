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

import controladora.IEmpresaFachada;
import controladora.ProdutoController;
import exceptions.AbertoNoCarrinhoException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Produto;

public class GerenciarProdutos extends JPanel {
	private JList listProdutos;
	   private JPanel panel_rosa;
	   private JPanel panel_inferior;
	   private DefaultListModel model = new DefaultListModel();
	   private JTextField text_pesquisar;
	   private JButton btnAdicionar;
	   private JButton btnRemover;
	   private JButton btnAtualizar;
	   private JButton btnPesquisar;
	/**
	 * Create the panel.
	 */
	public GerenciarProdutos() {
		 


			
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
				
				listProdutos = new JList();
				
			
				listProdutos.setBounds(0, 0, 663, 538);
				panel_inferior.add(listProdutos);
				
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
				
				btnPesquisar = new JButton("New button");
				btnPesquisar.setBounds(1037, 49, 33, 26);
				panel_inferior.add(btnPesquisar);
				
				
			 
				
			
				
				
				
				
				

			}
			
			public void adicionar(Produto produto)
			{
				listProdutos.setModel(model);
				model.addElement(produto);
				
			}
			
			public void atualizar(Produto produto, int index)
			{
				model.setElementAt(produto, index);
			}
			
			


			public boolean remover(VenderProdutos vender, IEmpresaFachada fachada) throws NaoExisteException, AbertoNoCarrinhoException
			{
				Produto produto = (Produto)this.listProdutos.getSelectedValue();
				int index = this.listProdutos.getSelectedIndex();
				if(produto != null)
				{
					if(!fachada.existeProdutoCarrinho(produto))
					{
						boolean sucesso = fachada.removerProduto(produto);
						if(sucesso)
						{
							this.model.removeElementAt(index);
							vender.remover(index);
							return true;
						}
					}else
					{
						throw new AbertoNoCarrinhoException("produto");
					}
				}
				return false;
			}
			
			public boolean esvaziar()
			{
				this.model.clear();
				if(this.model.isEmpty())
				{
					return true;
				}
				return false;
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


			public JButton getBtnPesquisar() {
				return btnPesquisar;
			}


			public void setBtnPesquisar(JButton btnPesquisar) {
				this.btnPesquisar = btnPesquisar;
			}

			public JList getListProdutos() {
				return listProdutos;
			}

			public void setListProdutos(JList listProdutos) {
				this.listProdutos = listProdutos;
			}
			
			
			
}
