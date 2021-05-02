package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class VentanaPrincipal extends JFrame {

	private JTabbedPane JTabbedPane = null;

	private static VentanaPrincipal instance = null;

	public static VentanaPrincipal getInstance() {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Gestión de ventas de coches");
		this.setBounds(0, 0, 600, 400);

		this.setJMenuBar(new MenuBar());

		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);

	}

	/**
	 * 
	 * @return
	 */
	public JTabbedPane getPanelPrincipal() {
		JTabbedPane = new JTabbedPane();

		JTabbedPane.add("Fabricantes", new PanelFabricantes());
		JTabbedPane.add("Coches", new PanelCoches());
		JTabbedPane.add("Clientes", new PanelCliente());
		JTabbedPane.add("Concesionario", new PanelConcesionario());
		JTabbedPane.add("Ventas", new PanelVenta());

		return JTabbedPane;
	}

	public static void main(String[] args) {

		VentanaPrincipal.getInstance().setVisible(true);

	}

	/**
	 * 
	 * @return to JTabbedPane
	 */
	public JTabbedPane getJTabbedPane() {
		return JTabbedPane;
	}

}