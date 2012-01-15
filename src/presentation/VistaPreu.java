package presentation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaPreu extends JPanel {

	private static final long serialVersionUID = 1L;
	private VistaInicial vistaInicial;
	private JTextField textField;

	public VistaPreu(VistaInicial vistaInicial) {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.vistaInicial = vistaInicial;

		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);

		JLabel lblNewLabel = new JLabel("DNI:   ");
		horizontalBox.add(lblNewLabel);

		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		textField.setMaximumSize(new Dimension(200, 20));
		textField.addKeyListener(new TextFieldChangeListener());

		Component horizontalGlue2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue2);
	}

	public String getDni() {
		return textField.getText();
	}

	class TextFieldChangeListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if (textField.getText().length() > 0) {
				vistaInicial.habilitarOk(true);
			} else
				vistaInicial.habilitarOk(false);
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
		}
	}
}
