package com.conversor;

import javax.swing.*;
import javax.swing.JRootPane;
import com.conversor.model.conversorMoneda;
import com.conversor.model.conversorTemperatura;
import com.conversor.model.conversorLongitud;

import java.awt.*;
import java.awt.event.*;

public class Conversor extends JFrame implements ActionListener {
    /*
     * Creamos los objetos de nuestra ventana
     */
    private JLabel label1, label2, label3;

    private JTextField texto1, texto2;

    private JComboBox combo1, combo2;

    private JButton boton;

    String[] options = { "Temperatura", "Divisas", "Longitud" };
    String opcion = (String) JOptionPane.showInputDialog(null, "Que desea convertir?", "Conversor",
            JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

    /*
     * Vamos a proceder a asignar valores a estos objetos
     */
    public Conversor() throws MonedaNegativaException { /*
                                                         * <- Lanzamos error en caso de que el usuario ingrese un
                                                         * valor incorrecto.
                                                         */
        setLayout(new GridLayout(4, 3));
        setLocationRelativeTo(null);
        // OPCION CONVERTIR TEMPERATURAS

        if (opcion.equalsIgnoreCase("Temperatura")) {
            label1 = new JLabel("Cantidad");
            texto1 = new JTextField(10);
            label2 = new JLabel("Temperatura de origen");
            combo1 = new JComboBox<>();
            combo1.addItem("Celcius");
            combo1.addItem("Farenheit");
            combo1.addItem("Kelvin");
            label3 = new JLabel("Temperatura destino");
            combo2 = new JComboBox<>();
            combo2.addItem("Farenheit");
            combo2.addItem("Celcius");
            combo2.addItem("Kelvin");
            setTitle("Conversor de temperatura");
        } else if (opcion.equalsIgnoreCase("Divisas")) { // <- CONVERTIR DIVISAS
            label1 = new JLabel("Cantidad:");
            texto1 = new JTextField(10);
            label2 = new JLabel("Moneda de origen:");
            combo1 = new JComboBox();
            combo1.addItem("USD");
            combo1.addItem("EUR");
            combo1.addItem("ARG");
            combo1.addItem("LIBRA");
            combo1.addItem("YEN");
            combo1.addItem("WON");
            label3 = new JLabel("Moneda de destino:");
            combo2 = new JComboBox();
            combo2.addItem("ARG");
            combo2.addItem("EUR");
            combo2.addItem("USD");
            combo2.addItem("LIBRA");
            combo2.addItem("YEN");
            combo2.addItem("WON");
            setTitle("Conversor de Divisas");
        } else if (opcion.equalsIgnoreCase("Longitud")) {
            label1 = new JLabel("Cantidad");
            texto1 = new JTextField(10);
            label2 = new JLabel("Longitud inicial");
            combo1 = new JComboBox<>();
            combo1.addItem("Kilometro");
            combo1.addItem("Milla");
            label3 = new JLabel("Longitud destino");
            combo2 = new JComboBox<>();
            combo2.addItem("Milla");
            combo2.addItem("Kilometro");
            setTitle("Conversor de longitud");
        } else {
            throw new IllegalArgumentException("Opción inválida: " + opcion);
        }

        // Agregando objetos y sus valores a la ventana.

        add(label1);
        add(texto1);
        add(label2);
        add(combo1);
        add(label3);
        add(combo2);
        boton = new JButton("Convertir");
        boton.addActionListener(this); // Agregamos el action listener que creamos mas adelante al boton.
        add(boton);
        texto2 = new JTextField(10);
        texto2.setEditable(false);
        add(texto2);
        label1.setBackground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // <- Funcion que se ejecutara cuando hagamos click en el boton
        double resultado;
        double cantidad = Double.parseDouble(texto1.getText());

        // En caso de que el usuario al convertir divisas ingrese un valor menor a 0
        // arrojaremos un error.

        if (opcion.equalsIgnoreCase("Divisas") || opcion.equalsIgnoreCase("Longitud")) {
            if (cantidad < 0) {
                throw new MonedaNegativaException("Valor erroneo");
            }
        }
        String origen = (String) combo1.getSelectedItem();
        String destino = (String) combo2.getSelectedItem();
        double tasa = obtenerTasa(origen, destino);
        double formula = obtenerFormula(origen, destino);
        double formula2 = obtenerFormula2(origen, destino);

        // Variantes de formulas para resultado dependiendo de que decidamos convertir

        if (opcion.equalsIgnoreCase("Temperatura")) {
            resultado = formula;
        } else if (opcion.equalsIgnoreCase("Longitud")) { // <- Conversion de divisas
            resultado = formula2;
        } else {
            resultado = cantidad * tasa;
        }
        texto2.setText(String.format("%.2f", resultado));

        /*
         * Cambiando formula de resultado dependiendo de la divisa que seleccionemos.
         * Si cambiamos PESOS a USD o EU la formula pasara de multiplicar a dividir.
         */

        if (opcion.equalsIgnoreCase("Divisas")) {
            if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD"
                    || combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "EUR"
                    || combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "LIBRA"
                    || combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "LIBRA"
                    || combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "EUR"
                    || combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "USD"
                    || combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "YEN"
                    || combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "USD"
                    || combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "EUR"
                    || combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "LIBRA"
                    || combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "ARG"
                    || combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "YEN"
                    || combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "LIBRA"
                    || combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "LIBRA") {
                resultado = cantidad / tasa;
            }
            // Si convertimos de Pesos a dolares le agregamos el impuesto pais
            if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD") {
                texto2.setText(String.format("%.2f con impuesto pais", resultado));
            } else {
                texto2.setText(String.format("%.2f", resultado));
            }
        }
    }

    // Formulas para conversion de temperaturas

    private double obtenerFormula(String origen, String destino) {
        if (combo1.getSelectedItem() == "Celcius" && combo2.getSelectedItem() == "Farenheit") {
            return conversorTemperatura.celciusFarenheit(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Celcius" && combo2.getSelectedItem() == "Kelvin") {
            return conversorTemperatura.celciusKelvin(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Farenheit" && combo2.getSelectedItem() == "Celcius") {
            return conversorTemperatura.farenheitCelcius(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Farenheit" && combo2.getSelectedItem() == "Kelvin") {
            return conversorTemperatura.farenheitKelvin(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Kelvin" && combo2.getSelectedItem() == "Celcius") {
            return conversorTemperatura.kelvinCelcius(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Kelvin" && combo2.getSelectedItem() == "Farenheit") {
            return conversorTemperatura.kelvinFarenheit(Double.parseDouble(texto1.getText()));
        }
        return Double.parseDouble(texto1.getText());
    }
    // Formulas para conversion de longitud

    private double obtenerFormula2(String origen, String destino) {
        if (combo1.getSelectedItem() == "Kilometro" && combo2.getSelectedItem() == "Milla") {
            return conversorLongitud.kilometroMilla(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "Milla" && combo2.getSelectedItem() == "Kilometro") {
            return conversorLongitud.millaKilometro(Double.parseDouble(texto1.getText()));
        } else {
            return Double.parseDouble(texto1.getText());
        }
    }

    // Formulas para conversion de divisas

    private double obtenerTasa(String origen, String destino) {
        if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "ARG") {
            return conversorMoneda.PesoDolar(Double.parseDouble(texto1.getText())); // <-- PESOS
        } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD") {
            return conversorMoneda.DolarPeso(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "EUR") {
            return conversorMoneda.PesoEuro(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "YEN") {
            return conversorMoneda.PesoYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "WON") {
            return conversorMoneda.PesoWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "LIBRA") {
            return conversorMoneda.PesoLibra(Double.parseDouble(texto1.getText())); // <-- EUROS
        } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "ARG") {
            return conversorMoneda.PesoEuro(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "USD") {
            return conversorMoneda.EuroDolar(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "YEN") {
            return conversorMoneda.EuroYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "WON") {
            return conversorMoneda.EuroWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "LIBRA") {
            return conversorMoneda.EuroLibra(Double.parseDouble(texto1.getText())); // <-- DOLARES
        } else if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "EUR") {
            return conversorMoneda.DolarEuro(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "WON") {
            return conversorMoneda.DolarWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "YEN") {
            return conversorMoneda.DolarYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "LIBRA") {
            return conversorMoneda.DolarLibra(Double.parseDouble(texto1.getText())); // <-- LIBRAS
        } else if (combo1.getSelectedItem() == "LIBRA" && combo2.getSelectedItem() == "ARG") {
            return conversorMoneda.PesoLibra(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "LIBRA" && combo2.getSelectedItem() == "USD") {
            return conversorMoneda.DolarLibra(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "LIBRA" && combo2.getSelectedItem() == "EUR") {
            return conversorMoneda.EuroLibra(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "LIBRA" && combo2.getSelectedItem() == "YEN") {
            return conversorMoneda.LibraYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "LIBRA" && combo2.getSelectedItem() == "WON") {
            return conversorMoneda.LibraWon(Double.parseDouble(texto1.getText())); // <-- YENES
        } else if (combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "ARG") {
            return conversorMoneda.PesoYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "USD") {
            return conversorMoneda.DolarYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "EUR") {
            return conversorMoneda.EuroYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "LIBRA") {
            return conversorMoneda.LibraYen(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "YEN" && combo2.getSelectedItem() == "WON") {
            return conversorMoneda.YenWon(Double.parseDouble(texto1.getText())); // <-- WONES
        } else if (combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "ARG") {
            return conversorMoneda.PesoWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "USD") {
            return conversorMoneda.DolarWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "EUR") {
            return conversorMoneda.EuroWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "LIBRA") {
            return conversorMoneda.LibraWon(Double.parseDouble(texto1.getText()));
        } else if (combo1.getSelectedItem() == "WON" && combo2.getSelectedItem() == "YEN") {
            return conversorMoneda.YenWon(Double.parseDouble(texto1.getText()));
        }
        return 1;
    }
}
