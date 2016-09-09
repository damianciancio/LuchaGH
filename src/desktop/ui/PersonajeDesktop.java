package desktop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonajeDesktop {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNombreusuario;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtPtsrest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonajeDesktop window = new PersonajeDesktop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonajeDesktop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		panelInf.setBorder(new EmptyBorder(5, 75, 5, 5));
		frame.getContentPane().add(panelInf, BorderLayout.SOUTH);
		panelInf.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		panelInf.add(btnGuardar);
		
		JButton btnReset = new JButton("Reset");
		panelInf.add(btnReset);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelInf.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 0, 10, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{17, 92, 81, 0};
		gbl_panel.rowHeights = new int[]{20, 14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 0;
		panel.add(lblID, gbc_lblID);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridx = 2;
		gbc_txtId.gridy = 0;
		panel.add(txtId, gbc_txtId);
		
		JLabel lblNombreusuario = new JLabel("Nombre de Usuario");
		GridBagConstraints gbc_lblNombreusuario = new GridBagConstraints();
		gbc_lblNombreusuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombreusuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombreusuario.gridx = 1;
		gbc_lblNombreusuario.gridy = 1;
		panel.add(lblNombreusuario, gbc_lblNombreusuario);
		
		txtNombreusuario = new JTextField();
		GridBagConstraints gbc_txtNombreusuario = new GridBagConstraints();
		gbc_txtNombreusuario.anchor = GridBagConstraints.WEST;
		gbc_txtNombreusuario.gridx = 2;
		gbc_txtNombreusuario.gridy = 1;
		panel.add(txtNombreusuario, gbc_txtNombreusuario);
		txtNombreusuario.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][91.00][62.00,grow]", "[][][][]"));
		
		JLabel lblVida = new JLabel("Vida");
		panel_1.add(lblVida, "cell 0 0,alignx trailing");
		
		txtVida = new JTextField();
		panel_1.add(txtVida, "cell 1 0,growx");
		txtVida.setColumns(10);
		
		JLabel lblPtsRestantes = new JLabel("Pts. Restantes");
		panel_1.add(lblPtsRestantes, "cell 2 0,alignx trailing");
		
		txtPtsrest = new JTextField();
		txtPtsrest.setEnabled(false);
		panel_1.add(txtPtsrest, "cell 3 0,growx");
		txtPtsrest.setColumns(10);
		
		JLabel lblEnerga = new JLabel("Energ\u00EDa");
		panel_1.add(lblEnerga, "cell 0 1,alignx trailing");
		
		txtEnergia = new JTextField();
		panel_1.add(txtEnergia, "cell 1 1,growx");
		txtEnergia.setColumns(10);
		
		JLabel lblDefensa = new JLabel("Defensa");
		panel_1.add(lblDefensa, "cell 0 2,alignx trailing");
		
		txtDefensa = new JTextField();
		panel_1.add(txtDefensa, "cell 1 2,growx");
		txtDefensa.setColumns(10);
		
		JLabel lblMaxdef = new JLabel("(M\u00E1x. 20)");
		panel_1.add(lblMaxdef, "cell 2 2");
		
		JLabel lblEvasin = new JLabel("Evasi\u00F3n");
		panel_1.add(lblEvasin, "cell 0 3,alignx trailing");
		
		txtEvasion = new JTextField();
		panel_1.add(txtEvasion, "cell 1 3,growx");
		txtEvasion.setColumns(10);
		
		JLabel lblMaxevasion = new JLabel("(Max. 80)");
		panel_1.add(lblMaxevasion, "cell 2 3");
	}
	
	public void guardar()
	{
		if(validar())
		{
			int i = 9;
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
}

