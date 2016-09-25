package desktop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import entities.Entidad;
import entities.Personaje;

import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import logic.PersonajeLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Personajes {

	private Personaje personajeActual;
	private PersonajeLogic ctrlPers;
	private JList<Personaje> listPersonajes;
	private JFrame frame;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 
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
		refrescar();
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				refrescar();
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
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Elegir();
			}
		});
		GridBagConstraints gbc_btnElegir = new GridBagConstraints();
		gbc_btnElegir.fill = GridBagConstraints.BOTH;
		gbc_btnElegir.insets = new Insets(0, 0, 5, 0);
		gbc_btnElegir.gridx = 0;
		gbc_btnElegir.gridy = 0;
		panelDerecho.add(btnElegir, gbc_btnElegir);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPersonaje();
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
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditPersonaje();
			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.BOTH;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditar.gridx = 0;
		gbc_btnEditar.gridy = 2;
		panelDerecho.add(btnEditar, gbc_btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeletePersonaje();
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 3;
		panelDerecho.add(btnEliminar, gbc_btnEliminar);
		
		JScrollPane panelCentral = new JScrollPane();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		listPersonajes = new JList<Personaje>();
		
		panelCentral.setViewportView(listPersonajes);
	}
	
	private void refrescar() {
		try
		{
			DefaultListModel<Personaje> modelo = new DefaultListModel<Personaje>();
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
	
	private void Elegir() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(frame, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		personajeActual = (Personaje)listPersonajes.getSelectedValue();
		
		this.frame.setVisible(false);;
	}
	
	private void AddPersonaje() {
		PersonajeDesktop pj = new PersonajeDesktop();
		JFrame pjFrame = pj.getFrame();
		
		
		//JDialog pjDialog = new JDialog(this.frame, "asd", true);
		//pjDialog.add(pjFrame);
		//pjDialog.pack();
		//pjDialog.setModal(true);
		//pjDialog.setVisible(true);
		
		pjFrame.setVisible(true);
		
		refrescar();
	}
	private void EditPersonaje() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(frame, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		Personaje per = (Personaje)listPersonajes.getSelectedValue();
		per.setEstData(Entidad.estadoData.Modified);
		
		//Creo la ventana de edición
		PersonajeDesktop pj = new PersonajeDesktop();
		JFrame pjFrame = pj.getFrame();
		pj.mapearDeDatos(per);
		
		//Esto es a corregir. Hay que hacerlo modal
		pjFrame.setVisible(true);
		
		//Se refresca la lista
		refrescar();
	}
	private void DeletePersonaje() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(frame, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		Personaje per = (Personaje)listPersonajes.getSelectedValue();
		String msj = "Está seguro que desea eliminar a " + per.getNombre() + "?";
		
		int response = JOptionPane.showConfirmDialog(frame, msj, "Eliminar Personaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION) {

			try
			{
				per.setEstData(Entidad.estadoData.Deleted);
				ctrlPers.guardar(per);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, ex.getMessage());
			}
		}
		
		refrescar();
	}
	
	public Personaje getPersonaje() {
		return personajeActual;
	}
}
