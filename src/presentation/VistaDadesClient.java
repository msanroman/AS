package presentation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

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

	private VistaInicial vistaInicial;
	private JTextField textField;
	private JTextField textFieldDataAny;
	private JTextField textFieldDataMes;
	private JTextField textFieldDataDia;

	/**
	 * Create the panel.
	 */
	public VistaDadesClient(VistaInicial vistaInicial) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.vistaInicial = vistaInicial;

		Component verticalStrut = Box.createVerticalStrut(10);
		add(verticalStrut);

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JLabel lblNumTarjetaTag = new JLabel("Número de tarjeta:  ");
		horizontalBox.add(lblNumTarjetaTag);

		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		textField.setMaximumSize(new Dimension(200, 20));

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		textField.addKeyListener(new TextFieldChangeListener());

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JLabel lblDataCad = new JLabel("Data de caducitat:   ");
		horizontalBox_1.add(lblDataCad);

		textFieldDataAny = new JTextField();
		horizontalBox_1.add(textFieldDataAny);
		textFieldDataAny.setMaximumSize(new Dimension(200, 20));
		textFieldDataAny.setColumns(10);
		textFieldDataAny.addKeyListener(new TextFieldChangeListener());
		textFieldDataAny.addKeyListener(new TextFieldDigitListener());

		JLabel label = new JLabel("/");
		horizontalBox_1.add(label);

		textFieldDataMes = new JTextField();
		horizontalBox_1.add(textFieldDataMes);
		textFieldDataMes.setColumns(10);
		textFieldDataMes.setMaximumSize(new Dimension(200, 20));
		textFieldDataMes.addKeyListener(new TextFieldChangeListener());
		textFieldDataMes.addKeyListener(new TextFieldDigitListener());

		JLabel label_1 = new JLabel("/");
		horizontalBox_1.add(label_1);

		textFieldDataDia = new JTextField();
		horizontalBox_1.add(textFieldDataDia);
		textFieldDataDia.setMaximumSize(new Dimension(200, 20));
		textFieldDataDia.setColumns(10);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		textFieldDataDia.addKeyListener(new TextFieldChangeListener());
		textFieldDataDia.addKeyListener(new TextFieldDigitListener());
	}

	public String getNumTarg() {
		return textField.getText();
	}

	public Date getDataCaducitat() {
		return new Date(Integer.parseInt(textFieldDataAny.getText()),
				Integer.parseInt(textFieldDataMes.getText()),
				Integer.parseInt(textFieldDataDia.getText()));
	}

	class TextFieldChangeListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if (textField.getText().length() > 0
					&& textFieldDataAny.getText().length() > 0
					&& textFieldDataMes.getText().length() > 0
					&& textFieldDataDia.getText().length() > 0) {
				vistaInicial.habilitarOk(true);
			} else
				vistaInicial.habilitarOk(false);
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
		}
	}
}
