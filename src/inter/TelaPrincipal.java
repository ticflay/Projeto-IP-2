package inter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controladora.EmpresaFachada;
import exceptions.AbertoNoCarrinhoException;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import exceptions.StringVaziaException;
import exceptions.VoceNaoTemPermissaoException;

import texto.Dono;
import texto.Empresa;
import texto.Funcionario;
import texto.Historico;
import texto.Produto;
import texto.Servico;
import controladora.IEmpresaFachada;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Empresa empresaLogada;
	private Funcionario funcionarioLogado;
	private Dono donoLogado;

	IEmpresaFachada fachada = EmpresaFachada.getInstance();
	/**
	 * Launch the application.
	 */
	

	void setColor(JPanel panel1, JPanel panel2, JLabel label)
	{

		panel1.setBackground(new Color(255, 182, 193));
		panel2.setBackground(new Color(255, 182, 193));
		label.setForeground(new Color(240,240,240));

	}

	void resetColor(JPanel panel1, JPanel panel2, JLabel label)
	{
		panel1.setBackground(new Color(219, 112, 147));
		panel2.setBackground(new Color(219, 112, 147));
		label.setForeground(new Color(240,240,240));
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
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




	public TelaPrincipal() {

		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 650);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JPanel panel_pai = new JPanel();
		panel_pai.setBackground(new Color(0, 0, 0));
		panel_pai.setBounds(0, 0, 1350, 650);
		contentPane.add(panel_pai);
		panel_pai.setLayout(null);

		JPanel sideBar_panel1 = new JPanel();
		sideBar_panel1.setBounds(0, 0, 278, 621);
		sideBar_panel1.setForeground(new Color(0, 153, 153));
		sideBar_panel1.setBackground(new Color(219, 112, 147));
		panel_pai.add(sideBar_panel1);
		sideBar_panel1.setLayout(null);

		JPanel panel_home = new JPanel();

		panel_home.setBorder(null);
		panel_home.setBackground(new Color(219, 112, 147));
		panel_home.setBounds(0, 168, 278, 52);
		sideBar_panel1.add(panel_home);
		panel_home.setLayout(null);

		JLabel lbl_home = new JLabel("Home");
		lbl_home.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_home.setForeground(new Color(0, 0, 0));
		lbl_home.setBackground(new Color(255, 255, 255));
		lbl_home.setBounds(88, 0, 180, 52);
		panel_home.add(lbl_home);

		JPanel small_h = new JPanel();
		small_h.setBackground(new Color(219, 112, 147));
		small_h.setBounds(0, 0, 4, 52);
		panel_home.add(small_h);
		small_h.setLayout(null);

		JLabel corClara = new JLabel("");
		corClara.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/inter/ROSAclaro.png")));

		JDesktopPane deskPanel = new JDesktopPane();
		deskPanel.setBounds(276, 0, 1074, 621);

		JPanel panel_login = new JPanel();

		panel_login.setBackground(new Color(219, 112, 147));
		panel_login.setBorder(null);
		panel_login.setBounds(0, 251, 278, 52);
		sideBar_panel1.add(panel_login);
		panel_login.setLayout(null);

		JLabel lbl_login = new JLabel("Login");
		lbl_login.setForeground(Color.BLACK);
		lbl_login.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_login.setBackground(Color.BLACK);
		lbl_login.setBounds(86, 0, 182, 52);
		panel_login.add(lbl_login);

		JPanel small_l = new JPanel();
		small_l.setBackground(new Color(219, 112, 147));
		small_l.setBounds(0, 0, 4, 52);
		panel_login.add(small_l);
		small_l.setLayout(null);

		JPanel panel_cadastro = new JPanel();

		panel_cadastro.setBorder(null);
		panel_cadastro.setBackground(new Color(219, 112, 147));
		panel_cadastro.setBounds(0, 329, 278, 52);
		sideBar_panel1.add(panel_cadastro);
		panel_cadastro.setLayout(null);

		JLabel lbl_cadastro = new JLabel("Cadastre-se");
		lbl_cadastro.setForeground(Color.BLACK);
		lbl_cadastro.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_cadastro.setBackground(Color.BLACK);
		lbl_cadastro.setBounds(53, 0, 182, 52);
		panel_cadastro.add(lbl_cadastro);

		JPanel small_c = new JPanel();
		small_c.setBackground(new Color(219, 112, 147));
		small_c.setBounds(0, 0, 4, 52);
		panel_cadastro.add(small_c);
		small_c.setLayout(null);

		JPanel panel_servicos = new JPanel();
		panel_servicos.setBorder(null);
		panel_servicos.setBackground(new Color(219, 112, 147));
		panel_servicos.setBounds(0, 405, 278, 52);
		sideBar_panel1.add(panel_servicos);
		panel_servicos.setLayout(null);

		JLabel lbl_servicos = new JLabel("Servi\u00E7os");
		lbl_servicos.setForeground(Color.BLACK);
		lbl_servicos.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_servicos.setBackground(Color.WHITE);
		lbl_servicos.setBounds(73, 0, 182, 52);
		panel_servicos.add(lbl_servicos);

		JPanel small_se = new JPanel();
		small_se.setBackground(new Color(219, 112, 147));
		small_se.setBounds(0, 0, 4, 52);
		panel_servicos.add(small_se);
		small_se.setLayout(null);

		JPanel panel_sobre = new JPanel();
		panel_sobre.setBorder(null);
		panel_sobre.setBackground(new Color(219, 112, 147));
		panel_sobre.setBounds(0, 479, 278, 52);
		sideBar_panel1.add(panel_sobre);
		panel_sobre.setLayout(null);

		JLabel lbl_sobre = new JLabel("Sobre\r\n");
		lbl_sobre.setForeground(Color.BLACK);
		lbl_sobre.setFont(new Font("Corbel Light", Font.BOLD, 25));
		lbl_sobre.setBackground(Color.WHITE);
		lbl_sobre.setBounds(86, 0, 182, 52);
		panel_sobre.add(lbl_sobre);

		JPanel small_sobre = new JPanel();
		small_sobre.setBackground(new Color(219, 112, 147));
		small_sobre.setBounds(0, 0, 4, 52);
		panel_sobre.add(small_sobre);
		small_sobre.setLayout(null);

		JLabel lbl_G = new JLabel("G");
		lbl_G.setFont(new Font("Adobe Devanagari", Font.BOLD, 88));
		lbl_G.setBounds(85, 24, 146, 107);
		sideBar_panel1.add(lbl_G);

		JLabel lbl_S = new JLabel("S");
		lbl_S.setFont(new Font("Adobe Devanagari", Font.BOLD, 99));
		lbl_S.setBounds(51, 11, 104, 122);
		sideBar_panel1.add(lbl_S);

		JLabel lbl_Sell = new JLabel("Selling\r\n");
		lbl_Sell.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lbl_Sell.setBounds(140, 61, 104, 52);
		sideBar_panel1.add(lbl_Sell);

		JLabel lbl_Gui = new JLabel("Guide");
		lbl_Gui.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lbl_Gui.setBounds(140, 83, 104, 52);
		sideBar_panel1.add(lbl_Gui);


		LoginEmpresa login = new LoginEmpresa();
		login.setBounds(276, 0, 1074, 621);

		Home home = new Home();
		home.setBounds(276, 0, 1074, 621);
		CadastroEmpresa cadastro = new CadastroEmpresa();
		cadastro.setBounds(276, 0, 1074, 621);
		Servicos serv = new Servicos();
		serv.setBounds(276, 0 , 1074, 621);
		CadastroProprietario prop = new CadastroProprietario();
		prop.setBounds(276, 0 , 1074, 621);

		GerenciarFuncionarios func = new GerenciarFuncionarios();
		func.setBounds(276, 0, 1074, 621);

		LoginFuncionario loginF = new LoginFuncionario();
		loginF.setBounds(276, 0, 1074, 621);

		NovoFuncionario addF = new NovoFuncionario();
		addF.setBounds(350, 100, 600, 345);

		TelaPrincipalLogado principal = new TelaPrincipalLogado();
		principal.setBounds(276, 0, 1074, 621);

		EdicaoFuncionario updateF = new EdicaoFuncionario();
		updateF.setBounds(350, 100, 600, 345);

		SideBarLogado side = new SideBarLogado();
		side.setBounds(0, 0, 278, 621);

		GerenciarProdutos produtos = new GerenciarProdutos();
		produtos.setBounds(276, 0, 1074, 621);

		NovoProduto addProduto = new NovoProduto();
		addProduto.setBounds(350, 100, 600, 290);

		EdicaoProduto updateProdutos = new EdicaoProduto();
		updateProdutos.setBounds(350, 100, 600, 290);

		GerenciarServicos GerenciarServicos =new GerenciarServicos();
		GerenciarServicos.setBounds(276, 0, 1074, 621);

		AdicionarServico addServico = new AdicionarServico();
		addServico.setBounds(350, 100, 600, 290);

		EdicaoServico updateServico = new EdicaoServico();
		updateServico.setBounds(350, 100, 600, 290);

		VenderProdutos venderProdutos = new VenderProdutos();
		venderProdutos.setBounds(276, 0, 1074, 621);

		VisualizarCarrinho visualizarCarrinho = new VisualizarCarrinho();
		visualizarCarrinho.setBounds(276, 0, 1074, 621);

		VenderServicos venderServicos = new VenderServicos();
		venderServicos.setBounds(276, 0, 1074, 621);

		ContagemAdicionarAoCarrinhoProdutos contagemAdicionarAoCarrinhoProduto = new ContagemAdicionarAoCarrinhoProdutos();
		ContagemEditarProduto contagemEditarProduto = new ContagemEditarProduto();

		HistoricoVendas historicoVendas = new HistoricoVendas();
		historicoVendas.setBounds(276, 0, 1074, 621);


		deskPanel.add(addF);
		deskPanel.add(updateF);
		deskPanel.add(addProduto);
		deskPanel.add(updateProdutos);
		deskPanel.add(addServico);
		deskPanel.add(updateServico);
		deskPanel.add(contagemAdicionarAoCarrinhoProduto);
		deskPanel.add(contagemEditarProduto);



		panel_pai.add(side);
		panel_pai.add(principal);
		panel_pai.add(loginF);
		panel_pai.add(func);
		panel_pai.add(home);
		panel_pai.add(login);
		panel_pai.add(cadastro);
		panel_pai.add(serv);
		panel_pai.add(prop);
		panel_pai.add(produtos);
		panel_pai.add(GerenciarServicos);
		panel_pai.add(visualizarCarrinho);
		panel_pai.add(venderProdutos);
		panel_pai.add(venderServicos);
		panel_pai.add(historicoVendas);
		panel_pai.add(deskPanel);

		//para adicionar em todos dps
		GerenciarServicos.setVisible(false);

		produtos.setVisible(false);
		updateF.setVisible(false);
		principal.setVisible(false);
		loginF.setVisible(false);
		func.setVisible(false);
		home.setVisible(true);
		login.setVisible(false);
		cadastro.setVisible(false);
		serv.setVisible(false);
		prop.setVisible(false);
		deskPanel.setVisible(false);
		side.setVisible(false);
		sideBar_panel1.setVisible(true);
		addProduto.setVisible(false);
		updateProdutos.setVisible(false);
		addServico.setVisible(false);
		updateServico.setVisible(false);
		venderProdutos.setVisible(false);
		visualizarCarrinho.setVisible(false);
		contagemAdicionarAoCarrinhoProduto.setVisible(false);
		venderServicos.setVisible(false);
		contagemEditarProduto.setVisible(false);


		historicoVendas.setVisible(false);

		//home
		panel_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setColor(panel_home, small_h, lbl_home);
				resetColor(panel_login, small_l, lbl_login);
				resetColor(panel_cadastro, small_c, lbl_cadastro);
				resetColor(panel_servicos, small_se, lbl_servicos);
				resetColor(panel_sobre, small_sobre, lbl_sobre);

				sideBar_panel1.setVisible(true);
				side.setVisible(false);

				home.setVisible(true);
				login.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				principal.setVisible(false);
				deskPanel.setVisible(false);
				addF.setVisible(false);
				side.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				updateF.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

			}
		});

		//botão para ir pra tela de atualizar funcionario
		func.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {{
				int index = func.getList_func().getSelectedIndex();
				if(index != 0)
				{
					Funcionario funcionarioSelecionado = (Funcionario) func.getList_func().getSelectedValue();
					updateF.preencher(funcionarioSelecionado);

					sideBar_panel1.setVisible(false);
					side.setVisible(true);
					login.setVisible(false);
					home.setVisible(false); 
					cadastro.setVisible(false); 
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					principal.setVisible(false); 
					produtos.setVisible(false);
					addProduto.setVisible(false); 
					updateProdutos.setVisible(false); 
					GerenciarServicos.setVisible(false); 
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					deskPanel.setVisible(true); 
					updateF.setVisible(true);
					loginF.setVisible(false); 
					addF.setVisible(false); 
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					addServico.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

				}else
				{
					JOptionPane.showMessageDialog(null, "Você não pode alterar as informaçãoes do proprietário");
				}



			}

			}
		});

		//botão para ir para a tela de cadastro do funcionario
		func.getBtnAdicionar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(true);
				principal.setVisible(false);
				addF.setVisible(true);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				updateF.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);



			}
		});

		//botão para remover funcionario
		func.getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean sucesso = func.remover(fachada);
					if(sucesso)
					{
						JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
					}
				} catch (NaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (LoginInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (VoceNaoTemPermissaoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});


		//define o que acontece ao clicar em um item da lista de funcionarios
		func.getList_func().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selected = func.getList_func().getSelectedValue().toString();
				func.getText_pesquisar().setText(selected);
				//abrir uma telinha com as informaçoes dos funcionarios (CRIAR)
			}
		});


		//botão voltar na aba de cadasto de funcionario
		addF.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sideBar_panel1.setVisible(false);
				side.setVisible(true);

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(true);
				principal.setVisible(false);
				produtos.setVisible(false);
				deskPanel.setVisible(false);
				updateF.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addF.setVisible(false);
				updateF.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

			}
		});


		//botão adicionar na tela de cadastro de funcionario
		addF.getBtnAdicionar().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean sucesso = addF.adicionar(fachada, func);
					if(sucesso)
					{
						JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
						addF.limpar();

						login.setVisible(false);
						home.setVisible(false);
						cadastro.setVisible(false);
						serv.setVisible(false);
						prop.setVisible(false);
						func.setVisible(false);
						loginF.setVisible(false);
						deskPanel.setVisible(true);
						principal.setVisible(false);
						addF.setVisible(true);
						produtos.setVisible(false);
						addProduto.setVisible(false);
						updateProdutos.setVisible(false);
						GerenciarServicos.setVisible(false);
						updateServico.setVisible(false);
						venderProdutos.setVisible(false);
						contagemAdicionarAoCarrinhoProduto.setVisible(false);
						updateF.setVisible(false);
						addServico.setVisible(false);
						visualizarCarrinho.setVisible(false);
						venderServicos.setVisible(false);
						contagemEditarProduto.setVisible(false);
						historicoVendas.setVisible(false);

						side.setVisible(true);
						sideBar_panel1.setVisible(false);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (LoginInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (StringVaziaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (CodigoPequenoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (JaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}








			}
		});

		//botão atualizar na tela de atualização do funcionario
		updateF.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = func.getList_func().getSelectedIndex();
				Funcionario funcionarioSelecionado = (Funcionario)func.getList_func().getSelectedValue();
				try {
					boolean sucesso = updateF.atualizar(funcionarioSelecionado, fachada);
					if(sucesso)
					{
						func.atualizar(funcionarioSelecionado, index);
						
						JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");

						login.setVisible(false);
						home.setVisible(false);
						cadastro.setVisible(false);
						serv.setVisible(false);
						prop.setVisible(false);
						func.setVisible(true);
						loginF.setVisible(false);
						addF.setVisible(false);
						principal.setVisible(false);
						deskPanel.setVisible(false);
						produtos.setVisible(false);
						addProduto.setVisible(false);
						updateProdutos.setVisible(false);
						GerenciarServicos.setVisible(false);
						updateServico.setVisible(false);
						venderProdutos.setVisible(false);
						contagemAdicionarAoCarrinhoProduto.setVisible(false);
						updateF.setVisible(false);
						addServico.setVisible(false);
						visualizarCarrinho.setVisible(false);
						venderServicos.setVisible(false);
						contagemEditarProduto.setVisible(false);
						historicoVendas.setVisible(false);

						side.setVisible(true);
						sideBar_panel1.setVisible(false);
					}else
					{
						JOptionPane.showMessageDialog(null, "Não foi póssivel atualizar o funcionário, tente novamente mais tarde!");
					}
				} catch (NaoExisteException | LoginInvalidoException | CodigoPequenoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}






			}});

		//botão para sair
		side.getBtn_Sair().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Alerta!", JOptionPane.YES_NO_OPTION);
				if(opcao == JOptionPane.YES_OPTION)
				{
					fachada.sairEmpresa(empresaLogada);
					fachada.sairFuncionario(funcionarioLogado);
					fachada.sairDono(donoLogado);
					empresaLogada = null;
					funcionarioLogado = null;
					donoLogado = null;
					produtos.esvaziar();
					func.esvaziar();
					GerenciarServicos.esvaziar();
					venderProdutos.esvaziar();
					venderServicos.esvaziar();
					visualizarCarrinho.esvaziar();
					historicoVendas.limpar();
					fachada.limparCarrinho();

					login.setVisible(false);
					home.setVisible(true);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					loginF.setVisible(false);
					deskPanel.setVisible(false);
					principal.setVisible(false);
					addF.setVisible(false);
					produtos.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(false);
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					addServico.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

					side.setVisible(false);
					sideBar_panel1.setVisible(true);

				}

			}
		});

		//define o que acontece ao clicar em PANEL funcionario
		side.getPanel_FUNC().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if((donoLogado != null && donoLogado.isLogado())  || (funcionarioLogado != null && funcionarioLogado.isLogado() && funcionarioLogado.isGerenciaFuncionarios()))
				{


					login.setVisible(false);
					home.setVisible(false);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(true);
					loginF.setVisible(false);
					addF.setVisible(false);
					principal.setVisible(false);
					deskPanel.setVisible(false);
					produtos.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(false);
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					addServico.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

					side.setVisible(true);
					sideBar_panel1.setVisible(false);















				}else
				{
					JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa função");
				}

			}
		});
		///Define o que acontece ao clicar em cadastro
		panel_cadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_cadastro, small_c, lbl_cadastro);
				resetColor(panel_login, small_l, lbl_login);
				resetColor(panel_home, small_h, lbl_home);
				resetColor(panel_servicos, small_se, lbl_servicos);
				resetColor(panel_sobre, small_sobre, lbl_sobre);
				panel_pai.add(cadastro);
				cadastro.setBounds(276,0,1074,621);

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(true);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				addF.setVisible(false);
				principal.setVisible(false);
				deskPanel.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(false);
				sideBar_panel1.setVisible(true);







			}
		});

		//Define o que acontece ao clicar no panelLOGIN
		panel_login.addMouseListener(new MouseAdapter() { //clica em login
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_login, small_l, lbl_login);
				resetColor(panel_home, small_h, lbl_home);
				resetColor(panel_cadastro, small_c, lbl_cadastro);
				resetColor(panel_servicos, small_se, lbl_servicos);
				resetColor(panel_sobre, small_sobre, lbl_sobre);

				panel_pai.add(login);
				login.setBounds(276,0,1074,621);


				login.setVisible(true);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				produtos.setVisible(false);
				deskPanel.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addF.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);
				principal.setVisible(false);

				side.setVisible(false);
				sideBar_panel1.setVisible(true);

				addServico.setVisible(false);



			}
		});
		//clicar em Entrar em empresa
		login.getBtn_entrar().addActionListener(new ActionListener() { //clica em entrar
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					boolean sucesso = login.logarEmpresa(fachada);
					if(sucesso)
					{
						empresaLogada = fachada.getEmpresaLogada();
						
						
						login.setVisible(false);
						home.setVisible(false);
						cadastro.setVisible(false);
						serv.setVisible(false);
						prop.setVisible(false);
						func.setVisible(false);
						loginF.setVisible(true);
						deskPanel.setVisible(false);
						principal.setVisible(false);
						addF.setVisible(false);
						produtos.setVisible(false);
						addProduto.setVisible(false);
						updateProdutos.setVisible(false);
						GerenciarServicos.setVisible(false);
						updateServico.setVisible(false);
						venderProdutos.setVisible(false);
						addServico.setVisible(false);
						contagemAdicionarAoCarrinhoProduto.setVisible(false);
						visualizarCarrinho.setVisible(false);
						venderServicos.setVisible(false);
						contagemEditarProduto.setVisible(false);
						historicoVendas.setVisible(false);

						side.setVisible(false);
						sideBar_panel1.setVisible(true);
						loginF.getBtn_entrar().addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {

								try {
									boolean sucesso = loginF.entrar(fachada.getEmpresaLogada(), fachada);
									if(sucesso)
									{
										empresaLogada = fachada.getEmpresaLogada();
										if(fachada.getLogadoFuncionario() != null)
										{
											funcionarioLogado = fachada.getLogadoFuncionario();
										}
										if(fachada.getLogadoDono() != null)
										{
											donoLogado = fachada.getLogadoDono();
										}

										preencherProduto(produtos, venderProdutos);
									

										if(fachada.getTamanhoDono() >= 0)
										{
											for(int i = 0; i < fachada.getTamanhoDono(); i++)
											{
												Dono dono = fachada.getDonoEntrar(i, empresaLogada);
												if(dono != null)
												{
													func.adicionar(dono);
													break;
												}
											}
										}

										if(fachada.getTamanhoFuncionario() >= 0)
										{
											for(int i = 0; i < fachada.getTamanhoFuncionario(); i++)
											{
												Funcionario funcionario = fachada.getFuncionarioEntrar(i, empresaLogada);
												if(funcionario != null)
												{
													func.adicionar(funcionario);
												}
											}
										}

										if(fachada.getTamanhoServico() >= 0)
										{
											for(int i = 0; i < fachada.getTamanhoServico(); i++)
											{
												Servico servico = fachada.getServicoEntrar(i, empresaLogada);
												if(servico != null)
												{
													GerenciarServicos.adicionar(servico);
												}
											}
										}
										
										preencherHistorico(historicoVendas);
										if(funcionarioLogado != null && funcionarioLogado.isLogado())
										{
											principal.getLbl_nome().setText(funcionarioLogado.getNome());
										}else if(donoLogado != null && donoLogado.isLogado())
										{
											principal.getLbl_nome().setText(donoLogado.getNome());
										}

										login.setVisible(false);
										home.setVisible(false);
										cadastro.setVisible(false);
										serv.setVisible(false);
										prop.setVisible(false);
										func.setVisible(false);
										loginF.setVisible(false);
										deskPanel.setVisible(false);
										principal.setVisible(true);
										addF.setVisible(false);
										produtos.setVisible(false);
										addProduto.setVisible(false);
										updateProdutos.setVisible(false);
										GerenciarServicos.setVisible(false);
										updateServico.setVisible(false);
										venderProdutos.setVisible(false);
										addServico.setVisible(false);
										contagemAdicionarAoCarrinhoProduto.setVisible(false);
										visualizarCarrinho.setVisible(false);
										venderServicos.setVisible(false);
										contagemEditarProduto.setVisible(false);
										historicoVendas.setVisible(false);

										side.setVisible(true);
										sideBar_panel1.setVisible(false);
										login.limpar();
										loginF.limpar();
									}else
									{

										empresaLogada = null;
										funcionarioLogado = null;
										donoLogado = null;
										login.limpar();
										loginF.limpar();
										JOptionPane.showMessageDialog(null, "Não foi póssivel completar o login, tente novamente!");

										login.setVisible(true);
										home.setVisible(false);
										cadastro.setVisible(false);
										serv.setVisible(false);
										prop.setVisible(false);
										func.setVisible(false);
										loginF.setVisible(false);
										deskPanel.setVisible(false);
										principal.setVisible(false);
										addF.setVisible(false);
										produtos.setVisible(false);
										addProduto.setVisible(false);
										updateProdutos.setVisible(false);
										GerenciarServicos.setVisible(false);
										updateServico.setVisible(false);
										venderProdutos.setVisible(false);
										addServico.setVisible(false);
										contagemAdicionarAoCarrinhoProduto.setVisible(false);
										visualizarCarrinho.setVisible(false);
										venderServicos.setVisible(false);
										contagemEditarProduto.setVisible(false);
										historicoVendas.setVisible(false);

										side.setVisible(false);
										sideBar_panel1.setVisible(true);
									}
								} catch (SenhasDiferentesException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								} catch (NaoExisteException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								} catch (LoginInvalidoException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								} catch (StringVaziaException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}



							}
						});
					}
				} catch (SenhasDiferentesException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (JaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (StringVaziaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (LoginInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}



			}
		});

		//login do funcionario, apos o da empresa		



		//Vai para o cadastro do funcionario ao clicar em próximo
		cadastro.getBtn_prox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					boolean sucesso = cadastro.cadastrar(fachada);
					if(sucesso)
					{

						Empresa empresa = fachada.getUltimo();
						if(empresa != null)
						{
							prop.setVisible(true);
							cadastro.setVisible(false);
							prop.getBtn_cad().addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										boolean sucess = prop.cadastrar(empresa, fachada);
										if(sucess)
										{
											Historico historico = new Historico();
											historico.setEmpresa(empresa);
											fachada.adicionar(historico);
											
											prop.setVisible(false);
											cadastro.setVisible(true);

											cadastro.limpar();
											prop.limpar();
											JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!");
										}
									} catch (StringVaziaException e1) {
										JOptionPane.showMessageDialog(null, e1.getMessage());
									} catch (SenhasDiferentesException e1) {
										JOptionPane.showMessageDialog(null, e1.getMessage());

									} catch (JaExisteException e1) {
										JOptionPane.showMessageDialog(null, e1.getMessage());

									}catch (Exception e1)
									{
										JOptionPane.showMessageDialog(null, e1.getMessage());

									}
								}
							});

						}
					}
				} catch (SenhasDiferentesException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (StringVaziaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (JaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (LoginInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}
		});;

		panel_servicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				setColor(panel_servicos, small_se, lbl_servicos);

				resetColor(panel_login, small_l, lbl_login);
				resetColor(panel_cadastro, small_c, lbl_cadastro);
				resetColor(panel_home, small_h, lbl_home);
				resetColor(panel_sobre, small_sobre, lbl_sobre);
				panel_pai.add(serv);
				serv.setBounds(276,0,1074,621);


				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(true);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				addF.setVisible(false);
				principal.setVisible(false);
				deskPanel.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(false);
				sideBar_panel1.setVisible(true);
			}
		});
		panel_sobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(panel_sobre, small_sobre, lbl_sobre);
				resetColor(panel_login, small_l, lbl_login);
				resetColor(panel_cadastro, small_c, lbl_cadastro);
				resetColor(panel_servicos, small_se, lbl_servicos);
				resetColor(panel_home, small_h, lbl_home);

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				addF.setVisible(false);
				principal.setVisible(false);
				deskPanel.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(false);
				sideBar_panel1.setVisible(true);
			}
		});

		//Define o que acontece ao clicar em panel PRODUTOS	
		side.getPanel_PROD().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {


				if((donoLogado != null && donoLogado.isLogado()) || (funcionarioLogado != null && funcionarioLogado.isLogado() && funcionarioLogado.isGerenciaProdutosServicos()))
				{
					sideBar_panel1.setVisible(false);
					side.setVisible(true);

					login.setVisible(false);
					home.setVisible(false);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					principal.setVisible(false);
					produtos.setVisible(true);
					deskPanel.setVisible(false);
					updateF.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(false);
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					addF.setVisible(false);
					addServico.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

				}else
				{
					JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa informação!");
				}

			}
		});

		//botão Adicionar na lista de produtos
		produtos.getBtnAdicionar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sideBar_panel1.setVisible(false);
				side.setVisible(true);

				addF.setVisible(false);
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				principal.setVisible(false);
				produtos.setVisible(false);
				deskPanel.setVisible(true);
				updateF.setVisible(false);
				addProduto.setVisible(true);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);
			}
		});

		//Botão voltar em produtos
		addProduto.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				sideBar_panel1.setVisible(false);
				side.setVisible(true);

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				principal.setVisible(false);
				produtos.setVisible(true);
				deskPanel.setVisible(false);
				updateF.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addF.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);
			}
		});



		//Define o que acontece ao clicar em um produto da lista
		produtos.getListProdutos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selected = produtos.getListProdutos().getSelectedValue().toString();
				produtos.getText_pesquisar().setText(selected);
			}
		});

	
		//Botão Adicionar na aba de cadastro de produtos
		addProduto.getBtnAdicionar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					boolean sucesso = addProduto.adicionar(fachada, produtos, venderProdutos);
					if(sucesso)
					{
						JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
						addProduto.limparTexto();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (NaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (StringVaziaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (CodigoPequenoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}

		});

		//Botão atualizar na lista de produtos
		produtos.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Produto produtoSelecionado = (Produto)produtos.getListProdutos().getSelectedValue();
				int index = produtos.getListProdutos().getSelectedIndex();
				updateProdutos.preencher(produtoSelecionado.getNome(), Integer.toString(produtoSelecionado.getCodigo()), Double.toString(produtoSelecionado.getPreco()));

				
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				principal.setVisible(false);
				produtos.setVisible(false);
				deskPanel.setVisible(true);
				updateF.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(true);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addF.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);







			}
		});

		//Botão remover na lista de produtos
		produtos.getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					produtos.remover(venderProdutos, fachada);

				} catch (NaoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (AbertoNoCarrinhoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}			

			}
		});
		
		
		updateProdutos.getBtnVoltar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				principal.setVisible(false);
				produtos.setVisible(true);
				deskPanel.setVisible(false);
				updateF.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addF.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);
			}
		});
		
		//Botão atualizar na aba de atualizar produtos
		updateProdutos.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Produto produtoSelecionado = (Produto)produtos.getListProdutos().getSelectedValue();
				int index = produtos.getListProdutos().getSelectedIndex();

				if(!fachada.existeProdutoCarrinho(produtoSelecionado))
				{
					try {
						boolean sucesso = updateProdutos.atualizar(fachada, produtoSelecionado, produtos, venderProdutos, index);
						if(sucesso)
						{
							login.setVisible(false);
							home.setVisible(false);
							cadastro.setVisible(false);
							serv.setVisible(false);
							prop.setVisible(false);
							func.setVisible(false);
							principal.setVisible(false);
							produtos.setVisible(true);
							deskPanel.setVisible(false);
							updateF.setVisible(false);
							addProduto.setVisible(false);
							updateProdutos.setVisible(false);
							GerenciarServicos.setVisible(false);
							updateServico.setVisible(false);
							venderProdutos.setVisible(false);
							addF.setVisible(false);
							contagemAdicionarAoCarrinhoProduto.setVisible(false);
							addServico.setVisible(false);
							visualizarCarrinho.setVisible(false);
							venderServicos.setVisible(false);
							contagemEditarProduto.setVisible(false);
							historicoVendas.setVisible(false);
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (StringVaziaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CodigoPequenoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NaoExisteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());;
					}
				}





			}
		});

		//clica em PANEL SERVIÇOS
		side.getPanel_SERV().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {


				if( (donoLogado != null && donoLogado.isLogado()) || (funcionarioLogado != null && funcionarioLogado.isLogado() && funcionarioLogado.isGerenciaProdutosServicos()))
				{
					sideBar_panel1.setVisible(false);
					side.setVisible(true);

					login.setVisible(false);
					home.setVisible(false);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					principal.setVisible(false);
					produtos.setVisible(false);
					deskPanel.setVisible(false);
					updateF.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(true);
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					addF.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

				}else
				{
					JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa informação!");
				}

			}
		});

		//clica em adicionar na lista de serviços
		GerenciarServicos.getBtnAdicionar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(true);
				principal.setVisible(false);
				addF.setVisible(true);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(true);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);




			}
		});

		addServico.getBtnAdicionar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean sucesso = addServico.adicionar(fachada, venderServicos, GerenciarServicos);
					if(sucesso)
					{
						addServico.limpar();
					}
				} catch (NumberFormatException | StringVaziaException | CodigoPequenoException
						| JaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		addServico.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(true);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);


			}
		});

		updateServico.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(true);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				addServico.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);
			}
		});

		updateServico.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Servico servicoSelecionado = (Servico)GerenciarServicos.getListServicos().getSelectedValue();
				int index = GerenciarServicos.getListServicos().getSelectedIndex();
				try {
					boolean sucesso = updateServico.atualizarServico(GerenciarServicos, fachada, servicoSelecionado, venderServicos, index);
					if(sucesso)
					{
						JOptionPane.showMessageDialog(null, "Serviço atualizado com sucesso!");
						updateServico.limpar();

						login.setVisible(false);
						home.setVisible(false);
						cadastro.setVisible(false);
						serv.setVisible(false);
						prop.setVisible(false);
						func.setVisible(false);
						loginF.setVisible(false);
						deskPanel.setVisible(false);
						principal.setVisible(false);
						addF.setVisible(false);
						produtos.setVisible(false);
						addProduto.setVisible(false);
						updateProdutos.setVisible(false);
						GerenciarServicos.setVisible(true);
						updateServico.setVisible(false);
						venderProdutos.setVisible(false);
						addServico.setVisible(false);
						contagemAdicionarAoCarrinhoProduto.setVisible(false);
						visualizarCarrinho.setVisible(false);
						venderServicos.setVisible(false);
						contagemEditarProduto.setVisible(false);
						historicoVendas.setVisible(false);

						side.setVisible(true);
						sideBar_panel1.setVisible(false);
					}
				} catch (NumberFormatException | StringVaziaException | NaoExisteException | CodigoPequenoException
						| AbertoNoCarrinhoException | JaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} 
		});

		GerenciarServicos.getBtnAtualizar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Servico servicoSelecionado = (Servico)GerenciarServicos.getListServicos().getSelectedValue();
				if(servicoSelecionado != null)
				{
					updateServico.preencher(servicoSelecionado.getNome(), Double.toString(servicoSelecionado.getPreco()), Integer.toString(servicoSelecionado.getCodigo()));

				}
				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(true);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(true);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);
			}
		});

		GerenciarServicos.getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GerenciarServicos.remover(fachada, venderServicos);
				} catch (NaoExisteException | AbertoNoCarrinhoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		GerenciarServicos.getListServicos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selected = GerenciarServicos.getListServicos().getSelectedValue().toString();

			}
		});


		//PERMITE VISUALIZAR O FUNCIONARIO
		

		side.getPanel_VendaProdutos().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if((donoLogado != null && donoLogado.isLogado()) || (funcionarioLogado != null && funcionarioLogado.isLogado() && funcionarioLogado.isVendeProduto()))
				{

					//venderProdutos.setModel((DefaultListModel)produtos.getListProdutos().getModel());

					login.setVisible(false);
					home.setVisible(false);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					loginF.setVisible(false);
					deskPanel.setVisible(false);
					principal.setVisible(false);
					addF.setVisible(false);
					produtos.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(false);
					updateServico.setVisible(false);
					venderProdutos.setVisible(true);
					addServico.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(false);
					contagemEditarProduto.setVisible(false);


					historicoVendas.setVisible(false);





					side.setVisible(true);
					sideBar_panel1.setVisible(false);

				}else
				{
					JOptionPane.showMessageDialog(null, "Você não tem permissão para vender produtos!");
				}

			}
		});

		venderProdutos.getListaVenda().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Selected = venderProdutos.getListaVenda().getSelectedValue().toString();
			}
		});

		venderProdutos.getBtnAdicionarAoCarrinho().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int index = venderProdutos.getListaVenda().getSelectedIndex();
				Produto produtoSelecionado =(Produto)venderProdutos.getListaVenda().getSelectedValue();
				contagemAdicionarAoCarrinhoProduto.setQuantidadeMaxima(produtoSelecionado); //define a quantidade máxima


				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(true);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(true);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);

				//clica em adicionar dps de escolher  a quantidade	
				contagemAdicionarAoCarrinhoProduto.getBtnAdicionar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						int quantidade = (Integer)contagemAdicionarAoCarrinhoProduto.getSpinner().getValue();

						try {
							boolean sucesso = venderProdutos.adicionarAoCarrinho(fachada, quantidade, visualizarCarrinho);
							if(sucesso)
							{
								JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho!");
								login.setVisible(false);
								home.setVisible(false);
								cadastro.setVisible(false);
								serv.setVisible(false);
								prop.setVisible(false);
								func.setVisible(false);
								loginF.setVisible(false);
								deskPanel.setVisible(false);
								principal.setVisible(false);
								addF.setVisible(false);
								produtos.setVisible(false);
								addProduto.setVisible(false);
								updateProdutos.setVisible(false);
								GerenciarServicos.setVisible(false);
								updateServico.setVisible(false);
								venderProdutos.setVisible(true);
								addServico.setVisible(false);
								contagemAdicionarAoCarrinhoProduto.setVisible(false);
								visualizarCarrinho.setVisible(false);
								venderServicos.setVisible(false);
								contagemEditarProduto.setVisible(false);
								historicoVendas.setVisible(false);

								side.setVisible(true);
								sideBar_panel1.setVisible(false);

							}
						} catch (NaoExisteException | JaExisteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}



					}
				});


			}
		});
		// ABRE O CARRINHO DE COMPRAS

		venderServicos.getBtnVisualizarCarrinho().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				visualizarCarrinho.preencherPreco(Double.toString(fachada.getPrecoServico()), Double.toString(fachada.getPrecoProduto()), Double.toString(fachada.getPrecoTotal()));


				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(true);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);

			}
		});

		venderProdutos.getBtnVisualizarCarrinho().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizarCarrinho.preencherPreco(Double.toString(fachada.getPrecoServico()), Double.toString(fachada.getPrecoProduto()), Double.toString(fachada.getPrecoTotal()));


				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(true);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);


			}
		});

		visualizarCarrinho.getPanel_produtos().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				visualizarCarrinho.getList_produtos().setVisible(true);
				visualizarCarrinho.getList_servicos().setVisible(false);

			}
		});

		visualizarCarrinho.getPanel_servicos().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				visualizarCarrinho.getList_servicos().setVisible(true);
				visualizarCarrinho.getList_produtos().setVisible(false);
			}
		});

		visualizarCarrinho.getBtnEditar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(visualizarCarrinho.getList_produtos().isVisible())
				{
					Produto produtoSelecionado = (Produto)visualizarCarrinho.getList_produtos().getSelectedValue();
					int index = visualizarCarrinho.getList_produtos().getSelectedIndex();
					Produto produtoOriginal;
					try {
						produtoOriginal = fachada.getProduto(produtoSelecionado);
						contagemEditarProduto.setQuantidadeMaximaInicial(produtoOriginal, produtoSelecionado);
						login.setVisible(false);
						home.setVisible(false);
						cadastro.setVisible(false);
						serv.setVisible(false);
						prop.setVisible(false);
						func.setVisible(false);
						loginF.setVisible(false);
						deskPanel.setVisible(true);
						principal.setVisible(false);
						addF.setVisible(false);
						produtos.setVisible(false);
						addProduto.setVisible(false);
						updateProdutos.setVisible(false);
						GerenciarServicos.setVisible(false);
						updateServico.setVisible(false);
						venderProdutos.setVisible(false);
						addServico.setVisible(false);
						contagemAdicionarAoCarrinhoProduto.setVisible(true);
						visualizarCarrinho.setVisible(false);
						venderServicos.setVisible(false);
						contagemEditarProduto.setVisible(false);
						historicoVendas.setVisible(false);

						side.setVisible(true);
						sideBar_panel1.setVisible(false);
						contagemEditarProduto.getBtnAtualizar().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int quantidadeNova = (Integer)contagemEditarProduto.getSpinner().getValue();
								produtoSelecionado.setQuantidade(quantidadeNova);
								visualizarCarrinho.getModel_produtos().setElementAt(produtoSelecionado, index);
								try {
									boolean sucesso = fachada.atualizarCarrinho(produtoSelecionado, quantidadeNova);
									if(sucesso)
									{
										JOptionPane.showMessageDialog(null, "Quantidade editada com sucesso!");
										login.setVisible(false);
										home.setVisible(false);
										cadastro.setVisible(false);
										serv.setVisible(false);
										prop.setVisible(false);
										func.setVisible(false);
										loginF.setVisible(false);
										deskPanel.setVisible(false);
										principal.setVisible(false);
										addF.setVisible(false);
										produtos.setVisible(false);
										addProduto.setVisible(false);
										updateProdutos.setVisible(false);
										GerenciarServicos.setVisible(false);
										updateServico.setVisible(false);
										venderProdutos.setVisible(false);
										addServico.setVisible(false);
										contagemAdicionarAoCarrinhoProduto.setVisible(false);
										visualizarCarrinho.setVisible(true);
										venderServicos.setVisible(false);
										contagemEditarProduto.setVisible(false);
										historicoVendas.setVisible(false);

										side.setVisible(true);
										sideBar_panel1.setVisible(false);
									}
								} catch (NaoExisteException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
								}




							}
						});
					} catch (NaoExisteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}


				}else
				{
					JOptionPane.showMessageDialog(null, "Serviços não podem ser editados!");
				}
			}
		});


		//quando remover
		visualizarCarrinho.getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(visualizarCarrinho.getList_produtos().isVisible())
				{
					Produto produto = (Produto)visualizarCarrinho.getList_produtos().getSelectedValue();
					int index = visualizarCarrinho.getList_produtos().getSelectedIndex();
					if(produto != null)
					{
						try {
							boolean sucesso = fachada.removerCarrinho(produto);
							if(sucesso)
							{
								visualizarCarrinho.removerProduto(index);
							}
						} catch (NaoExisteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}




				}else if(visualizarCarrinho.getList_servicos().isVisible())
				{
					Servico servico = (Servico)visualizarCarrinho.getList_servicos().getSelectedValue();
					int index = visualizarCarrinho.getList_servicos().getSelectedIndex();
					if(servico != null)
					{
						try {
							boolean sucesso = fachada.removerCarrinho(servico);
							if(sucesso)
							{
								visualizarCarrinho.removerServico(index);
							}
						} catch (NaoExisteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}

				}

			}
		});
		//quando clica em finalizar compra
		visualizarCarrinho.getBtnFinalizarCompra().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double PagoCliente;
				if(visualizarCarrinho.getTextPagoCliente().getText().length() != 0)
				{
					PagoCliente = Double.parseDouble(visualizarCarrinho.getTextPagoCliente().getText());
				}else
				{
					PagoCliente = 0.0;
				}






				if(PagoCliente >= fachada.getPrecoTotal())
				{

					Double troco =PagoCliente -  fachada.getPrecoTotal();
					for(int i = 0; i < fachada.getTamanhoProdutoCarrinho(); i++)
					{
						Produto produtoCarrinho = fachada.getProdutoCarrinho(i);
						try {
							Produto produtoOriginal = fachada.getProduto(produtoCarrinho);
							int quantidade; 
							if(produtoOriginal.getQuantidade() - produtoCarrinho.getQuantidade() < 0)
							{
								quantidade = 0;
							}else
							{
								quantidade = produtoOriginal.getQuantidade() - produtoCarrinho.getQuantidade();
							}

							boolean sucesso = fachada.vender(produtoCarrinho);
							if(sucesso)
							{
								fachada.atualizarProduto(produtoOriginal.getNome(), produtoOriginal.getCodigo(), produtoOriginal.getPreco(), quantidade, fachada.getEmpresaLogada(), produtoOriginal);
								produtos.esvaziar();
								preencherProduto(produtos, venderProdutos);
							}
						} catch (NaoExisteException e1) {
							JOptionPane.showMessageDialog(null, e1);
						} catch (StringVaziaException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (CodigoPequenoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}




						for(int j = 0; j < fachada.getTamanhoServicoCarrinho() ; j++)
						{
							Servico servicoCarrinho = fachada.getServicoCarrinho(j);
							try {
								fachada.vender(servicoCarrinho);
	
							} catch (NaoExisteException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}

						}

						LocalDateTime now = LocalDateTime.now();

						DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
						String dataFormatada = formatterData.format(now);

						DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
						String horaFormatada = formatterHora.format(now);
						String historico = "";
						if((donoLogado == null || !donoLogado.isLogado()) && (funcionarioLogado != null && funcionarioLogado.isLogado() && (funcionarioLogado.isVendeProduto() || funcionarioLogado.isVendeServico())))
						{

							historico = "Venda feita por: " +funcionarioLogado.getNome() + " às " + horaFormatada + " no dia " + dataFormatada+".";
						}else if(donoLogado != null && donoLogado.isLogado())
						{

							historico = "Venda feita por: " +donoLogado.getNome() + " às " + horaFormatada + " no dia " + dataFormatada+".";
						}
						fachada.adicionar(historico, empresaLogada);
						historicoVendas.limpar();
						preencherHistorico(historicoVendas);
						

						visualizarCarrinho.getModel_produtos().clear();
						visualizarCarrinho.getModel_servicos().clear();
						fachada.limparCarrinho();

						

					}
					JOptionPane.showMessageDialog(null, "O cliente deverá receber: "+troco+ "R$ de troco!");

				}else
				{
					JOptionPane.showMessageDialog(null, "O cliente deve pagar mais que o valor total!");
				}

			}
		});



		side.getPanel_SERV().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(true);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(false);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);

			}
		});

		side.getPanel_VendaServicos().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if((donoLogado != null && donoLogado.isLogado()) || (funcionarioLogado != null && funcionarioLogado.isLogado() && funcionarioLogado.isVendeServico()))

				{
					login.setVisible(false);
					home.setVisible(false);
					cadastro.setVisible(false);
					serv.setVisible(false);
					prop.setVisible(false);
					func.setVisible(false);
					loginF.setVisible(false);
					deskPanel.setVisible(false);
					principal.setVisible(false);
					addF.setVisible(false);
					produtos.setVisible(false);
					addProduto.setVisible(false);
					updateProdutos.setVisible(false);
					GerenciarServicos.setVisible(false);
					updateServico.setVisible(false);
					venderProdutos.setVisible(false);
					addServico.setVisible(false);
					contagemAdicionarAoCarrinhoProduto.setVisible(false);
					visualizarCarrinho.setVisible(false);
					venderServicos.setVisible(true);
					contagemEditarProduto.setVisible(false);
					historicoVendas.setVisible(false);

					side.setVisible(true);
					sideBar_panel1.setVisible(false);
				}else
				{
					JOptionPane.showMessageDialog(null, "Você não tem permissão para vender serviços");
				}


			}
		});

		venderServicos.getBtnAdicionarAoCarrinho().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean sucesso;
				try {
					sucesso = venderServicos.adicionarAoCarrinho(fachada, visualizarCarrinho);
					if(sucesso)
					{
						JOptionPane.showMessageDialog(null, "Serviço adicionado com sucesso!");
					}
				} catch (NaoExisteException | JaExisteException e1) {
					e1.printStackTrace();
				}


			}
		});



		side.getPanel_HIST().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				login.setVisible(false);
				home.setVisible(false);
				cadastro.setVisible(false);
				serv.setVisible(false);
				prop.setVisible(false);
				func.setVisible(false);
				loginF.setVisible(false);
				deskPanel.setVisible(false);
				principal.setVisible(false);
				addF.setVisible(false);
				produtos.setVisible(false);
				addProduto.setVisible(false);
				updateProdutos.setVisible(false);
				GerenciarServicos.setVisible(false);
				updateServico.setVisible(false);
				venderProdutos.setVisible(false);
				addServico.setVisible(false);
				contagemAdicionarAoCarrinhoProduto.setVisible(false);
				visualizarCarrinho.setVisible(false);
				venderServicos.setVisible(false);
				contagemEditarProduto.setVisible(false);
				historicoVendas.setVisible(true);

				side.setVisible(true);
				sideBar_panel1.setVisible(false);


			}
		});



	}
	
	public void preencherHistorico(HistoricoVendas hist)
	{
		Historico historico = fachada.getHistorico(empresaLogada);
		for(int i = 0; i < historico.getHistorico().size(); i++)
		{
			hist.adicionar(historico.getHistorico().get(i));
		}
		
	}
	
	public void preencherProduto(GerenciarProdutos produtos, VenderProdutos vender) throws NaoExisteException
	{
		if(fachada.getTamanhoProduto() >= 0)
		{
			for(int i = 0; i < fachada.getTamanhoProduto(); i++)
			{
				Produto produto = fachada.getProdutoEntrar(i, empresaLogada);
				if(produto != null)
				{
					produtos.adicionar(produto);
					vender.adicionar(produto);
				}
			}
		}
	}
	


}
