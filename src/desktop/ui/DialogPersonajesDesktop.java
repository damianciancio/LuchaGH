package desktop.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.PersonajeLogic;
import entities.Entidad.estadoData;
import entities.Personaje;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class DialogPersonajesDesktop extends JDialog {
	
	private PersonajeLogic ctrlPers;
	Personaje perActual;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombreusuario;
	private JTextField txtVida;
	private JTextField txtPtsrest;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;

	/**
	 * Launch the application.
	 *
	 * Create the dialog.
	 */
	public DialogPersonajesDesktop() {
		ctrlPers = new PersonajeLogic();
		perActual = new Personaje();
		perActual.setEstData(estadoData.New);
		this.setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelIzq = new JPanel();
			panelIzq.setSize(new Dimension(50, 0));
			contentPanel.add(panelIzq, BorderLayout.WEST);
		}
		{
			JPanel panelDer = new JPanel();
			panelDer.setSize(new Dimension(50, 0));
			contentPanel.add(panelDer, BorderLayout.EAST);
		}
		{
			JPanel panelSup = new JPanel();
			panelSup.setBorder(new EmptyBorder(10, 0, 10, 0));
			contentPanel.add(panelSup, BorderLayout.NORTH);
			GridBagLayout gbl_panelSup = new GridBagLayout();
			gbl_panelSup.columnWidths = new int[]{17, 92, 81, 0};
			gbl_panelSup.rowHeights = new int[]{20, 14, 0};
			gbl_panelSup.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelSup.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panelSup.setLayout(gbl_panelSup);
			{
				JLabel label = new JLabel("ID");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				panelSup.add(label, gbc_label);
			}
			{
				txtId = new JTextField();
				txtId.setEnabled(false);
				txtId.setColumns(10);
				GridBagConstraints gbc_txtId = new GridBagConstraints();
				gbc_txtId.anchor = GridBagConstraints.NORTHWEST;
				gbc_txtId.insets = new Insets(0, 0, 5, 0);
				gbc_txtId.gridx = 2;
				gbc_txtId.gridy = 0;
				panelSup.add(txtId, gbc_txtId);
			}
			{
				JLabel label = new JLabel("Nombre de Usuario");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.NORTHEAST;
				gbc_label.insets = new Insets(0, 0, 0, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 1;
				panelSup.add(label, gbc_label);
			}
			{
				txtNombreusuario = new JTextField();
				txtNombreusuario.setColumns(10);
				GridBagConstraints gbc_txtNombreusuario = new GridBagConstraints();
				gbc_txtNombreusuario.anchor = GridBagConstraints.WEST;
				gbc_txtNombreusuario.gridx = 2;
				gbc_txtNombreusuario.gridy = 1;
				panelSup.add(txtNombreusuario, gbc_txtNombreusuario);
			}
		}
		{
			JPanel panelInf = new JPanel();
			panelInf.setBorder(new EmptyBorder(5, 0, 5, 0));
			contentPanel.add(panelInf, BorderLayout.SOUTH);
			GridBagLayout gbl_panelInf = new GridBagLayout();
			gbl_panelInf.columnWidths = new int[]{40, 83, 83, 83, 0};
			gbl_panelInf.rowHeights = new int[]{23, 0};
			gbl_panelInf.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelInf.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelInf.setLayout(gbl_panelInf);
			{
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
			}
			{
				JButton btnReset = new JButton("Reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiarCampos();
					}
				});
				GridBagConstraints gbc_btnReset = new GridBagConstraints();
				gbc_btnReset.fill = GridBagConstraints.BOTH;
				gbc_btnReset.insets = new Insets(0, 0, 0, 5);
				gbc_btnReset.gridx = 2;
				gbc_btnReset.gridy = 0;
				panelInf.add(btnReset, gbc_btnReset);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cerrar();
					}
				});
				GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
				gbc_btnCancelar.fill = GridBagConstraints.BOTH;
				gbc_btnCancelar.gridx = 3;
				gbc_btnCancelar.gridy = 0;
				panelInf.add(btnCancelar, gbc_btnCancelar);
			}
		}
		{
			JPanel panelCentral = new JPanel();
			panelCentral.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panelCentral, BorderLayout.CENTER);
			GridBagLayout gbl_panelCentral = new GridBagLayout();
			gbl_panelCentral.columnWidths = new int[]{10, 40, 86, 60, 66, 5, 0, 0};
			gbl_panelCentral.rowHeights = new int[] {10, 20, 20, 20, 20, 30, 0};
			gbl_panelCentral.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 4.9E-324, 0.0, Double.MIN_VALUE};
			panelCentral.setLayout(gbl_panelCentral);
			{
				JLabel label = new JLabel("Vida");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 1;
				panelCentral.add(label, gbc_label);
			}
			{
				txtVida = new JTextField();
				txtVida.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						calcularRestantes();
					}
				});
				txtVida.setColumns(10);
				GridBagConstraints gbc_txtVida = new GridBagConstraints();
				gbc_txtVida.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtVida.anchor = GridBagConstraints.NORTH;
				gbc_txtVida.insets = new Insets(0, 0, 5, 5);
				gbc_txtVida.gridx = 2;
				gbc_txtVida.gridy = 1;
				panelCentral.add(txtVida, gbc_txtVida);
			}
			{
				JLabel label = new JLabel("Pts. Restantes");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 3;
				gbc_label.gridy = 1;
				panelCentral.add(label, gbc_label);
			}
			{
				txtPtsrest = new JTextField();
				txtPtsrest.setEnabled(false);
				txtPtsrest.setColumns(10);
				GridBagConstraints gbc_txtPtsrest = new GridBagConstraints();
				gbc_txtPtsrest.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPtsrest.anchor = GridBagConstraints.NORTH;
				gbc_txtPtsrest.insets = new Insets(0, 0, 5, 5);
				gbc_txtPtsrest.gridx = 4;
				gbc_txtPtsrest.gridy = 1;
				panelCentral.add(txtPtsrest, gbc_txtPtsrest);
			}
			{
				JLabel label = new JLabel("Energ\u00EDa");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 2;
				panelCentral.add(label, gbc_label);
			}
			{
				txtEnergia = new JTextField();
				txtEnergia.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						calcularRestantes();
					}
				});
				txtEnergia.setColumns(10);
				GridBagConstraints gbc_txtEnergia = new GridBagConstraints();
				gbc_txtEnergia.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEnergia.anchor = GridBagConstraints.NORTH;
				gbc_txtEnergia.insets = new Insets(0, 0, 5, 5);
				gbc_txtEnergia.gridx = 2;
				gbc_txtEnergia.gridy = 2;
				panelCentral.add(txtEnergia, gbc_txtEnergia);
			}
			{
				JLabel label = new JLabel("Defensa");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.WEST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 3;
				panelCentral.add(label, gbc_label);
			}
			{
				txtDefensa = new JTextField();
				txtDefensa.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						calcularRestantes();
					}
				});
				txtDefensa.setColumns(10);
				GridBagConstraints gbc_txtDefensa = new GridBagConstraints();
				gbc_txtDefensa.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDefensa.anchor = GridBagConstraints.NORTH;
				gbc_txtDefensa.insets = new Insets(0, 0, 5, 5);
				gbc_txtDefensa.gridx = 2;
				gbc_txtDefensa.gridy = 3;
				panelCentral.add(txtDefensa, gbc_txtDefensa);
			}
			{
				JLabel label = new JLabel("(M\u00E1x. 20)");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.WEST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 3;
				gbc_label.gridy = 3;
				panelCentral.add(label, gbc_label);
			}
			{
				{
					JLabel label = new JLabel("Evasi\u00F3n");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.anchor = GridBagConstraints.EAST;
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridx = 1;
					gbc_label.gridy = 4;
					panelCentral.add(label, gbc_label);
				}
			}
			txtEvasion = new JTextField();
			txtEvasion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					calcularRestantes();
				}
			});
			txtEvasion.setColumns(10);
			GridBagConstraints gbc_txtEvasion = new GridBagConstraints();
			gbc_txtEvasion.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEvasion.anchor = GridBagConstraints.NORTH;
			gbc_txtEvasion.insets = new Insets(0, 0, 5, 5);
			gbc_txtEvasion.gridx = 2;
			gbc_txtEvasion.gridy = 4;
			panelCentral.add(txtEvasion, gbc_txtEvasion);
			{
				JLabel label = new JLabel("(Max. 80)");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.WEST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 3;
				gbc_label.gridy = 4;
				panelCentral.add(label, gbc_label);
			}
		}
	}
	

	public void guardar()
	{
		if(validar())
		{
			try {
				ctrlPers.guardar(this.mapearADatos());
				this.cerrar();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
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
		JOptionPane.showMessageDialog(this, error,"Error", JOptionPane.ERROR_MESSAGE);
		
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
		this.dispose();
	}
	
	public void showDialog()
	{
		setVisible(true);
	}
}
