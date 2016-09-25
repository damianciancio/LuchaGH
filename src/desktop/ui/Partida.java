package desktop.ui;

import logic.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.Personaje;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Partida {
	
	Personaje tempPer;
	
	private JFrame frame;
	private JTextField txtVidaIzq;
	private JTextField txtVidaDer;
	private JTextField txtEneIzq;
	private JTextField txtEneDer;
	private JTextField txtPtsAtaque;
	private JRadioButton rdbtnDefender;
	private JRadioButton rdbtnAtacar;
	private PartidaLogic ctrlPartida;
	public Personaje p1;
	public Personaje p2;
	JLabel lblTurnoDe;
	JButton btnComenzar;
	JButton btnPersonajeIzq;
	JButton btnPersonajeDer;
	JButton btnListo;

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida window = new Partida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public Partida() {
		initialize();
		ctrlPartida = new PartidaLogic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlPersonajes = new JPanel();
		pnlPersonajes.setBorder(new EmptyBorder(10, 10, 0, 10));
		frame.getContentPane().add(pnlPersonajes, BorderLayout.NORTH);
		GridBagLayout gbl_pnlPersonajes = new GridBagLayout();
		gbl_pnlPersonajes.columnWidths = new int[] {41, 170, 41, 170};
		gbl_pnlPersonajes.rowHeights = new int[] {23, 15, 23, 23, 23};
		gbl_pnlPersonajes.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_pnlPersonajes.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0};
		pnlPersonajes.setLayout(gbl_pnlPersonajes);
		
		btnPersonajeIzq = new JButton("+");
		btnPersonajeIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirPersonaje1();
			}
		});
		btnPersonajeIzq.setMargin(new Insets(0, 5, 0, 5));
		btnPersonajeIzq.setPreferredSize(new Dimension(41, 20));
		btnPersonajeIzq.setSize(new Dimension(30, 20));
		GridBagConstraints gbc_btnPersonajeIzq = new GridBagConstraints();
		gbc_btnPersonajeIzq.insets = new Insets(0, 0, 5, 5);
		gbc_btnPersonajeIzq.gridx = 0;
		gbc_btnPersonajeIzq.gridy = 0;
		pnlPersonajes.add(btnPersonajeIzq, gbc_btnPersonajeIzq);
		
		JLabel lblPerIzq = new JLabel("Elija un Personaje");
		lblPerIzq.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPerIzq = new GridBagConstraints();
		gbc_lblPerIzq.anchor = GridBagConstraints.WEST;
		gbc_lblPerIzq.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerIzq.gridx = 1;
		gbc_lblPerIzq.gridy = 0;
		pnlPersonajes.add(lblPerIzq, gbc_lblPerIzq);
		
		btnPersonajeDer = new JButton("+");
		btnPersonajeDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirPersonaje2();
			}
		});
		btnPersonajeDer.setMargin(new Insets(0, 5, 0, 5));
		btnPersonajeDer.setPreferredSize(new Dimension(41, 20));
		btnPersonajeDer.setSize(new Dimension(30, 20));
		btnPersonajeDer.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnPersonajeDer = new GridBagConstraints();
		gbc_btnPersonajeDer.insets = new Insets(0, 0, 5, 5);
		gbc_btnPersonajeDer.gridx = 2;
		gbc_btnPersonajeDer.gridy = 0;
		pnlPersonajes.add(btnPersonajeDer, gbc_btnPersonajeDer);
		
		JLabel lblPerDer = new JLabel("Elija un Personaje");
		lblPerDer.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPerDer = new GridBagConstraints();
		gbc_lblPerDer.anchor = GridBagConstraints.WEST;
		gbc_lblPerDer.insets = new Insets(0, 0, 5, 0);
		gbc_lblPerDer.gridx = 3;
		gbc_lblPerDer.gridy = 0;
		pnlPersonajes.add(lblPerDer, gbc_lblPerDer);
		
		JLabel lblVidaIzq = new JLabel("Vida:");
		GridBagConstraints gbc_lblVidaIzq = new GridBagConstraints();
		gbc_lblVidaIzq.anchor = GridBagConstraints.EAST;
		gbc_lblVidaIzq.insets = new Insets(0, 0, 5, 5);
		gbc_lblVidaIzq.gridx = 0;
		gbc_lblVidaIzq.gridy = 2;
		pnlPersonajes.add(lblVidaIzq, gbc_lblVidaIzq);
		
		txtVidaIzq = new JTextField();
		txtVidaIzq.setMaximumSize(new Dimension(60, 20));
		txtVidaIzq.setMinimumSize(new Dimension(60, 20));
		txtVidaIzq.setEditable(false);
		GridBagConstraints gbc_txtVidaIzq = new GridBagConstraints();
		gbc_txtVidaIzq.anchor = GridBagConstraints.WEST;
		gbc_txtVidaIzq.insets = new Insets(0, 0, 5, 5);
		gbc_txtVidaIzq.gridx = 1;
		gbc_txtVidaIzq.gridy = 2;
		pnlPersonajes.add(txtVidaIzq, gbc_txtVidaIzq);
		txtVidaIzq.setColumns(10);
		
		JLabel lblVidaDer = new JLabel("Vida: ");
		GridBagConstraints gbc_lblVidaDer = new GridBagConstraints();
		gbc_lblVidaDer.anchor = GridBagConstraints.EAST;
		gbc_lblVidaDer.insets = new Insets(0, 0, 5, 5);
		gbc_lblVidaDer.gridx = 2;
		gbc_lblVidaDer.gridy = 2;
		pnlPersonajes.add(lblVidaDer, gbc_lblVidaDer);
		
		txtVidaDer = new JTextField();
		txtVidaDer.setMaximumSize(new Dimension(60, 20));
		txtVidaDer.setMinimumSize(new Dimension(60, 20));
		txtVidaDer.setEditable(false);
		GridBagConstraints gbc_txtVidaDer = new GridBagConstraints();
		gbc_txtVidaDer.anchor = GridBagConstraints.WEST;
		gbc_txtVidaDer.insets = new Insets(0, 0, 5, 0);
		gbc_txtVidaDer.gridx = 3;
		gbc_txtVidaDer.gridy = 2;
		pnlPersonajes.add(txtVidaDer, gbc_txtVidaDer);
		txtVidaDer.setColumns(10);
		
		JLabel lblEnerIzq = new JLabel("Ener.:");
		GridBagConstraints gbc_lblEnerIzq = new GridBagConstraints();
		gbc_lblEnerIzq.anchor = GridBagConstraints.EAST;
		gbc_lblEnerIzq.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnerIzq.gridx = 0;
		gbc_lblEnerIzq.gridy = 3;
		pnlPersonajes.add(lblEnerIzq, gbc_lblEnerIzq);
		
		txtEneIzq = new JTextField();
		txtEneIzq.setMinimumSize(new Dimension(60, 20));
		txtEneIzq.setMaximumSize(new Dimension(60, 20));
		txtEneIzq.setEditable(false);
		GridBagConstraints gbc_txtEneIzq = new GridBagConstraints();
		gbc_txtEneIzq.anchor = GridBagConstraints.WEST;
		gbc_txtEneIzq.insets = new Insets(0, 0, 5, 5);
		gbc_txtEneIzq.gridx = 1;
		gbc_txtEneIzq.gridy = 3;
		pnlPersonajes.add(txtEneIzq, gbc_txtEneIzq);
		txtEneIzq.setColumns(10);
		
		JLabel lblEnerDer = new JLabel("Ener.:");
		GridBagConstraints gbc_lblEnerDer = new GridBagConstraints();
		gbc_lblEnerDer.anchor = GridBagConstraints.EAST;
		gbc_lblEnerDer.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnerDer.gridx = 2;
		gbc_lblEnerDer.gridy = 3;
		pnlPersonajes.add(lblEnerDer, gbc_lblEnerDer);
		
		txtEneDer = new JTextField();
		txtEneDer.setMaximumSize(new Dimension(60, 20));
		txtEneDer.setMinimumSize(new Dimension(60, 20));
		txtEneDer.setEditable(false);
		GridBagConstraints gbc_txtEneDer = new GridBagConstraints();
		gbc_txtEneDer.insets = new Insets(0, 0, 5, 0);
		gbc_txtEneDer.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtEneDer.gridx = 3;
		gbc_txtEneDer.gridy = 3;
		pnlPersonajes.add(txtEneDer, gbc_txtEneDer);
		txtEneDer.setColumns(10);
		
		btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzar();
			}
		});
		GridBagConstraints gbc_btnComenzar = new GridBagConstraints();
		gbc_btnComenzar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnComenzar.insets = new Insets(0, 0, 5, 0);
		gbc_btnComenzar.gridwidth = 4;
		gbc_btnComenzar.gridx = 0;
		gbc_btnComenzar.gridy = 4;
		pnlPersonajes.add(btnComenzar, gbc_btnComenzar);

		JPanel pnlComenzar = new JPanel();
		pnlComenzar.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlComenzar.setAlignmentY(Component.TOP_ALIGNMENT);
		pnlComenzar.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(pnlComenzar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlComenzar = new GridBagLayout();
		gbl_pnlComenzar.columnWidths = new int[] {80, 125, 60, 200};
		gbl_pnlComenzar.rowHeights = new int[] {40, 23, 23};
		gbl_pnlComenzar.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_pnlComenzar.rowWeights = new double[]{0.0};
		pnlComenzar.setLayout(gbl_pnlComenzar);
		
		JLabel lblTurno = new JLabel("Turno: ");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTurno = new GridBagConstraints();
		gbc_lblTurno.gridwidth = 3;
		gbc_lblTurno.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurno.gridx = 0;
		gbc_lblTurno.gridy = 0;
		pnlComenzar.add(lblTurno, gbc_lblTurno);
		
		JLabel lblTurnoDe = new JLabel("");
		lblTurnoDe.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblTurnoDe = new GridBagConstraints();
		gbc_lblTurnoDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblTurnoDe.gridx = 3;
		gbc_lblTurnoDe.gridy = 0;
		pnlComenzar.add(lblTurnoDe, gbc_lblTurnoDe);
		
		rdbtnDefender = new JRadioButton("Defender");
		GridBagConstraints gbc_rdbtnDefender = new GridBagConstraints();
		gbc_rdbtnDefender.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDefender.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDefender.gridx = 0;
		gbc_rdbtnDefender.gridy = 1;
		pnlComenzar.add(rdbtnDefender, gbc_rdbtnDefender);
		
		btnListo = new JButton("Listo!");
		btnListo.setEnabled(false);
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actuar();
			}
		});
		GridBagConstraints gbc_btnListo = new GridBagConstraints();
		gbc_btnListo.gridheight = 2;
		gbc_btnListo.fill = GridBagConstraints.VERTICAL;
		gbc_btnListo.insets = new Insets(0, 0, 0, 5);
		gbc_btnListo.gridx = 2;
		gbc_btnListo.gridy = 1;
		pnlComenzar.add(btnListo, gbc_btnListo);
		
		rdbtnAtacar = new JRadioButton("Atacar");
		GridBagConstraints gbc_rdbtnAtacar = new GridBagConstraints();
		gbc_rdbtnAtacar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAtacar.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnAtacar.gridx = 0;
		gbc_rdbtnAtacar.gridy = 2;
		pnlComenzar.add(rdbtnAtacar, gbc_rdbtnAtacar);
		
		txtPtsAtaque = new JTextField();
		txtPtsAtaque.setMaximumSize(new Dimension(45, 20));
		txtPtsAtaque.setMinimumSize(new Dimension(45, 20));
		GridBagConstraints gbc_txtPtsAtaque = new GridBagConstraints();
		gbc_txtPtsAtaque.anchor = GridBagConstraints.WEST;
		gbc_txtPtsAtaque.insets = new Insets(0, 0, 0, 5);
		gbc_txtPtsAtaque.gridx = 1;
		gbc_txtPtsAtaque.gridy = 2;
		pnlComenzar.add(txtPtsAtaque, gbc_txtPtsAtaque);
		txtPtsAtaque.setColumns(10); 
	}
	
	private void elegirPersonaje1()
	{
		elegirPersonaje();
		p1 = tempPer;
	}
	private void elegirPersonaje2()
	{
		elegirPersonaje();
		p2 = tempPer;
	}
	private void comenzar()
	{
		try {
			ctrlPartida.comenzarPelea(p1, p2);
			btnComenzar.setEnabled(false);
			btnPersonajeDer.setEnabled(false);
			btnPersonajeIzq.setEnabled(false);
			
			String turno = ctrlPartida.getTurnoDe().getP().getNombre();
			lblTurnoDe.setText("Turno de: " + turno);
			btnListo.setEnabled(true);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		}
	}
	private void actuar()
	{
		//Esta linea tiene que ser reemplazada por algo que tenga sentido
		//Con los radiobutton. Además hay que agregarle un radio button gropup
		boolean atacar = true;
		
		if (atacar) {
			try {
				int ptosAtaque = Integer.parseInt(txtPtsAtaque.getText());
				
				ctrlPartida.atacar(ptosAtaque);
				
			}
			catch(NumberFormatException nfex){
				JOptionPane.showMessageDialog(this.frame, "Ingrese un numero entero en los puntos de ataque.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this.frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else {
			ctrlPartida.defender();
		}
		
		Refrescar();
	}
	
	private void elegirPersonaje() {
		Personajes pj = new Personajes();
		pj.getFrame().addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				tempPer = pj.getPersonaje();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		pj.getFrame().setVisible(true);
	}

	private void Refrescar() {

		String vidaIzq = String.valueOf(ctrlPartida.getP1().getVidaActual());
		String enerIzq = String.valueOf(ctrlPartida.getP1().getEnergiaActual());
		String vidaDer = String.valueOf(ctrlPartida.getP2().getVidaActual());
		String enerDer = String.valueOf(ctrlPartida.getP2().getEnergiaActual());
		
		txtVidaIzq.setText(vidaIzq);
		txtVidaDer.setText(vidaDer);
		txtEneIzq.setText(enerIzq);
		txtEneDer.setText(enerDer);
		
		String turnoDe = ctrlPartida.getTurnoDe().getP().getNombre();
		lblTurnoDe.setText("Turno de " + turnoDe);
		
		// TODO Limpiar los radioButtons
	}
}
