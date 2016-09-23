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
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;

public class Personajes {

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new EmptyBorder(5, 5, 5, 0));
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JList listPersonas = new JList();
		listPersonas.setBounds(6, 6, 319, 254);
		listPersonas.setMaximumSize(new Dimension(5000, 5000));
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setModel(new AbstractListModel() {
			String[] values = new String[] {"ele1", "ele2", "ele3", "ele1", "ele2", "ele3", "ele1", "ele2", "ele3", "ele1", "ele2", "ele3", "ele1", "ele2", "ele3", "ele1", "ele2", "ele3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelCentral.add(listPersonas);
		
		JScrollBar scrPersonas = new JScrollBar();
		scrPersonas.setBounds(337, 6, 15, 204);
		panelCentral.add(scrPersonas);

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
	}

}
