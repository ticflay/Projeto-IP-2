package inter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import texto.Produto;
import texto.Servico;

public class VisualizarCarrinho extends JPanel {

	private JPanel panel_pai;
	private JPanel panel_produtos;
	private JLabel lblNewLabel;
	private JPanel panel_servicos;
	private JLabel lblServicos;
	private JPanel panel;
	private JList list_produtos;
	private JList list_servicos;
    private DefaultListModel model_produtos = new DefaultListModel();
    private DefaultListModel model_servicos = new DefaultListModel();
    private JButton btnEditar;
    private JButton btnRemover;
    private JPanel panel_total;
    private JLabel lblTotalProdutos;
    private JLabel lblTotalServicos;
    private JLabel lblTotal;
    private JButton btnFinalizarCompra;
    private JLabel lblTotalCliente;
    private JTextField textPagoCliente;
	/**
	 * Create the panel.
	 */
	public VisualizarCarrinho() {
		setBounds(0, 0, 1100, 621);
		setLayout(null);
		
		panel_pai = new JPanel();
		panel_pai.setBounds(0, 0, 1100, 621);
		setLayout(null);

		add(panel_pai);
		panel_pai.setLayout(null);
		
		panel_produtos = new JPanel();
		
		panel_produtos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_produtos.setBackground(new Color(219, 112, 147));
		panel_produtos.setBounds(51, 60, 322, 43);
		panel_pai.add(panel_produtos);
		panel_produtos.setLayout(null);
		
		lblNewLabel = new JLabel("Produtos\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(21, 11, 251, 21);
		panel_produtos.add(lblNewLabel);
		
		panel_servicos = new JPanel();
		
		panel_servicos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_servicos.setLayout(null);
		panel_servicos.setBackground(new Color(219, 112, 147));
		panel_servicos.setBounds(372, 60, 322, 43);
		panel_pai.add(panel_servicos);
		
		lblServicos = new JLabel("Servi\u00E7os\r\n");
		
		lblServicos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblServicos.setBounds(21, 11, 251, 21);
		panel_servicos.add(lblServicos);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(51, 100, 643, 346);
		panel_pai.add(panel);
		panel.setLayout(null);
		
		list_produtos = new JList();
		list_produtos.setBackground(new Color(255, 182, 193));
		list_produtos.setBounds(0, 0, 643, 343);
		panel.add(list_produtos);
		
		list_servicos = new JList();
		list_servicos.setBackground(new Color(255, 182, 193));
		list_servicos.setBounds(0, 0, 643, 343);
		list_servicos.setVisible(false);
		panel.add(list_servicos);
		
		btnEditar = new JButton("Editar\r\n");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEditar.setBounds(798, 350, 203, 23);
		panel_pai.add(btnEditar);
		
		btnRemover = new JButton("Remover\r\n");
		
		btnRemover.setBounds(798, 408, 203, 23);
		panel_pai.add(btnRemover);
		
		panel_total = new JPanel();
		panel_total.setBackground(new Color(219, 112, 147));
		panel_total.setBounds(51, 446, 643, 43);
		panel_pai.add(panel_total);
		panel_total.setLayout(null);
		
		lblTotalProdutos = new JLabel("Total Produtos: ");
		lblTotalProdutos.setBounds(0, 0, 191, 14);
		panel_total.add(lblTotalProdutos);
		
		lblTotalServicos = new JLabel("Total Servi\u00E7os:");
		lblTotalServicos.setBounds(0, 25, 191, 14);
		panel_total.add(lblTotalServicos);
		
		lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(301, 11, 273, 14);
		panel_total.add(lblTotal);
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		
		btnFinalizarCompra.setBounds(798, 466, 203, 23);
		panel_pai.add(btnFinalizarCompra);
		
		lblTotalCliente = new JLabel("Total pago pelo cliente: ");
		lblTotalCliente.setBounds(787, 60, 115, 14);
		panel_pai.add(lblTotalCliente);
		
		textPagoCliente = new JTextField();
		textPagoCliente.setBounds(786, 73, 243, 30);
		panel_pai.add(textPagoCliente);
		textPagoCliente.setColumns(10);
		
		textPagoCliente.setDocument(new SoDouble());


	}
	
	public void esvaziar()
	{
		this.model_produtos.clear();
		this.model_servicos.clear();
	}

	

	public void adicionarServico(Servico servico)
	{
		list_servicos.setModel(model_servicos);
		model_servicos.addElement(servico);
	
	}
	public void adicionarProdutos(Produto produto)
	{
		
			list_produtos.setModel(model_produtos);
			model_produtos.addElement(produto);
		
	}
	
	public void preencherPreco(String precoServico, String precoProduto, String precoTotal)
	{
		this.lblTotalServicos.setText(precoServico);
		this.lblTotalProdutos.setText(precoProduto);
		this.lblTotal.setText(precoTotal);
	}
	
	public void removerProduto(int index)
	{
		this.model_produtos.removeElementAt(index);
	}
	
	public void removerServico(int index)
	{
		this.model_servicos.remove(index);
	}
	
	public JPanel getPanel_pai() {
		return panel_pai;
	}
	public void setPanel_pai(JPanel panel_pai) {
		this.panel_pai = panel_pai;
	}
	public JPanel getPanel_produtos() {
		return panel_produtos;
	}
	public void setPanel_produtos(JPanel panel_produtos) {
		this.panel_produtos = panel_produtos;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	public JPanel getPanel_servicos() {
		return panel_servicos;
	}
	public void setPanel_servicos(JPanel panel_servicos) {
		this.panel_servicos = panel_servicos;
	}
	public JLabel getLblServicos() {
		return lblServicos;
	}
	public void setLblServicos(JLabel lblServicos) {
		this.lblServicos = lblServicos;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JList getList_produtos() {
		return list_produtos;
	}
	public void setList_produtos(JList list_produtos) {
		this.list_produtos = list_produtos;
	}
	public JList getList_servicos() {
		return list_servicos;
	}
	public void setList_servicos(JList list_servicos) {
		this.list_servicos = list_servicos;
	}
	public DefaultListModel getModel_produtos() {
		return model_produtos;
	}
	public void setModel_produtos(DefaultListModel model_produtos) {
		this.model_produtos = model_produtos;
	}
	public DefaultListModel getModel_servicos() {
		return model_servicos;
	}
	public void setModel_servicos(DefaultListModel model_servicos) {
		this.model_servicos = model_servicos;
	}


	public JButton getBtnEditar() {
		return btnEditar;
	}


	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}


	public JButton getBtnRemover() {
		return btnRemover;
	}


	public void setBtnRemover(JButton btnRemover) {
		this.btnRemover = btnRemover;
	}


	public JPanel getPanel_total() {
		return panel_total;
	}


	public void setPanel_total(JPanel panel_total) {
		this.panel_total = panel_total;
	}


	public JLabel getLblTotalProdutos() {
		return lblTotalProdutos;
	}


	public JButton getBtnFinalizarCompra() {
		return btnFinalizarCompra;
	}


	public void setBtnFinalizarCompra(JButton btnFinalizarCompra) {
		this.btnFinalizarCompra = btnFinalizarCompra;
	}


	public void setLblTotalProdutos(JLabel lblTotalProdutos) {
		this.lblTotalProdutos = lblTotalProdutos;
	}


	public JLabel getLblTotalServicos() {
		return lblTotalServicos;
	}


	public void setLblTotalServicos(JLabel lblTotalServicos) {
		this.lblTotalServicos = lblTotalServicos;
	}


	public JLabel getLblTotal() {
		return lblTotal;
	}


	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}


	public JLabel getLblTotalCliente() {
		return lblTotalCliente;
	}


	public void setLblTotalCliente(JLabel lblTotalCliente) {
		this.lblTotalCliente = lblTotalCliente;
	}


	public JTextField getTextPagoCliente() {
		return textPagoCliente;
	}


	public void setTextPagoCliente(JTextField textPagoCliente) {
		this.textPagoCliente = textPagoCliente;
	}
	
	
}
