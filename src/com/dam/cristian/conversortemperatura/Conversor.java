

package com.dam.cristian.conversortemperatura;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class Conversor extends JFrame {

    private JPanel centerPanel;
    private JLabel indicatorTemperature;
    private JTextField temperatureText;
    private JLabel indicatorConversion;
    private JTextArea conversionResult;
    private JButton celsiusButton;
    private JButton fahrenheitButton;

    public Conversor() {
        setTitle("Conversor de tempetaturas");
        setVisible(true);
        setBounds(500, 500, 500, 500);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        Border bordeLineaRoja = BorderFactory.createLineBorder(Color.RED, 160);
        centerPanel.setBorder(bordeLineaRoja);
        add(centerPanel);
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.insets = new Insets(5, 5, 5, 5);
        gbl.gridx = 0;
        gbl.gridy = 0;
        indicatorTemperature = new JLabel("temperatura");
        centerPanel.add(indicatorTemperature, gbl);
        gbl.gridx = 0;
        gbl.gridy = 1;
        temperatureText = new JTextField(8);
        centerPanel.add(temperatureText, gbl);
        gbl.gridx = 0;
        gbl.gridy = 2;
        indicatorConversion = new JLabel("resultado");
        centerPanel.add(indicatorConversion, gbl);
        gbl.gridx = 0;
        gbl.gridy = 3;
        conversionResult = new JTextArea();
        conversionResult.setEditable(false);
        centerPanel.add(new JScrollPane(conversionResult), gbl);
        gbl.gridx = 0;
        gbl.gridy = 4;
        celsiusButton = new JButton("Celsius");
        centerPanel.add(celsiusButton, gbl);
        gbl.gridx = 1;
        gbl.gridy = 4;
        fahrenheitButton = new JButton("fahrenheit");
        centerPanel.add(fahrenheitButton, gbl);
        celsiusButton.addActionListener(this::convertTemperatures);
        fahrenheitButton.addActionListener(this::convertTemperatures);


    }

    public void convertTemperatures(ActionEvent e) {

        try {
            if(checkFullFields()) {
                float temperature = Float.parseFloat(temperatureText.getText());
                if(e.getSource() == fahrenheitButton) {

                    float result = temperature*(9f/5f)+32;
                    conversionResult.setText("Tus " + temperature + " grados celsius, son " + result + " grados fahrenheit");
                    temperatureText.setText("");
                }
                else if(e.getSource() == celsiusButton) {
                    temperature = Float.parseFloat(temperatureText.getText());
                    float result = (temperature - 32)*5f/9f;
                    conversionResult.setText("Tus " + temperature + " grados fahrenheit, son " + result + " grados celsius");
                    temperatureText.setText("");
                }
            }
            else {
                conversionResult.setText("Rellene los campos, por favor");
            }


        }catch(NumberFormatException ex) {

            conversionResult.setText("Numero incorrecto, vuelve a intentarlo");
            temperatureText.setText("");
        }

    }

    public boolean checkFullFields() {

        return !temperatureText.getText().isEmpty();
    }

}
