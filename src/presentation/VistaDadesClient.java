package presentation;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaDadesClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public VistaDadesClient() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JLabel lblNumTarjetaTag = new JLabel("Número de tarjeta:");
		horizontalBox.add(lblNumTarjetaTag);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		textField.setMaximumSize(new Dimension(200, 25));
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		add(horizontalBox_1);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);
		
		JLabel lblDataCad = new JLabel("Data de caducitat");
		horizontalBox_1.add(lblDataCad);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_4);
		
		textField_1 = new JTextField();
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setMaximumSize(new Dimension(200, 25));
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_5);
	}
}
