package inter;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class HistoricoVendas extends JPanel {
	

	private DefaultListModel model = new DefaultListModel();
	private JList list;
	/**
	 * Create the panel.
	 */
	public HistoricoVendas() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBackground(new Color(219, 112, 147));
		panelProdutos.setBounds(26, 11, 1043, 584);
		add(panelProdutos);
		panelProdutos.setLayout(null);
		
		list = new JList();
		list.setBounds(34, 36, 955, 519);
		panelProdutos.add(list);

	}
	
	public void adicionar(String string)
	{
		list.setModel(model);
		model.addElement(string);
	}
	
	public void limpar()
	{
		this.model.clear();
	}


	public DefaultListModel getModelProdutos() {
		return model;
	}

	public void setModelProdutos(DefaultListModel modelProdutos) {
		this.model = modelProdutos;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	
}
