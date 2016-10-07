package desktop.ui;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import entities.Entidad;
import entities.Personaje;
import logic.PersonajeLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogPersonajes extends JDialog {
	
	private Personaje personajeActual;
	private PersonajeLogic ctrlPers;
	private JList<Personaje> listPersonajes;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public DialogPersonajes() {
		
		inicializar();
		
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel, BorderLayout.EAST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{69, 0};
			gbl_panel.rowHeights = new int[]{23, 23, 23, 28, 0};
			gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JButton button = new JButton("Elegir");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						elegir();
					}
				});
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.fill = GridBagConstraints.BOTH;
				gbc_button.insets = new Insets(0, 0, 5, 0);
				gbc_button.gridx = 0;
				gbc_button.gridy = 0;
				panel.add(button, gbc_button);
			}
			{
				JButton button = new JButton("A\u00F1adir");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addPersonaje();
					}
				});
				button.setAlignmentY(1.0f);
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.fill = GridBagConstraints.BOTH;
				gbc_button.insets = new Insets(0, 0, 5, 0);
				gbc_button.gridx = 0;
				gbc_button.gridy = 1;
				panel.add(button, gbc_button);
			}
			{
				JButton button = new JButton("Editar");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						editPersonaje();
						
					}
				});
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.fill = GridBagConstraints.BOTH;
				gbc_button.insets = new Insets(0, 0, 5, 0);
				gbc_button.gridx = 0;
				gbc_button.gridy = 2;
				panel.add(button, gbc_button);
			}
			{
				JButton button = new JButton("Eliminar");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deletePersonaje();
					}
				});
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.fill = GridBagConstraints.BOTH;
				gbc_button.gridx = 0;
				gbc_button.gridy = 3;
				panel.add(button, gbc_button);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				listPersonajes = new JList<Personaje>();
				scrollPane.setViewportView(listPersonajes);
			}
		}

		refrescar();
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
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void elegir() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(this, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		personajeActual = (Personaje)listPersonajes.getSelectedValue();
		
		this.setVisible(false);
		this.dispose();
	}
	
	private void addPersonaje() {
		new DialogPersonajesDesktop().showDialog();

		refrescar();
	}
	private void editPersonaje() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(this, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		Personaje per = (Personaje)listPersonajes.getSelectedValue();
		per.setEstData(Entidad.estadoData.Modified);
		
		//Creo la ventana de edición
		DialogPersonajesDesktop dper = new DialogPersonajesDesktop();
		dper.mapearDeDatos(per);
		dper.showDialog();
		
		//Se refresca la lista
		refrescar();
	}
	private void deletePersonaje() {
		//Valido que se haya elegido a alguien
		if (listPersonajes.isSelectionEmpty()){
			JOptionPane.showMessageDialog(this, "Elija un personaje");
			return;
		}
		
		//Capturo el personaje seleccionado y le asigno el estaod modificado
		Personaje per = (Personaje)listPersonajes.getSelectedValue();
		String msj = "Está seguro que desea eliminar a " + per.getNombre() + "?";
		
		int response = JOptionPane.showConfirmDialog(this, msj, "Eliminar Personaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION) {

			try
			{
				per.setEstData(Entidad.estadoData.Deleted);
				ctrlPers.guardar(per);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		}
		
		refrescar();
	}
	
	public Personaje getPersonaje() {
		return personajeActual;
	}
	
	public Personaje showDialog()
	{
		setVisible(true);
		return personajeActual;
	}
	
	public void inicializar()
	{
		ctrlPers = new PersonajeLogic();
		personajeActual = null;
	}

}
