import javax.swing.*;

public class ConversorMoneda extends Moneda {

    public static void main(String[] args) {
        Moneda moneda = new ConversorMoneda();

        moneda.setMoneda(JOptionPane.showInputDialog("Ingrese el tipo de moneda(USD o EU o ARG): ", moneda));
        String dolar = "USD";
        String euro = "EU";
        String pesos = "ARG";

        // OPCION DOLAR

        if (moneda.getMoneda().equalsIgnoreCase(dolar)) {
            moneda.ventaDolar();

            // OPCION EURO

        } else if (moneda.getMoneda().equalsIgnoreCase(euro)) {
            moneda.ventaEuro();

        }

        // OPCION PESOS
        /*
         * Al elegir pesos para operar, se aplican los impuetos del pais para
         * comercializacion de monedas extranjeras.
         */

        while (moneda.getMoneda().equalsIgnoreCase(pesos)) {
            String tipo_moneda = JOptionPane.showInputDialog("Que moneda desea comprar(USD o EU): ");

            if (tipo_moneda.equalsIgnoreCase(dolar)) {
                moneda.compraDolar();
                break;

            } else if (tipo_moneda.equalsIgnoreCase(euro)) {
                moneda.compraEuro();
                break;
            } else {
                System.out.println("Moneda invalida.");
                tipo_moneda = JOptionPane.showInputDialog("Que moneda desea comprar(USD o EU): ");
            }

        }
    }
}
