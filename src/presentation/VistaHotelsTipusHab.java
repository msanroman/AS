package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import tupleTypes.HabitacionsTuple;
import tupleTypes.HotelAmbHabitacions;

public class VistaHotelsTipusHab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelAmbHabitacions hotelSeleccionat;
	private String habitacioSeleccionada;
	private JLabel lblNomHotel;
	private JLabel lblEstrelles;
	private JTextArea lblDescripcioHotel;
	private JLabel lblNota;
	private ButtonGroup buttonGroup;
	
	Box verticalBox_1;
	
	/**
	 * Create the panel.
	 */
	public VistaHotelsTipusHab(
			final ArrayList<HotelAmbHabitacions> informacioHotels) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		hotelSeleccionat = informacioHotels.get(0);
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Hotels");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_5);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		horizontalBox.add(comboBox);
		
		//comboBox.setMaximumSize(new Dimension(300, 30));
		//comboBox.setPreferredSize(new Dimension(300, 30));
		
		for (HotelAmbHabitacions hotel : informacioHotels) {
			comboBox.addItem(hotel.infoHotel.nom);
		}
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				JComboBox<String> aux = (JComboBox<String>) arg0.getSource();
				hotelSeleccionat = informacioHotels.get(aux.getSelectedIndex());
				actualitzaInformacio(hotelSeleccionat.habitacions);
			}
		});
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		add(verticalStrut_2);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(verticalBox);
				
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		lblNomHotel = new JLabel(hotelSeleccionat.infoHotel.nom);
		horizontalBox_1.add(lblNomHotel);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		lblEstrelles = new JLabel(hotelSeleccionat.infoHotel.categoria);
		horizontalBox_1.add(lblEstrelles);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		lblDescripcioHotel = new JTextArea(hotelSeleccionat.infoHotel.descripcio);
		horizontalBox_4.add(lblDescripcioHotel);
		lblDescripcioHotel.setLineWrap(true);
		lblDescripcioHotel.setBackground(this.getBackground());
		//lblDescripcioHotel.setMaximumSize(new Dimension(200, 100));
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_4);
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);
		
		lblNota = new JLabel(String.valueOf(hotelSeleccionat.infoHotel.avaluacio));
		horizontalBox_2.add(lblNota);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		JLabel lblNewLabel_5 = new JLabel("Habitacions disponibles");
		horizontalBox_3.add(lblNewLabel_5);
		lblNewLabel_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_3);
		
		verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);
 
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		actualitzaInformacio(hotelSeleccionat.habitacions);
		
		this.setVisible(true);
	}
	
	public String getHabitacioSeleccionada() {
		return this.habitacioSeleccionada;
	}

	public String getHotelSeleccionat() {
		return this.hotelSeleccionat.infoHotel.nom;
	}
	
	private void actualitzaInformacio(ArrayList<HabitacionsTuple> habitacions) {
		lblNomHotel.setText(hotelSeleccionat.infoHotel.nom);
		lblDescripcioHotel.setText(hotelSeleccionat.infoHotel.descripcio);
		lblEstrelles.setText(hotelSeleccionat.infoHotel.categoria + " estrelles");
		lblNota.setText(String.valueOf(hotelSeleccionat.infoHotel.avaluacio));
		
		verticalBox_1.removeAll();
		
		buttonGroup = new ButtonGroup();
		for (HabitacionsTuple habitacio : habitacions) {
			Box horizontal = Box.createHorizontalBox();
			JRadioButton radioButton = new JRadioButton(habitacio.tipusHabitacio); 
			buttonGroup.add(radioButton);
			horizontal.add(radioButton);
			
			radioButton.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					JRadioButton radioButton = (JRadioButton) arg0.getSource();
					if (radioButton.isSelected()) {
						habitacioSeleccionada = radioButton.getText();
					}					
				}
			});
			
			horizontal.add(Box.createHorizontalGlue());
			horizontal.add(new Label(String.valueOf(habitacio.numeroDisponibles+" disponibles")));
			horizontal.add(Box.createHorizontalGlue());
			horizontal.add(new Label(String.valueOf(habitacio.preu)+" €"));
			verticalBox_1.add(horizontal);
		}	
	}
}
