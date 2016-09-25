package desktop.ui;
import logic.PersonajeLogic;
import entities.*;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PersonajeDesktop {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNombreusuario;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPtsrest;

	private PersonajeLogic ctrlPers;
	Personaje perActual;
	
	/**
	 * Launch the application.
	 */
/**
 *	 public static void main(String[] args) {
 *	 
 *		EventQueue.invokeLater(new Runnable() {
 *			public void run() {
 *				try {
 *					PersonajeDesktop window = new PersonajeDesktop();
 *					window.frame.setVisible(true);
 *				} catch (Exception e) {
 *					e.printStackTrace();
 *				}
 *			}
 *		});
 *	}
 */

	/**
	 * Create the application.
	 */
	public PersonajeDesktop() {
		initialize();
		
		perActual = new Personaje();
		perActual.setEstData(Entidad.estadoData.New);
		ctrlPers = new PersonajeLogic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 339, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelIzq = new JPanel();
		panelIzq.setSize(new Dimension(50, 0));
		frame.getContentPane().add(panelIzq, BorderLayout.WEST);

		JPanel panelDer = new JPanel();
		panelDer.setSize(new Dimension(50, 0));
		frame.getContentPane().add(panelDer, BorderLayout.EAST);
		
		JPanel panelInf = new JPanel();
		panelInf.setBorder(new EmptyBorder(5, 0, 5, 0));
		frame.getContentPane().add(panelInf, BorderLayout.SOUTH);
		GridBagLayout gbl_panelInf = new GridBagLayout();
		gbl_panelInf.columnWidths = new int[] {40, 83, 83, 83};
		gbl_panelInf.rowHeights = new int[]{23, 0};
		gbl_panelInf.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panelInf.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelInf.setLayout(gbl_panelInf);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.BOTH;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 0;
		panelInf.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 2;
		gbc_btnReset.gridy = 0;
		panelInf.add(btnReset, gbc_btnReset);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 0;
		panelInf.add(btnCancelar, gbc_btnCancelar);
		
		JPanel panelSup = new JPanel();
		panelSup.setBorder(new EmptyBorder(10, 0, 10, 0));
		frame.getContentPane().add(panelSup, BorderLayout.NORTH);
		GridBagLayout gbl_panelSup = new GridBagLayout();
		gbl_panelSup.columnWidths = new int[]{17, 92, 81, 0};
		gbl_panelSup.rowHeights = new int[]{20, 14, 0};
		gbl_panelSup.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelSup.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelSup.setLayout(gbl_panelSup);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 0;
		panelSup.add(lblID, gbc_lblID);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 0;
		panelSup.add(txtId, gbc_txtId);
		
		JLabel lblNombreusuario = new JLabel("Nombre de Usuario");
		GridBagConstraints gbc_lblNombreusuario = new GridBagConstraints();
		gbc_lblNombreusuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombreusuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombreusuario.gridx = 1;
		gbc_lblNombreusuario.gridy = 1;
		panelSup.add(lblNombreusuario, gbc_lblNombreusuario);
		
		txtNombreusuario = new JTextField();
		GridBagConstraints gbc_txtNombreusuario = new GridBagConstraints();
		gbc_txtNombreusuario.anchor = GridBagConstraints.WEST;
		gbc_txtNombreusuario.gridx = 2;
		gbc_txtNombreusuario.gridy = 1;
		panelSup.add(txtNombreusuario, gbc_txtNombreusuario);
		txtNombreusuario.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[] {10, 40, 86, 60, 66, 5, 0};
		gbl_panelCentro.rowHeights = new int[] {5, 20, 20, 20, 20};
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblVida = new JLabel("Vida");
		GridBagConstraints gbc_lblVida = new GridBagConstraints();
		gbc_lblVida.anchor = GridBagConstraints.EAST;
		gbc_lblVida.insets = new Insets(0, 0, 5, 5);
		gbc_lblVida.gridx = 1;
		gbc_lblVida.gridy = 1;
		panelCentro.add(lblVida, gbc_lblVida);
		
		txtVida = new JTextField();
		txtVida.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				calcularRestantes();
			}
		});
		
		GridBagConstraints gbc_txtVida = new GridBagConstraints();
		gbc_txtVida.anchor = GridBagConstraints.NORTH;
		gbc_txtVida.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVida.insets = new Insets(0, 0, 5, 5);
		gbc_txtVida.gridx = 2;
		gbc_txtVida.gridy = 1;
		panelCentro.add(txtVida, gbc_txtVida);
		txtVida.setColumns(10);
		
		JLabel lblPtsRestantes = new JLabel("Pts. Restantes");
		GridBagConstraints gbc_lblPtsRestantes = new GridBagConstraints();
		gbc_lblPtsRestantes.anchor = GridBagConstraints.EAST;
		gbc_lblPtsRestantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPtsRestantes.gridx = 3;
		gbc_lblPtsRestantes.gridy = 1;
		panelCentro.add(lblPtsRestantes, gbc_lblPtsRestantes);
		
		txtPtsrest = new JTextField();
		txtPtsrest.setEnabled(false);
		GridBagConstraints gbc_txtPtsrest = new GridBagConstraints();
		gbc_txtPtsrest.anchor = GridBagConstraints.NORTH;
		gbc_txtPtsrest.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPtsrest.insets = new Insets(0, 0, 5, 5);
		gbc_txtPtsrest.gridx = 4;
		gbc_txtPtsrest.gridy = 1;
		panelCentro.add(txtPtsrest, gbc_txtPtsrest);
		txtPtsrest.setColumns(10);
		
		txtEnergia = new JTextField();
		txtEnergia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calcularRestantes();
			}
		});
		
		JLabel lblEnerga = new JLabel("Energ\u00EDa");
		GridBagConstraints gbc_lblEnerga = new GridBagConstraints();
		gbc_lblEnerga.anchor = GridBagConstraints.EAST;
		gbc_lblEnerga.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnerga.gridx = 1;
		gbc_lblEnerga.gridy = 2;
		panelCentro.add(lblEnerga, gbc_lblEnerga);
		
		GridBagConstraints gbc_txtEnergia = new GridBagConstraints();
		gbc_txtEnergia.anchor = GridBagConstraints.NORTH;
		gbc_txtEnergia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnergia.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnergia.gridx = 2;
		gbc_txtEnergia.gridy = 2;
		panelCentro.add(txtEnergia, gbc_txtEnergia);
		txtEnergia.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calcularRestantes();
			}
		});
		
		JLabel lblDefensa = new JLabel("Defensa");
		GridBagConstraints gbc_lblDefensa = new GridBagConstraints();
		gbc_lblDefensa.anchor = GridBagConstraints.WEST;
		gbc_lblDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefensa.gridx = 1;
		gbc_lblDefensa.gridy = 3;
		panelCentro.add(lblDefensa, gbc_lblDefensa);
		
		GridBagConstraints gbc_txtDefensa = new GridBagConstraints();
		gbc_txtDefensa.anchor = GridBagConstraints.NORTH;
		gbc_txtDefensa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_txtDefensa.gridx = 2;
		gbc_txtDefensa.gridy = 3;
		panelCentro.add(txtDefensa, gbc_txtDefensa);
		txtDefensa.setColumns(10);
		
		JLabel lblMaxdef = new JLabel("(M\u00E1x. 20)");
		GridBagConstraints gbc_lblMaxdef = new GridBagConstraints();
		gbc_lblMaxdef.anchor = GridBagConstraints.WEST;
		gbc_lblMaxdef.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxdef.gridx = 3;
		gbc_lblMaxdef.gridy = 3;
		panelCentro.add(lblMaxdef, gbc_lblMaxdef);
		
		txtEvasion = new JTextField();
		txtEvasion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calcularRestantes();
			}
		});
		
		JLabel lblEvasin = new JLabel("Evasi\u00F3n");
		GridBagConstraints gbc_lblEvasin = new GridBagConstraints();
		gbc_lblEvasin.anchor = GridBagConstraints.EAST;
		gbc_lblEvasin.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvasin.gridx = 1;
		gbc_lblEvasin.gridy = 5;
		panelCentro.add(lblEvasin, gbc_lblEvasin);
		GridBagConstraints gbc_txtEvasion = new GridBagConstraints();
		gbc_txtEvasion.anchor = GridBagConstraints.NORTH;
		gbc_txtEvasion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEvasion.insets = new Insets(0, 0, 5, 5);
		gbc_txtEvasion.gridx = 2;
		gbc_txtEvasion.gridy = 5;
		panelCentro.add(txtEvasion, gbc_txtEvasion);
		txtEvasion.setColumns(10);
		
		JLabel lblMaxevasion = new JLabel("(Max. 80)");
		GridBagConstraints gbc_lblMaxevasion = new GridBagConstraints();
		gbc_lblMaxevasion.anchor = GridBagConstraints.WEST;
		gbc_lblMaxevasion.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxevasion.gridx = 3;
		gbc_lblMaxevasion.gridy = 5;
		panelCentro.add(lblMaxevasion, gbc_lblMaxevasion);
	}
	
	public void guardar()
	{
		if(validar())
		{
			try {
				ctrlPers.guardar(this.mapearADatos());
				this.cerrar();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this.frame, e.getMessage());
			}

		}
	}
	
	public boolean validar()
	{
		boolean valido = true;
		String error = "";
		if(txtNombreusuario.getText().equals(""))
		{
			valido = false;
			error = error + "Ingrese nombre de usuario\n";
		}
		int ptDefensa = 0;
		int ptVida = 0;
		int ptEnergia = 0;
		int ptEvasion = 0;
		try
		{
			ptDefensa = parseAttributo(txtDefensa);
			ptVida = parseAttributo(txtVida);
			ptEnergia = parseAttributo(txtEnergia);
			ptEvasion = parseAttributo(txtEvasion);
		}
		catch(Exception e)
		{
			valido = false;
			error = error + "Los atributos deben tener valor numerico entero.\n";
		}
		if((ptDefensa >  20 || ptEvasion > 80) )
		{
			valido = false;
			error = error + "Los puntos de defensa no pueden superar los 20 puntos.\nLos puntos de evasion no pueden superar los 80 puntos.";
		}
		if(valido && ptDefensa + ptVida + ptEnergia + ptEvasion > 200)
		{
			error = error + "Los atributos no pueden superar los 200 puntos.\n"; 
			valido = false;
		}
		if(!valido)
		JOptionPane.showMessageDialog(frame, error,"Error", JOptionPane.ERROR_MESSAGE);
		
		return valido;
	}
	
	private int parseAttributo(JTextField campo) {
		String strCampo = campo.getText();
		strCampo = !strCampo.equals("") ? strCampo : "0";
		
		return Integer.parseInt(strCampo);
	}
	
	private Personaje mapearADatos(){
		
		perActual.setNombre(txtNombreusuario.getText());
		perActual.setDefensa(parseAttributo(txtDefensa));
		perActual.setEvasion(parseAttributo(txtEvasion));
		perActual.setVida(parseAttributo(txtVida));
		perActual.setEnergia(parseAttributo(txtEnergia));
		
		return perActual;
	}
	
	public void mapearDeDatos(Personaje per) {

		perActual = per;
		
		String perID = String.valueOf(per.getId());
		String perVida = String.valueOf(per.getVida());
		String perDefensa = String.valueOf(per.getDefensa());
		String perEnergia = String.valueOf(per.getEnergia());
		String perEvasion = String.valueOf(per.getEvasion());
		String perNombre = per.getNombre();
		
		
		this.txtId.setText(perID);
		this.txtNombreusuario.setText(perNombre);
		this.txtVida.setText(perVida);
		this.txtDefensa.setText(perDefensa);
		this.txtEnergia.setText(perEnergia);
		this.txtEvasion.setText(perEvasion);
		
		
	}

	private void calcularRestantes()
	{
		int restantes = 200;
		if(!txtDefensa.getText().equals(null))
		{
			try {
				restantes = restantes - Integer.parseInt(txtDefensa.getText());
			} catch (NumberFormatException e) 
			{
				
			}
		}
		if (!txtEnergia.getText().equals(null)) {
			
		
			try {
				restantes = restantes - Integer.parseInt(txtEnergia.getText());
			} catch (NumberFormatException e) 
			{
				
			}
		}
		if(!txtEvasion.equals(null))
		{
			try {
				restantes = restantes - Integer.parseInt(txtEvasion.getText());
			} catch (NumberFormatException e) 
			{
				
			}
		}
		if(!txtVida.getText().equals(null))
			try {
				restantes = restantes - Integer.parseInt(txtVida.getText());
			} catch (NumberFormatException e) 
			{
				
			}
		txtPtsrest.setText(String.valueOf(restantes));
	}
	
	private void limpiarCampos()
	{
		txtDefensa.setText("");
		txtEnergia.setText("");
		txtEvasion.setText("");
		txtId.setText("");
		txtNombreusuario.setText("");
		txtPtsrest.setText("");
		txtVida.setText("");
	}
	public void cerrar()
	{
		this.frame.dispose();
	}

	public JFrame getFrame() {
		return frame;
	}
}

