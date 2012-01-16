package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tupleTypes.HotelAmbHabitacions;

public class VistaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMessageArea = new JLabel();
	private CardLayout card = new CardLayout();

	private VistaHotelsTipusHab vistaHotelsTipusHab;
	private VistaPreu vistaPreu;
	private VistaDadesClient vistaDadesClient;

	private static final int FIRST = 0;
	private static final int HOTELS = 1;
	private static final int PREU = 2;
	private static final int CLIENT = 3;

	private ReservarHabitacioController reservarHabitacioController;

	private int state = 0;
	private JPanel panelCard;
	private Box verticalBoxLbl;
	private JTextField textFieldPoblacio;
	private JTextField textFieldDataIniciDia;
	private JTextField textFieldDataIniciMes;
	private JTextField textFieldDataIniciAny;
	private JTextField textFieldDataFiDia;
	private JTextField textFieldDataFiMes;
	private JTextField textFieldDataFiAny;
	private JTextField textFieldNumOcupants;
	private JButton btnOk;

	public VistaInicial(ReservarHabitacioController _reservarHabitacioController) {

		this.setVisible(true);

		this.reservarHabitacioController = _reservarHabitacioController;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// South panel

		Box verticalBox_1 = Box.createVerticalBox();
		contentPane.add(verticalBox_1, BorderLayout.SOUTH);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_6);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue_5);

		lblMessageArea = new JLabel("");
		horizontalBox_6.add(lblMessageArea);
		lblMessageArea.setHorizontalAlignment(SwingConstants.CENTER);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue_1);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_3);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_2);

		btnOk = new JButton("Ok");
		horizontalBox_4.add(btnOk);

		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// TODO
				switch (state) {
				case FIRST:
					Calendar calendarInici = Calendar.getInstance();
					calendarInici.set(Calendar.DAY_OF_MONTH,
							Integer.parseInt(textFieldDataIniciDia.getText()));
					calendarInici.set(Calendar.MONTH,
							Integer.parseInt(textFieldDataIniciMes.getText()));
					calendarInici.set(Calendar.YEAR,
							Integer.parseInt(textFieldDataIniciAny.getText()));

					Calendar calendarFi = Calendar.getInstance();
					calendarFi.set(Calendar.DAY_OF_MONTH,
							Integer.parseInt(textFieldDataFiDia.getText()));
					calendarFi.set(Calendar.MONTH,
							Integer.parseInt(textFieldDataFiMes.getText()));
					calendarFi.set(Calendar.YEAR,
							Integer.parseInt(textFieldDataFiAny.getText()));

					Date dataInici = calendarInici.getTime();
					Date dataFi = calendarFi.getTime();

					reservarHabitacioController.prOkBuscarHabitacio(
							textFieldPoblacio.getText(),
							Integer.parseInt(textFieldNumOcupants.getText()),
							dataInici, dataFi);
					break;
				case HOTELS:
					reservarHabitacioController.prOkObtePreu(
							vistaHotelsTipusHab.getHotelSeleccionat(),
							vistaHotelsTipusHab.getHabitacioSeleccionada());
					break;
				case PREU:
					reservarHabitacioController.prOkObteDadesClient(vistaPreu
							.getDni());
					break;
				case CLIENT:
					reservarHabitacioController.prOkPaga(
							vistaDadesClient.getNumTarg(),
							vistaDadesClient.getDataCaducitat());
					break;
				}
			}
		});

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_4);

		JButton btnCancel_1 = new JButton("Cancel");
		horizontalBox_4.add(btnCancel_1);

		btnCancel_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservarHabitacioController.prCancel();
			}
		});

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_3);

		// South end

		// Center
		Box verticalBox_2 = Box.createVerticalBox();
		contentPane.add(verticalBox_2, BorderLayout.CENTER);

		// First panel
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_2.add(verticalStrut_2);

		Box verticalBox = Box.createVerticalBox();

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JLabel lblPoblacio = new JLabel("Poblacio:");
		horizontalBox.add(lblPoblacio);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);

		textFieldPoblacio = new JTextField();
		textFieldPoblacio.setColumns(10);
		horizontalBox.add(textFieldPoblacio);
		textFieldPoblacio.addKeyListener(new TextFieldChangeListener());

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_4);

		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JLabel lblDataInici = new JLabel("Data inici:");
		horizontalBox_1.add(lblDataInici);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);

		textFieldDataIniciDia = new JTextField();
		horizontalBox_1.add(textFieldDataIniciDia);
		textFieldDataIniciDia.setColumns(10);
		textFieldDataIniciDia.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataIniciDia.addKeyListener(new TextFieldDigitListener());

		JLabel label_2 = new JLabel("/");
		horizontalBox_1.add(label_2);

		textFieldDataIniciMes = new JTextField();
		horizontalBox_1.add(textFieldDataIniciMes);
		textFieldDataIniciMes.setColumns(10);
		textFieldDataIniciMes.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataIniciMes.addKeyListener(new TextFieldDigitListener());

		JLabel label_3 = new JLabel("/");
		horizontalBox_1.add(label_3);

		textFieldDataIniciAny = new JTextField();
		horizontalBox_1.add(textFieldDataIniciAny);
		textFieldDataIniciAny.setColumns(10);
		textFieldDataIniciAny.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataIniciAny.addKeyListener(new TextFieldDigitListener());

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_5);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue);

		JLabel lblNewLabel = new JLabel("dd/mm/yy");
		horizontalBox_5.add(lblNewLabel);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		JLabel lblDataFi = new JLabel("Data fi:");
		horizontalBox_2.add(lblDataFi);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut);

		textFieldDataFiDia = new JTextField();
		horizontalBox_2.add(textFieldDataFiDia);
		textFieldDataFiDia.setColumns(10);
		textFieldDataFiDia.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataFiDia.addKeyListener(new TextFieldDigitListener());

		JLabel label = new JLabel("/");
		horizontalBox_2.add(label);

		textFieldDataFiMes = new JTextField();
		horizontalBox_2.add(textFieldDataFiMes);
		textFieldDataFiMes.setColumns(10);
		textFieldDataFiMes.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataFiMes.addKeyListener(new TextFieldDigitListener());

		JLabel label_1 = new JLabel("/");
		horizontalBox_2.add(label_1);

		textFieldDataFiAny = new JTextField();
		horizontalBox_2.add(textFieldDataFiAny);
		textFieldDataFiAny.setColumns(10);
		textFieldDataFiAny.addKeyListener(new TextFieldDateChangeListener());
		textFieldDataFiAny.addKeyListener(new TextFieldDigitListener());

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_6);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_1);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		JLabel lblNumOcupants = new JLabel("Número d'ocupants");
		horizontalBox_3.add(lblNumOcupants);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_3);

		textFieldNumOcupants = new JTextField();
		horizontalBox_3.add(textFieldNumOcupants);
		textFieldNumOcupants.setColumns(10);
		textFieldNumOcupants.addKeyListener(new TextFieldChangeListener());
		textFieldNumOcupants.addKeyListener(new TextFieldDigitListener());

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_7);

		JPanel firstPanel = new JPanel();
		firstPanel.add(verticalBox);

		// First end

		panelCard = new JPanel();
		verticalBox_2.add(panelCard);

		panelCard.setLayout(card);

		panelCard.add(firstPanel, "first");

		vistaPreu = new VistaPreu(this);
		panelCard.add(vistaPreu, "preu");

		vistaDadesClient = new VistaDadesClient(this);
		panelCard.add(vistaDadesClient, "client");

		card.show(panelCard, "first");

		state = FIRST;

		habilitarOk(false);
	}

	public void mostraMissatge(String missatge) {
		lblMessageArea.setText(missatge);
		lblMessageArea.setVisible(true);
	}

	public void mostraHotelsTipusHab(
			ArrayList<HotelAmbHabitacions> informacioHotels) {

		mostraMissatge("");
		vistaHotelsTipusHab = new VistaHotelsTipusHab(informacioHotels);
		panelCard.add(vistaHotelsTipusHab, "hotels");

		verticalBoxLbl = Box.createVerticalBox();

		Box horizontalBox = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox);

		JLabel lblPoblacioTag = new JLabel("Poblacio:");
		horizontalBox.add(lblPoblacioTag);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);

		JLabel lblPoblacio = new JLabel(textFieldPoblacio.getText());
		horizontalBox.add(lblPoblacio);

		Component horizontalGlue_8 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_8);

		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_1);

		JLabel lblDataInici = new JLabel("Data inici:");
		horizontalBox_1.add(lblDataInici);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);

		JLabel label_2 = new JLabel(textFieldDataIniciDia.getText() + " / "
				+ textFieldDataIniciMes.getText() + " / "
				+ textFieldDataIniciAny.getText());
		horizontalBox_1.add(label_2);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_5);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_2);

		JLabel lblDataFiTag = new JLabel("Data fi:");
		horizontalBox_2.add(lblDataFiTag);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);

		JLabel lblDataFi = new JLabel(textFieldDataFiDia.getText() + " / "
				+ textFieldDataFiMes.getText() + " / "
				+ textFieldDataFiAny.getText());
		horizontalBox_2.add(lblDataFi);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_6);

		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_3);

		JLabel lblNumOcupantsTag = new JLabel("Número d'ocupants");
		horizontalBox_3.add(lblNumOcupantsTag);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4);

		JLabel lblNumOcupants = new JLabel(textFieldNumOcupants.getText());
		horizontalBox_3.add(lblNumOcupants);

		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_7);

		contentPane.add(verticalBoxLbl, BorderLayout.NORTH);

		card.show(panelCard, "hotels");

		state = HOTELS;
	}

	public void mostraPreu(float preu) {

		mostraMissatge("");

		habilitarOk(false);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBoxLbl.add(verticalStrut_1);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox);

		JLabel lblHotelTag = new JLabel("Hotel:");
		horizontalBox.add(lblHotelTag);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		JLabel lblHotel = new JLabel(vistaHotelsTipusHab.getHotelSeleccionat());
		horizontalBox.add(lblHotel);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);

		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_2);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_1);

		JLabel lblHabitacioTag = new JLabel("Tipus d'habitació:");
		horizontalBox_1.add(lblHabitacioTag);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);

		JLabel lblHabitacio = new JLabel(
				vistaHotelsTipusHab.getHabitacioSeleccionada());
		horizontalBox_1.add(lblHabitacio);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);

		Component verticalStrut_3 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_3);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_4);

		JLabel lblPreuTag = new JLabel("Preu:");
		horizontalBox_4.add(lblPreuTag);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_5);

		JLabel lblPreu = new JLabel(String.valueOf(preu));
		horizontalBox_4.add(lblPreu);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_6);

		card.show(panelCard, "preu");

		state = PREU;
	}

	public void mostraDadesClient(String nom, String cognoms, String mail) {

		mostraMissatge("");

		habilitarOk(false);
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBoxLbl.add(verticalStrut_1);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox);

		JLabel lblNomTag = new JLabel("Nom:");
		horizontalBox.add(lblNomTag);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		JLabel lblNom = new JLabel(nom);
		horizontalBox.add(lblNom);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);

		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_2);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_1);

		JLabel lblCognomTag = new JLabel("Cognoms:");
		horizontalBox_1.add(lblCognomTag);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);

		JLabel lblCognom = new JLabel(cognoms);
		horizontalBox_1.add(lblCognom);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);

		Component verticalStrut_3 = Box.createVerticalStrut(10);
		verticalBoxLbl.add(verticalStrut_3);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBoxLbl.add(horizontalBox_2);

		JLabel lblMailTag = new JLabel("Email:");
		horizontalBox_2.add(lblMailTag);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);

		JLabel lblMail = new JLabel(mail);
		horizontalBox_2.add(lblMail);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_5);

		card.show(panelCard, "client");

		state = CLIENT;
	}

	public void tancar(boolean exit) {
		if (exit)
			System.exit(0);
		else
			this.setVisible(false);
	}

	public void habilitarOk(boolean habilitat) {
		btnOk.setEnabled(habilitat);
	}

	class TextFieldChangeListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			@SuppressWarnings("unused")
			JTextField textField = (JTextField) arg0.getSource();
			if (textFieldPoblacio.getText().length() > 0
					&& textFieldNumOcupants.getText().length() > 0
					&& textFieldDataFiAny.getText().length() > 0
					&& textFieldDataFiMes.getText().length() > 0
					&& textFieldDataFiDia.getText().length() > 0
					&& textFieldDataIniciMes.getText().length() > 0
					&& textFieldDataIniciDia.getText().length() > 0
					&& textFieldDataIniciAny.getText().length() > 0) {
				habilitarOk(true);
			} else
				habilitarOk(false);
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
		}
	}

	class TextFieldDateChangeListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			@SuppressWarnings("unused")
			JTextField textField = (JTextField) arg0.getSource();
			if (textFieldPoblacio.getText().length() > 0
					&& textFieldNumOcupants.getText().length() > 0
					&& textFieldDataFiAny.getText().length() > 0
					&& textFieldDataFiMes.getText().length() > 0
					&& textFieldDataFiDia.getText().length() > 0
					&& textFieldDataIniciMes.getText().length() > 0
					&& textFieldDataIniciDia.getText().length() > 0
					&& textFieldDataIniciAny.getText().length() > 0) {

				String diaFi = textFieldDataFiDia.getText();
				String mesFi = textFieldDataFiMes.getText();
				String anyFi = textFieldDataFiAny.getText();

				String diaInici = textFieldDataIniciDia.getText();
				String mesInici = textFieldDataIniciMes.getText();
				String anyInici = textFieldDataIniciAny.getText();

				if (isFechaValida(diaFi + "/" + mesFi + "/" + anyFi)
						&& isFechaValida(diaInici + "/" + mesInici + "/"
								+ anyInici))
					habilitarOk(true);
			} else
				habilitarOk(false);
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		private boolean isFechaValida(String fechax) {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat(
						"dd/MM/yyyy", Locale.getDefault());
				formatoFecha.setLenient(false);
				formatoFecha.parse(fechax);
			} catch (ParseException e) {
				return false;
			}
			return true;
		}
	}
}
