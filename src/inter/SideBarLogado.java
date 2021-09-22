package inter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBarLogado extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel panel_FUNC;
	private JLabel lbl_FUNC;
	private JPanel panel_PROD;
	private JLabel lbl_PROD;
	private JPanel panel_SERV;
	private JLabel lbl_SERV;
	private JPanel panel_VendaProdutos;
	private JLabel lbl_VendaProdutos;
	private JPanel panel_HIST;
	private JLabel lbl_HIST;
	private JButton btn_Sair;
	private JPanel panel_VendaServicos;
	public SideBarLogado() {
		
		setBounds(0, 0, 278, 621);
		setForeground(new Color(0, 153, 153));
		setBackground(new Color(219, 112, 147));
		setLayout(null);
		
		JLabel lbl_G = new JLabel("G");
		lbl_G.setFont(new Font("Adobe Devanagari", Font.BOLD, 88));
		lbl_G.setBounds(85, 24, 146, 107);
		add(lbl_G);
		
		JLabel lbl_S = new JLabel("S");
		lbl_S.setFont(new Font("Adobe Devanagari", Font.BOLD, 99));
		lbl_S.setBounds(51, 11, 104, 122);
		add(lbl_S);
		
		JLabel lbl_Sell = new JLabel("Selling\r\n");
		lbl_Sell.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lbl_Sell.setBounds(140, 61, 104, 52);
		add(lbl_Sell);
		
		JLabel lbl_Gui = new JLabel("Guide");
		lbl_Gui.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lbl_Gui.setBounds(140, 83, 104, 52);
		add(lbl_Gui);
		
		panel_FUNC = new JPanel();
	
		panel_FUNC.setBackground(new Color(219, 112, 147));
		panel_FUNC.setBounds(0, 142, 278, 52);
		add(panel_FUNC);
		panel_FUNC.setLayout(null);
		
		lbl_FUNC = new JLabel("FUNCION\u00C1RIOS");
		lbl_FUNC.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_FUNC.setBounds(41, 0, 187, 52);
		panel_FUNC.add(lbl_FUNC);
		
		panel_PROD = new JPanel();
		
		panel_PROD.setLayout(null);
		panel_PROD.setBackground(new Color(219, 112, 147));
		panel_PROD.setBounds(0, 205, 278, 52);
		add(panel_PROD);
		
		lbl_PROD = new JLabel("PRODUTOS");
		lbl_PROD.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_PROD.setBounds(59, 0, 187, 52);
		panel_PROD.add(lbl_PROD);
		
		panel_SERV = new JPanel();
		
		panel_SERV.setLayout(null);
		panel_SERV.setBackground(new Color(219, 112, 147));
		panel_SERV.setBounds(0, 279, 278, 52);
		add(panel_SERV);
		
		lbl_SERV = new JLabel("SERVI\u00C7OS");
		lbl_SERV.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_SERV.setBounds(66, 0, 187, 52);
		panel_SERV.add(lbl_SERV);
		
		panel_VendaProdutos = new JPanel();
		
		panel_VendaProdutos.setLayout(null);
		panel_VendaProdutos.setBackground(new Color(219, 112, 147));
		panel_VendaProdutos.setBounds(0, 342, 278, 52);
		add(panel_VendaProdutos);
		
	    lbl_VendaProdutos = new JLabel("VENDER PRODUTOS");
		lbl_VendaProdutos.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_VendaProdutos.setBounds(20, 0, 258, 52);
		panel_VendaProdutos.add(lbl_VendaProdutos);
		
		panel_HIST = new JPanel();
		
		panel_HIST.setLayout(null);
		panel_HIST.setBackground(new Color(219, 112, 147));
		panel_HIST.setBounds(0, 474, 278, 52);
		add(panel_HIST);
		
		lbl_HIST = new JLabel("HIST\u00D3RICO DE VENDAS");
		lbl_HIST.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_HIST.setBounds(10, 0, 278, 52);
		panel_HIST.add(lbl_HIST);
		
		btn_Sair = new JButton("Sair");
		
		btn_Sair.setBackground(new Color(219, 112, 147));
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Sair.setBounds(38, 553, 193, 23);
		add(btn_Sair);
		
		panel_VendaServicos = new JPanel();
	
		
		panel_VendaServicos.setLayout(null);
		panel_VendaServicos.setBackground(new Color(219, 112, 147));
		panel_VendaServicos.setBounds(0, 405, 278, 52);
		add(panel_VendaServicos);
		
		JLabel lbl_VendaProdutos_1 = new JLabel("VENDER SERVI\u00C7OS");
		lbl_VendaProdutos_1.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_VendaProdutos_1.setBounds(20, 0, 258, 52);
		panel_VendaServicos.add(lbl_VendaProdutos_1);

	}
	public JPanel getPanel_FUNC() {
		return panel_FUNC;
	}
	public void setPanel_FUNC(JPanel panel_FUNC) {
		this.panel_FUNC = panel_FUNC;
	}
	public JLabel getLbl_FUNC() {
		return lbl_FUNC;
	}
	public void setLbl_FUNC(JLabel lbl_FUNC) {
		this.lbl_FUNC = lbl_FUNC;
	}
	public JPanel getPanel_PROD() {
		return panel_PROD;
	}
	public void setPanel_PROD(JPanel panel_PROD) {
		this.panel_PROD = panel_PROD;
	}
	public JLabel getLbl_PROD() {
		return lbl_PROD;
	}
	public void setLbl_PROD(JLabel lbl_PROD) {
		this.lbl_PROD = lbl_PROD;
	}
	public JPanel getPanel_SERV() {
		return panel_SERV;
	}
	public void setPanel_SERV(JPanel panel_SERV) {
		this.panel_SERV = panel_SERV;
	}
	public JLabel getLbl_SERV() {
		return lbl_SERV;
	}
	public void setLbl_SERV(JLabel lbl_SERV) {
		this.lbl_SERV = lbl_SERV;
	}

	public JLabel getLbl_VENDA() {
		return lbl_VendaProdutos;
	}
	public void setLbl_VENDA(JLabel lbl_VENDA) {
		this.lbl_VendaProdutos = lbl_VENDA;
	}
	public JPanel getPanel_HIST() {
		return panel_HIST;
	}
	public void setPanel_HIST(JPanel panel_HIST) {
		this.panel_HIST = panel_HIST;
	}
	public JLabel getLbl_HIST() {
		return lbl_HIST;
	}
	public void setLbl_HIST(JLabel lbl_HIST) {
		this.lbl_HIST = lbl_HIST;
	}
	public JButton getBtn_Sair() {
		return btn_Sair;
	}
	public void setBtn_Sair(JButton btn_Sair) {
		this.btn_Sair = btn_Sair;
	}
	public JPanel getPanel_VendaProdutos() {
		return panel_VendaProdutos;
	}
	public void setPanel_VendaProdutos(JPanel panel_VendaProdutos) {
		this.panel_VendaProdutos = panel_VendaProdutos;
	}
	public JLabel getLbl_VendaProdutos() {
		return lbl_VendaProdutos;
	}
	public void setLbl_VendaProdutos(JLabel lbl_VendaProdutos) {
		this.lbl_VendaProdutos = lbl_VendaProdutos;
	}
	public JPanel getPanel_VendaServicos() {
		return panel_VendaServicos;
	}
	public void setPanel_VendaServicos(JPanel panel_VendaServicos) {
		this.panel_VendaServicos = panel_VendaServicos;
		
	}
	
	
	
}
