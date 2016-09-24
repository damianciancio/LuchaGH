package desktop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import entities.Personaje;

import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import logic.PersonajeLogic;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Personajes {

	private PersonajeLogic ctrlPers;
	private JList listPersonajes;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personajes window = new Personajes();
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
	public Personajes() {
		initialize();
		
		ctrlPers=new PersonajeLogic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Refrescar();
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		

		JPanel panelDerecho = new JPanel();
		panelDerecho.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panelDerecho, BorderLayout.EAST);
		GridBagLayout gbl_panelDerecho = new GridBagLayout();
		gbl_panelDerecho.columnWidths = new int[]{69, 0};
		gbl_panelDerecho.rowHeights = new int[]{23, 23, 23, 28, 0};
		gbl_panelDerecho.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelDerecho.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDerecho.setLayout(gbl_panelDerecho);
		
		JButton btnElegir = new JButton("Elegir");
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.fill = GridBagConstraints.BOTH;
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 0;
		gbc_btnElegir.gridy = 0;
		panelDerecho.add(btnElegir, gbc_btnElegir);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAadir.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.fill = GridBagConstraints.BOTH;
		gbc_btnAadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnAadir.gridx = 0;
		gbc_btnAadir.gridy = 1;
		panelDerecho.add(btnAadir, gbc_btnAadir);
		
		JButton btnEditar = new JButton("Editar");
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.BOTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 2;
		panelDerecho.add(btnEditar, gbc_btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 3;
		panelDerecho.add(btnEliminar, gbc_btnEliminar);
		
		JScrollPane panelCentral = new JScrollPane();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		listPersonajes = new JList();
		
		panelCentral.setViewportView(listPersonajes);
	}
	
	private void Refrescar() {
		/*ArrayList<Personaje> _list = null;
		try
		{
			_list = ctrlPers.GetAll();
			for (int i = 0 ; i < _list.size() ; i++) {
				Personaje per = _list.get(i);
				
			}
			
			listPersonajes = new JList(_list.toArray());
		}*/
		try
		{
			DefaultListModel modelo = new DefaultListModel();
			ArrayList<Personaje> personajes = new PersonajeLogic().GetAll();
			
			for (Personaje personaje : personajes) {
				modelo.addElement(personaje);
			}
			listPersonajes.setModel(modelo);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
		
		
		
		
	}
}
