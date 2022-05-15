package pruebaSwing;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class HolaMundoSwing extends JFrame implements ActionListener{
	private JButton btnHolaMundo;
	private JPanel panelPrincipal;
	private int contador = 0;
	private JLabel lblIncremental;
	private JButton botonincremento10;
	private JCheckBox checkboxBotones;
	
	public static void main(String[] args) {
		HolaMundoSwing ventana = new HolaMundoSwing();
		ventana.setVisible(true);
	}
	public HolaMundoSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		btnHolaMundo = new JButton("Hola Mundo");
		panelPrincipal.add(btnHolaMundo, BorderLayout.SOUTH);
		
		/*btnHolaMundo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola Mundo!");
			}
		});*/
		/*btnHolaMundo.addActionListener(e -> {
				System.out.println("Hola Mundo!");});*/
		btnHolaMundo.addActionListener(this); 
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height - 200;
		int width = toolkit.getScreenSize().width - 200;
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		
		setContentPane(panelPrincipal);
		
		lblIncremental = new JLabel("Contador :" + contador);
		lblIncremental.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(lblIncremental, BorderLayout.CENTER);
		
		botonincremento10 = new JButton("incrementar 10");
		panelPrincipal.add(botonincremento10, BorderLayout.NORTH);
		
		checkboxBotones = new JCheckBox("Activar botones");
		checkboxBotones.setSelected(true);
		panelPrincipal.add(checkboxBotones, BorderLayout.WEST);
		
		checkboxBotones.addActionListener(this);
		setVisible(true);
	}
	public void gestionarPulsacionBotonIncrementar() {
		contador++;
		//escribo en el label el valor del contador
		lblIncremental.setText("Contador :" + contador);
		
		System.out.println(contador);
		if (contador % 2 == 0) {
			panelPrincipal.setBackground(Color.GREEN);
			btnHolaMundo.setForeground(Color.red);
		} else {
			panelPrincipal.setBackground(Color.YELLOW);
		}
	}
	public void gestionarActivacionBotones() {
		if (checkboxBotones.isEnabled()) {
			lblIncremental.setEnabled(true);
			botonincremento10.setEnabled(true);
		} else {
			lblIncremental.setEnabled(false);
			botonincremento10.setEnabled(false);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}