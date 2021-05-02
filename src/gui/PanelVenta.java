package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;

import model.controllers.ControladorCliente;
import model.controllers.ControladorCoche;
import model.controllers.ControladorConcesionario;
import model.controllers.ControladorVenta;
import model.entities.Cliente;
import model.entities.Coche;
import model.entities.Concesionario;
import model.entities.Fabricante;
import model.entities.Venta;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PanelVenta extends JPanel {
	private JTextField jtfId;
	private JTextField jtfFecha;
	private JTextField jtfPrecioVenta;
	private JComboBox<Cliente> jcbCliente;
	private JComboBox<Concesionario> jcbConcesionario;
	private JComboBox<Coche> jcbCoche;

	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

	Venta actual = new Venta();

	/**
	 * Create the panel.
	 */
	public PanelVenta() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("DNI Cliente:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbCliente = new JComboBox();
		GridBagConstraints gbc_jcbCliente = new GridBagConstraints();
		gbc_jcbCliente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCliente.gridx = 1;
		gbc_jcbCliente.gridy = 1;
		add(jcbCliente, gbc_jcbCliente);

		JLabel lblNewLabel_2 = new JLabel("CIF de Concesionario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbConcesionario = new JComboBox();
		GridBagConstraints gbc_jcbConcesionario = new GridBagConstraints();
		gbc_jcbConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_jcbConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbConcesionario.gridx = 1;
		gbc_jcbConcesionario.gridy = 2;
		add(jcbConcesionario, gbc_jcbConcesionario);

		JLabel lblNewLabel_3 = new JLabel("Número de bastidor:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbCoche = new JComboBox();
		GridBagConstraints gbc_jcbCoche = new GridBagConstraints();
		gbc_jcbCoche.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCoche.gridx = 1;
		gbc_jcbCoche.gridy = 3;
		add(jcbCoche, gbc_jcbCoche);

		JLabel lblNewLabel_4 = new JLabel("fecha:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 4;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Precio venta:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfPrecioVenta = new JTextField();
		GridBagConstraints gbc_jtfPrecioVenta = new GridBagConstraints();
		gbc_jtfPrecioVenta.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrecioVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecioVenta.gridx = 1;
		gbc_jtfPrecioVenta.gridy = 5;
		add(jtfPrecioVenta, gbc_jtfPrecioVenta);
		jtfPrecioVenta.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel_1.add(btnPrimero);

		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel_1.add(btnAnterior);

		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel_1.add(btnSiguiente);

		JButton btnUtimo = new JButton(">>");
		btnUtimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel_1.add(btnUtimo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		panel.add(btnBorrar);

		cargarDatos();
		this.actual = ControladorVenta.getInstance().findPrimero();
		cargarActualEnPantalla();

	}

	/**
	 * 
	 */
	private void cargarDatos() {
		List<Coche> coches = ControladorCoche.getInstance().findAll();
		List<Cliente> clientes = ControladorCliente.getInstance().findAll();
		List<Concesionario> concesionarios = ControladorConcesionario.getInstance().findAll();

		for (Coche f : coches) {
			this.jcbCoche.addItem(f);
		}
		for (Cliente c : clientes) {
			this.jcbCliente.addItem(c);
		}
		for (Concesionario c : concesionarios) {
			this.jcbConcesionario.addItem(c);
		}

	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfFecha.setText(this.formatoFecha.format(this.actual.getFecha()));
			this.jtfPrecioVenta.setText("" + this.actual.getPrecioVenta());
			
			// Carga del cliente
			for (int i = 0; i < this.jcbCliente.getItemCount(); i++) {
				if (this.actual.getCliente().getId() == this.jcbCliente.getItemAt(i).getId()) {
					this.jcbCliente.setSelectedIndex(i);
				}
			}
		

			// concesionario
			for (int i = 0; i < this.jcbConcesionario.getItemCount(); i++) {
				if (this.actual.getConcesionario().getId() == this.jcbConcesionario.getItemAt(i).getId()) {
					this.jcbConcesionario.setSelectedIndex(i);
				}
			}}
			// coche
		for (int i = 0; i < this.jcbCoche.getItemCount(); i++) {
			if (this.actual.getCoche().getId() == this.jcbCoche.getItemAt(i).getId()) {
				this.jcbCoche.setSelectedIndex(i);
			}
		}

		
	}
	

	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setPrecioVenta(Float.parseFloat(jtfPrecioVenta.getText()));
		try {
			this.actual.setFecha(this.formatoFecha.parse(jtfFecha.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente c = (Cliente) jcbCliente.getSelectedItem();
		this.actual.setCliente(c);
		
		Concesionario co = (Concesionario) jcbConcesionario.getSelectedItem();
		this.actual.setConcesionario(co);
		
		Coche ch = (Coche) jcbCoche.getSelectedItem();
		this.actual.setCoche(ch);
		
	}
	
	/**
	 * 
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jcbCliente.setSelectedItem(null);
		this.jcbConcesionario.setSelectedItem(null);
		this.jcbCoche.setSelectedItem(null);
		this.jtfFecha.setText("");
		this.jtfPrecioVenta.setText("");
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		boolean resultado = ControladorVenta.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null) {
			this.jtfId.setText(""+this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else { // Alta - nuevo
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	
	/**
	 * 
	 */
	private void borrar() {
		String posiblesRespuestas[] = { "SI", "NO" };
		// En esta opciï¿½n se utiliza un showOptionDialog en el que personalizo el
		// icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			ControladorVenta.getInstance().borrar(this.actual);

			vaciarCampos();
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");

		}
	}

}
