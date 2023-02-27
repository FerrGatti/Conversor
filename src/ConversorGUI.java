import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ConversorGUI extends JFrame implements ActionListener, MonedaAbstract {

   // Dolar(Valores en interfaz moneda abstracta)
   @Override
   public Double PesoDolar(Double monto) {
      return dolarCompra;
   }

   // Valor Dolar a Peso + impuesto pais
   @Override
   public Double DolarPeso(Double monto) {
      return dolarCompra + (dolarCompra * 0.65);
   }

   @Override
   // Valor Euro a Peso
   public Double PesoEuro(Double monto) {
      return euroCompra;
   }

   @Override
   // Valor de Euro a Dolar
   public Double EuroDolar(Double monto) {
      return euroDolar;
   }

   @Override
   // Valor de Dolar a Euro
   public Double DolarEuro(Double monto) {
      return dolarEuro;
   }

   // -----------------------------------
   // Creando objetos de nuestra ventana

   private JLabel label1, label2, label3; // Los label indicaran en texto a que refiere cada combo.

   private JTextField texto1, texto2; // Texto1 es el imput donde vamos a colocar el valor a convertir y texto2 es el
                                      // output donde saldra la moneda ya convertida.

   private JComboBox combo1, combo2; // Combo1 son los valores de la primer opcion de moneda, Combo 2 son los valores
                                     // de las monedas a las cuales vamos a convertir.
   private JButton boton;

   // Asignando Valores a los objetos de nuestra ventana y colocando los tamanios

   public ConversorGUI() {
      setLayout(new GridLayout(4, 2));
      label1 = new JLabel("Cantidad:");
      add(label1);
      texto1 = new JTextField(10);
      add(texto1);
      label2 = new JLabel("Moneda de origen:");
      add(label2);
      combo1 = new JComboBox();
      combo1.addItem("USD");
      combo1.addItem("EUR");
      combo1.addItem("ARG");
      add(combo1);
      label3 = new JLabel("Moneda de destino:");
      add(label3);
      combo2 = new JComboBox();
      combo2.addItem("USD");
      combo2.addItem("EUR");
      combo2.addItem("ARG");
      add(combo2);
      boton = new JButton("Convertir");
      boton.addActionListener(this);
      add(boton);
      texto2 = new JTextField(10);
      texto2.setEditable(false);
      add(texto2);
      setTitle("Conversor de Divisas");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 150);
      setVisible(true);
   }

   // Seteando los parametros y cuentas que va a realizar nuestro programa para
   // realizar las conversiones.

   public void actionPerformed(ActionEvent e) {
      double cantidad = Double.parseDouble(texto1.getText());
      String origen = (String) combo1.getSelectedItem();
      String destino = (String) combo2.getSelectedItem();
      double tasa = obtenerTasa(origen, destino);
      double resultado = cantidad * tasa;

      // Creando condiciones para que, dependiendo de las monedas elegidas, la cuenta
      // que se realice sea una multiplicacion o difision segun corresponda.

      if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD"
            || combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "EUR") {
         resultado = cantidad / tasa;
      }
      // Si convertimos de Pesos a dolares le agregamos el impuesto pais
      if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD") {
         texto2.setText(String.format("%.2f con impuesto pais", resultado));
      } else {
         texto2.setText(String.format("%.2f", resultado));
      }
   }

   // Dando parametros al metodo obtenerTasa y que, dependiendo la moneda de origen
   // y destino asigne un valor a la variable. Caso que, si convertimos Dolares a
   // Pesos obtendremos el valor del dolar.

   private double obtenerTasa(String origen, String destino) {
      if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "ARG") {
         return PesoDolar(Double.parseDouble(texto1.getText())); // <-- Dolar a peso
      } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "USD") {
         return DolarPeso(Double.parseDouble(texto1.getText())); // <-- Peso a dolar
      } else if (combo1.getSelectedItem() == "ARG" && combo2.getSelectedItem() == "EUR") {
         return PesoEuro(Double.parseDouble(texto1.getText())); // <-- Peso a Euro
      } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "ARG") {
         return PesoEuro(Double.parseDouble(texto1.getText())); // <-- Euro a Peso
      } else if (combo1.getSelectedItem() == "EUR" && combo2.getSelectedItem() == "USD") {
         return EuroDolar(Double.parseDouble(texto1.getText())); // <-- Euro a Dolar
      } else if (combo1.getSelectedItem() == "USD" && combo2.getSelectedItem() == "EUR") {
         return DolarEuro(Double.parseDouble(texto1.getText())); // <-- Dolar a Euro
      }
      return 1;
   }

}