package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaMissatgeFiOk extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ReservarHabitacioController reservarHabitacioController;

	/**
	 * Create the frame.
	 */
	public VistaMissatgeFiOk(ReservarHabitacioController _reservarHabitacioController) {
		
		this.reservarHabitacioController = _reservarHabitacioController;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnOk = new JButton("Ok");
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservarHabitacioController.prOkMissatgeReservaOk();
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue_1);
		
		JLabel lblNewLabel = new JLabel("El pagament s'ha realitzat correctament");
		panel_1.add(lblNewLabel);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue);
		setVisible(true);
	}

	public void tancar() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
