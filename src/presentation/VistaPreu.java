package presentation;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class VistaPreu extends JPanel {
	
	private JTextField textField;
	private String dni;

	/**
	 * Create the panel.
	 */
	public VistaPreu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		textField.setMaximumSize(new Dimension(200, 20));
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField aux = (JTextField) arg0.getSource();
				dni = aux.getText();
			}
		});

		Component horizontalGlue2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue2);
	}

	public String getDni() {
		return dni;
	}

}
